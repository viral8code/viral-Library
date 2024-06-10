package util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * 配列に関する処理を管理するクラスです。
 * 2次元配列の回転や1次元配列の区間反転などを提供します。
 */
public final class ArrayUtil{

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateR(final int[][] array){
		final int[][] ans = new int[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static long[][] rotateR(final long[][] array){
		final long[][] ans = new long[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static char[][] rotateR(final char[][] array){
		final char[][] ans = new char[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static double[][] rotateR(final double[][] array){
		final double[][] ans = new double[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static boolean[][] rotateR(final boolean[][] array){
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
	 * 
	 * @param <E> 配列の要素の型
	 *
	 * @return 回転させた配列
	 */
	public static <E> E[][] rotateR(final E[][] array,final E[][] ans){
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[ans[i].length-j-1][i];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateL(final int[][] array){
		final int[][] ans = new int[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			final int index = i;
			Arrays.setAll(ans[i],k->array[k][ans.length-index-1]);
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static long[][] rotateL(final long[][] array){
		final long[][] ans = new long[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			final int index = i;
			Arrays.setAll(ans[i],k->array[k][ans.length-index-1]);
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static char[][] rotateL(final char[][] array){
		final char[][] ans = new char[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static double[][] rotateL(final double[][] array){
		final double[][] ans = new double[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static boolean[][] rotateL(final boolean[][] array){
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
	 * 
	 * @param <E> 配列の要素の型
	 *
	 * @return 回転させた配列
	 */
	public static <E> E[][] rotateL(final E[][] array,final E[][] ans){
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;++j){
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
	public static int lis(int[] array){
		return lis(array,false);
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p](0 &lt;= p &lt;= arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis(int[][] arrays,int p){
		return lis(arrays,p,false);
	}

	/**
	 * 引数の配列の最長狭義増加部分列の長さを返します。
	 *
	 * @param array 最長狭義増加部分列の長さを求める配列
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(long[] array){
		return lis(array,false);
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p](0 &lt;= p &lt;= arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis(long[][] arrays,int p){
		return lis(arrays,p,false);
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(int[] array,boolean include){
		int[] list = new int[array.length];
		Arrays.fill(list,Integer.MAX_VALUE);
		for(int num: array){
			int index = include?Searcher.overSearch(list,num):Searcher.upSearch(list,num);
			list[index] = Math.min(list[index],num);
		}
		int answer = Searcher.underSearch(list,Integer.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return arrays[i][p](0 &lt;= p &lt;= arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis(int[][] arrays,int p,boolean include){
		int[] list = new int[arrays.length];
		Arrays.fill(list,Integer.MAX_VALUE);
		for(int[] array: arrays){
			int index = include?Searcher.overSearch(list,array[p]):Searcher.upSearch(list,array[p]);
			list[index] = Math.min(list[index],array[p]);
		}
		int answer = Searcher.underSearch(list,Integer.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis(long[] array,boolean include){
		long[] list = new long[array.length];
		Arrays.fill(list,Long.MAX_VALUE);
		for(long num: array){
			int index = include?Searcher.overSearch(list,num):Searcher.upSearch(list,num);
			list[index] = Math.min(list[index],num);
		}
		int answer = Searcher.underSearch(list,Long.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return arrays[i][p](0 &lt;= p &lt;= arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis(long[][] arrays,int p,boolean include){
		long[] list = new long[arrays.length];
		Arrays.fill(list,Long.MAX_VALUE);
		for(long[] array: arrays){
			int index = include?Searcher.overSearch(list,array[p]):Searcher.upSearch(list,array[p]);
			list[index] = Math.min(list[index],array[p]);
		}
		int answer = Searcher.underSearch(list,Long.MAX_VALUE);
		return answer+1;
	}

	/**
	 * 引数の隣接グラフから求められる有向辺に対してトポロジカルソートを行ないます。
	 * 引数のグラフは有向非巡回グラフであることを要求します。
	 * 有向非巡回グラフでない場合、閉路に含まれる辺の分nullで置き換えたものが返されます。
	 * 戻り値は辺を表すint型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort(final ArrayList<ArrayList<Integer>> route){
		final int[] count = new int[route.size()];
		int pathCount = 0;
		for(final ArrayList<Integer> path: route){
			for(final int point: path){
				++pathCount;
				++count[point];
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>();
		for(int i = 1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(deq.size()>0){
			int nowP = deq.pollFirst();
			for(final int nextP: route.get(nowP)){
				ans[index][0] = nowP;
				ans[index++][1] = nextP;
				if(--count[nextP]==0){
					deq.add(nextP);
				}
			}
		}
		return ans;
	}

	/**
	 * 引数の隣接リストから求められる有向辺に対してトポロジカルソートを行ないます。
	 * 引数のグラフは有向非巡回グラフであることを要求します。
	 * 有向非巡回グラフでない場合、閉路に含まれる辺の分nullで置き換えたものが返されます。
	 * 戻り値は辺を表すint型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort(final int[][] route){
		final int[] count = new int[route.length];
		int pathCount = 0;
		for(final int[] path: route){
			for(final int point: path){
				++pathCount;
				++count[point];
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>();
		for(int i = 1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(deq.size()>0){
			int nowP = deq.pollFirst();
			for(final int nextP: route[nowP]){
				ans[index][0] = nowP;
				ans[index++][1] = nextP;
				if(--count[nextP]==0){
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
	 * @param a 交換元
	 * @param b 交換先
	 */
	public static void swap(final int[] array,final int a,final int b){
		final int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元
	 * @param b 交換先
	 */
	public static void swap(final long[] array,final int a,final int b){
		final long temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元
	 * @param b 交換先
	 */
	public static void swap(final double[] array,final int a,final int b){
		final double temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元
	 * @param b 交換先
	 */
	public static void swap(final char[] array,final int a,final int b){
		final char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元
	 * @param b 交換先
	 */
	public static void swap(final boolean[] array,final int a,final int b){
		final boolean temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元
	 * @param b 交換先
	 * 
	 * @param <E> 配列の型
	 */
	public static <E> void swap(final E[] array,final int a,final int b){
		final E temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 */
	public static void swap(final int[][] array,final int a,final int b,final int c,final int d){
		final int temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 */
	public static void swap(final long[][] array,final int a,final int b,final int c,final int d){
		final long temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 */
	public static void swap(final double[][] array,final int a,final int b,final int c,final int d){
		final double temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 */
	public static void swap(final char[][] array,final int a,final int b,final int c,final int d){
		final char temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 */
	public static void swap(final boolean[][] array,final int a,final int b,final int c,final int d){
		final boolean temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の位置の要素を交換します。
	 *
	 * @param array 交換する要素の含まれる配列
	 * @param a 交換元の第1インデックス
	 * @param b 交換元の第2インデックス
	 * @param c 交換先の第1インデックス
	 * @param d 交換先の第2インデックス
	 * 
	 * @param <E> 配列の型
	 */
	public static <E> void swap(final E[][] array,final int a,final int b,final int c,final int d){
		final E temp = array[a][b];
		array[a][b] = array[c][d];
		array[c][d] = temp;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
	 */
	public static boolean nextPermutation(final int[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]<array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],array[index1],min)){
				min = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.insertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
	 */
	public static boolean nextPermutation(final long[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]<array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		long min = Long.MAX_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],array[index1],min)){
				min = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.insertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
	 */
	public static boolean nextPermutation(final char[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]<array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],array[index1],min)){
				min = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.insertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 * 
	 * @param <E> 配列の型
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
	 */
	public static <E extends Comparable<E>> boolean nextPermutation(final E[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1].compareTo(array[i])<0){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		E min = MathFunction.max(array);
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckSubClose(array[i],array[index1],min)){
				min = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.insertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
	 */
	public static boolean previousPermutation(final int[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]>array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		int max = Integer.MIN_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],max,array[index1])){
				max = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.reverseInsertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
	 */
	public static boolean previousPermutation(final long[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]>array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		long max = Long.MIN_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],max,array[index1])){
				max = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.reverseInsertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
	 */
	public static boolean previousPermutation(final char[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1]>array[i]){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		int max = Integer.MIN_VALUE;
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheckOpen(array[i],max,array[index1])){
				max = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.reverseInsertSort(array,index1+1,array.length);
		return true;
	}

	/**
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 * 
	 * @param <E> 配列の型
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
	 */
	public static <E extends Comparable<E>> boolean previousPermutation(final E[] array){
		int index1 = 0;
		for(int i = 1;i<array.length;++i){
			if(array[i-1].compareTo(array[i])>0){
				index1 = i;
			}
		}
		if(--index1<0){
			return false;
		}
		int index2 = 0;
		E max = MathFunction.min(array);
		for(int i = index1+1;i<array.length;++i){
			if(MathFunction.rangeCheck(array[i],max,array[index1])){
				max = array[i];
				index2 = i;
			}
		}
		swap(array,index1,index2);
		reverseRange(array,index1+1,array.length);
		Sorter.reverseInsertSort(array,index1+1,array.length);
		return true;
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
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 * 
	 * @return 再構築した配列
	 */
	public static int[] reBuild(final int[] array,final IntUnaryOperator func){
		final int[] ans = new int[array.length];
		for(int i = 0;i<array.length;++i){
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
		for(int i = 0;i<array.length;++i){
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
		for(int i = 0;i<array.length;++i){
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
		for(int i = 0;i<array.length;++i){
			ans[i] = func.applyAsLong(i,array[i]);
		}
		return ans;
	}

	/**
	 * 配列の要素を順に引数のConsumerに作用させます。
	 *
	 * @param array 作用させる配列
	 * @param func 作用先のConsumer
	 */
	public static void computeByArray(final int[] array,final IntConsumer func){
		for(final int num: array){
			func.accept(num);
		}
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 */
	public static void reverseRange(final int[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 */
	public static void reverseRange(final long[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 */
	public static void reverseRange(final double[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 */
	public static void reverseRange(final char[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 */
	public static void reverseRange(final boolean[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * 引数の区間の要素を逆順にします。
	 *
	 * @param array 元となる配列
	 * @param l 区間の左端
	 * @param r 区間の右端(rを含まない)
	 * 
	 * @param <E> 配列の型
	 */
	public static <E> void reverseRange(final E[] array,int l,int r){
		while(l<r)
			swap(array,l++,--r);
	}

	/**
	 * Mo's Algorithm用のComparatorを返します。
	 *
	 * @param M 分割数
	 * @return Mo's Algorithm用のComparator
	 */
	public static Comparator<int[]> mo_sComparator(final int M){
		return (a,b)->a[0]/M!=b[0]/M?Integer.compare(a[0]/M,b[0]/M):
			Integer.compare(a[1]/M,b[1]/M)*((a[0]/M&1)==0?-1:1);
	}
}
