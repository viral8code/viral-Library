package math;

import java.awt.Dimension;
import java.util.Arrays;

/**
 * Matrixクラスです。
 * 行列を保持するクラスで、簡単な四則演算に行列式、累乗などを提供しています。
 */
public final class Matrix{

	/**
	 * 行列を管理するための二次元配列です。
	 */
	private final long[][] matrix;

	/**
	 * H行W列の、全要素がdefの行列を構築します。
	 *
	 * @param H 行数
	 * @param W 列数
	 * @param def 全要素の値
	 */
	public Matrix(final int H,final int W,final long def){
		matrix = new long[H][W];
		if(def!=0){
			for(final long[] mat: matrix){
				Arrays.fill(mat,def);
			}
		}
	}

	/**
	 * H行W列の、全要素が0である行列を構築します。
	 *
	 * @param H 行数
	 * @param W 列数
	 */
	public Matrix(final int H,final int W){
		this(H,W,0);
	}

	/**
	 * Dimensionで表される行数、列数で全要素がdefの行列を構築します。
	 *
	 * @param d 行・列数
	 * @param def 全要素の値
	 */
	public Matrix(final Dimension d,final long def){
		this(d.height,d.width,def);
	}

	/**
	 * 引数の二次元配列を元に行列を構築します。
	 * 値をコピーして構築するため、引数の行列とは連動していません。
	 *
	 * @param mat 元となる二次元配列
	 */
	public Matrix(final long[][] mat){
		matrix = new long[mat.length][];
		for(int i = 0;i<mat.length;++i){
			matrix[i] = Arrays.copyOf(mat[i],mat[i].length);
		}
	}

	/**
	 * i行j列目の要素を取得します。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 *
	 * @return i行j列目の要素
	 */
	public long get(final int i,final int j){
		return matrix[i][j];
	}

	/**
	 * i行j列目の要素を引数の値で上書きします。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 * @param value 上書きする値
	 *
	 * @return value
	 */
	public long set(final int i,final int j,final long value){
		return matrix[i][j] = value;
	}

	/**
	 * この行列を複製します。
	 *
	 * @return この行列と等価な行列(連動していない)
	 */
	public Matrix copy(){
		return new Matrix(matrix);
	}

	/**
	 * この行列の行・列数を表すDimensionを返します。
	 *
	 * @return この行列の行・列数を表すDimension
	 */
	public Dimension size(){
		return new Dimension(matrix[0].length,matrix.length);
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 *
	 * @param m 加算する行列
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix add(final Matrix m){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,matrix[i][j]+m.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 *
	 * @param m 減算する行列
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix subtract(final Matrix m){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,matrix[i][j]-m.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 *
	 * @param m 乗算する行列
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix multiply(final Matrix m){
		if(size().width!=m.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(size().height,m.size().width);
		final Dimension size = ans.size();
		final int len = size().width;
		for(int i = 0;i<size.height;++i){
			for(int j = 0;j<size.width;++j){
				long sum = 0;
				for(int k = 0;k<len;++k){
					sum += matrix[i][k]*m.get(k,j);
				}
				ans.set(i,j,sum);
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 * 各要素はmodで除算したあまりに変換されます。
	 *
	 * @param m 加算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix modAdd(final Matrix m,final long mod){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(matrix[i][j]+m.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 * 各要素はmodで除算したあまりに変換されます。
	 *
	 * @param m 減算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix modSubtract(final Matrix m,final long mod){
		if(!size().equals(m.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size(),0);
		for(int i = 0;i<matrix.length;++i){
			for(int j = 0;j<matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(matrix[i][j]-m.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 * 各要素はmodで乗算したあまりに変換されます。
	 *
	 * @param m 乗算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix modMultiply(final Matrix m,final long mod){
		if(size().width!=m.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(size().height,m.size().width);
		final Dimension size = ans.size();
		final int len = size().width;
		for(int i = 0;i<size.height;++i){
			for(int j = 0;j<size.width;++j){
				long sum = 0;
				for(int k = 0;k<len;++k){
					sum = MathFunction.remainder(sum+matrix[i][k]*m.get(k,j),mod);
				}
				ans.set(i,j,sum);
			}
		}
		return ans;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix pow(final Matrix original,final Matrix pw,long exp){
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while(0<exp){
			if((exp&1)==1){
				a = b.multiply(a);
			}
			b = b.multiply(b);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。
	 * 各要素はmodで乗算したあまりに変換されます。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 * @param mod 法となる値
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix modPow(final Matrix original,final Matrix pw,long exp,final long mod){
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while(0<exp){
			if((exp&1)==1){
				a = b.modMultiply(a,mod);
			}
			b = b.modMultiply(b,mod);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * この行列の行列式を返します。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(){
		return determinant(matrix);
	}

	/**
	 * 引数の二次元配列の行列式を返します。
	 *
	 * @param mat 元となる二次元配列
	 *
	 * @return 二次元配列の行列式
	 */
	private static long determinant(final long[][] mat){
		if(mat.length==1){
			return mat[0][0];
		}
		final long[][] miniMat = new long[mat.length-1][mat.length-1];
		for(int i = 1;i<mat.length;++i){
			System.arraycopy(mat[i],1,miniMat[i-1],0,miniMat.length);
		}
		long ans = mat[0][0]*determinant(miniMat);
		for(int i = 1;i<mat.length;++i){
			for(int j = 1;j<mat.length;++j){
				miniMat[j-1][i-1] = mat[j][i-1];
			}
			final long num = mat[0][i]*determinant(miniMat);
			ans += i%2==0?num:-num;
		}
		return ans;
	}

	/**
	 * この行列を表すStringを返します。
	 *
	 * @return この行列を表すString
	 */
	@Override public String toString(){
		final StringBuilder ans = new StringBuilder();
		ans.append(Arrays.toString(matrix[0]));
		for(int i = 1;i<matrix.length;++i){
			ans.append("\n");
			ans.append(Arrays.toString(matrix[i]));
		}
		return ans.toString();
	}
}
