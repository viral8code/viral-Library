package structure;

import java.util.Arrays;

/**
 * LazySegmentTree クラスです。<br/>
 * 載せる演算は function メソッド、演算の合成は composition メソッド、演算の適用は mapping メソッドに定義して使用して下さい。
 *
 * @param <S> 演算を適用する要素の型
 * @param <F> 演算に使用するパラメータ
 */
public abstract class LazySegmentTree<S,F>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int offSet, log;

	/**
	 * 載せる要素の単位元です。
	 */
	private final S defaultS;

	/**
	 * 載せる演算の恒等写像です。
	 */
	private final F defaultF;

	/**
	 * 要素用のテーブルです。
	 */
	private final Object[] node;

	/**
	 * 演算用のテーブルです。
	 */
	private final Object[] lazy;

	/**
	 * 大きさ N、単位元が defaultS、恒等写像が defaultF である LazySegmentTree を構築します。<br/>
	 * 各メソッドに渡すインデックスは 0-indexed であることが要求されます。
	 *
	 * @param size 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 */
	protected LazySegmentTree(final int size,final S defS,final F defF){
		this(size,defS,defF,false);
	}

	/**
	 * 大きさ N、単位元が defaultS、恒等写像が defaultF である LazySegmentTree を構築します。
	 *
	 * @param size 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは 1-indexed か
	 */
	protected LazySegmentTree(final int size,final S defS,final F defF,final boolean is1indexed){
		this.log = 32-Integer.numberOfLeadingZeros(size-1);
		this.offSet = (1<<this.log)-(is1indexed?1:0);
		this.defaultS = defS;
		this.defaultF = defF;
		this.node = new Object[1<<this.log+1];
		this.lazy = new Object[1<<this.log+1];
		this.clear();
	}

	/**
	 * 引数の配列を元に、単位元が defaultS、恒等写像が defaultFである LazySegmentTree を構築します。
	 *
	 * @param defaultValues 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは 1-indexed か
	 */
	protected LazySegmentTree(final S[] defaultValues,final S defS,final F defF,final boolean is1indexed){
		this(defaultValues.length,defS,defF,is1indexed);
		this.updateAll(defaultValues);
	}

	/**
	 * 全ての要素を単位元に、演算を恒等写像にします。
	 */
	public final void clear(){
		Arrays.fill(this.node,this.defaultS);
		Arrays.fill(this.lazy,this.defaultF);
	}

	/**
	 * 引数の要素を元にテーブルを再構築します。
	 *
	 * @param defaultValues 元となる配列
	 */
	@SuppressWarnings("unchecked")
	private void updateAll(final S[] defaultValues){
		System.arraycopy(defaultValues,0,this.node,1<<this.log,defaultValues.length);
		for(int i=(1<<this.log)-1;i>0;i--){
			this.node[i] = this.function((S)this.node[i<<1],(S)this.node[i<<1|1]);
		}
	}

	/**
	 * 引数の位置の演算を適用し、子に伝播します。
	 *
	 * @param index 演算を適用する位置
	 */
	@SuppressWarnings("unchecked")
	private void spread(final int index){
		if(this.lazy[index]!=this.defaultF){
			final int left = index<<1;
			final int right = index<<1|1;
			this.node[left] = this.mapping((S)this.node[left],(F)this.lazy[index]);
			this.node[right] = this.mapping((S)this.node[right],(F)this.lazy[index]);
			this.lazy[left] = this.composition((F)this.lazy[left],(F)this.lazy[index]);
			this.lazy[right] = this.composition((F)this.lazy[right],(F)this.lazy[index]);
			this.lazy[index] = this.defaultF;
		}
	}

	/**
	 * 親から順に引数の位置までの演算を適用します。
	 *
	 * @param from 演算を適用する終点
	 */
	private void spreadLine(final int from){
		for(int i=this.log;i>0;i--){
			this.spread(from>>i);
		}
	}

	/**
	 * 引数の区間の演算を適用します。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含まない)
	 */
	private void spreadRange(final int left,final int right){
		for(int i=this.log;i>0;i--){
			if((left>>i<<i)!=left){
				this.spread(left>>i);
			}
			if((right>>i<<i)!=right){
				this.spread(right>>i);
			}
		}
	}

	/**
	 * 引数の位置の要素の情報を親に向かって伝播します。
	 *
	 * @param index 伝播したい要素のインデックス
	 */
	@SuppressWarnings("unchecked")
	private void update(int index){
		while(true){
			index >>= 1;
			if(index==0){
				break;
			}
			this.node[index] = this.function((S)this.node[index<<1],(S)this.node[index<<1|1]);
		}
	}

	/**
	 * 区間の要素の情報を親に向かって伝播します。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含まない)
	 */
	@SuppressWarnings("unchecked")
	private void update(final int left,final int right){
		for(int i=1;i<=this.log;i++){
			final int subL = left>>i;
			final int subR = right>>i;
			if((subL<<i)!=left){
				this.node[subL] = this.function((S)this.node[subL<<1],(S)this.node[subL<<1|1]);
			}
			if((subR<<i)!=right){
				this.node[subR] = this.function((S)this.node[subR<<1],(S)this.node[subR<<1|1]);
			}
		}
	}

	/**
	 * 引数の位置の要素を引数の値で上書きします。
	 *
	 * @param index インデックス
	 * @param x 上書きする値
	 */
	public final void update(int index,final S x){
		index += this.offSet;
		this.spreadLine(index);
		this.node[index] = x;
		this.update(index);
	}

	/**
	 * 引数の位置の要素を取得します
	 *
	 * @param index インデックス
	 *
	 * @return 引数の位置の要素
	 */
	@SuppressWarnings("unchecked")
	public final S get(int index){
		index += this.offSet;
		this.spreadLine(index);
		return (S)this.node[index];
	}

	/**
	 * 指定された区間に function を適用した結果を返します。<br/>
	 * 閉区間であることに注意して下さい。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 *
	 * @return [left,right] の要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final S query(int left,int right){
		left += this.offSet;
		right += this.offSet+1;
		this.spreadRange(left,right);
		S sumL = this.defaultS;
		S sumR = this.defaultS;
		while(left<right){
			if((left&1)==1){
				sumL = this.function(sumL,(S)this.node[left]);
				left += 1;
			}
			left >>= 1;
			if((right&1)==1){
				right -= 1;
				sumR = this.function((S)this.node[right],sumR);
			}
			right >>= 1;
		}
		return this.function(sumL,sumR);
	}

	/**
	 * 全要素に function を適用した結果を返します。
	 *
	 * @return 全要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final S answer(){
		return (S)this.node[1];
	}

	/**
	 * 引数の位置の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param index インデックス
	 * @param function 反映する演算を表すパラメータ
	 */
	@SuppressWarnings("unchecked")
	public final void apply(int index,final F function){
		index += this.offSet;
		this.spreadLine(index);
		this.node[index] = this.mapping((S)this.node[index],function);
		this.update(index);
	}

	/**
	 * 指定された区間の要素に指定されたパラメータによる演算を反映します。<br/>
	 * 閉区間であることに注意して下さい。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 * @param function 反映する演算を表すパラメータ
	 */
	@SuppressWarnings("unchecked")
	public final void apply(final int left,final int right,final F function){
		int subL = left+this.offSet;
		int subR = right+this.offSet+1;
		this.spreadRange(subL,subR);
		while(subL<subR){
			if((subL&1)==1){
				this.node[subL] = this.mapping((S)this.node[subL],function);
				this.lazy[subL] = this.composition((F)this.lazy[subL],function);
				subL += 1;
			}
			if((subR&1)==1){
				subR -= 1;
				this.node[subR] = this.mapping((S)this.node[subR],function);
				this.lazy[subR] = this.composition((F)this.lazy[subR], function);
			}
			subL >>= 1;
			subR >>= 1;
		}
		this.update(left+this.offSet,right+this.offSet+1);
	}

	/**
	 * 各要素に適用する関数を定義するメソッドです。
	 *
	 * @param s1 要素 1
	 * @param s2 要素 2
	 *
	 * @return 要素に関数を適用した結果
	 */
	abstract public S function(S s1,S s2);

	/**
	 * パラメータを合成するメソッドです。<br/>
	 * パラメータを表すインスタンスが不変であること、
	 * ここで返すインスタンスが他に影響を及ぼさないことが要求されます。
	 *
	 * @param f1 パラメータ 1
	 * @param f2 パラメータ 2
	 *
	 * @return パラメータを合成した結果を表すパラメータ
	 */
	abstract public F composition(F f1,F f2);

	/**
	 * パラメータを元に要素に演算を適用します。
	 *
	 * @param value 要素
	 * @param function パラメータ
	 *
	 * @return 要素に演算を適用した結果
	 */
	abstract public S mapping(S value,F function);

	/**
	 * この LazySegmentTree を表す文字列を返します。
	 *
	 * @return この LazySegmentTree を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "LazySegmentTree["+this.hashCode()+"]";
	}
}
