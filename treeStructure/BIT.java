/**
 * BIT(Binary Indexed Tree)クラスです。
 * 引数は1-indexedにしてください。
 */
package treeStructure;

public final class BIT {

	//このBITの大きさを表す値です。
	final int size;

	//このBITを表すlong配列です。
	final long[] tree;

	/**
	 * 引数の大きさのBITを生成します。
	 * @param n
	 */
	public BIT ( int n ) {
		size = n;
		tree = new long[n + 1];
	}

	/**
	 * [1,i]の総和を求めます。
	 * @param i
	 * @return
	 */
	public long sum ( int i ) {
		long sum = 0;
		while ( i > 0 ) {
			sum += tree[i];
			i ^= i & ( -i );
		}
		return sum;
	}

	/**
	 * 引数の位置に加算します。
	 * @param i
	 * @param x
	 */
	public void add ( int i, long x ) {
		while ( i <= size ) {
			tree[i] += x;
			i += i & ( -i );
		}
	}
}
