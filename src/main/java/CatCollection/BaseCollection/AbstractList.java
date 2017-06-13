package CatCollection.BaseCollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import CatCollection.Util.ArrayTool;



public abstract class AbstractList<T> extends AbstractCollection<T> {

	
	protected Comparator<T> comparator;
	
	private class ListIterator<T> implements Iterator<T> {

		int index=-1;
		
		@Override
		public boolean hasNext() {
			
			
			return (++index)<size();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return (T) get(index);
		}

	}
	
	

	public AbstractList(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		// TODO Auto-generated constructor stub
	}

	
	public AbstractList()
	{
		
	}
	
	/**
	 * 返回从前往后遍历的index
	 * @param value
	 * @return
	 */
	abstract public int indexOf(T value);
	

	/**
	 * 返回从后往前遍历的index
	 * @param value
	 * @return
	 */
	abstract public int lastIndexOf(T value);
	
	
	/**
	 * 索引返回值
	 * @param value
	 * @return
	 */
	abstract public T get(int index);
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>();
		
	}


	public Comparator<T> getComparator() {
		return comparator;
	}


	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
		sort(comparator);
	}


	abstract protected void sort(Comparator<T> comparator);


	
	@Override
	public AbstractCollection<T> add(T value) {
		super.add(value);
		sort(getComparator());
		return this;
	}
	
	@Override
	public AbstractCollection<T> remove(T value) {
		super.remove(value);
		sort(getComparator());
		return this;
	}
	
	
}
