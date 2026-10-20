package structure;

import java.util.Random;

/**
 * StaticRollingHash クラスです。<br/>
 * 一応文字列連結メソッドなどを実装していますが、
 * ハッシュ値を再計算するため、高頻度での使用は推奨されません。
 */
public final class StaticRollingHash implements Comparable<StaticRollingHash>{

	/**
	 * 底となる値です。<br/>
	 * 実行時に決まります。
	 */
	private static final long BASE;

	static{
		final Random random = new Random();
		BASE = random.nextInt(1000)+Character.MAX_VALUE+1;
	}

	/**
	 * 剰余計算用の変数です。
	 */
	private static final long MASK30, MASK31, MOD, MASK61;

	/**
	 * 剰余計算用のシフト幅です。
	 */
	private static final int SHIFT_VALUE;

	static{
		SHIFT_VALUE = 31;
		MASK30 = (1L<<30)-1;
		MASK31 = (1L<<SHIFT_VALUE)-1;
		MOD = (1L<<61)-1;
		MASK61 = MOD;
	}

	/**
	 * ハッシュ値記録用の配列です。
	 */
	private final long[] hash;

	/**
	 * この StaticRollingHash インスタンスが表す文字列です。
	 */
	private final String str;

	/**
	 * 引数の文字列を元に StaticRollingHash を構築します。
	 *
	 * @param s 元となる String
	 */
	public StaticRollingHash(final String s){
		this.str = s;
		this.hash = new long[s.length()+1];
		this.roll();
	}

	/**
	 * フィールドの Stringを元にハッシュ値を計算します。
	 */
	private void roll(){
		final int len = this.str.length();
		for(int i=1;i<=len;++i){
			this.hash[i] = multiply(this.hash[i-1],BASE)+this.str.charAt(i-1)+1;
			if(MOD<=this.hash[i]){
				this.hash[i] -= MOD;
			}
		}
	}

	/**
	 * long * long 用の特別メソッドです。
	 *
	 * @param value1 乗算する値
	 * @param value2 乗算される値
	 *
	 * @return value1 * value2 mod 2 ** 61 - 1
	 */
	private static long multiply(final long value1,final long value2){
		final long au = value1>>SHIFT_VALUE;
		final long ad = value1&MASK31;
		final long bu = value2>>SHIFT_VALUE;
		final long bd = value2&MASK31;
		final long mid = ad*bu+au*bd;
		final long midTop = mid>>30;
		final long midBottom = mid&MASK30;
		return mod(au*bu*2+midTop+(midBottom<<SHIFT_VALUE)+ad*bd);
	}

	/**
	 * x mod 2 ** 61 - 1 を計算します。
	 *
	 * @param x 元となる値
	 *
	 * @return x mod 2 ** 61 - 1
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
	 * @param left 左端
	 * @param right 右端
	 *
	 * @return [left,right] のハッシュ値
	 */
	public long getHash(final int left,final int right){
		return (this.hash[right]-multiply(this.hash[left],modBasePow(right-left))+MOD)%MOD;
	}

	/**
	 * BASE ** exp mod 2 ** 61 - 1 を計算します。
	 *
	 * @param exp 指数
	 *
	 * @return BASE ** exp mod 2 ** 61 - 1
	 */
	private static long modBasePow(long exp){
		long ans = 1;
		long a = BASE;
		while(exp>0){
			if((exp&1)==1){
				ans = multiply(ans,a);
			}
			a = multiply(a,a);
			exp >>= 1;
		}
		return ans;
	}

	/**
	 * 指定された区間と引数の指定された区間が等しいか返します。
	 *
	 * @param rh 比較対象の StaticRollingHash
	 * @param l1 この StaticRollingHash の左端
	 * @param r1 この StaticRollingHash の右端
	 * @param l2 比較対象の左端
	 * @param r2 比較対象の右端
	 *
	 * @return 等しい可能性があるなら true、確実に異なるなら false
	 */
	public boolean equals(final StaticRollingHash rh,final int l1,final int r1,final int l2,final int r2){
		if(r1-l1!=r2-l2){
			return false;
		}
		return this.getHash(l1,r1)==rh.getHash(l2,r2);
	}

	/**
	 * この StaticRollingHash の長さを返します。
	 *
	 * @return この StaticRollingHash の長さ
	 */
	public int length(){
		return this.str.length();
	}

	/**
	 * この StaticRollingHash の元となる String のハッシュ値を返します。
	 *
	 * @return この StaticRollingHash の元となる String のハッシュ値
	 */
	@Override
	public int hashCode(){
		return (int)this.hash[this.length()];
	}

	/**
	 * この StaticRollingHash の元となる String を返します。
	 *
	 * @return この StaticRollingHash の元となる String
	 */
	@Override
	public String toString(){
		return this.str;
	}

	/**
	 * 引数と自身が等しいか返します。
	 *
	 * @param obj 比較対象
	 *
	 * @return 等しい可能性があるなら true、確実に異なるなら false
	 */
	@Override
	public boolean equals(final Object obj){
		if(obj instanceof final StaticRollingHash rh){
			return this.equals(rh,0,this.length(),0,rh.length());
		}
		return false;
	}

	/**
	 * 引数の StaticRollingHash の元となる String と辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	@Override
	public int compareTo(final StaticRollingHash rh){
		return this.str.compareTo(rh.toString());
	}

	/**
	 * 引数の String と辞書順で比較します。
	 *
	 * @param s the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareTo(final String s){
		return this.str.compareTo(s);
	}

	/**
	 * この StaticRollingHash の i 文字目を返します。
	 *
	 * @param i インデックス
	 *
	 * @return i 番目の文字を表す char
	 */
	public char charAt(final int i){
		return this.str.charAt(i);
	}

	/**
	 * 引数の StaticRollingHash の元となる String と大文字小文字を無視して辞書順で比較します。
	 *
	 * @param rh the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareToIgnoreCase(final StaticRollingHash rh){
		return this.str.compareToIgnoreCase(rh.toString());
	}

	/**
	 * 引数の String と大文字小文字を無視して辞書順で比較します。
	 *
	 * @param s the object to be compared.
	 *
	 * @return 辞書順で自身が小さいなら -1、等しいなら 0、それ以外は 1
	 */
	public int compareToIgnoreCase(final String s){
		return this.str.compareToIgnoreCase(s);
	}

	/**
	 * 引数の StaticRollingHash を末尾に連結します。<br/>
	 * 計算量は O(length + rh.length) です。
	 *
	 * @param rh 連結する文字列を表す StaticRollingHash
	 *
	 * @return 結合した文字列を表す StaticRollingHash
	 */
	public StaticRollingHash concat(final StaticRollingHash rh){
		return this.concat(rh.toString());
	}

	/**
	 * 引数の String を末尾に連結します。<br/>
	 * 計算量は O(length + s.length) です。
	 *
	 * @param s 連結する文字列
	 *
	 * @return 結合した文字列を表す StaticRollingHash
	 */
	public StaticRollingHash concat(final String s){
		return new StaticRollingHash(this.str+s);
	}

	/**
	 * この StaticRollingHash の連続部分列として引数の StaticRollingHash が存在するか判定します。
	 *
	 * @param rh 連続部分列として存在するか検査する StaticRollingHash
	 *
	 * @return 部分列として存在する可能性があるなら true、確実に含まれていないなら false
	 */
	public boolean contains(final StaticRollingHash rh){
		final long h = rh.getHash(0,rh.length());
		final int len = this.length()-rh.length();
		for(int i=0;i<=len;++i){
			if(h==this.getHash(i,rh.length()+i)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 引数の String が連続部分列として存在するか判定します。
	 *
	 * @param s 存在判定をする String
	 *
	 * @return 連続部分列として存在するなら true、それ以外は false
	 */
	public boolean contains(final String s){
		return this.indexOf(s)!=-1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int indexOf(final int charValue){
		return this.indexOf(charValue,0);
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int indexOf(final int charValue,final int fromIndex){
		if(fromIndex<0){
			return -1;
		}
		final int len = this.length();
		for(int i=fromIndex;i<len;++i){
			if(this.str.charAt(i)==charValue){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字列が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param s 探索する文字列
	 *
	 * @return 最も左側にある引数の文字列のインデックス (無ければ -1)
	 */
	public int indexOf(final String s){
		return this.indexOf(s,0);
	}

	/**
	 * 引数の文字列を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param s 探索する文字列
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も左側にある引数の文字列のインデックス (無ければ -1)
	 */
	public int indexOf(final String s,final int fromIndex){
		if(fromIndex<0){
			return -1;
		}
		long h = 0;
		for(final char c:s.toCharArray()){
			h = multiply(h,BASE)+c+1;
			if(MOD<=h){
				h -= MOD;
			}
		}
		final int len = this.length()-s.length();
		for(int i=fromIndex;i<=len;++i){
			if(h==this.getHash(i,s.length()+i)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * この StaticRollingHash が表す文字列が空文字列か判定します。
	 *
	 * @return ""と等しいなら true、それ以外は false
	 */
	public boolean isEmpty(){
		return this.length()==0;
	}

	/**
	 * 引数の文字を指定されたインデックス以降で探索します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 * @param fromIndex 探索開始位置
	 *
	 * @return 最も右側にある引数の文字のインデックス (無ければ -1)
	 */
	public int lastIndexOf(final int charValue,final int fromIndex){
		if(fromIndex>=this.length()){
			return -1;
		}
		for(int i=fromIndex;i>=0;--i){
			if(this.str.charAt(i)==charValue){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 引数の文字が先頭から何番目に存在するか返します。<br/>
	 * 存在しない場合は -1 を返します。
	 *
	 * @param charValue 探索する文字を表す int
	 *
	 * @return 最も左側にある引数の文字のインデックス (無ければ -1)
	 */
	public int lastIndexOf(final int charValue){
		return this.lastIndexOf(charValue,this.length()-1);
	}

	/**
	 * 引数の boolean を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param boolValue 元となる boolean
	 *
	 * @return 引数の boolean を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final boolean boolValue){
		return new StaticRollingHash(boolValue?"true":"false");
	}

	/**
	 * 引数の char を元に StaticRollingHash を構築します。
	 *
	 * @param c 元となる char
	 *
	 * @return 引数の char を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char c){
		return new StaticRollingHash(""+c);
	}

	/**
	 * 引数の char[] を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param chars 元となる char[]
	 *
	 * @return 引数の char[] を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] chars){
		return new StaticRollingHash(String.valueOf(chars,0,chars.length));
	}

	/**
	 * 引数の char[] を表す文字列の、引数の区間を元に StaticRollingHash を構築します。
	 *
	 * @param chars 元となる char[]
	 * @param offset 左端
	 * @param count 文字数
	 *
	 * @return 引数の char[] の引数の区間を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final char[] chars,final int offset,final int count){
		return new StaticRollingHash(String.valueOf(chars,offset,count));
	}

	/**
	 * 引数の double を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param d 元となる double
	 *
	 * @return 引数の double を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final double d){
		return new StaticRollingHash(String.valueOf(d));
	}

	/**
	 * 引数の float を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param f 元となる float
	 *
	 * @return 引数の float を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final float f){
		return new StaticRollingHash(String.valueOf(f));
	}

	/**
	 * 引数の int を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param i 元となる int
	 *
	 * @return 引数の int を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final int i){
		return new StaticRollingHash(String.valueOf(i));
	}

	/**
	 * 引数の long を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param l 元となる long
	 *
	 * @return 引数の long を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final long l){
		return new StaticRollingHash(String.valueOf(l));
	}

	/**
	 * 引数の Object を表す文字列を元に StaticRollingHash を構築します。
	 *
	 * @param obj 元となる Object
	 *
	 * @return 引数の Object を表す StaticRollingHash
	 */
	public static StaticRollingHash valueOf(final Object obj){
		return new StaticRollingHash(String.valueOf(obj));
	}
}
