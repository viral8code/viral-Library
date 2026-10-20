package util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * 配列に関する処理を管理するクラスです。<br/>
 * 2 次元配列の回転や1次元配列の区間反転などを提供します。
 */
public final class ArrayUtil{

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private ArrayUtil() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateR(final int[][] array){
		final int[][] ans = new int[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static long[][] rotateR(final long[][] array){
		final long[][] ans = new long[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static char[][] rotateR(final char[][] array){
		final char[][] ans = new char[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static double[][] rotateR(final double[][] array){
		final double[][] ans = new double[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static boolean[][] rotateR(final boolean[][] array){
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
	 * @param <E> 配列の要素の型
	 *
	 * @return 回転させた配列
	 */
	public static <E> E[][] rotateR(final E[][] array,final E[][] ans){
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateL(final int[][] array){
		final int[][] ans = new int[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;j++){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static long[][] rotateL(final long[][] array){
		final long[][] ans = new long[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;j++){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static char[][] rotateL(final char[][] array){
		final char[][] ans = new char[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static double[][] rotateL(final double[][] array){
		final double[][] ans = new double[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static boolean[][] rotateL(final boolean[][] array){
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。<br/>
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
	 * @param <E> 配列の要素の型
	 *
	 * @return 回転させた配列
	 */
	public static <E> E[][] rotateL(final E[][] array,final E[][] ans){
		for(int i=0;i<ans.length;++i){
			for(int j=0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 引数の配列の最長狭義増加部分列の長さを返します。
	 *
	 * @param array 最長狭義増加部分列の長さを求める配列
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(final int[] array){
		return lis(array,false);
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p] (0 &lt;= p &lt;= arrays.length) の最長狭義増加部分列の長さ
	 */
	public static int lis(final int[][] arrays,final int p){
		return lis(arrays,p,false);
	}

	/**
	 * 引数の配列の最長狭義増加部分列の長さを返します。
	 *
	 * @param array 最長狭義増加部分列の長さを求める配列
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(final long[] array){
		return lis(array,false);
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p] (0 &lt;= p &lt;= arrays.length) の最長狭義増加部分列の長さ
	 */
	public static int lis(final long[][] arrays,final int p){
		return lis(arrays,p,false);
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列なら true、狭義増加列なら false
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(final int[] array,final boolean include){
		final int[] list = new int[array.length];
		Arrays.fill(list,Integer.MAX_VALUE);
		for(final int num:array){
			final int index = include?Searcher.overSearch(list,num):Searcher.upSearch(list,num);
			list[index] = Math.min(list[index],num);
		}
		final int answer = Searcher.underSearch(list,Integer.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列なら true、狭義増加列なら false
	 *
	 * @return arrays[i][p] (0 &lt;= p &lt;= arrays.length) の最長狭義増加部分列の長さ
	 */
	public static int lis(final int[][] arrays,final int p,final boolean include){
		final int[] list = new int[arrays.length];
		Arrays.fill(list,Integer.MAX_VALUE);
		for(final int[] array:arrays){
			final int index = include?Searcher.overSearch(list,array[p]):Searcher.upSearch(list,array[p]);
			list[index] = Math.min(list[index],array[p]);
		}
		final int answer = Searcher.underSearch(list,Integer.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列なら true、狭義増加列なら false
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(final long[] array,final boolean include){
		final long[] list = new long[array.length];
		Arrays.fill(list,Long.MAX_VALUE);
		for(final long num:array){
			final int index = include?Searcher.overSearch(list,num):Searcher.upSearch(list,num);
			list[index] = Math.min(list[index],num);
		}
		final int answer = Searcher.underSearch(list,Long.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列なら true、狭義増加列なら false
	 *
	 * @return arrays[i][p] (0 &lt;= p &lt;= arrays.length) の最長狭義増加部分列の長さ
	 */
	public static int lis(final long[][] arrays,final int p,final boolean include){
		final long[] list = new long[arrays.length];
		Arrays.fill(list,Long.MAX_VALUE);
		for(final long[] array:arrays){
			final int index = include?Searcher.overSearch(list,array[p]):Searcher.upSearch(list,array[p]);
			list[index] = Math.min(list[index],array[p]);
		}
		final int answer = Searcher.underSearch(list,Long.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の隣接グラフから求められる有向辺に対してトポロジカルソートを行ないます。<br/>
	 * 引数のグラフは有向非巡回グラフであることを要求します。<br/>
	 * 有向非巡回グラフでない場合、閉路以降の辺は全て null で置換されて返します。<br/>
	 * 戻り値は辺を表す int 型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort(final ArrayList<? extends ArrayList<Integer>> route){
		final int[] count = new int[route.size()];
		int pathCount = 0;
		for(final ArrayList<Integer> path:route){
			for(final int point:path){
				pathCount += 1;
				count[point] += 1;
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>(count.length);
		for(int i=1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(!deq.isEmpty()){
			final int nowP = deq.pollFirst();
			for(final int nextP:route.get(nowP)){
				ans[index][0] = nowP;
				ans[index][1] = nextP;
				index += 1;
				count[nextP] -= 1;
				if(count[nextP]==0){
					deq.add(nextP);
				}
			}
		}
		return ans;
	}

	/**
	 * 引数の隣接リストから求められる有向辺に対してトポロジカルソートを行ないます。<br/>
	 * 引数のグラフは有向非巡回グラフであることを要求します。<br/>
	 * 有向非巡回グラフでない場合、閉路以降の辺は全て null で置換されて返します。<br/>
	 * 戻り値は辺を表す int 型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort(final int[][] route){
		final int[] count = new int[route.length];
		int pathCount = 0;
		for(final int[] path:route){
			for(final int point:path){
				pathCount += 1;
				count[point] += 1;
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>(count.length);
		for(int i=1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(!deq.isEmpty()){
			final int nowP = deq.pollFirst();
			for(final int nextP:route[nowP]){
				ans[index][0] = nowP;
				ans[index][1] = nextP;
				index += 1;
				count[nextP] -= 1;
				if(count[nextP]==0){
					deq.add(nextP);
				}
			}
		}
		return ans;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 */
	public static void swap(final int[] array,final int i,final int j){
		final int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 */
	public static void swap(final long[] array,final int i,final int j){
		final long temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 */
	public static void swap(final double[] array,final int i,final int j){
		final double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 */
	public static void swap(final char[] array,final int i,final int j){
		final char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 */
	public static void swap(final boolean[] array,final int i,final int j){
		final boolean temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i 交換元
	 * @param j 交換先
	 * @param <E> 配列の型
	 */
	public static <E> void swap(final E[] array,final int i,final int j){
		final E temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 */
	public static void swap(final int[][] array,final int i1,final int j1,final int i2,final int j2){
		final int temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 */
	public static void swap(final long[][] array,final int i1,final int j1,final int i2,final int j2){
		final long temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 */
	public static void swap(final double[][] array,final int i1,final int j1,final int i2,final int j2){
		final double temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 */
	public static void swap(final char[][] array,final int i1,final int j1,final int i2,final int j2){
		final char temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 */
	public static void swap(final boolean[][] array,final int i1,final int j1,final int i2,final int j2){
		final boolean temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param i1 交換元の第 1 インデックス
	 * @param j1 交換元の第 2 インデックス
	 * @param i2 交換先の第 1 インデックス
	 * @param j2 交換先の第 2 インデックス
	 * @param <E> 配列の型
	 */
	public static <E> void swap(final E[][] array,final int i1,final int j1,final int i2,final int j2){
		final E temp = array[i1][j1];
		array[i1][j1] = array[i2][j2];
		array[i2][j2] = temp;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合は true、array が降順に並んでいるなら false
	 */
	public static boolean nextPermutation(final int[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]<array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合は true、array が降順に並んでいるなら false
	 */
	public static boolean nextPermutation(final long[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]<array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合は true、array が降順に並んでいるなら false
	 */
	public static boolean nextPermutation(final char[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]<array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 * @param <E> 配列の型
	 *
	 * @return 辞書順で次に当たる配列がある場合は true、array が降順に並んでいるなら false
	 */
	public static <E extends Comparable<E>> boolean nextPermutation(final E[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i].compareTo(array[i+1])<0){
				for(int j=array.length-1;i<j;--j){
					if(array[i].compareTo(array[j])<0){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合は true、array が昇順に並んでいるなら false
	 */
	public static boolean previousPermutation(final int[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]>array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合は true、array が昇順に並んでいるなら false
	 */
	public static boolean previousPermutation(final long[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]>array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合は true、array が昇順に並んでいるなら false
	 */
	public static boolean previousPermutation(final char[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j=array.length-1;i<j;--j){
					if(array[i]>array[j]){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。<br/>
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 * @param <E> 配列の型
	 *
	 * @return 辞書順で直前に当たる配列がある場合は true、array が昇順に並んでいるなら false
	 */
	public static <E extends Comparable<E>> boolean previousPermutation(final E[] array){
		for(int i=array.length-2;i>=0;--i){
			if(array[i].compareTo(array[i+1])>0){
				for(int j=array.length-1;i<j;--j){
					if(array[i].compareTo(array[j])>0){
						swap(array,i,j);
						reverseRange(array,i+1,array.length);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 引数の配列に対して渡された関数を適用します。
	 *
	 * @param array 元となる配列
	 * @param func 適用する関数
	 */
	public static void mapping(final int[] array,final IntUnaryOperator func){
		for(int i=0;i<array.length;i++){
			array[i] = func.applyAsInt(array[i]);
		}
	}

	/**
	 * 引数の配列に対して渡された関数を適用します。
	 *
	 * @param array 元となる配列
	 * @param func 適用する関数
	 */
	public static void mapping(final long[] array,final LongUnaryOperator func){
		for(int i=0;i<array.length;i++){
			array[i] = func.applyAsLong(array[i]);
		}
	}

	/**
	 * 引数の配列に対して渡された関数を適用します。
	 *
	 * @param array 元となる配列
	 * @param func 適用する関数
	 */
	public static void mapping(final double[] array,final DoubleUnaryOperator func){
		for(int i=0;i<array.length;i++){
			array[i] = func.applyAsDouble(array[i]);
		}
	}

	/**
	 * 引数の配列に対して渡された関数を適用します。
	 *
	 * @param array 元となる配列
	 * @param func 適用する関数
	 */
	public static <E> void mapping(final E[] array,final UnaryOperator<E> func){
		for(int i=0;i<array.length;i++){
			array[i] = func.apply(array[i]);
		}
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static int[] reBuild(final int[] array,final IntUnaryOperator func){
		final int[] ans = new int[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsInt(array[i]);
		}
		return ans;
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static int[] reBuild(final int[] array,final IntBinaryOperator func){
		final int[] ans = new int[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsInt(i,array[i]);
		}
		return ans;
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static long[] reBuild(final long[] array,final LongUnaryOperator func){
		final long[] ans = new long[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsLong(array[i]);
		}
		return ans;
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static long[] reBuild(final long[] array,final LongBinaryOperator func){
		final long[] ans = new long[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsLong(i,array[i]);
		}
		return ans;
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static double[] reBuild(final double[] array,final DoubleUnaryOperator func){
		final double[] ans = new double[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsDouble(array[i]);
		}
		return ans;
	}

	/**
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static double[] reBuild(final double[] array,final DoubleBinaryOperator func){
		final double[] ans = new double[array.length];
		for(int i=0;i<array.length;++i){
			ans[i] = func.applyAsDouble(i,array[i]);
		}
		return ans;
	}

	/**
	 * 配列の要素を順に引数の Consumer に作用させます。
	 *
	 * @param array 作用させる配列
	 * @param func 作用先の Consumer
	 */
	public static void computeByArray(final int[] array,final IntConsumer func){
		for(final int num:array){
			func.accept(num);
		}
	}

	/**
	 * 配列の要素を順に引数の Consumer に作用させます。
	 *
	 * @param array 作用させる配列
	 * @param func 作用先の Consumer
	 */
	public static void computeByArray(final long[] array,final LongConsumer func){
		for(final long num:array){
			func.accept(num);
		}
	}

	/**
	 * 配列の要素を順に引数の Consumer に作用させます。
	 *
	 * @param array 作用させる配列
	 * @param func 作用先の Consumer
	 */
	public static void computeByArray(final double[] array,final DoubleConsumer func){
		for(final double num:array){
			func.accept(num);
		}
	}

	/**
	 * 配列の要素を順に引数の Consumer に作用させます。
	 *
	 * @param array 作用させる配列
	 * @param func 作用先の Consumer
	 */
	public static <E> void computeByArray(final E[] array,final Consumer<? super E> func){
		for(final E num:array){
			func.accept(num);
		}
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static void reverse(final int[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static void reverse(final long[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static void reverse(final double[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static void reverse(final char[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static void reverse(final boolean[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 要素を逆順にします。
	 *
	 * @param array 元となる配列
	 */
	public static <E> void reverse(final E[] array){
		reverseRange(array,0,array.length);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 */
	public static void reverseRange(final int[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 */
	public static void reverseRange(final long[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 */
	public static void reverseRange(final double[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 */
	public static void reverseRange(final char[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 */
	public static void reverseRange(final boolean[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param left 区間の左端
	 * @param right 区間の右端 (right を含まない)
	 * @param <E> 配列の型
	 */
	public static <E> void reverseRange(final E[] array,int left,int right){
		while(left<right){
			right -= 1;
			swap(array,left,right);
			left += 1;
		}
	}

	/**
	 * Mo's Algorithm 用の Comparator を返します。
	 *
	 * @param queryCount クエリ数
	 *
	 * @return Mo's Algorithm 用の Comparator
	 */
	public static Comparator<int[]> mosComparator(final int queryCount){
		final int separateCount = (int)Math.sqrt(queryCount);
		return (left,right)->{
			final int sepL = left[0]/separateCount;
			final int sepR = right[0]/separateCount;
			if(sepL!=sepR){
				return Integer.compare(left[0]/separateCount,right[0]/separateCount);
			}
			else if((left[0]/separateCount&1)==0){
				return Integer.compare(right[1],left[1]);
			}
			else{
				return Integer.compare(left[1],right[1]);
			}
		};
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final int[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final long[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final char[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final boolean[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static <E> boolean isPalindrome(final E[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final int[] array,int left,int right){
		while(left<right){
			right -= 1;
			if(array[left]!=array[right]){
				return false;
			}
			left += 1;
		}
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final long[] array,int left,int right){
		while(left<right){
			right -= 1;
			if(array[left]!=array[right]){
				return false;
			}
			left += 1;
		}
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final char[] array,int left,int right){
		while(left<right){
			right -= 1;
			if(array[left]!=array[right]){
				return false;
			}
			left += 1;
		}
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static boolean isPalindrome(final boolean[] array,int left,int right){
		while(left<right){
			right -= 1;
			if(array[left]!=array[right]){
				return false;
			}
			left += 1;
		}
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっているなら true、それ以外は false
	 */
	public static <E> boolean isPalindrome(final E[] array,int left,int right){
		while(left<right){
			right -= 1;
			if(!array[left].equals(array[right])){
				return false;
			}
			left += 1;
		}
		return true;
	}
}
