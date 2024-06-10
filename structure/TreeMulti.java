package structure;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Treemultiクラスです。
 * java.util.TreeSetと基本変わりませんが、インデックスを指定してのアクセスがO(log N)で可能です。
 * また、同等な要素を複数追加することができます。
 * 同等な要素は最初に追加した要素と等価として管理するので、
 * 別々に管理したい場合は順序を付けるようにしてください。
 *
 * @param <E> TreeMultiに載せる要素の型
 */
public final class TreeMulti<E extends Comparable<E>>{

	/**
	 * このTreeMultiの根となるNodeインスタンスを保持する変数です。
	 */
	private Node root;

	/**
	 * このTreeMultiの要素数を保持する変数です。
	 */
	private long size;

	/**
	 * このTreeMultiのユニークな要素数を保持する変数です。
	 */
	private int uniqueSize;

	/**
	 * このTreeMultiのハッシュ値を保持する変数です。
	 */
	private int hash;

	/**
	 * 空のTreeMultiを生成します。
	 */
	public TreeMulti(){
		size = 0;
		uniqueSize = 0;
		root = null;
		hash = 0;
	}

	/**
	 * 要素を保持するためのNodeクラスです。
	 */
	final private class Node{

		/**
		 * このNodeクラスが保持する要素です。
		 */
		E value;

		/**
		 * 状態管理用の変数です。
		 */
		long count, size;
		int height;

		/**
		 * 親、左右の子を保持する変数です。
		 */
		Node left, right, parent;

		/**
		 * 指定された情報を元にNodeインスタンスを生成します。
		 * 
		 * @param p 親となるNodeインスタンス
		 * @param v 要素
		 * @param c 要素数
		 */
		public Node(final Node p,final E v,final long c){
			value = v;
			parent = p;
			count = c;
			height = 1;
			size = c;
		}
	}

	/**
	 * 指定された要素を追加します。
	 * 
	 * @param x 追加する要素
	 */
	public void add(final E x){
		if(root==null){
			root = new Node(null,x,1);
			++uniqueSize;
		}
		else{
			Node par;
			Node now = root;
			boolean bool = true;
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
					++now.count;
					break;
				}
			}
			while(now!=null);
			if(bool){
				++uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x,1);
				}
				else{
					par.right = new Node(par,x,1);
				}
			}
			fix(par);
		}
		++size;
		hash ^= x.hashCode();
	}

	/**
	 * 指定された要素を引数の値だけ追加します。
	 * 
	 * @param x 追加する要素
	 * @param sum 追加する個数
	 */
	public void add(final E x,final long sum){
		if(root==null){
			root = new Node(null,x,sum);
			++uniqueSize;
		}
		else{
			Node par;
			Node now = root;
			boolean bool = true;
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
					now.count += sum;
					fix(now);
					break;
				}
			}
			while(now!=null);
			if(bool){
				++uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x,sum);
				}
				else{
					par.right = new Node(par,x,sum);
				}
				fix(par);
			}
		}
		size += sum;
		hash ^= sum%2==1?x.hashCode():0;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * これはユニークな要素数ではなく全体の要素数でのインデックスです。
	 * 
	 * @param index 取得する要素のインデックス
	 * @return 指定されたインデックスの要素
	 */
	public E get(long index){
		if(root==null||size<=index){
			throw new NullPointerException();
		}
		Node now = root;
		while(true){
			assert now!=null;
			final long ls = now.left!=null?now.left.size:0;
			if(index<ls){
				now = now.left;
			}
			else if(ls+now.count<=index){
				index -= ls+now.count;
				now = now.right;
			}
			else{
				break;
			}
		}
		return now.value;
	}

	/**
	 * 指定された要素を一つだけ削除しようと試みます。
	 * 
	 * @param x 削除する要素
	 * @return 指定された要素が一つだけ削除されたらtrue、それ以外はfalse
	 */
	public boolean remove(final E x){
		final Node n = getNode(x);
		if(n==null){
			return false;
		}
		--size;
		hash ^= n.hashCode();
		delete(n);
		return true;
	}

	/**
	 * 指定された要素を指定した個数分削除します。
	 * もし指定された個数だけ存在しない場合は削除できるだけ削除します。
	 * 
	 * @param x 削除する要素
	 * @param sum 削除したい個数
	 * @return 削除に成功した個数
	 */
	public long remove(final E x,final long sum){
		final Node n = getNode(x);
		if(n==null){
			return 0;
		}
		final long ans = Math.min(sum,n.count);
		size -= ans;
		hash ^= ans%2==1?n.hashCode():0;
		n.count -= ans-1;
		delete(n);
		return ans;
	}

	/**
	 * 指定された要素を全て削除します。
	 * 
	 * @param x 削除する要素
	 * @return 削除した個数
	 */
	public long removeAll(final E x){
		final Node n = getNode(x);
		if(n==null){
			return 0;
		}
		size -= n.count;
		final long ans = n.count;
		hash ^= ans%2==1?n.hashCode():0;
		n.count = 0;
		delete(n);
		return ans;
	}

	/**
	 * 指定されたNodeインスタンスを削除します。
	 * 
	 * @param node 削除するNodeインスタンス
	 */
	private void delete(final Node node){
		if(node!=null){
			if(node.count>1){
				--node.count;
				fix(node);
				return;
			}
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
				--uniqueSize;
			}
			else{
				if(node.left!=null&&node.right!=null){
					final Node rep = getFirstNode(node.right);
					node.value = rep.value;
					node.count = rep.count;
					rep.count = 0;
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
					--uniqueSize;
				}
			}
		}
	}

	/**
	 * 指定された要素を保持するNodeインスタンスを返します。
	 * そのようなNodeインスタンスが存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xを保持するNodeインスタンス
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
	 * このTreeMultiの先頭の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeMultiの先頭の要素
	 */
	public E first(){
		if(root==null){
			return null;
		}
		return getFirstNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の先頭の要素を保持するNodeインスタンスを返します。
	 * このNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return 先頭の要素を保持するNodeインスタンス
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
	 * このTreeMultiインスタンスの末尾の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeMultiインスタンスの末尾の要素
	 */
	public E last(){
		if(root==null){
			return null;
		}
		return getLastNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の末尾の要素を保持するNodeインスタンスを返します。
	 * このNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return 末尾の要素を保持するNodeインスタンス
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
	 * 指定された要素がこのTreeMultiインスタンスに存在するか判定します。
	 * 
	 * @param x 探索対象
	 * @return このTreeMultiインスタンスに指定された要素が存在するならtrue、それ以外はfalse
	 */
	public boolean contains(final E x){
		if(root==null){
			return false;
		}
		return getNode(x)!=null;
	}

	/**
	 * 指定された要素がこのTreeMultiインスタンスにいくつ存在するか返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素がこのTreeMultiインスタンスに存在する個数
	 */
	public long sum(final E x){
		if(root==null){
			return 0;
		}
		Node node = getNode(x);
		return node!=null?node.count:0;
	}

	/**
	 * このTreeMultiインスタンスの先頭の要素を取得し、削除します。
	 * 
	 * @return このTreeMultiインスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(root==null){
			return null;
		}
		--size;
		final Node min = getFirstNode(root);
		hash ^= min.value.hashCode();
		final E ans = min.value;
		delete(min);
		return ans;
	}

	/**
	 * このTreeMultiインスタンスの末尾の要素を取得し、削除します。
	 * 
	 * @return このTreeMultiインスタンスの末尾の要素
	 */
	public E pollLast(){
		if(root==null){
			return null;
		}
		--size;
		final Node max = getLastNode(root);
		hash ^= max.value.hashCode();
		final E ans = max.value;
		delete(max);
		return ans;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
	 */
	public E ceiling(final E x){
		return ceiling(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
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
	 * 指定された要素以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素以降の要素で最小のもの
	 */
	public E higher(final E x){
		return higher(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素以降の要素で最小のもの
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
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
	 */
	public E floor(final E x){
		return floor(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
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
	 * 指定された要素以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素以前の要素で最大のもの
	 */
	public E lower(final E x){
		return lower(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素以前の要素で最大のもの
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
	 * このTreeMultiインスタンスのユニークな要素数を返します。
	 * 
	 * @return このTreeMultiインスタンスのユニークな要素数
	 */
	public int size(){
		return uniqueSize;
	}

	/**
	 * このTreeMultiインスタンスの要素数を返します。
	 * 
	 * @return このTreeMultiインスタンスの要素数
	 */
	public long sumSize(){
		return size;
	}

	/**
	 * このTreeMultiインスタンスと同等なArrayListを返します。
	 * このArrayListの要素とTreeMultiインスタンスの要素は連動しています。
	 * 
	 * @return このTreeMultiインスタンスと等価なArrayList
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
						for(int i = 0;i<now.count;++i){
							list.add(now.value);
						}
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
					for(int i = 0;i<now.count;++i){
						list.add(now.value);
					}
					if(now.right!=null){
						deq.add(now.right);
					}
				}
			}
		}
		return list;
	}

	/**
	 * このTreeMultiインスタンスを表すStringを返します。
	 */
	@Override public String toString(){
		final ArrayList<E> list = toList();
		return list.toString();
	}

	/**
	 * このTreeMultiインスタンスと等価か判定します。
	 */
	@Override public boolean equals(final Object o){
		if(o instanceof final TreeMulti<?> tree){
			if(size!=tree.size()){
				return false;
			}
			final ArrayList<E> array1 = toList();
			final ArrayList<?> array2 = tree.toList();
			for(int i = 0;i<size;++i){
				if(!array1.get(i).equals(array2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このTreeMultiインスタンスを表すハッシュ値を返します。
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
					setStates(node.left);
				}
				rotateR(node);
			}
			else if(rh-lh>1){
				assert node.right!=null;
				if(node.right.left!=null&&node.right.left.height==rh-1){
					rotateR(node.right);
					setStates(node.right);
				}
				rotateL(node);
			}
			setStates(node);
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
	 * 指定されたNodeインスタンスの状態を更新します。
	 * 
	 * @param node 更新対象のNodeインスタンス
	 */
	private void setStates(final Node node){
		final int lh = node.left!=null?node.left.height:0;
		final int rh = node.right!=null?node.right.height:0;
		node.height = Math.max(lh,rh)+1;
		final long ls = node.left!=null?node.left.size:0;
		final long rs = node.right!=null?node.right.size:0;
		node.size = ls+rs+node.count;
	}
}
