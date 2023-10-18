/**
 * SegmentTreeクラスです。
 * 使用するときはfunctionメソッドを定義してご使用ください。
 */
package treeStructure;

import java.util.Arrays;

public abstract class SegmentTree<E> {
	
	//要素数とこのSegmentTreeを構成するのに必要な配列の大きさの半分を表すsize
	final int N, size;
	
	//このSegmentTreeにおける単位元
	final E def;
	
	//テーブル
	final Object[] node;

	/**
	 * 要素数n、初期値defとして新しくSegmentTreeを構築します。
	 * 1-indexedならtrue、0-indexedならfalseを渡して下さい。
	 * 
	 * @param n 要素数
	 * @param def 単位元(初期値)
	 * @param include 1-indexedか
	 */
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

	/**
	 * 配列arrを元に新しくSegmentTreeを構築します。
	 * 1-indexedならtrue、0-indexedならfalseを渡して下さい。
	 * 
	 * @param arr 初期値
	 * @param def 単位元
	 * @param include 1-indexedか
	 */
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

	/**
	 * 0-indexedの、要素数n、初期値defの新しいSegmentTreeを構築します。
	 * @param n
	 * @param def
	 */
	public SegmentTree ( final int n, final E def ) {
		this( n, def, false );
	}

	/**
	 * テーブル全体を更新します。
	 */
	@SuppressWarnings( "unchecked" )
	private void updateAll () {
		for ( int i = ( N >> 1 ) - 1; i > 0; i-- ) {
			node[i] = function( ( E )node[i << 1], ( E )node[( i << 1 ) + 1] );
		}
	}

	/**
	 * 指定された位置の要素を引数で上書きします。
	 * @param n
	 * @param value
	 */
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

	/**
	 * 指定された位置の要素を返します。
	 * @param a
	 * @return
	 */
	@SuppressWarnings( "unchecked" )
	public E get ( final int a ) {
		return ( E )node[a + size];
	}

	/**
	 * このSegmentTree全体にfunctionを作用させた時の解を返します。
	 * @return
	 */
	@SuppressWarnings( "unchecked" )
	public E answer () {
		return ( E )node[1];
	}

	/**
	 * l以上r以下の要素に対してfunctionを作用させた時の解を返します。
	 * @param l
	 * @param r
	 * @return
	 */
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

	/**
	 * このSegmentTreeに乗せる演算が定義されているメソッドです。
	 * @param a
	 * @param b
	 * @return
	 */
	abstract public E function ( E a, E b );
}
