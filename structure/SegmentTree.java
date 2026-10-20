package structure;

import java.util.Arrays;

/**
 * SegmentTree クラスです。<br/>
 * 載せる演算は function メソッドを定義して使用して下さい。
 *
 * @param <E> 演算を適用する要素の型
 */
public abstract class SegmentTree<E>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int size, offSet;

	/**
	 * この SegmentTree の単位元です。
	 */
	private final E def;

	/**
	 * この SegmentTree を表すテーブルです。
	 */
	private final Object[] node;

	/**
	 * 大きさ n の、単位元が def である SegmentTree を構築します。
	 *
	 * @param n 扱う範囲
	 * @param defaultValue 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが 1-indexed か
	 */
	protected SegmentTree(final int n,final E defaultValue,final boolean is1indexed){
		int num = 2;
		while(num<n<<1){
			num <<= 1;
		}
		this.size = num;
		this.offSet = (num>>1)-(is1indexed?1:0);
		this.node = new Object[this.size];
		this.def = defaultValue;
		Arrays.fill(this.node,this.def);
	}

	/**
	 * 引数の配列を元に、単位元が def である SegmentTree を構築します。<br/>
	 * 浅いコピーなので、引数の配列の要素に変更を加えたときの動作は保証されません。
	 *
	 * @param arr 元となる配列
	 * @param defaultValue 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが 1-indexed か
	 */
	protected SegmentTree(final E[] arr,final E defaultValue,final boolean is1indexed){
		int num = 2;
		while(num<arr.length<<1){
			num <<= 1;
		}
		this.size = num;
		this.offSet = (num>>1)-(is1indexed?1:0);
		this.node = new Object[this.size];
		this.def = defaultValue;
		System.arraycopy(arr,0,this.node,this.size>>1,arr.length);
		for(int i=arr.length+(this.size>>1);i<this.size;i++){
			this.node[i] = defaultValue;
		}
		this.updateAll();
	}

	/**
	 * 大きさ n、単位元が def の SegmentTree を構築します。
	 * 各メソッドに渡すインデックスは 0-indexed であることが要求されます。
	 *
	 * @param n 大きさ
	 * @param defaultValue 単位元
	 */
	protected SegmentTree(final int n,final E defaultValue){
		this(n,defaultValue,false);
	}

	/**
	 * この SegmentTree のテーブルを一括で更新します。
	 */
	@SuppressWarnings("unchecked")
	private void updateAll(){
		for(int i=(this.size>>1)-1;i>0;i--){
			this.node[i] = this.function((E)this.node[i<<1],(E)this.node[(i<<1)+1]);
		}
	}

	/**
	 * 引数の位置の値を引数の値で上書きします。
	 *
	 * @param n インデックス
	 * @param value 上書きする値
	 */
	@SuppressWarnings("unchecked")
	public final void update(int n,final E value){
		n += this.offSet;
		this.node[n] = value;
		n >>= 1;
		while(n>0){
			this.node[n] = this.function((E)this.node[n<<1],(E)this.node[(n<<1)+1]);
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
	@SuppressWarnings("unchecked")
	public final E get(final int a){
		return (E)this.node[a+this.offSet];
	}

	/**
	 * この SegmentTree 上の要素全てに function を適用した結果を返します。
	 *
	 * @return 要素全てに function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final E answer(){
		return (E)this.node[1];
	}

	/**
	 * 引数の区間の要素に function を適用した結果を返します。<br/>
	 * 閉区間であることに注意して下さい。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 *
	 * @return [left,right] の要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final E query(int left,int right){
		left += this.offSet;
		right += this.offSet;
		E sumL = this.def;
		E sumR = this.def;
		while(left>0&&right>0&&left<=right){
			if((left&1)==1){
				sumL = this.function(sumL,(E)this.node[left]);
				left += 1;
			}
			if((right&1)==0){
				sumR = this.function((E)this.node[right],sumR);
				right -= 1;
			}
			left >>= 1;
			right >>= 1;
		}
		return this.function(sumL,sumR);
	}

	/**
	 * この SegmentTree 上で適用する関数を定義したメソッドです。
	 *
	 * @param value1 要素1
	 * @param value2 要素2
	 *
	 * @return value1 と value2 に関数を適用した結果
	 */
	abstract public E function(E value1,E value2);

	/**
	 * この LazySegmentTree を表す文字列を返します。
	 *
	 * @return この LazySegmentTree を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "SegmentTree["+this.hashCode()+"]";
	}
}
