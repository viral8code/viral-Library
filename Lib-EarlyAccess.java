import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleUnaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

//Maybe use
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

final class Main{
	private static final boolean autoFlush = false;
	private static final SimpleScanner sc = new SimpleScanner(System.in);
	private static final SimpleWriter out = new SimpleWriter(System.out,autoFlush);

	public static void main(String[] args){

		

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
 * 2次元配列の回転や1次元配列の区間反転などを提供します。
 */
final class ArrayUtil{

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
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
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
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の次に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で次に当たる配列がある場合はtrue、arrayが降順に並んでいるならfalse
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
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
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
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
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
	 * 引数の配列の要素を並び替えた時の、辞書順で引数の直前に当たる順番に並び替えます。
	 * 原則として、要素に重複が無いものとして処理します。重複がある場合の戻り値は保証されていません。
	 *
	 * @param array 並び替え対象の配列
	 *
	 * @return 辞書順で直前に当たる配列がある場合はtrue、arrayが昇順に並んでいるならfalse
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

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final int[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final long[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final char[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final boolean[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static <E> boolean isPalindrome(final E[] array){
		return isPalindrome(array,0,array.length);
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param l 区間の左端(lを含む)
	 * @param r 区間の右端(rを含まない)
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final int[] array,int l,int r){
		while(l<r)
			if(array[l++]!=array[--r])
				return false;
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param l 区間の左端(lを含む)
	 * @param r 区間の右端(rを含まない)
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final long[] array,int l,int r){
		while(l<r)
			if(array[l++]!=array[--r])
				return false;
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param l 区間の左端(lを含む)
	 * @param r 区間の右端(rを含まない)
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final char[] array,int l,int r){
		while(l<r)
			if(array[l++]!=array[--r])
				return false;
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param l 区間の左端(lを含む)
	 * @param r 区間の右端(rを含まない)
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static boolean isPalindrome(final boolean[] array,int l,int r){
		while(l<r)
			if(array[l++]!=array[--r])
				return false;
		return true;
	}

	/**
	 * 引数の配列の指定された区間が回文になっているか判定します。
	 *
	 * @param array 配列
	 * @param l 区間の左端(lを含む)
	 * @param r 区間の右端(rを含まない)
	 * @return 回文になっているならtrue、それ以外はfalse
	 */
	public static <E> boolean isPalindrome(final E[] array,int l,int r){
		while(l<r)
			if(array[l++].equals(array[--r]))
				return false;
		return true;
	}
}

/**
 * Binary Indexed Treeクラスです。
 * 引数は1-indexedであることを要求します。
 */
final class BIT{
	final int size;
	final private long[] tree;

	/**
	 * 大きさnのBITを生成します。
	 *
	 * @param n 生成するBITの大きさ
	 */
	public BIT(int n){
		size = n;
		tree = new long[n+1];
	}

	/**
	 * [1,i]の総和を求めます。
	 *
	 * @param i 求める区間の右端(iを含む)
	 *
	 * @return [1,i]の総和
	 */
	public long sum(int i){
		long sum = 0;
		while(i>0){
			sum += tree[i];
			i ^= i&(-i);
		}
		return sum;
	}

	/**
	 * i番目に引数の値を加算します。
	 *
	 * @param i 加算する位置
	 * @param x 加算する値
	 */
	public void add(int i,long x){
		while(i<=size){
			tree[i] += x;
			i += i&(-i);
		}
	}

	/**
	 * このBITの値を全て0にします。
	 */
	public void clear(){
		Arrays.fill(tree,0L);
	}
}

/**
 * Binary Indexed Treeのint特化クラスです。
 * 引数は1-indexedであることを要求します。
 */
final class BITInt{
	final int size;
	final private int[] tree;

	/**
	 * 大きさnのBITを生成します。
	 *
	 * @param n 生成するBITの大きさ
	 */
	public BITInt(int n){
		size = n;
		tree = new int[n+1];
	}

	/**
	 * [1,i]の総和を求めます。
	 *
	 * @param i 求める区間の右端(iを含む)
	 *
	 * @return [1,i]の総和
	 */
	public int sum(int i){
		int sum = 0;
		while(i>0){
			sum += tree[i];
			i ^= i&(-i);
		}
		return sum;
	}

	/**
	 * i番目に引数の値を加算します。
	 *
	 * @param i 加算する位置
	 * @param x 加算する値
	 */
	public void add(int i,int x){
		while(i<=size){
			tree[i] += x;
			i += i&(-i);
		}
	}

	/**
	 * このBITの値を全て0にします。
	 */
	public void clear(){
		Arrays.fill(tree,0);
	}
}

/**
 * Converterクラスです。
 * Stringを反転したりCollectionをプリミティヴ型の配列に変換するメソッドを提供します。
 */
final class Converter{
	/**
	 * 渡された文字列を逆順にした文字列を返します。
	 *
	 * @param str 元の文字列
	 *
	 * @return strを逆順にした文字列
	 */
	public static String reverse(final String str){
		final StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1;i>=0;--i){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static int[] toIntArray(final Collection<Integer> collection){
		final int[] ans = new int[collection.size()];
		int index = 0;
		for(int num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static long[] toLongArray(final Collection<Long> collection){
		final long[] ans = new long[collection.size()];
		int index = 0;
		for(long num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static char[] toCharArray(final Collection<Character> collection){
		final char[] ans = new char[collection.size()];
		int index = 0;
		for(char num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static double[] toDoubleArray(final Collection<Double> collection){
		final double[] ans = new double[collection.size()];
		int index = 0;
		for(double num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static boolean[] toBooleanArray(final Collection<Boolean> collection){
		final boolean[] ans = new boolean[collection.size()];
		int index = 0;
		for(boolean num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static byte[] toByteArray(final Collection<Byte> collection){
		final byte[] ans = new byte[collection.size()];
		int index = 0;
		for(byte num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static short[] toShortArray(final Collection<Short> collection){
		final short[] ans = new short[collection.size()];
		int index = 0;
		for(short num: collection){
			ans[index++] = num;
		}
		return ans;
	}

	/**
	 * 渡されたラッパークラスのCollectionをプリミティヴ型の配列に変換します。
	 *
	 * @param collection 元のCollection
	 *
	 * @return collectionの要素をプリミティヴ型に変換した配列
	 */
	public static float[] toFloatArray(final Collection<Float> collection){
		final float[] ans = new float[collection.size()];
		int index = 0;
		for(float num: collection){
			ans[index++] = num;
		}
		return ans;
	}
}

/**
 * 階乗計算用の Facttorial クラスです。
 * 引数Nに対して前計算をO(N)で行なうことでN以下の階乗とその逆元、N以下の逆元をO(1)で求めます。
 */
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
	 * このFactorialでの法となる値
	 */
	private final long mod;

	/**
	 * 1～Nの階乗とその逆元をmodで割ったあまりを事前に計算します。
	 *
	 * @param N 計算範囲
	 * @param mod 法
	 */
	public Factorial(final int N,final long mod){
		fact = new long[N+1];
		fact[0] = fact[1] = 1;
		for(int i = 2;i<=N;++i){
			fact[i] = fact[i-1]*i%mod;
		}
		inFact = new long[N+1];
		inFact[N] = MathFunction.modPow(fact[N],mod-2,mod);
		for(int i = N;i>0;--i){
			inFact[i-1] = inFact[i]*i%mod;
		}
		inFact[0] = 1;
		this.mod = mod;
	}

	/**
	 * num!をmodで割ったあまりを返します。
	 *
	 * @param num num!となるnum
	 *
	 * @return num!
	 */
	public long getFact(final int num){
		return fact[num];
	}

	/**
	 * num!^-1をmodで割ったあまりを返します。
	 *
	 * @param num num!^-1となるnum
	 *
	 * @return num!
	 */
	public long getInFact(final int num){
		return inFact[num];
	}

	/**
	 * modを法とした時のnum^-1を返します。
	 *
	 * @param num num^-1 mod mとなるnum
	 *
	 * @return num!
	 */
	public long getInverse(final int num){
		return fact[num-1]*inFact[num]%mod;
	}

	/**
	 * aCbをmodで割ったあまりを返します。
	 *
	 * @param a aCbとなるa
	 * @param b aCbとなるb
	 *
	 * @return aCb
	 */
	public long getCombi(final int a,final int b){
		if(a<b||a<0||b<0){
			return 0;
		}
		return (fact[a]*inFact[a-b]%mod)*inFact[b]%mod;
	}
}

/**
 * LazySegmentTreeクラスです。
 * 載せる演算はfunctionメソッド、演算の合成はcompositionメソッド、演算の適用はmappingメソッドに定義して使用して下さい。
 *
 * @param <S> 演算を適用する要素の型
 * @param <F> 演算に使用するパラメータ
 */
@SuppressWarnings("unchecked")
abstract class LazySegmentTree<S,F>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int size, log;

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
	private final S[] node;

	/**
	 * 演算用のテーブルです。
	 */
	private final F[] lazy;

	/**
	 * 大きさN、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 * 各メソッドに渡すインデックスは0-indexedであることが要求されます。
	 *
	 * @param N 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 */
	public LazySegmentTree(final int N,final S defaultS,final F defaultF){
		this(N,defaultS,defaultF,false);
	}

	/**
	 * 大きさN、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 *
	 * @param N 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは1-indexedか
	 */
	public LazySegmentTree(final int N,final S defaultS,final F defaultF,final boolean is1indexed){
		this.log = 32-Integer.numberOfLeadingZeros(N-1);
		this.size = (1<<log)-(is1indexed?1:0);
		this.defaultS = defaultS;
		this.defaultF = defaultF;
		this.node = (S[])new Object[1<<log+1];
		this.lazy = (F[])new Object[1<<log+1];
		clear();
	}

	/**
	 * 引数の配列を元に、単位元がdefaultS、恒等写像がdefaultFであるLazySegmentTreeを構築します。
	 *
	 * @param defaultValues 大きさ
	 * @param defaultS 単位元
	 * @param defaultF 恒等写像
	 * @param is1indexed 各メソッドに渡すインデックスは1-indexedか
	 */
	public LazySegmentTree(final S[] defaultValues,final S defaultS,final F defaultF,final boolean is1indexed){
		this(defaultValues.length,defaultS,defaultF,is1indexed);
		updateAll(defaultValues);
	}

	/**
	 * 全ての要素を単位元に、演算を恒等写像にします。
	 */
	public void clear(){
		Arrays.fill(this.node,this.defaultS);
		Arrays.fill(this.lazy,this.defaultF);
	}

	/**
	 * 引数の要素を元にテーブルを再構築します。
	 *
	 * @param defaultValues 元となる配列
	 */
	private void updateAll(final S[] defaultValues){
		System.arraycopy(defaultValues,0,node,1<<log,defaultValues.length);
		for(int i = (1<<log)-1;i>0;i--){
			node[i] = function(node[i<<1],node[i<<1|1]);
		}
	}

	/**
	 * 引数の位置の演算を適用し、子に伝播します。
	 *
	 * @param index 演算を適用する位置
	 */
	private void spread(final int index){
		if(lazy[index]!=defaultF){
			int l = index<<1;
			int r = index<<1|1;
			node[l] = mapping(node[l],lazy[index]);
			node[r] = mapping(node[r],lazy[index]);
			lazy[l] = composition(lazy[l],lazy[index]);
			lazy[r] = composition(lazy[r],lazy[index]);
			lazy[index] = defaultF;
		}
	}

	/**
	 * 親から順に引数の位置までの演算を適用します。
	 *
	 * @param from 演算を適用する終点
	 */
	private void spreadLine(final int from){
		for(int i = log;i>0;i--)
			spread(from>>i);
	}

	/**
	 * 引数の区間の演算を適用します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 */
	private void spreadRange(final int l,final int r){
		for(int i = log;i>0;i--){
			if((l>>i<<i)!=l)
				spread(l>>i);
			if((r>>i<<i)!=r)
				spread(r>>i);
		}
	}

	/**
	 * 引数の位置の要素の情報を親に向かって伝播します。
	 *
	 * @param index 伝播したい要素のインデックス
	 */
	private void update(int index){
		while((index >>= 1)>0)
			node[index] = function(node[index<<1],node[index<<1|1]);
	}

	/**
	 * 区間の要素の情報を親に向かって伝播します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 */
	private void update(final int l,final int r){
		for(int i = 1;i<=log;i++){
			int subL = l>>i;
			int subR = r>>i;
			if((subL<<i)!=l)
				node[subL] = function(node[subL<<1],node[subL<<1|1]);
			if((subR<<i)!=r)
				node[subR] = function(node[subR<<1],node[subR<<1|1]);
		}
	}

	/**
	 * 引数の位置の要素を引数の値で上書きします。
	 *
	 * @param index インデックス
	 * @param x 上書きする値
	 */
	public void update(int index,final S x){
		index += size;
		spreadLine(index);
		node[index] = x;
		update(index);
	}

	/**
	 * 引数の位置の要素を取得します
	 *
	 * @param index インデックス
	 *
	 * @return 引数の位置の要素
	 */
	public S get(int index){
		index += size;
		spreadLine(index);
		return node[index];
	}

	/**
	 * 指定された区間にfunctionを適用した結果を返します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 *
	 * @return [l,r)の要素にfunctionを適用した結果
	 */
	public S query(int l,int r){
		l += size;
		r += size;
		spreadRange(l,r);
		S sumL = defaultS;
		S sumR = defaultS;
		while(l<r){
			if((l&1)==1)
				sumL = function(sumL,node[l++]);
			if((r&1)==1)
				sumR = function(node[--r],sumR);
			l >>= 1;
			r >>= 1;
		}
		return function(sumL,sumR);
	}

	/**
	 * 全要素にfunctionを適用した結果を返します。
	 *
	 * @return 全要素にfunctionを適用した結果
	 */
	public S answer(){
		return node[1];
	}

	/**
	 * 引数の位置の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param index インデックス
	 * @param f 反映する演算を表すパラメータ
	 */
	public void apply(int index,final F f){
		index += size;
		spreadLine(index);
		node[index] = mapping(node[index],f);
		update(index);
	}

	/**
	 * 指定された区間の要素に指定されたパラメータによる演算を反映します。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含まない)
	 * @param f 反映する演算を表すパラメータ
	 */
	public void apply(int l,int r,final F f){
		l += size;
		r += size;
		spreadRange(l,r);
		int subL = l;
		int subR = r;
		while(subL<subR){
			if((subL&1)==1){
				node[subL] = mapping(node[subL],f);
				lazy[subL] = composition(lazy[subL++],f);
			}
			if((subR&1)==1){
				node[--subR] = mapping(node[subR],f);
				lazy[subR] = composition(lazy[subR],f);
			}
			subL >>= 1;
			subR >>= 1;
		}
		update(l,r);
	}

	/**
	 * 各要素に適用する関数を定義するメソッドです。
	 *
	 * @param s1 要素1
	 * @param s2 要素2
	 *
	 * @return 要素に関数を適用した結果
	 */
	abstract public S function(S s1,S s2);

	/**
	 * パラメータを合成するメソッドです。
	 * パラメータを表すインスタンスが不変であること、
	 * ここで返すインスタンスが他に影響を及ぼさないことが要求されます。
	 *
	 * @param f1 パラメータ1
	 * @param f2 パラメータ2
	 *
	 * @return パラメータを合成した結果を表すパラメータ
	 */
	abstract public F composition(F f1,F f2);

	/**
	 * パラメータを元に要素に演算を適用します。
	 *
	 * @param s 要素
	 * @param f パラメータ
	 *
	 * @return 要素に演算を適用した結果
	 */
	abstract public S mapping(S s,F f);
}

/**
 * 数学に関するメソッドを提供するクラスです。
 * 最大公約数や累乗、2線分の交差判定などを提供します。
 */
final class MathFunction{

	/**
	 * int型の素数判定用の値
	 */
	private static final int[] numberForIntPrime = {2,7,61};

	/**
	 * long型の素数判定用の値
	 */
	private static final long[] numberForLongPrime = {2,7,61,325,9375,28178,450775,9780504,1795265022};

	/**
	 * aとbの最大公約数を求めます。戻り値は0以上であることが保証されます。
	 *
	 * @param a 公約数を求める整数
	 * @param b 公約数を求める整数
	 *
	 * @return aとbの最大公約数
	 */
	public static long gcd(long a,long b){
		a = Math.abs(a);
		b = Math.abs(b);
		if(b==0){
			return a;
		}
		long temp;
		while((temp = a%b)!=0){
			a = b;
			b = temp;
		}
		return b;
	}

	/**
	 * aとbの最小公倍数を求めます。
	 * オーバーフロー検知は出来ません。
	 *
	 * @param a 公倍数を求める整数
	 * @param b 公倍数を求める整数
	 *
	 * @return aとbの最小公倍数
	 */
	public static long lcm(final long a,final long b){
		return a/gcd(a,b)*b;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param n 検査対象
	 *
	 * @return nが素数であるならtrue、素数でないならfalse
	 */
	public static boolean isPrime(long n){
		n = Math.abs(n);
		if(n==2L){
			return true;
		}
		if(n==1L||(n&1L)==0L){
			return false;
		}
		if(n<=Integer.MAX_VALUE){
			return isPrimeForInt((int)n);
		}
		return isPrimeForBigInteger(n);
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param n 検査対象
	 *
	 * @return nが素数であるならtrue、素数でないならfalse
	 */
	private static boolean isPrimeForInt(int n){
		long d = n-1L;
		while((d&1)==0){
			d >>= 1;
		}
		Montgomery32 mg = new Montgomery32(n);
		for(final int a: numberForIntPrime){
			if(a>=n){
				return true;
			}
			long t = d;
			long y = mg.inner.pow(a,t);
			long one = mg.inner.setMontgomeryExpression(1);
			long Nd = mg.inner.setMontgomeryExpression(n-1);
			while(t<n-1L&&y!=one&&y!=Nd){
				y = mg.inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=Nd&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 引数が素数か判定します。
	 *
	 * @param n 検査対象
	 *
	 * @return nが素数であるならtrue、素数でないならfalse
	 */
	private static boolean isPrimeForBigInteger(long n){
		long d = n-1L;
		while((d&1L)==0L){
			d >>= 1;
		}
		Montgomery64 mg = new Montgomery64(n);
		for(final long a: numberForLongPrime){
			if(a>=n){
				return true;
			}
			long t = d;
			long y = mg.inner.pow(a,t);
			long one = mg.inner.setMontgomeryExpression(1);
			long Nd = mg.inner.setMontgomeryExpression(n-1);
			while(t<n-1L&&y!=one&&y!=Nd){
				y = mg.inner.innerMultiply(y,y);
				t <<= 1;
			}
			if(y!=Nd&&(t&1L)==0){
				return false;
			}
		}
		return true;
	}

	/**
	 * num以下の素数を列挙します。
	 *
	 * @param num 素数を探す上限値
	 *
	 * @return num以下の素数のint型配列
	 */
	public static int[] primes(final int num){
		if(num<2){
			return new int[0];
		}
		final BitSet numbers = new BitSet(num+1);
		numbers.set(2,num+1);
		final int limit = (int)Math.sqrt(num);
		int bit = 0;
		while(
			rangeCheckClose(
				bit=numbers.nextSetBit(bit+1),
				2,
				limit)){
			for(int j = bit*bit;j<=num;j+=bit){
				numbers.clear(j);
			}
		}
		final int[] answer = new int[numbers.cardinality()];
		bit = 0;
		for(int i=0;i<answer.length;++i)
			bit = (answer[i] = numbers.nextSetBit(bit+1));
		return answer;
	}

	/**
	 * a**bを計算します。
	 *
	 * @param a 被累乗数
	 * @param b 指数
	 *
	 * @return a**b
	 */
	public static long pow(long a,long b){
		long ans = 1;
		while(b>0){
			if((b&1)==1){
				ans *= a;
			}
			a *= a;
			b >>= 1;
		}
		return ans;
	}

	/**
	 * a**bをmodで割ったあまりを計算します。
	 *
	 * @param a 被累乗数
	 * @param b 指数
	 * @param mod 法とする整数
	 *
	 * @return a**bをmodで割ったあまり
	 */
	public static long modPow(long a,long b,final long mod){
		long ans = 1;
		a %= mod;
		while(b>0){
			if((b&1)==1){
				ans *= a;
			}
			ans %= mod;
			a *= a;
			a %= mod;
			b >>= 1;
		}
		return ans;
	}

	/**
	 * N!を計算します。
	 *
	 * @param N 階乗を求めるのに用いる値
	 *
	 * @return N!
	 */
	public static long fact(final int N){
		long ans = 1;
		for(int i = 2;i<=N;++i){
			ans *= i;
		}
		return ans;
	}

	/**
	 * N!をmodで割ったあまりを計算します。
	 *
	 * @param N 階乗を求めるのに用いる値
	 * @param mod 法とする整数
	 *
	 * @return N!をmodで割ったあまり
	 */
	public static long modFact(final int N,final long mod){
		long ans = 1;
		for(int i = 2;i<=N;++i){
			ans *= i;
			ans %= mod;
		}
		return ans;
	}

	/**
	 * nCrを計算します。
	 *
	 * @param n 二項係数を求めるのに用いる値
	 * @param r 二項係数を求めるのに用いる値
	 *
	 * @return nCr
	 */
	public static long combi(final long n,long r){
		if(r<0||n<r){
			return 0;
		}
		long ans = 1;
		r = Math.min(n-r,r);
		for(int i = 0;i<r;++i){
			ans *= n-i;
			ans /= i+1;
		}
		return ans;
	}

	/**
	 * nCrをmodで割ったあまりを計算します。
	 *
	 * @param n 二項係数を求めるのに用いる値
	 * @param r 二項係数を求めるのに用いる値
	 * @param mod 法とする整数
	 *
	 * @return nCrをmodで割ったあまり
	 */
	public static long modCombi(final long n,long r,final long mod){
		if(r<0||n<r){
			return 0;
		}
		long ans = 1;
		r = Math.min(n-r,r);
		for(int i = 0;i<r;++i){
			ans *= (n-i)%mod;
			ans %= mod;
			ans *= modPow(i+1,mod-2,mod);
			ans %= mod;
		}
		return ans;
	}

	/**
	 * 引数の前半二点、後半二点で構成される二線分が交差しているか返します。
	 *
	 * @param x1 点1のx座標
	 * @param y1 点1のy座標
	 * @param x2 点2のx座標
	 * @param y2 点2のy座標
	 * @param x3 点3のx座標
	 * @param y3 点3のy座標
	 * @param x4 点4のx座標
	 * @param y4 点4のy座標
	 *
	 * @return 交差している(線分の端が他方の線分上に存在する場合も含む)場合は1、同一線分・直線上なら0、それ以外は-1
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
	 * 引数の前半二点、後半二点で構成される二線分が交差しているか返します。
	 *
	 * @param p1 点1
	 * @param p2 点2
	 * @param p3 点3
	 * @param p4 点4
	 *
	 * @return 交差している(線分の端が他方の線分上に存在する場合も含む)場合は1、同一線分・直線上なら0、それ以外は-1
	 */
	public static int isCrossed(final Point p1,final Point p2,final Point p3,final Point p4){
		return isCrossed(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y,p4.x,p4.y);
	}

	/**
	 * 指定された頂点を順に結んで出来上がる多角形が凸多角形か判定します。
	 *
	 * @param points 多角形を構成する点
	 *
	 * @return 多角形が凸多角形ならtrue
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
			int result = isCrossed(points[i],points[(i+2)%n],points[(i+1)%n],points[(i+1+n/2)%n]);
			conv &= result>=0;
		}
		return conv;
	}

	/**
	 * numをmodで割ったあまりを返します。
	 * 戻り値は0以上mod未満であることが保証されます。
	 *
	 * @param num 被除算数
	 * @param mod 法とする値
	 *
	 * @return numをmodで割ったあまり
	 */
	public static long remainder(long num,final long mod){
		num %= mod;
		if(num<0){
			num += mod;
		}
		return num;
	}

	/**
	 * numが何桁かを返します。
	 * 0は1桁として捉えます。
	 *
	 * @param num 調べる整数
	 *
	 * @return numの桁数
	 */
	public static int digit(final long num){
		if(num<10L){
			return 1;
		}
		if(num<100L){
			return 2;
		}
		if(num<1000L){
			return 3;
		}
		if(num<10000L){
			return 4;
		}
		if(num<100000L){
			return 5;
		}
		if(num<1000000L){
			return 6;
		}
		if(num<10000000L){
			return 7;
		}
		if(num<100000000L){
			return 8;
		}
		if(num<1000000000L){
			return 9;
		}
		if(num<10000000000L){
			return 10;
		}
		if(num<100000000000L){
			return 11;
		}
		if(num<1000000000000L){
			return 12;
		}
		if(num<10000000000000L){
			return 13;
		}
		if(num<100000000000000L){
			return 14;
		}
		if(num<1000000000000000L){
			return 15;
		}
		if(num<10000000000000000L){
			return 16;
		}
		if(num<100000000000000000L){
			return 17;
		}
		if(num<1000000000000000000L){
			return 18;
		}
		return 19;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static int max(final int... nums){
		int ans = Integer.MIN_VALUE;
		for(int num: nums){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static long max(final long... nums){
		long ans = Long.MIN_VALUE;
		for(long num: nums){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最大の要素
	 */
	public static double max(final double... nums){
		double ans = -Double.MIN_VALUE;
		for(double num: nums){
			ans = Math.max(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最大の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最大の要素
	 */
	public static <E extends Comparable<E>> E max(final E[] nums){
		E ans = nums[0];
		for(E value: nums){
			if(ans.compareTo(value)<0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static int min(final int... nums){
		int ans = Integer.MAX_VALUE;
		for(int num: nums){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static long min(final long... nums){
		long ans = Long.MAX_VALUE;
		for(long num: nums){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @return 引数で最小の要素
	 */
	public static double min(final double... nums){
		double ans = Double.MAX_VALUE;
		for(double num: nums){
			ans = Math.min(ans,num);
		}
		return ans;
	}

	/**
	 * 引数の中で最小の値を返します。
	 *
	 * @param nums 探索対象
	 *
	 * @param <E> 配列の要素の型
	 *
	 * @return 引数で最小の要素
	 */
	public static <E extends Comparable<E>> E min(final E[] nums){
		E ans = nums[0];
		for(E value: nums){
			if(ans.compareTo(value)>0){
				ans = value;
			}
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param nums 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final int... nums){
		long ans = 0;
		for(int num: nums){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を返します。
	 *
	 * @param nums 加算対象
	 *
	 * @return 引数の総和
	 */
	public static long sum(final long... nums){
		long ans = 0;
		for(long num: nums){
			ans += num;
		}
		return ans;
	}

	/**
	 * 引数の総和を指定された値で割ったあまりを返します。
	 *
	 * @param mod 法とする値
	 * @param nums 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final int... nums){
		long ans = 0;
		for(int num: nums){
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
	 * @param nums 加算対象
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long mod,final long... nums){
		long ans = 0;
		for(long num: nums){
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
	 * @param nums 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端(toを含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final int[] nums,int from,int to){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += nums[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を返します。
	 *
	 * @param nums 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端(toを含まない)
	 *
	 * @return 指定された区間の総和
	 */
	public static long sum(final long[] nums,int from,int to){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += nums[i];
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param nums 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端(toを含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final int[] nums,int from,int to,long mod){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += nums[i];
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 指定された区間の総和を指定された値で割ったあまりを返します。
	 *
	 * @param nums 加算対象
	 * @param from 区間の左端
	 * @param to 区間の右端(toを含まない)
	 * @param mod 法とする値
	 *
	 * @return 引数の総和を指定された値で割ったあまり
	 */
	public static long modSum(final long[] nums,int from,int to,long mod){
		long ans = 0;
		for(int i = from;i<to;++i){
			ans += nums[i];
			ans %= mod;
		}
		if(ans<0){
			ans += mod;
		}
		return ans;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt;= num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheck(final int num,final int l,final int r){
		return l<=num&&num<r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt;= num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheck(final long num,final long l,final long r){
		return l<=num&&num<r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt;= num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheck(final double num,final double l,final double r){
		return l<=num&&num<r;
	}

	/**
	 * 引数numがl以上r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含まない)
	 *
	 * @param <E> 比較対象の型
	 *
	 * @return l &lt;= num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheck(final E num,final E l,final E r){
		return 0<=num.compareTo(l)&&num.compareTo(r)<0;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt; num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckOpen(final int num,final int l,final int r){
		return l<num&&num<r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt; num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckOpen(final long num,final long l,final long r){
		return l<num&&num<r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @return l &lt; num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckOpen(final double num,final double l,final double r){
		return l<num&&num<r;
	}

	/**
	 * 引数numがlより大きく、r未満の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含まない)
	 *
	 * @param <E> 比較対象の型
	 *
	 * @return l &lt; num &lt; rを満たしていればtrue、満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheckOpen(final E num,final E l,final E r){
		return 0<num.compareTo(l)&&num.compareTo(r)<0;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt;= num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckClose(final int num,final int l,final int r){
		return l<=num&&num<=r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt;= num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckClose(final long num,final long l,final long r){
		return l<=num&&num<=r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt;= num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckClose(final double num,final double l,final double r){
		return l<=num&&num<=r;
	}

	/**
	 * 引数numがl以上r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含む)
	 * @param r 上限(rを含む)
	 *
	 * @param <E> 比較対象の型
	 *
	 * @return l &lt;= num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheckClose(final E num,final E l,final E r){
		return 0<=num.compareTo(l)&&num.compareTo(r)<=0;
	}

	/**
	 * 引数numがlより大きく、r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt; num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckSubClose(final int num,final int l,final int r){
		return l<num&&num<=r;
	}

	/**
	 * 引数numがlより大きく、r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt; num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckSubClose(final long num,final long l,final long r){
		return l<num&&num<=r;
	}

	/**
	 * 引数numがlより大きく、r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含む)
	 *
	 * @return l &lt; num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static boolean rangeCheckSubClose(final double num,final double l,final double r){
		return l<num&&num<=r;
	}

	/**
	 * 引数numがlより大きく、r以下の範囲内か判定します。
	 *
	 * @param num 判定する値
	 * @param l 下限(lを含まない)
	 * @param r 上限(rを含む)
	 *
	 * @param <E> 比較対象の型
	 *
	 * @return l &lt; num &lt;= rを満たしていればtrue、満たしていなければfalse
	 */
	public static <E extends Comparable<E>> boolean rangeCheckSubClose(final E num,final E l,final E r){
		return 0<num.compareTo(l)&&num.compareTo(r)<=0;
	}

	/**
	 * 引数の中でのmexを求めます。
	 *
	 * @param nums 引数
	 *
	 * @return 引数を集合として見たときのmex
	 */
	public static int mex(final int... nums){
		final BitSet set = new BitSet(nums.length);
		for(final int num: nums)
			if(num<nums.length)
				set.set(num);
		return set.nextClearBit(0);
	}
}

/**
 * Matrixクラスです。
 * 行列を保持するクラスで、簡単な四則演算に行列式、累乗などを提供しています。
 */
final class Matrix{

	/**
	 * 行列を管理するための二次元配列です。
	 */
	private final long[][] matrix;

	/**
	 * H行W列の、全要素がdefの行列を構築します。
	 *
	 * @param H 行数
	 * @param W 列数
	 * @param def 全要素の値
	 */
	public Matrix(final int H,final int W,final long def){
		matrix = new long[H][W];
		if(def!=0){
			for(final long[] mat: matrix){
				Arrays.fill(mat,def);
			}
		}
	}

	/**
	 * H行W列の、全要素が0である行列を構築します。
	 *
	 * @param H 行数
	 * @param W 列数
	 */
	public Matrix(final int H,final int W){
		this(H,W,0);
	}

	/**
	 * Dimensionで表される行数、列数で全要素がdefの行列を構築します。
	 *
	 * @param d 行・列数
	 * @param def 全要素の値
	 */
	public Matrix(final Dimension d,final long def){
		this(d.height,d.width,def);
	}

	/**
	 * 引数の二次元配列を元に行列を構築します。
	 * 値をコピーして構築するため、引数の行列とは連動していません。
	 *
	 * @param mat 元となる二次元配列
	 */
	public Matrix(final long[][] mat){
		matrix = new long[mat.length][];
		for(int i = 0;i<mat.length;++i){
			matrix[i] = Arrays.copyOf(mat[i],mat[i].length);
		}
	}

	/**
	 * i行j列目の要素を取得します。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 *
	 * @return i行j列目の要素
	 */
	public long get(final int i,final int j){
		return matrix[i][j];
	}

	/**
	 * i行j列目の要素を引数の値で上書きします。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 * @param value 上書きする値
	 *
	 * @return value
	 */
	public long set(final int i,final int j,final long value){
		return matrix[i][j] = value;
	}

	/**
	 * この行列を複製します。
	 *
	 * @return この行列と等価な行列(連動していない)
	 */
	public Matrix copy(){
		return new Matrix(matrix);
	}

	/**
	 * この行列の行・列数を表すDimensionを返します。
	 *
	 * @return この行列の行・列数を表すDimension
	 */
	public Dimension size(){
		return new Dimension(matrix[0].length,matrix.length);
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 *
	 * @param m 加算する行列
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix add(final Matrix m){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,matrix[i][j]+m.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 *
	 * @param m 減算する行列
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix subtract(final Matrix m){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,matrix[i][j]-m.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 *
	 * @param m 乗算する行列
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix multiply(final Matrix m){
		if(size().width!=m.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(size().height,m.size().width);
		final Dimension size = ans.size();
		final int len = size().width;
		for(int i = 0;i<size.height;++i){
			for(int j = 0;j<size.width;++j){
				long sum = 0;
				for(int k = 0;k<len;++k){
					sum += matrix[i][k]*m.get(k,j);
				}
				ans.set(i,j,sum);
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 * 各要素はmodで除算したあまりに変換されます。
	 *
	 * @param m 加算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix modAdd(final Matrix m,final long mod){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(matrix[i][j]+m.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 * 各要素はmodで除算したあまりに変換されます。
	 *
	 * @param m 減算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix modSubtract(final Matrix m,final long mod){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(matrix[i][j]-m.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 * 各要素はmodで乗算したあまりに変換されます。
	 *
	 * @param m 乗算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix modMultiply(final Matrix m,final long mod){
		if(size().width!=m.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(size().height,m.size().width);
		final Dimension size = ans.size();
		final int len = size().width;
		for(int i = 0;i<size.height;++i){
			for(int j = 0;j<size.width;++j){
				long sum = 0;
				for(int k = 0;k<len;++k){
					sum = MathFunction.remainder(sum+matrix[i][k]*m.get(k,j),mod);
				}
				ans.set(i,j,sum);
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
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while(0<exp){
			if((exp&1)==1){
				a = b.multiply(a);
			}
			b = b.multiply(b);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。
	 * 各要素はmodで乗算したあまりに変換されます。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 * @param mod 法となる値
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix modPow(final Matrix original,final Matrix pw,long exp,final long mod){
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while(0<exp){
			if((exp&1)==1){
				a = b.modMultiply(a,mod);
			}
			b = b.modMultiply(b,mod);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * この行列の行列式を返します。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(){
		return determinant(matrix);
	}

	/**
	 * 引数の二次元配列の行列式を返します。
	 *
	 * @param mat 元となる二次元配列
	 *
	 * @return 二次元配列の行列式
	 */
	private static long determinant(final long[][] mat){
		if(mat.length==1){
			return mat[0][0];
		}
		final long[][] miniMat = new long[mat.length-1][mat.length-1];
		for(int i = 1;i<mat.length;++i){
			System.arraycopy(mat[i],1,miniMat[i-1],0,miniMat.length);
		}
		long ans = mat[0][0]*determinant(miniMat);
		for(int i = 1;i<mat.length;++i){
			for(int j = 1;j<mat.length;++j){
				miniMat[j-1][i-1] = mat[j][i-1];
			}
			final long num = mat[0][i]*determinant(miniMat);
			ans += i%2==0?num:-num;
		}
		return ans;
	}

	/**
	 * この行列を表すStringを返します。
	 *
	 * @return この行列を表すString
	 */
	@Override public String toString(){
		final StringBuilder ans = new StringBuilder();
		ans.append(Arrays.toString(matrix[0]));
		for(int i = 1;i<matrix.length;++i){
			ans.append("\n");
			ans.append(Arrays.toString(matrix[i]));
		}
		return ans.toString();
	}
}

/**
 * 法が32bitに収まるとき用のMontgomeryクラスです。
 * 剰余結果を得る他に、innerから直接モンゴメリ表現での処理も提供します。
 */
final class Montgomery32{

	/**
	 * 内部処理用のインスタンスです。
	 */
	public final InnerMontgomery32 inner;

	/**
	 * 内部処理用のクラスです。
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery32{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long R2,Nd,N;

		/**
		 * ビットマスク用の変数です。
		 */
		private static final long MASK;
		static{
			MASK = 0xffffffffL;
		}

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 * 
		 * @param n 法とする整数
		 */
		private InnerMontgomery32(int n){
			N = n;
			long r = 0;
			long t = 0;
			long num = 1L<<32;
			long i = 1;
			while(num>1){
				if((t&1L)==0){
					t += N;
					r |= i;
				}
				t >>>= 1;
				num >>>= 1;
				i <<= 1;
			}
			Nd = r;
			R2 = Long.remainderUnsigned(-1L-N+1,N);
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 * 
		 * @param num 対象の値
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long TNd = num*Nd&MASK;
			final long mult = TNd*N;
			final long down = (mult&MASK)+(num&MASK);
			final long up = (mult>>>32)+(num>>>32);
			long ans = up+(down>>>32);
			if(N<=ans){
				ans -= N;
			}
			return ans;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 * 
		 * @param num 変換対象
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(int num){
			return montgomeryReduction(num*R2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*bのモンゴメリ表現
		 */
		public long multiply(final int a,final int b){
			final long A = setMontgomeryExpression(a);
			final long B = setMontgomeryExpression(b);
			return montgomeryReduction(A*B);
		}

		/**
		 * 引数をモンゴメリ表現の値として積を返します。
		 * 
		 * @param A 乗算対象
		 * @param B 乗算対象
		 * @return MR(a*b)
		 */
		public long innerMultiply(final long A,final long B){
			return montgomeryReduction(A*B);
		}

		/**
		 * a^bのモンゴメリ表現を返します。
		 * 
		 * @param a 累乗対象
		 * @param b 指数
		 * @return a^bのモンゴメリ表現
		 */
		public long pow(final int a,long b){
			long A = setMontgomeryExpression(a);
			long ans = montgomeryReduction(R2);
			while(b>0){
				if((b&1L)>0){
					ans = montgomeryReduction(ans*A);
				}
				A = montgomeryReduction(A*A);
				b >>>= 1;
			}
			return ans;
		}
	}
	
	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 * 
	 * @param n 法とする値
	 */
	public Montgomery32(int n){
		inner = new InnerMontgomery32(n);
	}

	/**
	 * a*b mod nを返します。
	 * 
	 * @param a 乗算対象
	 * @param b 乗算対象
	 * @return a*b mod n
	 */
	public int multiply(final int a,final int b){
		final long ans = inner.multiply(a,b);
		return (int)inner.montgomeryReduction(ans);
	}

	/**
	 * a^b mod nを返します。
	 * 
	 * @param a 累乗対象
	 * @param b 指数
	 * @return a^b mod n
	 */
	public int pow(final int a,final long b){
		final long ans = inner.pow(a,b);
		return (int)inner.montgomeryReduction(ans);
	}
}

/**
 * 法が32bitに収まらないとき用のMontgomeryクラスです。
 * 剰余結果を得る他に、innerから直接モンゴメリ表現での処理も提供します。
 */
final class Montgomery64{

	/**
	 * 内部処理用のインスタンスです。
	 */
	public final InnerMontgomery64 inner;

	/**
	 * 内部処理用のクラスです。
	 * モンゴメリ表現の取得や、モンゴメリ表現のまま処理したい場合などにお使いください。
	 */
	public static final class InnerMontgomery64{

		/**
		 * モンゴメリ乗算用の変数です。
		 */
		private final long R2,Nd,N;

		/**
		 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
		 * 
		 * @param n 法とする整数
		 */
		public InnerMontgomery64(final long n){
			N = n;
			long r = 0;
			long t = 0;
			for(int i=0;i<64;i++){
				if((t&1L)==0){
					t += N;
					r |= 1L<<i;
				}
				t >>>= 1;
			}
			Nd = r;
			R2 = BigInteger.ONE.shiftLeft(128).mod(BigInteger.valueOf(N)).longValue();
		}

		/**
		 * 引数に対してモンゴメリリダクションを適用します。
		 * 
		 * @param num 対象の値
		 * @return MR(num)
		 */
		public long montgomeryReduction(final long num){
			final long TNd = num*Nd;
			final long down = TNd*N;
			final long up = unsignedmultiplyHigh(TNd,N);
			final long ans = up+Math.max(Long.compareUnsigned(num,~down),0L);
			return Long.compareUnsigned(ans,N)<0?ans:ans-N;
		}

		/**
		 * 引数を128bit整数として解釈してモンゴメリリダクションを適用します。
		 * 
		 * @param u 上位64bit
		 * @param d 下位64bit
		 * @return MR(u*2^64 + d)
		 */
		private long montgomeryReduction(final long u,final long d){
			final long ans = u+montgomeryReduction(d);
			return Long.compareUnsigned(ans,N)<0?ans:ans-N;
		}

		/**
		 * 引数をモンゴメリ表現に変換します。
		 * 
		 * @param num 変換対象
		 * @return モンゴメリ表現に変換後の値
		 */
		public long setMontgomeryExpression(final long num){
			return innerMultiply(num,R2);
		}

		/**
		 * 引数同士の積のモンゴメリ表現を返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*bのモンゴメリ表現
		 */
		public long multiply(final long a,final long b){
			final long A = setMontgomeryExpression(a);
			final long B = setMontgomeryExpression(b);
			return innerMultiply(A,B);
		}

		/**
		 * 引数をモンゴメリ表現の値と解釈して積を返します。
		 * 
		 * @param A 乗算対象
		 * @param B 乗算対象
		 * @return MR(A*B)
		 */
		public long innerMultiply(final long A,final long B){
			return montgomeryReduction(unsignedmultiplyHigh(A,B),A*B);
		}

		/**
		 * a^bのモンゴメリ表現を返します。
		 * 
		 * @param a 累乗対象
		 * @param b 指数
		 * @return a^bのモンゴメリ表現
		 */
		public long pow(final long a,long b){
			long A = setMontgomeryExpression(a);
			long ans = montgomeryReduction(R2);
			while(b>0){
				if((b&1L)>0){
					ans = innerMultiply(ans,A);
				}
				A = innerMultiply(A,A);
				b >>>= 1;
			}
			return ans;
		}

		/**
		 * 引数を符号なし64bit整数として解釈したときのa*bの上位64bitを返します。
		 * 
		 * @param a 乗算対象
		 * @param b 乗算対象
		 * @return a*b>>>64
		 */
		private static long unsignedmultiplyHigh(final long a,final long b){
			return Math.multiplyHigh(a,b)+(b&(a>>63))+(a&(b>>63));
		}
	}

	/**
	 * 引数を法とするモンゴメリ乗算用のクラスを生成します。
	 * 
	 * @param n 法とする値
	 */
	public Montgomery64(final long n){
		inner = new InnerMontgomery64(n);
	}

	/**
	 * a*b mod nを返します。
	 * 
	 * @param a 乗算対象
	 * @param b 乗算対象
	 * @return a*b mod n
	 */
	public long multiply(final long a,final long b){
		final long ans = inner.multiply(a,b);
		return inner.montgomeryReduction(ans);
	}

	/**
	 * a^b mod nを返します。
	 * 
	 * @param a 累乗対象
	 * @param b 指数
	 * @return a^b mod n
	 */
	public long pow(final long a,final long b){
		final long ans = inner.pow(a,b);
		return inner.montgomeryReduction(ans);
	}
}

/**
 * 二分探索ライブラリです。
 * 様々な条件での探索を二分探索を用いて実行します。
 */
final class Searcher{
	
	/**
	 * double用の二分探索のサイクル回数
	 */
	private static final int CYCLE_COUNT = Double.MAX_EXPONENT+53;

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final int[] array,final int value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final long[] array,final long value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final double[] array,final double value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static int downSearch(final char[] array,final int value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static <E extends Comparable<E>> int downSearch(final E[] array,final E value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c].compareTo(value)>0){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素を探します。
	 * リスト内で見つかった場合はその要素と同一で最大のインデックスを返します。
	 * 見つからなかった場合は指定された要素未満で最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static <E extends Comparable<E>> int downSearch(final List<E> list,final E value){
		int a = 0, b = list.size()-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(list.get(c).compareTo(value)>0){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。
	 * もしそのような要素が存在しない場合は下限-1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static int downSearch(int a,int b,final int value,final IntUnaryOperator func){
		int ans = a-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsInt(c)>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。
	 * もしそのような要素が存在しない場合は下限-1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static long downSearch(long a,long b,final long value,final LongUnaryOperator func){
		long ans = a-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsLong(c)>value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 * 関数内で見つかった場合はその値と同一で最大の引数を返します。
	 * 見つからなかった場合は指定された値未満で最大の引数を返します。
	 * もしそのような要素が存在しない場合は下限より小さい値を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static double search(double a,double b,final double value,final DoubleUnaryOperator func){
		double ans = a-Math.abs(a), c;
		for(int $ = 0;$<CYCLE_COUNT;++$){
			c = (a+b)/2;
			if(func.applyAsDouble(c)>value){
				b = c;
			}
			else{
				a = (ans = c);
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
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static boolean contains(final int[] array,final int value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
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
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static boolean contains(final long[] array,final long value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
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
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static boolean contains(final double[] array,final double value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
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
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static boolean contains(final char[] array,final char value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
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
	 * @param <E> 探索対象の型
	 *
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static <E extends Comparable<E>> boolean contains(final E[] array,final E value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			int result = array[c].compareTo(value);
			if(result>0){
				b = c-1;
			}
			else if(result<0){
				a = c+1;
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
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return listにvalueが含まれているかを表すboolean
	 */
	public static <E extends Comparable<E>> boolean contains(final List<E> list,final E value){
		int a = 0, b = list.size()-1, c;
		while(a-b<1){
			c = (a+b)/2;
			int result = list.get(c).compareTo(value);
			if(result>0){
				b = c-1;
			}
			else if(result<0){
				a = c+1;
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
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数がa以上b以下で探索値を取るかを表すboolean
	 */
	public static boolean contains(int a,int b,final int value,final IntUnaryOperator func){
		int c;
		while(a-b<1){
			c = (a+b)/2;
			int num = func.applyAsInt(c);
			if(num>value){
				b = c-1;
			}
			else if(num<value){
				a = c+1;
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
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数がa以上b以下で探索値を取るかを表すboolean
	 */
	public static boolean contains(long a,long b,final long value,final LongUnaryOperator func){
		long c;
		while(a-b<1){
			c = (a+b)/2;
			long num = func.applyAsLong(c);
			if(num>value){
				b = c-1;
			}
			else if(num<value){
				a = c+1;
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
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数がa以上b以下で探索値を取るかを表すboolean
	 */
	public static boolean contains(double a,double b,final double value,final DoubleUnaryOperator func){
		double c;
		for(int $ = 0;$<CYCLE_COUNT;++$){
			c = (a+b)/2;
			double num = func.applyAsDouble(c);
			if(num>value){
				b = c-1;
			}
			else if(num<value){
				a = c+1;
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
	 * @return arrayのvalueのインデックス(無ければ - 1)
	 */
	public static int search(final int[] array,final int value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
			}
			else{
				return c;
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
	 * @return arrayのvalueのインデックス(無ければ - 1)
	 */
	public static int search(final long[] array,final long value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
			}
			else{
				return c;
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
	 * @return arrayのvalueのインデックス(無ければ - 1)
	 */
	public static int search(final double[] array,final double value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
			}
			else{
				return c;
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
	 * @return arrayのvalueのインデックス(無ければ - 1)
	 */
	public static int search(final char[] array,final char value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = c-1;
			}
			else if(array[c]<value){
				a = c+1;
			}
			else{
				return c;
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
	 * @param <E> 探索対象の型
	 *
	 * @return arrayのvalueのインデックス(無ければ - 1)
	 */
	public static <E extends Comparable<E>> int search(final E[] array,final E value){
		int a = 0, b = array.length-1, c;
		while(a-b<1){
			c = (a+b)/2;
			int result = array[c].compareTo(value);
			if(result>0){
				b = c-1;
			}
			else if(result<0){
				a = c+1;
			}
			else{
				return c;
			}
		}
		return -1;
	}

	/**
	 * リスト内の指定された要素を探します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return listのvalueのインデックス(無ければ - 1)
	 */
	public static <E extends Comparable<E>> int search(final List<E> list,final E value){
		int a = 0, b = list.size()-1, c;
		while(a-b<1){
			c = (a+b)/2;
			int result = list.get(c).compareTo(value);
			if(result>0){
				b = c-1;
			}
			else if(result<0){
				a = c+1;
			}
			else{
				return c;
			}
		}
		return -1;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数がvalueを取る引数(無ければa - 1)
	 */
	public static int search(int a,int b,final int value,final IntUnaryOperator func){
		int c;
		while(a-b<1){
			c = (a+b)/2;
			int num = func.applyAsInt(c);
			if(num>value){
				b = c-1;
			}
			else if(num<value){
				a = c+1;
			}
			else{
				return c;
			}
		}
		return a-1;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return この関数がvalueを取る引数(無ければa - 1)
	 */
	public static long search(long a,long b,final long value,final LongUnaryOperator func){
		long c;
		while(a-b<1){
			c = (a+b)/2;
			long num = func.applyAsLong(c);
			if(num>value){
				b = c-1;
			}
			else if(num<value){
				a = c+1;
			}
			else{
				return c;
			}
		}
		return a-1;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final int[] array,final int value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final long[] array,final long value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final double[] array,final double value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static int upSearch(final char[] array,final char value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static <E extends Comparable<E>> int upSearch(final E[] array,final E value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c].compareTo(value)>=0){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素を探します。
	 * リスト内で見つかった場合はその要素と同一で最小のインデックスを返します。
	 * 見つからなかった場合は指定された要素以上で最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はlist.size()を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static <E extends Comparable<E>> int upSearch(final List<E> list,final E value){
		int a = 0, b = list.size()-1, ans = list.size(), c;
		while(a-b<1){
			c = (a+b)/2;
			if(list.get(c).compareTo(value)>=0){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 * 関数内で見つかった場合はその値と同一で最小の引数を返します。
	 * 見つからなかった場合は指定された値以上で最大の引数を返します。
	 * もしそのような要素が存在しない場合は上限+1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static int upSearch(int a,int b,final int value,final IntUnaryOperator func){
		int ans = b+1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsInt(c)>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 * 関数内で見つかった場合はその値と同一で最小の引数を返します。
	 * 見つからなかった場合は指定された値以上で最大の引数を返します。
	 * もしそのような要素が存在しない場合は上限+1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static long upSearch(long a,long b,final long value,final LongUnaryOperator func){
		long ans = b+1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsLong(c)>=value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final int[] array,final int value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final long[] array,final long value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final double[] array,final double value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static int underSearch(final char[] array,final char value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より小さい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static <E extends Comparable<E>> int underSearch(final E[] array,final E value){
		int a = 0, b = array.length-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c].compareTo(value)>=0){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素より小さい要素を探します。
	 * リスト内で見つかった場合は条件を満たす最大のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最大のインデックス
	 */
	public static <E extends Comparable<E>> int underSearch(final List<E> list,final E value){
		int a = 0, b = list.size()-1, ans = -1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(list.get(c).compareTo(value)>=0){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より小さい値を探します。
	 * 関数内で見つかった場合は条件を満たす最大の引数を返します。
	 * もしそのような要素が存在しない場合は下限-1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static int underSearch(int a,int b,final int value,final IntUnaryOperator func){
		int ans = a-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsInt(c)>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より小さい値を探します。
	 * 関数内で見つかった場合は条件を満たす最大の引数を返します。
	 * もしそのような要素が存在しない場合は下限-1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static long underSearch(long a,long b,final long value,final LongUnaryOperator func){
		long ans = a-1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsLong(c)>=value){
				b = c-1;
			}
			else{
				a = (ans = c)+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final int[] array,final int value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final long[] array,final long value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final double[] array,final double value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static int overSearch(final char[] array,final char value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c]>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素より大きい要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はarray.lengthを返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int overSearch(final E[] array,final E value){
		int a = 0, b = array.length-1, ans = array.length, c;
		while(a-b<1){
			c = (a+b)/2;
			if(array[c].compareTo(value)>0){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * リスト内の指定された要素より大きい要素を探します。
	 * リスト内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合はlist.size()を返します。
	 *
	 * @param list 探索対象のリスト
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int overSearch(final List<E> list,final E value){
		int a = 0, b = list.size()-1, ans = list.size(), c;
		while(a-b<1){
			c = (a+b)/2;
			if(list.get(c).compareTo(value)>0){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より大きい値を探します。
	 * 関数内で見つかった場合は条件を満たす最小の引数を返します。
	 * もしそのような要素が存在しない場合は上限+1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static int overSearch(int a,int b,final int value,final IntUnaryOperator func){
		int ans = b+1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsInt(c)>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 広義単調増加な関数内の指定された値より大きい値を探します。
	 * 関数内で見つかった場合は条件を満たす最小の引数を返します。
	 * もしそのような要素が存在しない場合は上限+1を返します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 * @param func 広義単調増加な関数
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static long overSearch(long a,long b,final long value,final LongUnaryOperator func){
		long ans = b+1, c;
		while(a-b<1){
			c = (a+b)/2;
			if(func.applyAsLong(c)>value){
				b = (ans = c)-1;
			}
			else{
				a = c+1;
			}
		}
		return ans;
	}

	/**
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
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
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
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
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
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
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
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
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param array 探索対象の配列
	 * @param value 探索要素
	 *
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
	 * 配列内の指定された要素を探します。
	 * 配列内で見つかった場合は条件を満たす最小のインデックスを返します。
	 * もしそのような要素が存在しない場合は-1を返します。
	 *
	 * @param list 探索対象の配列
	 * @param value 探索要素
	 *
	 * @param <E> 探索対象の型
	 *
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int linearSearch(final List<E> list,final E value){
		for(int i = 0;i<list.size();++i){
			if(list.get(i).compareTo(value)==0){
				return i;
			}
		}
		return -1;
	}
}

/**
 * SegmentTreeクラスです。
 * 載せる演算はfunctionメソッドを定義して使用して下さい。
 *
 * @param <E> 演算を適用する要素の型
 */
@SuppressWarnings("unchecked")
abstract class SegmentTree<E>{

	/**
	 * 内部処理用の変数です。
	 */
	private final int N, size;

	/**
	 * このSegmentTreeの単位元です。
	 */
	private final E def;

	/**
	 * このSegmentTreeを表すテーブルです。
	 */
	private final Object[] node;

	/**
	 * 大きさnの、単位元がdefであるSegmentTreeを構築します。
	 *
	 * @param n 扱う範囲
	 * @param def 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが1-indexedか
	 */
	public SegmentTree(final int n,final E def,final boolean is1indexed){
		int num = 2;
		while(num<n<<1){
			num <<= 1;
		}
		N = num;
		size = (num>>1)-(is1indexed?1:0);
		node = new Object[N];
		this.def = def;
		Arrays.fill(node,this.def);
	}

	/**
	 * 引数の配列を元に、単位元がdefであるSegmentTreeを構築します。
	 * 浅いコピーなので、引数の配列の要素に変更を加えたときの動作は保証されません。
	 *
	 * @param arr 　元となる配列
	 * @param def 単位元
	 * @param is1indexed 各メソッドに渡すインデックスが1-indexedか
	 */
	public SegmentTree(final E[] arr,final E def,final boolean is1indexed){
		int num = 2;
		while(num<arr.length<<1){
			num <<= 1;
		}
		N = num;
		size = num>>1-(is1indexed?1:0);
		node = new Object[N];
		this.def = def;
		System.arraycopy(arr,0,node,N>>1,arr.length);
		for(int i = arr.length+(N>>1);i<N;i++){
			node[i] = def;
		}
		updateAll();
	}

	/**
	 * 大きさn、単位元がdefのSegmentTreeを構築します。
	 * 各メソッドに渡すインデックスは0-indexedであることが要求されます。
	 *
	 * @param n 大きさ
	 * @param def 単位元
	 */
	public SegmentTree(final int n,final E def){
		this(n,def,false);
	}

	/**
	 * このSegmentTreeのテーブルを一括で更新します。
	 */
	private void updateAll(){
		for(int i = (N>>1)-1;i>0;i--){
			node[i] = function((E)node[i<<1],(E)node[(i<<1)+1]);
		}
	}

	/**
	 * 引数の位置の値を引数の値で上書きします。
	 *
	 * @param n インデックス
	 * @param value 上書きする値
	 */
	public void update(int n,final E value){
		n += size;
		node[n] = value;
		n >>= 1;
		while(n>0){
			node[n] = function((E)node[n<<1],(E)node[(n<<1)+1]);
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
	public E get(final int a){
		return (E)node[a+size];
	}

	/**
	 * このSegmentTree上の要素全てにfunctionを適用した結果を返します。
	 *
	 * @return 要素全てにfunctionを適用した結果
	 */
	public E answer(){
		return (E)node[1];
	}

	/**
	 * 引数の区間の要素にfunctionを適用した結果を返します。
	 * 閉区間であることに注意して下さい。
	 *
	 * @param l 左端(lを含む)
	 * @param r 右端(rを含む)
	 *
	 * @return [l,r]の要素にfunctionを適用した結果
	 */
	public E query(int l,int r){
		l += size;
		r += size;
		E answer = def;
		while(l>0&&r>0&&l<=r){
			if(l%2==1){
				answer = function((E)node[l++],answer);
			}
			l >>= 1;
			if(r%2==0){
				answer = function(answer,(E)node[r--]);
			}
			r >>= 1;
		}
		return answer;
	}

	/**
	 * このSegmentTree上で適用する関数を定義したメソッドです。
	 *
	 * @param a 要素1
	 * @param b 要素2
	 *
	 * @return aとbに関数を適用した結果
	 */
	abstract public E function(E a,E b);
}

/**
 * SimpleScannerクラスです。
 * java.util.Scannerクラスよりは速いですが、競プロ用に特化しているため
 * charの値がスペース以下の文字は全て区切り文字と判断します。
 */
final class SimpleScanner{

	/**
	 * SimpleScannerの内部のバッファーの容量です。
	 */
	private static final int BUFF_SIZE = 1<<17;

	/**
	 * このSimpleScannerのInputStreamインスタンスです。
	 */
	private final InputStream is;

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
		this.is = is;
		buff = new byte[BUFF_SIZE];
		point = length = 0;
	}

	/**
	 * バッファに再読み込みします。
	 * 何かしら入力がされるまで待機します。
	 */
	private void reload(){
		try{
			length = is.read(buff,point = 0,BUFF_SIZE);
		}catch(final IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * バッファから一文字読み込みます。
	 *
	 * @return 読み込んだ文字を表すbyte
	 */
	private byte read(){
		if(point==length){
			reload();
		}
		if(length<0){
			return '\n';
		}
		return buff[point++];
	}

	/**
	 * バッファから文字を表すbyteを取得します。
	 *
	 * @return まだ読んでない中で最初に入力された文字を表すbyte
	 */
	public byte nextByte(){
		byte c = read();
		while(c<=' '){
			c = read();
		}
		return c;
	}

	/**
	 * バッファからintを読み込みます。
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列をintと解釈した時の値
	 */
	public int nextInt(){
		int ans = 0;
		byte c = nextByte();
		final boolean negate = c=='-';
		if(!MathFunction.rangeCheckClose(c,'0','9')){
			c = read();
		}
		while(MathFunction.rangeCheckClose(c,'0','9')){
			ans = ans*10+c-'0';
			c = read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファからlongを読み込みます。
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列をlongと解釈した時の値
	 */
	public long nextLong(){
		long ans = 0;
		byte c = nextByte();
		final boolean negate = c=='-';
		if(!MathFunction.rangeCheckClose(c,'0','9')){
			c = read();
		}
		while(MathFunction.rangeCheckClose(c,'0','9')){
			ans = ans*10L+c-'0';
			c = read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファからcharを読み込みます。
	 *
	 * @return 区切り文字を無視した、一番最初に取得された文字を表すchar
	 */
	public char nextChar(){
		return (char)nextByte();
	}

	/**
	 * バッファからStringを読み込みます。
	 *
	 * @return 区切り文字までの文字列を表すString
	 */
	public String next(){
		final StringBuilder ans = new StringBuilder();
		byte c = nextByte();
		while(c>' '){
			ans.append((char)c);
			c = read();
		}
		return ans.toString();
	}

	/**
	 * バッファからBigIntegerを読み込みます。
	 *
	 * @return 区切り文字までの文字列を整数と解釈した時のBigInteger
	 */
	public BigInteger nextBigInteger(){
		return new BigInteger(next());
	}

	/**
	 * バッファからbyte[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字を無視してn個文字を取得した結果を表すbyte[]
	 */
	public byte[] nextByte(final int n){
		final byte[] ans = new byte[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextByte();
		}
		return ans;
	}

	/**
	 * バッファからint[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個intを取得した結果を表すint[]
	 */
	public int[] nextInt(final int n){
		final int[] ans = new int[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextInt();
		}
		return ans;
	}

	/**
	 * バッファからlong[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個longを取得した結果を表すlong[]
	 */
	public long[] nextLong(final int n){
		final long[] ans = new long[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextLong();
		}
		return ans;
	}

	/**
	 * バッファからString[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個Stringを取得した結果を表すString[]
	 */
	public String[] next(final int n){
		final String[] ans = new String[n];
		for(int i = 0;i<n;++i){
			ans[i] = next();
		}
		return ans;
	}

	/**
	 * バッファからbyte[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個byteを取得した結果を表すbyte[][]
	 */
	public byte[][] nextByte(final int n,final int m){
		final byte[][] ans = new byte[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextByte(m);
		}
		return ans;
	}

	/**
	 * バッファからint[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個intを取得した結果を表すint[][]
	 */
	public int[][] nextInt(final int n,final int m){
		final int[][] ans = new int[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextInt(m);
		}
		return ans;
	}

	/**
	 * バッファからlong[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個longを取得した結果を表すlong[][]
	 */
	public long[][] nextLong(final int n,final int m){
		final long[][] ans = new long[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextLong(m);
		}
		return ans;
	}

	/**
	 * バッファからString[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個Stringを取得した結果を表すString[][]
	 */
	public String[][] next(final int n,final int m){
		final String[][] ans = new String[n][];
		for(int i = 0;i<n;++i){
			ans[i] = next(m);
		}
		return ans;
	}

	/**
	 * バッファからStringを読み込み、char[]に変換して返します。
	 * 
	 * @return バッファから読み込んだStringを表すchar[]
	 */
	public char[] nextCharArray(){
		return next().toCharArray();
	}

	/**
	 * バッファからchar[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @return 区切り文字で区切ってn個Stringを取得した結果を表すchar[][]
	 */
	public char[][] nextCharArray(final int n){
		final char[][] ans = new char[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextCharArray();
		}
		return ans;
	}

	/**
	 * バッファから読み込んだM個のペアの整数を無向辺として処理します。
	 * 
	 * @param N 頂点の数
	 * @param M 辺の数
	 * @return N頂点M辺の無向グラフの隣接リストを表すint[][]
	 */
	public int[][] nextGraph(final int N,final int M){
		if(M==0){
			return new int[N+1][0];
		}
		final int[][] ans = new int[N+1][];
		final int[] count = new int[N+1];
		final int[][] path = nextInt(M,2);
		for(final int[] temp: path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i = 1;i<=N;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp: path){
			ans[temp[0]][--count[temp[0]]] = temp[1];
			ans[temp[1]][--count[temp[1]]] = temp[0];
		}
		ans[0] = new int[0];
		return ans;
	}

	/**
	 * バッファからPointを読み込みます。
	 * 
	 * @return 読み込んだint二つをPointに変換したインスタンス
	 */
	public Point nextPoint(){
		return new Point(nextInt(),nextInt());
	}

	/**
	 * バッファからPoint[]を読み込みます。
	 * 
	 * @param n 取得する個数
	 * @return 区切り文字で区切ってn個Pointを取得した結果を表すPoint[]
	 */
	public Point[] nextPoint(final int n){
		final Point[] ans = new Point[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextPoint();
		}
		return ans;
	}

	/**
	 * このSimpleScannerのInputStreamを閉じます。
	 */
	public void close(){
		try{
			is.close();
		}catch(final IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}

/**
 * SimpleWriterクラスです。
 * そこそこ速い出力を提供します。
 */
final class SimpleWriter implements Closeable, Flushable, AutoCloseable{

	/**
	 * このSimpleWriterのオートフラッシュが有効か保持する変数です。
	 */
	private final boolean autoFlush;

	/**
	 * このSimpleWriterのSimpleOutputStreamです。
	 */
	private SimpleOutputStream out;

	/**
	 * 改行文字列を表すchar[]です。
	 */
	private static final char[] charsOfReturn;

	/**
	 * 整数処理用のバッファーです。
	 */
	private static final byte[] integerBuffer;

	/**
	 * Long.MIN_VALUE用の配列です。
	 */
	private static final byte[] MIN_VALUE_ARRAY;

	/**
	 * '0'を表すbyteです。
	 */
	private static final byte ZERO;

	static{
		charsOfReturn = System.lineSeparator().toCharArray();
		integerBuffer = new byte[20];
		integerBuffer[0] = '-';
		ZERO = '0';
		MIN_VALUE_ARRAY = new byte[]{'-','9','2','2','3','3','7','2','0','3','6','8','5','4','7','7','5','8','0','8'};
	}

	/**
	 * 指定されたOutputStreamを元にSimpleWriterを生成します。
	 * オートフラッシュは無効です。
	 * 
	 * @param out SimpleWriterに保持させるOutputStream
	 */
	public SimpleWriter(final OutputStream out){
		this(out,false);
	}

	/**
	 * 指定されたOutputStreamとフラグを元にSimpleWriterを生成します。
	 * @param out SimpleWriterに保持させるOutputStream
	 * @param autoFlush オートフラッシュの有効無効を表すboolean
	 */
	public SimpleWriter(final OutputStream out,final boolean autoFlush){
		this.out = new SimpleOutputStream(out,1<<17);
		this.autoFlush = autoFlush;
	}

	/**
	 * バッファーにあるものを出力します。
	 */
	public void flush(){
		try{
			out.flush();
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * このSimpleWriterのSimpleOutputStreamを閉じます。
	 */
	public void close(){
		try{
			if(out==null){
				return;
			}
			out.close();
			out = null;
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 引数の値を書き込みます。
	 * 
	 * @param c 文字コード
	 */
	public void write(final int c){
		try{
			out.write(c);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された区間のcharを書き込みます。
	 * 
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final char[] buf,final int off,final int len){
		try{
			out.write(buf,off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された区間のbyteを書き込みます。
	 * 
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final byte[] buf,final int off,final int len){
		try{
			out.write(buf,off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定されたchar[]を書き込みます。
	 * 
	 * @param buf 書き込みたいchar[]
	 */
	public void write(final char[] buf){
		write(buf,0,buf.length);
	}

	/**
	 * 指定されたbyte[]を書き込みます。
	 * 
	 * @param buf 書き込みたいbyte[]
	 */
	public void write(final byte[] buf){
		write(buf,0,buf.length);
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
			out.write(s.toCharArray(),off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された文字列を書き込みます。
	 * 
	 * @param s 書き込みたい文字列
	 */
	public void write(final String s){
		write(s.toCharArray(),0,s.length());
	}

	/**
	 * 改行を書き込みます。
	 */
	private void newLine(){
		try{
			out.write(charsOfReturn,0,charsOfReturn.length);
			if(autoFlush){
				out.flush();
			}
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 引数のbooleanを表す文字列を改行無しで出力します。
	 * 
	 * @param b 出力したいboolean
	 */
	public void print(final boolean b){
		write(b?"true":"false");
	}

	/**
	 * 引数のcharを改行無しで出力します。
	 * 
	 * @param c 出力したいchar
	 */
	public void print(final char c){
		write(c);
	}

	/**
	 * 引数のlongを改行無しで出力します。
	 * 
	 * @param l 出力したいlong
	 */
	public void print(final long l){
		if(l==Long.MIN_VALUE){
			write(MIN_VALUE_ARRAY);
		}
		else{
			long num = Math.abs(l);
			int len = MathFunction.digit(num);
			for(int i=len;i>0;i--){
				integerBuffer[i] = (byte)(num%10+ZERO);
				num /= 10;
			}
			if(l<0)
				write(integerBuffer,0,len+1);
			else
				write(integerBuffer,1,len);
		}
	}

	/**
	 * 引数のfloatを改行無しで出力します。
	 * 
	 * @param f 出力したいfloat
	 */
	public void print(final float f){
		write(String.valueOf(f).toCharArray());
	}

	/**
	 * 引数のdoubleを改行無しで出力します。
	 * 
	 * @param d 出力したいdouble
	 */
	public void print(final double d){
		write(String.valueOf(d).toCharArray());
	}

	/**
	 * 引数のchar[]を改行無しで出力します。
	 * 
	 * @param s 出力したいchar[]
	 */
	public void print(final char[] s){
		write(s);
	}

	/**
	 * 引数のObjectを改行無しで出力します。
	 * このメソッドはprint(obj.toString().toCharArray())と等価です。
	 * 
	 * @param obj 出力したいObject
	 */
	public void print(final Object obj){
		write(obj.toString().toCharArray());
	}

	/**
	 * 改行を出力します。
	 */
	public void println(){
		newLine();
	}

	/**
	 * 引数のbooleanを表す文字列を改行ありで出力します。
	 * 
	 * @param x 出力したいboolean
	 */
	public void println(final boolean x){
		print(x);
		println();
	}

	/**
	 * 引数のcharを改行ありで出力します。
	 * 
	 * @param x 出力したいchar
	 */
	public void println(final char x){
		print(x);
		println();
	}

	/**
	 * 引数のintを改行ありで出力します。
	 * 
	 * @param x 出力したいint
	 */
	public void println(final int x){
		print(x);
		println();
	}

	/**
	 * 引数のlongを改行ありで出力します。
	 * 
	 * @param x 出力したいlong
	 */
	public void println(final long x){
		print(x);
		println();
	}

	/**
	 * 引数のfloatを改行ありで出力します。
	 * 
	 * @param x 出力したいfloat
	 */
	public void println(final float x){
		print(x);
		println();
	}

	/**
	 * 引数のdoubleを改行ありで出力します。
	 * 
	 * @param x 出力したいdouble
	 */
	public void println(final double x){
		print(x);
		println();
	}

	/**
	 * 引数のchar[]を改行ありで出力します。
	 * 
	 * @param x 出力したいchar[]
	 */
	public void println(final char[] x){
		print(x);
		println();
	}

	/**
	 * 引数のStringを改行ありで出力します。
	 * 
	 * @param x 出力したいString
	 */
	public void println(final String x){
		print(x);
		println();
	}

	/**
	 * 引数のObjectを改行ありで出力します。
	 * 
	 * @param x 出力したいObject
	 */
	public void println(final Object x){
		print(x);
		println();
	}

	/**
	 * 指定されたフォーマットで引数を出力します。
	 * 
	 * @param format フォーマット
	 * @param args 出力したい引数
	 * @return このSimpleWriter
	 */
	public SimpleWriter printf(final String format,final Object... args){
		print(String.format(format,args));
		return this;
	}

	/**
	 * 指定されたCharSequenceをSimpleOutputStreamに追加します。
	 * 
	 * @param csq 追加したいCharSequence
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(final CharSequence csq){
		write(String.valueOf(csq).toCharArray());
		return this;
	}

	/**
	 * 指定されたCharSequenceの区間をSimpleOutputStreamに追加します。
	 * 
	 * @param csq 追加したいCharSequence
	 * @param start 開始地点(startを含む)
	 * @param end 終了地点(endを含まない)
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(CharSequence csq,final int start,final int end){
		if(csq==null){
			csq = "null";
		}
		return append(csq.subSequence(start,end));
	}

	/**
	 * 指定されたcharをSimpleOutputStreamに追加します。
	 * 
	 * @param c 追加したいchar
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(final char c){
		write(c);
		return this;
	}

	/**
	 * int[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 */
	public void print(final int[] array){
		print(array,' ');
	}

	/**
	 * int[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param str 区切り文字
	 */
	public void print(final int[] array,final String str){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * int[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param c 区切り文字
	 */
	public void print(final int[] array,final char c){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * int[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいint[][]
	 */
	public void print(final int[][] array){
		print(array,' ');
	}

	/**
	 * int[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param str 区切り文字
	 */
	public void print(final int[][] arrays,final String str){
		if(arrays.length==0)
			return;
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * int[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param c 区切り文字
	 */
	public void print(final int[][] arrays,final char c){
		if(arrays.length==0)
			return;
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * int[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 */
	public void println(final int[] array){
		print(array,' ');
		println();
	}

	/**
	 * int[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param str 区切り文字
	 */
	public void println(final int[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * int[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param c 区切り文字
	 */
	public void println(final int[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * int[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいint[][]
	 */
	public void println(final int[][] array){
		print(array,' ');
		println();
	}

	/**
	 * int[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param str 区切り文字
	 */
	public void println(final int[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * int[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param c 区切り文字
	 */
	public void println(final int[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * long[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 */
	public void print(final long[] array){
		print(array,' ');
	}

	/**
	 * long[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param str 区切り文字
	 */
	public void print(final long[] array,final String str){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * long[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param c 区切り文字
	 */
	public void print(final long[] array,final char c){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * long[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいlong[][]
	 */
	public void print(final long[][] array){
		print(array,' ');
	}

	/**
	 * long[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param str 区切り文字
	 */
	public void print(final long[][] arrays,final String str){
		if(arrays.length==0)
			return;
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * long[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param c 区切り文字
	 */
	public void print(final long[][] arrays,final char c){
		if(arrays.length==0)
			return;
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * long[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 */
	public void println(final long[] array){
		println(array,' ');
	}

	/**
	 * long[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param str 区切り文字
	 */
	public void println(final long[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * long[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param c 区切り文字
	 */
	public void println(final long[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * long[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいlong[][]
	 */
	public void println(final long[][] array){
		println(array,' ');
	}

	/**
	 * long[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param str 区切り文字
	 */
	public void println(final long[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * long[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param c 区切り文字
	 */
	public void println(final long[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * double[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 */
	public void print(final double[] array){
		print(array,' ');
	}

	/**
	 * double[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param str 区切り文字
	 */
	public void print(final double[] array,final String str){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * double[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param c 区切り文字
	 */
	public void print(final double[] array,final char c){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * double[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいdouble[][]
	 */
	public void print(final double[][] array){
		print(array,' ');
	}

	/**
	 * double[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param str 区切り文字
	 */
	public void print(final double[][] arrays,final String str){
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * double[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param c 区切り文字
	 */
	public void print(final double[][] arrays,final char c){
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * double[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 */
	public void println(final double[] array){
		println(array,' ');
	}

	/**
	 * double[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param str 区切り文字
	 */
	public void println(final double[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * double[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param c 区切り文字
	 */
	public void println(final double[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * double[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいdouble[][]
	 */
	public void println(final double[][] array){
		println(array,' ');
	}

	/**
	 * double[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param str 区切り文字
	 */
	public void println(final double[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * double[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param c 区切り文字
	 */
	public void println(final double[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * char[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param cs 出力したいchar[]
	 * @param str 区切り文字
	 */
	public void println(final char[] cs,final String str){
		print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			print(str);
			print(cs[i]);
		}
		println();
	}

	/**
	 * char[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param cs 出力したいchar[]
	 * @param c 区切り文字
	 */
	public void println(final char[] cs,final char c){
		print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			print(c);
			print(cs[i]);
		}
		println();
	}

	/**
	 * char[][]を改行区切りで、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 */
	public void println(final char[][] cs){
		for(final char[] c: cs){
			println(c);
		}
	}

	/**
	 * char[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 * @param str 区切り文字
	 */
	public void println(final char[][] cs,final String str){
		for(final char[] c: cs){
			println(c,str);
		}
	}

	/**
	 * char[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 * @param c 区切り文字
	 */
	public void println(final char[][] cs,final char c){
		for(final char[] cc: cs){
			println(cc,c);
		}
	}

	/**
	 * 配列を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array){
		print(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final String str){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * 配列を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final char c){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays){
		print(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final String str){
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final char c){
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * 配列を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array){
		println(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * 配列を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays){
		println(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * リストを空白区切りで改行無しで出力します。
	 * 
	 * @param list 出力したいリスト
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list){
		println(list,' ');
	}

	/**
	 * リストを指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param list 出力したいリスト
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final String str){
		if(list.size()>0){
			print(list.get(0));
			for(int i = 1;i<list.size();++i){
				print(str);
				print(list.get(i));
			}
		}
		println();
	}

	/**
	 * リストを指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param list 出力したいリスト
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final char c){
		if(list.size()>0){
			print(list.get(0));
			for(int i = 1;i<list.size();++i){
				print(c);
				print(list.get(i));
			}
		}
		println();
	}

	/**
	 * SimpleWriterクラス用のSimpleOutputStreamクラスです。
	 * ちょっとだけ速いです。
	 */
	public final class SimpleOutputStream{

		/**
		 * このSimpleOutputStreamのバッファーです。
		 */
		private final byte[] buf;

		/**
		 * このSimpleOutputStreamのバッファーにある文字数を管理する変数です。
		 */
		private int count;

		/**
		 * このSimpleoutputStreamの元となるoutputStreamです。
		 */
		private OutputStream out;

		/**
		 * 指定されたOutputStreamとバッファーサイズを元にSimpleOutputStreamを生成します。
		 * 
		 * @param out SimpleOutputStreamの元となるOutputStream
		 * @param size バッファーサイズ
		 */
		public SimpleOutputStream(final OutputStream out,final int size){
			this.out = out;
			if(size<=0){
				throw new IllegalArgumentException("Buffer size <= 0");
			}
			buf = new byte[size];
		}

		/**
		 * バッファリングしている文字をOutputStreamに書き込みます。
		 * 
		 * @throws IOException
		 */
		private void flushBuffer() throws IOException{
			if(count>0){
				out.write(buf,0,count);
				count = 0;
			}
		}

		/**
		 * 引数の値をバッファリングします。
		 * 
		 * @param b バッファリング対象
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final int b) throws IOException{
			if(count>=buf.length){
				flushBuffer();
			}
			buf[count++] = (byte)b;
		}

		/**
		 * 引数のchar[]の指定された文字数分をバッファリングします。
		 * 
		 * @param ch 元となるchar[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final char[] ch,final int off,final int len) throws IOException{
			if(len>=buf.length){
				flushBuffer();
				out.write(parseByteArray(ch,off,len),0,len);
				return;
			}
			if(len>buf.length-count){
				flushBuffer();
			}
			for(int i=0;i<len;i++){
				buf[count+i] = (byte)ch[i+off];
			}
			count += len;
		}
		
		/**
		 * 指定されたchar[]の区間をbyte[]に変換します。
		 * 
		 * @param ch 元となるchar[]
		 * @param off 開始始点
		 * @param len 文字数
		 * @return 変換後のbyte[]
		 */
		private byte[] parseByteArray(final char[] ch,final int off,final int len){
			final byte[] ans = new byte[len];
			for(int i=0;i<len;i++){
				ans[i] = (byte)ch[i+off];
			}
			return ans;
		}

		/**
		 * 指定されたbyte[]の要素分バッファリングします。
		 * 
		 * @param b 元となるbyte[]
		 * @param off 開始地点
		 * @param len 要素数
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final byte[] b,final int off,final int len) throws IOException{
			if(len>=buf.length){
				flushBuffer();
				out.write(b,off,len);
				return;
			}
			if(len>buf.length-count){
				flushBuffer();
			}
			System.arraycopy(b,off,buf,count,len);
			count += len;
		}

		/**
		 * バッファリングしている文字を書き込み、OutputStreamをフラッシュします。
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void flush() throws IOException{
			flushBuffer();
			out.flush();
		}

		/**
		 * このSimpleOutputStreamの元となるOutputStreamを閉じます。
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void close() throws IOException{
			flush();
			out.close();
			out = null;
		}
	}
}

/**
 * ソートに関するメソッドを提供するクラスです。
 * カウントソートや挿入ソート、プリミティヴ型のソートでの比較関数の指定など、
 * Arrays::sortでカバーできない部分を提供します。
 */
final class Sorter{

	/**
	 * int型配列を比較関数を元にソートします。
	 * ソートアルゴリズムはマージソートを採用しています。
	 * 
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final int[] array,final IntBinaryOperator comparator){
		final int N = array.length;
		if(N<2){
			return;
		}
		final int len1 = N>>1;
		final int len2 = N-len1;
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
				array[k++] = array1[i++];
			}
			else{
				array[k++] = array2[j++];
			}
		}
		while(i<len1){
			array[k++] = array1[i++];
		}
		while(j<len2){
			array[k++] = array2[j++];
		}
	}

	/**
	 * long型配列を比較関数を元にソートします。
	 * ソートアルゴリズムはマージソートを採用しています。
	 * 
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final long[] array,final LongBinaryOperator comparator){
		final int N = array.length;
		if(N<2){
			return;
		}
		final int len1 = N>>1;
		final int len2 = N-len1;
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
				array[k++] = array1[i++];
			}
			else{
				array[k++] = array2[j++];
			}
		}
		while(i<len1){
			array[k++] = array1[i++];
		}
		while(j<len2){
			array[k++] = array2[j++];
		}
	}

	/**
	 * char型配列を比較関数を元にソートします。
	 * ソートアルゴリズムはマージソートを採用しています。
	 * 
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final char[] array,final IntBinaryOperator comparator){
		final int N = array.length;
		if(N<2){
			return;
		}
		final int len1 = N>>1;
		final int len2 = N-len1;
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
				array[k++] = array1[i++];
			}
			else{
				array[k++] = array2[j++];
			}
		}
		while(i<len1){
			array[k++] = array1[i++];
		}
		while(j<len2){
			array[k++] = array2[j++];
		}
	}

	/**
	 * double型配列を比較関数を元にソートします。
	 * ソートアルゴリズムはマージソートを採用しています。
	 * 
	 * @param array ソートしたい配列
	 * @param comparator 比較関数
	 */
	public static void sort(final double[] array,final DoubleBinaryOperator comparator){
		final int N = array.length;
		if(N<2){
			return;
		}
		final int len1 = N>>1;
		final int len2 = N-len1;
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
				array[k++] = array1[i++];
			}
			else{
				array[k++] = array2[j++];
			}
		}
		while(i<len1){
			array[k++] = array1[i++];
		}
		while(j<len2){
			array[k++] = array2[j++];
		}
	}

	/**
	 * カウントソートによるソートです。
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 * @param maximumLimit array内の最大要素
	 */
	public static void countSort(final int[] array,final int maximumLimit){
		countSort(array,0,array.length,maximumLimit);
	}

	/**
	 * カウントソートによるソートです。
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 * @param maximumLimit array内の最大要素
	 */
	public static void countSort(final int[] array,final int l,final int r,final int maximumLimit){
		final int[] list = new int[maximumLimit+1];
		for(int i = l;i<r;++i){
			++list[array[i]];
		}
		int temp = l;
		for(int i = 0;i<list.length;++i){
			while(list[i]-->0){
				array[temp++] = i;
			}
		}
	}

	/**
	 * カウントソートによるソートです。
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 * @param maximumLimit array内の最大要素
	 */
	public static void countSort(final char[] array,final char maximumLimit){
		countSort(array,0,array.length,maximumLimit);
	}

	/**
	 * カウントソートによるソートです。
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 * @param maximumLimit array内の最大要素
	 */
	public static void countSort(final char[] array,final int l,final int r,final char maximumLimit){
		final int[] list = new int[maximumLimit+1];
		for(int i = l;i<r;++i){
			++list[array[i]];
		}
		int temp = l;
		for(char c = 0;c<list.length;++c){
			while(list[c]-->0){
				array[temp++] = c;
			}
		}
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 */
	public static void insertSort(final int[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void insertSort(final int[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			int num = array[j];
			while(l<j&&array[j-1]>num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のlong型配列
	 */
	public static void insertSort(final long[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のlong型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void insertSort(final long[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			long num = array[j];
			while(l<j&&array[j-1]>num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 */
	public static void insertSort(final char[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void insertSort(final char[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			char num = array[j];
			while(l<j&&array[j-1]>num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 *
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void insertSort(final E[] array){
		insertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによるソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 *
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void insertSort(final E[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			E num = array[j];
			while(l<j&&array[j-1].compareTo(num)>0){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 */
	public static void reverseInsertSort(final int[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void reverseInsertSort(final int[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			int num = array[j];
			while(l<j&&array[j-1]<num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のlong型配列
	 */
	public static void reverseInsertSort(final long[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のlong型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void reverseInsertSort(final long[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			long num = array[j];
			while(l<j&&array[j-1]<num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 */
	public static void reverseInsertSort(final char[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のchar型配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 */
	public static void reverseInsertSort(final char[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			char num = array[j];
			while(l<j&&array[j-1]<num){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 *
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void reverseInsertSort(final E[] array){
		reverseInsertSort(array,0,array.length);
	}

	/**
	 * 挿入ソートによる逆順ソートです。
	 * 各要素がほとんどソートされている場合はこちらの使用を推奨します。
	 *
	 * @param array ソート対象の配列
	 * @param l ソート範囲の左端
	 * @param r ソート範囲の右端(rを含まない)
	 *
	 * @param <E> 配列の要素の型
	 */
	public static <E extends Comparable<E>> void reverseInsertSort(final E[] array,final int l,final int r){
		for(int i = l+1;i<r;i++){
			int j = i;
			E num = array[j];
			while(l<j&&array[j-1].compareTo(num)<0){
				array[j] = array[j-1];
				--j;
			}
			array[j] = num;
		}
	}
}

/**
 * StaticRollingHashクラスです。
 * 一応文字列連結メソッドなどを実装していますが、
 * ハッシュ値を再計算するため、高頻度での使用は推奨されません。
 */
final class StaticRollingHash implements Comparable<StaticRollingHash>{

	/**
	 * 底となる値です。
	 * 実行時に決まります。
	 */
	private static final long BASE = new Random().nextInt(1000)+Character.MAX_VALUE+1;

	/**
	 * 剰余計算用の変数です。
	 */
	private static final long MASK30,MASK31,MOD,MASK61;
	static{
		MASK30 = (1L<<30)-1;
		MASK31 = (1L<<31)-1;
		MOD = (1L<<61)-1;
		MASK61 = MOD;
	}

	/**
	 * ハッシュ値記録用の配列です。
	 */
	private long[] hash;

	/**
	 * このStaticRollingHashインスタンスが表す文字列です。
	 */
	private String string;

	/**
	 * 引数の文字列を元にStaticRollingHashを構築します。
	 *
	 * @param str 元となるString
	 */
	public StaticRollingHash(final String str){
		string = str;
		hash = new long[str.length()+1];
		roll();
	}

	/**
	 * フィールドのstringを元にハッシュ値を計算します。
	 */
	private void roll(){
		final int len = string.length();
		for(int i = 1;i<=len;++i){
			hash[i] = multiply(hash[i-1],BASE)+string.charAt(i-1)-' '+1;
			if(MOD<=hash[i]){
				hash[i] -= MOD;
			}
		}
	}

	/**
	 * long*long用の特別メソッドです。
	 *
	 * @param a 乗算する値
	 * @param b 乗算される値
	 *
	 * @return a*b mod 2^61-1
	 */
	private static long multiply(final long a,final long b){
		final long au = a>>31;
		final long ad = a&MASK31;
		final long bu = b>>31;
		final long bd = b&MASK31;
		final long mid = ad*bu+au*bd;
		final long midu = mid>>30;
		final long midd = mid&MASK30;
		return mod(au*bu*2+midu+(midd<<31)+ad*bd);
	}

	/**
	 * x mod 2^61-1を計算します。
	 *
	 * @param x 元となる値
	 *
	 * @return x mod 2^61-1
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
	 * @param l 左端
	 * @param r 右端
	 *
	 * @return [l,r]のハッシュ値
	 */
	public long getHash(final int l,final int r){
		return (hash[r]-multiply(hash[l],modBasePow(r-l))+MOD)%MOD;
	}

	/**
	 * BASE^b mod 2^61-1を計算します。
	 *
	 * @param b 指数
	 *
	 * @return BASE^b mod 2^61-1
	 */
	private static long modBasePow(long b){
		long ans = 1;
		long a = BASE;
		while(b>0){
			if((b&1)==1){
				ans = multiply(ans,a);
			}
			a = multiply(a,a);
			b >>= 1;
		}
		return ans;
	}

	/**
	 * 指定された区間と引数の指定された区間が等しいか返します。
	 *
	 * @param rh 比較対象のStaticRollingHash
	 * @param l1 このStaticRollingHashの左端
	 * @param r1 このStaticRollingHashの右端
	 * @param l2 比較対象の左端
	 * @param r2 比較対象の右端
	 *
	 * @return 等しい可能性があるならtrue、確実に異なるならfalse
	 */
	public boolean equals(final StaticRollingHash rh,final int l1,final int r1,final int l2,final int r2){
		if(r1-l1!=r2-l2){
			return false;
		}
		return getHash(l1,r1)==rh.getHash(l2,r2);
	}

	/**
	 * このStaticRollingHashの長さを返します。
	 *
	 * @return このStaticRollingHashの長さ
	 */
	public int length(){
		return string.length();
	}

	/**
	 * このStaticRollingHashの元となるStringのハッシュ値を返します。
	 *
	 * @return このStaticRollingHashの元となるStringのハッシュ値
	 */
	@Override public int hashCode(){
		return (int)hash[length()];
	}

	/**
	 * このStaticRollingHashの元となるStringを返します。
	 *
	 * @return このStaticRollingHashの元となるString
	 */
	@Override public String toString(){
		return string;
	}

	/**
	 * 引数と自身が等しいか返します。
	 *
	 * @param o 比較対象
	 *
	 * @return 等しい可能性があるならtrue、確実に異なるならfalse
	 */
	@Override public boolean equals(Object o){
		if(o instanceof final StaticRollingHash rh){
			return equals(rh,0,length(),0,rh.length());
		}
		return false;
	}

	/**
	 * 引数のStaticRollingHashの元となるStringと辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら-1、等しいなら0、それ以外は1
	 */
	@Override public int compareTo(StaticRollingHash rh){
		return string.compareTo(rh.toString());
	}

	/**
	 * 引数のStringと辞書順で比較します。
	 *
	 * @param str the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら-1、等しいなら0、それ以外は1
	 */
	public int compareTo(String str){
		return string.compareTo(str);
	}

	/**
	 * このStaticRollingHashのi文字目を返します。
	 *
	 * @param i インデックス
	 *
	 * @return i番目の文字を表すchar
	 */
	public char charAt(final int i){
		return string.charAt(i);
	}

	/**
	 * 引数のStaticRollingHashの元となるStringと大文字小文字を無視して辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら-1、等しいなら0、それ以外は1
	 */
	public int compareToIgnoreCase(final StaticRollingHash rh){
		return string.compareToIgnoreCase(rh.toString());
	}

	/**
	 * 引数のStringと大文字小文字を無視して辞書順で比較します。
	 *
	 * @param str the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら-1、等しいなら0、それ以外は1
	 */
	public int compareToIgnoreCase(final String str){
		return string.compareToIgnoreCase(str);
	}

	/**
	 * 引数のStaticRollingHashを末尾に連結します。
	 * 計算量はO(length+rh.length)です。
	 *
	 * @param rh 連結する文字列を表すStaticRollingHash
	 */
	public void concat(final StaticRollingHash rh){
		concat(rh.toString());
	}

	/**
	 * 引数のStringを末尾に連結します。
	 * 計算量はO(length+rh.length)です。
	 *
	 * @param str 連結する文字列
	 */
	public void concat(final String str){
		string = string.concat(str);
		hash = new long[string.length()+1];
		roll();
	}

	/**
	 * このStaticRollingHashの連続部分列として引数のStaticRollingHashが存在するか判定します。
	 *
	 * @param rh 連続部分列として存在するか検査するStaticRollingHash
	 *
	 * @return 部分列として存在する可能性があるならtrue、確実に含まれていないならfalse
	 */
	public boolean contains(final StaticRollingHash rh){
		final long hash = rh.getHash(0,rh.length());
		final int len = length()-rh.length();
		for(int i = 0;i<=len;++i){
			if(hash==getHash(i,rh.length()+i)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 引数のStringが連続部分列として存在するか判定します。
	 *
	 * @param str 存在判定をするString
	 *
	 * @return 連続部分列として存在するならtrue、それ以外はfalse
	 */
	public boolean contains(final String str){
		return indexOf(str)!=-1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param ch 探索する文字を表すint
	 *
	 * @return 最も左側にある引数の文字のインデックス(無ければ - 1)
	 */
	public int indexOf(final int ch){
		return indexOf(ch,0);
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param ch 探索する文字を表すint
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字のインデックス(無ければ - 1)
	 */
	public int indexOf(final int ch,final int fromIndex){
		final int len = length();
		for(int i = fromIndex;i<len;++i){
			if(string.charAt(i)==ch){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字列が先頭から何番目に存在するか返します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param str 探索する文字列
	 *
	 * @return 最も左側にある引数の文字列のインデックス(無ければ - 1)
	 */
	public int indexOf(final String str){
		return indexOf(str,0);
	}

	/**
	 * 引数の文字列を指定されたインデックス以降で探索します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param str 探索する文字列
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字列のインデックス(無ければ - 1)
	 */
	public int indexOf(final String str,final int fromIndex){
		long hash = 0;
		for(final char c: str.toCharArray()){
			hash = multiply(hash,BASE)+c-' '+1;
			if(MOD<=hash){
				hash -= MOD;
			}
		}
		final int len = length()-str.length();
		for(int i = fromIndex;i<=len;++i){
			if(hash==getHash(i,str.length()+i)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * このStaticRollingHashが表す文字列が空文字列か判定します。
	 *
	 * @return ""と等しいならtrue、それ以外はfalse
	 */
	public boolean isEmpty(){
		return length()==0;
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param ch 探索する文字を表すint
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も右側にある引数の文字のインデックス(無ければ - 1)
	 */
	public int lastIndexOf(final int ch,final int fromIndex){
		for(int i = fromIndex;i>=0;--i){
			if(string.charAt(i)==ch){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。
	 * 存在しない場合は-1を返します。
	 *
	 * @param ch 探索する文字を表すint
	 *
	 * @return 最も左側にある引数の文字のインデックス(無ければ - 1)
	 */
	public int lastIndexOf(final int ch){
		return lastIndexOf(ch,length()-1);
	}

	/**
	 * 引数のbooleanを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param b 元となるboolean
	 *
	 * @return 引数のbooleanを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final boolean b){
		return new StaticRollingHash(b?"true":"false");
	}

	/**
	 * 引数のcharを元にStaticRollingHashを構築します。
	 *
	 * @param c 元となるchar
	 *
	 * @return 引数のcharを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char c){
		return new StaticRollingHash(""+c);
	}

	/**
	 * 引数のchar[]を表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param c 元となるchar[]
	 *
	 * @return 引数のchar[]を表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] c){
		return new StaticRollingHash(String.valueOf(c,0,c.length));
	}

	/**
	 * 引数のchar[]を表す文字列の、引数の区間を元にStaticRollingHashを構築します。
	 *
	 * @param c 元となるchar[]
	 * @param offset 左端
	 * @param count 文字数
	 *
	 * @return 引数のchar[]の引数の区間を表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] c,final int offset,final int count){
		return new StaticRollingHash(String.valueOf(c,offset,count));
	}

	/**
	 * 引数のdoubleを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param d 元となるdouble
	 *
	 * @return 引数のdoubleを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final double d){
		return new StaticRollingHash(String.valueOf(d));
	}

	/**
	 * 引数のfloatを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param f 元となるfloat
	 *
	 * @return 引数のfloatを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final float f){
		return new StaticRollingHash(String.valueOf(f));
	}

	/**
	 * 引数のintを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param i 元となるint
	 *
	 * @return 引数のintを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final int i){
		return new StaticRollingHash(String.valueOf(i));
	}

	/**
	 * 引数のlongを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param l 元となるlong
	 *
	 * @return 引数のlongを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final long l){
		return new StaticRollingHash(String.valueOf(l));
	}

	/**
	 * 引数のObjectを表す文字列を元にStaticRollingHashを構築します。
	 *
	 * @param obj 元となるObject
	 *
	 * @return 引数のObjectを表すStaticRollingHash
	 */
	public static StaticRollingHash valueOf(final Object obj){
		return new StaticRollingHash(String.valueOf(obj));
	}
}

/**
 * Treeクラスです。
 * java.util.TreeSetと基本変わりませんが、インデックスを指定してのアクセスがO(log N)で可能です。
 *
 * @param <E> Treeに載せる要素の型
 */
final class Tree<E extends Comparable<E>>{

	/**
	 * 根を表すNodeです。
	 */
	private Node root;

	/**
	 * 状態管理用の変数です。
	 */
	private int size, hash;

	/**
	 * 空のTreeクラスを生成します。
	 */
	public Tree(){
		size = 0;
		root = null;
		hash = 0;
	}

	/**
	 * 要素を保持するNodeクラスです。
	 */
	final private class Node{

		/**
		 * このNodeインスタンスが持つ要素です。
		 */
		E value;

		/**
		 * 状態管理用の変数です。
		 */
		int height, size;

		/**
		 * 親、左右のNodeを保持する変数です。
		 */
		Node left, right, parent;

		/**
		 * 指定された情報を元にNodeインスタンスを生成します。
		 * 
		 * @param p 親となるNodeインスタンス
		 * @param v 要素
		 */
		public Node(final Node p,final E v){
			value = v;
			parent = p;
			height = 1;
			size = 1;
		}
	}

	/**
	 * 引数の要素をこのTreeインスタンスに追加しようと試みます。
	 * 
	 * @param x 追加する要素
	 * @return 追加されたらtrue、それ以外はfalse
	 */
	public boolean add(final E x){
		boolean bool = true;
		if(root==null){
			root = new Node(null,x);
		}
		else{
			Node par;
			Node now = root;
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
					bool = false;
					break;
				}
			}
			while(now!=null);
			if(bool){
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x);
				}
				else{
					par.right = new Node(par,x);
				}
				fix(par);
			}
		}
		if(bool){
			++size;
			hash ^= x.hashCode();
		}
		return bool;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * 
	 * @param index インデックス
	 * @return 先頭からindex番目の要素
	 */
	public E get(int index){
		if(root==null||size<=index){
			throw new NullPointerException();
		}
		Node now = root;
		while(true){
			assert now!=null;
			final int ls = now.left!=null?now.left.size:0;
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
		return now.value;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * 
	 * @param index インデックス
	 * @return 先頭からindex番目の要素
	 */
	public int getIndex(E x){
		Node now = root;
		int index = 0;
		while(now!=null){
			int result = now.value.compareTo(x);
			if(0<result){
				now = now.left;
			}
			else{
				index += now.left==null?0:now.left.size;
				if(result<0){
					now = now.right;
					index++;
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
	 * @return 要素が削除できたらtrue、それ以外はfalse
	 */
	public boolean remove(final E x){
		final Node n = getNode(x);
		if(n==null){
			return false;
		}
		--size;
		hash ^= n.value.hashCode();
		delete(n);
		return true;
	}

	/**
	 * 引数のNodeインスタンスを削除します。
	 * 
	 * @param node 削除対象
	 */
	private void delete(final Node node){
		if(node!=null){
			if(node.left==null&&node.right==null){
				if(node.parent!=null){
					if(node.parent.left==node){
						node.parent.left = null;
					}
					else{
						node.parent.right = null;
					}
					fix(node.parent);
				}
				else{
					root = null;
				}
				node.parent = null;
			}
			else{
				if(node.left!=null&&node.right!=null){
					final Node rep = getFirstNode(node.right);
					node.value = rep.value;
					delete(rep);
				}
				else{
					final Node rep = node.left!=null?node.left:node.right;
					rep.parent = node.parent;
					if(node.parent!=null){
						if(node.parent.left==node){
							node.parent.left = rep;
						}
						else{
							node.parent.right = rep;
						}
						fix(node.parent);
					}
					else{
						root = rep;
					}
					node.parent = null;
				}
			}
		}
	}

	/**
	 * 指定された要素を持つNodeインスタンスを返します。
	 * 無い場合はnullを返します。
	 * 
	 * @param x 指定する要素
	 * @return 指定された要素を持つNodeインスタンス
	 */
	private Node getNode(final E x){
		Node now = root;
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
	 * このTreeインスタンスの先頭の要素を返します。
	 * もしこのTreeインスタンスが空ならnullを返します。
	 * 
	 * @return このTreeインスタンスの先頭の要素
	 */
	public E first(){
		if(root==null){
			return null;
		}
		return getFirstNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の先頭の要素を持つNodeインスタンスを返します。
	 * 指定するNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return この部分木の先頭の要素を持つNodeインスタンス
	 */
	private Node getFirstNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * このTreeインスタンスの末尾の要素を返します。
	 * もしそのような要素が存在しない場合はnullを返します。
	 * 
	 * @return このTreeインスタンスの末尾の要素
	 */
	public E last(){
		if(root==null){
			return null;
		}
		return getLastNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の末尾の要素を持つNodeインスタンスを返します。
	 * 指定するNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return この部分木の末尾の要素を持つNodeインスタンス
	 */
	private Node getLastNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 指定された要素がこのTreeインスタンスに存在するか判定します。
	 * 
	 * @param x 探索対象の要素
	 * @return 指定された要素が存在するならtrue、それ以外はfalse
	 */
	public boolean contains(final E x){
		if(root==null){
			return false;
		}
		return getNode(x)!=null;
	}

	/**
	 * このTreeインスタンスの先頭の要素を取得し、削除します。
	 * もしそのような要素が存在しない場合はnullを返します。
	 * 
	 * @return このTreeインスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(root==null){
			return null;
		}
		--size;
		final Node min = getFirstNode(root);
		hash ^= min.value.hashCode();
		delete(min);
		return min.value;
	}

	/**
	 * このTreeインスタンスの末尾の要素を取得し、削除します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeインスタンスの末尾の要素
	 */
	public E pollLast(){
		if(root==null){
			return null;
		}
		--size;
		final Node max = getLastNode(root);
		hash ^= max.value.hashCode();
		delete(max);
		return max.value;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xと同等かそれ以降の要素で最小の要素
	 */
	public E ceiling(final E x){
		return ceiling(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * xと同等かそれ以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return xと同等かそれ以降の要素で最小の要素
	 */
	private E ceiling(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return x以降の要素で最小の要素
	 */
	public E higher(final E x){
		return higher(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * x以降の要素で最小の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return x以降の要素で最小の要素
	 */
	private E higher(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素と同等かそれ以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xと同等かそれ以前の要素で最大の要素
	 */
	public E floor(final E x){
		return floor(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * xと同等かそれ以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return xと同等かそれ以前の要素で最大の要素
	 */
	private E floor(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return x以前の要素で最大の要素
	 */
	public E lower(final E x){
		return lower(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の、
	 * x以前の要素で最大の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return x以前の要素で最大の要素
	 */
	private E lower(Node node,final E x){
		Node ans = null;
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
	 * このTreeインスタンスを空にします。
	 */
	public void clear(){
		root = null;
		size = 0;
		hash = 0;
	}

	/**
	 * このTreeインスタンスが空か判定します。
	 * 
	 * @return このTreeインスタンスが空ならtrue、それ以外はfalse
	 */
	public boolean isEmpty(){
		return size==0;
	}

	/**
	 * このTreeインスタンスの要素数を返します。
	 * 
	 * @return このTreeインスタンスの要素数
	 */
	public int size(){
		return size;
	}

	/**
	 * このTreeインスタンスと同等なArrayListを返します。
	 * 各要素はTreeインスタンスの要素と連動します。
	 * 
	 * @return このTreeインスタンスを表すArrayList
	 */
	public ArrayList<E> toList(){
		final ArrayList<E> list = new ArrayList<>();
		if(root!=null){
			final ArrayDeque<Node> deq = new ArrayDeque<>();
			deq.add(root);
			while(!deq.isEmpty()){
				final Node now = deq.pollLast();
				if(list.size()==0){
					if(now.left!=null){
						deq.add(now);
						deq.add(now.left);
					}
					else{
						list.add(now.value);
						if(now.right!=null){
							deq.add(now.right);
						}
					}
				}
				else if(now.left!=null&&list.get(list.size()-1).compareTo(now.left.value)<0){
					deq.add(now);
					deq.add(now.left);
				}
				else{
					list.add(now.value);
					if(now.right!=null){
						deq.add(now.right);
					}
				}
			}
		}
		return list;
	}

	/**
	 * このTreeインスタンスを表すStringを返します。
	 */
	@Override public String toString(){
		final ArrayList<E> list = toList();
		return list.toString();
	}

	/**
	 * 引数がこのTreeインスタンスと同等か判定します。
	 */
	@Override public boolean equals(final Object o){
		if(o instanceof final Tree<?> tree){
			if(size!=tree.size()){
				return false;
			}
			final ArrayList<E> list1 = toList();
			final ArrayList<?> list2 = tree.toList();
			for(int i = 0;i<size;++i){
				if(!list1.get(i).equals(list2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このTreeを表すハッシュ値を返します。
	 */
	@Override public int hashCode(){
		return hash;
	}

	/**
	 * 指定されたNodeインスタンスを根の方向に辿りながら平衡を修正します。
	 * 
	 * @param node 始点となるNodeインスタンス
	 */
	private void fix(Node node){
		while(node!=null){
			final int lh = node.left==null?0:node.left.height;
			final int rh = node.right==null?0:node.right.height;
			if(lh-rh>1){
				assert node.left!=null;
				if(node.left.right!=null&&node.left.right.height==lh-1){
					rotateL(node.left);
				}
				rotateR(node);
			}
			else if(rh-lh>1){
				assert node.right!=null;
				if(node.right.left!=null&&node.right.left.height==rh-1){
					rotateR(node.right);
				}
				rotateL(node);
			}
			else{
				setStates(node);
			}
			node = node.parent;
		}
	}

	/**
	 * 指定されたNodeインスタンスを基点に右回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateR(final Node node){
		final Node temp = node.left;
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
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスを基点に左回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateL(final Node node){
		final Node temp = node.right;
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
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスの内部情報を更新します。
	 * 
	 * @param node 更新対象のNodeインスタンス
	 */
	private void setStates(final Node node){
		final int lh = node.left!=null?node.left.height:0;
		final int rh = node.right!=null?node.right.height:0;
		node.height = Math.max(lh,rh)+1;
		final int ls = node.left!=null?node.left.size:0;
		final int rs = node.right!=null?node.right.size:0;
		node.size = ls+rs+1;
	}
}

/**
 * Treemultiクラスです。
 * java.util.TreeSetと基本変わりませんが、インデックスを指定してのアクセスがO(log N)で可能です。
 * また、同等な要素を複数追加することができます。
 * 同等な要素は最初に追加した要素と等価として管理するので、
 * 別々に管理したい場合は順序を付けるようにしてください。
 *
 * @param <E> TreeMultiに載せる要素の型
 */
final class TreeMulti<E extends Comparable<E>>{

	/**
	 * このTreeMultiの根となるNodeインスタンスを保持する変数です。
	 */
	private Node root;

	/**
	 * このTreeMultiの要素数を保持する変数です。
	 */
	private long size;

	/**
	 * このTreeMultiのユニークな要素数を保持する変数です。
	 */
	private int uniqueSize;

	/**
	 * このTreeMultiのハッシュ値を保持する変数です。
	 */
	private int hash;

	/**
	 * 空のTreeMultiを生成します。
	 */
	public TreeMulti(){
		size = 0;
		uniqueSize = 0;
		root = null;
		hash = 0;
	}

	/**
	 * 要素を保持するためのNodeクラスです。
	 */
	final private class Node{

		/**
		 * このNodeクラスが保持する要素です。
		 */
		E value;

		/**
		 * 状態管理用の変数です。
		 */
		long count, size;
		int height;

		/**
		 * 親、左右の子を保持する変数です。
		 */
		Node left, right, parent;

		/**
		 * 指定された情報を元にNodeインスタンスを生成します。
		 * 
		 * @param p 親となるNodeインスタンス
		 * @param v 要素
		 * @param c 要素数
		 */
		public Node(final Node p,final E v,final long c){
			value = v;
			parent = p;
			count = c;
			height = 1;
			size = c;
		}
	}

	/**
	 * 指定された要素を追加します。
	 * 
	 * @param x 追加する要素
	 */
	public void add(final E x){
		if(root==null){
			root = new Node(null,x,1);
			++uniqueSize;
		}
		else{
			Node par;
			Node now = root;
			boolean bool = true;
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
					bool = false;
					++now.count;
					break;
				}
			}
			while(now!=null);
			if(bool){
				++uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x,1);
				}
				else{
					par.right = new Node(par,x,1);
				}
			}
			fix(par);
		}
		++size;
		hash ^= x.hashCode();
	}

	/**
	 * 指定された要素を引数の値だけ追加します。
	 * 
	 * @param x 追加する要素
	 * @param sum 追加する個数
	 */
	public void add(final E x,final long sum){
		if(root==null){
			root = new Node(null,x,sum);
			++uniqueSize;
		}
		else{
			Node par;
			Node now = root;
			boolean bool = true;
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
					bool = false;
					now.count += sum;
					fix(now);
					break;
				}
			}
			while(now!=null);
			if(bool){
				++uniqueSize;
				final int result = x.compareTo(par.value);
				if(result<0){
					par.left = new Node(par,x,sum);
				}
				else{
					par.right = new Node(par,x,sum);
				}
				fix(par);
			}
		}
		size += sum;
		hash ^= sum%2==1?x.hashCode():0;
	}

	/**
	 * 指定されたインデックスの要素を取得します。
	 * これはユニークな要素数ではなく全体の要素数でのインデックスです。
	 * 
	 * @param index 取得する要素のインデックス
	 * @return 指定されたインデックスの要素
	 */
	public E get(long index){
		if(root==null||size<=index){
			throw new NullPointerException();
		}
		Node now = root;
		while(true){
			assert now!=null;
			final long ls = now.left!=null?now.left.size:0;
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
		return now.value;
	}

	/**
	 * 指定された要素を一つだけ削除しようと試みます。
	 * 
	 * @param x 削除する要素
	 * @return 指定された要素が一つだけ削除されたらtrue、それ以外はfalse
	 */
	public boolean remove(final E x){
		final Node n = getNode(x);
		if(n==null){
			return false;
		}
		--size;
		hash ^= n.hashCode();
		delete(n);
		return true;
	}

	/**
	 * 指定された要素を指定した個数分削除します。
	 * もし指定された個数だけ存在しない場合は削除できるだけ削除します。
	 * 
	 * @param x 削除する要素
	 * @param sum 削除したい個数
	 * @return 削除に成功した個数
	 */
	public long remove(final E x,final long sum){
		final Node n = getNode(x);
		if(n==null){
			return 0;
		}
		final long ans = Math.min(sum,n.count);
		size -= ans;
		hash ^= ans%2==1?n.hashCode():0;
		n.count -= ans-1;
		delete(n);
		return ans;
	}

	/**
	 * 指定された要素を全て削除します。
	 * 
	 * @param x 削除する要素
	 * @return 削除した個数
	 */
	public long removeAll(final E x){
		final Node n = getNode(x);
		if(n==null){
			return 0;
		}
		size -= n.count;
		final long ans = n.count;
		hash ^= ans%2==1?n.hashCode():0;
		n.count = 0;
		delete(n);
		return ans;
	}

	/**
	 * 指定されたNodeインスタンスを削除します。
	 * 
	 * @param node 削除するNodeインスタンス
	 */
	private void delete(final Node node){
		if(node!=null){
			if(node.count>1){
				--node.count;
				fix(node);
				return;
			}
			if(node.left==null&&node.right==null){
				if(node.parent!=null){
					if(node.parent.left==node){
						node.parent.left = null;
					}
					else{
						node.parent.right = null;
					}
					fix(node.parent);
				}
				else{
					root = null;
				}
				node.parent = null;
				--uniqueSize;
			}
			else{
				if(node.left!=null&&node.right!=null){
					final Node rep = getFirstNode(node.right);
					node.value = rep.value;
					node.count = rep.count;
					rep.count = 0;
					delete(rep);
				}
				else{
					final Node rep = node.left!=null?node.left:node.right;
					rep.parent = node.parent;
					if(node.parent!=null){
						if(node.parent.left==node){
							node.parent.left = rep;
						}
						else{
							node.parent.right = rep;
						}
						fix(node.parent);
					}
					else{
						root = rep;
					}
					node.parent = null;
					--uniqueSize;
				}
			}
		}
	}

	/**
	 * 指定された要素を保持するNodeインスタンスを返します。
	 * そのようなNodeインスタンスが存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象の要素
	 * @return xを保持するNodeインスタンス
	 */
	private Node getNode(final E x){
		Node now = root;
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
	 * このTreeMultiの先頭の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeMultiの先頭の要素
	 */
	public E first(){
		if(root==null){
			return null;
		}
		return getFirstNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の先頭の要素を保持するNodeインスタンスを返します。
	 * このNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return 先頭の要素を保持するNodeインスタンス
	 */
	private Node getFirstNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.left;
		}
		return par;
	}

	/**
	 * このTreeMultiインスタンスの末尾の要素を返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @return このTreeMultiインスタンスの末尾の要素
	 */
	public E last(){
		if(root==null){
			return null;
		}
		return getLastNode(root).value;
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木の末尾の要素を保持するNodeインスタンスを返します。
	 * このNodeインスタンスはnullでないことを要求します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @return 末尾の要素を保持するNodeインスタンス
	 */
	private Node getLastNode(Node node){
		assert node!=null;
		Node par = null;
		while(node!=null){
			par = node;
			node = par.right;
		}
		return par;
	}

	/**
	 * 指定された要素がこのTreeMultiインスタンスに存在するか判定します。
	 * 
	 * @param x 探索対象
	 * @return このTreeMultiインスタンスに指定された要素が存在するならtrue、それ以外はfalse
	 */
	public boolean contains(final E x){
		if(root==null){
			return false;
		}
		return getNode(x)!=null;
	}

	/**
	 * 指定された要素がこのTreeMultiインスタンスにいくつ存在するか返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素がこのTreeMultiインスタンスに存在する個数
	 */
	public long sum(final E x){
		if(root==null){
			return 0;
		}
		Node node = getNode(x);
		return node!=null?node.count:0;
	}

	/**
	 * このTreeMultiインスタンスの先頭の要素を取得し、削除します。
	 * 
	 * @return このTreeMultiインスタンスの先頭の要素
	 */
	public E pollFirst(){
		if(root==null){
			return null;
		}
		--size;
		final Node min = getFirstNode(root);
		hash ^= min.value.hashCode();
		final E ans = min.value;
		delete(min);
		return ans;
	}

	/**
	 * このTreeMultiインスタンスの末尾の要素を取得し、削除します。
	 * 
	 * @return このTreeMultiインスタンスの末尾の要素
	 */
	public E pollLast(){
		if(root==null){
			return null;
		}
		--size;
		final Node max = getLastNode(root);
		hash ^= max.value.hashCode();
		final E ans = max.value;
		delete(max);
		return ans;
	}

	/**
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
	 */
	public E ceiling(final E x){
		return ceiling(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以降の要素で最小のもの
	 */
	private E ceiling(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素以降の要素で最小のもの
	 */
	public E higher(final E x){
		return higher(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素以降の要素で最小のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素以降の要素で最小のもの
	 */
	private E higher(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
	 */
	public E floor(final E x){
		return floor(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素と同等かそれ以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素と同等かそれ以前の要素で最大のもの
	 */
	private E floor(Node node,final E x){
		Node ans = null;
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
	 * 指定された要素以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param x 探索対象
	 * @return 指定された要素以前の要素で最大のもの
	 */
	public E lower(final E x){
		return lower(root,x);
	}

	/**
	 * 指定されたNodeインスタンスを根とする部分木のうち、
	 * 指定された要素以前の要素で最大のものを返します。
	 * もしそのような要素が存在しない場合、nullを返します。
	 * 
	 * @param node 根とするNodeインスタンス
	 * @param x 探索対象
	 * @return 指定された要素以前の要素で最大のもの
	 */
	private E lower(Node node,final E x){
		Node ans = null;
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
	 * このTreeMultiインスタンスのユニークな要素数を返します。
	 * 
	 * @return このTreeMultiインスタンスのユニークな要素数
	 */
	public int size(){
		return uniqueSize;
	}

	/**
	 * このTreeMultiインスタンスの要素数を返します。
	 * 
	 * @return このTreeMultiインスタンスの要素数
	 */
	public long sumSize(){
		return size;
	}

	/**
	 * このTreeMultiインスタンスと同等なArrayListを返します。
	 * このArrayListの要素とTreeMultiインスタンスの要素は連動しています。
	 * 
	 * @return このTreeMultiインスタンスと等価なArrayList
	 */
	public ArrayList<E> toList(){
		final ArrayList<E> list = new ArrayList<>();
		if(root!=null){
			final ArrayDeque<Node> deq = new ArrayDeque<>();
			deq.add(root);
			while(!deq.isEmpty()){
				final Node now = deq.pollLast();
				if(list.size()==0){
					if(now.left!=null){
						deq.add(now);
						deq.add(now.left);
					}
					else{
						for(int i = 0;i<now.count;++i){
							list.add(now.value);
						}
						if(now.right!=null){
							deq.add(now.right);
						}
					}
				}
				else if(now.left!=null&&list.get(list.size()-1).compareTo(now.left.value)<0){
					deq.add(now);
					deq.add(now.left);
				}
				else{
					for(int i = 0;i<now.count;++i){
						list.add(now.value);
					}
					if(now.right!=null){
						deq.add(now.right);
					}
				}
			}
		}
		return list;
	}

	/**
	 * このTreeMultiインスタンスを表すStringを返します。
	 */
	@Override public String toString(){
		final ArrayList<E> list = toList();
		return list.toString();
	}

	/**
	 * このTreeMultiインスタンスと等価か判定します。
	 */
	@Override public boolean equals(final Object o){
		if(o instanceof final TreeMulti<?> tree){
			if(size!=tree.size()){
				return false;
			}
			final ArrayList<E> array1 = toList();
			final ArrayList<?> array2 = tree.toList();
			for(int i = 0;i<size;++i){
				if(!array1.get(i).equals(array2.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * このTreeMultiインスタンスを表すハッシュ値を返します。
	 */
	@Override public int hashCode(){
		return hash;
	}

	/**
	 * 指定されたNodeインスタンスを根の方向に辿りながら平衡を修正します。
	 * 
	 * @param node 始点となるNodeインスタンス
	 */
	private void fix(Node node){
		while(node!=null){
			final int lh = node.left==null?0:node.left.height;
			final int rh = node.right==null?0:node.right.height;
			if(lh-rh>1){
				assert node.left!=null;
				if(node.left.right!=null&&node.left.right.height==lh-1){
					rotateL(node.left);
					setStates(node.left);
				}
				rotateR(node);
			}
			else if(rh-lh>1){
				assert node.right!=null;
				if(node.right.left!=null&&node.right.left.height==rh-1){
					rotateR(node.right);
					setStates(node.right);
				}
				rotateL(node);
			}
			setStates(node);
			node = node.parent;
		}
	}

	/**
	 * 指定されたNodeインスタンスを基点に右回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateR(final Node node){
		final Node temp = node.left;
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
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスを基点に左回転を適用します。
	 * 
	 * @param node 基点となるNodeインスタンス
	 */
	private void rotateL(final Node node){
		final Node temp = node.right;
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
			root = temp;
		}
		node.parent = temp;
		setStates(node);
	}

	/**
	 * 指定されたNodeインスタンスの状態を更新します。
	 * 
	 * @param node 更新対象のNodeインスタンス
	 */
	private void setStates(final Node node){
		final int lh = node.left!=null?node.left.height:0;
		final int rh = node.right!=null?node.right.height:0;
		node.height = Math.max(lh,rh)+1;
		final long ls = node.left!=null?node.left.size:0;
		final long rs = node.right!=null?node.right.size:0;
		node.size = ls+rs+node.count;
	}
}

/**
 * UnionFindクラスです。
 * 連結成分の大きさの他、辺の数、連結成分の数も取得できます。
 */
final class UnionFind{

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
