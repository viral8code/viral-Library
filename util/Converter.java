package util;

public final class Converter {

	/**
	 * 渡された文字列を逆順にした文字列を返します。
	 *
	 * @param str 元の文字列
	 *
	 * @return strを逆順にした文字列
	 */
	public static String reverse ( final String str ) {
		final StringBuilder sb = new StringBuilder();
		for ( int i = str.length() - 1; i >= 0; --i ) {
			sb.append( str.charAt( i ) );
		}
		return sb.toString();
	}
}
