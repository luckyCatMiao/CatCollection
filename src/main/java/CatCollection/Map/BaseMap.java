package CatCollection.Map;

import java.io.Serializable;

public abstract class BaseMap<K,V> implements Serializable {

	
	public abstract V get(K key);
	public abstract BaseMap<K, V> put(K key,V value);
	public abstract BaseMap<K, V> remove(K key);
	public abstract int size();
}
