package structure;

import java.util.Arrays;

/**
 * SegmentTreeクラスです。
 * 載せる演算はfunctionメソッドを定義して使用して下さい。
 *
 * @param <E> 演算を適用する要素の型
 */
@SuppressWarnings("unchecked")
public abstract class SegmentTree<E>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int N, size;

	/**
	 * このSegmentTreeの単位元です。
	 */
	private final E def;

	/**
	 * このSegmentTreeを表すテーブルです。
	 */
	private final Object[] node;

	/**
	 * 大きさnの、単位元がdefであるSegmentTreeを構築します。
	 *
	 * @param n 扱う範囲
	 * @param def 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが1-indexedか
	 */
	public SegmentTree(final int n,final E def,final boolean is1indexed){
		int num = 2;
		while(num<n<<1){
			num <<= 1;
		}
		N = num;
		size = (num>>1)-(is1indexed?1:0);
		node = new Object[N];
		this.def = def;
		Arrays.fill(node,this.def);
	}

	/**
	 * 引数の配列を元に、単位元がdefであるSegmentTreeを構築します。
	 * 浅いコピーなので、引数の配列の要素に変更を加えたときの動作は保証されません。
	 *
	 * @param arr 　元となる配列
	 * @param def 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが1-indexedか
	 */
	public SegmentTree(final E[] arr,final E def,final boolean is1indexed){
		int num = 2;
		while(num<arr.length<<1){
			num <<= 1;
		}
		N = num;
		size = num>>1-(is1indexed?1:0);
		node = new Object[N];
		this.def = def;
		System.arraycopy(arr,0,node,N>>1,arr.length);
		for(int i = arr.length+(N>>1);i<N;i++){
			node[i] = def;
		}
		updateAll();
	}

	/**
	 * 大きさn、単位元がdefのSegmentTreeを構築します。
	 * 各メソッドに渡すインデックスは0-indexedであることが要求されます。
	 *
	 * @param n 大きさ
	 * @param def 単位元
	 */
	public SegmentTree(final int n,final E def){
		this(n,def,false);
	}

	/**
	 * このSegmentTreeのテーブルを一括で更新します。
	 */
	private void updateAll(){
		for(int i = (N>>1)-1;i>0;i--){
			node[i] = function((E)node[i<<1],(E)node[(i<<1)+1]);
		}
	}

	/**
	 * 引数の位置の値を引数の値で上書きします。
	 *
	 * @param n インデックス
	 * @param value 上書きする値
	 */
	public void update(int n,final E value){
		n += size;
		node[n] = value;
		n >>= 1;
		while(n>0){
			node[n] = function((E)node[n<<1],(E)node[(n<<1)+1]);
			n >>= 1;
		}
	}

	/**
	 * 引数の位置の要素を返します。
	 *
	 * @param a インデックス
	 *
	 * @return 引数の位置の要素
	 */
	public E get(final int a){
		return (E)node[a+size];
	}

	/**
	 * このSegmentTree上の要素全てにfunctionを適用した結果を返します。
	 *
	 * @return 要素全てにfunctionを適用した結果
	 */
	public E answer(){
		return (E)node[1];
	}

	/**
	 * 引数の区間の要素にfunctionを適用した結果を返します。
	 * 閉区間であることに注意して下さい。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含む)
	 *
	 * @return [l,r]の要素にfunctionを適用した結果
	 */
	public E query(int l,int r){
		l += size;
		r += size;
		E answer = def;
		while(l>0&&r>0&&l<=r){
			if(l%2==1){
				answer = function((E)node[l++],answer);
			}
			l >>= 1;
			if(r%2==0){
				answer = function(answer,(E)node[r--]);
			}
			r >>= 1;
		}
		return answer;
	}

	/**
	 * このSegmentTree上で適用する関数を定義したメソッドです。
	 *
	 * @param a 要素1
	 * @param b 要素2
	 *
	 * @return aとbに関数を適用した結果
	 */
	abstract public E function(E a,E b);
}
