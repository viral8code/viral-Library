/**
 * Matrixクラスです。
 * 基本は変更不可なインスタンスですが、setメソッドを用いることで変更が可能です。
 * equalsメソッド、hashCodeメソッドを実装していないため、HashSetなどでは期待通りの結果にならない可能性があります。
 */
package math;

import java.awt.Dimension;
import java.util.Arrays;

public final class Matrix {
	private final long[][] matrix;

	/**
	 * defを初期としてH行W列の行列を生成します。
	 * @param H
	 * @param W
	 * @param def
	 */
	public Matrix ( final int H, final int W, final long def ) {
		matrix = new long[H][W];
		if ( def != 0 ) {
			for ( final long[] mat: matrix ) {
				Arrays.fill( mat, def );
			}
		}
	}

	/**
	 * H行W列の行列を生成します。初期値は0です。
	 * @param H
	 * @param W
	 * @param def
	 */
	public Matrix ( final int H, final int W ) {
		this( H, W, 0 );
	}

	/**
	 * Dimensionが表す大きさの行列を生成します。
	 * @param H
	 * @param W
	 * @param def
	 */
	public Matrix ( final Dimension d, final long def ) {
		this( d.height, d.width, def );
	}

	/**
	 * 引数の二次元配列を行列として解釈します。
	 * 深いコピーをするので引数に変更を加えてもこの行列に反映はされません。
	 * @param H
	 * @param W
	 * @param def
	 */
	public Matrix ( final long[][] mat ) {
		matrix = new long[mat.length][];
		for ( int i = 0; i < mat.length; ++i ) {
			matrix[i] = Arrays.copyOf( mat[i], mat[i].length );
		}
	}

	/**
	 * i行j列目の要素を取得します。
	 * @param i
	 * @param j
	 * @return
	 */
	public long get ( final int i, final int j ) {
		return matrix[i][j];
	}

	/**
	 * i行j列目の要素をvalueに変更します。
	 * @param i
	 * @param j
	 * @param value
	 * @return
	 */
	public long set ( final int i, final int j, final long value ) {
		return matrix[i][j] = value;
	}

	/**
	 * この行列と等しい行列を新しく生成します。
	 * @return
	 */
	public Matrix copy () {
		return new Matrix( matrix );
	}

	/**
	 * この行列の行数、列数に対応するDimensionを返します。
	 * @return
	 */
	public Dimension size () {
		return new Dimension( matrix[0].length, matrix.length );
	}

	/**
	 * 引数の行列でこの行列を加算した行列に等しい行列を返します。
	 * @param m
	 * @return
	 */
	public Matrix add ( final Matrix m ) {
		if ( !size().equals( m.size() ) ) {
			throw new IllegalArgumentException( "matrix size is not same" );
		}
		final Matrix ans = new Matrix( size(), 0 );
		for ( int i = 0; i < matrix.length; ++i ) {
			for ( int j = 0; j < matrix[i].length; ++j ) {
				ans.set( i, j, matrix[i][j] + m.get( i, j ) );
			}
		}
		return ans;
	}

	/**
	 * 引数の行列でこの行列を減算した行列に等しい行列を返します。
	 * @param m
	 * @return
	 */
	public Matrix subtract ( final Matrix m ) {
		if ( !size().equals( m.size() ) ) {
			throw new IllegalArgumentException( "matrix size is not same" );
		}
		final Matrix ans = new Matrix( size(), 0 );
		for ( int i = 0; i < matrix.length; ++i ) {
			for ( int j = 0; j < matrix[i].length; ++j ) {
				ans.set( i, j, matrix[i][j] - m.get( i, j ) );
			}
		}
		return ans;
	}

	/**
	 * 引数の行列でこの行列を乗算した行列に等しい行列を返します。
	 * @param m
	 * @return
	 */
	public Matrix multiply ( final Matrix m ) {
		if ( size().width != m.size().height ) {
			throw new IllegalArgumentException( "matrix length is not same" );
		}
		final Matrix ans = new Matrix( size().height, m.size().width );
		final Dimension size = ans.size();
		final int len = size().width;
		for ( int i = 0; i < size.height; ++i ) {
			for ( int j = 0; j < size.width; ++j ) {
				long sum = 0;
				for ( int k = 0; k < len; ++k ) {
					sum += matrix[i][k] * m.get( k, j );
				}
				ans.set( i, j, sum );
			}
		}
		return ans;
	}

	/**
	 * 引数の行列でこの行列を加算した行列に等しい行列を返します。
	 * 各要素はmodで割ったあまりに変換されます。
	 * @param m
	 * @param mod
	 * @return
	 */
	public Matrix modAdd ( final Matrix m, final long mod ) {
		if ( !size().equals( m.size() ) ) {
			throw new IllegalArgumentException( "matrix size is not same" );
		}
		final Matrix ans = new Matrix( size(), 0 );
		for ( int i = 0; i < matrix.length; ++i ) {
			for ( int j = 0; j < matrix[i].length; ++j ) {
				ans.set( i, j, MathFunction.remainder( matrix[i][j] + m.get( i, j ), mod ) );
			}
		}
		return ans;
	}

	/**
	 * 引数の行列でこの行列を減算した行列に等しい行列を返します。
	 * 各要素はmodで割ったあまりに変換されます。
	 * @param m
	 * @param mod
	 * @return
	 */
	public Matrix modSubtract ( final Matrix m, final long mod ) {
		if ( !size().equals( m.size() ) ) {
			throw new IllegalArgumentException( "matrix size is not same" );
		}
		final Matrix ans = new Matrix( size(), 0 );
		for ( int i = 0; i < matrix.length; ++i ) {
			for ( int j = 0; j < matrix[i].length; ++j ) {
				ans.set( i, j, MathFunction.remainder( matrix[i][j] - m.get( i, j ), mod ) );
			}
		}
		return ans;
	}

	/**
	 * 引数の行列でこの行列を乗算した行列に等しい行列を返します。
	 * 各要素はmodで割ったあまりに変換されます。
	 * @param m
	 * @param mod
	 * @return
	 */
	public Matrix modMultiply ( final Matrix m, final long mod ) {
		if ( size().width != m.size().height ) {
			throw new IllegalArgumentException( "matrix length is not same" );
		}
		final Matrix ans = new Matrix( size().height, m.size().width );
		final Dimension size = ans.size();
		final int len = size().width;
		for ( int i = 0; i < size.height; ++i ) {
			for ( int j = 0; j < size.width; ++j ) {
				long sum = 0;
				for ( int k = 0; k < len; ++k ) {
					sum = MathFunction.remainder( sum + matrix[i][k] * m.get( k, j ), mod );
				}
				ans.set( i, j, sum );
			}
		}
		return ans;
	}

	/**
	 * originalを初期値として、pwをexp回乗算した行列に等しい行列を返します。
	 * @param original
	 * @param pw
	 * @param exp
	 * @return
	 */
	public static Matrix pow ( final Matrix original, final Matrix pw, long exp ) {
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while ( 0 < exp ) {
			if ( ( exp & 1 ) == 1 ) {
				a = b.multiply( a );
			}
			b = b.multiply( b );
			exp >>= 1;
		}
		return a;
	}

	/**
	 * originalを初期値として、pwをexp回乗算した行列に等しい行列を返します。
	 * 各要素はmodで割ったあまりに変換されます。
	 * @param original
	 * @param pw
	 * @param exp
	 * @param mod
	 * @return
	 */
	public static Matrix modPow ( final Matrix original, final Matrix pw, long exp, final long mod ) {
		Matrix a = original.copy();
		Matrix b = pw.copy();
		while ( 0 < exp ) {
			if ( ( exp & 1 ) == 1 ) {
				a = b.modMultiply( a, mod );
			}
			b = b.modMultiply( b, mod );
			exp >>= 1;
		}
		return a;
	}

	/**
	 * この行列の行列式を計算します。
	 * @return
	 */
	public long determinant () {
		return determinant( matrix );
	}

	/**
	 * 引数の二次元配列を行列として見て行列式を計算します。
	 * 正方行列にのみ対応しているのでご注意ください。
	 * @param mat
	 * @return
	 */
	private static long determinant ( final long[][] mat ) {
		if ( mat.length == 1 ) {
			return mat[0][0];
		}
		final long[][] miniMat = new long[mat.length - 1][mat.length - 1];
		for ( int i = 1; i < mat.length; ++i ) {
			System.arraycopy( mat[i], 1, miniMat[i - 1], 0, miniMat.length );
		}
		long ans = mat[0][0] * determinant( miniMat );
		for ( int i = 1; i < mat.length; ++i ) {
			for ( int j = 1; j < mat.length; ++j ) {
				miniMat[j - 1][i - 1] = mat[j][i - 1];
			}
			final long num = mat[0][i] * determinant( miniMat );
			ans += i % 2 == 0 ? num : -num;
		}
		return ans;
	}

	/**
	 * この行列を表すStringを返します。
	 */
	@Override
	public String toString () {
		final StringBuilder ans = new StringBuilder();
		ans.append( Arrays.toString( matrix[0] ) );
		for ( int i = 1; i < matrix.length; ++i ) {
			ans.append( "\n" );
			ans.append( Arrays.toString( matrix[i] ) );
		}
		return ans.toString();
	}
}
