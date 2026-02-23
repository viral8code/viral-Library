import java.awt.Dimension;
import java.awt.Point;
import java.io.Flushable;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PrimitiveIterator;
import java.util.Random;
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

//Maybe use
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

final class Main{

	private static final SimpleScanner sc;
	private static final SimpleWriter out;

	static{
		final boolean autoFlush = false;
		sc = new SimpleScanner(System.in);
		out = new SimpleWriter(System.out,autoFlush);
	}

	public static void main(final String[] args){

		

		out.close();
	}
}

/*//////////////////////////////////////////////////////////////////////////////////////////*/
/*                                     *  My Library  *                                     */
/*                                                                                          */
/*                                      @author  viral                                      */
/*//////////////////////////////////////////////////////////////////////////////////////////*/

/**
 * 配列に関する処理を管理するクラスです。
 * 2 次元配列の回転や1次元配列の区間反転などを提供します。
 */
@SuppressWarnings("unused")
final class ArrayUtil{

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private ArrayUtil() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 配列を右周りに 90 度回転させたものを返します。
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
	 * 配列を右周りに 90 度回転させたものを返します。
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
	 * 配列を右周りに 90 度回転させたものを返します。
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
	 * 配列を右周りに 90 度回転させたものを返します。
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
	 * 配列を右周りに 90 度回転させたものを返します。
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
	 * 配列を右周りに 90 度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
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
	 * 配列を左周りに 90 度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateL(final int[][] array){
		final int[][] ans = new int[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;j++){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static long[][] rotateL(final long[][] array){
		final long[][] ans = new long[array[0].length][array.length];
		for(int i = 0;i<ans.length;++i){
			for(int j = 0;j<ans[i].length;j++){
				ans[i][j] = array[j][ans.length-i-1];
			}
		}
		return ans;
	}

	/**
	 * 配列を左周りに 90 度回転させたものを返します。
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
	 * 配列を左周りに 90 度回転させたものを返します。
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
	 * 配列を左周りに 90 度回転させたものを返します。
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
	 * 配列を左周りに 90 度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 * @param ans 回転させた配列を格納するための配列
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
		for(final int num: array){
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
		for(final int[] array: arrays){
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
		for(final long num: array){
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
		for(final long[] array: arrays){
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
		for(final ArrayList<Integer> path: route){
			for(final int point: path){
				pathCount += 1;
				count[point] += 1;
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>(count.length);
		for(int i = 1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(!deq.isEmpty()){
			final int nowP = deq.pollFirst();
			for(final int nextP: route.get(nowP)){
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
		for(final int[] path: route){
			for(final int point: path){
				pathCount += 1;
				count[point] += 1;
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>(count.length);
		for(int i = 1;i<count.length;++i){
			if(count[i]==0){
				deq.add(i);
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while(!deq.isEmpty()){
			final int nowP = deq.pollFirst();
			for(final int nextP: route[nowP]){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]<array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i].compareTo(array[i+1])<0){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i]>array[i+1]){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = array.length-2;i>=0;--i){
			if(array[i].compareTo(array[i+1])>0){
				for(int j = array.length-1;i<j;--j){
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
		for(int i = 0;i<array.length;i++){
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
		for(int i = 0;i<array.length;i++){
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
		for(int i = 0;i<array.length;i++){
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
		for(int i = 0;i<array.length;i++){
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
	 * 引数の配列と関数を元に配列を再構築します。
	 *
	 * @param array 元となる配列
	 * @param func 配列に施す関数
	 *
	 * @return 再構築した配列
	 */
	public static double[] reBuild(final double[] array,final DoubleUnaryOperator func){
		final double[] ans = new double[array.length];
		for(int i = 0;i<array.length;++i){
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
		for(int i = 0;i<array.length;++i){
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
		for(final int num: array){
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
		for(final long num: array){
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
		for(final double num: array){
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
		for(final E num: array){
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
		return (left,right) -> {
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
			if(array[left].equals(array[right])){
				return false;
			}
			left += 1;
		}
		return true;
	}
}

/**
 * Binary Indexed Tree クラスです。
 * 引数は 1-indexed であることを要求します。
 */
@SuppressWarnings("unused")
final class BIT{

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
		for(int i = this.size;i>0;i--){
			long val = this.tree[i];
			final int j = i-(i&-i)+1;
			for(int k = j;k<i;k++){
				val -= array[k];
			}
			array[i-1] = val;
		}
		return Arrays.toString(array);
	}
}

/**
 * Binary Indexed Tree の int 特化クラスです。
 * 引数は 1-indexed であることを要求します。
 */
@SuppressWarnings("unused")
final class BITInt{

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
		for(int i = this.size;i>0;i--){
			int val = this.tree[i];
			final int j = i-(i&-i)+1;
			for(int k = j;k<i;k++){
				val -= array[k];
			}
			array[i-1] = val;
		}
		return Arrays.toString(array);
	}
}

/**
 * Converter クラスです。
 * Collection をプリミティヴ型の配列に変換するメソッドを提供します。
 */
@SuppressWarnings("unused")
final class Converter{

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private Converter() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static int[] toIntArray(final Collection<Integer> collection){
		final int[] ans = new int[collection.size()];
		int index = 0;
		for(final int num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static long[] toLongArray(final Collection<Long> collection){
		final long[] ans = new long[collection.size()];
		int index = 0;
		for(final long num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static char[] toCharArray(final Collection<Character> collection){
		final char[] ans = new char[collection.size()];
		int index = 0;
		for(final char num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static double[] toDoubleArray(final Collection<Double> collection){
		final double[] ans = new double[collection.size()];
		int index = 0;
		for(final double num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static boolean[] toBooleanArray(final Collection<Boolean> collection){
		final boolean[] ans = new boolean[collection.size()];
		int index = 0;
		for(final boolean num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static byte[] toByteArray(final Collection<Byte> collection){
		final byte[] ans = new byte[collection.size()];
		int index = 0;
		for(final byte num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static short[] toShortArray(final Collection<Short> collection){
		final short[] ans = new short[collection.size()];
		int index = 0;
		for(final short num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスの Collection をプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元の Collection
	 *
	 * @return Collection の要素をプリミティヴ型に変換した配列
	 */
	public static float[] toFloatArray(final Collection<Float> collection){
		final float[] ans = new float[collection.size()];
		int index = 0;
		for(final float num: collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}
}

/**
 * 階乗計算用の Factorial クラスです。
 * 引数Nに対して前計算を O(N) で行なうことで N 以下の階乗とその逆元、N 以下の逆元を O(1) で求めます。
 */
@SuppressWarnings("unused")
final class Factorial{

	/**
	 * 階乗を格納するための配列
	 */
	private final long[] fact;

	/**
	 * 階乗の逆元を格納するための配列
	 */
	private final long[] inFact;

	/**
	 * この Factorial での法となる値
	 */
	private final long mod;

	/**
	 * 1～N の階乗とその逆元を mod で割ったあまりを事前に計算します。
	 *
	 * @param size 計算範囲
	 * @param modValue 法
	 */
	public Factorial(final int size,final long modValue){
		this.fact = new long[size+1];
		this.fact[0] = 1;
		this.fact[1] = 1;
		for(int i = 2;i<=size;++i){
			this.fact[i] = this.fact[i-1]*i%modValue;
		}
		this.inFact = new long[size+1];
		this.inFact[size] = MathFunction.modPow(this.fact[size],modValue-2,modValue);
		for(int i = size;i>0;--i){
			this.inFact[i-1] = this.inFact[i]*i%modValue;
		}
		this.inFact[0] = 1;
		this.mod = modValue;
	}

	/**
	 * num! を mod で割ったあまりを返します。
	 *
	 * @param num num! mod m となる num
	 *
	 * @return num! mod m
	 */
	public long getFact(final int num){
		return this.fact[num];
	}

	/**
	 * num! ** -1 を mod で割ったあまりを返します。
	 *
	 * @param num num! ** -1 mod m となる num
	 *
	 * @return num! ** -1 mod m
	 */
	public long getInFact(final int num){
		return this.inFact[num];
	}

	/**
	 * mod を法とした時の num ** -1 を返します。
	 *
	 * @param num num ** -1 mod m となる num
	 *
	 * @return num ** -1 mod m
	 */
	public long getInverse(final int num){
		return this.fact[num-1]*this.inFact[num]%this.mod;
	}

	/**
	 * aCb を mod で割ったあまりを返します。
	 *
	 * @param total aCb mod m となる a
	 * @param choose aCb mod m となる b
	 *
	 * @return aCb mod m
	 */
	public long getCombination(final int total,final int choose){
		if(total<choose||total<0||choose<0){
			return 0;
		}
		return (this.fact[total]*this.inFact[total-choose]%this.mod)*this.inFact[choose]%this.mod;
	}

	/**
	 * この Factorial インスタンスを表す文字列を返します。
	 *
	 * @return この Factorial インスタンスを表す文字列
	 */
	@Override
	public String toString(){
		return "Factorial (size = "+this.fact.length+", mod = "+this.mod+")";
	}
}

/**
 * 高速フーリエ変換の mod 998244353 バージョンです。
 */
@SuppressWarnings("unused")
final class FastFourierTransformFor998244353{

	/**
	 * このクラスの法となる値 (998244353)
	 */
	private static final int mod;

	/**
	 * mod の原始根
	 */
	private static final int g;

	static{
		mod = 998_244_353;
		g = 3;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private FastFourierTransformFor998244353() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void discreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i = 0, j = 0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit = 1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,(mod-1)>>bit,mod);
			final int subN = n>>1;
			for(int i = 0;i<array.length;i += n){
				long now = 1;
				for(int j = 0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 逆離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void inverseDiscreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i = 0, j = 0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit = 1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,mod-1-((mod-1)>>bit),mod);
			final int subN = n>>1;
			for(int i = 0;i<array.length;i += n){
				long now = 1;
				for(int j = 0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 渡された配列を多項式として畳み込みを行います。<br/>
	 * 配列はインデックスを i としたときに array[i] * (x ** i) と解釈します。
	 *
	 * @param array1 多項式 F
	 * @param array2 多項式 G
	 *
	 * @return F * G
	 */
	public static long[] convolution(final long[] array1,final long[] array2){
		int size = 1;
		final int length = array1.length+array2.length;
		while(size<length){
			size <<= 1;
		}
		final long[] poly1 = Arrays.copyOf(array1,size);
		final long[] poly2 = Arrays.copyOf(array2,size);
		discreteFourierTransform(poly1);
		discreteFourierTransform(poly2);
		for(int i = 0;i<size;i++){
			poly1[i] *= poly2[i];
			poly1[i] %= mod;
		}
		inverseDiscreteFourierTransform(poly1);
		final long ip = MathFunction.modPow(size,mod-2,mod);
		for(int i = 0;i<size;i++){
			poly1[i] *= ip;
			poly1[i] %= mod;
		}
		return poly1;
	}
}

/**
 * 高速フーリエ変換の mod 1000000007 バージョンです。
 */
@SuppressWarnings("unused")
final class FastFourierTransformFor1000000007{

	/**
	 * このクラスの法となる値 (1000000007)
	 */
	private static final int mod;

	/**
	 * mod の原始根
	 */
	private static final int g;

	static{
		mod = 1_000_000_007;
		g = 5;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private FastFourierTransformFor1000000007() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void discreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i = 0, j = 0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit = 1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,(mod-1)>>bit,mod);
			final int subN = n>>1;
			for(int i = 0;i<array.length;i += n){
				long now = 1;
				for(int j = 0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 逆離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void inverseDiscreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i = 0, j = 0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit = 1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,mod-1-((mod-1)>>bit),mod);
			final int subN = n>>1;
			for(int i = 0;i<array.length;i += n){
				long now = 1;
				for(int j = 0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 渡された配列を多項式として畳み込みを行います。<br/>
	 * 配列はインデックスを i としたときに array[i] * (x ** i) と解釈します。
	 *
	 * @param array1 多項式 F
	 * @param array2 多項式 G
	 *
	 * @return F * G
	 */
	public static long[] convolution(final long[] array1,final long[] array2){
		int size = 1;
		final int length = array1.length+array2.length;
		while(size<length){
			size <<= 1;
		}
		final long[] poly1 = Arrays.copyOf(array1,size);
		final long[] poly2 = Arrays.copyOf(array2,size);
		discreteFourierTransform(poly1);
		discreteFourierTransform(poly2);
		for(int i = 0;i<size;i++){
			poly1[i] *= poly2[i];
			poly1[i] %= mod;
		}
		inverseDiscreteFourierTransform(poly1);
		final long ip = MathFunction.modPow(size,mod-2,mod);
		for(int i = 0;i<size;i++){
			poly1[i] *= ip;
			poly1[i] %= mod;
		}
		return poly1;
	}
}

/**
 * 高速フーリエ変換の mod 9223372006790004737 バージョンです。
 */
@SuppressWarnings("unused")
final class FastFourierTransformForMegaPrime{

	/**
	 * このクラスの法となる値 (9223372006790004737)
	 */
	private static final long mod;

	/**
	 * mod の原始根
	 */
	private static final long g;

	/**
	 * 高速乗算用のモントゴメリ乗算クラスのインスタンス
	 */
	private static final Montgomery64.InnerMontgomery64 im;

	static{
		mod = 9_223_372_006_790_004_737L;
		final Montgomery64 m64 = new Montgomery64(mod);
		im = m64.inner();
		g = 3;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private FastFourierTransformForMegaPrime() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 離散フーリエ変換用メソッドです。<br/>
	 * 再帰による高速フーリエ変換を実装しています。
	 */
	private static void discreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		final long[] odd = new long[array.length>>1];
		final long[] even = new long[array.length>>1];
		for(int i = 0, j = 1, k = 0;j<array.length;i += 2,j += 2,++k){
			odd[k] = array[i];
			even[k] = array[j];
		}
		discreteFourierTransform(odd);
		discreteFourierTransform(even);
		long now = im.setMontgomeryExpression(1);
		final long multiplyValue = im.pow(g,(mod-1)/array.length);
		final int mask = odd.length-1;
		for(int i = 0;i<array.length;i++){
			array[i] = (odd[i&mask]-mod)+im.innerMultiply(now,even[i&mask]);
			if(array[i]<0){
				array[i] += mod;
			}
			now = im.innerMultiply(now,multiplyValue);
		}
	}

	/**
	 * 逆離散フーリエ変換用メソッドです。<br/>
	 * 再帰による高速フーリエ変換を実装しています。
	 */
	private static void invertDiscreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		final long[] odd = new long[array.length>>1];
		final long[] even = new long[array.length>>1];
		for(int i = 0, j = 1, k = 0;j<array.length;i += 2,j += 2,++k){
			odd[k] = array[i];
			even[k] = array[j];
		}
		invertDiscreteFourierTransform(odd);
		invertDiscreteFourierTransform(even);
		long now = im.setMontgomeryExpression(1);
		final long multiplyValue = im.pow(g,mod-1-(mod-1)/array.length);
		final int mask = odd.length-1;
		for(int i = 0;i<array.length;i++){
			array[i] = (odd[i&mask]-mod)+im.innerMultiply(now,even[i&mask]);
			if(array[i]<0){
				array[i] += mod;
			}
			now = im.innerMultiply(now,multiplyValue);
		}
	}

	/**
	 * 渡された配列を多項式として畳み込みを行います。<br/>
	 * 配列はインデックスを i としたときに array[i] * (x ** i) と解釈します。
	 *
	 * @param array1 多項式 F
	 * @param array2 多項式 G
	 *
	 * @return F * G
	 */
	public static long[] convolution(final long[] array1,final long[] array2){
		int size = 1;
		final int length = array1.length+array2.length;
		while(size<length){
			size <<= 1;
		}
		final long[] poly1 = new long[size];
		for(int i = 0;i<array1.length;i++){
			poly1[i] = im.setMontgomeryExpression(array1[i]);
		}
		final long[] poly2 = new long[size];
		for(int i = 0;i<array2.length;i++){
			poly2[i] = im.setMontgomeryExpression(array2[i]);
		}
		discreteFourierTransform(poly1);
		discreteFourierTransform(poly2);
		for(int i = 0;i<size;i++){
			poly1[i] = im.innerMultiply(poly1[i],poly2[i]);
		}
		invertDiscreteFourierTransform(poly1);
		final long ip = im.pow(size,mod-2);
		for(int i = 0;i<size;i++){
			poly1[i] = im.innerMultiply(poly1[i],ip);
			poly1[i] = im.montgomeryReduction(poly1[i]);
		}
		return poly1;
	}
}

/**
 * Int 特化の stack です。
 * Iterable を実装しているので範囲 for 文に使用できます。
 */
@SuppressWarnings("unused")
final class IntStack implements Iterable<Integer>{

	/**
	 * サイズ未指定時の初期容量です。
	 */
	private static final int DEFAULT_SIZE = 16;

	/**
	 * この IntStack を表す int[]
	 */
	private int[] stack;

	/**
	 * stack に入っている値の数
	 */
	private int tail;

	/**
	 * 初期容量 16 で stack を生成します。
	 */
	public IntStack(){
		this(DEFAULT_SIZE);
	}

	/**
	 * 指定された初期容量で stack を生成します。
	 * 1 以上の容量でしてください。
	 *
	 * @param size 初期容量
	 *
	 * @throws IllegalArgumentException サイズが 0 以下のとき
	 */
	public IntStack(final int size) throws IllegalArgumentException{
		if(size<1){
			throw new IllegalArgumentException();
		}
		this.stack = new int[size];
		this.tail = 0;
	}

	/**
	 * この IntStack の内部容量を拡張します。
	 */
	private void grow(){
		final int[] oldStack = this.stack;
		this.stack = new int[oldStack.length<<1];
		System.arraycopy(oldStack,0,this.stack,0,this.tail);
	}

	/**
	 * 引数の値をこの stack に追加します。
	 *
	 * @param value 追加する値
	 */
	public void push(final int value){
		if(this.stack.length==this.tail){
			this.grow();
		}
		this.stack[this.tail] = value;
		this.tail += 1;
	}

	/**
	 * この stack を空にします。<br/>
	 * 内部配列は操作せずインデックスのみ初期化するため O(1) で動作します。
	 */
	public void clear(){
		this.tail = 0;
	}

	/**
	 * この stack に最後に追加された値を取り出し、削除します。
	 *
	 * @return この stack から削除された値
	 */
	public int poll(){
		this.tail -= 1;
		return this.stack[this.tail];
	}

	/**
	 * この stack に保持されている個数を返します。
	 *
	 * @return この stack に保持されている個数
	 */
	public int size(){
		return this.tail;
	}

	/**
	 * この stack を表現する Iterator&lt;Integer&gt; を返します。
	 *
	 * @return この stack を表現する Iterator&lt;Integer&gt;
	 */
	@Override
	public Iterator<Integer> iterator(){
		return new IntStackIterator(this.stack,this.tail);
	}

	/**
	 * この stack を Iterator として表現するためのクラスです。
	 */
	private static class IntStackIterator implements PrimitiveIterator.OfInt{

		/**
		 * 内部配列
		 */
		private final int[] innerStack;

		/**
		 * 内部容量
		 */
		private final int innerTail;

		/**
		 * イテレータが次返す位置
		 */
		private int index;

		/**
		 * 指定された配列、サイズを基に Iterator を生成します。
		 *
		 * @param stack 基となる配列
		 * @param tail 読み取るサイズ
		 */
		private IntStackIterator(final int[] stack,final int tail){
			this.innerStack = stack;
			this.innerTail = tail;
			this.index = 0;
		}

		/**
		 * 次の要素があるか返します。
		 *
		 * @return 次の要素があれば true、それ以外は false
		 */
		@Override
		public boolean hasNext(){
			return this.index<this.innerTail;
		}

		/**
		 * この Iterator に対して引数の Consumer を適用します。
		 *
		 * @param action 適用する Consumer
		 */
		@Override
		public void forEachRemaining(final Consumer<? super Integer> action){
			for(int i = 0;i<this.innerTail;i++){
				action.accept(this.innerStack[i]);
			}
		}

		/**
		 * この Iterator に対して引数の Consumer を適用します。
		 *
		 * @param action 適用する Consumer
		 */
		@Override
		public void forEachRemaining(final IntConsumer action){
			for(int i = 0;i<this.innerTail;i++){
				action.accept(this.innerStack[i]);
			}
		}

		/**
		 * 次の要素を取得します。
		 *
		 * @return この Iterator が指す次の値
		 */
		@Override
		public Integer next(){
			if(!this.hasNext()){
				throw new NoSuchElementException();
			}
			final int ans = this.innerStack[this.index];
			this.index += 1;
			return ans;
		}

		/**
		 * 次の要素を int として返します。
		 *
		 * @return この Iterator が指す次の int
		 */
		@Override
		public int nextInt(){
			if(this.index==this.innerTail){
				throw new NoSuchElementException();
			}
			final int ans = this.innerStack[this.index];
			this.index += 1;
			return ans;
		}

		/**
		 * この IntStackIterator を表す文字列を返します。
		 *
		 * @return この IntStackIterator を表す文字列
		 */
		@Override
		public String toString(){
			return "IntStackIterator[now = "+this.index+", length = "+this.innerTail+"]";
		}
	}

	/**
	 * この IntStack を表す文字列を返します。
	 *
	 * @return この IntStack を表す文字列
	 */
	@Override
	public String toString(){
		return Arrays.toString(Arrays.copyOf(this.stack,this.tail));
	}
}

/**
 * LazySegmentTree クラスです。<br/>
 * 載せる演算は function メソッド、演算の合成は composition メソッド、演算の適用は mapping メソッドに定義して使用して下さい。
 *
 * @param <S> 演算を適用する要素の型
 * @param <F> 演算に使用するパラメータ
 */
@SuppressWarnings("unused")
abstract class LazySegmentTree<S,F>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int offSet, log;

	/**
	 * 載せる要素の単位元です。
	 */
	private final S defaultS;

	/**
	 * 載せる演算の恒等写像です。
	 */
	private final F defaultF;

	/**
	 * 要素用のテーブルです。
	 */
	private final Object[] node;

	/**
	 * 演算用のテーブルです。
	 */
	private final Object[] lazy;

	/**
	 * 大きさ N、単位元が defaultS、恒等写像が defaultF である LazySegmentTree を構築します。<br/>
	 * 各メソッドに渡すインデックスは 0-indexed であることが要求されます。
	 *
	 * @param size 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 */
	protected LazySegmentTree(final int size,final S defS,final F defF){
		this(size,defS,defF,false);
	}

	/**
	 * 大きさ N、単位元が defaultS、恒等写像が defaultF である LazySegmentTree を構築します。
	 *
	 * @param size 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは 1-indexed か
	 */
	protected LazySegmentTree(final int size,final S defS,final F defF,final boolean is1indexed){
		this.log = 32-Integer.numberOfLeadingZeros(size-1);
		this.offSet = (1<<this.log)-(is1indexed?1:0);
		this.defaultS = defS;
		this.defaultF = defF;
		this.node = new Object[1<<this.log+1];
		this.lazy = new Object[1<<this.log+1];
		this.clear();
	}

	/**
	 * 引数の配列を元に、単位元が defaultS、恒等写像が defaultFである LazySegmentTree を構築します。
	 *
	 * @param defaultValues 大きさ
	 * @param defS 単位元
	 * @param defF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは 1-indexedか
	 */
	protected LazySegmentTree(final S[] defaultValues,final S defS,final F defF,final boolean is1indexed){
		this(defaultValues.length,defS,defF,is1indexed);
		this.updateAll(defaultValues);
	}

	/**
	 * 全ての要素を単位元に、演算を恒等写像にします。
	 */
	public final void clear(){
		Arrays.fill(this.node,this.defaultS);
		Arrays.fill(this.lazy,this.defaultF);
	}

	/**
	 * 引数の要素を元にテーブルを再構築します。
	 *
	 * @param defaultValues 元となる配列
	 */
	@SuppressWarnings("unchecked")
	private void updateAll(final S[] defaultValues){
		System.arraycopy(defaultValues,0,this.node,1<<this.log,defaultValues.length);
		for(int i = (1<<this.log)-1;i>0;i--){
			this.node[i] = this.function((S)this.node[i<<1],(S)this.node[i<<1|1]);
		}
	}

	/**
	 * 引数の位置の演算を適用し、子に伝播します。
	 *
	 * @param index 演算を適用する位置
	 */
	@SuppressWarnings("unchecked")
	private void spread(final int index){
		if(this.lazy[index]!=this.defaultF){
			final int left = index<<1;
			final int right = index<<1|1;
			this.node[left] = this.mapping((S)this.node[left],(F)this.lazy[index]);
			this.node[right] = this.mapping((S)this.node[right],(F)this.lazy[index]);
			this.lazy[left] = this.composition((F)this.lazy[left],(F)this.lazy[index]);
			this.lazy[right] = this.composition((F)this.lazy[right],(F)this.lazy[index]);
			this.lazy[index] = this.defaultF;
		}
	}

	/**
	 * 親から順に引数の位置までの演算を適用します。
	 *
	 * @param from 演算を適用する終点
	 */
	private void spreadLine(final int from){
		for(int i = this.log;i>0;i--){
			this.spread(from>>i);
		}
	}

	/**
	 * 引数の区間の演算を適用します。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含まない)
	 */
	private void spreadRange(final int left,final int right){
		for(int i = this.log;i>0;i--){
			if((left>>i<<i)!=left){
				this.spread(left>>i);
			}
			if((right>>i<<i)!=right){
				this.spread(right>>i);
			}
		}
	}

	/**
	 * 引数の位置の要素の情報を親に向かって伝播します。
	 *
	 * @param index 伝播したい要素のインデックス
	 */
	@SuppressWarnings("unchecked")
	private void update(int index){
		while(true){
			index >>= 1;
			if(index==0){
				break;
			}
			this.node[index] = this.function((S)this.node[index<<1],(S)this.node[index<<1|1]);
		}
	}

	/**
	 * 区間の要素の情報を親に向かって伝播します。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含まない)
	 */
	@SuppressWarnings("unchecked")
	private void update(final int left,final int right){
		for(int i = 1;i<=this.log;i++){
			final int subL = left>>i;
			final int subR = right>>i;
			if((subL<<i)!=left){
				this.node[subL] = this.function((S)this.node[subL<<1],(S)this.node[subL<<1|1]);
			}
			if((subR<<i)!=right){
				this.node[subR] = this.function((S)this.node[subR<<1],(S)this.node[subR<<1|1]);
			}
		}
	}

	/**
	 * 引数の位置の要素を引数の値で上書きします。
	 *
	 * @param index インデックス
	 * @param x 上書きする値
	 */
	public final void update(int index,final S x){
		index += this.offSet;
		this.spreadLine(index);
		this.node[index] = x;
		this.update(index);
	}

	/**
	 * 引数の位置の要素を取得します
	 *
	 * @param index インデックス
	 *
	 * @return 引数の位置の要素
	 */
	@SuppressWarnings("unchecked")
	public final S get(int index){
		index += this.offSet;
		this.spreadLine(index);
		return (S)this.node[index];
	}

	/**
	 * 指定された区間に function を適用した結果を返します。<br/>
	 * 閉区間であることに注意して下さい。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 *
	 * @return [left,right] の要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final S query(int left,int right){
		left += this.offSet;
		right += this.offSet+1;
		this.spreadRange(left,right);
		S sumL = this.defaultS;
		S sumR = this.defaultS;
		while(left>0&&right>0&&left<=right){
			if((left&1)==1){
				sumL = this.function(sumL,(S)this.node[left]);
				left += 1;
			}
			left >>= 1;
			if((right&1)==1){
				right -= 1;
				sumR = this.function((S)this.node[right],sumR);
			}
			right >>= 1;
		}
		return this.function(sumL,sumR);
	}

	/**
	 * 全要素に function を適用した結果を返します。
	 *
	 * @return 全要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final S answer(){
		return (S)this.node[1];
	}

	/**
	 * 引数の位置の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param index インデックス
	 * @param function 反映する演算を表すパラメータ
	 */
	@SuppressWarnings("unchecked")
	public final void apply(int index,final F function){
		index += this.offSet;
		this.spreadLine(index);
		this.node[index] = this.mapping((S)this.node[index],function);
		this.update(index);
	}

	/**
	 * 指定された区間の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 * @param function 反映する演算を表すパラメータ
	 */
	@SuppressWarnings("unchecked")
	public final void apply(final int left,final int right,final F function){
		int subL = left+this.offSet;
		int subR = right+this.offSet+1;
		this.spreadRange(subL,subR);
		while(subL<subR){
			if((subL&1)==1){
				this.node[subL] = this.mapping((S)this.node[subL],function);
				this.lazy[subL] = this.composition((F)this.lazy[subL],function);
				subL += 1;
			}
			if((subR&1)==0){
				this.node[subR] = this.mapping((S)this.node[subR],function);
				this.lazy[subR] = this.composition((F)this.lazy[subR],function);
				subR -= 1;
			}
			subL >>= 1;
			subR >>= 1;
		}
		this.update(left,right);
	}

	/**
	 * 各要素に適用する関数を定義するメソッドです。
	 *
	 * @param s1 要素 1
	 * @param s2 要素 2
	 *
	 * @return 要素に関数を適用した結果
	 */
	abstract public S function(S s1,S s2);

	/**
	 * パラメータを合成するメソッドです。<br/>
	 * パラメータを表すインスタンスが不変であること、
	 * ここで返すインスタンスが他に影響を及ぼさないことが要求されます。
	 *
	 * @param f1 パラメータ 1
	 * @param f2 パラメータ 2
	 *
	 * @return パラメータを合成した結果を表すパラメータ
	 */
	abstract public F composition(F f1,F f2);

	/**
	 * パラメータを元に要素に演算を適用します。
	 *
	 * @param value 要素
	 * @param function パラメータ
	 *
	 * @return 要素に演算を適用した結果
	 */
	abstract public S mapping(S value,F function);

	/**
	 * この LazySegmentTree を表す文字列を返します。
	 *
	 * @return この LazySegmentTree を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "LazySegmentTree["+this.hashCode()+"]";
	}
}

/**
 * 数学に関するメソッドを提供するクラスです。<br/>
 * 最大公約数や累乗、2 線分の交差判定などを提供します。
 */
@SuppressWarnings("unused")
final class MathFunction{

	/**
	 * int 型の素数判定用の値
	 */
	private static final int[] numberForIntPrime;

	/**
	 * long 型の素数判定用の値
	 */
	private static final long[] numberForLongPrime;

	/**
	 * 空の int 型配列
	 */
	public static final int[] EMPTY_INTS = new int[0];

	static{
		numberForIntPrime = new int[]{2,7,61};
		numberForLongPrime = new long[]{2,7,61,325,9375,28178,450775,9780504,1795265022};
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private MathFunction() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * a と b の最大公約数を求めます。戻り値は 0 以上であることが保証されます。
	 *
	 * @param value1 公約数を求める整数
	 * @param value2 公約数を求める整数
	 *
	 * @return a と b の最大公約数
	 */
	public static long gcd(long value1,long value2){
		value1 = Math.abs(value1);
		value2 = Math.abs(value2);
		if(value2==0){
			return value1;
		}
		long temp = value1%value2;
		while(temp!=0){
			value1 = value2;
			value2 = temp;
			temp = value1%value2;
		}
		return value2;
	}

	/**
	 * a と b の最小公倍数を求めます。<br/>
	 * オーバーフロー検知は出来ません。
	 *
	 * @param value1 公倍数を求める整数
	 * @param value2 公倍数を求める整数
	 *
	 * @return a と b の最小公倍数
	 */
	public static long lcm(final long value1,final long value2){
		return value1/gcd(value1,value2)*value2;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	public static boolean isPrime(long value){
		value = Math.abs(value);
		if(value==2L){
			return true;
		}
		if(value==1L||(value&1L)==0L){
			return false;
		}
		if(value<=Integer.MAX_VALUE){
			return isPrimeForInt((int)value);
		}
		return isPrimeForBigInteger(value);
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	private static boolean isPrimeForInt(final int value){
		long bit = value-1L;
		while((bit&1)==0){
			bit >>= 1;
		}
		final Montgomery32 mg = new Montgomery32(value);
		final Montgomery32.InnerMontgomery32 inner = mg.inner();
		final long montgomeryOne = inner.setMontgomeryExpression(1);
		final long decrementValue = inner.setMontgomeryExpression(value-1);
		for(final int a: numberForIntPrime){
			if(a>=value){
				return true;
			}
			long t = bit;
			long y = inner.pow(a,t);
			while(t<value-1L&&y!=montgomeryOne&&y!=decrementValue){
				y = inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=decrementValue&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param value 検査対象
	 *
	 * @return value が素数であるなら true、素数でないなら false
	 */
	private static boolean isPrimeForBigInteger(final long value){
		long bit = value-1L;
		while((bit&1L)==0L){
			bit >>= 1;
		}
		final Montgomery64 mg = new Montgomery64(value);
		final Montgomery64.InnerMontgomery64 inner = mg.inner();
		final long montgomeryOne = inner.setMontgomeryExpression(1);
		final long decrementValue = inner.setMontgomeryExpression(value-1);
		for(final long a: numberForLongPrime){
			if(a>=value){
				return true;
			}
			long t = bit;
			long y = inner.pow(a,t);
			while(t<value-1L&&y!=montgomeryOne&&y!=decrementValue){
				y = inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=decrementValue&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * num 以下の素数を列挙します。
	 *
	 * @param num 素数を探す上限値
	 *
	 * @return num 以下の素数の int 型配列
	 */
	public static int[] primes(final int num){
		if(num<2){
			return EMPTY_INTS;
		}
		final BitSet numbers = new BitSet(num+1);
		numbers.set(2,num+1);
		final int limit = (int)Math.sqrt(num);
		for(int bit = numbers.nextSetBit(0);rangeCheckClose(bit,2,limit);bit = numbers.nextSetBit(bit+1)){
			for(int j = bit*bit;j<=num;j += bit){
				numbers.clear(j);
			}
		}
		final int[] answer = new int[numbers.cardinality()];
		int bit = 0;
		for(int i = 0;i<answer.length;++i){
			answer[i] = numbers.nextSetBit(bit+1);
			bit = answer[i];
		}
		return answer;
	}

	/**
	 * value ** b を計算します。
	 *
	 * @param value 被累乗数
	 * @param exp 指数
	 *
	 * @return value ** exp
	 */
	public static long pow(long value,long exp){
		long ans = 1;
		while(exp>0){
			if((exp&1)==1){
				ans *= value;
			}
			value *= value;
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * value ** b を mod で割ったあまりを計算します。
	 *
	 * @param value 被累乗数
	 * @param exp 指数
	 * @param mod 法とする整数
	 *
	 * @return value ** exp を mod で割ったあまり
	 */
	public static long modPow(long value,long exp,final long mod){
		long ans = 1;
		value %= mod;
		while(exp>0){
			if((exp&1)==1){
				ans *= value;
			}
			ans %= mod;
			value *= value;
			value %= mod;
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * value! を計算します。
	 *
	 * @param value 階乗を求めるのに用いる値
	 *
	 * @return value!
	 */
	public static long fact(final int value){
		long ans = 1;
		for(int i = 2;i<=value;++i){
			ans *= i;
		}
		return ans;
	}

	/**
	 * value! を mod で割ったあまりを計算します。
	 *
	 * @param value 階乗を求めるのに用いる値
	 * @param mod 法とする整数
	 *
	 * @return value! を mod で割ったあまり
	 */
	public static long modFact(final int value,final long mod){
		long ans = 1;
		for(int i = 2;i<=value;++i){
			ans *= i;
			ans %= mod;
		}
		return ans;
	}

	/**
	 * nCr を計算します。
	 *
	 * @param total nCr の n
	 * @param choose nCr の r
	 *
	 * @return nCr
	 */
	public static long combination(final long total,long choose){
		if(choose<0||total<choose){
			return 0;
		}
		long ans = 1;
		choose = Math.min(total-choose,choose);
		for(int i = 0;i<choose;++i){
			ans *= total-i;
			ans /= i+1;
		}
		return ans;
	}

	/**
	 * nCr を mod で割ったあまりを計算します。
	 *
	 * @param total nCr の n
	 * @param choose nCr の r
	 * @param mod 法とする整数
	 *
	 * @return nCr を mod で割ったあまり
	 */
	public static long modCombination(final long total,long choose,final long mod){
		if(choose<0||total<choose){
			return 0;
		}
		long ans = 1;
		choose = Math.min(total-choose,choose);
		for(int i = 0;i<choose;++i){
			ans *= (total-i)%mod;
			ans %= mod;
			ans *= modPow(i+1,mod-2,mod);
			ans %= mod;
		}
		return ans;
	}

	/**
	 * 引数の前半 2 点、後半 2 点で構成される 2 線分が交差しているか返します。
	 *
	 * @param x1 点 1 の x 座標
	 * @param y1 点 1 の y 座標
	 * @param x2 点 2 の x 座標
	 * @param y2 点 2 の y 座標
	 * @param x3 点 3 の x 座標
	 * @param y3 点 3 の y 座標
	 * @param x4 点 4 の x 座標
	 * @param y4 点 4 の y 座標
	 *
	 * @return 交差している (線分の端が他方の線分上に存在する場合も含む) 場合は 1、同一線分・直線上なら 0、それ以外は -1
	 */
	public static int isCrossed(final int x1,final int y1,final int x2,final int y2,final int x3,final int y3,final int x4,final int y4){
		final long s1 = (long)(x1-x2)*(y3-y1)-(long)(y1-y2)*(x3-x1);
		final long t1 = (long)(x1-x2)*(y4-y1)-(long)(y1-y2)*(x4-x1);
		final long s2 = (long)(x3-x4)*(y1-y3)-(long)(y3-y4)*(x1-x3);
		final long t2 = (long)(x3-x4)*(y2-y3)-(long)(y3-y4)*(x2-x3);
		final long temp1 = s1*t1;
		final long temp2 = s2*t2;
		if(temp1>0||temp2>0){
			return -1;
		}
		if(temp1==0&&temp2==0){
			return 0;
		}
		return 1;
	}

	/**
	 * 引数の前半 2 点、後半 2 点で構成される 2 線分が交差しているか返します。
	 *
	 * @param p1 点 1
	 * @param p2 点 2
	 * @param p3 点 3
	 * @param p4 点 4
	 *
	 * @return 交差している (線分の端が他方の線分上に存在する場合も含む) 場合は 1、同一線分・直線上なら 0、それ以外は -1
	 */
	public static int isCrossed(final Point p1,final Point p2,final Point p3,final Point p4){
		return isCrossed(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y,p4.x,p4.y);
	}

	/**
	 * 指定された頂点を順に結んで出来上がる多角形が凸多角形か判定します。
	 *
	 * @param points 多角形を構成する点
	 *
	 * @return 頂点数が 3 つ以上かつ多角形が凸多角形なら true、それ以外は false
	 */
	public static boolean isConvex(final Point... points){
		final int n = points.length;
		if(n<3){
			return false;
		}
		if(n==3){
			return true;
		}
		boolean conv = true;
		for(int i = 0;i<n;++i){
			final int result = isCrossed(points[i],points[(i+2)%n],points[(i+1)%n],points[(i+1+n/2)%n]);
			conv &= result>=0;
		}
		return conv;
	}

	/**
	 * num を mod で割ったあまりを返します。<br/>
	 * 戻り値は 0 以上 mod 未満であることが保証されます。
	 *
	 * @param num 被除算数
	 * @param mod 法とする値
	 *
	 * @return num を mod で割ったあまり
	 */
	public static long remainder(long num,final long mod){
		num %= mod;
		if(num<0){
			num += mod;
		}
		return num;
	}

	/**
	 * num が何桁かを返します。<br/>
	 * 0 は 1 桁として捉えます。<br/>
	 * 負の値の '-' は無視されます (正の整数として解釈されます)。
	 *
	 * @param num 調べる整数
	 *
	 * @return num の桁数
	 */
	public static int digit(final long num){
		final int length = String.valueOf(Math.abs(num)).length();
		if(num<0){
			return length-1;
		}
		else{
			return length;
		}
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static int max(final int... numbers){
		int ans = Integer.MIN_VALUE;
		for(final int num: numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static long max(final long... numbers){
		long ans = Long.MIN_VALUE;
		for(final long num: numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static double max(final double... numbers){
		double ans = -Double.MIN_VALUE;
		for(final double num: numbers){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param numbers 探索対象
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最大の要素
	 */
	public static <E extends Comparable<E>> E max(final E[] numbers){
		E ans = numbers[0];
		for(final E value: numbers){
			if(ans.compareTo(value)<0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static int min(final int... numbers){
		int ans = Integer.MAX_VALUE;
		for(final int num: numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static long min(final long... numbers){
		long ans = Long.MAX_VALUE;
		for(final long num: numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static double min(final double... numbers){
		double ans = Double.MAX_VALUE;
		for(final double num: numbers){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param numbers 探索対象
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最小の要素
	 */
	public static <E extends Comparable<E>> E min(final E[] numbers){
		E ans = numbers[0];
		for(final E value: numbers){
			if(ans.compareTo(value)>0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final int... numbers){
		long ans = 0;
		for(final int num: numbers){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final long... numbers){
		long ans = 0;
		for(final long num: numbers){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を指定された値で割ったあまりを返します。
	 *
	 * @param mod 法とする値
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final int... numbers){
		long ans = 0;
		for(final int num: numbers){
			ans += num;
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数の総和を指定された値で割ったあまりを返します。
	 *
	 * @param mod 法とする値
	 * @param numbers 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final long... numbers){
		long ans = 0;
		for(final long num: numbers){
			ans += num;
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final int[] numbers,final int from,final int to){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += numbers[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final long[] numbers,final int from,final int to){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += numbers[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final int[] numbers,final int from,final int to,final long mod){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += numbers[i]%mod;
			if(ans>=mod){
				ans -= mod;
			}
			else if(ans<0){
				ans += mod;
			}
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param numbers 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端 (to を含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long[] numbers,final int from,final int to,final long mod){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += numbers[i]%mod;
			if(ans>=mod){
				ans -= mod;
			}
			else if(ans<0){
				ans += mod;
			}
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final int num,final int left,final int right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final long num,final long left,final long right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheck(final double num,final double left,final double right){
		return left<=num&&num<right;
	}

	/**
	 * 引数 num が left 以上 right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含まない)
	 * @param <E> 比較する型
	 *
	 * @return left &lt;= num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheck(final E num,final E left,final E right){
		return 0<=num.compareTo(left)&&num.compareTo(right)<0;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final int num,final int left,final int right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final long num,final long left,final long right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckOpen(final double num,final double left,final double right){
		return left<num&&num<right;
	}

	/**
	 * 引数 num が left より大きく、right 未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含まない)
	 * @param <E> 比較する型
	 *
	 * @return left &lt; num &lt; right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckOpen(final E num,final E left,final E right){
		return 0<num.compareTo(left)&&num.compareTo(right)<0;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final int num,final int left,final int right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final long num,final long left,final long right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckClose(final double num,final double left,final double right){
		return left<=num&&num<=right;
	}

	/**
	 * 引数 num が left 以上 right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含む)
	 * @param right 上限 (right を含む)
	 * @param <E> 比較する型
	 *
	 * @return left &lt;= num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckClose(final E num,final E left,final E right){
		return 0<=num.compareTo(left)&&num.compareTo(right)<=0;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final int num,final int left,final int right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final long num,final long left,final long right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static boolean rangeCheckSubClose(final double num,final double left,final double right){
		return left<num&&num<=right;
	}

	/**
	 * 引数 num が left より大きく、right 以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param left 下限 (left を含まない)
	 * @param right 上限 (right を含む)
	 * @param <E> 比較する型
	 *
	 * @return left &lt; num &lt;= right を満たしていれば true、満たしていなければ false
	 */
	public static <E extends Comparable<E>> boolean rangeCheckSubClose(final E num,final E left,final E right){
		return 0<num.compareTo(left)&&num.compareTo(right)<=0;
	}

	/**
	 * 引数の中での mex を求めます。
	 *
	 * @param numbers 引数
	 *
	 * @return 引数を集合として見たときの mex
	 */
	public static int mex(final int... numbers){
		final BitSet set = new BitSet(numbers.length);
		for(final int num: numbers){
			if(num<numbers.length){
				set.set(num);
			}
		}
		return set.nextClearBit(0);
	}
}

/**
 * Matrix クラスです。
 * 行列を保持するクラスで、簡単な四則演算に行列式、累乗などを提供しています。
 *
 * @param matrix 行列を管理するための二次元配列です。
 */
@SuppressWarnings("unused")
record Matrix(long[][] matrix){

	/**
	 * 行列式計算用のモンゴメリ乗算計算クラスです。
	 */
	private static final Montgomery64.InnerMontgomery64 im;

	/**
	 * 行列式計算用の素数です。
	 */
	private static final long innerMod;

	/**
	 * 行列式計算時のデフォルトの最大値です。
	 */
	private static final long DEFAULT_LIMIT;

	static{
		innerMod = 9_223_372_006_790_004_737L;
		DEFAULT_LIMIT = 4_000_000_000_000_000_000L;
		final Montgomery64 m64 = new Montgomery64(innerMod);
		im = m64.inner();
	}

	/**
	 * H 行 W 列の、全要素が def の行列を構築します。
	 *
	 * @param height 行数
	 * @param width 列数
	 * @param def 全要素の値
	 */
	public Matrix(final int height,final int width,final long def){
		this(new long[height][width]);
		if(def!=0){
			for(final long[] mat: this.matrix){
				Arrays.fill(mat,def);
			}
		}
	}

	/**
	 * H 行 W 列の、全要素が 0 である行列を構築します。
	 *
	 * @param height 行数
	 * @param width 列数
	 */
	public Matrix(final int height,final int width){
		this(height,width,0);
	}

	/**
	 * Dimension で表される行数、列数で全要素が def の行列を構築します。
	 *
	 * @param size 行・列数
	 * @param def 全要素の値
	 */
	public Matrix(final Dimension size,final long def){
		this(size.height,size.width,def);
	}

	/**
	 * 引数の二次元配列を元に行列を構築します。
	 * 値をコピーして構築するため、引数の行列とは連動していません。
	 *
	 * @param matrix 元となる二次元配列
	 */
	public Matrix(final long[][] matrix){
		this.matrix = new long[matrix.length][matrix[0].length];
		for(int i = 0;i<matrix.length;++i){
			System.arraycopy(matrix[i],0,this.matrix[i],0,this.matrix[i].length);
		}
	}

	/**
	 * i 行 j 列目の要素を取得します。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 *
	 * @return i 行 j 列目の要素
	 */
	public long get(final int i,final int j){
		return this.matrix[i][j];
	}

	/**
	 * i 行 j 列目の要素を引数の値で上書きします。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 * @param value 上書きする値
	 */
	public void set(final int i,final int j,final long value){
		this.matrix[i][j] = value;
	}

	/**
	 * この行列を複製します。
	 *
	 * @return この行列と等価な行列 (連動していない)
	 */
	public Matrix copy(){
		return new Matrix(this.matrix);
	}

	/**
	 * この行列の行・列数を表す Dimension を返します。
	 *
	 * @return この行列の行・列数を表す Dimension
	 */
	public Dimension size(){
		return new Dimension(this.matrix[0].length,this.matrix.length);
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 *
	 * @param mat 加算する行列
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix add(final Matrix mat){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i = 0;i<this.matrix.length;++i){
			for(int j = 0;j<this.matrix[i].length;++j){
				ans.set(i,j,this.matrix[i][j]+mat.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 *
	 * @param mat 減算する行列
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix subtract(final Matrix mat){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i = 0;i<this.matrix.length;++i){
			for(int j = 0;j<this.matrix[i].length;++j){
				ans.set(i,j,this.matrix[i][j]-mat.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 *
	 * @param mat 乗算する行列
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix multiply(final Matrix mat){
		if(this.size().width!=mat.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(this.size().height,mat.size().width);
		final Dimension size = ans.size();
		final int len = this.size().width;
		for(int i = 0;i<size.height;++i){
			for(int j = 0;j<size.width;++j){
				long sum = 0;
				for(int k = 0;k<len;++k){
					sum += this.matrix[i][k]*mat.get(k,j);
				}
				ans.set(i,j,sum);
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 * 各要素は mod で除算したあまりに変換されます。
	 *
	 * @param mat 加算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix modAdd(final Matrix mat,final long mod){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i = 0;i<this.matrix.length;++i){
			for(int j = 0;j<this.matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(this.matrix[i][j]+mat.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 * 各要素は mod で除算したあまりに変換されます。
	 *
	 * @param mat 減算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix modSubtract(final Matrix mat,final long mod){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i = 0;i<this.matrix.length;++i){
			for(int j = 0;j<this.matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(this.matrix[i][j]-mat.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 * 各要素は mod で乗算したあまりに変換されます。
	 *
	 * @param mat 乗算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix modMultiply(final Matrix mat,final long mod){
		if(this.size().width!=mat.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(this.size().height,mat.size().width);
		final Dimension size = ans.size();
		final int len = this.size().width;
		for(int i = 0;i<size.height;++i){
			for(int k = 0;k<len;++k){
				for(int j = 0;j<size.width;++j){
					ans.set(i,j,MathFunction.remainder(ans.get(i,j)+this.matrix[i][k]*mat.get(k,j),mod));
				}
			}
		}
		return ans;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix pow(final Matrix original,final Matrix pw,long exp){
		Matrix a = original;
		Matrix multiplyValue = pw;
		while(0<exp){
			if((exp&1)==1){
				a = multiplyValue.multiply(a);
			}
			multiplyValue = multiplyValue.multiply(multiplyValue);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。
	 * 各要素は mod で乗算したあまりに変換されます。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 * @param mod 法となる値
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix modPow(final Matrix original,final Matrix pw,long exp,final long mod){
		Matrix a = original;
		Matrix multiplyValue = pw;
		while(0<exp){
			if((exp&1)==1){
				a = multiplyValue.modMultiply(a,mod);
			}
			multiplyValue = multiplyValue.modMultiply(multiplyValue,mod);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * この行列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9223372006790004737) を法とした剰余環上で計算します。<br/>
	 * 4e18 を超える場合は負の値として判定するためご注意ください。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(){
		return determinant(this.matrix,DEFAULT_LIMIT);
	}

	/**
	 * この行列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9223372006790004737) を法とした剰余環上で計算します。<br/>
	 * limit を超える値は負の値として判定します。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(final long limit){
		return determinant(this.matrix,limit);
	}

	/**
	 * 引数の二次元配列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9223372006790004737) を法とした剰余環上で計算します。
	 *
	 * @param mat 元となる二次元配列
	 * @param limit 正の値としてあり得る最大値
	 *
	 * @return 二次元配列の行列式
	 */
	private static long determinant(final long[][] mat,final long limit){
		final int length = mat.length;
		final long[][] copiedMatrix = new long[length][];
		for(int i = 0;i<length;i++){
			copiedMatrix[i] = mat[i].clone();
			ArrayUtil.mapping(copiedMatrix[i],num -> num<0?im.setMontgomeryExpression(num+innerMod):im.setMontgomeryExpression(num));
		}
		long ans = im.setMontgomeryExpression(1);
		for(int i = 0;i<length;i++){
			int pivot = -1;
			for(int j = i;j<length;j++){
				if(copiedMatrix[j][i]!=0){
					pivot = j;
					break;
				}
			}
			if(pivot==-1){
				ans = 0;
				break;
			}
			if(i!=pivot){
				ArrayUtil.swap(copiedMatrix,i,pivot);
				ans = innerMod-ans;
			}
			ans = im.innerMultiply(ans,copiedMatrix[i][i]);
			final long inv = im.innerPow(copiedMatrix[i][i],innerMod-2);
			for(int j = i+1;j<length;j++){
				final long num = im.innerMultiply(copiedMatrix[j][i],inv);
				for(int k = i;k<length;k++){
					copiedMatrix[j][k] -= im.innerMultiply(copiedMatrix[i][k],num);
					if(copiedMatrix[j][k]<0){
						copiedMatrix[j][k] += innerMod;
					}
				}
			}
		}
		ans = im.montgomeryReduction(ans);
		return ans>limit?ans-innerMod:ans;
	}

	/**
	 * この行列の行列式を返します。
	 *
	 * @return この行列の行列式
	 */
	public long modDeterminant(final long mod){
		return modDeterminant(this.matrix,mod);
	}

	/**
	 * 引数の二次元配列の行列式を返します。
	 *
	 * @param mat 元となる二次元配列
	 *
	 * @return 二次元配列の行列式
	 */
	private static long modDeterminant(final long[][] mat,final long mod){
		final int length = mat.length;
		final long[][] copiedMatrix = new long[length][];
		for(int i = 0;i<length;i++){
			copiedMatrix[i] = mat[i].clone();
		}
		long ans = 1;
		for(int i = 0;i<length;i++){
			int pivot = -1;
			for(int j = i;j<length;j++){
				if(copiedMatrix[j][i]!=0){
					pivot = j;
					break;
				}
			}
			if(pivot==-1){
				ans = 0;
				break;
			}
			if(i!=pivot){
				ArrayUtil.swap(copiedMatrix[i],i,pivot);
				ans = mod-ans;
			}
			ans = ans*copiedMatrix[i][i]%mod;
			final long inv = MathFunction.modPow(copiedMatrix[i][i],mod-2,mod);
			for(int j = i+1;j<length;j++){
				final long num = copiedMatrix[j][i]*inv%mod;
				for(int k = i;k<length;k++){
					copiedMatrix[j][k] -= copiedMatrix[i][k]*num%mod;
					if(copiedMatrix[j][k]<0){
						copiedMatrix[j][k] += mod;
					}
				}
			}
		}
		return ans;
	}

	/**
	 * この行列を表す String を返します。
	 *
	 * @return この行列を表す String
	 */
	@Override
	public String toString(){
		final StringBuilder ans = new StringBuilder(this.matrix.length*this.matrix[0].length);
		ans.append(Arrays.toString(this.matrix[0]));
		for(int i = 1;i<this.matrix.length;++i){
			ans.append("\n");
			ans.append(Arrays.toString(this.matrix[i]));
		}
		return ans.toString();
	}
}

/**
 * 法が 32 bit に収まるとき用の Montgomery クラスです。
 * 剰余結果を得る他に、inner から直接モンゴメリ表現での処理も提供します。
 *
 * @param inner 内部処理用のインスタンスです。
 */
@SuppressWarnings("unused")
record Montgomery32(InnerMontgomery32 inner){

	/**
	 * 内部処理用のクラスです。<br/>
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery32{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long r2, Nd, mod;

		/**
		 * ビットマスク用の変数です。
		 */
		private static final long MASK;

		/**
		 * 上位ビット、下位ビットを扱うためのシフト幅です。
		 */
		private static final int SHIFT_VALUE;

		static{
			MASK = 0xffffffffL;
			SHIFT_VALUE = 32;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 *
		 * @param n 法とする整数
		 */
		private InnerMontgomery32(final int n){
			this.mod = n;
			long r = 0;
			long t = 0;
			long num = 1L<<SHIFT_VALUE;
			long bit = 1;
			while(num>1){
				if((t&1L)==0){
					t += this.mod;
					r |= bit;
				}
				t >>>= 1;
				num >>>= 1;
				bit <<= 1;
			}
			this.Nd = r;
			this.r2 = Long.remainderUnsigned(-1L-this.mod+1,this.mod);
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 *
		 * @param num 対象の値
		 *
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long tNd = num*this.Nd&MASK;
			final long multiplyValue = tNd*this.mod;
			final long down = (multiplyValue&MASK)+(num&MASK);
			final long up = (multiplyValue >>> SHIFT_VALUE)+(num >>> SHIFT_VALUE);
			long ans = up+(down >>> SHIFT_VALUE);
			if(this.mod<=ans){
				ans -= this.mod;
			}
			return ans;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 *
		 * @param num 変換対象
		 *
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final int num){
			return this.montgomeryReduction(num*this.r2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return value1 * value2 のモンゴメリ表現
		 */
		public long multiply(final int value1,final int value2){
			final long val1 = this.setMontgomeryExpression(value1);
			final long val2 = this.setMontgomeryExpression(value2);
			return this.montgomeryReduction(val1*val2);
		}

		/**
		 * 引数をモンゴメリ表現の値として積を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return MR(a * b)
		 */
		public long innerMultiply(final long value1,final long value2){
			return this.montgomeryReduction(value1*value2);
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long pow(final int value,long exp){
			long multiplyValue = this.setMontgomeryExpression(value);
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.montgomeryReduction(ans*multiplyValue);
				}
				multiplyValue = this.montgomeryReduction(multiplyValue*multiplyValue);
				exp >>>= 1;
			}
			return ans;
		}

		/**
		 * この InnerMontgomery32 を表す文字列を返します。
		 *
		 * @return この InnerMontgomery32 を表す文字列
		 */
		@Override
		@Deprecated
		public String toString(){
			return "InnerMontgomery32[mod = "+this.mod+"]";
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 *
	 * @param mod 法とする値
	 */
	public Montgomery32(final int mod){
		this(new InnerMontgomery32(mod));
	}

	/**
	 * value1 * value2 mod n を返します。
	 *
	 * @param value1 乗算対象
	 * @param value2 乗算対象
	 *
	 * @return value1 * value2 mod n
	 */
	public int multiply(final int value1,final int value2){
		final long ans = this.inner.multiply(value1,value2);
		return (int)this.inner.montgomeryReduction(ans);
	}

	/**
	 * value ** exp mod nを返します。
	 *
	 * @param value 累乗対象
	 * @param exp 指数
	 *
	 * @return value ** exp mod n
	 */
	public int pow(final int value,final long exp){
		final long ans = this.inner.pow(value,exp);
		return (int)this.inner.montgomeryReduction(ans);
	}
}

/**
 * 法が 32 bit に収まらないとき用の Montgomery クラスです。<br/>
 * 剰余結果を得る他に、inner から直接モンゴメリ表現での処理も提供します。
 *
 * @param inner 内部処理用のインスタンスです。
 */
@SuppressWarnings("unused")
record Montgomery64(InnerMontgomery64 inner){

	/**
	 * 内部処理用のクラスです。<br/>
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery64{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long r2, Nd, mod;

		/**
		 * long のビット長です。
		 */
		private static final int BIT_LENGTH;

		/**
		 * 上位、下位ビットを取得するためのシフト幅です。
		 */
		private static final int SHIFT_VALUE;

		static{
			BIT_LENGTH = 64;
			SHIFT_VALUE = 63;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 *
		 * @param modValue 法とする整数
		 */
		public InnerMontgomery64(final long modValue){
			this.mod = modValue;
			long r = 0;
			long t = 0;
			for(int i = 0;i<BIT_LENGTH;i++){
				if((t&1L)==0){
					t += this.mod;
					r |= 1L<<i;
				}
				t >>>= 1;
			}
			this.Nd = r;
			this.r2 = BigInteger.ONE.shiftLeft(128).mod(BigInteger.valueOf(this.mod)).longValue();
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 *
		 * @param num 対象の値
		 *
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long tNd = num*this.Nd;
			final long down = tNd*this.mod;
			final long up = Math.unsignedMultiplyHigh(tNd,this.mod);
			final long ans = up+Math.max(Long.compareUnsigned(num,~down),0L);
			return Long.compareUnsigned(ans,this.mod)<0?ans:ans-this.mod;
		}

		/**
		 * 引数を 128 bit 整数として解釈してモンゴメリリダクションを適用します。
		 *
		 * @param top 上位 64 bit
		 * @param bottom 下位 64 bit
		 *
		 * @return MR(top * 2 ** 64 + bottom)
		 */
		private long montgomeryReduction(final long top,final long bottom){
			final long ans = top+this.montgomeryReduction(bottom);
			return Long.compareUnsigned(ans,this.mod)<0?ans:ans-this.mod;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 *
		 * @param num 変換対象
		 *
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final long num){
			return this.innerMultiply(num,this.r2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return value1 * value2 のモンゴメリ表現
		 */
		public long multiply(final long value1,final long value2){
			final long val1 = this.setMontgomeryExpression(value1);
			final long val2 = this.setMontgomeryExpression(value2);
			return this.innerMultiply(val1,val2);
		}

		/**
		 * 引数をモンゴメリ表現の値と解釈して積を返します。
		 *
		 * @param value1 乗算対象
		 * @param value2 乗算対象
		 *
		 * @return MR(value1 * value2)
		 */
		public long innerMultiply(final long value1,final long value2){
			return this.montgomeryReduction(Math.unsignedMultiplyHigh(value1,value2),value1*value2);
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long pow(final long value,long exp){
			long multiplyValue = this.setMontgomeryExpression(value);
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.innerMultiply(ans,multiplyValue);
				}
				multiplyValue = this.innerMultiply(multiplyValue,multiplyValue);
				exp >>>= 1;
			}
			return ans;
		}

		/**
		 * value ** exp のモンゴメリ表現を返します。<br/>
		 * value はモンゴメリ表現の値と解釈します。
		 *
		 * @param value 累乗対象
		 * @param exp 指数
		 *
		 * @return value ** exp のモンゴメリ表現
		 */
		public long innerPow(long value,long exp){
			long ans = this.montgomeryReduction(this.r2);
			while(exp>0){
				if((exp&1L)>0){
					ans = this.innerMultiply(ans,value);
				}
				value = this.innerMultiply(value,value);
				exp >>>= 1;
			}
			return ans;
		}

		@Override
		@Deprecated
		public String toString(){
			return "InnerMontgomery64[mod = "+this.mod+"]";
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 *
	 * @param mod 法とする値
	 */
	public Montgomery64(final long mod){
		this(new InnerMontgomery64(mod));
	}

	/**
	 * value1 * value2 mod nを返します。
	 *
	 * @param value1 乗算対象
	 * @param value2 乗算対象
	 *
	 * @return value1 * value2 mod n
	 */
	public long multiply(final long value1,final long value2){
		final long ans = this.inner.multiply(value1,value2);
		return this.inner.montgomeryReduction(ans);
	}

	/**
	 * value ** exp mod n を返します。
	 *
	 * @param value 累乗対象
	 * @param exp 指数
	 *
	 * @return value ** exp mod n
	 */
	public long pow(final long value,final long exp){
		final long ans = this.inner.pow(value,exp);
		return this.inner.montgomeryReduction(ans);
	}
}

/**
 * PolarComparator です。
 * 基準点から見たときに x 軸方向を基準に反時計回りで比較します。
 */
@SuppressWarnings("unused")
final class PolarComparator{

	/**
	 * 原点 (内部用)
	 */
	private static final Point ORIGIN = new Point(0,0);

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private PolarComparator()throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 基準点 base からの極座標順に比較する Comparator を返します。
	 *
	 * @param base 基準点
	 *
	 * @return Comparator<Point>
	 */
	public static Comparator<Point> fromBase(final Point base){
		return (a,b)->compareFromBase(a,b,base);
	}
	
	/**
	 * 基準点 base からの極座標順に比較する Comparator を返します。
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param base 基準点
	 *
	 * @return Comparator<Point>
	 */
	public static Comparator<Point> fromBaseExact(final Point base){
		return (a,b)->compareExactFromBase(a,b,base);
	}
	
	/**
	 * 原点からの極座標順に比較します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 *
	 * @return
	 */
	public static int compare(final Point a,final Point b){
		return compareFromBase(a,b,ORIGIN);
	}
	
	/**
	 * 原点からの極座標順に比較します。
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 *
	 * @return
	 */
	public static int compareExact(final Point a,final Point b){
		return compareExactFromBase(a,b,ORIGIN);
	}
	
	/**
	 * 基準点からの極座標順に比較します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 * @param base 基準点
	 *
	 * @return
	 */
	public static int compareFromBase(final Point a,final Point b,final Point base){
		final long ax = a.x-base.x;
		final long ay = a.y-base.y;
		final long bx = b.x-base.x;
		final long by = b.y-base.y;
		final int qa = quadrant(ax,ay);
		final int qb = quadrant(bx,by);
		if(qa!=qb){
			return Integer.compare(qa,qb);
		}
		final long cross = ax*by-ay*bx;
		if(cross!=0){
			return cross>0?-1:1;
		}
		return Long.compare(ax*ax+ay*ay,bx*bx+by*by);
	}
	
	/**
	 * 基準点からの極座標順に比較します。
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 * @param base 基準点
	 *
	 * @return
	 */
	public static int compareExactFromBase(final Point a,final Point b,final Point base){
		final long ax = a.x-base.x;
		final long ay = a.y-base.y;
		final long bx = b.x-base.x;
		final long by = b.y-base.y;
		final int qa = quadrant(ax,ay);
		final int qb = quadrant(bx,by);
		if(qa!=qb){
			return Integer.compare(qa,qb);
		}
		final BigInteger axBig = BigInteger.valueOf(ax);
		final BigInteger ayBig = BigInteger.valueOf(ay);
		final BigInteger bxBig = BigInteger.valueOf(bx);
		final BigInteger byBig = BigInteger.valueOf(by);
		final BigInteger cross = axBig.multiply(byBig).subtract(ayBig.multiply(bxBig));
		final int cmp = cross.signum();
		if(cmp!=0){
			return -cmp;
		}
		final BigInteger distA = axBig.multiply(axBig).add(ayBig.multiply(ayBig));
		final BigInteger distB = bxBig.multiply(bxBig).add(byBig.multiply(byBig));
		return distA.compareTo(distB);
	}
	
	/**
	 * 象限を返します。
	 *
	 * @param x x座標
	 * @param y y座標
	 *
	 * @return 象限
	 */
	private static int quadrant(final long x,final long y){
		if(y>0){
			return x>=0?0:1;
		}
		if(y<0){
			return x<0?2:3;
		}
		if(x>0){
			return 4;
		}
		if(x<0){
			return 6;
		}
		return 8;
	}
}

/**
 * 二分探索ライブラリです。
 * 様々な条件での探索を二分探索を用いて実行します。
 */
@SuppressWarnings("unused")
final class Searcher{

	/**
	 * double 用の二分探索のサイクル回数
	 */
	private static final int CYCLE_COUNT;

	static{
		CYCLE_COUNT = Double.MAX_EXPONENT+53;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private Searcher() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final char[] array,final int value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static <E extends Comparable<E>> int downSearch(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid].compareTo(value)>0){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素を探します。<br/>
	 * リスト内で見つかった場合はその要素と同一で最大のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static <E extends Comparable<E>> int downSearch(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(list.get(mid).compareTo(value)>0){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。<br/>
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。<br/>
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は下限 -1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static int downSearchAsInt(int left,int right,final int value,final IntUnaryOperator func){
		int ans = left-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(func.applyAsInt(mid)>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。<br/>
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。<br/>
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は下限 -1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static long downSearchAsLong(long left,long right,final long value,final LongUnaryOperator func){
		long ans = left-1;
		while(left-right<1){
			final long mid = (left+right)/2;
			if(func.applyAsLong(mid)>value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。<br/>
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。<br/>
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は下限より小さい値を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static double searchAsDouble(double left,double right,final double value,final DoubleUnaryOperator func){
		double ans = left-Math.abs(left);
		for(int i = 0;i<CYCLE_COUNT;++i){
			final double mid = (left+right)/2;
			if(func.applyAsDouble(mid)>value){
				right = mid;
			}
			else{
				ans = mid;
				left = mid;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array に value が含まれているかを表す boolean
	 */
	public static boolean contains(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array に value が含まれているかを表す boolean
	 */
	public static boolean contains(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array に value が含まれているかを表す boolean
	 */
	public static boolean contains(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array に value が含まれているかを表す boolean
	 */
	public static boolean contains(final char[] array,final char value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return array に value が含まれているかを表す boolean
	 */
	public static <E extends Comparable<E>> boolean contains(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			final int result = array[mid].compareTo(value);
			if(result>0){
				right = mid-1;
			}
			else if(result<0){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * リスト内の指定された要素を探します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return list に value が含まれているかを表す boolean
	 */
	public static <E extends Comparable<E>> boolean contains(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			final int result = list.get(mid).compareTo(value);
			if(result>0){
				right = mid-1;
			}
			else if(result<0){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数が left 以上 right 以下で探索値を取るかを表す boolean
	 */
	public static boolean containsAsInt(int left,int right,final int value,final IntUnaryOperator func){
		while(left-right<1){
			final int mid = (left+right)/2;
			final int num = func.applyAsInt(mid);
			if(num>value){
				right = mid-1;
			}
			else if(num<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数が left 以上 right 以下で探索値を取るかを表す boolean
	 */
	public static boolean containsAsLong(long left,long right,final long value,final LongUnaryOperator func){
		while(left-right<1){
			final long mid = (left+right)/2;
			final long num = func.applyAsLong(mid);
			if(num>value){
				right = mid-1;
			}
			else if(num<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数が left 以上 right 以下で探索値を取るかを表す boolean
	 */
	public static boolean containsAsDouble(double left,double right,final double value,final DoubleUnaryOperator func){
		for(int i = 0;i<CYCLE_COUNT;++i){
			final double mid = (left+right)/2;
			final double num = func.applyAsDouble(mid);
			if(num>value){
				right = mid-1;
			}
			else if(num<value){
				left = mid+1;
			}
			else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array の value のインデックス (無ければ -1)
	 */
	public static int search(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array の value のインデックス (無ければ -1)
	 */
	public static int search(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array の value のインデックス (無ければ -1)
	 */
	public static int search(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return array の value のインデックス (無ければ -1)
	 */
	public static int search(final char[] array,final char value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				right = mid-1;
			}
			else if(array[mid]<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return array の value のインデックス (無ければ -1)
	 */
	public static <E extends Comparable<E>> int search(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			final int result = array[mid].compareTo(value);
			if(result>0){
				right = mid-1;
			}
			else if(result<0){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * リスト内の指定された要素を探します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return list の value のインデックス (無ければ -1)
	 */
	public static <E extends Comparable<E>> int search(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			final int result = list.get(mid).compareTo(value);
			if(result>0){
				right = mid-1;
			}
			else if(result<0){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数が value を取る引数 (無ければ left-1)
	 */
	public static int searchAsInt(int left,int right,final int value,final IntUnaryOperator func){
		while(left-right<1){
			final int mid = (left+right)/2;
			final int num = func.applyAsInt(mid);
			if(num>value){
				right = mid-1;
			}
			else if(num<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return left-1;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数が value を取る引数 (無ければ left-1)
	 */
	public static long searchAsLong(long left,long right,final long value,final LongUnaryOperator func){
		while(left-right<1){
			final long mid = (left+right)/2;
			final long num = func.applyAsLong(mid);
			if(num>value){
				right = mid-1;
			}
			else if(num<value){
				left = mid+1;
			}
			else{
				return mid;
			}
		}
		return left-1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final char[] array,final char value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static <E extends Comparable<E>> int upSearch(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid].compareTo(value)>=0){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素を探します。<br/>
	 * リスト内で見つかった場合はその要素と同一で最小のインデックスを返します。<br/>
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は list.size() を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static <E extends Comparable<E>> int upSearch(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		int ans = list.size();
		while(left-right<1){
			final int mid = (left+right)/2;
			final E e = list.get(mid);
			if(e.compareTo(value)>=0){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。<br/>
	 * 関数内で見つかった場合はその値と同一で最小の引数を返します。<br/>
	 * 見つからなかった場合は指定された値以上で最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は上限 +1 を返します。<br/>
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static int upSearchAsInt(int left,int right,final int value,final IntUnaryOperator func){
		int ans = right+1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(func.applyAsInt(mid)>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。<br/>
	 * 関数内で見つかった場合はその値と同一で最小の引数を返します。<br/>
	 * 見つからなかった場合は指定された値以上で最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は上限+1を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static long upSearchAsLong(long left,long right,final long value,final LongUnaryOperator func){
		long ans = right+1;
		while(left-right<1){
			final long mid = (left+right)/2;
			if(func.applyAsLong(mid)>=value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final char[] array,final char value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static <E extends Comparable<E>> int underSearch(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid].compareTo(value)>=0){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素より小さい要素を探します。<br/>
	 * リスト内で見つかった場合は条件を満たす最大のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static <E extends Comparable<E>> int underSearch(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		int ans = -1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(list.get(mid).compareTo(value)>=0){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より小さい値を探します。<br/>
	 * 関数内で見つかった場合は条件を満たす最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は下限 -1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static int underSearchAsInt(int left,int right,final int value,final IntUnaryOperator func){
		int ans = left-1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(func.applyAsInt(mid)>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より小さい値を探します。<br/>
	 * 関数内で見つかった場合は条件を満たす最大の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は下限 -1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static long underSearchAsLong(long left,long right,final long value,final LongUnaryOperator func){
		long ans = left-1;
		while(left-right<1){
			final long mid = (left+right)/2;
			if(func.applyAsLong(mid)>=value){
				right = mid-1;
			}
			else{
				ans = mid;
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final int[] array,final int value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final long[] array,final long value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final double[] array,final double value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final char[] array,final char value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid]>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は array.length を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int overSearch(final E[] array,final E value){
		int left = 0;
		int right = array.length-1;
		int ans = array.length;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(array[mid].compareTo(value)>0){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素より大きい要素を探します。<br/>
	 * リスト内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は list.size() を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int overSearch(final List<? extends E> list,final E value){
		int left = 0;
		int right = list.size()-1;
		int ans = list.size();
		while(left-right<1){
			final int mid = (left+right)/2;
			final E e = list.get(mid);
			if(e.compareTo(value)>0){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より大きい値を探します。<br/>
	 * 関数内で見つかった場合は条件を満たす最小の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は上限 +1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static int overSearchAsInt(int left,int right,final int value,final IntUnaryOperator func){
		int ans = right+1;
		while(left-right<1){
			final int mid = (left+right)/2;
			if(func.applyAsInt(mid)>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より大きい値を探します。<br/>
	 * 関数内で見つかった場合は条件を満たす最小の引数を返します。<br/>
	 * もしそのような要素が存在しない場合は上限 +1 を返します。
	 *
	 * @param left 探索範囲の下限
	 * @param right 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static long overSearchAsLong(long left,long right,final long value,final LongUnaryOperator func){
		long ans = right+1;
		while(left-right<1){
			final long mid = (left+right)/2;
			if(func.applyAsLong(mid)>value){
				ans = mid;
				right = mid-1;
			}
			else{
				left = mid+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int linearSearch(final int[] array,final int value){
		for(int i = 0;i<array.length;++i){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int linearSearch(final long[] array,final long value){
		for(int i = 0;i<array.length;++i){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int linearSearch(final double[] array,final double value){
		for(int i = 0;i<array.length;++i){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int linearSearch(final char[] array,final char value){
		for(int i = 0;i<array.length;++i){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int linearSearch(final E[] array,final E value){
		for(int i = 0;i<array.length;++i){
			if(array[i].compareTo(value)==0){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 配列内の指定された要素を探します。<br/>
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。<br/>
	 * もしそのような要素が存在しない場合は -1 を返します。
	 *
	 * @param list 探索対象の配列
	 * @param value 探索要素
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int linearSearch(final List<? extends E> list,final E value){
		for(int i = 0;i<list.size();++i){
			final E e = list.get(i);
			if(e.compareTo(value)==0){
				return i;
			}
		}
		return -1;
	}
}

/**
 * SegmentTree クラスです。
 * 載せる演算は function メソッドを定義して使用して下さい。
 *
 * @param <E> 演算を適用する要素の型
 */
@SuppressWarnings("unused")
abstract class SegmentTree<E>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int size, offSet;

	/**
	 * この SegmentTree の単位元です。
	 */
	private final E def;

	/**
	 * この SegmentTree を表すテーブルです。
	 */
	private final Object[] node;

	/**
	 * 大きさ n の、単位元が def である SegmentTree を構築します。
	 *
	 * @param n 扱う範囲
	 * @param defaultValue 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが 1-indexed か
	 */
	protected SegmentTree(final int n,final E defaultValue,final boolean is1indexed){
		int num = 2;
		while(num<n<<1){
			num <<= 1;
		}
		this.size = num;
		this.offSet = (num>>1)-(is1indexed?1:0);
		this.node = new Object[this.size];
		this.def = defaultValue;
		Arrays.fill(this.node,this.def);
	}

	/**
	 * 引数の配列を元に、単位元が def である SegmentTree を構築します。
	 * 浅いコピーなので、引数の配列の要素に変更を加えたときの動作は保証されません。
	 *
	 * @param arr 元となる配列
	 * @param defaultValue 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが 1-indexed か
	 */
	protected SegmentTree(final E[] arr,final E defaultValue,final boolean is1indexed){
		int num = 2;
		while(num<arr.length<<1){
			num <<= 1;
		}
		this.size = num;
		this.offSet = num>>1-(is1indexed?1:0);
		this.node = new Object[this.size];
		this.def = defaultValue;
		System.arraycopy(arr,0,this.node,this.size>>1,arr.length);
		for(int i = arr.length+(this.size>>1);i<this.size;i++){
			this.node[i] = defaultValue;
		}
		this.updateAll();
	}

	/**
	 * 大きさ n、単位元が def の SegmentTree を構築します。
	 * 各メソッドに渡すインデックスは 0-indexed であることが要求されます。
	 *
	 * @param n 大きさ
	 * @param defaultValue 単位元
	 */
	protected SegmentTree(final int n,final E defaultValue){
		this(n,defaultValue,false);
	}

	/**
	 * この SegmentTree のテーブルを一括で更新します。
	 */
	@SuppressWarnings("unchecked")
	private void updateAll(){
		for(int i = (this.size>>1)-1;i>0;i--){
			this.node[i] = this.function((E)this.node[i<<1],(E)this.node[(i<<1)+1]);
		}
	}

	/**
	 * 引数の位置の値を引数の値で上書きします。
	 *
	 * @param n インデックス
	 * @param value 上書きする値
	 */
	@SuppressWarnings("unchecked")
	public final void update(int n,final E value){
		n += this.offSet;
		this.node[n] = value;
		n >>= 1;
		while(n>0){
			this.node[n] = this.function((E)this.node[n<<1],(E)this.node[(n<<1)+1]);
			n >>= 1;
		}
	}

	/**
	 * 引数の位置の要素を返します。
	 *
	 * @param a インデックス
	 *
	 * @return 引数の位置の要素
	 */
	@SuppressWarnings("unchecked")
	public final E get(final int a){
		return (E)this.node[a+this.offSet];
	}

	/**
	 * この SegmentTree 上の要素全てに function を適用した結果を返します。
	 *
	 * @return 要素全てに function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final E answer(){
		return (E)this.node[1];
	}

	/**
	 * 引数の区間の要素に function を適用した結果を返します。
	 * 閉区間であることに注意して下さい。
	 *
	 * @param left 左端 (left を含む)
	 * @param right 右端 (right を含む)
	 *
	 * @return [left,right] の要素に function を適用した結果
	 */
	@SuppressWarnings("unchecked")
	public final E query(int left,int right){
		left += this.offSet;
		right += this.offSet;
		E sumL = this.def;
		E sumR = this.def;
		while(left>0&&right>0&&left<=right){
			if((left&1)==1){
				sumL = this.function(sumL,(E)this.node[left]);
				left += 1;
			}
			if((right&1)==0){
				sumR = this.function((E)this.node[right],sumR);
				right -= 1;
			}
			left >>= 1;
			right >>= 1;
		}
		return this.function(sumL,sumR);
	}

	/**
	 * この SegmentTree 上で適用する関数を定義したメソッドです。
	 *
	 * @param value1 要素1
	 * @param value2 要素2
	 *
	 * @return value1 と value2 に関数を適用した結果
	 */
	abstract public E function(E value1,E value2);

	/**
	 * この LazySegmentTree を表す文字列を返します。
	 *
	 * @return この LazySegmentTree を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "LazySegmentTree["+this.hashCode()+"]";
	}
}

/**
 * StringUtil クラスです。
 * String に対するメソッドを提供します。
 */
@SuppressWarnings("unused")
final class StringUtil{

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private StringUtil() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 渡された文字列を逆順にした文字列を返します。
	 *
	 * @param str 元の文字列
	 *
	 * @return str を逆順にした文字列
	 */
	public static String reverse(final String str){
		final StringBuilder sb = new StringBuilder(str.length());
		for(int i = str.length()-1;i>=0;--i){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * 引数の文字列が回文になっているか判定します。
	 *
	 * @param s 対象の文字列
	 *
	 * @return 回文になっていれば true、それ以外は false
	 */
	public static boolean isPalindrome(final String s){
		return isPalindrome(s,0,s.length());
	}

	/**
	 * 引数の文字列の指定された区間が回文か判定します
	 *
	 * @param s 対象の文字列
	 * @param left 区間の左端 (left を含む)
	 * @param right 区間の右端 (right を含まない)
	 *
	 * @return 回文になっていれば true、それ以外は false
	 */
	public static boolean isPalindrome(final String s,int left,int right){
		while(left<right){
			right -= 1;
			if(s.charAt(left)!=s.charAt(right)){
				return false;
			}
			left += 1;
		}
		return true;
	}
}

/**
 * StronglyConnectedComponent クラスです。
 * 有向グラフに対応しています。
 */
@SuppressWarnings("unused")
final class StronglyConnectedComponent{

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
		for(final int[] path: this.pathList){
			++count[path[0]];
		}

		this.start = new int[this.size+2];
		this.eList = new int[this.pathList.size()];
		for(int i = 1;i<=this.size;++i){
			this.start[i+1] = this.start[i]+count[i];
		}

		for(final int[] path: this.pathList){
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
				for(int i = this.innerStart[now];i<this.innerStart[now+1];++i){
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

		for(int i = 1;i<=this.size;++i){
			if(order[i]==-1){
				innerSCC.dfs(i);
			}
		}

		final int groupNumber = innerSCC.groupNumber;
		final int[] ids = innerSCC.ids;
		final int[] count = new int[groupNumber];
		for(int i = 1;i<=this.size;++i){
			ids[i] = groupNumber-ids[i]-1;
			++count[ids[i]];
		}

		final int[][] ans = new int[groupNumber][];
		for(int i = 0;i<groupNumber;++i){
			ans[i] = new int[count[i]];
		}

		for(int i = 1;i<=this.size;++i){
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

/**
 * SimpleScanner クラスです。
 * java.util.Scanner クラスよりは速いですが、競プロ用に特化しているため
 * char の値がスペース以下の文字は全て区切り文字と判断します。
 */
@SuppressWarnings("unused")
final class SimpleScanner{

	/**
	 * SimpleScannerの内部のバッファーの容量です。
	 */
	private static final int BUFF_SIZE;

	/**
	 * 内部計算用の定数です。
	 */
	private static final long TEN;

	/**
	 * 空の int 型配列です。
	 */
	private static final int[] EMPTY_INTS;

	static{
		BUFF_SIZE = 1<<17;
		TEN = 10L;
		EMPTY_INTS = new int[0];
	}

	/**
	 * このSimpleScannerのInputStreamインスタンスです。
	 */
	private final InputStream inputStream;

	/**
	 * このSimpleScannerのバッファーです。
	 */
	private final byte[] buff;

	/**
	 * 状態管理用の変数です。
	 */
	private int point, length;

	/**
	 * 引数のInputStreamを元にSimpleScannerを構築します。
	 *
	 * @param is 元となるInputStream
	 */
	public SimpleScanner(final InputStream is){
		this.inputStream = is;
		this.buff = new byte[BUFF_SIZE];
		this.point = 0;
		this.length = 0;
	}

	/**
	 * バッファに再読み込みします。
	 * 何かしら入力がされるまで待機します。
	 */
	private void reload(){
		try{
			this.point = 0;
			this.length = this.inputStream.read(this.buff,0,BUFF_SIZE);
		}
		catch(final IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * バッファから一文字読み込みます。
	 *
	 * @return 読み込んだ文字を表す byte
	 */
	private byte read(){
		if(this.point==this.length){
			this.reload();
		}
		if(this.length<0){
			return '\n';
		}
		final byte ans = this.buff[this.point];
		this.point += 1;
		return ans;
	}

	/**
	 * バッファから文字を表す byte を取得します。
	 *
	 * @return まだ読んでない中で最初に入力された文字を表す byte
	 */
	public byte nextByte(){
		byte b = this.read();
		while(b<=' '){
			b = this.read();
		}
		return b;
	}

	/**
	 * バッファから int を読み込みます。<br/>
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列を int と解釈した時の値
	 */
	public int nextInt(){
		int ans = 0;
		byte b = this.nextByte();
		final boolean negate = b=='-';
		if(!MathFunction.rangeCheckClose(b,'0','9')){
			b = this.read();
		}
		while(MathFunction.rangeCheckClose(b,'0','9')){
			ans = ans*10+b-'0';
			b = this.read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファから long を読み込みます。<br/>
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列を long と解釈した時の値
	 */
	public long nextLong(){
		long ans = 0;
		byte b = this.nextByte();
		final boolean negate = b=='-';
		if(!MathFunction.rangeCheckClose(b,'0','9')){
			b = this.read();
		}
		while(MathFunction.rangeCheckClose(b,'0','9')){
			ans = ans*TEN+b-'0';
			b = this.read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファから char を読み込みます。
	 *
	 * @return 区切り文字を無視した、一番最初に取得された文字を表す char
	 */
	public char nextChar(){
		return (char)this.nextByte();
	}

	/**
	 * バッファから double を読み込みます。
	 *
	 * @return 区切り文字までの文字列を double と解釈した時の値
	 */
	public double nextDouble(){
		return Double.parseDouble(this.next());
	}

	/**
	 * バッファから String を読み込みます。
	 *
	 * @return 区切り文字までの文字列を表す String
	 */
	public String next(){
		final StringBuilder ans = new StringBuilder(16);
		byte b = this.nextByte();
		while(b>' '){
			ans.append((char)b);
			b = this.read();
		}
		return ans.toString();
	}

	/**
	 * バッファから BigInteger を読み込みます。
	 *
	 * @return 区切り文字までの文字列を整数と解釈した時の BigInteger
	 */
	public BigInteger nextBigInteger(){
		return new BigInteger(this.next());
	}

	/**
	 * バッファから byte[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字を無視して n 個文字を取得した結果を表す byte[]
	 */
	public byte[] nextByte(final int n){
		final byte[] ans = new byte[n];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextByte();
		}
		return ans;
	}

	/**
	 * バッファから int[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 int を取得した結果を表す int[]
	 */
	public int[] nextInt(final int n){
		final int[] ans = new int[n];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextInt();
		}
		return ans;
	}

	/**
	 * バッファから long[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 long を取得した結果を表す long[]
	 */
	public long[] nextLong(final int n){
		final long[] ans = new long[n];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextLong();
		}
		return ans;
	}

	/**
	 * バッファから String[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 String を取得した結果を表す String[]
	 */
	public String[] next(final int n){
		final String[] ans = new String[n];
		for(int i = 0;i<n;++i){
			ans[i] = this.next();
		}
		return ans;
	}

	/**
	 * バッファから byte[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 byte を取得した結果を表す byte[][]
	 */
	public byte[][] nextByte(final int n,final int m){
		final byte[][] ans = new byte[n][];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextByte(m);
		}
		return ans;
	}

	/**
	 * バッファから int[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 int を取得した結果を表す int[][]
	 */
	public int[][] nextInt(final int n,final int m){
		final int[][] ans = new int[n][];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextInt(m);
		}
		return ans;
	}

	/**
	 * バッファから long[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 long を取得した結果を表す long[][]
	 */
	public long[][] nextLong(final int n,final int m){
		final long[][] ans = new long[n][];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextLong(m);
		}
		return ans;
	}

	/**
	 * バッファから String[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 String を取得した結果を表す String[][]
	 */
	public String[][] next(final int n,final int m){
		final String[][] ans = new String[n][];
		for(int i = 0;i<n;++i){
			ans[i] = this.next(m);
		}
		return ans;
	}

	/**
	 * バッファから String を読み込み、char[] に変換して返します。
	 *
	 * @return バッファから読み込んだ String を表す char[]
	 */
	public char[] nextCharArray(){
		final String s = this.next();
		return s.toCharArray();
	}

	/**
	 * バッファから char[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 *
	 * @return 区切り文字で区切って n 個 String を取得した結果を表す char[][]
	 */
	public char[][] nextCharArray(final int n){
		final char[][] ans = new char[n][];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextCharArray();
		}
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を無向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の無向グラフの隣接リストを表す int[][]
	 */
	public int[][] nextUndirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0];
		}
		final int[][] ans = new int[vertex+1][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,2);
		for(final int[] temp: path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i = 1;i<=vertex;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp: path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = temp[1];
			count[temp[1]] -= 1;
			ans[temp[1]][count[temp[1]]] = temp[0];
		}
		ans[0] = EMPTY_INTS;
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を有向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の有向グラフの隣接リストを表す int[][]
	 */
	public int[][] nextDirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0];
		}
		final int[][] ans = new int[vertex+1][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,2);
		for(final int[] temp: path){
			++count[temp[0]];
		}
		for(int i = 1;i<=vertex;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp: path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = temp[1];
		}
		ans[0] = EMPTY_INTS;
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を重み付き無向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の無向グラフの隣接リストを表す int[][]
	 */
	public int[][][] nextWeightedUndirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0][3];
		}
		final int[][][] ans = new int[vertex+1][][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,3);
		for(final int[] temp: path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i = 1;i<=vertex;++i){
			ans[i] = new int[count[i]][];
		}
		for(final int[] temp: path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = new int[]{temp[1],temp[2]};
			count[temp[1]] -= 1;
			ans[temp[1]][count[temp[1]]] = new int[]{temp[0],temp[2]};
		}
		ans[0] = new int[0][3];
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を重み付き有向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の有向グラフの隣接リストを表す int[][]
	 */
	public int[][][] nextWeightedDirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0][3];
		}
		final int[][][] ans = new int[vertex+1][][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,3);
		for(final int[] temp: path){
			++count[temp[0]];
		}
		for(int i = 1;i<=vertex;++i){
			ans[i] = new int[count[i]][];
		}
		for(final int[] temp: path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = new int[]{temp[1],temp[2]};
		}
		ans[0] = new int[0][3];
		return ans;
	}

	/**
	 * バッファから Point を読み込みます。
	 *
	 * @return 読み込んだ int 二つを Point に変換したインスタンス
	 */
	public Point nextPoint(){
		return new Point(this.nextInt(),this.nextInt());
	}

	/**
	 * バッファから Point[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 Point を取得した結果を表す Point[]
	 */
	public Point[] nextPoint(final int n){
		final Point[] ans = new Point[n];
		for(int i = 0;i<n;++i){
			ans[i] = this.nextPoint();
		}
		return ans;
	}

	/**
	 * この SimpleScanner の InputStream を閉じます。
	 */
	public void close(){
		try{
			this.inputStream.close();
		}
		catch(final IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * この SimpleScanner を表す文字列を返します。
	 *
	 * @return この SimpleScanner を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "SimpleScanner["+this.hashCode()+"]";
	}
}

/**
 * SimpleWriter クラスです。<br/>
 * そこそこ速い出力を提供します。
 */
@SuppressWarnings("unused")
final class SimpleWriter implements Flushable, AutoCloseable{

	/**
	 * この SimpleWriter のオートフラッシュが有効か保持する変数です。
	 */
	private final boolean _autoFlush;

	/**
	 * この SimpleWriter の SimpleOutputStream です。
	 */
	private SimpleOutputStream simpleOutputStream;

	/**
	 * 改行文字列を表す char[] です。
	 */
	private static final char[] charsOfReturn;

	/**
	 * 整数処理用のバッファーです。
	 */
	private static final byte[] integerBuffer;

	/**
	 * Long.MIN_VALUE 用の配列です。
	 */
	private static final byte[] MIN_VALUE_ARRAY;

	/**
	 * '0' を表す byte です。
	 */
	private static final byte ZERO;

	/**
	 * デフォルトのバッファサイズです。
	 */
	private static final int DEFAULT_SIZE;

	static{
		final String s = System.lineSeparator();
		charsOfReturn = s.toCharArray();
		integerBuffer = new byte[20];
		integerBuffer[0] = '-';
		ZERO = '0';
		MIN_VALUE_ARRAY = new byte[]{'-','9','2','2','3','3','7','2','0','3','6','8','5','4','7','7','5','8','0','8'};
		DEFAULT_SIZE = 1<<17;
	}

	/**
	 * 指定された OutputStream を元に SimpleWriter を生成します。<br/>
	 * オートフラッシュは無効です。
	 *
	 * @param out SimpleWriter に保持させる OutputStream
	 */
	public SimpleWriter(final OutputStream out){
		this(out,false);
	}

	/**
	 * 指定された OutputStream とフラグを元に SimpleWriter を生成します。
	 *
	 * @param out SimpleWriter に保持させる OutputStream
	 * @param autoFlush オートフラッシュの有効無効を表す boolean
	 */
	public SimpleWriter(final OutputStream out,final boolean autoFlush){
		this.simpleOutputStream = new SimpleOutputStream(out,DEFAULT_SIZE);
		this._autoFlush = autoFlush;
	}

	/**
	 * バッファーにあるものを出力します。
	 */
	public void flush(){
		try{
			this.simpleOutputStream.flush();
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * この SimpleWriter の SimpleOutputStream を閉じます。
	 */
	public void close(){
		try{
			if(this.simpleOutputStream==null){
				return;
			}
			this.simpleOutputStream.close();
			this.simpleOutputStream = null;
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 引数の値を書き込みます。
	 *
	 * @param i 文字コード
	 */
	public void write(final int i){
		try{
			this.simpleOutputStream.write(i);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された区間の char を書き込みます。
	 *
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final char[] buf,final int off,final int len){
		try{
			this.simpleOutputStream.write(buf,off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された区間の byte を書き込みます。
	 *
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final byte[] buf,final int off,final int len){
		try{
			this.simpleOutputStream.write(buf,off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された char[] を書き込みます。
	 *
	 * @param buf 書き込みたい char[]
	 */
	public void write(final char[] buf){
		this.write(buf,0,buf.length);
	}

	/**
	 * 指定された byte[] を書き込みます。
	 *
	 * @param buf 書き込みたい byte[]
	 */
	public void write(final byte[] buf){
		this.write(buf,0,buf.length);
	}

	/**
	 * 指定された区間の文字列を書き込みます。
	 *
	 * @param s 書き込み元
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final String s,final int off,final int len){
		try{
			this.simpleOutputStream.write(s.toCharArray(),off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された文字列を書き込みます。
	 *
	 * @param s 書き込みたい文字列
	 */
	public void write(final String s){
		this.write(s.toCharArray(),0,s.length());
	}

	/**
	 * 改行を書き込みます。
	 */
	private void newLine(){
		try{
			this.simpleOutputStream.write(charsOfReturn,0,charsOfReturn.length);
			if(this._autoFlush){
				this.simpleOutputStream.flush();
			}
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 引数の boolean を表す文字列を改行無しで出力します。
	 *
	 * @param value 出力したい boolean
	 */
	public void print(final boolean value){
		this.write(value?"true":"false");
	}

	/**
	 * 引数の char を改行無しで出力します。
	 *
	 * @param c 出力したい char
	 */
	public void print(final char c){
		this.write(c);
	}

	/**
	 * 引数の long を改行無しで出力します。
	 *
	 * @param l 出力したい long
	 */
	public void print(final long l){
		if(l==Long.MIN_VALUE){
			this.write(MIN_VALUE_ARRAY);
		}
		else{
			long num = Math.abs(l);
			final int len = MathFunction.digit(num);
			for(int i = len;i>0;i--){
				integerBuffer[i] = (byte)(num%10+ZERO);
				num /= 10;
			}
			if(l<0){
				this.write(integerBuffer,0,len+1);
			}
			else{
				this.write(integerBuffer,1,len);
			}
		}
	}

	/**
	 * 引数の float を改行無しで出力します。
	 *
	 * @param f 出力したい float
	 */
	public void print(final float f){
		this.write(String.valueOf(f).toCharArray());
	}

	/**
	 * 引数の double を改行無しで出力します。
	 *
	 * @param d 出力したい double
	 */
	public void print(final double d){
		this.write(String.valueOf(d).toCharArray());
	}

	/**
	 * 引数の char[] を改行無しで出力します。
	 *
	 * @param cs 出力したい char[]
	 */
	public void print(final char[] cs){
		this.write(cs);
	}

	/**
	 * 引数の Object を改行無しで出力します。
	 * このメソッドは print(obj.toString().toCharArray()) と等価です。
	 *
	 * @param obj 出力したい Object
	 */
	public void print(final Object obj){
		final String s = obj.toString();
		this.write(s.toCharArray());
	}

	/**
	 * 改行を出力します。
	 */
	public void println(){
		this.newLine();
	}

	/**
	 * 引数の boolean を表す文字列を改行ありで出力します。
	 *
	 * @param x 出力したい boolean
	 */
	public void println(final boolean x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の char を改行ありで出力します。
	 *
	 * @param x 出力したい char
	 */
	public void println(final char x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の int を改行ありで出力します。
	 *
	 * @param x 出力したい int
	 */
	public void println(final int x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の long を改行ありで出力します。
	 *
	 * @param x 出力したい long
	 */
	public void println(final long x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の float を改行ありで出力します。
	 *
	 * @param x 出力したい float
	 */
	public void println(final float x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の double を改行ありで出力します。
	 *
	 * @param x 出力したい double
	 */
	public void println(final double x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の char[] を改行ありで出力します。
	 *
	 * @param x 出力したい char[]
	 */
	public void println(final char[] x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の String を改行ありで出力します。
	 *
	 * @param x 出力したい String
	 */
	public void println(final String x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の Object を改行ありで出力します。
	 *
	 * @param x 出力したい Object
	 */
	public void println(final Object x){
		this.print(x);
		this.println();
	}

	/**
	 * 指定されたフォーマットで引数を出力します。
	 *
	 * @param format フォーマット
	 * @param args 出力したい引数
	 */
	public void printf(final String format,final Object... args){
		this.print(String.format(format,args));
	}

	/**
	 * 指定された CharSequence を SimpleOutputStream に追加します。
	 *
	 * @param csq 追加したい CharSequence
	 */
	public void append(final CharSequence csq){
		this.write(String.valueOf(csq).toCharArray());
	}

	/**
	 * 指定された CharSequence の区間を SimpleOutputStream に追加します。
	 *
	 * @param csq 追加したい CharSequence
	 * @param start 開始地点 (start を含む)
	 * @param end 終了地点 (end を含まない)
	 */
	public void append(CharSequence csq,final int start,final int end){
		if(csq==null){
			csq = "null";
		}
		this.append(csq.subSequence(start,end));
	}

	/**
	 * 指定された char を SimpleOutputStream に追加します。
	 *
	 * @param c 追加したい char
	 */
	public void append(final char c){
		this.write(c);
	}

	/**
	 * int[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 */
	public void print(final int[] array){
		this.print(array,' ');
	}

	/**
	 * int[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param str 区切り文字
	 */
	public void print(final int[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * int[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param c 区切り文字
	 */
	public void print(final int[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * int[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 */
	public void print(final int[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * int[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param str 区切り文字
	 */
	public void print(final int[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * int[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param c 区切り文字
	 */
	public void print(final int[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * int[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 */
	public void println(final int[] array){
		this.print(array,' ');
		this.println();
	}

	/**
	 * int[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param str 区切り文字
	 */
	public void println(final int[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * int[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param c 区切り文字
	 */
	public void println(final int[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * int[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param array 出力したい int[][]
	 */
	public void println(final int[][] array){
		this.print(array,' ');
		this.println();
	}

	/**
	 * int[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param str 区切り文字
	 */
	public void println(final int[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * int[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param c 区切り文字
	 */
	public void println(final int[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * long[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 */
	public void print(final long[] array){
		this.print(array,' ');
	}

	/**
	 * long[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param str 区切り文字
	 */
	public void print(final long[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * long[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param c 区切り文字
	 */
	public void print(final long[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * long[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 */
	public void print(final long[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * long[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param str 区切り文字
	 */
	public void print(final long[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * long[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param c 区切り文字
	 */
	public void print(final long[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * long[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 */
	public void println(final long[] array){
		this.println(array,' ');
	}

	/**
	 * long[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param str 区切り文字
	 */
	public void println(final long[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * long[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param c 区切り文字
	 */
	public void println(final long[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * long[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 */
	public void println(final long[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * long[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param str 区切り文字
	 */
	public void println(final long[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * long[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param c 区切り文字
	 */
	public void println(final long[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * double[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 */
	public void print(final double[] array){
		this.print(array,' ');
	}

	/**
	 * double[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param str 区切り文字
	 */
	public void print(final double[] array,final String str){
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * double[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param c 区切り文字
	 */
	public void print(final double[] array,final char c){
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * double[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 */
	public void print(final double[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * double[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param str 区切り文字
	 */
	public void print(final double[][] arrays,final String str){
		this.print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * double[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param c 区切り文字
	 */
	public void print(final double[][] arrays,final char c){
		this.print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * double[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 */
	public void println(final double[] array){
		this.println(array,' ');
	}

	/**
	 * double[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param str 区切り文字
	 */
	public void println(final double[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * double[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param c 区切り文字
	 */
	public void println(final double[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * double[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 */
	public void println(final double[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * double[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param str 区切り文字
	 */
	public void println(final double[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * double[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param c 区切り文字
	 */
	public void println(final double[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * char[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param cs 出力したい char[]
	 * @param str 区切り文字
	 */
	public void println(final char[] cs,final String str){
		this.print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			this.print(str);
			this.print(cs[i]);
		}
		this.println();
	}

	/**
	 * char[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param cs 出力したい char[]
	 * @param c 区切り文字
	 */
	public void println(final char[] cs,final char c){
		this.print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			this.print(c);
			this.print(cs[i]);
		}
		this.println();
	}

	/**
	 * char[][] を改行区切りで、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 */
	public void println(final char[][] cs){
		for(final char[] chars: cs){
			this.println(chars);
		}
	}

	/**
	 * char[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 * @param str 区切り文字
	 */
	public void println(final char[][] cs,final String str){
		for(final char[] chars: cs){
			this.println(chars,str);
		}
	}

	/**
	 * char[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 * @param c 区切り文字
	 */
	public void println(final char[][] cs,final char c){
		for(final char[] chars: cs){
			this.println(chars,c);
		}
	}

	/**
	 * 配列を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array){
		this.print(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final String str){
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * 配列を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final char c){
		this.print(array[0]);
		for(int i = 1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final String str){
		this.print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final char c){
		this.print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * 配列を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array){
		this.println(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * 配列を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * リストを空白区切りで改行無しで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list){
		this.println(list,' ');
	}

	/**
	 * リストを指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final String str){
		if(!list.isEmpty()){
			this.print(list.getFirst());
			for(int i = 1;i<list.size();++i){
				this.print(str);
				this.print(list.get(i));
			}
		}
		this.println();
	}

	/**
	 * リストを指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final char c){
		if(!list.isEmpty()){
			this.print(list.getFirst());
			for(int i = 1;i<list.size();++i){
				this.print(c);
				this.print(list.get(i));
			}
		}
		this.println();
	}

	/**
	 * この SimpleWriter を表す文字列を返します。
	 *
	 * @return この SimpleWriter を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "SimpleWriter["+this.hashCode()+"]";
	}

	/**
	 * SimpleWriter クラス用の SimpleOutputStream クラスです。<br/>
	 * ちょっとだけ速いです。
	 */
	public static final class SimpleOutputStream{

		/**
		 * この SimpleOutputStream のバッファーです。
		 */
		private final byte[] buf;

		/**
		 * この SimpleOutputStream のバッファーにある文字数を管理する変数です。
		 */
		private int count;

		/**
		 * この SimpleOutputStream の元となる OutputStream です。
		 */
		private OutputStream outputStream;

		/**
		 * 指定された OutputStream とバッファーサイズを元に SimpleOutputStream を生成します。
		 *
		 * @param out SimpleOutputStream の元となる OutputStream
		 * @param size バッファーサイズ
		 */
		public SimpleOutputStream(final OutputStream out,final int size){
			this.count = 0;
			this.outputStream = out;
			if(size<=0){
				throw new IllegalArgumentException("Buffer size <= 0");
			}
			this.buf = new byte[size];
		}

		/**
		 * バッファリングしている文字を OutputStream に書き込みます。
		 *
		 * @throws IOException OutputStream::write 由来の Exception
		 */
		private void flushBuffer() throws IOException{
			if(this.count>0){
				this.outputStream.write(this.buf,0,this.count);
				this.count = 0;
			}
		}

		/**
		 * 引数の値をバッファリングします。
		 *
		 * @param i バッファリング対象
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final int i) throws IOException{
			if(this.count>=this.buf.length){
				this.flushBuffer();
			}
			this.buf[this.count] = (byte)i;
			this.count += 1;
		}

		/**
		 * 引数の char[] の指定された文字数分をバッファリングします。
		 *
		 * @param chars 元となる char[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final char[] chars,final int off,final int len) throws IOException{
			if(len>=this.buf.length){
				this.flushBuffer();
				this.outputStream.write(parseByteArray(chars,off,len),0,len);
				return;
			}
			if(len>this.buf.length-this.count){
				this.flushBuffer();
			}
			for(int i = 0;i<len;i++){
				this.buf[this.count+i] = (byte)chars[i+off];
			}
			this.count += len;
		}

		/**
		 * 指定された char[] の区間を byte[] に変換します。
		 *
		 * @param chars 元となる char[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @return 変換後の byte[]
		 */
		private static byte[] parseByteArray(final char[] chars,final int off,final int len){
			final byte[] ans = new byte[len];
			for(int i = 0;i<len;i++){
				ans[i] = (byte)chars[i+off];
			}
			return ans;
		}

		/**
		 * 指定された byte[] の要素分バッファリングします。
		 *
		 * @param bytes 元となる byte[]
		 * @param off 開始地点
		 * @param len 要素数
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final byte[] bytes,final int off,final int len) throws IOException{
			if(len>=this.buf.length){
				this.flushBuffer();
				this.outputStream.write(bytes,off,len);
				return;
			}
			if(len>this.buf.length-this.count){
				this.flushBuffer();
			}
			System.arraycopy(bytes,off,this.buf,this.count,len);
			this.count += len;
		}

		/**
		 * バッファリングしている文字を書き込み、OutputStream をフラッシュします。
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void flush() throws IOException{
			this.flushBuffer();
			this.outputStream.flush();
		}

		/**
		 * この SimpleOutputStream の元となる OutputStream を閉じます。
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void close() throws IOException{
			this.flush();
			this.outputStream.close();
			this.outputStream = null;
		}

		/**
		 * この SimpleOutputStream を表す文字列を返します。
		 *
		 * @return この SimpleOutputStream を表す文字列
		 */
		@Override
		@Deprecated
		public String toString(){
			return "SimpleOutputStream["+this.hashCode()+"]";
		}
	}
}

/**
 * ソートに関するメソッドを提供するクラスです。<br/>
 * カウントソートや挿入ソート、プリミティヴ型のソートでの比較関数の指定など、<br/>
 * Arrays::sort でカバーできない部分を提供します。
 */
@SuppressWarnings("unused")
final class Sorter{

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private Sorter() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * int 型配列を比較関数を元にソートします。<br/>
	 * ソートアルゴリズムはマージソートを採用しています。
	 *
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final int[] array,final IntBinaryOperator comparator){
		final int length = array.length;
		if(length<2){
			return;
		}
		final int len1 = length>>1;
		final int len2 = length-len1;
		final int[] array1 = new int[len1];
		final int[] array2 = new int[len2];
		System.arraycopy(array,0,array1,0,len1);
		System.arraycopy(array,len1,array2,0,len2);
		sort(array1,comparator);
		sort(array2,comparator);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<len1&&j<len2){
			if(comparator.applyAsInt(array1[i],array[j])<=0){
				array[k] = array1[i];
				i += 1;
			}
			else{
				array[k] = array2[j];
				j += 1;
			}
			k += 1;
		}
		while(i<len1){
			array[k] = array1[i];
			i += 1;
			k += 1;
		}
		while(j<len2){
			array[k] = array2[j];
			j += 1;
			k += 1;
		}
	}

	/**
	 * long 型配列を比較関数を元にソートします。<br/>
	 * ソートアルゴリズムはマージソートを採用しています。
	 *
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final long[] array,final LongBinaryOperator comparator){
		final int length = array.length;
		if(length<2){
			return;
		}
		final int len1 = length>>1;
		final int len2 = length-len1;
		final long[] array1 = new long[len1];
		final long[] array2 = new long[len2];
		System.arraycopy(array,0,array1,0,len1);
		System.arraycopy(array,len1,array2,0,len2);
		sort(array1,comparator);
		sort(array2,comparator);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<len1&&j<len2){
			if(comparator.applyAsLong(array1[i],array[j])<=0){
				array[k] = array1[i];
				i += 1;
			}
			else{
				array[k] = array2[j];
				j += 1;
			}
			k += 1;
		}
		while(i<len1){
			array[k] = array1[i];
			i += 1;
			k += 1;
		}
		while(j<len2){
			array[k] = array2[j];
			j += 1;
			k += 1;
		}
	}

	/**
	 * char 型配列を比較関数を元にソートします。<br/>
	 * ソートアルゴリズムはマージソートを採用しています。
	 *
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final char[] array,final IntBinaryOperator comparator){
		final int length = array.length;
		if(length<2){
			return;
		}
		final int len1 = length>>1;
		final int len2 = length-len1;
		final char[] array1 = new char[len1];
		final char[] array2 = new char[len2];
		System.arraycopy(array,0,array1,0,len1);
		System.arraycopy(array,len1,array2,0,len2);
		sort(array1,comparator);
		sort(array2,comparator);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<len1&&j<len2){
			if(comparator.applyAsInt(array1[i],array[j])<=0){
				array[k] = array1[i];
				i += 1;
			}
			else{
				array[k] = array2[j];
				j += 1;
			}
			k += 1;
		}
		while(i<len1){
			array[k] = array1[i];
			k += 1;
			i += 1;
		}
		while(j<len2){
			array[k] = array2[j];
			k += 1;
			j += 1;
		}
	}

	/**
	 * double 型配列を比較関数を元にソートします。<br/>
	 * ソートアルゴリズムはマージソートを採用しています。
	 *
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final double[] array,final DoubleBinaryOperator comparator){
		final int length = array.length;
		if(length<2){
			return;
		}
		final int len1 = length>>1;
		final int len2 = length-len1;
		final double[] array1 = new double[len1];
		final double[] array2 = new double[len2];
		System.arraycopy(array,0,array1,0,len1);
		System.arraycopy(array,len1,array2,0,len2);
		sort(array1,comparator);
		sort(array2,comparator);
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<len1&&j<len2){
			if(comparator.applyAsDouble(array1[i],array[j])<=0){
				array[k] = array1[i];
				i += 1;
			}
			else{
				array[k] = array2[j];
				j += 1;
			}
			k += 1;
		}
		while(i<len1){
			array[k] = array1[i];
			k += 1;
			i += 1;
		}
		while(j<len2){
			array[k] = array2[j];
			k += 1;
			j += 1;
		}
	}

	/**
	 * カウントソートによるソートです。<br/>
	 * 各要素が 0 以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 * @param maximumLimit array 内の最大要素
	 */
	public static void countSort(final int[] array,final int maximumLimit){
		countSort(array,0,array.length,maximumLimit);
	}

	/**
	 * カウントソートによるソートです。<br/>
	 * 各要素が 0 以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 * @param maximumLimit array 内の最大要素
	 */
	public static void countSort(final int[] array,final int left,final int right,final int maximumLimit){
		final int[] list = new int[maximumLimit+1];
		for(int i = left;i<right;++i){
			list[array[i]] += 1;
		}
		int temp = left;
		for(int i = 0;i<list.length;++i){
			while(list[i]>0){
				list[i] -= 1;
				array[temp] = i;
				temp += 1;
			}
			list[i] -= 1;
		}
	}

	/**
	 * カウントソートによるソートです。<br/>
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 * @param maximumLimit array 内の最大要素
	 */
	public static void countSort(final char[] array,final char maximumLimit){
		countSort(array,0,array.length,maximumLimit);
	}

	/**
	 * カウントソートによるソートです。<br/>
	 * 各要素が 0 以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 * @param maximumLimit array 内の最大要素
	 */
	public static void countSort(final char[] array,final int left,final int right,final char maximumLimit){
		final int[] list = new int[maximumLimit+1];
		for(int i = left;i<right;++i){
			++list[array[i]];
		}
		int temp = left;
		for(char c = 0;c<list.length;++c){
			while(list[c]>0){
				list[c] -= 1;
				array[temp] = c;
				temp += 1;
			}
			list[c] -= 1;
		}
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 */
	public static void insertSort(final int[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void insertSort(final int[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final int num = array[j];
			while(left<j&&array[j-1]>num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の long 型配列
	 */
	public static void insertSort(final long[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の long 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void insertSort(final long[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final long num = array[j];
			while(left<j&&array[j-1]>num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 */
	public static void insertSort(final char[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void insertSort(final char[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final char num = array[j];
			while(left<j&&array[j-1]>num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void insertSort(final E[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void insertSort(final E[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final E num = array[j];
			while(left<j&&array[j-1].compareTo(num)>0){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 */
	public static void reverseInsertSort(final int[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の int 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void reverseInsertSort(final int[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final int num = array[j];
			while(left<j&&array[j-1]<num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の long 型配列
	 */
	public static void reverseInsertSort(final long[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の long 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void reverseInsertSort(final long[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final long num = array[j];
			while(left<j&&array[j-1]<num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 */
	public static void reverseInsertSort(final char[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の char 型配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 */
	public static void reverseInsertSort(final char[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final char num = array[j];
			while(left<j&&array[j-1]<num){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void reverseInsertSort(final E[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。<br/>
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param left ソート範囲の左端 (left を含む)
	 * @param right ソート範囲の右端 (right を含まない)
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void reverseInsertSort(final E[] array,final int left,final int right){
		for(int i = left+1;i<right;i++){
			int j = i;
			final E num = array[j];
			while(left<j&&array[j-1].compareTo(num)<0){
				array[j] = array[j-1];
				j -= 1;
			}
			array[j] = num;
		}
	}
}

/**
 * StaticRollingHash クラスです。<br/>
 * 一応文字列連結メソッドなどを実装していますが、
 * ハッシュ値を再計算するため、高頻度での使用は推奨されません。
 */
@SuppressWarnings("unused")
final class StaticRollingHash implements Comparable<StaticRollingHash>{

	/**
	 * 底となる値です。<br/>
	 * 実行時に決まります。
	 */
	private static final long BASE;

	static{
		final Random random = new Random();
		BASE = random.nextInt(1000)+Character.MAX_VALUE+1;
	}

	/**
	 * 剰余計算用の変数です。
	 */
	private static final long MASK30, MASK31, MOD, MASK61;

	/**
	 * 剰余計算用のシフト幅です。
	 */
	private static final int SHIFT_VALUE;

	static{
		SHIFT_VALUE = 31;
		MASK30 = (1L<<30)-1;
		MASK31 = (1L<<SHIFT_VALUE)-1;
		MOD = (1L<<61)-1;
		MASK61 = MOD;
	}

	/**
	 * ハッシュ値記録用の配列です。
	 */
	private final long[] hash;

	/**
	 * この StaticRollingHash インスタンスが表す文字列です。
	 */
	private final String str;

	/**
	 * 引数の文字列を元に StaticRollingHash を構築します。
	 *
	 * @param s 元となる String
	 */
	public StaticRollingHash(final String s){
		this.str = s;
		this.hash = new long[s.length()+1];
		this.roll();
	}

	/**
	 * フィールドの Stringを元にハッシュ値を計算します。
	 */
	private void roll(){
		final int len = this.str.length();
		for(int i = 1;i<=len;++i){
			this.hash[i] = multiply(this.hash[i-1],BASE)+this.str.charAt(i-1)-' '+1;
			if(MOD<=this.hash[i]){
				this.hash[i] -= MOD;
			}
		}
	}

	/**
	 * long * long 用の特別メソッドです。
	 *
	 * @param value1 乗算する値
	 * @param value2 乗算される値
	 *
	 * @return value1 * value2 mod 2 ** 61 - 1
	 */
	private static long multiply(final long value1,final long value2){
		final long au = value1>>SHIFT_VALUE;
		final long ad = value1&MASK31;
		final long bu = value2>>SHIFT_VALUE;
		final long bd = value2&MASK31;
		final long mid = ad*bu+au*bd;
		final long midTop = mid>>30;
		final long midBottom = mid&MASK30;
		return mod(au*bu*2+midTop+(midBottom<<SHIFT_VALUE)+ad*bd);
	}

	/**
	 * x mod 2 ** 61 - 1 を計算します。
	 *
	 * @param x 元となる値
	 *
	 * @return x mod 2 ** 61 - 1
	 */
	private static long mod(final long x){
		final long xu = x>>61;
		final long xd = x&MASK61;
		long ans = xu+xd;
		if(MOD<=ans){
			ans -= MOD;
		}
		return ans;
	}

	/**
	 * ハッシュ値を計算します。
	 *
	 * @param left 左端
	 * @param right 右端
	 *
	 * @return [left,right] のハッシュ値
	 */
	public long getHash(final int left,final int right){
		return (this.hash[right]-multiply(this.hash[left],modBasePow(right-left))+MOD)%MOD;
	}

	/**
	 * BASE ** exp mod 2 ** 61 - 1 を計算します。
	 *
	 * @param exp 指数
	 *
	 * @return BASE ** exp mod 2 ** 61 - 1
	 */
	private static long modBasePow(long exp){
		long ans = 1;
		long a = BASE;
		while(exp>0){
			if((exp&1)==1){
				ans = multiply(ans,a);
			}
			a = multiply(a,a);
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * 指定された区間と引数の指定された区間が等しいか返します。
	 *
	 * @param rh 比較対象の StaticRollingHash
	 * @param l1 この StaticRollingHash の左端
	 * @param r1 この StaticRollingHash の右端
	 * @param l2 比較対象の左端
	 * @param r2 比較対象の右端
	 *
	 * @return 等しい可能性があるなら true、確実に異なるなら false
	 */
	public boolean equals(final StaticRollingHash rh,final int l1,final int r1,final int l2,final int r2){
		if(r1-l1!=r2-l2){
			return false;
		}
		return this.getHash(l1,r1)==rh.getHash(l2,r2);
	}

	/**
	 * この StaticRollingHash の長さを返します。
	 *
	 * @return この StaticRollingHash の長さ
	 */
	public int length(){
		return this.str.length();
	}

	/**
	 * この StaticRollingHash の元となる String のハッシュ値を返します。
	 *
	 * @return この StaticRollingHash の元となる String のハッシュ値
	 */
	@Override
	public int hashCode(){
		return (int)this.hash[this.length()];
	}

	/**
	 * この StaticRollingHash の元となる String を返します。
	 *
	 * @return この StaticRollingHash の元となる String
	 */
	@Override
	public String toString(){
		return this.str;
	}

	/**
	 * 引数と自身が等しいか返します。
	 *
	 * @param obj 比較対象
	 *
	 * @return 等しい可能性があるなら true、確実に異なるなら false
	 */
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof final StaticRollingHash rh){
			return this.equals(rh,0,this.length(),0,rh.length());
		}
		return false;
	}

	/**
	 * 引数の StaticRollingHash の元となる String と辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	@Override
	public int compareTo(final StaticRollingHash rh){
		return this.str.compareTo(rh.toString());
	}

	/**
	 * 引数の String と辞書順で比較します。
	 *
	 * @param s the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareTo(final String s){
		return this.str.compareTo(s);
	}

	/**
	 * この StaticRollingHash の i 文字目を返します。
	 *
	 * @param i インデックス
	 *
	 * @return i 番目の文字を表す char
	 */
	public char charAt(final int i){
		return this.str.charAt(i);
	}

	/**
	 * 引数の StaticRollingHash の元となる String と大文字小文字を無視して辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareToIgnoreCase(final StaticRollingHash rh){
		return this.str.compareToIgnoreCase(rh.toString());
	}

	/**
	 * 引数の String と大文字小文字を無視して辞書順で比較します。
	 *
	 * @param s the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareToIgnoreCase(final String s){
		return this.str.compareToIgnoreCase(s);
	}

	/**
	 * 引数の StaticRollingHash を末尾に連結します。<br/>
	 * 計算量は O(length + rh.length) です。
	 *
	 * @param rh 連結する文字列を表す StaticRollingHash
	 *
	 * @return 結合した文字列を表す StaticRollingHash
	 */
	public StaticRollingHash concat(final StaticRollingHash rh){
		return this.concat(rh.toString());
	}

	/**
	 * 引数の String を末尾に連結します。<br/>
	 * 計算量は O(length + s.length) です。
	 *
	 * @param s 連結する文字列
	 *
	 * @return 結合した文字列を表す StaticRollingHash
	 */
	public StaticRollingHash concat(final String s){
		return new StaticRollingHash(this.str+s);
	}

	/**
	 * この StaticRollingHash の連続部分列として引数の StaticRollingHash が存在するか判定します。
	 *
	 * @param rh 連続部分列として存在するか検査する StaticRollingHash
	 *
	 * @return 部分列として存在する可能性があるなら true、確実に含まれていないなら false
	 */
	public boolean contains(final StaticRollingHash rh){
		final long h = rh.getHash(0,rh.length());
		final int len = this.length()-rh.length();
		for(int i = 0;i<=len;++i){
			if(h==this.getHash(i,rh.length()+i)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 引数の String が連続部分列として存在するか判定します。
	 *
	 * @param s 存在判定をする String
	 *
	 * @return 連続部分列として存在するなら true、それ以外は false
	 */
	public boolean contains(final String s){
		return this.indexOf(s)!=-1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int indexOf(final int charValue){
		return this.indexOf(charValue,0);
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int indexOf(final int charValue,final int fromIndex){
		final int len = this.length();
		for(int i = fromIndex;i<len;++i){
			if(this.str.charAt(i)==charValue){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字列が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param s 探索する文字列
	 *
	 * @return 最も左側にある引数の文字列のインデックス (無ければ -1)
	 */
	public int indexOf(final String s){
		return this.indexOf(s,0);
	}

	/**
	 * 引数の文字列を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param s 探索する文字列
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字列のインデックス (無ければ -1)
	 */
	public int indexOf(final String s,final int fromIndex){
		long h = 0;
		for(final char c: s.toCharArray()){
			h = multiply(h,BASE)+c-' '+1;
			if(MOD<=h){
				h -= MOD;
			}
		}
		final int len = this.length()-s.length();
		for(int i = fromIndex;i<=len;++i){
			if(h==this.getHash(i,s.length()+i)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * この StaticRollingHash が表す文字列が空文字列か判定します。
	 *
	 * @return ""と等しいなら true、それ以外は false
	 */
	public boolean isEmpty(){
		return this.length()==0;
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も右側にある引数の文字のインデックス (無ければ -1)
	 */
	public int lastIndexOf(final int charValue,final int fromIndex){
		for(int i = fromIndex;i>=0;--i){
			if(this.str.charAt(i)==charValue){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int lastIndexOf(final int charValue){
		return this.lastIndexOf(charValue,this.length()-1);
	}

	/**
	 * 引数の boolean を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param boolValue 元となる boolean
	 *
	 * @return 引数の boolean を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final boolean boolValue){
		return new StaticRollingHash(boolValue?"true":"false");
	}

	/**
	 * 引数の char を元に StaticRollingHash を構築します。
	 *
	 * @param c 元となる char
	 *
	 * @return 引数の char を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char c){
		return new StaticRollingHash(""+c);
	}

	/**
	 * 引数の char[] を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param chars 元となる char[]
	 *
	 * @return 引数の char[] を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] chars){
		return new StaticRollingHash(String.valueOf(chars,0,chars.length));
	}

	/**
	 * 引数の char[] を表す文字列の、引数の区間を元に StaticRollingHash を構築します。
	 *
	 * @param chars 元となる char[]
	 * @param offset 左端
	 * @param count 文字数
	 *
	 * @return 引数の char[] の引数の区間を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] chars,final int offset,final int count){
		return new StaticRollingHash(String.valueOf(chars,offset,count));
	}

	/**
	 * 引数の double を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param d 元となる double
	 *
	 * @return 引数の double を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final double d){
		return new StaticRollingHash(String.valueOf(d));
	}

	/**
	 * 引数の float を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param f 元となる float
	 *
	 * @return 引数の float を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final float f){
		return new StaticRollingHash(String.valueOf(f));
	}

	/**
	 * 引数の int を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param i 元となる int
	 *
	 * @return 引数の int を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final int i){
		return new StaticRollingHash(String.valueOf(i));
	}

	/**
	 * 引数の long を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param l 元となる long
	 *
	 * @return 引数の long を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final long l){
		return new StaticRollingHash(String.valueOf(l));
	}

	/**
	 * 引数の Object を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param obj 元となる Object
	 *
	 * @return 引数の Object を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final Object obj){
		return new StaticRollingHash(String.valueOf(obj));
	}
}

/**
 * Tree クラスです。<br/>
 * java.util.TreeSet と基本変わりませんが、インデックスを指定してのアクセスが O(log N) で可能です。
 *
 * @param <E> Tree に載せる要素の型
 */
@SuppressWarnings("unused")
final class Tree<E extends Comparable<E>>{

	/**
	 * 根を表す Node です。
	 */
	private Node<E> root;

	/**
	 * 状態管理用の変数です。
	 */
	private int size, hash;

	/**
	 * 空の Tree クラスを生成します。
	 */
	public Tree(){
		this.size = 0;
		this.root = null;
		this.hash = 0;
	}

	/**
	 * 要素を保持する Node クラスです。
	 */
	private static final class Node<E>{

		/**
		 * この Node インスタンスが持つ要素です。
		 */
		private E value;

		/**
		 * 状態管理用の変数です。
		 */
		private int height, innerSize;

		/**
		 * 親、左右の Node を保持する変数です。
		 */
		private Node<E> left, right, parent;

		/**
		 * 指定された情報を元に Node インスタンスを生成します。
		 *
		 * @param p 親となる Node インスタンス
		 * @param v 要素
		 */
		public Node(final Node<E> p,final E v){
			this.value = v;
			this.parent = p;
			this.height = 1;
			this.innerSize = 1;
			this.left = null;
			this.right = null;
		}

		/**
		 * この Node を表す文字列を返します。
		 *
		 * @return この Node を表す文字列
		 */
		@Override
		public String toString(){
			return "Node["+this.value+"]";
		}
	}

	/**
	 * 引数の要素をこの Tree インスタンスに追加しようと試みます。
	 *
	 * @param x 追加する要素
	 *
	 * @return 追加されたら true、それ以外は false
	 */
	public boolean add(final E x){
		boolean wasAdded = true;
		if(this.root==null){
			this.root = new Node<>(null,x);
		}
		else{
			Node<E> par;
			Node<E> now = this.root;
			do{
				par = now;
				final int result = x.compareTo(now.value);
				if(result<0){
					now = now.left;
				}
				else if(result>0){
					now = now.right;
				}
				else{
					wasAdded = false;
					break;
				}
			}while(now!=null);
			if(wasAdded){
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node<>(par,x);
				}
				else{
					par.right = new Node<>(par,x);
				}
				this.fix(par);
			}
		}
		if(wasAdded){
			this.size += 1;
			this.hash ^= x.hashCode();
		}
		return wasAdded;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 *
	 * @param index インデックス
	 *
	 * @return 先頭から index 番目の要素
	 */
	public E get(int index){
		if(this.root==null||this.size<=index){
			throw new IndexOutOfBoundsException();
		}
		Node<E> now = this.root;
		while(now!=null){
			final int ls = now.left!=null?now.left.innerSize:0;
			if(index<ls){
				now = now.left;
			}
			else if(ls<index){
				now = now.right;
				index -= ls+1;
			}
			else{
				break;
			}
		}
		return now==null?null:now.value;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 *
	 * @param x インデックス
	 *
	 * @return 先頭から index 番目の要素
	 */
	public int getIndex(final E x){
		Node<E> now = this.root;
		int index = 0;
		while(now!=null){
			final int result = now.value.compareTo(x);
			if(0<result){
				now = now.left;
			}
			else{
				index += now.left==null?0:now.left.innerSize;
				if(result<0){
					now = now.right;
					index += 1;
				}
				else{
					return index;
				}
			}
		}
		return ~index;
	}

	/**
	 * 引数の要素を削除しようと試みます。
	 *
	 * @param x 削除する要素
	 *
	 * @return 要素が削除できたら true、それ以外は false
	 */
	public boolean remove(final E x){
		final Node<E> node = this.getNode(x);
		if(node==null){
			return false;
		}
		this.size -= 1;
		this.hash ^= node.value.hashCode();
		this.delete(node);
		return true;
	}

	/**
	 * 引数の Node インスタンスを削除します。
	 *
	 * @param node 削除対象
	 */
	private void delete(final Node<E> node){
		if(node==null){
			return;
		}
		if(node.left==null&&node.right==null){
			if(node.parent==null){
				this.root = null;
			}
			else{
				if(node.parent.left==node){
					node.parent.left = null;
				}
				else{
					node.parent.right = null;
				}
				this.fix(node.parent);
			}
			node.parent = null;
		}
		else{
			if(node.left!=null&&node.right!=null){
				final Node<E> rep = getFirstNode(node.right);
				node.value = rep.value;
				this.delete(rep);
			}
			else{
				final Node<E> rep = node.left!=null?node.left:node.right;
				rep.parent = node.parent;
				if(node.parent==null){
					this.root = rep;
				}
				else{
					if(node.parent.left==node){
						node.parent.left = rep;
					}
					else{
						node.parent.right = rep;
					}
					this.fix(node.parent);
				}
				node.parent = null;
			}
		}
	}

	/**
	 * 指定された要素を持つ Node インスタンスを返します。<br/>
	 * 無い場合は null を返します。
	 *
	 * @param x 指定する要素
	 *
	 * @return 指定された要素を持つ Node インスタンス
	 */
	private Node<E> getNode(final E x){
		Node<E> now = this.root;
		while(now!=null){
			final int result = x.compareTo(now.value);
			if(result<0){
				now = now.left;
			}
			else if(result>0){
				now = now.right;
			}
			else{
				break;
			}
		}
		return now;
	}

	/**
	 * この Tree インスタンスの先頭の要素を返します。<br/>
	 * もしこの Tree インスタンスが空なら null を返します。
	 *
	 * @return この Tree インスタンスの先頭の要素
	 */
	public E first(){
		if(this.root==null){
			return null;
		}
		return getFirstNode(this.root).value;
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の先頭の要素を持つ Node インスタンスを返します。<br/>
	 * 指定する Node インスタンスは null でないことを要求します。
	 *
	 * @param node 根とする Node インスタンス
	 *
	 * @return この部分木の先頭の要素を持つ Node インスタンス
	 */
	private static <E extends Comparable<E>> Node<E> getFirstNode(Node<E> node){
		if(node==null){
			throw new NullPointerException();
		}
		Node<E> par = null;
		while(node!=null){
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * この Tree インスタンスの末尾の要素を返します。<br/>
	 * もしそのような要素が存在しない場合は null を返します。
	 *
	 * @return この Tree インスタンスの末尾の要素
	 */
	public E last(){
		if(this.root==null){
			return null;
		}
		return this.getLastNode(this.root).value;
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の末尾の要素を持つ Node インスタンスを返します。<br/>
	 * 指定する Node インスタンスは null でないことを要求します。
	 *
	 * @param node 根とする Node インスタンス
	 *
	 * @return この部分木の末尾の要素を持つ Node インスタンス
	 */
	private Node<E> getLastNode(Node<E> node){
		if(node==null){
			throw new NullPointerException();
		}
		Node<E> par = null;
		while(node!=null){
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 指定された要素がこの Tree インスタンスに存在するか判定します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return 指定された要素が存在するなら true、それ以外は false
	 */
	public boolean contains(final E x){
		if(this.root==null){
			return false;
		}
		return this.getNode(x)!=null;
	}

	/**
	 * この Tree インスタンスの先頭の要素を取得し、削除します。<br/>
	 * もしそのような要素が存在しない場合は null を返します。
	 *
	 * @return この Tree インスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(this.root==null){
			return null;
		}
		--this.size;
		final Node<E> min = getFirstNode(this.root);
		this.hash ^= min.value.hashCode();
		this.delete(min);
		return min.value;
	}

	/**
	 * この Tree インスタンスの末尾の要素を取得し、削除します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @return この Tree インスタンスの末尾の要素
	 */
	public E pollLast(){
		if(this.root==null){
			return null;
		}
		--this.size;
		final Node<E> max = this.getLastNode(this.root);
		this.hash ^= max.value.hashCode();
		this.delete(max);
		return max.value;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return x と同等かそれ以降の要素で最小の要素
	 */
	public E ceiling(final E x){
		return this.ceiling(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の、
	 * x と同等かそれ以降の要素で最小の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return x と同等かそれ以降の要素で最小の要素
	 */
	private E ceiling(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>0){
				node = node.right;
			}
			else if(result<0){
				ans = node;
				node = node.left;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以降の要素で最小の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return x 以降の要素で最小の要素
	 */
	public E higher(final E x){
		return this.higher(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の、
	 * x 以降の要素で最小の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return x 以降の要素で最小の要素
	 */
	private E higher(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>=0){
				node = node.right;
			}
			else{
				ans = node;
				node = node.left;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素と同等かそれ以前の要素で最大の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return x と同等かそれ以前の要素で最大の要素
	 */
	public E floor(final E x){
		return this.floor(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の、
	 * x と同等かそれ以前の要素で最大の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return x と同等かそれ以前の要素で最大の要素
	 */
	private E floor(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<0){
				node = node.left;
			}
			else if(result>0){
				ans = node;
				node = node.right;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以前の要素で最大の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return x 以前の要素で最大の要素
	 */
	public E lower(final E x){
		return this.lower(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の、
	 * x 以前の要素で最大の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return x 以前の要素で最大の要素
	 */
	private E lower(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<=0){
				node = node.left;
			}
			else{
				ans = node;
				node = node.right;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * この Tree インスタンスを空にします。
	 */
	public void clear(){
		this.root = null;
		this.size = 0;
		this.hash = 0;
	}

	/**
	 * この Tree インスタンスが空か判定します。
	 *
	 * @return この Tree インスタンスが空なら true、それ以外は false
	 */
	public boolean isEmpty(){
		return this.size==0;
	}

	/**
	 * この Tree インスタンスの要素数を返します。
	 *
	 * @return この Tree インスタンスの要素数
	 */
	public int size(){
		return this.size;
	}

	/**
	 * この Tree インスタンスと同等な ArrayList を返します。<br/>
	 * 各要素は Tree インスタンスの要素と連動します。
	 *
	 * @return この Tree インスタンスを表す ArrayList
	 */
	public ArrayList<E> toList(){
		final ArrayList<E> list = new ArrayList<>(this.size);
		if(this.root==null){
			return list;
		}
		final ArrayDeque<Node<E>> deq = new ArrayDeque<>(this.size);
		deq.add(this.root);
		while(!deq.isEmpty()){
			final Node<E> now = deq.pollLast();
			if(list.isEmpty()){
				if(now.left==null){
					list.add(now.value);
					if(now.right!=null){
						deq.add(now.right);
					}
				}
				else{
					deq.add(now);
					deq.add(now.left);
				}
			}
			else{
				final E last = list.getLast();
				if(now.left==null||last.compareTo(now.left.value)>=0){
					list.add(now.value);
					if(now.right!=null){
						deq.add(now.right);
					}
				}
				else{
					deq.add(now);
					deq.add(now.left);
				}
			}
		}
		return list;
	}

	/**
	 * この Tree インスタンスを表す String を返します。
	 */
	@Override
	public String toString(){
		final ArrayList<E> list = this.toList();
		return list.toString();
	}

	/**
	 * 引数がこの Tree インスタンスと同等か判定します。
	 */
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof final Tree<?> tree){
			if(this.size!=tree.size()){
				return false;
			}
			final ArrayList<E> list1 = this.toList();
			final ArrayList<?> list2 = tree.toList();
			for(int i = 0;i<this.size;++i){
				final E e = list1.get(i);
				if(!e.equals(list2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * この Tree を表すハッシュ値を返します。
	 */
	@Override
	public int hashCode(){
		return this.hash;
	}

	/**
	 * 指定された Node インスタンスを根の方向に辿りながら平衡を修正します。
	 *
	 * @param node 始点となる Node インスタンス
	 */
	private void fix(Node<E> node){
		while(node!=null){
			if(node.left==null){
				if(node.right!=null&&node.right.height>1){
					this.rotateL(node);
				}
			}
			else if(node.right==null){
				if(node.left.height>1){
					this.rotateR(node);
				}
			}
			else{
				final int lh = node.left.height;
				final int rh = node.right.height;
				if(lh-rh>1){
					if(node.left.right==null||node.left.right.height!=lh-1){
						this.rotateR(node);
					}
					else{
						this.rotateL(node.left);
						this.rotateR(node);
					}
				}
				else if(rh-lh>1){
					if(node.right.left==null||node.right.left.height!=rh-1){
						this.rotateL(node);
					}
					else{
						this.rotateR(node.right);
						this.rotateL(node);
					}
				}
			}
			this.setStates(node);
			node = node.parent;
		}
	}

	/**
	 * 指定された Node インスタンスを基点に右回転を適用します。
	 *
	 * @param node 基点となる Node インスタンス
	 */
	private void rotateR(final Node<E> node){
		final Node<E> temp = node.left;
		node.left = temp.right;
		if(node.left!=null){
			node.left.parent = node;
		}
		temp.right = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			this.root = temp;
		}
		node.parent = temp;
		this.setStates(node);
	}

	/**
	 * 指定された Node インスタンスを基点に左回転を適用します。
	 *
	 * @param node 基点となる Node インスタンス
	 */
	private void rotateL(final Node<E> node){
		final Node<E> temp = node.right;
		node.right = temp.left;
		if(node.right!=null){
			node.right.parent = node;
		}
		temp.left = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			this.root = temp;
		}
		node.parent = temp;
		this.setStates(node);
	}

	/**
	 * 指定された Node インスタンスの内部情報を更新します。
	 *
	 * @param node 更新対象の Node インスタンス
	 */
	private void setStates(final Node<E> node){
		final int lh = node.left==null?0:node.left.height;
		final int rh = node.right==null?0:node.right.height;
		node.height = Math.max(lh,rh)+1;
		final int ls = node.left==null?0:node.left.innerSize;
		final int rs = node.right==null?0:node.right.innerSize;
		node.innerSize = ls+rs+1;
	}
}

/**
 * TreeMulti クラスです。<br/>
 * java.util.TreeSet と基本変わりませんが、インデックスを指定してのアクセスが O(log N) で可能です。<br/>
 * また、同等な要素を複数追加できます。<br/>
 * 同等な要素は最初に追加した要素と等価として管理するので、
 * 別々に管理したい場合は順序を付けるようにしてください。
 *
 * @param <E> TreeMulti に載せる要素の型
 */
@SuppressWarnings("unused")
final class TreeMulti<E extends Comparable<E>>{

	/**
	 * この TreeMulti の根となる Node インスタンスを保持する変数です。
	 */
	private Node<E> root;

	/**
	 * この TreeMulti の要素数を保持する変数です。
	 */
	private long size;

	/**
	 * この TreeMulti のユニークな要素数を保持する変数です。
	 */
	private int uniqueSize;

	/**
	 * この TreeMulti のハッシュ値を保持する変数です。
	 */
	private int hash;

	/**
	 * 空の TreeMulti を生成します。
	 */
	public TreeMulti(){
		this.size = 0;
		this.uniqueSize = 0;
		this.root = null;
		this.hash = 0;
	}

	/**
	 * 要素を保持するための Node クラスです。
	 */
	private static final class Node<E>{

		/**
		 * この Node クラスが保持する要素です。
		 */
		private E value;

		/**
		 * 状態管理用の変数です。
		 */
		private long count, innerSize;
		private int height;

		/**
		 * 親、左右の子を保持する変数です。
		 */
		private Node<E> left, right, parent;

		/**
		 * 指定された情報を元に Node インスタンスを生成します。
		 *
		 * @param p 親となる Node インスタンス
		 * @param v 要素
		 * @param subSize 要素数
		 */
		public Node(final Node<E> p,final E v,final long subSize){
			this.value = v;
			this.parent = p;
			this.count = subSize;
			this.height = 1;
			this.innerSize = subSize;
			this.left = null;
			this.right = null;
		}

		/**
		 * この Node を表す文字列を返します。
		 *
		 * @return この Node を表す文字列
		 */
		@Override
		public String toString(){
			return "Node["+this.value+"]";
		}
	}

	/**
	 * 指定された要素を追加します。
	 *
	 * @param x 追加する要素
	 */
	public void add(final E x){
		if(this.root==null){
			this.root = new Node<>(null,x,1);
			++this.uniqueSize;
		}
		else{
			Node<E> par;
			Node<E> now = this.root;
			boolean wasAdded = true;
			do{
				par = now;
				final int result = x.compareTo(now.value);
				if(result<0){
					now = now.left;
				}
				else if(result>0){
					now = now.right;
				}
				else{
					wasAdded = false;
					++now.count;
					break;
				}
			}while(now!=null);
			if(wasAdded){
				++this.uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node<>(par,x,1);
				}
				else{
					par.right = new Node<>(par,x,1);
				}
			}
			this.fix(par);
		}
		++this.size;
		this.hash ^= x.hashCode();
	}

	/**
	 * 指定された要素を引数の値だけ追加します。
	 *
	 * @param x 追加する要素
	 * @param sum 追加する個数
	 */
	public void add(final E x,final long sum){
		if(this.root==null){
			this.root = new Node<>(null,x,sum);
			++this.uniqueSize;
		}
		else{
			Node<E> par;
			Node<E> now = this.root;
			boolean wasAdded = true;
			do{
				par = now;
				final int result = x.compareTo(now.value);
				if(result<0){
					now = now.left;
				}
				else if(result>0){
					now = now.right;
				}
				else{
					wasAdded = false;
					now.count += sum;
					this.fix(now);
					break;
				}
			}while(now!=null);
			if(wasAdded){
				++this.uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node<>(par,x,sum);
				}
				else{
					par.right = new Node<>(par,x,sum);
				}
				this.fix(par);
			}
		}
		this.size += sum;
		this.hash ^= sum%2==0?0:x.hashCode();
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * これはユニークな要素数ではなく全体の要素数でのインデックスです。
	 *
	 * @param index 取得する要素のインデックス
	 *
	 * @return 指定されたインデックスの要素
	 */
	public E get(long index){
		if(this.root==null||this.size<=index){
			throw new NullPointerException();
		}
		Node<E> now = this.root;
		while(now!=null){
			final long ls = now.left!=null?now.left.innerSize:0;
			if(index<ls){
				now = now.left;
			}
			else if(ls+now.count<=index){
				index -= ls+now.count;
				now = now.right;
			}
			else{
				break;
			}
		}
		return now==null?null:now.value;
	}

	/**
	 * 指定された要素を一つだけ削除しようと試みます。
	 *
	 * @param x 削除する要素
	 *
	 * @return 指定された要素が一つだけ削除されたら true、それ以外は false
	 */
	public boolean remove(final E x){
		final Node<E> node = this.getNode(x);
		if(node==null){
			return false;
		}
		--this.size;
		this.hash ^= node.hashCode();
		this.delete(node);
		return true;
	}

	/**
	 * 指定された要素を指定した個数分削除します。
	 * もし指定された個数だけ存在しない場合は削除できるだけ削除します。
	 *
	 * @param x 削除する要素
	 * @param sum 削除したい個数
	 *
	 * @return 削除に成功した個数
	 */
	public long remove(final E x,final long sum){
		final Node<E> node = this.getNode(x);
		if(node==null){
			return 0;
		}
		final long ans = Math.min(sum,node.count);
		this.size -= ans;
		this.hash ^= ans%2==0?0:node.hashCode();
		node.count -= ans-1;
		this.delete(node);
		return ans;
	}

	/**
	 * 指定された要素を全て削除します。
	 *
	 * @param x 削除する要素
	 *
	 * @return 削除した個数
	 */
	public long removeAll(final E x){
		final Node<E> node = this.getNode(x);
		if(node==null){
			return 0;
		}
		this.size -= node.count;
		final long ans = node.count;
		this.hash ^= ans%2==0?0:node.hashCode();
		node.count = 0;
		this.delete(node);
		return ans;
	}

	/**
	 * 指定された Node インスタンスを削除します。
	 *
	 * @param node 削除する Node インスタンス
	 */
	private void delete(final Node<E> node){
		if(node==null){
			return;
		}
		if(node.count>1){
			--node.count;
			this.fix(node);
			return;
		}
		if(node.left==null&&node.right==null){
			if(node.parent==null){
				this.root = null;
			}
			else{
				if(node.parent.left==node){
					node.parent.left = null;
				}
				else{
					node.parent.right = null;
				}
				this.fix(node.parent);
			}
			node.parent = null;
			--this.uniqueSize;
		}
		else{
			if(node.left==null||node.right==null){
				final Node<E> rep = node.left!=null?node.left:node.right;
				rep.parent = node.parent;
				if(node.parent==null){
					this.root = rep;
				}
				else{
					if(node.parent.left==node){
						node.parent.left = rep;
					}
					else{
						node.parent.right = rep;
					}
					this.fix(node.parent);
				}
				node.parent = null;
				--this.uniqueSize;
			}
			else{
				final Node<E> rep = getFirstNode(node.right);
				node.value = rep.value;
				node.count = rep.count;
				rep.count = 0;
				this.delete(rep);
			}
		}
	}

	/**
	 * 指定された要素を保持する Node インスタンスを返します。<br/>
	 * そのような Node インスタンスが存在しない場合、null を返します。
	 *
	 * @param x 探索対象の要素
	 *
	 * @return x を保持する Node インスタンス
	 */
	private Node<E> getNode(final E x){
		Node<E> now = this.root;
		while(now!=null){
			final int result = x.compareTo(now.value);
			if(result<0){
				now = now.left;
			}
			else if(result>0){
				now = now.right;
			}
			else{
				break;
			}
		}
		return now;
	}

	/**
	 * この TreeMulti の先頭の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @return この TreeMulti の先頭の要素
	 */
	public E first(){
		if(this.root==null){
			return null;
		}
		return getFirstNode(this.root).value;
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の先頭の要素を保持する Node インスタンスを返します。<br/>
	 * この Node インスタンスは null でないことを要求します。
	 *
	 * @param node 根とする Node インスタンス
	 *
	 * @return 先頭の要素を保持する Node インスタンス
	 */
	private static <E extends Comparable<E>> Node<E> getFirstNode(Node<E> node){
		if(node==null){
			throw new NullPointerException();
		}
		Node<E> par = null;
		while(node!=null){
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * この TreeMulti インスタンスの末尾の要素を返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @return この TreeMulti インスタンスの末尾の要素
	 */
	public E last(){
		if(this.root==null){
			return null;
		}
		return getLastNode(this.root).value;
	}

	/**
	 * 指定された Node インスタンスを根とする部分木の末尾の要素を保持する Node インスタンスを返します。<br/>
	 * この Node インスタンスは null でないことを要求します。
	 *
	 * @param node 根とする Node インスタンス
	 *
	 * @return 末尾の要素を保持する Node インスタンス
	 */
	private static <E extends Comparable<E>> Node<E> getLastNode(Node<E> node){
		if(node==null){
			throw new NullPointerException();
		}
		Node<E> par = null;
		while(node!=null){
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 指定された要素がこの TreeMulti インスタンスに存在するか判定します。
	 *
	 * @param x 探索対象
	 *
	 * @return この TreeMulti インスタンスに指定された要素が存在するなら true、それ以外は false
	 */
	public boolean contains(final E x){
		if(this.root==null){
			return false;
		}
		return this.getNode(x)!=null;
	}

	/**
	 * 指定された要素がこの TreeMulti インスタンスにいくつ存在するか返します。
	 *
	 * @param x 探索対象
	 *
	 * @return 指定された要素がこの TreeMulti インスタンスに存在する個数
	 */
	public long sum(final E x){
		if(this.root==null){
			return 0;
		}
		final Node<E> node = this.getNode(x);
		return node!=null?node.count:0;
	}

	/**
	 * この TreeMulti インスタンスの先頭の要素を取得し、削除します。
	 *
	 * @return この TreeMulti インスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(this.root==null){
			return null;
		}
		--this.size;
		final Node<E> min = getFirstNode(this.root);
		this.hash ^= min.value.hashCode();
		final E ans = min.value;
		this.delete(min);
		return ans;
	}

	/**
	 * この TreeMulti インスタンスの末尾の要素を取得し、削除します。
	 *
	 * @return この TreeMulti インスタンスの末尾の要素
	 */
	public E pollLast(){
		if(this.root==null){
			return null;
		}
		--this.size;
		final Node<E> max = getLastNode(this.root);
		this.hash ^= max.value.hashCode();
		final E ans = max.value;
		this.delete(max);
		return ans;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象
	 *
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
	 */
	public E ceiling(final E x){
		return this.ceiling(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
	 */
	private E ceiling(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>0){
				node = node.right;
			}
			else if(result<0){
				ans = node;
				node = node.left;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以降の要素で最小のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象
	 *
	 * @return 指定された要素以降の要素で最小のもの
	 */
	public E higher(final E x){
		return this.higher(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木のうち、
	 * 指定された要素以降の要素で最小のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return 指定された要素以降の要素で最小のもの
	 */
	private E higher(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result>=0){
				node = node.right;
			}
			else{
				ans = node;
				node = node.left;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象
	 *
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
	 */
	public E floor(final E x){
		return this.floor(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
	 */
	private E floor(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<0){
				node = node.left;
			}
			else if(result>0){
				ans = node;
				node = node.right;
			}
			else{
				return x;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * 指定された要素以前の要素で最大のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param x 探索対象
	 *
	 * @return 指定された要素以前の要素で最大のもの
	 */
	public E lower(final E x){
		return this.lower(this.root,x);
	}

	/**
	 * 指定された Node インスタンスを根とする部分木のうち、
	 * 指定された要素以前の要素で最大のものを返します。<br/>
	 * もしそのような要素が存在しない場合、null を返します。
	 *
	 * @param node 根とする Node インスタンス
	 * @param x 探索対象
	 *
	 * @return 指定された要素以前の要素で最大のもの
	 */
	private E lower(Node<E> node,final E x){
		Node<E> ans = null;
		while(node!=null){
			final int result = x.compareTo(node.value);
			if(result<=0){
				node = node.left;
			}
			else{
				ans = node;
				node = node.right;
			}
		}
		return ans!=null?ans.value:null;
	}

	/**
	 * この TreeMulti インスタンスのユニークな要素数を返します。
	 *
	 * @return この TreeMulti インスタンスのユニークな要素数
	 */
	public int size(){
		return this.uniqueSize;
	}

	/**
	 * この TreeMulti インスタンスの要素数を返します。
	 *
	 * @return この TreeMulti インスタンスの要素数
	 */
	public long sumSize(){
		return this.size;
	}

	/**
	 * この TreeMulti インスタンスと同等な ArrayList を返します。<br/>
	 * この ArrayList の要素と TreeMulti インスタンスの要素は連動しているため、
	 * 順序が入れ替わるような変更を加えた場合のこの TreeMulti の動作は未定義となります。
	 *
	 * @return この TreeMulti インスタンスと等価な ArrayList
	 */
	public ArrayList<E> toList(){
		final ArrayList<E> list = new ArrayList<>((int)this.size);
		if(this.root==null){
			return list;
		}
		final ArrayDeque<Node<E>> deq = new ArrayDeque<>((int)this.size);
		deq.add(this.root);
		while(!deq.isEmpty()){
			final Node<E> now = deq.pollLast();
			if(list.isEmpty()){
				if(now.left==null){
					for(int i = 0;i<now.count;++i){
						list.add(now.value);
					}
					if(now.right!=null){
						deq.add(now.right);
					}
				}
				else{
					deq.add(now);
					deq.add(now.left);
				}
			}
			else{
				final E last = list.getLast();
				if(now.left==null||last.compareTo(now.left.value)>=0){
					for(int i = 0;i<now.count;++i){
						list.add(now.value);
					}
					if(now.right!=null){
						deq.add(now.right);
					}
				}
				else{
					deq.add(now);
					deq.add(now.left);
				}
			}
		}
		return list;
	}

	/**
	 * この TreeMulti インスタンスを表す String を返します。
	 */
	@Override
	public String toString(){
		final ArrayList<E> list = this.toList();
		return list.toString();
	}

	/**
	 * この TreeMulti インスタンスと等価か判定します。
	 */
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof final TreeMulti<?> tree){
			if(this.size!=tree.size()){
				return false;
			}
			final ArrayList<E> array1 = this.toList();
			final ArrayList<?> array2 = tree.toList();
			for(int i = 0;i<this.size;++i){
				final E e = array1.get(i);
				if(!e.equals(array2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * この TreeMulti インスタンスを表すハッシュ値を返します。
	 */
	@Override
	public int hashCode(){
		return this.hash;
	}

	/**
	 * 指定された Node インスタンスを根の方向に辿りながら平衡を修正します。
	 *
	 * @param node 始点となる Node インスタンス
	 */
	private void fix(Node<E> node){
		while(node!=null){
			if(node.left==null){
				if(node.right!=null&&node.right.height>1){
					this.rotateL(node);
				}
			}
			else if(node.right==null){
				if(node.left.height>1){
					this.rotateR(node);
				}
			}
			else{
				final int lh = node.left.height;
				final int rh = node.right.height;
				if(lh-rh>1){
					if(node.left.right==null||node.left.right.height!=lh-1){
						this.rotateR(node);
					}
					else{
						this.rotateL(node.left);
						this.rotateR(node);
					}
				}
				else if(rh-lh>1){
					if(node.right.left==null||node.right.left.height!=rh-1){
						this.rotateL(node);
					}
					else{
						this.rotateR(node.right);
						this.rotateL(node);
					}
				}
			}
			setStates(node);
			node = node.parent;
		}
	}

	/**
	 * 指定された Node インスタンスを基点に右回転を適用します。
	 *
	 * @param node 基点となる Node インスタンス
	 */
	private void rotateR(final Node<E> node){
		final Node<E> temp = node.left;
		node.left = temp.right;
		if(node.left!=null){
			node.left.parent = node;
		}
		temp.right = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			this.root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定された Node インスタンスを基点に左回転を適用します。
	 *
	 * @param node 基点となる Node インスタンス
	 */
	private void rotateL(final Node<E> node){
		final Node<E> temp = node.right;
		node.right = temp.left;
		if(node.right!=null){
			node.right.parent = node;
		}
		temp.left = node;
		temp.parent = node.parent;
		if(node.parent!=null){
			if(node.parent.left==node){
				node.parent.left = temp;
			}
			else{
				node.parent.right = temp;
			}
		}
		else{
			this.root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定された Node インスタンスの状態を更新します。
	 *
	 * @param node 更新対象の Node インスタンス
	 */
	private static <E extends Comparable<E>> void setStates(final Node<E> node){
		final int lh = node.left==null?0:node.left.height;
		final int rh = node.right==null?0:node.right.height;
		node.height = Math.max(lh,rh)+1;
		final long ls = node.left==null?0:node.left.innerSize;
		final long rs = node.right==null?0:node.right.innerSize;
		node.innerSize = ls+rs+node.count;
	}
}

/**
 * UnionFind クラスです。
 * 連結成分の大きさの他、辺の数、連結成分の数も取得できます。
 */
@SuppressWarnings("unused")
final class UnionFind{

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
	 * 引数の 2 つの頂点を連結します。
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

/**
 * 重み付き UnionFind です。
 * 同じ連結成分内での相対的な重みを取得できます。
 */
@SuppressWarnings("unused")
final class WeightedUnionFind{

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
	 * 第一引数の頂点の重みを第二引数を基準にして求めます。
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
	 * 引数の 2 つの頂点を指定された重みで連結します。
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
		long sub = dx-dy+dif;
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
