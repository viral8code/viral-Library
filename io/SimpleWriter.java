package io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * SimpleWriterクラスです。
 * そこそこ速い出力を提供します。
 */
public final class SimpleWriter implements Closeable, Flushable, AutoCloseable{

	/**
	 * このSimpleWriterのオートフラッシュが有効か保持する変数です。
	 */
	private final boolean autoFlush;

	/**
	 * このSimpleWriterのSimpleOutputStreamです。
	 */
	private SimpleOutputStream out;

	/**
	 * 改行文字列を表すchar[]です。
	 */
	private static final char[] charsOfReturn;

	/**
	 * 整数処理用のバッファーです。
	 */
	private static final byte[] integerBuffer;

	/**
	 * Long.MIN_VALUE用の配列です。
	 */
	private static final byte[] MIN_VALUE_ARRAY;

	/**
	 * '0'を表すbyteです。
	 */
	private static final byte ZERO;

	static{
		charsOfReturn = System.lineSeparator().toCharArray();
		integerBuffer = new byte[20];
		integerBuffer[0] = '-';
		ZERO = '0';
		MIN_VALUE_ARRAY = new byte[]{'-','9','2','2','3','3','7','2','0','3','6','8','5','4','7','7','5','8','0','8'};
	}

	/**
	 * 指定されたOutputStreamを元にSimpleWriterを生成します。
	 * オートフラッシュは無効です。
	 * 
	 * @param out SimpleWriterに保持させるOutputStream
	 */
	public SimpleWriter(final OutputStream out){
		this(out,false);
	}

	/**
	 * 指定されたOutputStreamとフラグを元にSimpleWriterを生成します。
	 * @param out SimpleWriterに保持させるOutputStream
	 * @param autoFlush オートフラッシュの有効無効を表すboolean
	 */
	public SimpleWriter(final OutputStream out,final boolean autoFlush){
		this.out = new SimpleOutputStream(out,1<<17);
		this.autoFlush = autoFlush;
	}

	/**
	 * バッファーにあるものを出力します。
	 */
	public void flush(){
		try{
			out.flush();
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * このSimpleWriterのSimpleOutputStreamを閉じます。
	 */
	public void close(){
		try{
			if(out==null){
				return;
			}
			out.close();
			out = null;
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 引数の値を書き込みます。
	 * 
	 * @param c 文字コード
	 */
	public void write(final int c){
		try{
			out.write(c);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された区間のcharを書き込みます。
	 * 
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final char[] buf,final int off,final int len){
		try{
			out.write(buf,off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された区間のbyteを書き込みます。
	 * 
	 * @param buf 書き込み元のバッファー
	 * @param off 書き込み開始地点
	 * @param len 書き込む文字数
	 */
	public void write(final byte[] buf,final int off,final int len){
		try{
			out.write(buf,off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定されたchar[]を書き込みます。
	 * 
	 * @param buf 書き込みたいchar[]
	 */
	public void write(final char[] buf){
		write(buf,0,buf.length);
	}

	/**
	 * 指定されたbyte[]を書き込みます。
	 * 
	 * @param buf 書き込みたいbyte[]
	 */
	public void write(final byte[] buf){
		write(buf,0,buf.length);
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
			out.write(s.toCharArray(),off,len);
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 指定された文字列を書き込みます。
	 * 
	 * @param s 書き込みたい文字列
	 */
	public void write(final String s){
		write(s.toCharArray(),0,s.length());
	}

	/**
	 * 改行を書き込みます。
	 */
	private void newLine(){
		try{
			out.write(charsOfReturn,0,charsOfReturn.length);
			if(autoFlush){
				out.flush();
			}
		}catch(final Exception x){
			x.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * 引数のbooleanを表す文字列を改行無しで出力します。
	 * 
	 * @param b 出力したいboolean
	 */
	public void print(final boolean b){
		write(b?"true":"false");
	}

	/**
	 * 引数のcharを改行無しで出力します。
	 * 
	 * @param c 出力したいchar
	 */
	public void print(final char c){
		write(c);
	}

	/**
	 * 引数のlongを改行無しで出力します。
	 * 
	 * @param l 出力したいlong
	 */
	public void print(final long l){
		if(l==Long.MIN_VALUE){
			write(MIN_VALUE_ARRAY);
		}
		else{
			long num = Math.abs(l);
			int len = MathFunction.digit(num);
			for(int i=len;i>0;i--){
				integerBuffer[i] = (byte)(num%10+ZERO);
				num /= 10;
			}
			if(l<0)
				write(integerBuffer,0,len+1);
			else
				write(integerBuffer,1,len);
		}
	}

	/**
	 * 引数のfloatを改行無しで出力します。
	 * 
	 * @param f 出力したいfloat
	 */
	public void print(final float f){
		write(String.valueOf(f).toCharArray());
	}

	/**
	 * 引数のdoubleを改行無しで出力します。
	 * 
	 * @param d 出力したいdouble
	 */
	public void print(final double d){
		write(String.valueOf(d).toCharArray());
	}

	/**
	 * 引数のchar[]を改行無しで出力します。
	 * 
	 * @param s 出力したいchar[]
	 */
	public void print(final char[] s){
		write(s);
	}

	/**
	 * 引数のObjectを改行無しで出力します。
	 * このメソッドはprint(obj.toString().toCharArray())と等価です。
	 * 
	 * @param obj 出力したいObject
	 */
	public void print(final Object obj){
		write(obj.toString().toCharArray());
	}

	/**
	 * 改行を出力します。
	 */
	public void println(){
		newLine();
	}

	/**
	 * 引数のbooleanを表す文字列を改行ありで出力します。
	 * 
	 * @param x 出力したいboolean
	 */
	public void println(final boolean x){
		print(x);
		println();
	}

	/**
	 * 引数のcharを改行ありで出力します。
	 * 
	 * @param x 出力したいchar
	 */
	public void println(final char x){
		print(x);
		println();
	}

	/**
	 * 引数のintを改行ありで出力します。
	 * 
	 * @param x 出力したいint
	 */
	public void println(final int x){
		print(x);
		println();
	}

	/**
	 * 引数のlongを改行ありで出力します。
	 * 
	 * @param x 出力したいlong
	 */
	public void println(final long x){
		print(x);
		println();
	}

	/**
	 * 引数のfloatを改行ありで出力します。
	 * 
	 * @param x 出力したいfloat
	 */
	public void println(final float x){
		print(x);
		println();
	}

	/**
	 * 引数のdoubleを改行ありで出力します。
	 * 
	 * @param x 出力したいdouble
	 */
	public void println(final double x){
		print(x);
		println();
	}

	/**
	 * 引数のchar[]を改行ありで出力します。
	 * 
	 * @param x 出力したいchar[]
	 */
	public void println(final char[] x){
		print(x);
		println();
	}

	/**
	 * 引数のStringを改行ありで出力します。
	 * 
	 * @param x 出力したいString
	 */
	public void println(final String x){
		print(x);
		println();
	}

	/**
	 * 引数のObjectを改行ありで出力します。
	 * 
	 * @param x 出力したいObject
	 */
	public void println(final Object x){
		print(x);
		println();
	}

	/**
	 * 指定されたフォーマットで引数を出力します。
	 * 
	 * @param format フォーマット
	 * @param args 出力したい引数
	 * @return このSimpleWriter
	 */
	public SimpleWriter printf(final String format,final Object... args){
		print(String.format(format,args));
		return this;
	}

	/**
	 * 指定されたCharSequenceをSimpleOutputStreamに追加します。
	 * 
	 * @param csq 追加したいCharSequence
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(final CharSequence csq){
		write(String.valueOf(csq).toCharArray());
		return this;
	}

	/**
	 * 指定されたCharSequenceの区間をSimpleOutputStreamに追加します。
	 * 
	 * @param csq 追加したいCharSequence
	 * @param start 開始地点(startを含む)
	 * @param end 終了地点(endを含まない)
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(CharSequence csq,final int start,final int end){
		if(csq==null){
			csq = "null";
		}
		return append(csq.subSequence(start,end));
	}

	/**
	 * 指定されたcharをSimpleOutputStreamに追加します。
	 * 
	 * @param c 追加したいchar
	 * @return このSimpleWriter
	 */
	public SimpleWriter append(final char c){
		write(c);
		return this;
	}

	/**
	 * int[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 */
	public void print(final int[] array){
		print(array,' ');
	}

	/**
	 * int[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param str 区切り文字
	 */
	public void print(final int[] array,final String str){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * int[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param c 区切り文字
	 */
	public void print(final int[] array,final char c){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * int[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいint[][]
	 */
	public void print(final int[][] array){
		print(array,' ');
	}

	/**
	 * int[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param str 区切り文字
	 */
	public void print(final int[][] arrays,final String str){
		if(arrays.length==0)
			return;
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * int[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param c 区切り文字
	 */
	public void print(final int[][] arrays,final char c){
		if(arrays.length==0)
			return;
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * int[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 */
	public void println(final int[] array){
		print(array,' ');
		println();
	}

	/**
	 * int[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param str 区切り文字
	 */
	public void println(final int[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * int[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいint[]
	 * @param c 区切り文字
	 */
	public void println(final int[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * int[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいint[][]
	 */
	public void println(final int[][] array){
		print(array,' ');
		println();
	}

	/**
	 * int[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param str 区切り文字
	 */
	public void println(final int[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * int[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいint[][]
	 * @param c 区切り文字
	 */
	public void println(final int[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * long[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 */
	public void print(final long[] array){
		print(array,' ');
	}

	/**
	 * long[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param str 区切り文字
	 */
	public void print(final long[] array,final String str){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * long[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param c 区切り文字
	 */
	public void print(final long[] array,final char c){
		if(array.length==0)
			return;
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * long[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいlong[][]
	 */
	public void print(final long[][] array){
		print(array,' ');
	}

	/**
	 * long[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param str 区切り文字
	 */
	public void print(final long[][] arrays,final String str){
		if(arrays.length==0)
			return;
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * long[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param c 区切り文字
	 */
	public void print(final long[][] arrays,final char c){
		if(arrays.length==0)
			return;
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * long[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 */
	public void println(final long[] array){
		println(array,' ');
	}

	/**
	 * long[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param str 区切り文字
	 */
	public void println(final long[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * long[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいlong[]
	 * @param c 区切り文字
	 */
	public void println(final long[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * long[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいlong[][]
	 */
	public void println(final long[][] array){
		println(array,' ');
	}

	/**
	 * long[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param str 区切り文字
	 */
	public void println(final long[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * long[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいlong[][]
	 * @param c 区切り文字
	 */
	public void println(final long[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * double[]を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 */
	public void print(final double[] array){
		print(array,' ');
	}

	/**
	 * double[]を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param str 区切り文字
	 */
	public void print(final double[] array,final String str){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * double[]を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param c 区切り文字
	 */
	public void print(final double[] array,final char c){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * double[][]を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param array 出力したいdouble[][]
	 */
	public void print(final double[][] array){
		print(array,' ');
	}

	/**
	 * double[][]を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param str 区切り文字
	 */
	public void print(final double[][] arrays,final String str){
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * double[][]を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param c 区切り文字
	 */
	public void print(final double[][] arrays,final char c){
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * double[]を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 */
	public void println(final double[] array){
		println(array,' ');
	}

	/**
	 * double[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param str 区切り文字
	 */
	public void println(final double[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * double[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したいdouble[]
	 * @param c 区切り文字
	 */
	public void println(final double[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * double[][]を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param array 出力したいdouble[][]
	 */
	public void println(final double[][] array){
		println(array,' ');
	}

	/**
	 * double[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param str 区切り文字
	 */
	public void println(final double[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * double[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したいdouble[][]
	 * @param c 区切り文字
	 */
	public void println(final double[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * char[]を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param cs 出力したいchar[]
	 * @param str 区切り文字
	 */
	public void println(final char[] cs,final String str){
		print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			print(str);
			print(cs[i]);
		}
		println();
	}

	/**
	 * char[]を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param cs 出力したいchar[]
	 * @param c 区切り文字
	 */
	public void println(final char[] cs,final char c){
		print(cs[0]);
		for(int i = 1;i<cs.length;++i){
			print(c);
			print(cs[i]);
		}
		println();
	}

	/**
	 * char[][]を改行区切りで、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 */
	public void println(final char[][] cs){
		for(final char[] c: cs){
			println(c);
		}
	}

	/**
	 * char[][]を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 * @param str 区切り文字
	 */
	public void println(final char[][] cs,final String str){
		for(final char[] c: cs){
			println(c,str);
		}
	}

	/**
	 * char[][]を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param cs 出力したいchar[][]
	 * @param c 区切り文字
	 */
	public void println(final char[][] cs,final char c){
		for(final char[] cc: cs){
			println(cc,c);
		}
	}

	/**
	 * 配列を空白区切りで改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array){
		print(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final String str){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(str);
			print(array[i]);
		}
	}

	/**
	 * 配列を指定された文字を区切り文字として改行無しで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[] array,final char c){
		print(array[0]);
		for(int i = 1;i<array.length;++i){
			print(c);
			print(array[i]);
		}
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays){
		print(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final String str){
		print(arrays[0],str);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],str);
		}
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れないで出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void print(final E[][] arrays,final char c){
		print(arrays[0],c);
		for(int i = 1;i<arrays.length;++i){
			println();
			print(arrays[i],c);
		}
	}

	/**
	 * 配列を空白区切りで改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array){
		println(array,' ');
	}

	/**
	 * 配列を指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final String str){
		print(array,str);
		println();
	}

	/**
	 * 配列を指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param array 出力したい配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[] array,final char c){
		print(array,c);
		println();
	}

	/**
	 * 二次元配列を空白区切りで、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays){
		println(arrays,' ');
	}

	/**
	 * 二次元配列を指定された文字列を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final String str){
		print(arrays,str);
		println();
	}

	/**
	 * 二次元配列を指定された文字を区切り文字として、最後に改行を入れて出力します。
	 * 
	 * @param arrays 出力したい二次元配列
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final E[][] arrays,final char c){
		print(arrays,c);
		println();
	}

	/**
	 * リストを空白区切りで改行無しで出力します。
	 * 
	 * @param list 出力したいリスト
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list){
		println(list,' ');
	}

	/**
	 * リストを指定された文字列を区切り文字として改行ありで出力します。
	 * 
	 * @param list 出力したいリスト
	 * @param str 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final String str){
		if(list.size()>0){
			print(list.get(0));
			for(int i = 1;i<list.size();++i){
				print(str);
				print(list.get(i));
			}
		}
		println();
	}

	/**
	 * リストを指定された文字を区切り文字として改行ありで出力します。
	 * 
	 * @param list 出力したいリスト
	 * @param c 区切り文字
	 * 
	 * @param <E> 要素の型
	 */
	public <E> void println(final List<E> list,final char c){
		if(list.size()>0){
			print(list.get(0));
			for(int i = 1;i<list.size();++i){
				print(c);
				print(list.get(i));
			}
		}
		println();
	}

	/**
	 * SimpleWriterクラス用のSimpleOutputStreamクラスです。
	 * ちょっとだけ速いです。
	 */
	public final class SimpleOutputStream{

		/**
		 * このSimpleOutputStreamのバッファーです。
		 */
		private final byte[] buf;

		/**
		 * このSimpleOutputStreamのバッファーにある文字数を管理する変数です。
		 */
		private int count;

		/**
		 * このSimpleoutputStreamの元となるoutputStreamです。
		 */
		private OutputStream out;

		/**
		 * 指定されたOutputStreamとバッファーサイズを元にSimpleOutputStreamを生成します。
		 * 
		 * @param out SimpleOutputStreamの元となるOutputStream
		 * @param size バッファーサイズ
		 */
		public SimpleOutputStream(final OutputStream out,final int size){
			this.out = out;
			if(size<=0){
				throw new IllegalArgumentException("Buffer size <= 0");
			}
			buf = new byte[size];
		}

		/**
		 * バッファリングしている文字をOutputStreamに書き込みます。
		 * 
		 * @throws IOException
		 */
		private void flushBuffer() throws IOException{
			if(count>0){
				out.write(buf,0,count);
				count = 0;
			}
		}

		/**
		 * 引数の値をバッファリングします。
		 * 
		 * @param b バッファリング対象
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final int b) throws IOException{
			if(count>=buf.length){
				flushBuffer();
			}
			buf[count++] = (byte)b;
		}

		/**
		 * 引数のchar[]の指定された文字数分をバッファリングします。
		 * 
		 * @param ch 元となるchar[]
		 * @param off 開始始点
		 * @param len 文字数
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final char[] ch,final int off,final int len) throws IOException{
			if(len>=buf.length){
				flushBuffer();
				out.write(parseByteArray(ch,off,len),0,len);
				return;
			}
			if(len>buf.length-count){
				flushBuffer();
			}
			for(int i=0;i<len;i++){
				buf[count+i] = (byte)ch[i+off];
			}
			count += len;
		}
		
		/**
		 * 指定されたchar[]の区間をbyte[]に変換します。
		 * 
		 * @param ch 元となるchar[]
		 * @param off 開始始点
		 * @param len 文字数
		 * @return 変換後のbyte[]
		 */
		private byte[] parseByteArray(final char[] ch,final int off,final int len){
			final byte[] ans = new byte[len];
			for(int i=0;i<len;i++){
				ans[i] = (byte)ch[i+off];
			}
			return ans;
		}

		/**
		 * 指定されたbyte[]の要素分バッファリングします。
		 * 
		 * @param b 元となるbyte[]
		 * @param off 開始地点
		 * @param len 要素数
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void write(final byte[] b,final int off,final int len) throws IOException{
			if(len>=buf.length){
				flushBuffer();
				out.write(b,off,len);
				return;
			}
			if(len>buf.length-count){
				flushBuffer();
			}
			System.arraycopy(b,off,buf,count,len);
			count += len;
		}

		/**
		 * バッファリングしている文字を書き込み、OutputStreamをフラッシュします。
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void flush() throws IOException{
			flushBuffer();
			out.flush();
		}

		/**
		 * このSimpleOutputStreamの元となるOutputStreamを閉じます。
		 *
		 * @throws IOException フラッシュが必要な時にOutputStream側で例外が生じた場合
		 */
		public void close() throws IOException{
			flush();
			out.close();
			out = null;
		}
	}
}
