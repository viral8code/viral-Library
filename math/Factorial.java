/**
 * Factorialクラスです。
 * 前計算O(N)でコンストラクタに渡した値までの階乗とその逆元を求めます。
 */
package math;

public final class Factorial {

	//階乗とその逆元
	private final long[] fact, inFact;
	private final long mod;

	/**
	 * 1～Nの階乗とその逆元をmodで割ったあまりを事前に計算します。
	 *
	 * @param N 計算範囲
	 * @param mod 法
	 */
	public Factorial ( final int N, final long mod ) {
		fact = new long[N + 1];
		fact[0] = fact[1] = 1;
		for ( int i = 2; i <= N; ++i ) {
			fact[i] = fact[i - 1] * i % mod;
		}

		inFact = new long[N + 1];
		inFact[N] = MathFunction.modPow( fact[N], mod - 2, mod );
		for ( int i = N; i > 0; --i ) {
			inFact[i - 1] = inFact[i] * i % mod;
		}
		inFact[0] = 1;

		this.mod = mod;
	}

	/**
	 * num!をmodで割ったあまりを返します。
	 *
	 * @param num
	 *
	 * @return num!
	 */
	public long getFact ( final int num ) {
		return fact[num];
	}

	/**
	 * num!^-1をmodで割ったあまりを返します。
	 *
	 * @param num
	 *
	 * @return num!
	 */
	public long getInFact ( final int num ) {
		return inFact[num];
	}

	/**
	 * aCbをmodで割ったあまりを返します。
	 *
	 * @param a
	 * @param b
	 *
	 * @return aCb
	 */
	public long getCombi ( final int a, final int b ) {
		if ( a < b || a < 0 || b < 0 ) {
			return 0;
		}
		return ( fact[a] * inFact[a - b] % mod ) * inFact[b] % mod;
	}
}
