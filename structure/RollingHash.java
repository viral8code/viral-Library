package structure;

import java.util.Random;

public final class RollingHash implements Comparable<RollingHash> {
	private static final long BASE = new Random().nextInt( 1000 ) + Character.MAX_VALUE + 1;
	private static final long MASK30 = ( 1L << 30 ) - 1;
	private static final long MASK31 = ( 1L << 31 ) - 1;
	private static final long MOD = ( 1L << 61 ) - 1;
	private static final long MASK61 = MOD;
	private long[] hash;
	private String string;

	public RollingHash ( final String str ) {
		string = str;
		hash = new long[str.length() + 1];
		roll();
	}

	private void roll () {
		final int len = string.length();
		for ( int i = 1; i <= len; ++i ) {
			hash[i] = multiply( hash[i - 1], BASE ) + string.charAt( i - 1 ) - ' ' + 1;
			if ( MOD <= hash[i] ) {
				hash[i] -= MOD;
			}
		}
	}

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

	private static long mod ( final long x ) {
		final long xu = x >> 61;
		final long xd = x & MASK61;
		long ans = xu + xd;
		if ( MOD <= ans ) {
			ans -= MOD;
		}
		return ans;
	}

	public long getHash ( final int l, final int r ) {
		return ( hash[r] - multiply( hash[l], modBasePow( r - l ) ) + MOD ) % MOD;
	}

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

	public boolean equals ( final RollingHash rh, final int l1, final int r1, final int l2, final int r2 ) {
		if ( r1 - l1 != r2 - l2 ) {
			return false;
		}
		return getHash( l1, r1 ) == rh.getHash( l2, r2 );
	}

	public int length () {
		return string.length();
	}

	@Override
	public int hashCode () {
		return string.hashCode();
	}

	@Override
	public String toString () {
		return string;
	}

	@Override
	public boolean equals ( Object o ) {
		if ( o instanceof final RollingHash rh ) {
			return equals( rh, 0, length(), 0, rh.length() );
		}
		return false;
	}

	@Override
	public int compareTo ( RollingHash rh ) {
		return string.compareTo( rh.toString() );
	}

	public int compareTo ( String str ) {
		return string.compareTo( str );
	}

	public char charAt ( final int i ) {
		return string.charAt( i );
	}

	public int compareToIgnoreCase ( final RollingHash rh ) {
		return string.compareToIgnoreCase( rh.toString() );
	}

	public int compareToIgnoreCase ( final String str ) {
		return string.compareToIgnoreCase( str );
	}

	public void concat ( final RollingHash rh ) {
		concat( rh.toString() );
	}

	public void concat ( final String str ) {
		string = string.concat( str );
		hash = new long[string.length() + 1];
		roll();
	}

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

	public boolean contains ( final String str ) {
		return indexOf( str ) != -1;
	}

	public int indexOf ( final int ch ) {
		return indexOf( ch, 0 );
	}

	public int indexOf ( final int ch, final int fromIndex ) {
		final int len = length();
		for ( int i = fromIndex; i < len; ++i ) {
			if ( string.charAt( i ) == ch ) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf ( final String str ) {
		return indexOf( str, 0 );
	}

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

	public boolean isEmpty () {
		return length() == 0;
	}

	public int lastIndexOf ( final int ch, final int fromIndex ) {
		for ( int i = fromIndex; i >= 0; --i ) {
			if ( string.charAt( i ) == ch ) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf ( final int ch ) {
		return lastIndexOf( ch, length() - 1 );
	}

	public static RollingHash valueOf ( final boolean b ) {
		return new RollingHash( b ? "true" : "false" );
	}

	public static RollingHash valueOf ( final char c ) {
		return new RollingHash( "" + c );
	}

	public static RollingHash valueOf ( final char[] c ) {
		return new RollingHash( String.valueOf( c, 0, c.length ) );
	}

	public static RollingHash valueOf ( final char[] c, final int offset, final int count ) {
		return new RollingHash( String.valueOf( c, offset, count ) );
	}

	public static RollingHash valueOf ( final double d ) {
		return new RollingHash( String.valueOf( d ) );
	}

	public static RollingHash valueOf ( final float f ) {
		return new RollingHash( String.valueOf( f ) );
	}

	public static RollingHash valueOf ( final int i ) {
		return new RollingHash( String.valueOf( i ) );
	}

	public static RollingHash valueOf ( final long l ) {
		return new RollingHash( String.valueOf( l ) );
	}

	public static RollingHash valueOf ( final Object obj ) {
		return new RollingHash( String.valueOf( obj ) );
	}
}
