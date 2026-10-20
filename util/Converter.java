package util;

import java.util.Collection;

/**
 * Converter クラスです。
 * Collection をプリミティヴ型の配列に変換するメソッドを提供します。
 */
public final class Converter{

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
		for(final int num:collection){
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
		for(final long num:collection){
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
		for(final char num:collection){
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
		for(final double num:collection){
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
		for(final boolean num:collection){
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
		for(final byte num:collection){
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
		for(final short num:collection){
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
		for(final float num:collection){
			ans[index] = num;
			index += 1;
		}
		return ans;
	}
}
