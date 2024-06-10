package math;

import java.math.BigInteger;

/**
 * 法が32bitに収まらないとき用のMontgomeryクラスです。
 * 剰余結果を得る他に、innerから直接モンゴメリ表現での処理も提供します。
 */
public final class Montgomery64{

	/**
	 * 内部処理用のインスタンスです。
	 */
	public final InnerMontgomery64 inner;

	/**
	 * 内部処理用のクラスです。
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery64{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long R2,Nd,N;

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 * 
		 * @param n 法とする整数
		 */
		public InnerMontgomery64(final long n){
			N = n;
			long r = 0;
			long t = 0;
			for(int i=0;i<64;i++){
				if((t&1L)==0){
					t += N;
					r |= 1L<<i;
				}
				t >>>= 1;
			}
			Nd = r;
			R2 = BigInteger.ONE.shiftLeft(128).mod(BigInteger.valueOf(N)).longValue();
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 * 
		 * @param num 対象の値
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long TNd = num*Nd;
			final long down = TNd*N;
			final long up = unsignedmultiplyHigh(TNd,N);
			final long ans = up+Math.max(Long.compareUnsigned(num,~down),0L);
			return Long.compareUnsigned(ans,N)<0?ans:ans-N;
		}

		/**
		 * 引数を128bit整数として解釈してモンゴメリリダクションを適用します。
		 * 
		 * @param u 上位64bit
		 * @param d 下位64bit
		 * @return MR(u*2^64 + d)
		 */
		private long montgomeryReduction(final long u,final long d){
			final long ans = u+montgomeryReduction(d);
			return Long.compareUnsigned(ans,N)<0?ans:ans-N;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 * 
		 * @param num 変換対象
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final long num){
			return innerMultiply(num,R2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*bのモンゴメリ表現
		 */
		public long multiply(final long a,final long b){
			final long A = setMontgomeryExpression(a);
			final long B = setMontgomeryExpression(b);
			return innerMultiply(A,B);
		}

		/**
		 * 引数をモンゴメリ表現の値と解釈して積を返します。
		 * 
		 * @param A 乗算対象
		 * @param B 乗算対象
		 * @return MR(A*B)
		 */
		public long innerMultiply(final long A,final long B){
			return montgomeryReduction(unsignedmultiplyHigh(A,B),A*B);
		}

		/**
		 * a^bのモンゴメリ表現を返します。
		 * 
		 * @param a 累乗対象
		 * @param b 指数
		 * @return a^bのモンゴメリ表現
		 */
		public long pow(final long a,long b){
			long A = setMontgomeryExpression(a);
			long ans = montgomeryReduction(R2);
			while(b>0){
				if((b&1L)>0){
					ans = innerMultiply(ans,A);
				}
				A = innerMultiply(A,A);
				b >>>= 1;
			}
			return ans;
		}

		/**
		 * 引数を符号なし64bit整数として解釈したときのa*bの上位64bitを返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*b>>>64
		 */
		private static long unsignedmultiplyHigh(final long a,final long b){
			return Math.multiplyHigh(a,b)+(b&(a>>63))+(a&(b>>63));
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 * 
	 * @param n 法とする値
	 */
	public Montgomery64(final long n){
		inner = new InnerMontgomery64(n);
	}

	/**
	 * a*b mod nを返します。
	 * 
	 * @param a 乗算対象
	 * @param b 乗算対象
	 * @return a*b mod n
	 */
	public long multiply(final long a,final long b){
		final long ans = inner.multiply(a,b);
		return inner.montgomeryReduction(ans);
	}

	/**
	 * a^b mod nを返します。
	 * 
	 * @param a 累乗対象
	 * @param b 指数
	 * @return a^b mod n
	 */
	public long pow(final long a,final long b){
		final long ans = inner.pow(a,b);
		return inner.montgomeryReduction(ans);
	}
}
