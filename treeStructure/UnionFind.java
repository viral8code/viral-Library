package treeStructure;

import java.util.Arrays;

public final class UnionFind {
	private final int[] par, rank, size, path;
	private int count;

	public UnionFind ( final int N ) {
		count = N;
		par = new int[N];
		rank = new int[N];
		size = new int[N];
		path = new int[N];
		Arrays.fill( par, -1 );
		Arrays.fill( size, 1 );
	}

	public int root ( final int ind ) {
		if ( par[ind] == -1 ) {
			return ind;
		}
		else {
			return par[ind] = root( par[ind] );
		}
	}

	public boolean isSame ( final int x, final int y ) {
		return root( x ) == root( y );
	}

	public boolean unite ( final int x, final int y ) {
		int rx = root( x );
		int ry = root( y );
		++path[rx];
		if ( rx == ry ) {
			return false;
		}
		if ( rank[rx] < rank[ry] ) {
			int temp = rx;
			rx = ry;
			ry = temp;
		}
		par[ry] = rx;
		if ( rank[rx] == rank[ry] ) {
			++rank[rx];
		}
		path[rx] += path[ry];
		size[rx] += size[ry];
		--count;
		return true;
	}

	public int groupCount () {
		return count;
	}

	public int pathCount ( final int x ) {
		return path[root( x )];
	}

	public int size ( final int x ) {
		return size[root( x )];
	}
}
