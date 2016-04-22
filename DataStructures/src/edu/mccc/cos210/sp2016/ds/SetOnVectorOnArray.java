package edu.mccc.cos210.sp2016.ds;

public class SetOnVectorOnArray<E> implements ISet<E>, Iterable<E> {
	private IVector<IList<E>> theVector = new VectorOnArray<>(10);
	private int size = 0;
	public SetOnVectorOnArray() {
		for (int i = 0; i < theVector.getCapacity(); i++) {
			theVector.set(i, new List<E>());
		}
	}
	private void increaseCapacity() {
		IVector<IList<E>> newVector = new VectorOnArray<>(theVector.getCapacity() * 2);
		for (int i = 0; i < newVector.getCapacity(); i++) {
			newVector.set(i, new List<E>());
		}
		for (E data : this) {
			int index = compress(hash(data), newVector.getSize());
			newVector.get(index).addFirst(data);
		}
		theVector = newVector;
	}
	private int hash(E data) {
		int hash = data.hashCode();
		hash ^= (hash >>> 20) ^ (hash >>> 12);
	    hash ^= (hash>>> 7) ^ (hash>>> 4);
	    return hash;
	}
	private int compress(int hash) {
		return compress(hash, theVector.getSize());
	}
	private int compress(int hash, int mod) {
		hash=((Math.abs(15485867 * hash) + 3)% 32452843);
		return hash % mod;
	}
	@Override
	public void add(E data) {
		if ((double) getSize() > theVector.getCapacity() * 0.7) {
			increaseCapacity();
		}
		int index = compress(hash(data));
		if (!theVector.get(index).contains(data)) {
			theVector.get(index).addFirst(data);
			size++;
		}
	}
	@Override
	public void add(ISet<E> set) {
		for (E data : set) {
			add(data);
		}
	}
	@Override
	public void remove(E data) {
		for (int i = 0; i < theVector.getSize(); i++) {
			java.util.Iterator<E> listIterator = theVector.get(i).iterator();
			while (listIterator.hasNext()) {
				if (listIterator.next().equals(data)) {
					listIterator.remove();
					size--;
					break;
				}
			}
		}
	}
	@Override
	public boolean contains(E data) {
		int index = compress(hash(data));
		return theVector.get(index).contains(data);
	}
	@Override
	public boolean contains(ISet<E> set) {
		boolean b = false;
		for (E data : set) {
			b = contains(data);
			if (!b) {
				break;
			}
		}
		return b;
	}
	@Override
	public ISet<E> union(ISet<E> set) {
		ISet<E> unionset = new SetOnVectorOnArray<E>();
		unionset.add(this);
		unionset.add(set);
		return unionset;
	}
	@Override
	public ISet<E> intersection(ISet<E> set) {
		ISet<E> intersection = new SetOnVectorOnArray<E>();
		
		for (E data : this) {
			if (set.contains(data)) {
			intersection.add(data);	
			}	
		}
		
		return intersection;
	}
	@Override
	public ISet<E> difference(ISet<E> set) {
		ISet<E> difference = new SetOnVectorOnArray<E>();
		
		for (E data : this) {
			if (!set.contains(data)) {
			difference.add(data);	
			}
		}
		for (E data : set) {
				if (!this.contains(data)) {
				difference.add(data);	
				}	
		}
		return difference;
	}
	@Override
	public int getSize() {
		return this.size;
	}
	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}
	@Override
	public String toString() {
		return getSize() + " " + theVector.toString();
	}
	@Override
	public java.util.Iterator<E> iterator() {
		IForwardList<E> dataList = new ForwardList<>();
		for (int i = 0; i < theVector.getSize(); i++) {
			for (E data : theVector.get(i)) {
				dataList.addFirst(data);
			}
		}
		return dataList.iterator();
	}
}
