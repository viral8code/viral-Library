package util;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public final class Searcher {

	private static final int CYCLE_COUNT = Double.MAX_EXPONENT + 53;

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
	public static int downSearch ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int downSearch ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int downSearch ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int downSearch ( final char[] array, final int value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static <E extends Comparable<E>> int downSearch ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c].compareTo( value ) > 0 ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 * @return 指定された要素以下で最大のインデックス
	 */
	public static <E extends Comparable<E>> int downSearch ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( list.get( c ).compareTo( value ) > 0 ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static int downSearch ( int a, int b, final int value, final IntUnaryOperator func ) {
		int ans = a - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsInt( c ) > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static long downSearch ( long a, long b, final long value, final LongUnaryOperator func ) {
		long ans = a - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsLong( c ) > value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 *
	 * @return 指定された値以下で最大の引数
	 */
	public static double search ( double a, double b, final double value, final DoubleUnaryOperator func ) {
		double ans = a - Math.abs( a ), c;
		for ( int $ = 0; $ < CYCLE_COUNT; ++$ ) {
			c = ( a + b ) / 2;
			if ( func.applyAsDouble( c ) > value ) {
				b = c;
			}
			else {
				a = ( ans = c );
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
	public static boolean contains ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	public static boolean contains ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	public static boolean contains ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	public static <E extends Comparable<E>> boolean contains ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int result = array[c].compareTo( value );
			if ( result > 0 ) {
				b = c - 1;
			}
			else if ( result < 0 ) {
				a = c + 1;
			}
			else {
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
	 * @return listにvalueが含まれているかを表すboolean
	 */
	public static <E extends Comparable<E>> boolean contains ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int result = list.get( c ).compareTo( value );
			if ( result > 0 ) {
				b = c - 1;
			}
			else if ( result < 0 ) {
				a = c + 1;
			}
			else {
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
	 *
	 * @return この関数がa以上b以下で探索値を取るかを表すboolean
	 */
	public static boolean contains ( int a, int b, final int value, final IntUnaryOperator func ) {
		int c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int num = func.applyAsInt( c );
			if ( num > value ) {
				b = c - 1;
			}
			else if ( num < value ) {
				a = c + 1;
			}
			else {
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
	 *
	 * @return この関数がa以上b以下で探索値を取るかを表すboolean
	 */
	public static boolean contains ( long a, long b, final long value, final LongUnaryOperator func ) {
		long c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			long num = func.applyAsLong( c );
			if ( num > value ) {
				b = c - 1;
			}
			else if ( num < value ) {
				a = c + 1;
			}
			else {
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
	public static int search ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	public static int search ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	public static int search ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = c - 1;
			}
			else if ( array[c] < value ) {
				a = c + 1;
			}
			else {
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
	 * @return arrayにvalueが含まれているかを表すboolean
	 */
	public static <E extends Comparable<E>> int search ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int result = array[c].compareTo( value );
			if ( result > 0 ) {
				b = c - 1;
			}
			else if ( result < 0 ) {
				a = c + 1;
			}
			else {
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
	 * @return listのvalueのインデックス(無ければ - 1)
	 */
	public static <E extends Comparable<E>> int search ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int result = list.get( c ).compareTo( value );
			if ( result > 0 ) {
				b = c - 1;
			}
			else if ( result < 0 ) {
				a = c + 1;
			}
			else {
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
	 *
	 * @return この関数がvalueを取る引数(無ければa - 1)
	 */
	public static int search ( int a, int b, final int value, final IntUnaryOperator func ) {
		int c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			int num = func.applyAsInt( c );
			if ( num > value ) {
				b = c - 1;
			}
			else if ( num < value ) {
				a = c + 1;
			}
			else {
				return c;
			}
		}
		return a - 1;
	}

	/**
	 * 広義単調増加な関数内の指定された値を探します。
	 *
	 * @param a 探索範囲の下限
	 * @param b 探索範囲の上限
	 * @param value 探索値
	 *
	 * @return この関数がvalueを取る引数(無ければa - 1)
	 */
	public static long search ( long a, long b, final long value, final LongUnaryOperator func ) {
		long c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			long num = func.applyAsLong( c );
			if ( num > value ) {
				b = c - 1;
			}
			else if ( num < value ) {
				a = c + 1;
			}
			else {
				return c;
			}
		}
		return a - 1;
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
	public static int upSearch ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static int upSearch ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static int upSearch ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static <E extends Comparable<E>> int upSearch ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c].compareTo( value ) >= 0 ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 * @return 指定された要素以上で最小のインデックス
	 */
	public static <E extends Comparable<E>> int upSearch ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, ans = list.size(), c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( list.get( c ).compareTo( value ) >= 0 ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static int upSearch ( int a, int b, final int value, final IntUnaryOperator func ) {
		int ans = b + 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsInt( c ) >= value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 *
	 * @return 指定された値以上で最小の引数
	 */
	public static long upSearch ( long a, long b, final long value, final LongUnaryOperator func ) {
		long ans = b + 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsLong( c ) >= value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static int underSearch ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int underSearch ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int underSearch ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] >= value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static <E extends Comparable<E>> int underSearch ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c].compareTo( value ) >= 0 ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 * @return 条件を満たす最大のインデックス
	 */
	public static <E extends Comparable<E>> int underSearch ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, ans = -1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( list.get( c ).compareTo( value ) >= 0 ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static int underSearch ( int a, int b, final int value, final IntUnaryOperator func ) {
		int ans = a - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsInt( c ) >= value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	 *
	 * @return 条件を満たす最大の引数
	 */
	public static long underSearch ( long a, long b, final long value, final LongUnaryOperator func ) {
		long ans = a - 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsLong( c ) >= value ) {
				b = c - 1;
			}
			else {
				a = ( ans = c ) + 1;
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
	public static int overSearch ( final int[] array, final int value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static int overSearch ( final long[] array, final long value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static int overSearch ( final double[] array, final double value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c] > value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	public static <E extends Comparable<E>> int overSearch ( final E[] array, final E value ) {
		int a = 0, b = array.length - 1, ans = array.length, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( array[c].compareTo( value ) > 0 ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 * @return 条件を満たす最小のインデックス
	 */
	public static <E extends Comparable<E>> int overSearch ( final List<E> list, final E value ) {
		int a = 0, b = list.size() - 1, ans = list.size(), c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( list.get( c ).compareTo( value ) > 0 ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static int overSearch ( int a, int b, final int value, final IntUnaryOperator func ) {
		int ans = b + 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsInt( c ) > value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
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
	 *
	 * @return 条件を満たす最小の引数
	 */
	public static long overSearch ( long a, long b, final long value, final LongUnaryOperator func ) {
		long ans = b + 1, c;
		while ( a - b < 1 ) {
			c = ( a + b ) / 2;
			if ( func.applyAsLong( c ) > value ) {
				b = ( ans = c ) - 1;
			}
			else {
				a = c + 1;
			}
		}
		return ans;
	}
}
