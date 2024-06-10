package io;

import java.awt.Point;
import java.io.InputStream;
import java.io.IOException;
import java.math.BigInteger;

/**
 * SimpleScannerクラスです。
 * java.util.Scannerクラスよりは速いですが、競プロ用に特化しているため
 * charの値がスペース以下の文字は全て区切り文字と判断します。
 */
public final class SimpleScanner{

	/**
	 * SimpleScannerの内部のバッファーの容量です。
	 */
	private static final int BUFF_SIZE = 1<<17;

	/**
	 * このSimpleScannerのInputStreamインスタンスです。
	 */
	private final InputStream is;

	/**
	 * このSimpleScannerのバッファーです。
	 */
	private final byte[] buff;

	/**
	 * 状態管理用の変数です。
	 */
	private int point, length;

	/**
	 * 引数のInputStreamを元にSimpleScannerを構築します。
	 *
	 * @param is 元となるInputStream
	 */
	public SimpleScanner(final InputStream is){
		this.is = is;
		buff = new byte[BUFF_SIZE];
		point = length = 0;
	}

	/**
	 * バッファに再読み込みします。
	 * 何かしら入力がされるまで待機します。
	 */
	private void reload(){
		try{
			length = is.read(buff,point = 0,BUFF_SIZE);
		}catch(final IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * バッファから一文字読み込みます。
	 *
	 * @return 読み込んだ文字を表すbyte
	 */
	private byte read(){
		if(point==length){
			reload();
		}
		if(length<0){
			return '\n';
		}
		return buff[point++];
	}

	/**
	 * バッファから文字を表すbyteを取得します。
	 *
	 * @return まだ読んでない中で最初に入力された文字を表すbyte
	 */
	public byte nextByte(){
		byte c = read();
		while(c<=' '){
			c = read();
		}
		return c;
	}

	/**
	 * バッファからintを読み込みます。
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列をintと解釈した時の値
	 */
	public int nextInt(){
		int ans = 0;
		byte c = nextByte();
		final boolean negate = c=='-';
		if(!MathFunction.rangeCheckClose(c,'0','9')){
			c = read();
		}
		while(MathFunction.rangeCheckClose(c,'0','9')){
			ans = ans*10+c-'0';
			c = read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファからlongを読み込みます。
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列をlongと解釈した時の値
	 */
	public long nextLong(){
		long ans = 0;
		byte c = nextByte();
		final boolean negate = c=='-';
		if(!MathFunction.rangeCheckClose(c,'0','9')){
			c = read();
		}
		while(MathFunction.rangeCheckClose(c,'0','9')){
			ans = ans*10L+c-'0';
			c = read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファからcharを読み込みます。
	 *
	 * @return 区切り文字を無視した、一番最初に取得された文字を表すchar
	 */
	public char nextChar(){
		return (char)nextByte();
	}

	/**
	 * バッファからStringを読み込みます。
	 *
	 * @return 区切り文字までの文字列を表すString
	 */
	public String next(){
		final StringBuilder ans = new StringBuilder();
		byte c = nextByte();
		while(c>' '){
			ans.append((char)c);
			c = read();
		}
		return ans.toString();
	}

	/**
	 * バッファからBigIntegerを読み込みます。
	 *
	 * @return 区切り文字までの文字列を整数と解釈した時のBigInteger
	 */
	public BigInteger nextBigInteger(){
		return new BigInteger(next());
	}

	/**
	 * バッファからbyte[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字を無視してn個文字を取得した結果を表すbyte[]
	 */
	public byte[] nextByte(final int n){
		final byte[] ans = new byte[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextByte();
		}
		return ans;
	}

	/**
	 * バッファからint[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個intを取得した結果を表すint[]
	 */
	public int[] nextInt(final int n){
		final int[] ans = new int[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextInt();
		}
		return ans;
	}

	/**
	 * バッファからlong[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個longを取得した結果を表すlong[]
	 */
	public long[] nextLong(final int n){
		final long[] ans = new long[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextLong();
		}
		return ans;
	}

	/**
	 * バッファからString[]を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切ってn個Stringを取得した結果を表すString[]
	 */
	public String[] next(final int n){
		final String[] ans = new String[n];
		for(int i = 0;i<n;++i){
			ans[i] = next();
		}
		return ans;
	}

	/**
	 * バッファからbyte[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個byteを取得した結果を表すbyte[][]
	 */
	public byte[][] nextByte(final int n,final int m){
		final byte[][] ans = new byte[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextByte(m);
		}
		return ans;
	}

	/**
	 * バッファからint[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個intを取得した結果を表すint[][]
	 */
	public int[][] nextInt(final int n,final int m){
		final int[][] ans = new int[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextInt(m);
		}
		return ans;
	}

	/**
	 * バッファからlong[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個longを取得した結果を表すlong[][]
	 */
	public long[][] nextLong(final int n,final int m){
		final long[][] ans = new long[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextLong(m);
		}
		return ans;
	}

	/**
	 * バッファからString[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @param m 取得する列数
	 * @return 区切り文字で区切ってn*m個Stringを取得した結果を表すString[][]
	 */
	public String[][] next(final int n,final int m){
		final String[][] ans = new String[n][];
		for(int i = 0;i<n;++i){
			ans[i] = next(m);
		}
		return ans;
	}

	/**
	 * バッファからStringを読み込み、char[]に変換して返します。
	 * 
	 * @return バッファから読み込んだStringを表すchar[]
	 */
	public char[] nextCharArray(){
		return next().toCharArray();
	}

	/**
	 * バッファからchar[][]を読み込みます。
	 * 
	 * @param n 取得する行数
	 * @return 区切り文字で区切ってn個Stringを取得した結果を表すchar[][]
	 */
	public char[][] nextCharArray(final int n){
		final char[][] ans = new char[n][];
		for(int i = 0;i<n;++i){
			ans[i] = nextCharArray();
		}
		return ans;
	}

	/**
	 * バッファから読み込んだM個のペアの整数を無向辺として処理します。
	 * 
	 * @param N 頂点の数
	 * @param M 辺の数
	 * @return N頂点M辺の無向グラフの隣接リストを表すint[][]
	 */
	public int[][] nextGraph(final int N,final int M){
		if(M==0){
			return new int[N+1][0];
		}
		final int[][] ans = new int[N+1][];
		final int[] count = new int[N+1];
		final int[][] path = nextInt(M,2);
		for(final int[] temp: path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i = 1;i<=N;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp: path){
			ans[temp[0]][--count[temp[0]]] = temp[1];
			ans[temp[1]][--count[temp[1]]] = temp[0];
		}
		ans[0] = new int[0];
		return ans;
	}

	/**
	 * バッファからPointを読み込みます。
	 * 
	 * @return 読み込んだint二つをPointに変換したインスタンス
	 */
	public Point nextPoint(){
		return new Point(nextInt(),nextInt());
	}

	/**
	 * バッファからPoint[]を読み込みます。
	 * 
	 * @param n 取得する個数
	 * @return 区切り文字で区切ってn個Pointを取得した結果を表すPoint[]
	 */
	public Point[] nextPoint(final int n){
		final Point[] ans = new Point[n];
		for(int i = 0;i<n;++i){
			ans[i] = nextPoint();
		}
		return ans;
	}

	/**
	 * このSimpleScannerのInputStreamを閉じます。
	 */
	public void close(){
		try{
			is.close();
		}catch(final IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
