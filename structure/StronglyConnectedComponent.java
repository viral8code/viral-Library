package structure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * StronglyConnectedComponent クラスです。<br/>
 * 有向グラフに対応しています。
 */
public final class StronglyConnectedComponent{

	/**
	 * この StronglyConnectedComponent の大きさ
	 */
	private final int size;

	/**
	 * 内部計算用配列
	 */
	private int[] start, eList;

	/**
	 * この StronglyConnectedComponent に登録された辺を管理するリスト
	 */
	private final ArrayList<int[]> pathList;

	/**
	 * 頂点数 n の StronglyConnectedComponent を生成します。
	 *
	 * @param n 頂点数
	 */
	public StronglyConnectedComponent(final int n){
		this.size = n;
		this.start = null;
		this.eList = null;
		this.pathList = new ArrayList<>(n);
	}

	/**
	 * 有向辺を追加します。
	 *
	 * @param from 有向辺の始点
	 * @param to 有向辺の終点
	 */
	public void addPath(final int from,final int to){
		this.pathList.add(new int[]{from,to});
	}

	/**
	 * 現在の有向辺の情報を内部計算用の配列に格納します。
	 */
	private void makeCompressedRowStorage(){
		final int[] count = new int[this.size+1];
		for(final int[] path:this.pathList){
			++count[path[0]];
		}

		this.start = new int[this.size+2];
		this.eList = new int[this.pathList.size()];
		for(int i=1;i<=this.size;++i){
			this.start[i+1] = this.start[i]+count[i];
		}

		for(final int[] path:this.pathList){
			count[path[0]] -= 1;
			this.eList[this.start[path[0]]+(count[path[0]])] = path[1];
		}
	}

	/**
	 * 強連結成分分解を行い、トポロジカル順に返します。<br/>
	 * 連結成分内での順番は保証されていません。
	 *
	 * @return 強連結成分分解を行った結果
	 */
	public int[][] getIDs(){
		this.makeCompressedRowStorage();

		final class InnerSCC{

			private int nowOrder, groupNumber, tail;
			private final int[] stack, lowLink, order, ids, innerStart, innerEList;
			private final int innerSize;

			private InnerSCC(final int n,final int[] outerStart,final int[] outerEList){
				this.nowOrder = 0;
				this.groupNumber = 0;
				this.innerSize = n;
				this.innerStart = outerStart;
				this.innerEList = outerEList;
				this.lowLink = new int[this.innerSize];
				this.order = new int[this.innerSize];
				this.ids = new int[this.innerSize];
				Arrays.fill(this.order,-1);
				this.tail = 0;
				this.stack = new int[this.innerSize];
			}

			private void dfs(final int now){
				this.lowLink[now] = this.nowOrder;
				this.order[now] = this.nowOrder;
				this.nowOrder += 1;
				this.stack[this.tail] = now;
				this.tail += 1;
				for(int i=this.innerStart[now];i<this.innerStart[now+1];++i){
					final int next = this.innerEList[i];
					if(this.order[next]==-1){
						this.dfs(next);
						if(this.lowLink[next]<this.lowLink[now]){
							this.lowLink[now] = this.lowLink[next];
						}
					}
					else if(this.order[next]<this.lowLink[now]){
						this.lowLink[now] = this.order[next];
					}
				}
				if(this.lowLink[now]==this.order[now]){
					do{
						this.tail -= 1;
						final int u = this.stack[this.tail];
						this.order[u] = this.innerSize;
						this.ids[u] = this.groupNumber;
					}while(now!=this.stack[this.tail]);
					++this.groupNumber;
				}
			}

			@Override
			public String toString(){
				return "InnerSCC";
			}
		}

		final InnerSCC innerSCC = new InnerSCC(this.size+1,this.start,this.eList);
		final int[] order = innerSCC.order;

		for(int i=1;i<=this.size;++i){
			if(order[i]==-1){
				innerSCC.dfs(i);
			}
		}

		final int groupNumber = innerSCC.groupNumber;
		final int[] ids = innerSCC.ids;
		final int[] count = new int[groupNumber];
		for(int i=1;i<=this.size;++i){
			ids[i] = groupNumber-ids[i]-1;
			++count[ids[i]];
		}

		final int[][] ans = new int[groupNumber][];
		for(int i=0;i<groupNumber;++i){
			ans[i] = new int[count[i]];
		}

		for(int i=1;i<=this.size;++i){
			count[ids[i]] -= 1;
			ans[ids[i]][count[ids[i]]] = i;
		}

		return ans;
	}

	/**
	 * この StronglyConnectedComponent を表す文字列を返します。
	 *
	 * @return この StronglyConnectedComponent を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "StronglyConnectedComponent[size = "+this.size+"]";
	}
}
