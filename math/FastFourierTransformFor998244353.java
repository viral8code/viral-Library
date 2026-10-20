package math;

import java.util.Arrays;
import util.ArrayUtil;

/**
 * 高速フーリエ変換の mod 998244353 バージョンです。
 */
public final class FastFourierTransformFor998244353{

	/**
	 * このクラスの法となる値 (998244353)
	 */
	private static final int mod;

	/**
	 * mod の原始根
	 */
	private static final int g;

	static{
		mod = 998_244_353;
		g = 3;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private FastFourierTransformFor998244353() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void discreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i=0,j=0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit=1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,(mod-1)>>bit,mod);
			final int subN = n>>1;
			for(int i=0;i<array.length;i+=n){
				long now = 1;
				for(int j=0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 逆離散フーリエ変換用メソッドです。<br/>
	 * 非再帰による高速フーリエ変換を実装しています。
	 */
	private static void inverseDiscreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		for(int i=0,j=0;i<array.length;i++){
			if(i<j){
				ArrayUtil.swap(array,i,j);
			}
			int bit = array.length>>1;
			while((j&bit)!=0){
				j ^= bit;
				bit >>= 1;
			}
			j ^= bit;
		}
		for(int bit=1;1<<bit<=array.length;++bit){
			final int n = 1<<bit;
			final long multiplyValue = MathFunction.modPow(g,mod-1-((mod-1)>>bit),mod);
			final int subN = n>>1;
			for(int i=0;i<array.length;i+=n){
				long now = 1;
				for(int j=0;j<subN;j++){
					final int index1 = i+j;
					final int index2 = index1+subN;
					final long u = array[index1];
					final long v = array[index2]*now%mod;
					array[index1] = u+v;
					if(mod<=array[index1]){
						array[index1] -= mod;
					}
					array[index2] = u-v;
					if(array[index2]<0){
						array[index2] += mod;
					}
					now *= multiplyValue;
					now %= mod;
				}
			}
		}
	}

	/**
	 * 渡された配列を多項式として畳み込みを行います。<br/>
	 * 配列はインデックスを i としたときに array[i] * (x ** i) と解釈します。
	 *
	 * @param array1 多項式 F
	 * @param array2 多項式 G
	 *
	 * @return F * G
	 */
	public static long[] convolution(final long[] array1,final long[] array2){
		int size = 1;
		final int length = array1.length+array2.length;
		while(size<length){
			size <<= 1;
		}
		final long[] poly1 = Arrays.copyOf(array1,size);
		final long[] poly2 = Arrays.copyOf(array2,size);
		discreteFourierTransform(poly1);
		discreteFourierTransform(poly2);
		for(int i=0;i<size;i++){
			poly1[i] *= poly2[i];
			poly1[i] %= mod;
		}
		inverseDiscreteFourierTransform(poly1);
		final long ip = MathFunction.modPow(size,mod-2,mod);
		for(int i=0;i<size;i++){
			poly1[i] *= ip;
			poly1[i] %= mod;
		}
		return poly1;
	}
}
