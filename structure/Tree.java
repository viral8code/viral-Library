package structure;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Treeクラスです。
 * java.util.TreeSetと基本変わりませんが、インデックスを指定してのアクセスがO(log N)で可能です。
 *
 * @param <E> Treeに載せる要素の型
 */
public final class Tree<E extends Comparable<E>>{

	/**
	 * 根を表すNodeです。
	 */
	private Node root;

	/**
	 * 状態管理用の変数です。
	 */
	private int size, hash;

	/**
	 * 空のTreeクラスを生成します。
	 */
	public Tree(){
		size = 0;
		root = null;
		hash = 0;
	}

	/**
	 * 要素を保持するNodeクラスです。
	 */
	final private class Node{

		/**
		 * このNodeインスタンスが持つ要素です。
		 */
		E value;

		/**
		 * 状態管理用の変数です。
		 */
		int height, size;

		/**
		 * 親、左右のNodeを保持する変数です。
		 */
		Node left, right, parent;

		/**
		 * 指定された情報を元にNodeインスタンスを生成します。
		 * 
		 * @param p 親となるNodeインスタンス
		 * @param v 要素
		 */
		public Node(final Node p,final E v){
			value = v;
			parent = p;
			height = 1;
			size = 1;
		}
	}

	/**
	 * 引数の要素をこのTreeインスタンスに追加しようと試みます。
	 * 
	 * @param x 追加する要素
	 * @return 追加されたらtrue、それ以外はfalse
	 */
	public boolean add(final E x){
		boolean bool = true;
		if(root==null){
			root = new Node(null,x);
		}
		else{
			Node par;
			Node now = root;
			do{
				par = now;
				final int result = x.compareTo(now.value);
				if(result<0){
					now = now.left;
				}
				else if(result>0){
					now = now.right;
				}
				else{
					bool = false;
					break;
				}
			}
			while(now!=null);
			if(bool){
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x);
				}
				else{
					par.right = new Node(par,x);
				}
				fix(par);
			}
		}
		if(bool){
			++size;
			hash ^= x.hashCode();
		}
		return bool;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * 
	 * @param index インデックス
	 * @return 先頭からindex番目の要素
	 */
	public E get(int index){
		if(root==null||size<=index){
			throw new NullPointerException();
		}
		Node now = root;
		while(true){
			assert now!=null;
			final int ls = now.left!=null?now.left.size:0;
			if(index<ls){
				now = now.left;
			}
			else if(ls<index){
				now = now.right;
				index -= ls+1;
			}
			else{
				break;
			}
		}
		return now.value;
	}

	/**
	 * 引数の要素を削除しようと試みます。
	 * 
	 * @param x 削除する要素
	 * @return 要素が削除できたらtrue、それ以外はfalse
	 */
	public boolean remove(final E x){
		final Node n = getNode(x);
		if(n==null){
			return false;
		}
		--size;
		hash ^= n.value.hashCode();
		delete(n);
		return true;
	}

	/**
	 * 引数のNodeインスタンスを削除します。
	 * 
	 * @param node 削除対象
	 */
	private void delete(final Node node){
		if(node!=null){
			if(node.left==null&&node.right==null){
				if(node.parent!=null){
					if(node.parent.left==node){
						node.parent.left = null;
					}
					else{
						node.parent.right = null;
					}
					fix(node.parent);
				}
				else{
					root = null;
				}
				node.parent = null;
			}
			else{
				if(node.left!=null&&node.right!=null){
					final Node rep = getFirstNode(node.right);
					node.value = rep.value;
					delete(rep);
				}
				else{
					final Node rep = node.left!=null?node.left:node.right;
					rep.parent = node.parent;
					if(node.parent!=null){
						if(node.parent.left==node){
							node.parent.left = rep;
						}
						else{
							node.parent.right = rep;
						}
						fix(node.parent);
					}
					else{
						root = rep;
					}
					node.parent = null;
				}
			}
		}
	}

	/**
	 * 指定された要素を持つNodeインスタンスを返します。
	 * 無い場合はnullを返します。
	 * 
	 * @param x 指定する要素
	 * @return 指定された要素を持つNodeインスタンス
	 */
	private Node getNode(final E x){
		Node now = root;
		while(now!=null){
			final int result = x.compareTo(now.value);
			if(result<0){
				now = now.left;
			}
			else if(result>0){
				now = now.right;
			}
			else{
				break;
			}
		}
		return now;
	}

	/**
	 * このTreeインスタンスの先頭の要素を返します。
	 * もしこのTreeインスタンスが空ならnullを返します。
	 * 
	 * @return このTreeインスタンスの先頭の要素
	 */
	public E first(){
		if(root==null){
			return null;
		}
		return getFirstNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の先頭の要素を持つNodeインスタンスを返します。
	 * 指定するNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return この部分木の先頭の要素を持つNodeインスタンス
	 */
	private Node getFirstNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * このTreeインスタンスの末尾の要素を返します。
	 * もしそのような要素が存在しない場合はnullを返します。
	 * 
	 * @return このTreeインスタンスの末尾の要素
	 */
	public E last(){
		if(root==null){
			return null;
		}
		return getLastNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の末尾の要素を持つNodeインスタンスを返します。
	 * 指定するNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return この部分木の末尾の要素を持つNodeインスタンス
	 */
	private Node getLastNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 指定された要素がこのTreeインスタンスに存在するか判定します。
	 * 
	 * @param x 探索対象の要素
	 * @return 指定された要素が存在するならtrue、それ以外はfalse
	 */
	public boolean contains(final E x){
		if(root==null){
			return false;
		}
		return getNode(x)!=null;
	}

	/**
	 * このTreeインスタンスの先頭の要素を取得し、削除します。
	 * もしそのような要素が存在しない場合はnullを返します。
	 * 
	 * @return このTreeインスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(root==null){
			return null;
		}
		--size;
		final Node min = getFirstNode(root);
		hash ^= min.value.hashCode();
		delete(min);
		return min.value;
	}

	/**
	 * このTreeインスタンスの末尾の要素を取得し、削除します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeインスタンスの末尾の要素
	 */
	public E pollLast(){
		if(root==null){
			return null;
		}
		--size;
		final Node max = getLastNode(root);
		hash ^= max.value.hashCode();
		delete(max);
		return max.value;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xと同等かそれ以降の要素で最小の要素
	 */
	public E ceiling(final E x){
		return ceiling(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * xと同等かそれ以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return xと同等かそれ以降の要素で最小の要素
	 */
	private E ceiling(Node node,final E x){
		Node ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>0){
				node = node.right;
			}
			else if(result<0){
				ans = node;
				node = node.left;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return x以降の要素で最小の要素
	 */
	public E higher(final E x){
		return higher(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * x以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return x以降の要素で最小の要素
	 */
	private E higher(Node node,final E x){
		Node ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>=0){
				node = node.right;
			}
			else{
				ans = node;
				node = node.left;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素と同等かそれ以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xと同等かそれ以前の要素で最大の要素
	 */
	public E floor(final E x){
		return floor(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * xと同等かそれ以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return xと同等かそれ以前の要素で最大の要素
	 */
	private E floor(Node node,final E x){
		Node ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<0){
				node = node.left;
			}
			else if(result>0){
				ans = node;
				node = node.right;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return x以前の要素で最大の要素
	 */
	public E lower(final E x){
		return lower(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * x以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return x以前の要素で最大の要素
	 */
	private E lower(Node node,final E x){
		Node ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<=0){
				node = node.left;
			}
			else{
				ans = node;
				node = node.right;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * このTreeインスタンスを空にします。
	 */
	public void clear(){
		root = null;
		size = 0;
		hash = 0;
	}

	/**
	 * このTreeインスタンスが空か判定します。
	 * 
	 * @return このTreeインスタンスが空ならtrue、それ以外はfalse
	 */
	public boolean isEmpty(){
		return size==0;
	}

	/**
	 * このTreeインスタンスの要素数を返します。
	 * 
	 * @return このTreeインスタンスの要素数
	 */
	public int size(){
		return size;
	}

	/**
	 * このTreeインスタンスと同等なArrayListを返します。
	 * 各要素はTreeインスタンスの要素と連動します。
	 * 
	 * @return このTreeインスタンスを表すArrayList
	 */
	public ArrayList<E> toList(){
		final ArrayList<E> list = new ArrayList<>();
		if(root!=null){
			final ArrayDeque<Node> deq = new ArrayDeque<>();
			deq.add(root);
			while(!deq.isEmpty()){
				final Node now = deq.pollLast();
				if(list.size()==0){
					if(now.left!=null){
						deq.add(now);
						deq.add(now.left);
					}
					else{
						list.add(now.value);
						if(now.right!=null){
							deq.add(now.right);
						}
					}
				}
				else if(now.left!=null&&list.get(list.size()-1).compareTo(now.left.value)<0){
					deq.add(now);
					deq.add(now.left);
				}
				else{
					list.add(now.value);
					if(now.right!=null){
						deq.add(now.right);
					}
				}
			}
		}
		return list;
	}

	/**
	 * このTreeインスタンスを表すStringを返します。
	 */
	@Override public String toString(){
		final ArrayList<E> list = toList();
		return list.toString();
	}

	/**
	 * 引数がこのTreeインスタンスと同等か判定します。
	 */
	@Override public boolean equals(final Object o){
		if(o instanceof final Tree<?> tree){
			if(size!=tree.size()){
				return false;
			}
			final ArrayList<E> list1 = toList();
			final ArrayList<?> list2 = tree.toList();
			for(int i = 0;i<size;++i){
				if(!list1.get(i).equals(list2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このTreeを表すハッシュ値を返します。
	 */
	@Override public int hashCode(){
		return hash;
	}

	/**
	 * 指定されたNodeインスタンスを根の方向に辿りながら平衡を修正します。
	 * 
	 * @param node 始点となるNodeインスタンス
	 */
	private void fix(Node node){
		while(node!=null){
			final int lh = node.left==null?0:node.left.height;
			final int rh = node.right==null?0:node.right.height;
			if(lh-rh>1){
				assert node.left!=null;
				if(node.left.right!=null&&node.left.right.height==lh-1){
					rotateL(node.left);
				}
				rotateR(node);
			}
			else if(rh-lh>1){
				assert node.right!=null;
				if(node.right.left!=null&&node.right.left.height==rh-1){
					rotateR(node.right);
				}
				rotateL(node);
			}
			else{
				setStates(node);
			}
			node = node.parent;
		}
	}

	/**
	 * 指定されたNodeインスタンスを基点に右回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateR(final Node node){
		final Node temp = node.left;
		node.left = temp.right;
		if(node.left!=null){
			node.left.parent = node;
		}
		temp.right = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスを基点に左回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateL(final Node node){
		final Node temp = node.right;
		node.right = temp.left;
		if(node.right!=null){
			node.right.parent = node;
		}
		temp.left = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスの内部情報を更新します。
	 * 
	 * @param node 更新対象のNodeインスタンス
	 */
	private void setStates(final Node node){
		final int lh = node.left!=null?node.left.height:0;
		final int rh = node.right!=null?node.right.height:0;
		node.height = Math.max(lh,rh)+1;
		final int ls = node.left!=null?node.left.size:0;
		final int rs = node.right!=null?node.right.size:0;
		node.size = ls+rs+1;
	}
}
