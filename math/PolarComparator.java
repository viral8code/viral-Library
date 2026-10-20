package math;

import java.awt.Point;
import java.math.BigInteger;
import java.util.Comparator;

/**
 * PolarComparator です。<br/>
 * 基準点から見たときに x 軸方向を基準に反時計回りで比較します。
 */
public final class PolarComparator{

	/**
	 * 原点 (内部用)
	 */
	private static final Point ORIGIN = new Point(0,0);

	/**
	 * 呼び出さないでください。
	 *
	 * @throws UnsupportedOperationException このコンストラクタは呼び出されることを想定していません。
	 */
	private PolarComparator()throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 基準点 base からの極座標順に比較する Comparator を返します。
	 *
	 * @param base 基準点
	 *
	 * @return Comparator<Point>
	 */
	public static Comparator<Point> fromBase(final Point base){
		return (a,b)->compareFromBase(a,b,base);
	}
	
	/**
	 * 基準点 base からの極座標順に比較する Comparator を返します。<br/>
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param base 基準点
	 *
	 * @return Comparator<Point>
	 */
	public static Comparator<Point> fromBaseExact(final Point base){
		return (a,b)->compareExactFromBase(a,b,base);
	}
	
	/**
	 * 原点からの極座標順に比較します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 *
	 * @return
	 */
	public static int compare(final Point a,final Point b){
		return compareFromBase(a,b,ORIGIN);
	}
	
	/**
	 * 原点からの極座標順に比較します。<br/>
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 *
	 * @return
	 */
	public static int compareExact(final Point a,final Point b){
		return compareExactFromBase(a,b,ORIGIN);
	}
	
	/**
	 * 基準点からの極座標順に比較します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 * @param base 基準点
	 *
	 * @return
	 */
	public static int compareFromBase(final Point a,final Point b,final Point base){
		final long ax = a.x-base.x;
		final long ay = a.y-base.y;
		final long bx = b.x-base.x;
		final long by = b.y-base.y;
		final int qa = quadrant(ax,ay);
		final int qb = quadrant(bx,by);
		if(qa!=qb){
			return Integer.compare(qa,qb);
		}
		final long cross = ax*by-ay*bx;
		if(cross!=0){
			return cross>0?-1:1;
		}
		return Long.compare(ax*ax+ay*ay,bx*bx+by*by);
	}
	
	/**
	 * 基準点からの極座標順に比較します。<br/>
	 * 内部で BigInteger を用いて計算します。
	 *
	 * @param a 比較対象
	 * @param b 比較対象
	 * @param base 基準点
	 *
	 * @return
	 */
	public static int compareExactFromBase(final Point a,final Point b,final Point base){
		final long ax = a.x-base.x;
		final long ay = a.y-base.y;
		final long bx = b.x-base.x;
		final long by = b.y-base.y;
		final int qa = quadrant(ax,ay);
		final int qb = quadrant(bx,by);
		if(qa!=qb){
			return Integer.compare(qa,qb);
		}
		final BigInteger axBig = BigInteger.valueOf(ax);
		final BigInteger ayBig = BigInteger.valueOf(ay);
		final BigInteger bxBig = BigInteger.valueOf(bx);
		final BigInteger byBig = BigInteger.valueOf(by);
		final BigInteger cross = axBig.multiply(byBig).subtract(ayBig.multiply(bxBig));
		final int cmp = cross.signum();
		if(cmp!=0){
			return -cmp;
		}
		final BigInteger distA = axBig.multiply(axBig).add(ayBig.multiply(ayBig));
		final BigInteger distB = bxBig.multiply(bxBig).add(byBig.multiply(byBig));
		return distA.compareTo(distB);
	}
	
	/**
	 * 象限を返します。
	 *
	 * @param x x座標
	 * @param y y座標
	 *
	 * @return 象限
	 */
	private static int quadrant(final long x,final long y){
		if(y>0){
			if(x>0){
				return 1;
			}
			return x==0?2:3;
		}
		if(y<0){
			if(x<0){
				return 5;
			}
			return x==0?6:7;
		}
		if(x>0){
			return 0;
		}
		if(x<0){
			return 4;
		}
		return 8;
	}
}
