package math;

import java.awt.Dimension;
import java.util.Arrays;
import util.ArrayUtil;

/**
 * Matrix クラスです。<br/>
 * 行列を保持するクラスで、簡単な四則演算に行列式、累乗などを提供しています。
 *
 * @param matrix 行列を管理するための二次元配列です。
 */
public record Matrix(long[][] matrix){

	/**
	 * 行列式計算用のモンゴメリ乗算計算クラスです。
	 */
	private static final Montgomery64.InnerMontgomery64 im;

	/**
	 * 行列式計算用の素数です。
	 */
	private static final long innerMod;

	/**
	 * 行列式計算時のデフォルトの最大値です。
	 */
	private static final long DEFAULT_LIMIT;

	static{
		innerMod = 9_223_372_006_790_004_737L;
		DEFAULT_LIMIT = 4_000_000_000_000_000_000L;
		final Montgomery64 m64 = new Montgomery64(innerMod);
		im = m64.inner();
	}

	/**
	 * H 行 W 列の、全要素が def の行列を構築します。
	 *
	 * @param height 行数
	 * @param width 列数
	 * @param def 全要素の値
	 */
	public Matrix(final int height,final int width,final long def){
		this(new long[height][width]);
		if(def!=0){
			for(final long[] mat:this.matrix){
				Arrays.fill(mat,def);
			}
		}
	}

	/**
	 * H 行 W 列の、全要素が 0 である行列を構築します。
	 *
	 * @param height 行数
	 * @param width 列数
	 */
	public Matrix(final int height,final int width){
		this(height,width,0);
	}

	/**
	 * Dimension で表される行数、列数で全要素が def の行列を構築します。
	 *
	 * @param size 行・列数
	 * @param def 全要素の値
	 */
	public Matrix(final Dimension size,final long def){
		this(size.height,size.width,def);
	}

	/**
	 * 引数の二次元配列を元に行列を構築します。<br/>
	 * 値をコピーして構築するため、引数の行列とは連動していません。
	 *
	 * @param matrix 元となる二次元配列
	 */
	public Matrix(final long[][] matrix){
		this.matrix = new long[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;++i){
			System.arraycopy(matrix[i],0,this.matrix[i],0,this.matrix[i].length);
		}
	}

	/**
	 * i 行 j 列目の要素を取得します。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 *
	 * @return i 行 j 列目の要素
	 */
	public long get(final int i,final int j){
		return this.matrix[i][j];
	}

	/**
	 * i 行 j 列目の要素を引数の値で上書きします。
	 *
	 * @param i 行番号
	 * @param j 列番号
	 * @param value 上書きする値
	 */
	public void set(final int i,final int j,final long value){
		this.matrix[i][j] = value;
	}

	/**
	 * この行列を複製します。
	 *
	 * @return この行列と等価な行列 (連動していない)
	 */
	public Matrix copy(){
		return new Matrix(this.matrix);
	}

	/**
	 * この行列の行・列数を表す Dimension を返します。
	 *
	 * @return この行列の行・列数を表す Dimension
	 */
	public Dimension size(){
		return new Dimension(this.matrix[0].length,this.matrix.length);
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。
	 *
	 * @param mat 加算する行列
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix add(final Matrix mat){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i=0;i<this.matrix.length;++i){
			for(int j=0;j<this.matrix[i].length;++j){
				ans.set(i,j,this.matrix[i][j]+mat.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。
	 *
	 * @param mat 減算する行列
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix subtract(final Matrix mat){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i=0;i<this.matrix.length;++i){
			for(int j=0;j<this.matrix[i].length;++j){
				ans.set(i,j,this.matrix[i][j]-mat.get(i,j));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。
	 *
	 * @param mat 乗算する行列
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix multiply(final Matrix mat){
		if(this.size().width!=mat.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(this.size().height,mat.size().width);
		final Dimension size = ans.size();
		final int len = this.size().width;
		for(int i=0;i<size.height;++i){
			for(int j=0;j<size.width;++j){
				long sum = 0;
				for(int k=0;k<len;++k){
					sum += this.matrix[i][k]*mat.get(k,j);
				}
				ans.set(i,j,sum);
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を加算した行列を返します。<br/>
	 * 各要素は mod で除算したあまりに変換されます。
	 *
	 * @param mat 加算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を加算した行列と等価な行列
	 */
	public Matrix modAdd(final Matrix mat,final long mod){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i=0;i<this.matrix.length;++i){
			for(int j=0;j<this.matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(this.matrix[i][j]+mat.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を減算した行列を返します。<br/>
	 * 各要素は mod で除算したあまりに変換されます。
	 *
	 * @param mat 減算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を減算した行列と等価な行列
	 */
	public Matrix modSubtract(final Matrix mat,final long mod){
		final Dimension size = this.size();
		if(!size.equals(mat.size())){
			throw new IllegalArgumentException("matrix size is not same");
		}
		final Matrix ans = new Matrix(size,0);
		for(int i=0;i<this.matrix.length;++i){
			for(int j=0;j<this.matrix[i].length;++j){
				ans.set(i,j,MathFunction.remainder(this.matrix[i][j]-mat.get(i,j),mod));
			}
		}
		return ans;
	}

	/**
	 * この行列に引数の行列を乗算した行列を返します。<br/>
	 * 各要素は mod で乗算したあまりに変換されます。
	 *
	 * @param mat 乗算する行列
	 * @param mod 法となる値
	 *
	 * @return この行列に引数の行列を乗算した行列と等価な行列
	 */
	public Matrix modMultiply(final Matrix mat,final long mod){
		if(this.size().width!=mat.size().height){
			throw new IllegalArgumentException("matrix length is not same");
		}
		final Matrix ans = new Matrix(this.size().height,mat.size().width);
		final Dimension size = ans.size();
		final int len = this.size().width;
		for(int i=0;i<size.height;++i){
			for(int k=0;k<len;++k){
				for(int j=0;j<size.width;++j){
					ans.set(i,j,MathFunction.remainder(ans.get(i,j)+this.matrix[i][k]*mat.get(k,j),mod));
				}
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
		Matrix a = original;
		Matrix multiplyValue = pw;
		while(0<exp){
			if((exp&1)==1){
				a = multiplyValue.multiply(a);
			}
			multiplyValue = multiplyValue.multiply(multiplyValue);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * 元となる行列に引数の行列を指定された回数だけ乗算します。<br/>
	 * 各要素は mod で乗算したあまりに変換されます。
	 *
	 * @param original 元となる行列
	 * @param pw 乗算する配列
	 * @param exp 乗算する回数
	 * @param mod 法となる値
	 *
	 * @return 元となる行列に引数の行列を指定された回数だけ乗算した行列と等価な行列
	 */
	public static Matrix modPow(final Matrix original,final Matrix pw,long exp,final long mod){
		Matrix a = original;
		Matrix multiplyValue = pw;
		while(0<exp){
			if((exp&1)==1){
				a = multiplyValue.modMultiply(a,mod);
			}
			multiplyValue = multiplyValue.modMultiply(multiplyValue,mod);
			exp >>= 1;
		}
		return a;
	}

	/**
	 * この行列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9,223,372,006,790,004,737) を法とした剰余環上で計算します。<br/>
	 * 4e18 を超える場合は負の値として判定するためご注意ください。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(){
		return determinant(this.matrix,DEFAULT_LIMIT);
	}

	/**
	 * この行列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9,223,372,006,790,004,737) を法とした剰余環上で計算します。<br/>
	 * limit を超える値は負の値として判定します。
	 *
	 * @return この行列の行列式
	 */
	public long determinant(final long limit){
		return determinant(this.matrix,limit);
	}

	/**
	 * 引数の二次元配列の行列式を返します。<br/>
	 * 高速化のために非常に大きい素数 (9,223,372,006,790,004,737) を法とした剰余環上で計算します。
	 *
	 * @param mat 元となる二次元配列
	 * @param limit 正の値としてあり得る最大値
	 *
	 * @return 二次元配列の行列式
	 */
	private static long determinant(final long[][] mat,final long limit){
		final int length = mat.length;
		final long[][] copiedMatrix = new long[length][];
		for(int i=0;i<length;i++){
			copiedMatrix[i] = mat[i].clone();
			ArrayUtil.mapping(copiedMatrix[i],num->num<0?im.setMontgomeryExpression(num+innerMod):im.setMontgomeryExpression(num));
		}
		long ans = im.setMontgomeryExpression(1);
		for(int i=0;i<length;i++){
			int pivot = -1;
			for(int j=i;j<length;j++){
				if(copiedMatrix[j][i]!=0){
					pivot = j;
					break;
				}
			}
			if(pivot==-1){
				ans = 0;
				break;
			}
			if(i!=pivot){
				ArrayUtil.swap(copiedMatrix,i,pivot);
				ans = innerMod-ans;
			}
			ans = im.innerMultiply(ans,copiedMatrix[i][i]);
			final long inv = im.innerPow(copiedMatrix[i][i],innerMod-2);
			for(int j=i+1;j<length;j++){
				final long num = im.innerMultiply(copiedMatrix[j][i],inv);
				for(int k=i;k<length;k++){
					copiedMatrix[j][k] -= im.innerMultiply(copiedMatrix[i][k],num);
					if(copiedMatrix[j][k]<0){
						copiedMatrix[j][k] += innerMod;
					}
				}
			}
		}
		ans = im.montgomeryReduction(ans);
		return ans>limit?ans-innerMod:ans;
	}

	/**
	 * この行列の行列式を返します。
	 *
	 * @return この行列の行列式
	 */
	public long modDeterminant(final long mod){
		return modDeterminant(this.matrix,mod);
	}

	/**
	 * 引数の二次元配列の行列式を返します。
	 *
	 * @param mat 元となる二次元配列
	 *
	 * @return 二次元配列の行列式
	 */
	private static long modDeterminant(final long[][] mat,final long mod){
		final int length = mat.length;
		final long[][] copiedMatrix = new long[length][];
		for(int i=0;i<length;i++){
			copiedMatrix[i] = mat[i].clone();
			ArrayUtil.mapping(copiedMatrix[i],num->MathFunction.remainder(num,mod));
		}
		long ans = 1;
		for(int i=0;i<length;i++){
			int pivot = -1;
			for(int j=i;j<length;j++){
				if(copiedMatrix[j][i]!=0){
					pivot = j;
					break;
				}
			}
			if(pivot==-1){
				ans = 0;
				break;
			}
			if(i!=pivot){
				ArrayUtil.swap(copiedMatrix,i,pivot);
				ans = mod-ans;
			}
			ans = ans*copiedMatrix[i][i]%mod;
			final long inv = MathFunction.modPow(copiedMatrix[i][i],mod-2,mod);
			for(int j=i+1;j<length;j++){
				final long num = copiedMatrix[j][i]*inv%mod;
				for(int k=i;k<length;k++){
					copiedMatrix[j][k] -= copiedMatrix[i][k]*num%mod;
					if(copiedMatrix[j][k]<0){
						copiedMatrix[j][k] += mod;
					}
				}
			}
		}
		return ans;
	}

	/**
	 * この行列を表す String を返します。
	 *
	 * @return この行列を表す String
	 */
	@Override
	public String toString(){
		final StringBuilder ans = new StringBuilder(this.matrix.length*this.matrix[0].length);
		ans.append(Arrays.toString(this.matrix[0]));
		for(int i=1;i<this.matrix.length;++i){
			ans.append("\n");
			ans.append(Arrays.toString(this.matrix[i]));
		}
		return ans.toString();
	}
}
