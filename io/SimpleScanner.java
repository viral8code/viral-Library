/**
 * SimpleScannerです。
 * Scannerと基本同じですが、プリミティヴ型とString、Pointのみ受け取ることができます。
 * なお、nextGraphで返ってくる隣接リストは1-indexedです。
 */

package io;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;

import math.MathFunction;

public final class SimpleScanner {

	/**
	 * バッファサイズです
	 */
	private final int BUFF_SIZE = 1 << 15;

	/**
	 * 読み取り用のInputStreamです
	 */
	private final InputStream is;

	/**
	 * このScannerのバッファです
	 */
	private final byte[] buff;

	/**
	 * このScannerのバッファのどこまで読んだか、
	 * バッファのどこまでデータが入っているかを管理する変数です
	 */
	private int point, length;

	/**
	 * このScanner唯一のコンストラクタです
	 * @param is
	 */
	public SimpleScanner ( final InputStream is ) {
		this.is = is;
		buff = new byte[BUFF_SIZE];
		point = length = 0;
	}

	/**
	 * InputStreamからバッファに再度読み取りを行ないます
	 * このメソッドは一文字以上読み取れるまで終了しません
	 */
	private void reload () {
		do {
			try {
				length = is.read( buff, point = 0, BUFF_SIZE );
			} catch ( final IOException e ) {
				e.printStackTrace();
				System.exit( 1 );
			}
		} while ( length == -1 );
	}

	/**
	 * これまで読み込んだ文字の次の文字を表すbyteを返します
	 * @return
	 */
	private byte read () {
		if ( point == length ) {
			reload();
		}
		return buff[point++];
	}

	/**
	 * 次の文字を表すbyteを返します
	 * @return
	 */
	public byte nextByte () {
		byte c = read();
		while ( c <= ' ' ) {
			c = read();
		}
		return c;
	}

	/**
	 * 次の整数をintと解釈して読み取り、返します
	 * オーバーフローは検知できません
	 * @return
	 */
	public int nextInt () {
		int ans = 0;
		byte c = nextByte();
		final boolean negate = c == '-';
		if ( !MathFunction.rangeCheckClose( c, '0', '9' ) ) {
			c = read();
		}
		while ( MathFunction.rangeCheckClose( c, '0', '9' ) ) {
			ans = ans * 10 + c - '0';
			c = read();
		}
		return negate ? -ans : ans;
	}

	/**
	 * 次の整数をlongと解釈して読み取り、返します
	 * オーバーフローは検知できません
	 * @return
	 */
	public long nextLong () {
		long ans = 0;
		byte c = nextByte();
		final boolean negate = c == '-';
		if ( !MathFunction.rangeCheckClose( c, '0', '9' ) ) {
			c = read();
		}
		while ( MathFunction.rangeCheckClose( c, '0', '9' ) ) {
			ans = ans * 10 + c - '0';
			c = read();
		}
		return negate ? -ans : ans;
	}

	/**
	 * 次の文字をcharとして読み取り、返します
	 * 空白、改行は無視されます
	 * @return
	 */
	public char nextChar () {
		return ( char )nextByte();
	}

	/**
	 * 次の文字列を空白や改行などまで読み取り、返します
	 */
	public String next () {
		final StringBuilder ans = new StringBuilder();
		byte c = nextByte();
		while ( c > ' ' ) {
			ans.append( ( char )c );
			c = read();
		}
		return ans.toString();
	}

	/**
	 * 長さnのbyte型一次元配列を返します
	 * 各値はnextByteに等しいです
	 * @param n
	 * @return
	 */
	public byte[] nextByte ( final int n ) {
		final byte[] ans = new byte[n];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextByte();
		}
		return ans;
	}

	/**
	 * 長さnのint型一次元配列を返します
	 * 各値はnextIntに等しいです
	 * @param n
	 * @return
	 */
	public int[] nextInt ( final int n ) {
		final int[] ans = new int[n];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextInt();
		}
		return ans;
	}

	/**
	 * 長さnのlong型一次元配列を返します
	 * 各値はnextLongに等しいです
	 * @param n
	 * @return
	 */
	public long[] nextLong ( final int n ) {
		final long[] ans = new long[n];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextLong();
		}
		return ans;
	}

	/**
	 * 長さnのString型一次元配列を返します
	 * 各値はnextに等しいです
	 * @param n
	 * @return
	 */
	public String[] next ( final int n ) {
		final String[] ans = new String[n];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = next();
		}
		return ans;
	}

	/**
	 * n行m列のbyte型二次元配列を返します
	 * 各値はnextByteに等しいです
	 * @param n
	 * @return
	 */
	public byte[][] nextByte ( final int n, final int m ) {
		final byte[][] ans = new byte[n][];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextByte( m );
		}
		return ans;
	}

	/**
	 * n行m列のint型二次元配列を返します
	 * 各値はnextIntに等しいです
	 * @param n
	 * @return
	 */
	public int[][] nextInt ( final int n, final int m ) {
		final int[][] ans = new int[n][];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextInt( m );
		}
		return ans;
	}

	/**
	 * n行m列のlong型二次元配列を返します
	 * 各値はnextLongに等しいです
	 * @param n
	 * @return
	 */
	public long[][] nextLong ( final int n, final int m ) {
		final long[][] ans = new long[n][];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextLong( m );
		}
		return ans;
	}

	/**
	 * n行m列のString型二次元配列を返します
	 * 各値はnextに等しいです
	 * @param n
	 * @return
	 */
	public String[][] next ( final int n, final int m ) {
		final String[][] ans = new String[n][];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = next( m );
		}
		return ans;
	}

	/**
	 * 次の文字列をchar型一次元配列として受け取り、返します
	 * このメソッドはnext().toCharArray()に等しいです
	 * @return
	 */
	public char[] nextCharArray () {
		return next().toCharArray();
	}

	/**
	 * 次の文字列をchar型二次元配列として受け取り、返します
	 * @return
	 */
	public char[][] nextCharArray ( final int n ) {
		final char[][] ans = new char[n][];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextCharArray();
		}
		return ans;
	}

	/**
	 * N頂点M辺の行列を、1-indexedの隣接リストを表すint型二次元配列として返します
	 * 各頂点と隣接する頂点の順番は与えられた辺の順番に依存します
	 * この隣接リストの0行目はint[0]であることが保証されます
	 * @param N
	 * @param M
	 * @return
	 */
	public int[][] nextGraph ( final int N, final int M ) {
		if ( M == 0 ) {
			return new int[N + 1][0];
		}
		final int[][] ans = new int[N + 1][];
		final int[] count = new int[N + 1];
		final int[][] path = nextInt( M, 2 );
		for ( final int[] temp: path ) {
			++count[temp[0]];
			++count[temp[1]];
		}
		for ( int i = 1; i <= N; ++i ) {
			ans[i] = new int[count[i]];
		}
		for ( final int[] temp: path ) {
			ans[temp[0]][--count[temp[0]]] = temp[1];
			ans[temp[1]][--count[temp[1]]] = temp[0];
		}
		ans[0] = new int[0];
		return ans;
	}

	/**
	 * 次の値を(x,y)として解釈したPoint型インスタンスを返します
	 * @return
	 */
	public Point nextPoint () {
		return new Point( nextInt(), nextInt() );
	}

	/**
	 * 次の2n個の値を(x_i,y_i)として解釈したPoint型一次元配列を返します
	 * @return
	 */
	public Point[] nextPoint ( final int n ) {
		final Point[] ans = new Point[n];
		for ( int i = 0; i < n; ++i ) {
			ans[i] = nextPoint();
		}
		return ans;
	}

	/**
	 * このScannerを閉じます
	 * 閉じた後の各メソッドの挙動は保証されません
	 */
	public void close () {
		try {
			is.close();
		} catch ( final IOException e ) {
			e.printStackTrace();
			System.exit( 1 );
		}
	}
}
