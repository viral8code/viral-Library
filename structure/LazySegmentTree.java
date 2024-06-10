package structure;

import java.util.Arrays;

/**
 * LazySegmentTreeクラスです。
 * 載せる演算はfunctionメソッド、演算の合成はcompositionメソッド、演算の適用はmappingメソッドに定義して使用して下さい。
 *
 * @param <S> 演算を適用する要素の型
 * @param <F> 演算に使用するパラメータ
 */
@SuppressWarnings("unchecked")
public abstract class LazySegmentTree<S,F>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int size, log;

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
	private final S[] node;

	/**
	 * 演算用のテーブルです。
	 */
	private final F[] lazy;

	/**
	 * 大きさN、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 * 各メソッドに渡すインデックスは0-indexedであることが要求されます。
	 *
	 * @param N 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 */
	public LazySegmentTree(final int N,final S defaultS,final F defaultF){
		this(N,defaultS,defaultF,false);
	}

	/**
	 * 大きさN、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 *
	 * @param N 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは1-indexedか
	 */
	public LazySegmentTree(final int N,final S defaultS,final F defaultF,final boolean is1indexed){
		this.log = 32-Integer.numberOfLeadingZeros(N-1);
		this.size = (1<<log)-(is1indexed?1:0);
		this.defaultS = defaultS;
		this.defaultF = defaultF;
		this.node = (S[])new Object[1<<log+1];
		this.lazy = (F[])new Object[1<<log+1];
		clear();
	}

	/**
	 * 引数の配列を元に、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 *
	 * @param defaultValues 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは1-indexedか
	 */
	public LazySegmentTree(final S[] defaultValues,final S defaultS,final F defaultF,final boolean is1indexed){
		this(defaultValues.length,defaultS,defaultF,is1indexed);
		updateAll(defaultValues);
	}

	/**
	 * 全ての要素を単位元に、演算を恒等写像にします。
	 */
	public void clear(){
		Arrays.fill(this.node,this.defaultS);
		Arrays.fill(this.lazy,this.defaultF);
	}

	/**
	 * 引数の要素を元にテーブルを再構築します。
	 *
	 * @param defaultValues 元となる配列
	 */
	private void updateAll(final S[] defaultValues){
		System.arraycopy(defaultValues,0,node,1<<log,defaultValues.length);
		for(int i = (1<<log)-1;i>0;i--){
			node[i] = function(node[i<<1],node[i<<1|1]);
		}
	}

	/**
	 * 引数の位置の演算を適用し、子に伝播します。
	 *
	 * @param index 演算を適用する位置
	 */
	private void spread(final int index){
		if(lazy[index]!=defaultF){
			int l = index<<1;
			int r = index<<1|1;
			node[l] = mapping(node[l],lazy[index]);
			node[r] = mapping(node[r],lazy[index]);
			lazy[l] = composition(lazy[l],lazy[index]);
			lazy[r] = composition(lazy[r],lazy[index]);
			lazy[index] = defaultF;
		}
	}

	/**
	 * 親から順に引数の位置までの演算を適用します。
	 *
	 * @param from 演算を適用する終点
	 */
	private void spreadLine(final int from){
		for(int i = log;i>0;i--)
			spread(from>>i);
	}

	/**
	 * 引数の区間の演算を適用します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 */
	private void spreadRange(final int l,final int r){
		for(int i = log;i>0;i--){
			if((l>>i<<i)!=l)
				spread(l>>i);
			if((r>>i<<i)!=r)
				spread(r>>i);
		}
	}

	/**
	 * 引数の位置の要素の情報を親に向かって伝播します。
	 *
	 * @param index 伝播したい要素のインデックス
	 */
	private void update(int index){
		while((index >>= 1)>0)
			node[index] = function(node[index<<1],node[index<<1|1]);
	}

	/**
	 * 区間の要素の情報を親に向かって伝播します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 */
	private void update(final int l,final int r){
		for(int i = 1;i<=log;i++){
			int subL = l>>i;
			int subR = r>>i;
			if((subL<<i)!=l)
				node[subL] = function(node[subL<<1],node[subL<<1|1]);
			if((subR<<i)!=r)
				node[subR] = function(node[subR<<1],node[subR<<1|1]);
		}
	}

	/**
	 * 引数の位置の要素を引数の値で上書きします。
	 *
	 * @param index インデックス
	 * @param x 上書きする値
	 */
	public void update(int index,final S x){
		index += size;
		spreadLine(index);
		node[index] = x;
		update(index);
	}

	/**
	 * 引数の位置の要素を取得します
	 *
	 * @param index インデックス
	 *
	 * @return 引数の位置の要素
	 */
	public S get(int index){
		index += size;
		spreadLine(index);
		return node[index];
	}

	/**
	 * 指定された区間にfunctionを適用した結果を返します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 *
	 * @return [l,r)の要素にfunctionを適用した結果
	 */
	public S query(int l,int r){
		l += size;
		r += size;
		spreadRange(l,r);
		S sumL = defaultS;
		S sumR = defaultS;
		while(l<r){
			if((l&1)==1)
				sumL = function(sumL,node[l++]);
			if((r&1)==1)
				sumR = function(node[--r],sumR);
			l >>= 1;
			r >>= 1;
		}
		return function(sumL,sumR);
	}

	/**
	 * 全要素にfunctionを適用した結果を返します。
	 *
	 * @return 全要素にfunctionを適用した結果
	 */
	public S answer(){
		return node[1];
	}

	/**
	 * 引数の位置の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param index インデックス
	 * @param f 反映する演算を表すパラメータ
	 */
	public void apply(int index,final F f){
		index += size;
		spreadLine(index);
		node[index] = mapping(node[index],f);
		update(index);
	}

	/**
	 * 指定された区間の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 * @param f 反映する演算を表すパラメータ
	 */
	public void apply(int l,int r,final F f){
		l += size;
		r += size;
		spreadRange(l,r);
		int subL = l;
		int subR = r;
		while(subL<subR){
			if((subL&1)==1){
				node[subL] = mapping(node[subL],f);
				lazy[subL] = composition(lazy[subL++],f);
			}
			if((subR&1)==1){
				node[--subR] = mapping(node[subR],f);
				lazy[subR] = composition(lazy[subR],f);
			}
			subL >>= 1;
			subR >>= 1;
		}
		update(l,r);
	}

	/**
	 * 各要素に適用する関数を定義するメソッドです。
	 *
	 * @param s1 要素1
	 * @param s2 要素2
	 *
	 * @return 要素に関数を適用した結果
	 */
	abstract public S function(S s1,S s2);

	/**
	 * パラメータを合成するメソッドです。
	 * パラメータを表すインスタンスが不変であること、
	 * ここで返すインスタンスが他に影響を及ぼさないことが要求されます。
	 *
	 * @param f1 パラメータ1
	 * @param f2 パラメータ2
	 *
	 * @return パラメータを合成した結果を表すパラメータ
	 */
	abstract public F composition(F f1,F f2);

	/**
	 * パラメータを元に要素に演算を適用します。
	 *
	 * @param s 要素
	 * @param f パラメータ
	 *
	 * @return 要素に演算を適用した結果
	 */
	abstract public S mapping(S s,F f);
}
