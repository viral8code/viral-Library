package math;

/**
 * 法が32bitに収まるとき用のMontgomeryクラスです。
 * 剰余結果を得る他に、innerから直接モンゴメリ表現での処理も提供します。
 */
public final class Montgomery32{

	/**
	 * 内部処理用のインスタンスです。
	 */
	public final InnerMontgomery32 inner;

	/**
	 * 内部処理用のクラスです。
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery32{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long R2,Nd,N;

		/**
		 * ビットマスク用の変数です。
		 */
		private static final long MASK;
		static{
			MASK = 0xffffffffL;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 * 
		 * @param n 法とする整数
		 */
		private InnerMontgomery32(int n){
			N = n;
			long r = 0;
			long t = 0;
			long num = 1L<<32;
			long i = 1;
			while(num>1){
				if((t&1L)==0){
					t += N;
					r |= i;
				}
				t >>>= 1;
				num >>>= 1;
				i <<= 1;
			}
			Nd = r;
			R2 = Long.remainderUnsigned(-1L-N+1,N);
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 * 
		 * @param num 対象の値
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long TNd = num*Nd&MASK;
			final long mult = TNd*N;
			final long down = (mult&MASK)+(num&MASK);
			final long up = (mult>>>32)+(num>>>32);
			long ans = up+(down>>>32);
			if(N<=ans){
				ans -= N;
			}
			return ans;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 * 
		 * @param num 変換対象
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(int num){
			return montgomeryReduction(num*R2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*bのモンゴメリ表現
		 */
		public long multiply(final int a,final int b){
			final long A = setMontgomeryExpression(a);
			final long B = setMontgomeryExpression(b);
			return montgomeryReduction(A*B);
		}

		/**
		 * 引数をモンゴメリ表現の値として積を返します。
		 * 
		 * @param A 乗算対象
		 * @param B 乗算対象
		 * @return MR(a*b)
		 */
		public long innerMultiply(final long A,final long B){
			return montgomeryReduction(A*B);
		}

		/**
		 * a^bのモンゴメリ表現を返します。
		 * 
		 * @param a 累乗対象
		 * @param b 指数
		 * @return a^bのモンゴメリ表現
		 */
		public long pow(final int a,long b){
			long A = setMontgomeryExpression(a);
			long ans = montgomeryReduction(R2);
			while(b>0){
				if((b&1L)>0){
					ans = montgomeryReduction(ans*A);
				}
				A = montgomeryReduction(A*A);
				b >>>= 1;
			}
			return ans;
		}
	}
	
	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 * 
	 * @param n 法とする値
	 */
	public Montgomery32(int n){
		inner = new InnerMontgomery32(n);
	}

	/**
	 * a*b mod nを返します。
	 * 
	 * @param a 乗算対象
	 * @param b 乗算対象
	 * @return a*b mod n
	 */
	public int multiply(final int a,final int b){
		final long ans = inner.multiply(a,b);
		return (int)inner.montgomeryReduction(ans);
	}

	/**
	 * a^b mod nを返します。
	 * 
	 * @param a 累乗対象
	 * @param b 指数
	 * @return a^b mod n
	 */
	public int pow(final int a,final long b){
		final long ans = inner.pow(a,b);
		return (int)inner.montgomeryReduction(ans);
	}
}
