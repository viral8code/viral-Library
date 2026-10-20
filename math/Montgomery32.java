package math;

/**
 * 法が奇数で 32 bit に収まるとき用の Montgomery クラスです。<br/>
 * 剰余結果を得る他に、inner から直接モンゴメリ表現での処理も提供します。
 *
 * @param inner 内部処理用のインスタンスです。
 */
public record Montgomery32(InnerMontgomery32 inner){

	/**
	 * 内部処理用のクラスです。<br/>
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery32{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long r2, Nd, mod;

		/**
		 * ビットマスク用の変数です。
		 */
		private static final long MASK;

		/**
		 * 上位ビット、下位ビットを扱うためのシフト幅です。
		 */
		private static final int SHIFT_VALUE;

		static{
			MASK = 0xffffffffL;
			SHIFT_VALUE = 32;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 *
		 * @param n 法とする整数
		 */
		private InnerMontgomery32(final int n){
			this.mod = n;
			long r = 0;
			long t = 0;
			long num = 1L<<SHIFT_VALUE;
			long bit = 1;
			while(num>1){
				if((t&1L)==0){
					t += this.mod;
					r |= bit;
				}
				t >>>= 1;
				num >>>= 1;
				bit <<= 1;
			}
			this.Nd = r;
			this.r2 = Long.remainderUnsigned(-1L-this.mod+1,this.mod);
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 *
		 * @param num 対象の値
		 *
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long tNd = num*this.Nd&MASK;
			final long multiplyValue = tNd*this.mod;
			final long down = (multiplyValue&MASK)+(num&MASK);
			final long up = (multiplyValue>>>SHIFT_VALUE)+(num>>>SHIFT_VALUE);
			long ans = up+(down>>>SHIFT_VALUE);
			if(this.mod<=ans){
				ans -= this.mod;
			}
			return ans;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 *
		 * @param num 変換対象
		 *
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final int num){
			return this.montgomeryReduction(num*this.r2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return value1 * value2 のモンゴメリ表現
		 */
		public long multiply(final int value1,final int value2){
			final long val1 = this.setMontgomeryExpression(value1);
			final long val2 = this.setMontgomeryExpression(value2);
			return this.montgomeryReduction(val1*val2);
		}

		/**
		 * 引数をモンゴメリ表現の値として積を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return MR(a * b)
		 */
		public long innerMultiply(final long value1,final long value2){
			return this.montgomeryReduction(value1*value2);
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long pow(final int value,long exp){
			long multiplyValue = this.setMontgomeryExpression(value);
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.montgomeryReduction(ans*multiplyValue);
				}
				multiplyValue = this.montgomeryReduction(multiplyValue*multiplyValue);
				exp >>>= 1;
			}
			return ans;
		}

		/**
		 * この InnerMontgomery32 を表す文字列を返します。
		 *
		 * @return この InnerMontgomery32 を表す文字列
		 */
		@Override
		@Deprecated
		public String toString(){
			return "InnerMontgomery32[mod = "+this.mod+"]";
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 *
	 * @param mod 法とする値
	 */
	public Montgomery32(final int mod){
		this(new InnerMontgomery32(mod));
	}

	/**
	 * value1 * value2 mod n を返します。
	 *
	 * @param value1 乗算対象
	 * @param value2 乗算対象
	 *
	 * @return value1 * value2 mod n
	 */
	public int multiply(final int value1,final int value2){
		final long ans = this.inner.multiply(value1,value2);
		return (int)this.inner.montgomeryReduction(ans);
	}

	/**
	 * value ** exp mod n を返します。
	 *
	 * @param value 累乗対象
	 * @param exp 指数
	 *
	 * @return value ** exp mod n
	 */
	public int pow(final int value,final long exp){
		final long ans = this.inner.pow(value,exp);
		return (int)this.inner.montgomeryReduction(ans);
	}
}
