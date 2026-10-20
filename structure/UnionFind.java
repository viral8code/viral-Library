package structure;

import java.util.Arrays;

/**
 * UnionFind クラスです。<br/>
 * 連結成分の大きさの他、辺の数、連結成分の数も取得できます。
 */
public final class UnionFind{

	/**
	 * 内部処理用の配列です。
	 */
	private final int[] par, rank, sizes, path;

	/**
	 * 連結成分の数を管理する変数です。
	 */
	private int count;

	/**
	 * 大きさ N の UnionFind を構築します。
	 *
	 * @param size 大きさ
	 */
	public UnionFind(final int size){
		this.count = size;
		this.par = new int[size];
		this.rank = new int[size];
		this.sizes = new int[size];
		this.path = new int[size];
		Arrays.fill(this.par,-1);
		Arrays.fill(this.sizes,1);
	}

	/**
	 * 引数の頂点の代表される親を返します。
	 *
	 * @param index 代表を取得する頂点
	 *
	 * @return 代表される親
	 */
	public int root(final int index){
		if(this.par[index]==-1){
			return index;
		}
		else{
			this.par[index] = this.root(this.par[index]);
			return this.par[index];
		}
	}

	/**
	 * 引数の 2 つの頂点が同一の連結成分に属するか返します。
	 *
	 * @param x 頂点 1
	 * @param y 頂点 2
	 *
	 * @return 同一の連結成分に属するなら true、それ以外は false
	 */
	public boolean isSame(final int x,final int y){
		return this.root(x)==this.root(y);
	}

	/**
	 * 引数の 2 つの頂点を連結します。<br/>
	 * 連結済みであっても辺はカウントされることに注意して下さい。
	 *
	 * @param x 頂点 1
	 * @param y 頂点 2
	 *
	 * @return 既に 2 つの頂点が同一の連結成分に属しているなら false、それ以外は true
	 */
	public boolean unite(final int x,final int y){
		int rx = this.root(x);
		int ry = this.root(y);
		++this.path[rx];
		if(rx==ry){
			return false;
		}
		if(this.rank[rx]<this.rank[ry]){
			final int temp = rx;
			rx = ry;
			ry = temp;
		}
		this.par[ry] = rx;
		if(this.rank[rx]==this.rank[ry]){
			++this.rank[rx];
		}
		this.path[rx] += this.path[ry];
		this.sizes[rx] += this.sizes[ry];
		--this.count;
		return true;
	}

	/**
	 * この UnionFind の連結成分の数を返します。
	 *
	 * @return 連結成分の数
	 */
	public int groupCount(){
		return this.count;
	}

	/**
	 * 引数の頂点の連結成分の辺の総数を返します。
	 *
	 * @param x 頂点
	 *
	 * @return 連結成分の辺の総数
	 */
	public int pathCount(final int x){
		return this.path[this.root(x)];
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
	 * この UnionFind を表す文字列を返します。
	 *
	 * @return この UnionFind を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "UnionFind["+this.hashCode()+"]";
	}
}
