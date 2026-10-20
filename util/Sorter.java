package util;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/**
 * ソートに関するメソッドを提供するクラスです。<br/>
 * カウントソートや挿入ソート、プリミティヴ型のソートでの比較関数の指定など、<br/>
 * Arrays::sort でカバーできない部分を提供します。
 */
public final class Sorter{

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
			if(comparator.applyAsInt(array1[i],array2[j])<=0){
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
			if(comparator.applyAsLong(array1[i],array2[j])<=0){
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
			if(comparator.applyAsInt(array1[i],array2[j])<=0){
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
			if(comparator.applyAsDouble(array1[i],array2[j])<=0){
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
		for(int i=left;i<right;++i){
			list[array[i]] += 1;
		}
		int temp = left;
		for(int i=0;i<list.length;++i){
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
	public static void countSort(final char[] array,final int maximumLimit){
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
	public static void countSort(final char[] array,final int left,final int right,final int maximumLimit){
		final int[] list = new int[maximumLimit+1];
		for(int i=left;i<right;++i){
			++list[array[i]];
		}
		int temp = left;
		for(int c=0;c<list.length;++c){
			while(list[c]>0){
				list[c] -= 1;
				array[temp] = (char)c;
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
		for(int i=left+1;i<right;i++){
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
