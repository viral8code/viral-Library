package util;

import java.util.Collection;

/**
 * Converterクラスです。
 * Stringを反転したりCollectionをプリミティヴ型の配列に変換するメソッドを提供します。
 */
public final class Converter{
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
