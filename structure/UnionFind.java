package structure;

import java.util.Arrays;

/**
 * UnionFindクラスです。
 * 連結成分の大きさの他、辺の数、連結成分の数も取得できます。
 */
public final class UnionFind{

	/**
	 * 内部処理用の配列です。
	 */
	private final int[] par, rank, size, path;

	/**
	 * 連結成分の数を管理する変数です。
	 */
	private int count;

	/**
	 * 大きさNのUnionFindを構築します。
	 *
	 * @param N 大きさ
	 */
	public UnionFind(final int N){
		count = N;
		par = new int[N];
		rank = new int[N];
		size = new int[N];
		path = new int[N];
		Arrays.fill(par,-1);
		Arrays.fill(size,1);
	}

	/**
	 * 引数の頂点の代表される親を返します。
	 *
	 * @param ind 代表を取得する頂点
	 *
	 * @return 代表される親
	 */
	public int root(final int ind){
		if(par[ind]==-1){
			return ind;
		}
		else{
			return par[ind] = root(par[ind]);
		}
	}

	/**
	 * 引数の二つの頂点が同一の連結成分に属するか返します。
	 *
	 * @param x 頂点1
	 * @param y 頂点2
	 *
	 * @return 同一の連結成分に属するならtrue、それ以外はfalse
	 */
	public boolean isSame(final int x,final int y){
		return root(x)==root(y);
	}

	/**
	 * 引数の二つの頂点を連結します。
	 * 連結済みであっても辺はカウントされることに注意して下さい。
	 *
	 * @param x 頂点1
	 * @param y 頂点2
	 *
	 * @return 既に二頂点が同一の連結成分に属しているならfalse、それ以外はtrue
	 */
	public boolean unite(final int x,final int y){
		int rx = root(x);
		int ry = root(y);
		++path[rx];
		if(rx==ry){
			return false;
		}
		if(rank[rx]<rank[ry]){
			int temp = rx;
			rx = ry;
			ry = temp;
		}
		par[ry] = rx;
		if(rank[rx]==rank[ry]){
			++rank[rx];
		}
		path[rx] += path[ry];
		size[rx] += size[ry];
		--count;
		return true;
	}

	/**
	 * このUnionFindの連結成分の数を返します。
	 *
	 * @return 連結成分の数
	 */
	public int groupCount(){
		return count;
	}

	/**
	 * 引数の頂点の連結成分の辺の総数を返します。
	 *
	 * @param x 頂点
	 *
	 * @return 連結成分の辺の総数
	 */
	public int pathCount(final int x){
		return path[root(x)];
	}

	/**
	 * 引数の頂点の連結成分の頂点数を返します。
	 *
	 * @param x 頂点
	 *
	 * @return 連結成分の頂点数
	 */
	public int size(final int x){
		return size[root(x)];
	}
}
