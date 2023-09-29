/**
 * Pairクラスです。
 * 比較可能な型を使用してください。
 */
package structure;

import java.util.AbstractMap;

public class Pair<K extends Comparable<K>, V extends Comparable<V>>
		implements Comparable<Pair<K, V>> {
	
	//このPairを表すEntry
	private AbstractMap.SimpleEntry<K, V> map;

	/**
	 * 引数を表すPairを生成します。
	 * @param key
	 * @param value
	 */
	public Pair ( K key, V value ) {
		map = new AbstractMap.SimpleEntry<>( key, value );
	}

	/**
	 * Keyを返します。
	 * @return
	 */
	public K getKey () {
		return map.getKey();
	}

	/**
	 * Valueを返します。
	 * @return
	 */
	public V getValue () {
		return map.getValue();
	}

	/**
	 * Keyを引数のもので置き換えます。
	 * @param key
	 * @return
	 */
	public K setKey ( K key ) {
		K oldKey = map.getKey();
		V value = map.getValue();
		map = new AbstractMap.SimpleEntry<>( key, value );
		return oldKey;
	}

	/**
	 * Valueを引数のもので置き換えます。
	 * @param value
	 * @return
	 */
	public V setValue ( V value ) {
		return map.setValue( value );
	}

	/**
	 * 引数のPairと比較します。
	 */
	@Override
	public int compareTo ( Pair<K, V> pair ) {
		int com = getKey().compareTo( pair.getKey() );
		return com != 0 ? com : getValue().compareTo( pair.getValue() );
	}

	/**
	 * 引数がこのPairと等しいか返します。
	 */
	@Override
	public boolean equals ( Object o ) {
		if ( o instanceof Pair<?, ?> pair ) {
			return getKey().equals( pair.getKey() ) && getValue().equals( pair.getValue() );
		}
		return false;
	}

	/**
	 * このPairを表すStringを返します。
	 */
	@Override
	public String toString () {
		return getKey() + "=" + getValue();
	}

	/**
	 * このPairを表すハッシュ値を返します。
	 */
	@Override
	public int hashCode () {
		return ( getKey().hashCode() << 2 ) ^ ( getValue().hashCode() );
	}
}
