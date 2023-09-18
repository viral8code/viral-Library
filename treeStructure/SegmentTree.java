package treeStructure;

import java.util.Arrays;

public abstract class SegmentTree<E> {
	final int N, size;
	final E def;
	final Object[] node;

	public SegmentTree ( final int n, final E def, final boolean include ) {
		int num = 2;
		while ( num < n << 1 ) {
			num <<= 1;
		}
		N = num;
		size = num >> 1 - ( include ? 1 : 0 );
		node = new Object[N];
		this.def = def;
		Arrays.fill( node, this.def );
	}

	public SegmentTree ( final E[] arr, final E def, final boolean include ) {
		int num = 2;
		while ( num < arr.length << 1 ) {
			num <<= 1;
		}
		N = num;
		size = num >> 1 - ( include ? 1 : 0 );
		node = new Object[N];
		this.def = def;
		System.arraycopy( arr, 0, node, N >> 1, arr.length );
		for ( int i = arr.length + ( N >> 1 ); i < N; i++ ) {
			node[i] = def;
		}
		updateAll();
	}

	public SegmentTree ( final int n, final E def ) {
		this( n, def, false );
	}

	@SuppressWarnings( "unchecked" )
	private void updateAll () {
		for ( int i = ( N >> 1 ) - 1; i > 0; i-- ) {
			node[i] = function( ( E )node[i << 1], ( E )node[( i << 1 ) + 1] );
		}
	}

	@SuppressWarnings( "unchecked" )
	public void update ( int n, final E value ) {
		n += size;
		node[n] = value;
		n >>= 1;
		while ( n > 0 ) {
			node[n] = function( ( E )node[n << 1], ( E )node[( n << 1 ) + 1] );
			n >>= 1;
		}
	}

	@SuppressWarnings( "unchecked" )
	public E get ( final int a ) {
		return ( E )node[a + size];
	}

	@SuppressWarnings( "unchecked" )
	public E answer () {
		return ( E )node[1];
	}

	@SuppressWarnings( "unchecked" )
	public E query ( int l, int r ) {
		l += size;
		r += size;
		E answer = def;
		while ( l > 0 && r > 0 && l <= r ) {
			if ( l % 2 == 1 ) {
				answer = function( ( E )node[l++], answer );
			}
			l >>= 1;
			if ( r % 2 == 0 ) {
				answer = function( answer, ( E )node[r--] );
			}
			r >>= 1;
		}
		return answer;
	}

	abstract public E function ( E a, E b );
}
