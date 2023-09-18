package util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import math.MathFunction;

public final class ArrayFunction {

	/**
	 * カウントソートによるソートです。
	 * 各要素が0以上であり最大値が十分小さい時はこちらの使用を推奨します。
	 *
	 * @param array ソート対象のint型配列
	 * @param maximumLimit array内の最大要素
	 */
	public static void countSort ( final int[] array, final int maximumLimit ) {
		final int[] list = new int[maximumLimit + 1];
		for ( final int num: array ) {
			++list[num];
		}
		int temp = 0;
		for ( int i = 0; i < list.length; ++i ) {
			while ( list[i]-- > 0 ) {
				array[temp++] = i;
			}
		}
	}

	/**
	 * 配列を右周りに90度回転させたものを返します。
	 * 長方形でない配列に関しての動作は保証していません。
	 *
	 * @param array 回転させる行列
	 *
	 * @return 回転させた配列
	 */
	public static int[][] rotateR ( final int[][] array ) {
		final int[][] ans = new int[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static long[][] rotateR ( final long[][] array ) {
		final long[][] ans = new long[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static char[][] rotateR ( final char[][] array ) {
		final char[][] ans = new char[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static double[][] rotateR ( final double[][] array ) {
		final double[][] ans = new double[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static boolean[][] rotateR ( final boolean[][] array ) {
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static <E> E[][] rotateR ( final E[][] array, final E[][] ans ) {
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[ans[i].length - j - 1][i];
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
	public static int[][] rotateL ( final int[][] array ) {
		final int[][] ans = new int[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			final int index = i;
			Arrays.setAll( ans[i], k -> array[k][ans.length - index - 1] );
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
	public static long[][] rotateL ( final long[][] array ) {
		final long[][] ans = new long[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			final int index = i;
			Arrays.setAll( ans[i], k -> array[k][ans.length - index - 1] );
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
	public static char[][] rotateL ( final char[][] array ) {
		final char[][] ans = new char[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[j][ans.length - i - 1];
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
	public static double[][] rotateL ( final double[][] array ) {
		final double[][] ans = new double[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[j][ans.length - i - 1];
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
	public static boolean[][] rotateL ( final boolean[][] array ) {
		final boolean[][] ans = new boolean[array[0].length][array.length];
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[j][ans.length - i - 1];
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
	public static <E> E[][] rotateL ( final E[][] array, final E[][] ans ) {
		for ( int i = 0; i < ans.length; ++i ) {
			for ( int j = 0; j < ans[i].length; ++j ) {
				ans[i][j] = array[j][ans.length - i - 1];
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
	public static int lis ( int[] array ) {
		return lis( array, false );
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p](0 < = p < = arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis ( int[][] arrays, int p ) {
		return lis( arrays, p, false );
	}

	/**
	 * 引数の配列の最長狭義増加部分列の長さを返します。
	 *
	 * @param array 最長狭義増加部分列の長さを求める配列
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis ( long[] array ) {
		return lis( array, false );
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 *
	 * @return arrays[i][p](0 < = p < = arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis ( long[][] arrays, int p ) {
		return lis( arrays, p, false );
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis ( int[] array, boolean include ) {
		int[] list = new int[array.length];
		Arrays.fill( list, Integer.MAX_VALUE );
		for ( int num: array ) {
			int index = include ? Searcher.overSearch( list, num ) : Searcher.upSearch( list, num );
			list[index] = Math.min( list[index], num );
		}
		int answer = Searcher.underSearch( list, Integer.MAX_VALUE );
		return answer + 1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return arrays[i][p](0 < = p < = arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis ( int[][] arrays, int p, boolean include ) {
		int[] list = new int[arrays.length];
		Arrays.fill( list, Integer.MAX_VALUE );
		for ( int[] array: arrays ) {
			int index = include ? Searcher.overSearch( list, array[p] ) : Searcher.upSearch( list, array[p] );
			list[index] = Math.min( list[index], array[p] );
		}
		int answer = Searcher.underSearch( list, Integer.MAX_VALUE );
		return answer + 1;
	}

	/**
	 * 引数の配列の最長増加部分列の長さを返します。
	 *
	 * @param array 最長増加部分列の長さを求める配列
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return 最長狭義増加部分列の長さ
	 */
	public static int lis ( long[] array, boolean include ) {
		long[] list = new long[array.length];
		Arrays.fill( list, Long.MAX_VALUE );
		for ( long num: array ) {
			int index = include ? Searcher.overSearch( list, num ) : Searcher.upSearch( list, num );
			list[index] = Math.min( list[index], num );
		}
		int answer = Searcher.underSearch( list, Long.MAX_VALUE );
		return answer + 1;
	}

	/**
	 * 引数の配列指定されたインデックスの最長狭義増加部分列の長さを返します。
	 *
	 * @param arrays 最長狭義増加部分列の長さを求める配列
	 * @param p 探索する配列のインデックス
	 * @param include 広義増加列ならtrue、狭義増加列ならfalse
	 *
	 * @return arrays[i][p](0 < = p < = arrays.length)の最長狭義増加部分列の長さ
	 */
	public static int lis ( long[][] arrays, int p, boolean include ) {
		long[] list = new long[arrays.length];
		Arrays.fill( list, Long.MAX_VALUE );
		for ( long[] array: arrays ) {
			int index = include ? Searcher.overSearch( list, array[p] ) : Searcher.upSearch( list, array[p] );
			list[index] = Math.min( list[index], array[p] );
		}
		int answer = Searcher.underSearch( list, Long.MAX_VALUE );
		return answer + 1;
	}

	/**
	 * 引数の情報から求められる有向辺に対してトポロジカルソートを行ないます。
	 * 戻り値はint型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort ( final ArrayList<ArrayList<Integer>> route ) {
		final int[] count = new int[route.size()];
		int pathCount = 0;
		for ( final ArrayList<Integer> path: route ) {
			for ( final int point: path ) {
				++pathCount;
				++count[point];
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>();
		for ( int i = 1; i < count.length; ++i ) {
			if ( count[i] == 0 ) {
				deq.add( i );
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while ( deq.size() > 0 ) {
			int nowP = deq.pollFirst();
			for ( final int nextP: route.get( nowP ) ) {
				ans[index][0] = nowP;
				ans[index++][1] = nextP;
				if ( --count[nextP] == 0 ) {
					deq.add( nextP );
				}
			}
		}
		return ans;
	}

	/**
	 * 引数の情報から求められる有向辺に対してトポロジカルソートを行ないます。
	 * 戻り値はint型二次元配列です。
	 *
	 * @param route 有向グラフの隣接リスト
	 *
	 * @return トポロジカルソート済み有向グラフ
	 */
	public static int[][] topologicalSort ( final int[][] route ) {
		final int[] count = new int[route.length];
		int pathCount = 0;
		for ( final int[] path: route ) {
			for ( final int point: path ) {
				++pathCount;
				++count[point];
			}
		}
		final ArrayDeque<Integer> deq = new ArrayDeque<>();
		for ( int i = 1; i < count.length; ++i ) {
			if ( count[i] == 0 ) {
				deq.add( i );
			}
		}
		final int[][] ans = new int[pathCount][2];
		int index = 0;
		while ( deq.size() > 0 ) {
			int nowP = deq.pollFirst();
			for ( final int nextP: route[nowP] ) {
				ans[index][0] = nowP;
				ans[index++][1] = nextP;
				if ( --count[nextP] == 0 ) {
					deq.add( nextP );
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
	public static void swap ( final int[] array, final int a, final int b ) {
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
	public static void swap ( final long[] array, final int a, final int b ) {
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
	public static void swap ( final double[] array, final int a, final int b ) {
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
	public static void swap ( final char[] array, final int a, final int b ) {
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
	public static void swap ( final boolean[] array, final int a, final int b ) {
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
	 */
	public static <E> void swap ( final E[] array, final int a, final int b ) {
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
	public static void swap ( final int[][] array, final int a, final int b, final int c, final int d ) {
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
	public static void swap ( final long[][] array, final int a, final int b, final int c, final int d ) {
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
	public static void swap ( final double[][] array, final int a, final int b, final int c, final int d ) {
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
	public static void swap ( final char[][] array, final int a, final int b, final int c, final int d ) {
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
	public static void swap ( final boolean[][] array, final int a, final int b, final int c, final int d ) {
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
	 */
	public static <E> void swap ( final E[][] array, final int a, final int b, final int c, final int d ) {
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
	public static boolean nextPermutation ( final int[] array ) {
		int index1 = 0;
		for ( int i = 1; i < array.length; ++i ) {
			if ( array[i - 1] < array[i] ) {
				index1 = i;
			}
		}
		if ( --index1 < 0 ) {
			return false;
		}
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		for ( int i = index1 + 1; i < array.length; ++i ) {
			if ( MathFunction.rangeCheckOpen( array[i], array[index1], min ) ) {
				min = array[i];
				index2 = i;
			}
		}
		swap( array, index1, index2 );
		Arrays.sort( array, index1 + 1, array.length );
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
	public static boolean nextPermutation ( final long[] array ) {
		int index1 = 0;
		for ( int i = 1; i < array.length; ++i ) {
			if ( array[i - 1] < array[i] ) {
				index1 = i;
			}
		}
		if ( --index1 < 0 ) {
			return false;
		}
		int index2 = 0;
		long min = Long.MAX_VALUE;
		for ( int i = index1 + 1; i < array.length; ++i ) {
			if ( MathFunction.rangeCheckOpen( array[i], array[index1], min ) ) {
				min = array[i];
				index2 = i;
			}
		}
		swap( array, index1, index2 );
		Arrays.sort( array, index1 + 1, array.length );
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
	public static boolean nextPermutation ( final char[] array ) {
		int index1 = 0;
		for ( int i = 1; i < array.length; ++i ) {
			if ( array[i - 1] < array[i] ) {
				index1 = i;
			}
		}
		if ( --index1 < 0 ) {
			return false;
		}
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		for ( int i = index1 + 1; i < array.length; ++i ) {
			if ( MathFunction.rangeCheckOpen( array[i], array[index1], min ) ) {
				min = array[i];
				index2 = i;
			}
		}
		swap( array, index1, index2 );
		Arrays.sort( array, index1 + 1, array.length );
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
	public static <E extends Comparable<E>> boolean nextPermutation ( final E[] array ) {
		int index1 = 0;
		for ( int i = 1; i < array.length; ++i ) {
			if ( array[i - 1].compareTo( array[i] ) < 0 ) {
				index1 = i;
			}
		}
		if ( --index1 < 0 ) {
			return false;
		}
		int index2 = -1;
		E min = MathFunction.max( array );
		int subIndex = -1;
		E max = array[index1];
		for ( int i = index1 + 1; i < array.length; ++i ) {
			if ( MathFunction.rangeCheckOpen( array[i], array[index1], min ) ) {
				min = array[i];
				index2 = i;
			}
			if ( max.compareTo( array[i] ) < 0 ) {
				subIndex = i;
				max = array[i];
			}
		}
		if ( index2 == -1 ) {
			swap( array, index1, subIndex );
		}
		else {
			swap( array, index1, index2 );
		}
		Arrays.sort( array, index1 + 1, array.length );
		return true;
	}
}
