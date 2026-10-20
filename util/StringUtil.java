package util;

/**
 * StringUtil クラスです。<br/>
 * String に対するメソッドを提供します。
 */
public final class StringUtil{

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
		for(int i=str.length()-1;i>=0;--i){
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
