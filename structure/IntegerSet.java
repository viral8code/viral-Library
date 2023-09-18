/**
 * IntegerSetクラスです。
 * オートボクシングを避けるためにiteratorメソッドを実装していません。
 * 拡張for文などではtoArray()を使用することを推奨します。
 */
package structure;

import java.util.Arrays;

public final class IntegerSet {

	/**
	 * @author viral
	 *
	 */
	private class Node {
		private final int value;
		private Node next;

		private Node ( final int val ) {
			value = val;
		}

		private boolean add ( final int x ) {
			if ( value == x ) {
				return false;
			}
			if ( next != null ) {
				return next.add( x );
			}
			++size;
			next = new Node( x );
			return true;
		}

		private void add ( final Node n ) {
			if ( value != n.value ) {
				if ( next != null ) {
					next.add( n );
				}
				else {
					next = n;
				}
			}
		}

		private boolean remove ( final int x ) {
			if ( next == null ) {
				return false;
			}
			if ( next.value != x ) {
				return next.remove( x );
			}
			--size;
			next = next.next;
			return true;
		}

		private boolean contains ( final int x ) {
			if ( value == x ) {
				return true;
			}
			if ( next != null ) {
				return next.contains( x );
			}
			return false;
		}
	}

	private Node[] table;
	private int size;

	/**
	 * IntegerSetクラスのインスタンスを生成します。
	 */
	public IntegerSet () {
		this( 16 );
	}

	/**
	 * ハッシュテーブルの初期サイズをsとしたIntegerSetを生成します。
	 * @param s
	 */
	public IntegerSet ( final int s ) {
		if ( s < 1 ) {
			throw new NegativeArraySizeException( "hash table's size must be positive" );
		}
		table = new Node[s];
		size = 0;
	}

	/**
	 * xを追加します。
	 * @param x
	 * @return 要素が追加できたかを表すboolean
	 */
	public boolean add ( final int x ) {
		sizeCheck();
		final int index = hash( x );
		if ( table[index] != null ) {
			return table[index].add( x );
		}
		++size;
		table[index] = new Node( x );
		return true;
	}

	/**
	 * 内部処理のためのaddメソッドです。
	 * @param n
	 */
	private void add ( final Node n ) {
		final int index = hash( n.value );
		if ( table[index] != null ) {
			table[index].add( n );
		}
		else {
			table[index] = n;
		}
	}

	/**
	 * xを削除します。
	 * @param x
	 * @return xが削除前に存在したかを表すboolean
	 */
	public boolean remove ( final int x ) {
		final int index = hash( x );
		if ( table[index] == null ) {
			return false;
		}
		if ( table[index].value != x ) {
			return table[index].remove( x );
		}
		--size;
		table[index] = table[index].next;
		return true;
	}

	/**
	 * xが存在するか調べます。
	 * @param x
	 * @return
	 */
	public boolean contains ( final int x ) {
		final int index = hash( x );
		if ( table[index] == null ) {
			return false;
		}
		return table[index].contains( x );
	}

	/**
	 * リハッシュメソッドです。
	 */
	private void reHash () {
		final Node[] oldTable = table;
		table = new Node[table.length << 1];
		for ( Node node: oldTable ) {
			while ( node != null ) {
				final Node next = node.next;
				node.next = null;
				add( node );
				node = next;
			}
		}
	}

	/**
	 * 必要に応じてリハッシュするメソッドです。
	 */
	private void sizeCheck () {
		if ( table.length * 0.6 < size ) {
			reHash();
		}
	}

	/**
	 * ハッシュテーブルに追加すべき位置を返します。
	 * @param val
	 * @return
	 */
	private int hash ( final int val ) {
		final int h = val % table.length;
		return h < 0 ? h + table.length : h;
	}

	/**
	 * このIntegerSetに存在する要素の数を返します。
	 * @return
	 */
	public int size () {
		return size;
	}

	/**
	 * このIntegerSetに存在する要素を表すint[]を返します。
	 * 順番は不定です。
	 * @return
	 */
	public int[] toArray () {
		final int[] array = new int[size];
		int index = 0;
		for ( Node node: table ) {
			while ( node != null ) {
				array[index++] = node.value;
				node = node.next;
			}
		}
		return array;
	}

	/**
	 * このIntegerSetを表すStringを返します。
	 */
	public String toString () {
		return Arrays.toString( toArray() );
	}
}
