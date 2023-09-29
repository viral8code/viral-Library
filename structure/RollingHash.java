/**
 * RollingHashクラスです。
 * ハッシュ値による比較を行なっているので、equalsは確率的に等しいかを返します。
 * Stringの基本的なメソッドは実装してあります。
 */
package structure;

import java.util.Random;

public final class RollingHash implements Comparable<RollingHash> {
	
	//底(実行時にランダムで決まります)
	private static final long BASE = new Random().nextInt( 1000 ) + Character.MAX_VALUE + 1;
	
	//あまりを取る用のクラス変数です。
	private static final long MASK30 = ( 1L << 30 ) - 1;
	
	//あまりを取る用のクラス変数です。
	private static final long MASK31 = ( 1L << 31 ) - 1;
	
	//あまりを取る用のクラス変数です。
	private static final long MOD = ( 1L << 61 ) - 1;
	
	//あまりを取る用のクラス変数です。
	private static final long MASK61 = MOD;
	
	//ハッシュ値を管理するテーブルです。
	private long[] hash;
	
	//このRolligHashが表す文字列です。
	private String string;

	/**
	 * 引数を元にハッシュ値を求めます。
	 * @param str
	 */
	public RollingHash ( final String str ) {
		string = str;
		hash = new long[str.length() + 1];
		roll();
	}

	/**
	 * ハッシュ値を求めるためのメソッドです。
	 */
	private void roll () {
		final int len = string.length();
		for ( int i = 1; i <= len; ++i ) {
			hash[i] = multiply( hash[i - 1], BASE ) + string.charAt( i - 1 ) - ' ' + 1;
			if ( MOD <= hash[i] ) {
				hash[i] -= MOD;
			}
		}
	}

	/**
	 * ハッシュ値を求める際にオーバーフローを避けるためのメソッドです。
	 * @param a
	 * @param b
	 * @return
	 */
	private static long multiply ( final long a, final long b ) {
		final long au = a >> 31;
		final long ad = a & MASK31;
		final long bu = b >> 31;
		final long bd = b & MASK31;
		final long mid = ad * bu + au * bd;
		final long midu = mid >> 30;
		final long midd = mid & MASK30;
		return mod( au * bu * 2 + midu + ( midd << 31 ) + ad * bd );
	}

	/**
	 * xをMODで割ったあまりを求めます。
	 * @param x
	 * @return
	 */
	private static long mod ( final long x ) {
		final long xu = x >> 61;
		final long xd = x & MASK61;
		long ans = xu + xd;
		if ( MOD <= ans ) {
			ans -= MOD;
		}
		return ans;
	}

	/**
	 * [l,r)のハッシュ値を求めます。
	 * @param l
	 * @param r
	 * @return
	 */
	public long getHash ( final int l, final int r ) {
		return ( hash[r] - multiply( hash[l], modBasePow( r - l ) ) + MOD ) % MOD;
	}

	/**
	 * BASE^bをMODで割ったあまりを求めます。
	 * @param b
	 * @return
	 */
	private static long modBasePow ( long b ) {
		long ans = 1;
		long a = BASE;
		while ( b > 0 ) {
			if ( ( b & 1 ) == 1 ) {
				ans = multiply( ans, a );
			}
			a = multiply( a, a );
			b >>= 1;
		}
		return ans;
	}

	/**
	 * このRollingHashの[l1,r1)と引数のRollingHashの[l2,r2)が確率的に等しいか返します。
	 * @param rh
	 * @param l1
	 * @param r1
	 * @param l2
	 * @param r2
	 * @return
	 */
	public boolean equals ( final RollingHash rh, final int l1, final int r1, final int l2, final int r2 ) {
		if ( r1 - l1 != r2 - l2 ) {
			return false;
		}
		return getHash( l1, r1 ) == rh.getHash( l2, r2 );
	}

	/**
	 * このRollingHashが表すStringの長さを返します。
	 * @return
	 */
	public int length () {
		return string.length();
	}

	/**
	 * このRollingHashが表すStringのhashCodeを返します。
	 */
	@Override
	public int hashCode () {
		return string.hashCode();
	}

	/**
	 * このRollingHashが表すStringを返します。
	 */
	@Override
	public String toString () {
		return string;
	}

	/**
	 * 引数がこのRolligHashと確率的に等しいか返します。
	 */
	@Override
	public boolean equals ( Object o ) {
		if ( o instanceof final RollingHash rh ) {
			return equals( rh, 0, length(), 0, rh.length() );
		}
		return false;
	}

	/**
	 * 辞書順で比較します。
	 */
	@Override
	public int compareTo ( RollingHash rh ) {
		return string.compareTo( rh.toString() );
	}

	/**
	 * 辞書順で比較します。
	 */
	public int compareTo ( String str ) {
		return string.compareTo( str );
	}

	/**
	 * 引数の位置のcharを返します。
	 * @param i
	 * @return
	 */
	public char charAt ( final int i ) {
		return string.charAt( i );
	}

	/**
	 * 辞書順で比較します。
	 */
	public int compareToIgnoreCase ( final RollingHash rh ) {
		return string.compareToIgnoreCase( rh.toString() );
	}

	/**
	 * 辞書順で比較します。
	 */
	public int compareToIgnoreCase ( final String str ) {
		return string.compareToIgnoreCase( str );
	}

	/**
	 * 引数のRollingHashを末尾に追加します。
	 * @param rh
	 */
	public void concat ( final RollingHash rh ) {
		concat( rh.toString() );
	}

	/**
	 * 引数のStringを末尾に追加します。
	 * @param rh
	 */
	public void concat ( final String str ) {
		string = string.concat( str );
		hash = new long[string.length() + 1];
		roll();
	}

	/**
	 * 引数のRollingHashが含まれているか調べます。
	 * @param rh
	 * @return
	 */
	public boolean contains ( final RollingHash rh ) {
		final long hash = rh.getHash( 0, rh.length() );
		final int len = length() - rh.length();
		for ( int i = 0; i <= len; ++i ) {
			if ( hash == getHash( i, rh.length() + i ) ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 引数のStringが含まれているか調べます。
	 * @param str
	 * @return
	 */
	public boolean contains ( final String str ) {
		return indexOf( str ) != -1;
	}

	/**
	 * 引数のcharの最初のインデックスを探します。
	 * 見つからなければ-1を返します。
	 * @param ch
	 * @return
	 */
	public int indexOf ( final int ch ) {
		return indexOf( ch, 0 );
	}

	/**
	 * 引数以降で、引数のcharの最初のインデックスを探します。
	 * 見つからなければ-1を返します。
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public int indexOf ( final int ch, final int fromIndex ) {
		final int len = length();
		for ( int i = fromIndex; i < len; ++i ) {
			if ( string.charAt( i ) == ch ) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * strが現れる最初のインデックスを返します。
	 * @param str
	 * @return
	 */
	public int indexOf ( final String str ) {
		return indexOf( str, 0 );
	}

	/**
	 * 引数の位置から、strが現れる最初のインデックスを返します。
	 * @param str
	 * @param fromIndex
	 * @return
	 */
	public int indexOf ( final String str, final int fromIndex ) {
		long hash = 0;
		for ( final char c: str.toCharArray() ) {
			hash = multiply( hash, BASE ) + c - ' ' + 1;
			if ( MOD <= hash ) {
				hash -= MOD;
			}
		}
		final int len = length() - str.length();
		for ( int i = fromIndex; i <= len; ++i ) {
			if ( hash == getHash( i, str.length() + i ) ) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * このRollingHashが表す文字列が空文字かどうか返します。
	 * @return
	 */
	public boolean isEmpty () {
		return length() == 0;
	}

	/**
	 * 引数のcharが、引数よりも前で一番最後に出現したインデックスを返します。
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public int lastIndexOf ( final int ch, final int fromIndex ) {
		for ( int i = fromIndex; i >= 0; --i ) {
			if ( string.charAt( i ) == ch ) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数のcharが出現する一番最後のインデックスを返します。
	 * @param ch
	 * @return
	 */
	public int lastIndexOf ( final int ch ) {
		return lastIndexOf( ch, length() - 1 );
	}

	/**
	 * 引数のboolean型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final boolean b ) {
		return new RollingHash( b ? "true" : "false" );
	}

	/**
	 * 引数のchar型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final char c ) {
		return new RollingHash( "" + c );
	}

	/**
	 * 引数のchar[]型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final char[] c ) {
		return new RollingHash( String.valueOf( c, 0, c.length ) );
	}

	/**
	 * 引数のchar[]の引数の区間を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final char[] c, final int offset, final int count ) {
		return new RollingHash( String.valueOf( c, offset, count ) );
	}

	/**
	 * 引数のdouble型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final double d ) {
		return new RollingHash( String.valueOf( d ) );
	}

	/**
	 * 引数のfloat型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final float f ) {
		return new RollingHash( String.valueOf( f ) );
	}

	/**
	 * 引数のint型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final int i ) {
		return new RollingHash( String.valueOf( i ) );
	}

	/**
	 * 引数のlong型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final long l ) {
		return new RollingHash( String.valueOf( l ) );
	}

	/**
	 * 引数のObject型を表すRollingHashを返します。
	 * @param b
	 * @return
	 */
	public static RollingHash valueOf ( final Object obj ) {
		return new RollingHash( String.valueOf( obj ) );
	}
}
