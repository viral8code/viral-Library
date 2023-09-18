/**
 * SimpleWriterクラスです。
 * 配列の出力に特化したクラスで、一次元、二次元の配列の出力ができます。
 * 他はPrintWriterクラスとほぼ同等です。
 */

package io;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.Locale;

public final class SimpleWriter implements Appendable, Closeable, Flushable, AutoCloseable{

	/**
	 * 書き込み先のWriter
	 */
	private Writer out;

	/**
	 * trueなら改行を出力するごとにflushします
	 */
	private final boolean autoFlush;

	/**
	 * IOExceptionなどが起こったときにtrueになる
	 */
	private boolean trouble = false;

	/**
	 * format用
	 */
	private Formatter formatter;

	/**
	 * PrintStream特化用
	 */
	private PrintStream psOut = null;

	/**
	 * コンストラクタです
	 * @param out
	 */
	public SimpleWriter ( final Writer out ) {
		this( out, false );
	}

	/**
	 * コンストラクタです
	 * @param out
	 * @param autoFlush
	 */
	public SimpleWriter ( final Writer out, final boolean autoFlush ) {
		this.out = out;
		this.autoFlush = autoFlush;
	}

	/**
	 * コンストラクタです
	 * @param out
	 */
	public SimpleWriter ( final OutputStream out ) {
		this( out, false );
	}

	/**
	 * コンストラクタです
	 * @param out
	 * @param autoFlush
	 */
	public SimpleWriter ( final OutputStream out, final boolean autoFlush ) {
		this(out, autoFlush, Charset.defaultCharset());
	}

	/**
	 * コンストラクタです
	 * @param out
	 * @param autoFlush
	 * @param charset
	 */
	public SimpleWriter(final OutputStream out, final boolean autoFlush, final Charset charset) {
		this(new BufferedWriter(new OutputStreamWriter(new SimpleOutputStream(out), charset)), autoFlush);
		if (out instanceof PrintStream) {
			psOut = (PrintStream) out;
		}
	}

	/**
	 * streamがopenであるかチェックします
	 * @throws IOException
	 */
	private void ensureOpen () throws IOException {
		if ( out == null ) {
			throw new IOException( "Stream closed" );
		}
	}

	/**
	 * streamに残っているものをflushします
	 */
	public void flush () {
		try {
			ensureOpen();
			out.flush();
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * 出力用streamを閉じます
	 */
	public void close () {
		try {
			if ( out == null ) {
				return;
			}
			out.close();
			out = null;
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * エラー出ていないかチェックします
	 * @return
	 */
	public boolean checkError () {
		if ( out != null ) {
			flush();
		}
		else if ( psOut != null ) {
			return psOut.checkError();
		}
		return trouble;
	}

	/**
	 * 整数cを書き込みます
	 * @param c
	 */
	public void write ( final int c ) {
		try {
			ensureOpen();
			out.write( c );
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * bufのoffからlenだけ書き込みます
	 * @param buf
	 * @param off
	 * @param len
	 */
	public void write ( final char[] buf, final int off, final int len ) {
		try {
			ensureOpen();
			out.write( buf, off, len );
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * bufを書き込みます
	 * @param buf
	 */
	public void write ( final char[] buf ) {
		write( buf, 0, buf.length );
	}

	/**
	 * sのoffからlen文字だけ書き込みます
	 * @param s
	 * @param off
	 * @param len
	 */
	public void write ( final String s, final int off, final int len ) {
		try {
			ensureOpen();
			out.write( s, off, len );
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * sを書き込みます
	 * @param s
	 */
	public void write ( final String s ) {
		write( s, 0, s.length() );
	}

	/**
	 * 新しい行へ改行します
	 */
	private void newLine () {
		try {
			ensureOpen();
			out.write( System.lineSeparator() );
			if ( autoFlush ) {
				out.flush();
			}
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param b
	 */
	public void print ( final boolean b ) {
		write( b ? "true" : "false" );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param c
	 */
	public void print ( final char c ) {
		write( c );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param i
	 */
	public void print ( final int i ) {
		write( String.valueOf( i ) );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param l
	 */
	public void print ( final long l ) {
		write( String.valueOf( l ) );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param f
	 */
	public void print ( final float f ) {
		write( String.valueOf( f ) );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param d
	 */
	public void print ( final double d ) {
		write( String.valueOf( d ) );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param s
	 */
	public void print ( final char[] s ) {
		write( s );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param s
	 */
	public void print ( final String s ) {
		write( s );
	}

	/**
	 * 引数を改行無しで書き込みます
	 * @param obj
	 */
	public void print ( final Object obj ) {
		write( obj.toString() );
	}

	/**
	 * 引数を改行無しで書き込みます
	 */
	public void println () {
		newLine();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final boolean x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final char x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final int x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final long x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final float x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final double x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final char[] x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final String x ) {
		print( x );
		println();
	}

	/**
	 * 引数を改行ありで書き込みます
	 * @param x
	 */
	public void println ( final Object x ) {
		print( x.toString() );
		println();
	}

	/**
	 * 引数のフォーマットに従って書き込みます
	 * @param format
	 * @param args
	 * @return
	 */
	public SimpleWriter printf ( final String format, final Object... args ) {
		return format( format, args );
	}

	/**
	 * 引数のフォーマットに従って書き込みます
	 * @param l
	 * @param format
	 * @param args
	 * @return
	 */
	public SimpleWriter printf ( final Locale l, final String format, final Object... args ) {
		return format( l, format, args );
	}

	/**
	 * 引数のフォーマットに従って書き込みます
	 * @param format
	 * @param args
	 * @return
	 */
	public SimpleWriter format ( final String format, final Object... args ) {
		try {
			ensureOpen();
			if ( ( formatter == null )
					|| ( formatter.locale() != Locale.getDefault() ) ) {
				formatter = new Formatter( this );
			}
			formatter.format( Locale.getDefault(), format, args );
			if ( autoFlush ) {
				out.flush();
			}
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
		return this;
	}

	/**
	 * 引数のフォーマットに従って書き込みます
	 * @param l
	 * @param format
	 * @param args
	 * @return
	 */
	public SimpleWriter format ( final Locale l, final String format, final Object... args ) {
		try {
			ensureOpen();
			if ( ( formatter == null ) || ( formatter.locale() != l ) ) {
				formatter = new Formatter( this, l );
			}
			formatter.format( l, format, args );
			if ( autoFlush ) {
				out.flush();
			}
		} catch ( InterruptedIOException x ) {
			Thread.currentThread().interrupt();
		} catch ( IOException x ) {
			trouble = true;
		}
		return this;
	}

	/**
	 * CharSequenceを改行無しで書き込みます
	 */
	@Override
	public SimpleWriter append ( final CharSequence csq ) {
		write( String.valueOf( csq ) );
		return this;
	}

	/**
	 * CharSequenceをstartからendまで改行無しで書き込みます
	 */
	@Override
	public SimpleWriter append ( CharSequence csq, final int start, final int end ) {
		if ( csq == null ) {
			csq = "null";
		}
		return append( csq.subSequence( start, end ) );
	}

	/**
	 * charを改行無しで書き込みます
	 */
	@Override
	public SimpleWriter append ( final char c ) {
		write( c );
		return this;
	}

	/**
	 * int型一次元配列を空白区切りで出力します
	 * @param array
	 */
	public void println ( final int[] array ) {
		println( array, ' ' );
	}

	/**
	 * int型一次元配列を指定された区切り文字列で出力します
	 * @param array
	 * @param str
	 */
	public void println ( final int[] array, final String str ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( str );
			print( array[i] );
		}
		println();
	}

	/**
	 * int型一次元配列を指定された区切り文字で出力します
	 * @param array
	 * @param c
	 */
	public void println ( final int[] array, final char c ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( c );
			print( array[i] );
		}
		println();
	}

	/**
	 * int型二次元配列を指定された区切り文字列で出力します
	 * @param array
	 */
	public void println ( final int[][] array ) {
		println( array, ' ' );
	}

	/**
	 * int型二次元配列を指定された区切り文字列で出力します
	 * @param arrays
	 * @param str
	 */
	public void println ( final int[][] arrays, final String str ) {
		for ( final int[] array: arrays ) {
			println( array, str );
		}
	}

	/**
	 * int型二次元配列を指定された区切り文字で出力します
	 * @param arrays
	 * @param c
	 */
	public void println ( final int[][] arrays, final char c ) {
		for ( final int[] array: arrays ) {
			println( array, c );
		}
	}

	/**
	 * long型一次元配列を空白区切りで出力します
	 * @param array
	 */
	public void println ( final long[] array ) {
		println( array, ' ' );
	}

	/**
	 * long型一次元配列を指定された区切り文字列で出力します
	 * @param array
	 * @param str
	 */
	public void println ( final long[] array, final String str ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( str );
			print( array[i] );
		}
		println();
	}

	/**
	 * long型一次元配列を指定された区切り文字で出力します
	 * @param array
	 * @param c
	 */
	public void println ( final long[] array, final char c ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( c );
			print( array[i] );
		}
		println();
	}

	/**
	 * long型二次元配列を空白区切りで出力します
	 * @param array
	 */
	public void println ( final long[][] array ) {
		println( array, ' ' );
	}

	/**
	 * long型二次元配列を指定された区切り文字列で出力します
	 * @param arrays
	 * @param str
	 */
	public void println ( final long[][] arrays, final String str ) {
		for ( final long[] array: arrays ) {
			println( array, str );
		}
	}

	/**
	 * long型二次元配列を指定された区切り文字で出力します
	 * @param arrays
	 * @param c
	 */
	public void println ( final long[][] arrays, final char c ) {
		for ( final long[] array: arrays ) {
			println( array, c );
		}
	}

	/**
	 * double型一次元配列を空白区切りで出力します
	 * @param array
	 */
	public void println ( final double[] array ) {
		println( array, ' ' );
	}

	/**
	 * double型一次元配列を指定された区切り文字列で出力します
	 * @param array
	 * @param str
	 */
	public void println ( final double[] array, final String str ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( str );
			print( array[i] );
		}
		println();
	}

	/**
	 * double型一次元配列を指定された区切り文字列で出力します
	 * @param array
	 * @param c
	 */
	public void println ( final double[] array, final char c ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( c );
			print( array[i] );
		}
		println();
	}

	/**
	 * double型二次元配列を空白区切りで出力します
	 * @param array
	 */
	public void println ( final double[][] array ) {
		println( array, ' ' );
	}

	/**
	 * double型二次元配列を指定された区切り文字列で出力します
	 * @param arrays
	 * @param str
	 */
	public void println ( final double[][] arrays, final String str ) {
		for ( final double[] array: arrays ) {
			println( array, str );
		}
	}

	/**
	 * double型二次元配列を指定された区切り文字で出力します
	 * @param arrays
	 * @param c
	 */
	public void println ( final double[][] arrays, final char c ) {
		for ( final double[] array: arrays ) {
			println( array, c );
		}
	}

	/**
	 * char型一次元配列を指定された区切り文字列で出力します
	 * @param cs
	 * @param str
	 */
	public void println ( final char[] cs, final String str ) {
		print( cs[0] );
		for ( int i = 1; i < cs.length; ++i ) {
			print( str );
			print( cs[i] );
		}
		println();
	}

	/**
	 * char型一次元配列を指定された区切り文字で出力します
	 * @param cs
	 * @param c
	 */
	public void println ( final char[] cs, final char c ) {
		print( cs[0] );
		for ( int i = 1; i < cs.length; ++i ) {
			print( c );
			print( cs[i] );
		}
		println();
	}

	/**
	 * char型二次元配列を出力します
	 * @param cs
	 */
	public void println ( final char[][] cs ) {
		for ( final char[] c: cs ) {
			println( c );
		}
	}

	/**
	 * char型二次元配列を指定された区切り文字列で出力します
	 * @param cs
	 * @param str
	 */
	public void println ( final char[][] cs, final String str ) {
		for ( final char[] c: cs ) {
			println( c, str );
		}
	}

	/**
	 * char型二次元配列を指定された区切り文字で出力します
	 * @param cs
	 * @param c
	 */
	public void println ( final char[][] cs, final char c ) {
		for ( final char[] cc: cs ) {
			println( cc, c );
		}
	}

	/**
	 * 参照型一次元配列を空白区切りで出力します
	 * @param <E>
	 * @param array
	 */
	public <E> void println ( final E[] array ) {
		println( array, ' ' );
	}

	/**
	 * 参照型一次元配列を指定された区切り文字列で出力します
	 * @param <E>
	 * @param array
	 * @param str
	 */
	public <E> void println ( final E[] array, final String str ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( str );
			print( array[i] );
		}
		println();
	}

	/**
	 * 参照型一次元配列を指定された区切り文字で出力します
	 * @param <E>
	 * @param array
	 * @param c
	 */
	public <E> void println ( final E[] array, final char c ) {
		print( array[0] );
		for ( int i = 1; i < array.length; ++i ) {
			print( c );
			print( array[i] );
		}
		println();
	}

	/**
	 * 参照型二次元配列を空白区切りで出力します
	 * @param <E>
	 * @param arrays
	 */
	public <E> void println ( final E[][] arrays ) {
		println( arrays, ' ' );
	}

	/**
	 * 参照型二次元配列を指定された区切り文字列で出力します
	 * @param <E>
	 * @param arrays
	 * @param str
	 */
	public <E> void println ( final E[][] arrays, final String str ) {
		for ( final E[] array: arrays ) {
			println( array, str );
		}
	}

	/**
	 * 参照型二次元配列を指定された区切り文字で出力します
	 * @param <E>
	 * @param arrays
	 * @param c
	 */
	public <E> void println ( final E[][] arrays, final char c ) {
		for ( final E[] array: arrays ) {
			println( array, c );
		}
	}
}
