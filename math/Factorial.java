package math;

/**
 * 階乗計算用の Facttorial クラスです。
 * 引数Nに対して前計算をO(N)で行なうことでN以下の階乗とその逆元、N以下の逆元をO(1)で求めます。
 */
public final class Factorial{

	/**
	 * 階乗を格納するための配列
	 */
	private final long[] fact;

	/**
	 * 階乗の逆元を格納するための配列
	 */
	private final long[] inFact;

	/**
	 * このFactorialでの法となる値
	 */
	private final long mod;

	/**
	 * 1～Nの階乗とその逆元をmodで割ったあまりを事前に計算します。
	 *
	 * @param N 計算範囲
	 * @param mod 法
	 */
	public Factorial(final int N,final long mod){
		fact = new long[N+1];
		fact[0] = fact[1] = 1;
		for(int i = 2;i<=N;++i){
			fact[i] = fact[i-1]*i%mod;
		}
		inFact = new long[N+1];
		inFact[N] = MathFunction.modPow(fact[N],mod-2,mod);
		for(int i = N;i>0;--i){
			inFact[i-1] = inFact[i]*i%mod;
		}
		inFact[0] = 1;
		this.mod = mod;
	}

	/**
	 * num!をmodで割ったあまりを返します。
	 *
	 * @param num num!となるnum
	 *
	 * @return num!
	 */
	public long getFact(final int num){
		return fact[num];
	}

	/**
	 * num!^-1をmodで割ったあまりを返します。
	 *
	 * @param num num!^-1となるnum
	 *
	 * @return num!
	 */
	public long getInFact(final int num){
		return inFact[num];
	}

	/**
	 * modを法とした時のnum^-1を返します。
	 *
	 * @param num num^-1 mod mとなるnum
	 *
	 * @return num!
	 */
	public long getInverse(final int num){
		return fact[num-1]*inFact[num]%mod;
	}

	/**
	 * aCbをmodで割ったあまりを返します。
	 *
	 * @param a aCbとなるa
	 * @param b aCbとなるb
	 *
	 * @return aCb
	 */
	public long getCombi(final int a,final int b){
		if(a<b||a<0||b<0){
			return 0;
		}
		return (fact[a]*inFact[a-b]%mod)*inFact[b]%mod;
	}
}
