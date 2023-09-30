/**
 * Treeクラスです。
 * ジェネリクス型のAVL木です。
 */
package treeStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Tree<E extends Comparable<E>> {
	
	//このTreeの根です。
	private Node<E> root;
	
	private int size, hash;

	/**
	 * 新しいTreeを生成します。
	 */
	public Tree () {
		size = 0;
		root = null;
		hash = 0;
	}

	/**
	 * このTreeの節を表すNodeクラスです。
	 *
	 * @param <E>
	 */
	static final private class Node<E> {
		E value;
		int height, size;
		Node<E> left, right, parent;

		public Node ( final Node<E> p, final E v ) {
			value = v;
			parent = p;
			height = 1;
			size = 1;
		}
	}

	/**
	 * 引数の要素を追加します。
	 * @param x
	 * @return
	 */
	public boolean add ( final E x ) {
		boolean bool = true;
		if ( root == null ) {
			root = new Node<>( null, x );
		}
		else {
			Node<E> par;
			Node<E> now = root;
			do {
				par = now;
				final int result = x.compareTo( now.value );
				if ( result < 0 ) {
					now = now.left;
				}
				else if ( result > 0 ) {
					now = now.right;
				}
				else {
					bool = false;
					break;
				}
			} while ( now != null );
			if ( bool ) {
				final int result = x.compareTo( par.value );
				if ( result < 0 ) {
					par.left = new Node<>( par, x );
				}
				else {
					par.right = new Node<>( par, x );
				}
				fix( par );
			}
		}
		if ( bool ) {
			++size;
			hash ^= x.hashCode();
		}
		return bool;
	}

	/**
	 * 小さい方から数えて引数のインデックスの要素を返します。
	 * @param index
	 * @return
	 */
	public E get ( int index ) {
		if ( root == null || size <= index ) {
			throw new NullPointerException();
		}
		Node<E> now = root;
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
	 * このAVL木に引数が存在すれば削除します。
	 * @param x
	 * @return
	 */
	public boolean remove ( final E x ) {
		final Node<E> n = getNode( x );
		if ( n == null ) {
			return false;
		}
		--size;
		hash ^= n.value.hashCode();
		delete( n );
		return true;
	}

	/**
	 * 引数のNodeを削除します。
	 * @param node
	 */
	private void delete ( final Node<E> node ) {
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
					final Node<E> rep = getFirstNode( node.right );
					node.value = rep.value;
					delete( rep );
				}
				else {
					final Node<E> rep = node.left != null ? node.left : node.right;
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
	 * 引数をvalueに持ったNodeクラスを探します。
	 * @param x
	 * @return
	 */
	private Node<E> getNode ( final E x ) {
		Node<E> now = root;
		while ( now != null ) {
			final int result = x.compareTo( now.value );
			if ( result < 0 ) {
				now = now.left;
			}
			else if ( result > 0 ) {
				now = now.right;
			}
			else {
				break;
			}
		}
		return now;
	}

	/**
	 * このAVL木の最小の要素を返します。
	 * @return
	 */
	public E first () {
		if ( root == null ) {
			return null;
		}
		return getFirstNode( root ).value;
	}

	/**
	 * 引数のNodeクラスを根とした部分木の最小の要素を返します。
	 * @param node
	 * @return
	 */
	private Node<E> getFirstNode ( Node<E> node ) {
		assert node != null;
		Node<E> par = null;
		while ( node != null ) {
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * このAVL木の最大の要素を返します。
	 * @param node
	 * @return
	 */
	public E last () {
		if ( root == null ) {
			return null;
		}
		return getLastNode( root ).value;
	}

	/**
	 * 引数のNodeクラスを根とした部分木の最大の要素を返します。
	 * @param node
	 * @return
	 */
	private Node<E> getLastNode ( Node<E> node ) {
		assert node != null;
		Node<E> par = null;
		while ( node != null ) {
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 引数が存在するか調べます。
	 * @param x
	 * @return
	 */
	public boolean contains ( final E x ) {
		if ( root == null ) {
			return false;
		}
		return getNode( x ) != null;
	}

	/**
	 * このAVL木の最小の要素を取り出して削除します。
	 * @return
	 */
	public E pollFirst () {
		if ( root == null ) {
			return null;
		}
		--size;
		final Node<E> min = getFirstNode( root );
		hash ^= min.value.hashCode();
		delete( min );
		return min.value;
	}

	/**
	 * このAVL木の最大の要素を取り出して削除します。
	 * @return
	 */
	public E pollLast () {
		if ( root == null ) {
			return null;
		}
		--size;
		final Node<E> max = getLastNode( root );
		hash ^= max.value.hashCode();
		delete( max );
		return max.value;
	}

	/**
	 * 引数と等価か引数よりも大きい要素で最小の要素を返します。
	 * @param x
	 * @return
	 */
	public E ceiling ( final E x ) {
		return ceiling( root, x );
	}

	/**
	 * 引数と等価か引数よりも大きい要素で最小の要素を返します。
	 * @param x
	 * @return
	 */
	private E ceiling ( Node<E> node, final E x ) {
		Node<E> ans = null;
		while ( node != null ) {
			final int result = x.compareTo( node.value );
			if ( result > 0 ) {
				node = node.right;
			}
			else if ( result < 0 ) {
				ans = node;
				node = node.left;
			}
			else {
				return x;
			}
		}
		return ans != null ? ans.value : null;
	}

	/**
	 * 引数よりも大きい要素で最小の要素を返します。
	 * @param x
	 * @return
	 */
	public E higher ( final E x ) {
		return higher( root, x );
	}

	/**
	 * 引数よりも大きい要素で最小の要素を返します。
	 * @param x
	 * @return
	 */
	private E higher ( Node<E> node, final E x ) {
		Node<E> ans = null;
		while ( node != null ) {
			final int result = x.compareTo( node.value );
			if ( result >= 0 ) {
				node = node.right;
			}
			else {
				ans = node;
				node = node.left;
			}
		}
		return ans != null ? ans.value : null;
	}

	/**
	 * 引数と等価か引数よりも小さい要素で最大の要素を返します。
	 * @param x
	 * @return
	 */
	public E floor ( final E x ) {
		return floor( root, x );
	}

	/**
	 * 引数と等価か引数よりも小さい要素で最大の要素を返します。
	 * @param x
	 * @return
	 */
	private E floor ( Node<E> node, final E x ) {
		Node<E> ans = null;
		while ( node != null ) {
			final int result = x.compareTo( node.value );
			if ( result < 0 ) {
				node = node.left;
			}
			else if ( result > 0 ) {
				ans = node;
				node = node.right;
			}
			else {
				return x;
			}
		}
		return ans != null ? ans.value : null;
	}

	/**
	 * 引数よりも小さい要素で最大の要素を返します。
	 * @param x
	 * @return
	 */
	public E lower ( final E x ) {
		return lower( root, x );
	}

	/**
	 * 引数よりも小さい要素で最大の要素を返します。
	 * @param x
	 * @return
	 */
	private E lower ( Node<E> node, final E x ) {
		Node<E> ans = null;
		while ( node != null ) {
			final int result = x.compareTo( node.value );
			if ( result <= 0 ) {
				node = node.left;
			}
			else {
				ans = node;
				node = node.right;
			}
		}
		return ans != null ? ans.value : null;
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
	 * このAVL木に含まれる要素数を返します。
	 * @return
	 */
	public int size () {
		return size;
	}

	/**
	 * このAVL木に含まれる要素をArrayListにして返します。
	 * 順番は昇順であることが保証されます。
	 * @return
	 */
	public ArrayList<E> toList () {
		final ArrayList<E> list = new ArrayList<>();
		if ( root != null ) {
			final ArrayDeque<Node<E>> deq = new ArrayDeque<>();
			deq.add( root );
			while ( !deq.isEmpty() ) {
				final Node<E> now = deq.pollLast();
				if ( list.size() == 0 ) {
					if ( now.left != null ) {
						deq.add( now );
						deq.add( now.left );
					}
					else {
						list.add( now.value );
						if ( now.right != null ) {
							deq.add( now.right );
						}
					}
				}
				else if ( now.left != null && list.get( list.size() - 1 ).compareTo( now.left.value ) < 0 ) {
					deq.add( now );
					deq.add( now.left );
				}
				else {
					list.add( now.value );
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
	 * このメソッドはtree.toList().toString()と等価です。
	 */
	@Override
	public String toString () {
		final ArrayList<E> list = toList();
		return list.toString();
	}

	/**
	 * このAVL木と引数のObjectが等価か調べます。
	 */
	@Override
	public boolean equals ( final Object o ) {
		if ( o instanceof final Tree<?> tree ) {
			if ( size == tree.size() ) {
				return false;
			}
			final ArrayList<E> list1 = toList();
			final ArrayList<?> list2 = tree.toList();
			for ( int i = 0; i < size; ++i ) {
				if ( !list1.get( i ).equals( list2.get( i ) ) ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このAVL木を表すハッシュ値を返します。
	 */
	@Override
	public int hashCode () {
		return hash;
	}

	/*
	 * 以下、平衡用メソッド
	 */

	/**
	 * 節の情報を更新します。
	 * @param node
	 */
	private void fix ( Node<E> node ) {
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
	 * 右回転をします。
	 * @param node
	 */
	private void rotateR ( final Node<E> node ) {
		final Node<E> temp = node.left;
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
	 * 左回転をします。
	 * @param node
	 */
	private void rotateL ( final Node<E> node ) {
		final Node<E> temp = node.right;
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
	 * 部分木の高さや要素数の情報を更新します。
	 * @param node
	 */
	private void setStates ( final Node<E> node ) {
		final int lh = node.left != null ? node.left.height : 0;
		final int rh = node.right != null ? node.right.height : 0;
		node.height = Math.max( lh, rh ) + 1;
		final int ls = node.left != null ? node.left.size : 0;
		final int rs = node.right != null ? node.right.size : 0;
		node.size = ls + rs + 1;
	}
}
