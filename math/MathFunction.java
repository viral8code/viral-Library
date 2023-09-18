/**
 * MathFunctionクラスです。
 * 数学関係のメソッドや値が指定された区間内にあるかなどを判定するメソッドを提供します。
 */
package math;

import java.awt.Point;
import java.math.BigInteger;
import java.util.BitSet;

public final class MathFunction {

	private static final long[] numberForPrime = {2, 7, 61, 325, 9375, 28178, 450775, 9780504, 1795265022};

	/**
	 * aとbの最大公約数を求めます。戻り値は0以上であることが保証されます。
	 *
	 * @param a 公約数を求める整数
	 * @param b 公約数を求める整数
	 *
	 * @return aとbの最大公約数
	 */
	public static long gcd ( long a, long b ) {
		a = Math.abs( a );
		b = Math.abs( b );
		if ( b == 0 ) {
			return a;
		}
		long temp;
		while ( ( temp = a % b ) != 0 ) {
			a = b;
			b = temp;
		}
		return b;
	}

	/**
	 * aとbの最小公倍数を求めます。
	 * オーバーフロー検知は出来ません。
	 *
	 * @param a 公倍数を求める整数
	 * @param b 公倍数を求める整数
	 *
	 * @return aとbの最小公倍数
	 */
	public static long lcm ( final long a, final long b ) {
		return a / gcd( a, b ) * b;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param n 検査対象
	 *
	 * @return numが素数であるならtrue、素数でないならfalse
	 */
	public static boolean isPrime ( long n ) {
		n = Math.abs( n );
		if ( n == 2 ) {
			return true;
		}
		if ( n == 1 || ( n & 1 ) == 0 ) {
			return false;
		}
		long d = n - 1;
		while ( ( d & 1 ) == 0 ) {
			d >>= 1;
		}
		for ( final long a: numberForPrime ) {
			if ( a >= n ) {
				return true;
			}
			long t = d;
			long y = bigModPow( a, t, n );
			while ( t < n - 1 && y != 1 && y != n - 1 ) {
				y = bigModPow( y, 2, n );
				t <<= 1;
			}
			if ( y != n - 1 && ( t & 1 ) == 0 ) {
				return false;
			}
		}
		return true;
	}

	/**
	 * a**b mod mを計算します。
	 * Bigintegerを用いるのでオーバーフローは起こりません。
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @return a**b mod m
	 */
	private static long bigModPow ( final long a, final long b, final long m ) {
		return BigInteger.valueOf( a ).modPow( BigInteger.valueOf( b ), BigInteger.valueOf( m ) ).longValue();
	}

	/**
	 * num以下の素数を列挙します。
	 *
	 * @param num 素数を探す上限値
	 *
	 * @return num以下の素数のint型配列
	 */
	public static int[] primes ( final int num ) {
		if ( num < 2 ) {
			return new int[0];
		}
		final BitSet numbers = new BitSet( num + 1 );
		numbers.set( 2, num + 1 );
		final int limit = ( int )Math.sqrt( num );
		for ( int i = 2; i <= limit; ++i ) {
			if ( numbers.get( i ) ) {
				for ( int j = i * i; j <= num; j += i ) {
					numbers.clear( j );
				}
			}
		}
		final int[] answer = new int[numbers.cardinality()];
		int i = 2, index = 0;
		do {
			i = numbers.nextSetBit( i );
			answer[index++] = i++;
		} while ( index != answer.length );
		return answer;
	}

	/**
	 * a**bを計算します。
	 *
	 * @param a 被累乗数
	 * @param b 指数
	 *
	 * @return a**b
	 */
	public static long pow ( long a, long b ) {
		long ans = 1;
		while ( b > 0 ) {
			if ( ( b & 1 ) == 1 ) {
				ans *= a;
			}
			a *= a;
			b >>= 1;
		}
		return ans;
	}

	/**
	 * a**bをmodで割ったあまりを計算します。
	 *
	 * @param a 被累乗数
	 * @param b 指数
	 * @param mod 法とする整数
	 *
	 * @return a**bをmodで割ったあまり
	 */
	public static long modPow ( long a, long b, final long mod ) {
		long ans = 1;
		a %= mod;
		while ( b > 0 ) {
			if ( ( b & 1 ) == 1 ) {
				ans *= a;
			}
			ans %= mod;
			a *= a;
			a %= mod;
			b >>= 1;
		}
		return ans;
	}

	/**
	 * nCrを計算します。
	 *
	 * @param n 二項係数を求めるのに用いる値
	 * @param r 二項係数を求めるのに用いる値
	 *
	 * @return nCr
	 */
	public static long combi ( final long n, long r ) {
		if ( r < 0 || n < r ) {
			return 0;
		}
		long ans = 1;
		r = Math.min( n - r, r );
		for ( int i = 0; i < r; ++i ) {
			ans *= n - i;
			ans /= i + 1;
		}
		return ans;
	}

	/**
	 * nCrをmodで割ったあまりを計算します。
	 *
	 * @param n 二項係数を求めるのに用いる値
	 * @param r 二項係数を求めるのに用いる値
	 * @param mod 法とする整数
	 *
	 * @return nCrをmodで割ったあまり
	 */
	public static long modCombi ( final long n, long r, final long mod ) {
		if ( r < 0 || n < r ) {
			return 0;
		}
		long ans = 1;
		r = Math.min( n - r, r );
		for ( int i = 0; i < r; ++i ) {
			ans *= n - i;
			ans %= mod;
			ans *= modPow( i + 1, mod - 2, mod );
			ans %= mod;
		}
		return ans;
	}

	/**
	 * 引数の前半二点、後半二点で構成される二線分が交差しているか返します。
	 *
	 * @param x1 点1のx座標
	 * @param y1 点1のy座標
	 * @param x2 点2のx座標
	 * @param y2 点2のy座標
	 * @param x3 点3のx座標
	 * @param y3 点3のy座標
	 * @param x4 点4のx座標
	 * @param y4 点4のy座標
	 *
	 * @return 交差している(線分の端が他方の線分上に存在する場合も含む)場合は1、同一線分直線上なら0、それ以外は-1
	 */
	public static int isCrossed ( final int x1, final int y1,
			final int x2, final int y2,
			final int x3, final int y3,
			final int x4, final int y4 ) {
		final long s1 = ( long )( x1 - x2 ) * ( y3 - y1 ) - ( long )( y1 - y2 ) * ( x3 - x1 );
		final long t1 = ( long )( x1 - x2 ) * ( y4 - y1 ) - ( long )( y1 - y2 ) * ( x4 - x1 );
		final long s2 = ( long )( x3 - x4 ) * ( y1 - y3 ) - ( long )( y3 - y4 ) * ( x1 - x3 );
		final long t2 = ( long )( x3 - x4 ) * ( y2 - y3 ) - ( long )( y3 - y4 ) * ( x2 - x3 );
		final long temp1 = s1 * t1;
		final long temp2 = s2 * t2;
		if ( temp1 > 0 || temp2 > 0 ) {
			return -1;
		}
		if ( temp1 == 0 && temp2 == 0 ) {
			return 0;
		}
		return 1;
	}

	/**
	 * 引数の前半二点、後半二点で構成される二線分が交差しているか返します。
	 *
	 * @param p1 点1
	 * @param p2 点2
	 * @param p3 点3
	 * @param p4 点4
	 *
	 * @return 交差している(線分の端が他方の線分上に存在する場合も含む)場合は1、同一線分直線上なら0、それ以外は-1
	 */
	public static int isCrossed ( final Point p1, final Point p2, final Point p3, final Point p4 ) {
		return isCrossed( p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y );
	}

	/**
	 * 指定された頂点を順に結んで出来上がる多角形が凸多角形か判定します。
	 *
	 * @param points 多角形を構成する点
	 *
	 * @return 多角形が凸多角形ならtrue
	 */
	public static boolean isConvex ( final Point... points ) {
		final int n = points.length;
		if ( n < 3 ) {
			return false;
		}
		if ( n == 3 ) {
			return true;
		}
		boolean conv = true;
		for ( int i = 0; i < n; ++i ) {
			int result = isCrossed( points[i], points[( i + 2 ) % n],
					points[( i + 1 ) % n], points[( i + 1 + n / 2 ) % n] );
			conv &= result >= 0;
		}
		return conv;
	}

	/**
	 * numをmodで割ったあまりを返します。
	 * 戻り値は0以上mod未満であることが保証されます。
	 *
	 * @param num 被除算数
	 * @param mod 法とする値
	 *
	 * @return numをmodで割ったあまり
	 */
	public static long remainder ( long num, final long mod ) {
		num %= mod;
		if ( num < 0 ) {
			num += mod;
		}
		return num;
	}

	/**
	 * numが何桁かを返します。
	 * 0は1桁として捉えます。
	 *
	 * @param num 調べる整数
	 *
	 * @return numの桁数
	 */
	public static int digit ( final long num ) {
		if ( num < 10L ) {
			return 1;
		}
		if ( num < 100L ) {
			return 2;
		}
		if ( num < 1000L ) {
			return 3;
		}
		if ( num < 10000L ) {
			return 4;
		}
		if ( num < 100000L ) {
			return 5;
		}
		if ( num < 1000000L ) {
			return 6;
		}
		if ( num < 10000000L ) {
			return 7;
		}
		if ( num < 100000000L ) {
			return 8;
		}
		if ( num < 1000000000L ) {
			return 9;
		}
		if ( num < 10000000000L ) {
			return 10;
		}
		if ( num < 100000000000L ) {
			return 11;
		}
		if ( num < 1000000000000L ) {
			return 12;
		}
		if ( num < 10000000000000L ) {
			return 13;
		}
		if ( num < 100000000000000L ) {
			return 14;
		}
		if ( num < 1000000000000000L ) {
			return 15;
		}
		if ( num < 10000000000000000L ) {
			return 16;
		}
		if ( num < 100000000000000000L ) {
			return 17;
		}
		if ( num < 1000000000000000000L ) {
			return 18;
		}
		return 19;
	}

	/**
	 * 渡された値の最大値を求めます。
	 * @param nums
	 * @return
	 */
	public static int max ( final int... nums ) {
		int ans = Integer.MIN_VALUE;
		for ( int num: nums ) {
			ans = Math.max( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最大値を求めます。
	 * @param nums
	 * @return
	 */
	public static long max ( final long... nums ) {
		long ans = Long.MIN_VALUE;
		for ( long num: nums ) {
			ans = Math.max( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最大値を求めます。
	 * @param nums
	 * @return
	 */
	public static double max ( final double... nums ) {
		double ans = -Double.MIN_VALUE;
		for ( double num: nums ) {
			ans = Math.max( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最大値を求めます。
	 * @param nums
	 * @return
	 */
	public static <E extends Comparable<E>> E max ( final E[] nums ) {
		E ans = nums[0];
		for ( E value: nums ) {
			if ( ans.compareTo( value ) > 0 ) {
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 渡された値の最小値を求めます。
	 * @param nums
	 * @return
	 */
	public static int min ( final int... nums ) {
		int ans = Integer.MAX_VALUE;
		for ( int num: nums ) {
			ans = Math.min( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最小値を求めます。
	 * @param nums
	 * @return
	 */
	public static long min ( final long... nums ) {
		long ans = Long.MAX_VALUE;
		for ( long num: nums ) {
			ans = Math.min( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最小値を求めます。
	 * @param nums
	 * @return
	 */
	public static double min ( final double... nums ) {
		double ans = Double.MAX_VALUE;
		for ( double num: nums ) {
			ans = Math.min( ans, num );
		}
		return ans;
	}

	/**
	 * 渡された値の最小値を求めます。
	 * @param nums
	 * @return
	 */
	public static <E extends Comparable<E>> E min ( final E[] nums ) {
		E ans = nums[0];
		for ( E value: nums ) {
			if ( ans.compareTo( value ) < 0 ) {
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 渡された値の総和を求めます。
	 * @param nums
	 * @return
	 */
	public static long sum ( final int... nums ) {
		long ans = 0;
		for ( int num: nums ) {
			ans += num;
		}
		return ans;
	}

	/**
	 * 渡された値の総和を求めます。
	 * @param nums
	 * @return
	 */
	public static long sum ( final long... nums ) {
		long ans = 0;
		for ( long num: nums ) {
			ans += num;
		}
		return ans;
	}

	/**
	 * 渡された値の総和をmodで割ったあまりを求めます。
	 * @param nums
	 * @param mod
	 * @return
	 */
	public static long modSum ( final long mod, final int... nums ) {
		long ans = 0;
		for ( int num: nums ) {
			ans += num;
			ans %= mod;
		}
		if ( ans < 0 ) {
			ans += mod;
		}
		return ans;
	}

	/**
	 * 渡された値の総和をmodで割ったあまりを求めます。
	 * @param nums
	 * @param mod
	 * @return
	 */
	public static long modSum ( final long mod, final long... nums ) {
		long ans = 0;
		for ( long num: nums ) {
			ans += num;
			ans %= mod;
		}
		if ( ans < 0 ) {
			ans += mod;
		}
		return ans;
	}

	/**
	 * 渡された配列の指定された区間の総和を求めます。
	 * @param nums
	 * @param from
	 * @param to
	 * @return
	 */
	public static long sum ( final int[] nums, int from, int to ) {
		long ans = 0;
		for ( int i = from; i < to; ++i ) {
			ans += nums[i];
		}
		return ans;
	}

	/**
	 * 渡された配列の指定された区間の総和を求めます。
	 * @param nums
	 * @param from
	 * @param to
	 * @return
	 */
	public static long sum ( final long[] nums, int from, int to ) {
		long ans = 0;
		for ( int i = from; i < to; ++i ) {
			ans += nums[i];
		}
		return ans;
	}

	/**
	 * 渡された配列の指定された区間の総和をmodで割ったあまりを求めます。
	 * @param nums
	 * @param from
	 * @param to
	 * @param mod
	 * @return
	 */
	public static long modSum ( final int[] nums, int from, int to, long mod ) {
		long ans = 0;
		for ( int i = from; i < to; ++i ) {
			ans += nums[i];
			ans %= mod;
		}
		if ( ans < 0 ) {
			ans += mod;
		}
		return ans;
	}

	/**
	 * 渡された配列の指定された区間の総和をmodで割ったあまりを求めます。
	 * @param nums
	 * @param from
	 * @param to
	 * @param mod
	 * @return
	 */
	public static long modSum ( final long[] nums, int from, int to, long mod ) {
		long ans = 0;
		for ( int i = from; i < to; ++i ) {
			ans += nums[i];
			ans %= mod;
		}
		if ( ans < 0 ) {
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l <= num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheck ( final int num, final int l, final int r ) {
		return l <= num && num < r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l <= num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheck ( final long num, final long l, final long r ) {
		return l <= num && num < r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l <= num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheck ( final double num, final double l, final double r ) {
		return l <= num && num < r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l <= num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheck ( final E num, final E l, final E r ) {
		return 0 <= l.compareTo( num ) && 0 < num.compareTo( r );
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l < num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckOpen ( final int num, final int l, final int r ) {
		return l < num && num < r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l < num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckOpen ( final long num, final long l, final long r ) {
		return l < num && num < r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l < num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckOpen ( final double num, final double l, final double r ) {
		return l < num && num < r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l < num < rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheckOpen ( final E num, final E l, final E r ) {
		return 0 < l.compareTo( num ) && 0 < num.compareTo( r );
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l <= num <= rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckClose ( final int num, final int l, final int r ) {
		return l <= num && num <= r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l <= num <= rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckClose ( final long num, final long l, final long r ) {
		return l <= num && num <= r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l <= num <= rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static boolean rangeCheckClose ( final double num, final double l, final double r ) {
		return l <= num && num <= r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l <= num <= rを満たしていればtrue 、 満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheckClose ( final E num, final E l, final E r ) {
		return 0 <= l.compareTo( num ) && 0 <= num.compareTo( r );
	}
}
