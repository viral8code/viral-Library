package io;

import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import math.MathFunction;

/**
 * SimpleWriter クラスです。<br/>
 * そこそこ速い出力を提供します。
 */
public final class SimpleWriter implements Flushable, AutoCloseable{

	/**
	 * この SimpleWriter のオートフラッシュが有効か保持する変数です。
	 */
	private final boolean _autoFlush;

	/**
	 * この SimpleWriter の SimpleOutputStream です。
	 */
	private SimpleOutputStream simpleOutputStream;

	/**
	 * 改行文字列を表す char[] です。
	 */
	private static final char[] charsOfReturn;

	/**
	 * 整数処理用のバッファーです。
	 */
	private static final byte[] integerBuffer;

	/**
	 * Long.MIN_VALUE 用の配列です。
	 */
	private static final byte[] MIN_VALUE_ARRAY;

	/**
	 * '0' を表す byte です。
	 */
	private static final byte ZERO;

	/**
	 * デフォルトのバッファサイズです。
	 */
	private static final int DEFAULT_SIZE;

	static{
		final String s = System.lineSeparator();
		charsOfReturn = s.toCharArray();
		integerBuffer = new byte[20];
		integerBuffer[0] = '-';
		ZERO = '0';
		MIN_VALUE_ARRAY = new byte[]{'-','9','2','2','3','3','7','2','0','3','6','8','5','4','7','7','5','8','0','8'};
		DEFAULT_SIZE = 1<<17;
	}

	/**
	 * 指定された OutputStream を元に SimpleWriter を生成します。<br/>
	 * オートフラッシュは無効です。
	 *
	 * @param out SimpleWriter に保持させる OutputStream
	 */
	public SimpleWriter(final OutputStream out){
		this(out,false);
	}

	/**
	 * 指定された OutputStream とフラグを元に SimpleWriter を生成します。
	 *
	 * @param out SimpleWriter に保持させる OutputStream
	 * @param autoFlush オートフラッシュの有効無効を表す boolean
	 */
	public SimpleWriter(final OutputStream out,final boolean autoFlush){
		this.simpleOutputStream = new SimpleOutputStream(out,DEFAULT_SIZE);
		this._autoFlush = autoFlush;
	}

	/**
	 * バッファーにあるものを出力します。
	 */
	public void flush(){
		try{
			this.simpleOutputStream.flush();
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * この SimpleWriter の SimpleOutputStream を閉じます。
	 */
	public void close(){
		try{
			if(this.simpleOutputStream==null){
				return;
			}
			this.simpleOutputStream.close();
			this.simpleOutputStream = null;
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 引数の値を書き込みます。
	 *
	 * @param i 文字コード
	 */
	public void write(final int i){
		try{
			this.simpleOutputStream.write(i);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された区間の char を書き込みます。
	 *
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final char[] buf,final int off,final int len){
		try{
			this.simpleOutputStream.write(buf,off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された区間の byte を書き込みます。
	 *
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final byte[] buf,final int off,final int len){
		try{
			this.simpleOutputStream.write(buf,off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された char[] を書き込みます。
	 *
	 * @param buf 書き込みたい char[]
	 */
	public void write(final char[] buf){
		this.write(buf,0,buf.length);
	}

	/**
	 * 指定された byte[] を書き込みます。
	 *
	 * @param buf 書き込みたい byte[]
	 */
	public void write(final byte[] buf){
		this.write(buf,0,buf.length);
	}

	/**
	 * 指定された区間の文字列を書き込みます。
	 *
	 * @param s 書き込み元
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final String s,final int off,final int len){
		try{
			this.simpleOutputStream.write(s.toCharArray(),off,len);
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 指定された文字列を書き込みます。
	 *
	 * @param s 書き込みたい文字列
	 */
	public void write(final String s){
		this.write(s.toCharArray(),0,s.length());
	}

	/**
	 * 改行を書き込みます。
	 */
	private void newLine(){
		try{
			this.simpleOutputStream.write(charsOfReturn,0,charsOfReturn.length);
			if(this._autoFlush){
				this.simpleOutputStream.flush();
			}
		}
		catch(final Exception x){
			x.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * 引数の boolean を表す文字列を改行無しで出力します。
	 *
	 * @param value 出力したい boolean
	 */
	public void print(final boolean value){
		this.write(value?"true":"false");
	}

	/**
	 * 引数の char を改行無しで出力します。
	 *
	 * @param c 出力したい char
	 */
	public void print(final char c){
		this.write(c);
	}

	/**
	 * 引数の long を改行無しで出力します。
	 *
	 * @param l 出力したい long
	 */
	public void print(final long l){
		if(l==Long.MIN_VALUE){
			this.write(MIN_VALUE_ARRAY);
		}
		else{
			long num = Math.abs(l);
			final int len = MathFunction.digit(num);
			for(int i=len;i>0;i--){
				integerBuffer[i] = (byte)(num%10+ZERO);
				num /= 10;
			}
			if(l<0){
				this.write(integerBuffer,0,len+1);
			}
			else{
				this.write(integerBuffer,1,len);
			}
		}
	}

	/**
	 * 引数の float を改行無しで出力します。
	 *
	 * @param f 出力したい float
	 */
	public void print(final float f){
		this.write(String.valueOf(f).toCharArray());
	}

	/**
	 * 引数の double を改行無しで出力します。
	 *
	 * @param d 出力したい double
	 */
	public void print(final double d){
		this.write(String.valueOf(d).toCharArray());
	}

	/**
	 * 引数の char[] を改行無しで出力します。
	 *
	 * @param cs 出力したい char[]
	 */
	public void print(final char[] cs){
		this.write(cs);
	}

	/**
	 * 引数の Object を改行無しで出力します。
	 * このメソッドは print(obj.toString().toCharArray()) と等価です。
	 *
	 * @param obj 出力したい Object
	 */
	public void print(final Object obj){
		final String s = String.valueOf(obj);
		this.write(s.toCharArray());
	}

	/**
	 * 改行を出力します。
	 */
	public void println(){
		this.newLine();
	}

	/**
	 * 引数の boolean を表す文字列を改行ありで出力します。
	 *
	 * @param x 出力したい boolean
	 */
	public void println(final boolean x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の char を改行ありで出力します。
	 *
	 * @param x 出力したい char
	 */
	public void println(final char x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の int を改行ありで出力します。
	 *
	 * @param x 出力したい int
	 */
	public void println(final int x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の long を改行ありで出力します。
	 *
	 * @param x 出力したい long
	 */
	public void println(final long x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の float を改行ありで出力します。
	 *
	 * @param x 出力したい float
	 */
	public void println(final float x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の double を改行ありで出力します。
	 *
	 * @param x 出力したい double
	 */
	public void println(final double x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の char[] を改行ありで出力します。
	 *
	 * @param x 出力したい char[]
	 */
	public void println(final char[] x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の String を改行ありで出力します。
	 *
	 * @param x 出力したい String
	 */
	public void println(final String x){
		this.print(x);
		this.println();
	}

	/**
	 * 引数の Object を改行ありで出力します。
	 *
	 * @param x 出力したい Object
	 */
	public void println(final Object x){
		this.print(x);
		this.println();
	}

	/**
	 * 指定されたフォーマットで引数を出力します。
	 *
	 * @param format フォーマット
	 * @param args 出力したい引数
	 */
	public void printf(final String format,final Object... args){
		this.print(String.format(format,args));
	}

	/**
	 * 指定された CharSequence を SimpleOutputStream に追加します。
	 *
	 * @param csq 追加したい CharSequence
	 */
	public void append(final CharSequence csq){
		this.write(String.valueOf(csq).toCharArray());
	}

	/**
	 * 指定された CharSequence の区間を SimpleOutputStream に追加します。
	 *
	 * @param csq 追加したい CharSequence
	 * @param start 開始地点 (start を含む)
	 * @param end 終了地点 (end を含まない)
	 */
	public void append(CharSequence csq,final int start,final int end){
		if(csq==null){
			csq = "null";
		}
		this.append(csq.subSequence(start,end));
	}

	/**
	 * 指定された char を SimpleOutputStream に追加します。
	 *
	 * @param c 追加したい char
	 */
	public void append(final char c){
		this.write(c);
	}

	/**
	 * int[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 */
	public void print(final int[] array){
		this.print(array,' ');
	}

	/**
	 * int[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param str 区切り文字
	 */
	public void print(final int[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * int[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param c 区切り文字
	 */
	public void print(final int[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * int[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 */
	public void print(final int[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * int[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param str 区切り文字
	 */
	public void print(final int[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * int[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param c 区切り文字
	 */
	public void print(final int[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * int[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 */
	public void println(final int[] array){
		this.print(array,' ');
		this.println();
	}

	/**
	 * int[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param str 区切り文字
	 */
	public void println(final int[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * int[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい int[]
	 * @param c 区切り文字
	 */
	public void println(final int[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * int[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param array 出力したい int[][]
	 */
	public void println(final int[][] array){
		this.print(array,' ');
		this.println();
	}

	/**
	 * int[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param str 区切り文字
	 */
	public void println(final int[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * int[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい int[][]
	 * @param c 区切り文字
	 */
	public void println(final int[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * long[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 */
	public void print(final long[] array){
		this.print(array,' ');
	}

	/**
	 * long[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param str 区切り文字
	 */
	public void print(final long[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * long[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param c 区切り文字
	 */
	public void print(final long[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * long[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 */
	public void print(final long[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * long[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param str 区切り文字
	 */
	public void print(final long[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * long[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param c 区切り文字
	 */
	public void print(final long[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * long[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 */
	public void println(final long[] array){
		this.println(array,' ');
	}

	/**
	 * long[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param str 区切り文字
	 */
	public void println(final long[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * long[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい long[]
	 * @param c 区切り文字
	 */
	public void println(final long[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * long[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 */
	public void println(final long[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * long[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param str 区切り文字
	 */
	public void println(final long[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * long[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい long[][]
	 * @param c 区切り文字
	 */
	public void println(final long[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * double[] を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 */
	public void print(final double[] array){
		this.print(array,' ');
	}

	/**
	 * double[] を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param str 区切り文字
	 */
	public void print(final double[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * double[] を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param c 区切り文字
	 */
	public void print(final double[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * double[][] を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 */
	public void print(final double[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * double[][] を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param str 区切り文字
	 */
	public void print(final double[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * double[][] を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param c 区切り文字
	 */
	public void print(final double[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * double[] を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 */
	public void println(final double[] array){
		this.println(array,' ');
	}

	/**
	 * double[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param str 区切り文字
	 */
	public void println(final double[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * double[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい double[]
	 * @param c 区切り文字
	 */
	public void println(final double[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * double[][] を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 */
	public void println(final double[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * double[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param str 区切り文字
	 */
	public void println(final double[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * double[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい double[][]
	 * @param c 区切り文字
	 */
	public void println(final double[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * char[] を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param cs 出力したい char[]
	 * @param str 区切り文字
	 */
	public void println(final char[] cs,final String str){
		if(cs.length!=0){
			this.print(cs[0]);
			for(int i=1;i<cs.length;++i){
				this.print(str);
				this.print(cs[i]);
			}
		}
		this.println();
	}

	/**
	 * char[] を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param cs 出力したい char[]
	 * @param c 区切り文字
	 */
	public void println(final char[] cs,final char c){
		if(cs.length!=0){
			this.print(cs[0]);
			for(int i=1;i<cs.length;++i){
				this.print(c);
				this.print(cs[i]);
			}
		}
		this.println();
	}

	/**
	 * char[][] を改行区切りで、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 */
	public void println(final char[][] cs){
		for(final char[] chars:cs){
			this.println(chars);
		}
	}

	/**
	 * char[][] を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 * @param str 区切り文字
	 */
	public void println(final char[][] cs,final String str){
		for(final char[] chars:cs){
			this.println(chars,str);
		}
	}

	/**
	 * char[][] を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param cs 出力したい char[][]
	 * @param c 区切り文字
	 */
	public void println(final char[][] cs,final char c){
		for(final char[] chars:cs){
			this.println(chars,c);
		}
	}

	/**
	 * 配列を空白区切りで改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array){
		this.print(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final String str){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(str);
			this.print(array[i]);
		}
	}

	/**
	 * 配列を指定された文字を区切り文字として改行無しで出力します。
	 *
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final char c){
		if(array.length==0){
			return;
		}
		this.print(array[0]);
		for(int i=1;i<array.length;++i){
			this.print(c);
			this.print(array[i]);
		}
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays){
		this.print(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final String str){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],str);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],str);
		}
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final char c){
		if(arrays.length==0){
			return;
		}
		this.print(arrays[0],c);
		for(int i=1;i<arrays.length;++i){
			this.println();
			this.print(arrays[i],c);
		}
	}

	/**
	 * 配列を空白区切りで改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array){
		this.println(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final String str){
		this.print(array,str);
		this.println();
	}

	/**
	 * 配列を指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final char c){
		this.print(array,c);
		this.println();
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays){
		this.println(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final String str){
		this.print(arrays,str);
		this.println();
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 *
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final char c){
		this.print(arrays,c);
		this.println();
	}

	/**
	 * リストを空白区切りで改行無しで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list){
		this.println(list,' ');
	}

	/**
	 * リストを指定された文字列を区切り文字として改行ありで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param str 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final String str){
		if(!list.isEmpty()){
			this.print(list.getFirst());
			for(int i=1;i<list.size();++i){
				this.print(str);
				this.print(list.get(i));
			}
		}
		this.println();
	}

	/**
	 * リストを指定された文字を区切り文字として改行ありで出力します。
	 *
	 * @param list 出力したいリスト
	 * @param c 区切り文字
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final char c){
		if(!list.isEmpty()){
			this.print(list.getFirst());
			for(int i=1;i<list.size();++i){
				this.print(c);
				this.print(list.get(i));
			}
		}
		this.println();
	}

	/**
	 * この SimpleWriter を表す文字列を返します。
	 *
	 * @return この SimpleWriter を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "SimpleWriter["+this.hashCode()+"]";
	}

	/**
	 * SimpleWriter クラス用の SimpleOutputStream クラスです。<br/>
	 * ちょっとだけ速いです。
	 */
	public static final class SimpleOutputStream{

		/**
		 * この SimpleOutputStream のバッファーです。
		 */
		private final byte[] buf;

		/**
		 * この SimpleOutputStream のバッファーにある文字数を管理する変数です。
		 */
		private int count;

		/**
		 * この SimpleOutputStream の元となる OutputStream です。
		 */
		private OutputStream outputStream;

		/**
		 * 指定された OutputStream とバッファーサイズを元に SimpleOutputStream を生成します。
		 *
		 * @param out SimpleOutputStream の元となる OutputStream
		 * @param size バッファーサイズ
		 */
		public SimpleOutputStream(final OutputStream out,final int size){
			this.count = 0;
			this.outputStream = out;
			if(size<=0){
				throw new IllegalArgumentException("Buffer size <= 0");
			}
			this.buf = new byte[size];
		}

		/**
		 * バッファリングしている文字を OutputStream に書き込みます。
		 *
		 * @throws IOException OutputStream::write 由来の Exception
		 */
		private void flushBuffer() throws IOException{
			if(this.count>0){
				this.outputStream.write(this.buf,0,this.count);
				this.count = 0;
			}
		}

		/**
		 * 引数の値をバッファリングします。
		 *
		 * @param i バッファリング対象
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final int i) throws IOException{
			if(this.count>=this.buf.length){
				this.flushBuffer();
			}
			this.buf[this.count] = (byte)i;
			this.count += 1;
		}

		/**
		 * 引数の char[] の指定された文字数分をバッファリングします。
		 *
		 * @param chars 元となる char[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final char[] chars,final int off,final int len) throws IOException{
			if(len>=this.buf.length){
				this.flushBuffer();
				this.outputStream.write(parseByteArray(chars,off,len),0,len);
				return;
			}
			if(len>this.buf.length-this.count){
				this.flushBuffer();
			}
			for(int i=0;i<len;i++){
				this.buf[this.count+i] = (byte)chars[i+off];
			}
			this.count += len;
		}

		/**
		 * 指定された char[] の区間を byte[] に変換します。
		 *
		 * @param chars 元となる char[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @return 変換後の byte[]
		 */
		private static byte[] parseByteArray(final char[] chars,final int off,final int len){
			final byte[] ans = new byte[len];
			for(int i=0;i<len;i++){
				ans[i] = (byte)chars[i+off];
			}
			return ans;
		}

		/**
		 * 指定された byte[] の要素分バッファリングします。
		 *
		 * @param bytes 元となる byte[]
		 * @param off 開始地点
		 * @param len 要素数
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void write(final byte[] bytes,final int off,final int len) throws IOException{
			if(len>=this.buf.length){
				this.flushBuffer();
				this.outputStream.write(bytes,off,len);
				return;
			}
			if(len>this.buf.length-this.count){
				this.flushBuffer();
			}
			System.arraycopy(bytes,off,this.buf,this.count,len);
			this.count += len;
		}

		/**
		 * バッファリングしている文字を書き込み、OutputStream をフラッシュします。
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void flush() throws IOException{
			this.flushBuffer();
			this.outputStream.flush();
		}

		/**
		 * この SimpleOutputStream の元となる OutputStream を閉じます。
		 *
		 * @throws IOException フラッシュが必要な時に OutputStream 側で例外が生じた場合
		 */
		public void close() throws IOException{
			this.flush();
			this.outputStream.close();
			this.outputStream = null;
		}

		/**
		 * この SimpleOutputStream を表す文字列を返します。
		 *
		 * @return この SimpleOutputStream を表す文字列
		 */
		@Override
		@Deprecated
		public String toString(){
			return "SimpleOutputStream["+this.hashCode()+"]";
		}
	}
}
