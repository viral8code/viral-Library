package util;

import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;
/**
 * ソートに関するメソッドを提供するクラスです。
 * カウントソートや挿入ソート、プリミティヴ型のソートでの比較関数の指定など、
 * Arrays::sortでカバーできない部分を提供します。
 */
public final class Sorter{

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
