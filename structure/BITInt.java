package structure;

import java.util.Arrays;

/**
 * Binary Indexed Tree の int 特化クラスです。
 * 引数は 1-indexed であることを要求します。
 */
public final class BITInt{

	/**
	 * この BIT の大きさを表します。
	 */
	private final int size;

	/**
	 * この BIT を表す int[] です。
	 */
	private final int[] tree;

	/**
	 * 大きさ n の BITInt を生成します。
	 *
	 * @param n 生成する BIT の大きさ
	 */
	public BITInt(final int n){
		this.size = n;
		this.tree = new int[n+1];
	}

	/**
	 * [1,i] の総和を求めます。
	 *
	 * @param i 求める区間の右端 (i を含む)
	 *
	 * @return [1,i] の総和
	 */
	public int sum(int i){
		int sum = 0;
		while(i>0){
			sum += this.tree[i];
			i ^= i&(-i);
		}
		return sum;
	}

	/**
	 * i 番目に引数の値を加算します。
	 *
	 * @param i 加算する位置
	 * @param x 加算する値
	 */
	public void add(int i,final int x){
		if(i<1){
			throw new IndexOutOfBoundsException("index must be positive: "+i);
		}
		while(i<=this.size){
			this.tree[i] += x;
			i += i&(-i);
		}
	}

	/**
	 * この BITInt の値を全て 0 にします。
	 */
	public void clear(){
		Arrays.fill(this.tree,0);
	}

	/**
	 * 基となる配列を復元して文字列として返します。<br/>
	 * O(N log N) かかるので頻繁な呼び出しは非推奨です。
	 *
	 * @return 基となる配列を表現する文字列
	 */
	@Override
	public String toString(){
		final int[] array = new int[this.size];
		for(int i=1;i<=this.size;i++){
			int val = this.tree[i];
			final int j = i-(i&-i)+1;
			for(int k=j;k<i;k++){
				val -= array[k-1];
			}
			array[i-1] = val;
		}
		return Arrays.toString(array);
	}
}
