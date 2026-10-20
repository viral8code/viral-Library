package math;

/**
 * 高速フーリエ変換の mod 9223372006790004737 バージョンです。
 */
public final class FastFourierTransformForMegaPrime{

	/**
	 * このクラスの法となる値 (9223372006790004737)
	 */
	private static final long mod;

	/**
	 * mod の原始根
	 */
	private static final long g;

	/**
	 * 高速乗算用のモントゴメリ乗算クラスのインスタンス
	 */
	private static final Montgomery64.InnerMontgomery64 im;

	static{
		mod = 9_223_372_006_790_004_737L;
		final Montgomery64 m64 = new Montgomery64(mod);
		im = m64.inner();
		g = 3;
	}

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private FastFourierTransformForMegaPrime() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	/**
	 * 離散フーリエ変換用メソッドです。<br/>
	 * 再帰による高速フーリエ変換を実装しています。
	 */
	private static void discreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		final long[] odd = new long[array.length>>1];
		final long[] even = new long[array.length>>1];
		for(int i=0,j=1,k=0;j<array.length;i+=2,j+=2,++k){
			odd[k] = array[i];
			even[k] = array[j];
		}
		discreteFourierTransform(odd);
		discreteFourierTransform(even);
		long now = im.setMontgomeryExpression(1);
		final long multiplyValue = im.pow(g,(mod-1)/array.length);
		final int mask = odd.length-1;
		for(int i=0;i<array.length;i++){
			array[i] = (odd[i&mask]-mod)+im.innerMultiply(now,even[i&mask]);
			if(array[i]<0){
				array[i] += mod;
			}
			now = im.innerMultiply(now,multiplyValue);
		}
	}

	/**
	 * 逆離散フーリエ変換用メソッドです。<br/>
	 * 再帰による高速フーリエ変換を実装しています。
	 */
	private static void invertDiscreteFourierTransform(final long[] array){
		if(array.length==1){
			return;
		}
		final long[] odd = new long[array.length>>1];
		final long[] even = new long[array.length>>1];
		for(int i=0,j=1,k=0;j<array.length;i+=2,j+=2,++k){
			odd[k] = array[i];
			even[k] = array[j];
		}
		invertDiscreteFourierTransform(odd);
		invertDiscreteFourierTransform(even);
		long now = im.setMontgomeryExpression(1);
		final long multiplyValue = im.pow(g,mod-1-(mod-1)/array.length);
		final int mask = odd.length-1;
		for(int i=0;i<array.length;i++){
			array[i] = (odd[i&mask]-mod)+im.innerMultiply(now,even[i&mask]);
			if(array[i]<0){
				array[i] += mod;
			}
			now = im.innerMultiply(now,multiplyValue);
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
		final long[] poly1 = new long[size];
		for(int i=0;i<array1.length;i++){
			poly1[i] = im.setMontgomeryExpression(array1[i]);
		}
		final long[] poly2 = new long[size];
		for(int i=0;i<array2.length;i++){
			poly2[i] = im.setMontgomeryExpression(array2[i]);
		}
		discreteFourierTransform(poly1);
		discreteFourierTransform(poly2);
		for(int i=0;i<size;i++){
			poly1[i] = im.innerMultiply(poly1[i],poly2[i]);
		}
		invertDiscreteFourierTransform(poly1);
		final long ip = im.pow(size,mod-2);
		for(int i=0;i<size;i++){
			poly1[i] = im.innerMultiply(poly1[i],ip);
			poly1[i] = im.montgomeryReduction(poly1[i]);
		}
		return poly1;
	}
}
