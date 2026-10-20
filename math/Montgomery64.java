package math;

import java.math.BigInteger;

/**
 * 法が奇数で 32 bit に収まらないとき用の Montgomery クラスです。<br/>
 * 剰余結果を得る他に、inner から直接モンゴメリ表現での処理も提供します。
 *
 * @param inner 内部処理用のインスタンスです。
 */
public record Montgomery64(InnerMontgomery64 inner){

	/**
	 * 内部処理用のクラスです。<br/>
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery64{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long r2, Nd, mod;

		/**
		 * long のビット長です。
		 */
		private static final int BIT_LENGTH;

		/**
		 * 上位、下位ビットを取得するためのシフト幅です。
		 */
		private static final int SHIFT_VALUE;

		static{
			BIT_LENGTH = 64;
			SHIFT_VALUE = 63;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 *
		 * @param modValue 法とする整数
		 */
		public InnerMontgomery64(final long modValue){
			this.mod = modValue;
			long r = 0;
			long t = 0;
			for(int i=0;i<BIT_LENGTH;i++){
				if((t&1L)==0){
					t += this.mod;
					r |= 1L<<i;
				}
				t >>>= 1;
			}
			this.Nd = r;
			this.r2 = BigInteger.ONE.shiftLeft(128).mod(BigInteger.valueOf(this.mod)).longValue();
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 *
		 * @param num 対象の値
		 *
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long tNd = num*this.Nd;
			final long down = tNd*this.mod;
			final long up = Math.unsignedMultiplyHigh(tNd,this.mod);
			final long ans = up+Math.max(Long.compareUnsigned(num,~down),0L);
			return Long.compareUnsigned(ans,this.mod)<0?ans:ans-this.mod;
		}

		/**
		 * 引数を 128 bit 整数として解釈してモンゴメリリダクションを適用します。
		 *
		 * @param top 上位 64 bit
		 * @param bottom 下位 64 bit
		 *
		 * @return MR(top * 2 ** 64 + bottom)
		 */
		private long montgomeryReduction(final long top,final long bottom){
			final long ans = top+this.montgomeryReduction(bottom);
			return Long.compareUnsigned(ans,this.mod)<0?ans:ans-this.mod;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 *
		 * @param num 変換対象
		 *
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final long num){
			return this.innerMultiply(num,this.r2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return value1 * value2 のモンゴメリ表現
		 */
		public long multiply(final long value1,final long value2){
			final long val1 = this.setMontgomeryExpression(value1);
			final long val2 = this.setMontgomeryExpression(value2);
			return this.innerMultiply(val1,val2);
		}

		/**
		 * 引数をモンゴメリ表現の値と解釈して積を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return MR(value1 * value2)
		 */
		public long innerMultiply(final long value1,final long value2){
			return this.montgomeryReduction(Math.unsignedMultiplyHigh(value1,value2),value1*value2);
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long pow(final long value,long exp){
			long multiplyValue = this.setMontgomeryExpression(value);
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.innerMultiply(ans,multiplyValue);
				}
				multiplyValue = this.innerMultiply(multiplyValue,multiplyValue);
				exp >>>= 1;
			}
			return ans;
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。<br/>
		 * value はモンゴメリ表現の値と解釈します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long innerPow(long value,long exp){
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.innerMultiply(ans,value);
				}
				value = this.innerMultiply(value,value);
				exp >>>= 1;
			}
			return ans;
		}

		@Override
		@Deprecated
		public String toString(){
			return "InnerMontgomery64[mod = "+this.mod+"]";
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 *
	 * @param mod 法とする値
	 */
	public Montgomery64(final long mod){
		this(new InnerMontgomery64(mod));
	}

	/**
	 * value1 * value2 mod n を返します。
	 *
	 * @param value1 乗算対象
	 * @param value2 乗算対象
	 *
	 * @return value1 * value2 mod n
	 */
	public long multiply(final long value1,final long value2){
		final long ans = this.inner.multiply(value1,value2);
		return this.inner.montgomeryReduction(ans);
	}

	/**
	 * value ** exp mod n を返します。
	 *
	 * @param value 累乗対象
	 * @param exp 指数
	 *
	 * @return value ** exp mod n
	 */
	public long pow(final long value,final long exp){
		final long ans = this.inner.pow(value,exp);
		return this.inner.montgomeryReduction(ans);
	}
}
