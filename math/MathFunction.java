package math;

import java.awt.Point;
import java.util.BitSet;

/**
 * 数学に関するメソッドを提供するクラスです。<br/>
 * 最大公約数や累乗、2 線分の交差判定などを提供します。
 */
public final class MathFunction{

	/**
	 * int 型の素数判定用の値
	 */
	private static final int[] numberForIntPrime;

	/**
	 * long 型の素数判定用の値
	 */
	private static final long[] numberForLongPrime;

	/**
	 * 空の int 型配列
	 */
	public static final int[] EMPTY_INTS = new int[0];

	static{
		numberForIntPrime = new int[]{2,7,61};
		numberForLongPrime = new long[]{2,7,61,325,9375,28178,450775,9780504,1795265022};
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private MathFunction() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * a と b の最大公約数を求めます。戻り値は 0 以上であることが保証されます。
	 *
	 * @param value1 公約数を求める整数
	 * @param value2 公約数を求める整数
	 *
	 * @return a と b の最大公約数
	 */
	public static long gcd(long value1,long value2){
		if(value2==0){
			return Math.abs(value1);
		}
		long temp = value1%value2;
		while(temp!=0){
			value1 = value2;
			value2 = temp;
			temp = value1%value2;
		}
		return Math.abs(value2);
	}

	/**
	 * a と b の最小公倍数を求めます。<br/>
	 * オーバーフロー検知は出来ません。
	 *
	 * @param value1 公倍数を求める整数
	 * @param value2 公倍数を求める整数
	 *
	 * @return a と b の最小公倍数
	 */
	public static long lcm(final long value1,final long value2){
		return value1/gcd(value1,value2)*value2;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	public static boolean isPrime(long value){
		value = Math.abs(value);
		if(value==2L){
			return true;
		}
		if(value==1L||(value&1L)==0L){
			return false;
		}
		if(value<=Integer.MAX_VALUE){
			return isPrimeForInt((int)value);
		}
		return isPrimeForBigInteger(value);
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	private static boolean isPrimeForInt(final int value){
		long bit = value-1L;
		while((bit&1)==0){
			bit >>= 1;
		}
		final Montgomery32 mg = new Montgomery32(value);
		final Montgomery32.InnerMontgomery32 inner = mg.inner();
		final long montgomeryOne = inner.setMontgomeryExpression(1);
		final long decrementValue = inner.setMontgomeryExpression(value-1);
		for(final int a:numberForIntPrime){
			if(a>=value){
				return true;
			}
			long t = bit;
			long y = inner.pow(a,t);
			while(t<value-1L&&y!=montgomeryOne&&y!=decrementValue){
				y = inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=decrementValue&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	private static boolean isPrimeForBigInteger(final long value){
		long bit = value-1L;
		while((bit&1L)==0L){
			bit >>= 1;
		}
		final Montgomery64 mg = new Montgomery64(value);
		final Montgomery64.InnerMontgomery64 inner = mg.inner();
		final long montgomeryOne = inner.setMontgomeryExpression(1);
		final long decrementValue = inner.setMontgomeryExpression(value-1);
		for(final long a:numberForLongPrime){
			if(a>=value){
				return true;
			}
			long t = bit;
			long y = inner.pow(a,t);
			while(t<value-1L&&y!=montgomeryOne&&y!=decrementValue){
				y = inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=decrementValue&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * num 以下の素数を列挙します。
	 *
	 * @param num 素数を探す上限値
	 *
	 * @return num 以下の素数の int 型配列
	 */
	public static int[] primes(final int num){
		if(num<2){
			return EMPTY_INTS;
		}
		final BitSet numbers = new BitSet(num+1);
		numbers.set(2,num+1);
		final int limit = (int)Math.sqrt(num);
		for(int bit=numbers.nextSetBit(0);rangeCheckClose(bit,2,limit);bit=numbers.nextSetBit(bit+1)){
			for(int j=bit*bit;j<=num;j += bit){
				numbers.clear(j);
			}
		}
		final int[] answer = new int[numbers.cardinality()];
		int bit = 0;
		for(int i=0;i<answer.length;++i){
			answer[i] = numbers.nextSetBit(bit+1);
			bit = answer[i];
		}
		return answer;
	}

	/**
	 * value ** b を計算します。
	 *
	 * @param value 被累乗数
	 * @param exp 指数
	 *
	 * @return value ** exp
	 */
	public static long pow(long value,long exp){
		long ans = 1;
		while(exp>0){
			if((exp&1)==1){
				ans *= value;
			}
			value *= value;
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * value ** b を mod で割ったあまりを計算します。
	 *
	 * @param value 被累乗数
	 * @param exp 指数
	 * @param mod 法とする整数
	 *
	 * @return value ** exp を mod で割ったあまり
	 */
	public static long modPow(long value,long exp,final long mod){
		if(mod==1){
			return 0;
		}
		if(exp<0){
			exp = Math.floorMod(exp,mod-1);
		}
		long ans = 1;
		value %= mod;
		while(exp>0){
			if((exp&1)==1){
				ans *= value;
			}
			ans %= mod;
			value *= value;
			value %= mod;
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * value! を計算します。
	 *
	 * @param value 階乗を求めるのに用いる値
	 *
	 * @return value!
	 */
	public static long fact(final int value){
		long ans = 1;
		for(int i=2;i<=value;++i){
			ans *= i;
		}
		return ans;
	}

	/**
	 * value! を mod で割ったあまりを計算します。
	 *
	 * @param value 階乗を求めるのに用いる値
	 * @param mod 法とする整数
	 *
	 * @return value! を mod で割ったあまり
	 */
	public static long modFact(final int value,final long mod){
		long ans = 1;
		for(int i=2;i<=value;++i){
			ans *= i;
			ans %= mod;
		}
		return ans;
	}

	/**
	 * nCr を計算します。
	 *
	 * @param total nCr の n
	 * @param choose nCr の r
	 *
	 * @return nCr
	 */
	public static long combination(final long total,long choose){
		if(choose<0||total<choose){
			return 0;
		}
		long ans = 1;
		choose = Math.min(total-choose,choose);
		for(int i=0;i<choose;++i){
			ans *= total-i;
			ans /= i+1;
		}
		return ans;
	}

	/**
	 * nCr を mod で割ったあまりを計算します。
	 *
	 * @param total nCr の n
	 * @param choose nCr の r
	 * @param mod 法とする整数
	 *
	 * @return nCr を mod で割ったあまり
	 */
	public static long modCombination(final long total,long choose,final long mod){
		if(choose<0||total<choose){
			return 0;
		}
		long ans = 1;
		choose = Math.min(total-choose,choose);
		for(int i=0;i<choose;++i){
			ans *= (total-i)%mod;
			ans %= mod;
			ans *= modPow(i+1,mod-2,mod);
			ans %= mod;
		}
		return ans;
	}

	/**
	 * 引数の前半 2 点、後半 2 点で構成される 2 線分が交差しているか返します。
	 *
	 * @param x1 点 1 の x 座標
	 * @param y1 点 1 の y 座標
	 * @param x2 点 2 の x 座標
	 * @param y2 点 2 の y 座標
	 * @param x3 点 3 の x 座標
	 * @param y3 点 3 の y 座標
	 * @param x4 点 4 の x 座標
	 * @param y4 点 4 の y 座標
	 *
	 * @return 交差している (線分の端が他方の線分上に存在する場合も含む) 場合は 1、同一線分・直線上なら 0、それ以外は -1
	 */
	public static int isCrossed(final int x1,final int y1,final int x2,final int y2,final int x3,final int y3,final int x4,final int y4){
		final long s1 = (x1-x2)*(long)(y3-y1)-(y1-y2)*(long)(x3-x1);
		final long t1 = (x1-x2)*(long)(y4-y1)-(y1-y2)*(long)(x4-x1);
		final long s2 = (x3-x4)*(long)(y1-y3)-(y3-y4)*(long)(x1-x3);
		final long t2 = (x3-x4)*(long)(y2-y3)-(y3-y4)*(long)(x2-x3);
		final long temp1 = Long.signum(s1)*Long.signum(t1);
		final long temp2 = Long.signum(s2)*Long.signum(t2);
		if(temp1>0||temp2>0){
			return -1;
		}
		if(temp1==0&&temp2==0){
			return 0;
		}
		return 1;
	}

	/**
	 * 引数の前半 2 点、後半 2 点で構成される 2 線分が交差しているか返します。
	 *
	 * @param p1 点 1
	 * @param p2 点 2
	 * @param p3 点 3
	 * @param p4 点 4
	 *
	 * @return 交差している (線分の端が他方の線分上に存在する場合も含む) 場合は 1、同一線分・直線上なら 0、それ以外は -1
	 */
	public static int isCrossed(final Point p1,final Point p2,final Point p3,final Point p4){
		return isCrossed(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y,p4.x,p4.y);
	}

	/**
	 * 指定された頂点を順に結んで出来上がる多角形が凸多角形か判定します。
	 *
	 * @param points 多角形を構成する点
	 *
	 * @return 頂点数が 3 つ以上かつ多角形が凸多角形なら true、それ以外は false
	 */
	public static boolean isConvex(final Point... points){
		final int n = points.length;
		if(n<3){
			return false;
		}
		if(n==3){
			return true;
		}
		boolean conv = true;
		for(int i=0;i<n;++i){
			final int result = isCrossed(points[i],points[(i+2)%n],points[(i+1)%n],points[(i+1+n/2)%n]);
			conv &= result>=0;
		}
		return conv;
	}

	/**
	 * num を mod で割ったあまりを返します。<br/>
	 * 戻り値は 0 以上 mod 未満であることが保証されます。
	 *
	 * @param num 被除算数
	 * @param mod 法とする値
	 *
	 * @return num を mod で割ったあまり
	 */
	public static long remainder(long num,final long mod){
		num %= mod;
		if(num<0){
			num += mod;
		}
		return num;
	}

	/**
	 * num が何桁かを返します。<br/>
	 * 0 は 1 桁として捉えます。<br/>
	 * 負の値の '-' は無視されます (正の整数として解釈されます)。
	 *
	 * @param num 調べる整数
	 *
	 * @return num の桁数
	 */
	public static int digit(final long num){
		final int length = String.valueOf(Math.abs(num)).length();
		if(num<0){
			return length-1;
		}
		else{
			return length;
		}
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static int max(final int... numbers){
		int ans = Integer.MIN_VALUE;
		for(final int num:numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static long max(final long... numbers){
		long ans = Long.MIN_VALUE;
		for(final long num:numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static double max(final double... numbers){
		double ans = Double.NEGATIVE_INFINITY;
		for(final double num:numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最大の要素
	 */
	public static <E extends Comparable<E>> E max(final E[] numbers){
		E ans = numbers[0];
		for(final E value:numbers){
			if(ans.compareTo(value)<0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static int min(final int... numbers){
		int ans = Integer.MAX_VALUE;
		for(final int num:numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static long min(final long... numbers){
		long ans = Long.MAX_VALUE;
		for(final long num:numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static double min(final double... numbers){
		double ans = Double.MAX_VALUE;
		for(final double num:numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最小の要素
	 */
	public static <E extends Comparable<E>> E min(final E[] numbers){
		E ans = numbers[0];
		for(final E value:numbers){
			if(ans.compareTo(value)>0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final int... numbers){
		long ans = 0;
		for(final int num:numbers){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final long... numbers){
		long ans = 0;
		for(final long num:numbers){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を指定された値で割ったあまりを返します。
	 *
	 * @param mod 法とする値
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final int... numbers){
		long ans = 0;
		for(final int num:numbers){
			ans += num;
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数の総和を指定された値で割ったあまりを返します。
	 *
	 * @param mod 法とする値
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final long... numbers){
		long ans = 0;
		for(final long num:numbers){
			ans += num;
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final int[] numbers,final int from,final int to){
		long ans = 0;
		for(int i=from;i<to;++i){
			ans += numbers[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final long[] numbers,final int from,final int to){
		long ans = 0;
		for(int i=from;i<to;++i){
			ans += numbers[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final int[] numbers,final int from,final int to,final long mod){
		long ans = 0;
		for(int i=from;i<to;++i){
			ans += numbers[i]%mod;
			if(ans>=mod){
				ans -= mod;
			}
			else if(ans<0){
				ans += mod;
			}
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long[] numbers,final int from,final int to,final long mod){
		long ans = 0;
		for(int i=from;i<to;++i){
			ans += numbers[i]%mod;
			if(ans>=mod){
				ans -= mod;
			}
			else if(ans<0){
				ans += mod;
			}
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final int num,final int left,final int right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final long num,final long left,final long right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final double num,final double left,final double right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 * @param <E> 比較する型
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheck(final E num,final E left,final E right){
		return 0<=num.compareTo(left)&&num.compareTo(right)<0;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final int num,final int left,final int right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final long num,final long left,final long right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final double num,final double left,final double right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 * @param <E> 比較する型
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckOpen(final E num,final E left,final E right){
		return 0<num.compareTo(left)&&num.compareTo(right)<0;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final int num,final int left,final int right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final long num,final long left,final long right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final double num,final double left,final double right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 * @param <E> 比較する型
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckClose(final E num,final E left,final E right){
		return 0<=num.compareTo(left)&&num.compareTo(right)<=0;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final int num,final int left,final int right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final long num,final long left,final long right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final double num,final double left,final double right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 * @param <E> 比較する型
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckSubClose(final E num,final E left,final E right){
		return 0<num.compareTo(left)&&num.compareTo(right)<=0;
	}

	/**
	 * 引数の中での mex を求めます。
	 *
	 * @param numbers 引数
	 *
	 * @return 引数を集合として見たときの mex
	 */
	public static int mex(final int... numbers){
		final BitSet set = new BitSet(numbers.length);
		for(final int num:numbers){
			if(rangeCheck(num,0,numbers.length)){
				set.set(num);
			}
		}
		return set.nextClearBit(0);
	}
}
