package math;

/**
 * 階乗計算用の Factorial クラスです。
 * 引数 N に対して前計算を O(N) で行なうことで N 以下の階乗とその逆元、N 以下の逆元を O(1) で求めます。
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
	 * この Factorial での法となる値
	 */
	private final long mod;

	/**
	 * 1～N の階乗とその逆元を mod で割ったあまりを事前に計算します。
	 *
	 * @param size 計算範囲
	 * @param modValue 法
	 *
	 * @throws IllegalArgumentException size が負の場合
	 */
	public Factorial(final int size,final long modValue) throws IllegalArgumentException{
		if(size<0){
			throw new IllegalArgumentException("size must be non-negative");
		}
		this.fact = new long[size+1];
		this.fact[0] = 1;
		if(size>0){
			this.fact[1] = 1;
		}
		for(int i=2;i<=size;++i){
			this.fact[i] = this.fact[i-1]*i%modValue;
		}
		this.inFact = new long[size+1];
		this.inFact[size] = MathFunction.modPow(this.fact[size],modValue-2,modValue);
		for(int i=size;i>0;--i){
			this.inFact[i-1] = this.inFact[i]*i%modValue;
		}
		this.inFact[0] = 1;
		this.mod = modValue;
	}

	/**
	 * num! を mod で割ったあまりを返します。
	 *
	 * @param num num! mod m となる num
	 *
	 * @return num! mod m
	 */
	public long getFact(final int num){
		return this.fact[num];
	}

	/**
	 * num! ** -1 を mod で割ったあまりを返します。
	 *
	 * @param num num! ** -1 mod m となる num
	 *
	 * @return num! ** -1 mod m
	 */
	public long getInFact(final int num){
		return this.inFact[num];
	}

	/**
	 * mod を法とした時の num ** -1 を返します。
	 *
	 * @param num num ** -1 mod m となる num
	 *
	 * @return num ** -1 mod m
	 */
	public long getInverse(final int num){
		return this.fact[num-1]*this.inFact[num]%this.mod;
	}

	/**
	 * aCb を mod で割ったあまりを返します。
	 *
	 * @param total aCb mod m となる a
	 * @param choose aCb mod m となる b
	 *
	 * @return aCb mod m
	 */
	public long getCombination(final int total,final int choose){
		if(total<choose||total<0||choose<0){
			return 0;
		}
		return (this.fact[total]*this.inFact[total-choose]%this.mod)*this.inFact[choose]%this.mod;
	}

	/**
	 * この Factorial インスタンスを表す文字列を返します。
	 *
	 * @return この Factorial インスタンスを表す文字列
	 */
	@Override
	public String toString(){
		return "Factorial (size = "+this.fact.length+", mod = "+this.mod+")";
	}
}
