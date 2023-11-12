/**
 * TreeIntクラスです。
 * 全体はTreeクラスと変わりませんが、int特化になっているため他の要素は扱えません。
 */
package treeStructure;

import java.util.ArrayDeque;
import java.util.Arrays;

public final class TreeInt {
	
	//このAVL木の根です
	private Node root;
	
	//このAVL木の要素数とハッシュ値です
	private int size, hash;

	/**
	 * 新しいTreeIntインスタンスを生成します。
	 */
	public TreeInt () {
		size = 0;
		root = null;
		hash = 0;
	}

	/**
	 * このAVL木のノードを表すクラスです。
	 *
	 */
	static final private class Node {
		int value;
		int height, size;
		Node left, right, parent;

		public Node ( final Node p, final int v ) {
			value = v;
			parent = p;
			height = 1;
			size = 1;
		}
	}

	/**
	 * 引数の値をこのAVL木に追加します。
	 * @param x
	 * @return このAVL木に変更がされればtrue
	 */
	public boolean add ( final int x ) {
		boolean bool = true;
		if ( root == null ) {
			root = new Node( null, x );
		}
		else {
			Node par;
			Node now = root;
			do {
				par = now;
				if ( x < now.value ) {
					now = now.left;
				}
				else if ( x > now.value ) {
					now = now.right;
				}
				else {
					bool = false;
					break;
				}
			} while ( now != null );
			if ( bool ) {
				if ( x < par.value ) {
					par.left = new Node( par, x );
				}
				else {
					par.right = new Node( par, x );
				}
				fix( par );
			}
		}
		if ( bool ) {
			++size;
			hash ^= x;
		}
		return bool;
	}

	/**
	 * 引数で指定された位置の要素を返します。
	 * @param index
	 * @return 小さい方からindex番目の要素
	 */
	public int get ( int index ) {
		if ( root == null || size <= index ) {
			throw new NullPointerException();
		}
		Node now = root;
		while ( true ) {
			assert now != null;
			final int ls = now.left != null ? now.left.size : 0;
			if ( index < ls ) {
				now = now.left;
			}
			else if ( ls < index ) {
				now = now.right;
				index -= ls + 1;
			}
			else {
				break;
			}
		}
		return now.value;
	}

	/**
	 * 引数で指定された要素を削除します。
	 * @param x
	 * @return このAVL木が変更されればtrue
	 */
	public boolean remove ( final int x ) {
		final Node n = getNode( x );
		if ( n == null ) {
			return false;
		}
		--size;
		hash ^= n.value;
		delete( n );
		return true;
	}

	/**
	 * 引数のノードを削除します。
	 * @param node
	 */
	private void delete ( final Node node ) {
		if ( node != null ) {
			if ( node.left == null && node.right == null ) {
				if ( node.parent != null ) {
					if ( node.parent.left == node ) {
						node.parent.left = null;
					}
					else {
						node.parent.right = null;
					}
					fix( node.parent );
				}
				else {
					root = null;
				}
				node.parent = null;
			}
			else {
				if ( node.left != null && node.right != null ) {
					final Node rep = getFirstNode( node.right );
					node.value = rep.value;
					delete( rep );
				}
				else {
					final Node rep = node.left != null ? node.left : node.right;
					rep.parent = node.parent;
					if ( node.parent != null ) {
						if ( node.parent.left == node ) {
							node.parent.left = rep;
						}
						else {
							node.parent.right = rep;
						}
						fix( node.parent );
					}
					else {
						root = rep;
					}
					node.parent = null;
				}
			}
		}
	}

	/**
	 * 指定された値を持つノードを返します。
	 * @param x
	 * @return
	 */
	private Node getNode ( final int x ) {
		Node now = root;
		while ( now != null ) {
			if ( x < now.value ) {
				now = now.left;
			}
			else if ( x > now.value ) {
				now = now.right;
			}
			else {
				break;
			}
		}
		return now;
	}

	/**
	 * このAVL木の最小を値を返します。
	 * @return
	 */
	public int first () {
		if ( root == null ) {
			throw new NullPointerException();
		}
		return getFirstNode( root ).value;
	}

	/**
	 * このAVL木の最小の値を持つノードを返します。
	 * @param node
	 * @return
	 */
	private Node getFirstNode ( Node node ) {
		assert node != null;
		Node par = null;
		while ( node != null ) {
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * このAVL木の最大の値を返します。
	 * @return
	 */
	public int last () {
		if ( root == null ) {
			throw new NullPointerException();
		}
		return getLastNode( root ).value;
	}

	/**
	 * このAVL木の最大の値を持つノードを返します。
	 * @param node
	 * @return
	 */
	private Node getLastNode ( Node node ) {
		assert node != null;
		Node par = null;
		while ( node != null ) {
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 引数の値がこのAVL木に含まれているか返します。
	 * @param x
	 * @return
	 */
	public boolean contains ( final int x ) {
		if ( root == null ) {
			return false;
		}
		return getNode( x ) != null;
	}

	/**
	 * このAVL木の最小の値を返して削除します。
	 * @return
	 */
	public int pollFirst () {
		if ( root == null ) {
			throw new NullPointerException();
		}
		--size;
		final Node min = getFirstNode( root );
		hash ^= min.value;
		delete( min );
		return min.value;
	}

	/**
	 * このAVL木の最大の値を返して削除します。
	 * @return
	 */
	public int pollLast () {
		if ( root == null ) {
			throw new NullPointerException();
		}
		--size;
		final Node max = getLastNode( root );
		hash ^= max.value;
		delete( max );
		return max.value;
	}

	/**
	 * 引数以上の値で最も小さい値を返します。
	 * もし引数以上の値が無ければ引数-1を返します。
	 * @param x
	 * @return
	 */
	public int ceiling ( final int x ) {
		return ceiling( root, x );
	}

	/**
	 * 引数以上の値で最も小さい値を持っているノードを返します。
	 * もし引数以上の値が無ければ引数-1を持ったノードを返します。
	 * @param node
	 * @param x
	 * @return
	 */
	private int ceiling ( Node node, final int x ) {
		Node ans = new Node( null, x - 1 );
		while ( node != null ) {
			if ( x > node.value ) {
				node = node.right;
			}
			else if ( x < node.value ) {
				ans = node;
				node = node.left;
			}
			else {
				return x;
			}
		}
		return ans.value;
	}

	/**
	 * 引数よりも大きい値で最も小さい値を返します。
	 * もし引数よりも大きい値が無ければ引数-1を返します。
	 * @param x
	 * @return
	 */
	public int higher ( final int x ) {
		return higher( root, x );
	}

	/**
	 * 引数よりも大きい値で最も小さい値を持つノードを返します。
	 * もし引数よりも大きい値が無ければ引数-1を持つノードを返します。
	 * @param node
	 * @param x
	 * @return
	 */
	private int higher ( Node node, final int x ) {
		Node ans = new Node( null, x - 1 );
		while ( node != null ) {
			if ( x >= node.value ) {
				node = node.right;
			}
			else {
				ans = node;
				node = node.left;
			}
		}
		return ans.value;
	}

	/**
	 * 引数以下で最大の値を返します。
	 * もし引数以下の値が無ければ引数+1を返します。
	 * @param x
	 * @return
	 */
	public int floor ( final int x ) {
		return floor( root, x );
	}

	/**
	 * 引数以下で最大の値を持つノードを返します。
	 * もし引数以下の値が無ければ引数+1を持つノードを返します。
	 * @param node
	 * @param x
	 * @return
	 */
	private int floor ( Node node, final int x ) {
		Node ans = new Node( null, x + 1 );
		while ( node != null ) {
			if ( x < node.value ) {
				node = node.left;
			}
			else if ( x > node.value ) {
				ans = node;
				node = node.right;
			}
			else {
				return x;
			}
		}
		return ans.value;
	}

	/**
	 * 引数よりも小さい最大の値を返します。
	 * もし引数よりも小さい値が無ければ引数+1を返します。
	 * @param x
	 * @return
	 */
	public int lower ( final int x ) {
		return lower( root, x );
	}

	/**
	 * 引数よりも小さい最大の値を持つノードを返します。
	 * もし引数よりも小さい値が無ければ引数+1を持つノードを返します。
	 * @param node
	 * @param x
	 * @return
	 */
	private int lower ( Node node, final int x ) {
		Node ans = new Node( null, x + 1 );
		while ( node != null ) {
			if ( x <= node.value ) {
				node = node.left;
			}
			else {
				ans = node;
				node = node.right;
			}
		}
		return ans.value;
	}

	/**
	 * このAVL木を空にします。
	 */
	public void clear () {
		root = null;
		size = 0;
		hash = 0;
	}

	/**
	 * このAVL木が空か判定します。
	 * @return
	 */
	public boolean isEmpty () {
		return size == 0;
	}

	/**
	 * このAVL木の大きさを返します。
	 * @return
	 */
	public int size () {
		return size;
	}

	/**
	 * このAVL木の要素を配列にして返します。
	 * この配列の値は昇順に並んでいることが保証されます。
	 * @return
	 */
	public int[] toArray () {
		final int[] list = new int[size];
		if ( root != null ) {
			int index = 0;
			final ArrayDeque<Node> deq = new ArrayDeque<>();
			deq.add( root );
			while ( !deq.isEmpty() ) {
				final Node now = deq.pollLast();
				if ( index == 0 ) {
					if ( now.left != null ) {
						deq.add( now );
						deq.add( now.left );
					}
					else {
						list[index++] = now.value;
						if ( now.right != null ) {
							deq.add( now.right );
						}
					}
				}
				else if ( now.left != null && list[index - 1] < now.left.value ) {
					deq.add( now );
					deq.add( now.left );
				}
				else {
					list[index++] = now.value;
					if ( now.right != null ) {
						deq.add( now.right );
					}
				}
			}
		}
		return list;
	}

	/**
	 * このAVL木を表すStringを返します。
	 */
	@Override
	public String toString () {
		final int[] list = toArray();
		return Arrays.toString( list );
	}

	/**
	 * このAVL木と引数が等しいか返します。
	 */
	@Override
	public boolean equals ( final Object o ) {
		if ( o instanceof final TreeInt tree ) {
			if ( size != tree.size() ) {
				return false;
			}
			final int[] array1 = toArray();
			final int[] array2 = tree.toArray();
			for ( int i = 0; i < size; ++i ) {
				if ( array1[i] != array2[i] ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このAVL木のハッシュ値を返します。
	 * この値は全要素の累積排他的論理和と一致します。
	 */
	@Override
	public int hashCode () {
		return hash;
	}

	/*
	 * 以下、平衡用メソッド
	 */

	/**
	 * 引数のノードから根に向かって、各ノードが平衡を保つよう修正します。
	 * @param node
	 */
	private void fix ( Node node ) {
		while ( node != null ) {
			final int lh = node.left == null ? 0 : node.left.height;
			final int rh = node.right == null ? 0 : node.right.height;
			if ( lh - rh > 1 ) {
				assert node.left != null;
				if ( node.left.right != null && node.left.right.height == lh - 1 ) {
					rotateL( node.left );
				}
				rotateR( node );
			}
			else if ( rh - lh > 1 ) {
				assert node.right != null;
				if ( node.right.left != null && node.right.left.height == rh - 1 ) {
					rotateR( node.right );
				}
				rotateL( node );
			}
			else {
				setStates( node );
			}
			node = node.parent;
		}
	}

	/**
	 * 引数のノードを右に回転させます。
	 * @param node
	 */
	private void rotateR ( final Node node ) {
		final Node temp = node.left;
		node.left = temp.right;
		if ( node.left != null ) {
			node.left.parent = node;
		}
		temp.right = node;
		temp.parent = node.parent;
		if ( node.parent != null ) {
			if ( node.parent.left == node ) {
				node.parent.left = temp;
			}
			else {
				node.parent.right = temp;
			}
		}
		else {
			root = temp;
		}
		node.parent = temp;
		setStates( node );
	}

	/**
	 * 引数のノードを左に回転させます。
	 * @param node
	 */
	private void rotateL ( final Node node ) {
		final Node temp = node.right;
		node.right = temp.left;
		if ( node.right != null ) {
			node.right.parent = node;
		}
		temp.left = node;
		temp.parent = node.parent;
		if ( node.parent != null ) {
			if ( node.parent.left == node ) {
				node.parent.left = temp;
			}
			else {
				node.parent.right = temp;
			}
		}
		else {
			root = temp;
		}
		node.parent = temp;
		setStates( node );
	}

	/**
	 * 引数のノードのパラメータを更新します。
	 * @param node
	 */
	private void setStates ( final Node node ) {
		final int lh = node.left != null ? node.left.height : 0;
		final int rh = node.right != null ? node.right.height : 0;
		node.height = Math.max( lh, rh ) + 1;
		final int ls = node.left != null ? node.left.size : 0;
		final int rs = node.right != null ? node.right.size : 0;
		node.size = ls + rs + 1;
	}
}
