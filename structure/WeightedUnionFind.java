package structure;

import java.util.Arrays;

/**
 * 重み付き UnionFind です。<br/>
 * 同じ連結成分内での相対的な重みを取得できます。
 */
public final class WeightedUnionFind{

	/**
	 * 内部処理用の配列です。
	 */
	private final int[] par, rank, sizes;

	/**
	 * 内部処理用の配列です。
	 */
	private final long[] diff;

	/**
	 * 大きさ N の UnionFind を構築します。
	 *
	 * @param size 大きさ
	 */
	public WeightedUnionFind(final int size){
		this.par = new int[size];
		this.sizes = new int[size];
		this.rank = new int[size];
		this.diff = new long[size];
		Arrays.fill(this.par,-1);
		Arrays.fill(this.sizes,1);
	}

	/**
	 * 引数の頂点の代表される親を返します。
	 *
	 * @param x 代表を取得する頂点
	 *
	 * @return 代表される親
	 */
	public int root(final int x){
		if(this.par[x]==-1){
			return x;
		}
		final int beforeParent = this.par[x];
		this.par[x] = this.root(beforeParent);
		this.diff[x] += this.diff[beforeParent];
		return this.par[x];
	}

	/**
	 * 引数の 2 つの頂点が同一の連結成分に属するか返します。
	 *
	 * @param x1 頂点 1
	 * @param x2 頂点 2
	 *
	 * @return 同一の連結成分に属するなら true、それ以外は false
	 */
	public boolean isSame(final int x1,final int x2){
		return this.root(x1)==this.root(x2);
	}

	/**
	 * 第一引数の頂点の重みを第二引数を基準にして求めます。<br/>
	 * このメソッドは指定された 2 頂点が連結していることが求められます。
	 *
	 * @param x1 頂点 1
	 * @param x2 頂点 2
	 *
	 * @return 第二引数を基準とした第一引数の頂点の重み
	 */
	public long diff(final int x1,final int x2){
		if(!this.isSame(x1,x2)){
			throw new IllegalArgumentException(x1+"'s root and "+x2+"'s root is different");
		}
		return this.diff[x1]-this.diff[x2];
	}

	/**
	 * 引数の 2 つの頂点を指定された重みで連結します。<br/>
	 * 連結済みであっても辺はカウントされることに注意して下さい。
	 *
	 * @param x1 頂点 1
	 * @param x2 頂点 2
	 * @param dif 重み
	 *
	 * @return 既に 2 つの頂点が同一の連結成分に属しているなら false、それ以外は true
	 */
	public boolean unite(final int x1,final int x2,final long dif){
		int rx = this.root(x1);
		int ry = this.root(x2);
		if(rx==ry){
			return false;
		}
		final long dx = this.diff[x1];
		final long dy = this.diff[x2];
		long sub = dx-dy-dif;
		if(this.rank[rx]<this.rank[ry]){
			final int temp = rx;
			rx = ry;
			ry = temp;
			sub = -sub;
		}
		else if(this.rank[rx]==this.rank[ry]){
			this.rank[rx]++;
		}
		this.sizes[rx] += this.sizes[ry];
		this.diff[ry] = sub;
		this.par[ry] = rx;
		return true;
	}

	/**
	 * 引数の頂点の連結成分の頂点数を返します。
	 *
	 * @param x 頂点
	 *
	 * @return 連結成分の頂点数
	 */
	public int size(final int x){
		return this.sizes[this.root(x)];
	}

	/**
	 * この WeightedUnionFind を表す文字列を返します。
	 *
	 * @return この WeightedUnionFind を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "WeightedUnionFind["+this.hashCode()+"]";
	}
}
