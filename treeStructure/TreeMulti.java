package treeStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;

public final class TreeMulti<E extends Comparable<E>> {
	private Node<E> root;
	private long size;
	private int uniqueSize;
	private int hash;

	public TreeMulti () {
		size = 0;
		uniqueSize = 0;
		root = null;
		hash = 0;
	}

	static final private class Node<E> {
		E value;
		long count, size;
		int height;
		Node<E> left, right, parent;

		public Node ( final Node<E> p, final E v, final long c ) {
			value = v;
			parent = p;
			count = c;
			height = 1;
			size = c;
		}
	}

	public void add ( final E x ) {
		if ( root == null ) {
			root = new Node<>( null, x, 1 );
			++uniqueSize;
		}
		else {
			Node<E> par;
			Node<E> now = root;
			boolean bool = true;
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
					++now.count;
					break;
				}
			} while ( now != null );
			if ( bool ) {
				++uniqueSize;
				final int result = x.compareTo( par.value );
				if ( result < 0 ) {
					par.left = new Node<>( par, x, 1 );
				}
				else {
					par.right = new Node<>( par, x, 1 );
				}
			}
			fix( par );
		}
		++size;
		hash ^= x.hashCode();
	}

	public void add ( final E x, final long sum ) {
		if ( root == null ) {
			root = new Node<>( null, x, sum );
			++uniqueSize;
		}
		else {
			Node<E> par;
			Node<E> now = root;
			boolean bool = true;
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
					now.count += sum;
					fix( now );
					break;
				}
			} while ( now != null );
			if ( bool ) {
				++uniqueSize;
				final int result = x.compareTo( par.value );
				if ( result < 0 ) {
					par.left = new Node<>( par, x, sum );
				}
				else {
					par.right = new Node<>( par, x, sum );
				}
				fix( par );
			}
		}
		size += sum;
		hash ^= sum % 2 == 1 ? x.hashCode() : 0;
	}

	public E get ( long index ) {
		if ( root == null || size <= index ) {
			throw new NullPointerException();
		}
		Node<E> now = root;
		while ( true ) {
			assert now != null;
			final long ls = now.left != null ? now.left.size : 0;
			if ( index < ls ) {
				now = now.left;
			}
			else if ( ls + now.count <= index ) {
				index -= ls + now.count;
				now = now.right;
			}
			else {
				break;
			}
		}
		return now.value;
	}

	public boolean remove ( final E x ) {
		final Node<E> n = getNode( x );
		if ( n == null ) {
			return false;
		}
		--size;
		hash ^= n.hashCode();
		delete( n );
		return true;
	}

	public long remove ( final E x, final long sum ) {
		final Node<E> n = getNode( x );
		if ( n == null ) {
			return 0;
		}
		final long ans = Math.min( sum, n.count );
		size -= ans;
		hash ^= ans % 2 == 1 ? n.hashCode() : 0;
		n.count -= ans - 1;
		delete( n );
		return ans;
	}

	public long removeAll ( final E x ) {
		final Node<E> n = getNode( x );
		if ( n == null ) {
			return 0;
		}
		size -= n.count;
		final long ans = n.count;
		hash ^= ans % 2 == 1 ? n.hashCode() : 0;
		n.count = 0;
		delete( n );
		return ans;
	}

	private void delete ( final Node<E> node ) {
		if ( node != null ) {
			if ( node.count > 1 ) {
				--node.count;
				fix( node );
				return;
			}
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
				--uniqueSize;
			}
			else {
				if ( node.left != null && node.right != null ) {
					final Node<E> rep = getFirstNode( node.right );
					node.value = rep.value;
					node.count = rep.count;
					rep.count = 0;
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
					--uniqueSize;
				}
			}
		}
	}

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

	public E first () {
		if ( root == null ) {
			return null;
		}
		return getFirstNode( root ).value;
	}

	private Node<E> getFirstNode ( Node<E> node ) {
		assert node != null;
		Node<E> par = null;
		while ( node != null ) {
			par = node;
			node = par.left;
		}
		return par;
	}

	public E last () {
		if ( root == null ) {
			return null;
		}
		return getLastNode( root ).value;
	}

	private Node<E> getLastNode ( Node<E> node ) {
		assert node != null;
		Node<E> par = null;
		while ( node != null ) {
			par = node;
			node = par.right;
		}
		return par;
	}

	public boolean contains ( final E x ) {
		if ( root == null ) {
			return false;
		}
		return getNode( x ) != null;
	}

	public long sum ( final E x ) {
		if ( root == null ) {
			return 0;
		}
		Node<E> node = getNode( x );
		return node != null ? node.count : 0;
	}

	public E pollFirst () {
		if ( root == null ) {
			return null;
		}
		--size;
		final Node<E> min = getFirstNode( root );
		hash ^= min.value.hashCode();
		final E ans = min.value;
		delete( min );
		return ans;
	}

	public E pollLast () {
		if ( root == null ) {
			return null;
		}
		--size;
		final Node<E> max = getLastNode( root );
		hash ^= max.value.hashCode();
		final E ans = max.value;
		delete( max );
		return ans;
	}

	public E ceiling ( final E x ) {
		return ceiling( root, x );
	}

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

	public E higher ( final E x ) {
		return higher( root, x );
	}

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

	public E floor ( final E x ) {
		return floor( root, x );
	}

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

	public E lower ( final E x ) {
		return lower( root, x );
	}

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

	public int size () {
		return uniqueSize;
	}

	public long sumSize () {
		return size;
	}

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
						for ( int i = 0; i < now.count; ++i ) {
							list.add( now.value );
						}
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
					for ( int i = 0; i < now.count; ++i ) {
						list.add( now.value );
					}
					if ( now.right != null ) {
						deq.add( now.right );
					}
				}
			}
		}
		return list;
	}

	@Override
	public String toString () {
		final ArrayList<E> list = toList();
		return list.toString();
	}

	@Override
	public boolean equals ( final Object o ) {
		if ( o instanceof final TreeMulti<?> tree ) {
			if ( size == tree.size() ) {
				return false;
			}
			final ArrayList<E> array1 = toList();
			final ArrayList<?> array2 = tree.toList();
			for ( int i = 0; i < size; ++i ) {
				if ( !array1.get( i ).equals( array2.get( i ) ) ) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode () {
		return hash;
	}

	/*
	 * 以下、平衡用メソッド
	 */

	private void fix ( Node<E> node ) {
		while ( node != null ) {
			final int lh = node.left == null ? 0 : node.left.height;
			final int rh = node.right == null ? 0 : node.right.height;
			if ( lh - rh > 1 ) {
				assert node.left != null;
				if ( node.left.right != null && node.left.right.height == lh - 1 ) {
					rotateL( node.left );
					setStates( node.left );
				}
				rotateR( node );
			}
			else if ( rh - lh > 1 ) {
				assert node.right != null;
				if ( node.right.left != null && node.right.left.height == rh - 1 ) {
					rotateR( node.right );
					setStates( node.right );
				}
				rotateL( node );
			}
			setStates( node );
			node = node.parent;
		}
	}

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

	private void setStates ( final Node<E> node ) {
		final int lh = node.left != null ? node.left.height : 0;
		final int rh = node.right != null ? node.right.height : 0;
		node.height = Math.max( lh, rh ) + 1;
		final long ls = node.left != null ? node.left.size : 0;
		final long rs = node.right != null ? node.right.size : 0;
		node.size = ls + rs + node.count;
	}
}
