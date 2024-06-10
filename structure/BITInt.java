package structure;

import java.util.Arrays;

/**
 * Binary Indexed Treeのint特化クラスです。
 * 引数は1-indexedであることを要求します。
 */
public final class BITInt{
	final int size;
	final private int[] tree;

	/**
	 * 大きさnのBITを生成します。
	 *
	 * @param n 生成するBITの大きさ
	 */
	public BITInt(int n){
		size = n;
		tree = new int[n+1];
	}

	/**
	 * [1,i]の総和を求めます。
	 *
	 * @param i 求める区間の右端(iを含む)
	 *
	 * @return [1,i]の総和
	 */
	public int sum(int i){
		int sum = 0;
		while(i>0){
			sum += tree[i];
			i ^= i&(-i);
		}
		return sum;
	}

	/**
	 * i番目に引数の値を加算します。
	 *
	 * @param i 加算する位置
	 * @param x 加算する値
	 */
	public void add(int i,int x){
		while(i<=size){
			tree[i] += x;
			i += i&(-i);
		}
	}

	/**
	 * このBITの値を全て0にします。
	 */
	public void clear(){
		Arrays.fill(tree,0);
	}
}
