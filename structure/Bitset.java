/**
 * Bitsetクラスです。
 * java.util.BitSetと基本的には同じですが、ビットシフトが行えるようになっています。
 */
package structure;

import java.util.Arrays;

public final class Bitset implements Cloneable {
	private final long[] bit;
	private final int size, len;
	private final long MASK;

	/**
	 * len個のビットを扱えるBitsetを生成します。
	 * @param len
	 */
	public Bitset ( final int len ) {
		this.len = len;
		size = ( len + 63 ) >> 6;
		bit = new long[size];
		MASK = ( -1L ) >>> ( ( size << 6 ) - len );
	}

	/**
	 * 引数の位置のビットをtrueにします。
	 * @param index
	 */
	public void set ( final int index ) {
		if ( index >= size << 6 ) {
			throw new ArrayIndexOutOfBoundsException( index + " is out of this bitset's size " + size );
		}
		bit[index >> 6] |= ( 1L << ( index & 0b111111 ) );
	}

	/**
	 * 引数の位置のビットをfalseにします。
	 * @param index
	 */
	public void clear ( final int index ) {
		if ( index >= size << 6 ) {
			throw new ArrayIndexOutOfBoundsException( index + " is out of this bitset's size " + size );
		}
		long m = ~( 1L << ( index & 0b111111 ) );
		bit[index >> 6] &= m;
	}

	/**
	 * 引数の位置のビットを返します。
	 * @param index
	 * @return
	 */
	public boolean get ( final int index ) {
		if ( index >= size << 6 ) {
			throw new ArrayIndexOutOfBoundsException( index + " is out of this bitset's size " + size );
		}
		return ( bit[index >> 6] & ( 1L << ( index & 0b111111 ) ) ) != 0;
	}

	/**
	 * このビット列を左にnumだけシフトします。
	 * @param num
	 */
	public void shiftLeft ( int num ) {
		if ( num >= size << 6 ) {
			Arrays.fill( bit, 0L );
			return;
		}
		final int n = num >> 6;
		num &= 0b111111;
		for ( int i = size - 1; i >= n; --i ) {
			bit[i] = ( bit[i - n] << num ) | ( i != n && num != 0 ? bit[i - n - 1] >>> ( 64 - num ) : 0L );
		}
		for ( int i = 0; i < n; ++i ) {
			bit[i] = 0L;
		}
		bit[size - 1] &= MASK;
	}

	/**
	 * このビット列を右にnumだけシフトします。
	 * @param num
	 */
	public void shiftRight ( int num ) {
		if ( num >= size << 6 ) {
			Arrays.fill( bit, 0L );
			return;
		}
		final int n = num >> 6;
		num &= 0b111111;
		for ( int i = 0; i < size - n; ++i ) {
			bit[i] = ( bit[i + n] >>> num ) | ( i + n + 1 != size && num != 0 ? bit[i + n + 1] << ( 64 - num ) : 0L );
		}
		for ( int i = size - 1; i >= size - n; --i ) {
			bit[i] = 0L;
		}
	}

	/**
	 * このBitsetを表すlong型配列を返します。
	 * @return
	 */
	public long[] longValues () {
		return bit;
	}

	/**
	 * このBitsetをlongとして解釈したときの値を返します。
	 * @return
	 */
	public long longValue () {
		return bit[0];
	}

	/**
	 * 引数のBitsetとの論理積を返します。
	 * @param b
	 */
	public void and ( final Bitset b ) {
		final long[] bit2 = b.longValues();
		final int m = Math.min( bit2.length, size );
		for ( int i = 0; i < m; ++i ) {
			bit[i] &= bit2[i];
		}
		for ( int i = m; i < size; ++i ) {
			bit[i] = 0;
		}
		bit[size - 1] &= MASK;
	}

	/**
	 * 引数のBitsetとの論理和を返します。
	 * @param b
	 */
	public void or ( final Bitset b ) {
		final long[] bit2 = b.longValues();
		final int m = Math.min( bit2.length, size );
		for ( int i = 0; i < m; ++i ) {
			bit[i] |= bit2[i];
		}
		bit[size - 1] &= MASK;
	}

	/**
	 * 引数のBitsetとの排他的論理和を返します。
	 * @param b
	 */
	public void xor ( final Bitset b ) {
		final long[] bit2 = b.longValues();
		final int m = Math.min( bit2.length, size );
		for ( int i = 0; i < m; ++i ) {
			bit[i] ^= bit2[i];
		}
		bit[size - 1] &= MASK;
	}

	/**
	 * このBitsetと同等のBitsetを返します。
	 */
	public Bitset clone () throws CloneNotSupportedException {
		super.clone();
		final Bitset b = new Bitset( len );
		b.or( this );
		return b;
	}
}
