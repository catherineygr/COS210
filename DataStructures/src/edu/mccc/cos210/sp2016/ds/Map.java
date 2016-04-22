package edu.mccc.cos210.sp2016.ds;

public class Map<K, V> implements IMap<K, V>, Iterable<IMap.Entry<K, V>> {
	private IVector<IList<IMap.Entry<K, V>>> theVector = new VectorOnArray<>(1);
	private int size = 0;
	public Map() {
		for (int i = 0; i < theVector.getCapacity(); i++) {
			theVector.set(i, new List<IMap.Entry<K, V>>());
		}
	}
	@Override
	public boolean containsKey(K key) {
		boolean b = false;
		for (IMap.Entry<K, V> entry : this) {
			if (entry.getKey().equals(key)) {
				b = true;
				break;
			}
		}
		return b;
	}
	@Override
	public V get(K key) {
		V value = null;
		IMap.Entry<K, V> entry = new Map.Entry<K, V>(key, null);
		int index = compress(hash(entry));
		IList<IMap.Entry<K, V>> list = theVector.get(index);
		for (IMap.Entry<K, V> e : list) {
			if (e.getKey().equals(key)) {
				value = e.getValue();
				break;
			}
		}
		return value;
	}
	@Override
	public ISet<K> keySet() {
		ISet<K> keySet = new Set<>();
		for (IMap.Entry<K, V> entry : this) {
			keySet.add(entry.getKey());
		}
		return keySet;
	}
	@Override
	public void put(K key, V value) {
		if ((double) getSize() > theVector.getCapacity() * 0.7) {
			increaseCapacity();
		}
		IMap.Entry<K, V> entry = new Map.Entry<K, V>(key, value);
		int index = computeIndex(entry);
		IList<IMap.Entry<K, V>> list = theVector.get(index);
		if (!theVector.get(index).contains(entry)) {
			list.add(entry);
			size++;
		} else {
			/*java.util.Iterator<IMap.Entry<K, V>> it = list.iterator();
			while (it.hasNext()) {
				if (it.next().equals(entry)) {
							it.remove();
							list.add(entry);
				}
				
			}*/
			for (IMap.Entry<K, V> e : list) {
				if (e.equals(entry)) {
					e.setValue(entry.getValue());
				}
			}
		}
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}
	@Override
	public String toString() {
		return theVector.toString();
	}
	private int hash(IMap.Entry<K, V> entry) {
		return entry.hashCode();
	}
	private int compress(int hash) {
		return compress(hash, theVector.getSize());
	}
	private int compress(int hash, int mod) {
	    hash=((Math.abs(15485867 * hash) + 3)% 32452843);
		return hash % mod;
	}
	private int computeIndex(IMap.Entry<K, V> entry) {
		int index = compress(hash(entry));
		return index;
	}
	private void increaseCapacity() {
		IVector<IList<IMap.Entry<K, V>>> newVector = new Vector<>(theVector.getCapacity() * 2);
		for (int i = 0; i < newVector.getCapacity(); i++) {
			newVector.set(i, new List<IMap.Entry<K, V>>());
		}
		for (IMap.Entry<K, V> data : this) {
			int index = compress(hash(data), newVector.getSize());
			newVector.get(index).addFirst(data);
		}
		theVector = newVector;
	}
	public static class Entry<S, T> implements IMap.Entry<S, T> {
		private S key;
		private T value;
		public Entry(S key, T value) {
			setKey(key);
			setValue(value);
		}
		@Override
		public S getKey() {
			return key;
		}
		@Override
		public void setKey(S key) {
			this.key = key;
		}
		@Override
		public T getValue() {
			return value;
		}
		@Override
		public void setValue(T value) {
			this.value = value;
		}
		@Override
		public int hashCode() {
			int hash = getKey().hashCode();
			hash ^= (hash >>> 20) ^ (hash >>> 12);
		    hash ^= (hash>>> 7) ^ (hash>>> 4);
		    return hash;
		}
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object o) {
			if (o instanceof Map.Entry) {
				Map.Entry<S, T> that = (Map.Entry<S, T>) o;
				return this.key.equals(that.key);
			} else {
				return false;
			}
		}
		@Override
		public String toString() {
			return "{ " + getKey().toString() + " : " + getValue().toString() + " }";
		}
	}
	@Override
	public java.util.Iterator<IMap.Entry<K, V>> iterator() {
		IForwardList<IMap.Entry<K, V>> dataList = new ForwardList<>();
		for (int i = 0; i < theVector.getSize(); i++) {
			for (IMap.Entry<K, V> data : theVector.get(i)) {
				dataList.addFirst(data);
			}
		}
		return dataList.iterator();
	}
}
