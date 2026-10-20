package io;

import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import math.MathFunction;

/**
 * SimpleScanner クラスです。<br/>
 * java.util.Scanner クラスよりは速いですが、競プロ用に特化しているため char の値がスペース以下の文字は全て区切り文字と判断します。
 */
public final class SimpleScanner{

	/**
	 * SimpleScannerの内部のバッファーの容量です。
	 */
	private static final int BUFF_SIZE;

	/**
	 * 内部計算用の定数です。
	 */
	private static final long TEN;

	/**
	 * 空の int 型配列です。
	 */
	private static final int[] EMPTY_INTS;

	static{
		BUFF_SIZE = 1<<17;
		TEN = 10L;
		EMPTY_INTS = new int[0];
	}

	/**
	 * この SimpleScanner の InputStream インスタンスです。
	 */
	private final InputStream inputStream;

	/**
	 * この SimpleScanner のバッファーです。
	 */
	private final byte[] buff;

	/**
	 * 状態管理用の変数です。
	 */
	private int point, length;

	/**
	 * 引数の InputStream を元に SimpleScanner を構築します。
	 *
	 * @param is 元となるInputStream
	 */
	public SimpleScanner(final InputStream is){
		this.inputStream = is;
		this.buff = new byte[BUFF_SIZE];
		this.point = 0;
		this.length = 0;
	}

	/**
	 * バッファに再読み込みします。
	 * 何かしら入力がされるまで待機します。
	 */
	private void reload(){
		try{
			this.point = 0;
			this.length = this.inputStream.read(this.buff,0,BUFF_SIZE);
		}
		catch(final IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * バッファから一文字読み込みます。
	 *
	 * @return 読み込んだ文字を表す byte
	 */
	private byte read(){
		if(this.point==this.length){
			this.reload();
		}
		if(this.length<0){
			return '\n';
		}
		final byte ans = this.buff[this.point];
		this.point += 1;
		return ans;
	}

	/**
	 * バッファから文字を表す byte を取得します。
	 *
	 * @return まだ読んでない中で最初に入力された文字を表す byte
	 */
	public byte nextByte(){
		byte b = this.read();
		while(b<=' '){
			b = this.read();
		}
		return b;
	}

	/**
	 * バッファから int を読み込みます。<br/>
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列を int と解釈した時の値
	 */
	public int nextInt(){
		int ans = 0;
		byte b = this.nextByte();
		final boolean negate = b=='-';
		if(!MathFunction.rangeCheckClose(b,'0','9')){
			b = this.read();
		}
		while(MathFunction.rangeCheckClose(b,'0','9')){
			ans = ans*10+b-'0';
			b = this.read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファから long を読み込みます。<br/>
	 * オーバーフローは検知できないので注意して下さい。
	 *
	 * @return 区切り文字までの文字列を long と解釈した時の値
	 */
	public long nextLong(){
		long ans = 0;
		byte b = this.nextByte();
		final boolean negate = b=='-';
		if(!MathFunction.rangeCheckClose(b,'0','9')){
			b = this.read();
		}
		while(MathFunction.rangeCheckClose(b,'0','9')){
			ans = ans*TEN+b-'0';
			b = this.read();
		}
		return negate?-ans:ans;
	}

	/**
	 * バッファから char を読み込みます。
	 *
	 * @return 区切り文字を無視した、一番最初に取得された文字を表す char
	 */
	public char nextChar(){
		return (char)this.nextByte();
	}

	/**
	 * バッファから double を読み込みます。
	 *
	 * @return 区切り文字までの文字列を double と解釈した時の値
	 */
	public double nextDouble(){
		return Double.parseDouble(this.next());
	}

	/**
	 * バッファから String を読み込みます。
	 *
	 * @return 区切り文字までの文字列を表す String
	 */
	public String next(){
		final StringBuilder ans = new StringBuilder(16);
		byte b = this.nextByte();
		while(b>' '){
			ans.append((char)b);
			b = this.read();
		}
		return ans.toString();
	}

	/**
	 * バッファから BigInteger を読み込みます。
	 *
	 * @return 区切り文字までの文字列を整数と解釈した時の BigInteger
	 */
	public BigInteger nextBigInteger(){
		return new BigInteger(this.next());
	}

	/**
	 * バッファから byte[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字を無視して n 個文字を取得した結果を表す byte[]
	 */
	public byte[] nextByte(final int n){
		final byte[] ans = new byte[n];
		for(int i=0;i<n;++i){
			ans[i] = this.nextByte();
		}
		return ans;
	}

	/**
	 * バッファから int[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 int を取得した結果を表す int[]
	 */
	public int[] nextInt(final int n){
		final int[] ans = new int[n];
		for(int i=0;i<n;++i){
			ans[i] = this.nextInt();
		}
		return ans;
	}

	/**
	 * バッファから long[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 long を取得した結果を表す long[]
	 */
	public long[] nextLong(final int n){
		final long[] ans = new long[n];
		for(int i=0;i<n;++i){
			ans[i] = this.nextLong();
		}
		return ans;
	}

	/**
	 * バッファから String[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 String を取得した結果を表す String[]
	 */
	public String[] next(final int n){
		final String[] ans = new String[n];
		for(int i=0;i<n;++i){
			ans[i] = this.next();
		}
		return ans;
	}

	/**
	 * バッファから byte[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 byte を取得した結果を表す byte[][]
	 */
	public byte[][] nextByte(final int n,final int m){
		final byte[][] ans = new byte[n][];
		for(int i=0;i<n;++i){
			ans[i] = this.nextByte(m);
		}
		return ans;
	}

	/**
	 * バッファから int[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 int を取得した結果を表す int[][]
	 */
	public int[][] nextInt(final int n,final int m){
		final int[][] ans = new int[n][];
		for(int i=0;i<n;++i){
			ans[i] = this.nextInt(m);
		}
		return ans;
	}

	/**
	 * バッファから long[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 long を取得した結果を表す long[][]
	 */
	public long[][] nextLong(final int n,final int m){
		final long[][] ans = new long[n][];
		for(int i=0;i<n;++i){
			ans[i] = this.nextLong(m);
		}
		return ans;
	}

	/**
	 * バッファから String[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 * @param m 取得する列数
	 *
	 * @return 区切り文字で区切って n * m 個 String を取得した結果を表す String[][]
	 */
	public String[][] next(final int n,final int m){
		final String[][] ans = new String[n][];
		for(int i=0;i<n;++i){
			ans[i] = this.next(m);
		}
		return ans;
	}

	/**
	 * バッファから String を読み込み、char[] に変換して返します。
	 *
	 * @return バッファから読み込んだ String を表す char[]
	 */
	public char[] nextCharArray(){
		final String s = this.next();
		return s.toCharArray();
	}

	/**
	 * バッファから char[][] を読み込みます。
	 *
	 * @param n 取得する行数
	 *
	 * @return 区切り文字で区切って n 個 String を取得した結果を表す char[][]
	 */
	public char[][] nextCharArray(final int n){
		final char[][] ans = new char[n][];
		for(int i=0;i<n;++i){
			ans[i] = this.nextCharArray();
		}
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を無向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の無向グラフの隣接リストを表す int[][]
	 */
	public int[][] nextUndirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0];
		}
		final int[][] ans = new int[vertex+1][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,2);
		for(final int[] temp:path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i=1;i<=vertex;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp:path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = temp[1];
			count[temp[1]] -= 1;
			ans[temp[1]][count[temp[1]]] = temp[0];
		}
		ans[0] = EMPTY_INTS;
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を有向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の有向グラフの隣接リストを表す int[][]
	 */
	public int[][] nextDirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0];
		}
		final int[][] ans = new int[vertex+1][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,2);
		for(final int[] temp:path){
			++count[temp[0]];
		}
		for(int i=1;i<=vertex;++i){
			ans[i] = new int[count[i]];
		}
		for(final int[] temp:path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = temp[1];
		}
		ans[0] = EMPTY_INTS;
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を重み付き無向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の無向グラフの隣接リストを表す int[][]
	 */
	public int[][][] nextWeightedUndirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0][3];
		}
		final int[][][] ans = new int[vertex+1][][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,3);
		for(final int[] temp:path){
			++count[temp[0]];
			++count[temp[1]];
		}
		for(int i=1;i<=vertex;++i){
			ans[i] = new int[count[i]][];
		}
		for(final int[] temp:path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = new int[]{temp[1],temp[2]};
			count[temp[1]] -= 1;
			ans[temp[1]][count[temp[1]]] = new int[]{temp[0],temp[2]};
		}
		ans[0] = new int[0][3];
		return ans;
	}

	/**
	 * バッファから読み込んだ edge 個のペアの整数を重み付き有向辺として処理します。
	 *
	 * @param vertex 頂点の数
	 * @param edge 辺の数
	 *
	 * @return vertex 頂点 edge 辺の有向グラフの隣接リストを表す int[][]
	 */
	public int[][][] nextWeightedDirectGraph(final int vertex,final int edge){
		if(edge==0){
			return new int[vertex+1][0][3];
		}
		final int[][][] ans = new int[vertex+1][][];
		final int[] count = new int[vertex+1];
		final int[][] path = this.nextInt(edge,3);
		for(final int[] temp:path){
			++count[temp[0]];
		}
		for(int i=1;i<=vertex;++i){
			ans[i] = new int[count[i]][];
		}
		for(final int[] temp:path){
			count[temp[0]] -= 1;
			ans[temp[0]][count[temp[0]]] = new int[]{temp[1],temp[2]};
		}
		ans[0] = new int[0][3];
		return ans;
	}

	/**
	 * バッファから Point を読み込みます。
	 *
	 * @return 読み込んだ int 二つを Point に変換したインスタンス
	 */
	public Point nextPoint(){
		return new Point(this.nextInt(),this.nextInt());
	}

	/**
	 * バッファから Point[] を読み込みます。
	 *
	 * @param n 取得する個数
	 *
	 * @return 区切り文字で区切って n 個 Point を取得した結果を表す Point[]
	 */
	public Point[] nextPoint(final int n){
		final Point[] ans = new Point[n];
		for(int i=0;i<n;++i){
			ans[i] = this.nextPoint();
		}
		return ans;
	}

	/**
	 * この SimpleScanner の InputStream を閉じます。
	 */
	public void close(){
		try{
			this.inputStream.close();
		}
		catch(final IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	/**
	 * この SimpleScanner を表す文字列を返します。
	 *
	 * @return この SimpleScanner を表す文字列
	 */
	@Override
	@Deprecated
	public String toString(){
		return "SimpleScanner["+this.hashCode()+"]";
	}
}
