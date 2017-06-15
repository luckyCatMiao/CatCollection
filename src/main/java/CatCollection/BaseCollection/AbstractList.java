package CatCollection.BaseCollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import CatCollection.XArrayList;
import CatCollection.Exception.IllegalOpeator;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;
import CatCollection.Util.ArrayTool;



public abstract class AbstractList<T> extends AbstractCollection<T> {

	

	/**
	 * 比较元素的方法
	 */
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
	
	/**
	 * 设置索引处的值
	 * @param index
	 * @return
	 */
	abstract public AbstractList<T> set(T value,int index);
	
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


	private void sort(Comparator<T> comparator)
	{
		if(getComparator()!=null)
		{
			T[] objects=toArray(Object.class);
			Arrays.sort(objects, 0, size(), comparator);

			
			for(int i=0;i<objects.length;i++)
			{
				set((T) objects[i], i);
			}
		}
	}
	
	
	

	
	@Override
	public AbstractCollection<T> add(T value) {
		super.add(value);
		sort(getComparator());
		return this;
	}
	
	
	/**
	 * 在指定位置插入
	 * @param value
	 * @param index
	 * @return
	 */
	public AbstractCollection<T> add(T value,int index) {
		checkRange(index);
		if(getComparator()!=null)
		{
			throw new IllegalOpeator("自动排序的list不能在指定位置插入数据!");
		}
		else
		{
			
		}
		return this;
	}
	
	@Override
	public AbstractCollection<T> remove(T value) {
		super.remove(value);
		return this;
	}
	
	
	
	/**
	 * 分割出子列表
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public AbstractCollection<T> subList(int startIndex,int endIndex)
	{
		//实例化当前的子类 因为该类是抽象类不能实例化
		AbstractCollection<T> list=NewInstance();
	
		checkRange(startIndex);
		checkRange(endIndex);
		if(startIndex<=endIndex)
		{
			
			
			for(int i=startIndex;i<endIndex;i++)
			{
				list.add(get(i));
			}
			
			
			
		}
		
		return list;
	}

	
	private AbstractList<T> NewInstance() {
	Class<?> class1=this.getClass();
		
		AbstractList<T> list = null;
		try {
			list = (AbstractList<T>) class1.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public AbstractList<T> reverse()
	{
		
		AbstractList<T> list=NewInstance();
		for(int i=0;i<size();i++)
		{
			list.add(get(i));
			
		}
		
		clear();
		
		
		for(int i=list.size()-1;i>=0;i--)
		{
			add(list.get(i));
			
		}
		

		
		return this;
	}

	protected void checkRange(int index) {
		if(index<0||index>size()-1)
		{
			throw new IndexOutOfRangeException(index,size());
		}
		
	}
	
	
	
}
