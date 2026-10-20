package structure;

import java.util.Arrays;

/**
 * Binary Indexed Tree クラスです。
 * 引数は 1-indexed であることを要求します。
 */
public final class BIT{

	/**
	 * この BIT の大きさを表します。
	 */
	private final int size;

	/**
	 * この BIT を表す long[] です。
	 */
	private final long[] tree;

	/**
	 * 大きさ n の BIT を生成します。
	 *
	 * @param n 生成する BIT の大きさ
	 */
	public BIT(final int n){
		this.size = n;
		this.tree = new long[n+1];
	}

	/**
	 * [1,i] の総和を求めます。
	 *
	 * @param i 求める区間の右端 (i を含む)
	 *
	 * @return [1,i] の総和
	 */
	public long sum(int i){
		long sum = 0;
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
	public void add(int i,final long x){
		if(i<1){
			throw new IndexOutOfBoundsException("index must be positive: "+i);
		}
		while(i<=this.size){
			this.tree[i] += x;
			i += i&(-i);
		}
	}

	/**
	 * この BIT の値を全て 0 にします。
	 */
	public void clear(){
		Arrays.fill(this.tree,0L);
	}

	/**
	 * 基となる配列を復元して文字列として返します。<br/>
	 * O(N log N) かかるので頻繁な呼び出しは非推奨です。
	 *
	 * @return 基となる配列を表現する文字列
	 */
	@Override
	public String toString(){
		final long[] array = new long[this.size];
		for(int i=1;i<=this.size;i++){
			long val = this.tree[i];
			final int j = i-(i&-i)+1;
			for(int k=j;k<i;k++){
				val -= array[k-1];
			}
			array[i-1] = val;
		}
		return Arrays.toString(array);
	}
}
