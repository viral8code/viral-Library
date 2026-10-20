package util;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

/**
 * 二分探索ライブラリです。<br/>
 * 様々な条件での探索を二分探索を用いて実行します。
 */
public final class Searcher{

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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
		double ans = Math.nextDown(left);
		for(int i=0;i<CYCLE_COUNT;++i){
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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
		for(int i=0;i<CYCLE_COUNT;++i){
			final double mid = (left+right)/2;
			final double num = func.applyAsDouble(mid);
			if(num>value){
				right = mid;
			}
			else if(num<value){
				left = mid;
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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
			final int mid = (left&right)+((left^right)>>1);
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
			final long mid = (left&right)+((left^right)>>1);
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
		for(int i=0;i<array.length;++i){
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
		for(int i=0;i<array.length;++i){
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
		for(int i=0;i<array.length;++i){
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
		for(int i=0;i<array.length;++i){
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
		for(int i=0;i<array.length;++i){
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
		for(int i=0;i<list.size();++i){
			final E e = list.get(i);
			if(e.compareTo(value)==0){
				return i;
			}
		}
		return -1;
	}
}
