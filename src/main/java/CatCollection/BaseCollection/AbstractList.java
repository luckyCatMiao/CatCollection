package CatCollection.BaseCollection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import CatCollection.XArrayList;
import CatCollection.Exception.IllegalOpeator;
import CatCollection.Exception.CollectionException.ListException.CanNotConvertToOneValueException;
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
		super();
	}
	
	/**
	 * 返回从前往后遍历的index
	 * @param value
	 * @return
	 */

	public int indexOf(T value) {
		if(getComparator()==null)
		{
		for(int i=0;i<size();i++)
		{
			if(get(i).equals(value))
			{
				return i;
			}
		}
		}
		else
		{
			//排序之后使用二分法查找索引
			return binarySearch(value);
		}
		
		return -1;
	}


	


	private int binarySearch(T target) {
		
		int downIndex=0;
		int upIndex=size()-1;
		int centerIndex;
		T centerValue;
		
		while(downIndex<=upIndex)
		{
			centerIndex=(downIndex+upIndex)/2;
			
			centerValue=get(centerIndex);
			if(centerValue.equals(target))
			{
				return centerIndex;
			}
			else if(comparator.compare(centerValue, target)>0)
			{
				upIndex=centerIndex-1;
				
			}
			else if(comparator.compare(centerValue, target)<0)
			{
				downIndex=centerIndex+1;
			}
			
			
			
		}
		
		return -1;
	}


	/**
	 * 返回从后往前遍历的index
	 * @param value
	 * @return
	 */
	public int lastIndexOf(T value) {
		
		if(getComparator()==null)
		{
			
		
		for(int i=size()-1;i>=0;i--)
		{
			if(get(i).equals(value))
			{
				return size()-i-1;
			}
		}
		}
		else
		{
			//排序之后使用二分法查找索引
			return size()-binarySearch(value);
		}
		
		return -1;
	}
	
	
	/**
	 * 索引返回值
	 * @param index
	 * @return
	 */
	 public T get(int index)
	 {
		checkRange(index);
		
		return _realGet(index);
		 
		 
	 }
	
	 protected abstract T _realGet(int index);


	/**
	  * 将只有一个值的list转换为那个值类型
	  * @return
	  */
	public  T toOneValue()
	{
		if(size()!=1)
		{
			throw new CanNotConvertToOneValueException(size()+"");
		}
		return get(0);
	}



	public AbstractList<T> getRangeAndRemove(int startIndex, int endIndex) {
		
		
		AbstractList<T> list=getRange(startIndex, endIndex);
		removeRange(startIndex, endIndex);
		
		return list;
		
	}


	/**
	 * 设置索引处的值
	 * @param index
	 * @return
	 */
	public AbstractList<T> set(int index,T value)
	{
		checkRange(index);
		 _realSet(value,index);
		return this;
	}
	
	abstract protected void _realSet(T value, int index);
	


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


	protected void sort(Comparator<T> comparator)
	{
		if(getComparator()!=null)
		{
			T[] objects=toArray(Object.class);
			Arrays.sort(objects, 0, size(), comparator);

			
			for(int i=0;i<objects.length;i++)
			{
				set(i, (T) objects[i]);
			}
		}
	}
	
	
	
	@Override
	public AbstractList<T> add(T value) {
		super.add(value);
		sort(comparator);
		return this;
	}
	
	/**
	 * 在指定位置插入
	 * @param value
	 * @param index
	 * @return
	 */
	public AbstractList<T> add(T value,int index) {
		checkRange(index);
		if(getComparator()!=null)
		{
			throw new IllegalOpeator("自动排序的list不能在指定位置插入数据!");
		}
		else
		{
			AbstractCollection<T> abstractList=getRange(index,size());
			removeRange(index, size());
			add(value);
			addAll(abstractList.toArray(Object.class));
		}
		return this;
	}
	
	public  AbstractList<T> removeRange(int startIndex, int toIndex)
	{
		checkRange(startIndex);
		checkRange(toIndex-1);
		AbstractList<T> list=NewInstance();
		list.addAll(getRange(startIndex, toIndex));
		
		for(T element:list)
		{
			remove(element);
		}
		
		
		return this;
	}
	
	public AbstractList<T> getRange(int startIndex, int toIndex)
	{
		checkRange(startIndex);
		checkRange(toIndex-1);
		AbstractList<T> list=NewInstance();
		for(int i=startIndex;i<toIndex;i++)
		{
			list.add(get(i));
		}
		
		return list;
	}


	/**
	 * 分割出子列表
	 * @param startIndex
	 * @param toIndex
	 * @return
	 */
	public AbstractList<T> subList(int startIndex,int toIndex)
	{
		//实例化当前的子类 因为该类是抽象类不能实例化
		AbstractList<T> list=NewInstance();
	
		checkRange(startIndex);
		checkRange(toIndex-1);
		if(startIndex<=toIndex)
		{
			
			
			for(int i=startIndex;i<toIndex;i++)
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

	private AbstractList<T> NewInstance(boolean flag_onlyValue, boolean flag_canNull) {
		Class<? extends AbstractList> class1=this.getClass();
			
		AbstractList<T> list = null;
			try {
				Constructor<? extends AbstractList> constructor=class1.getConstructor(boolean.class,boolean.class);
				
				list = constructor.newInstance(flag_onlyValue,flag_canNull);
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
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
	
	@Override
	public AbstractList<T> shallowClone() {
	
		AbstractList<T> list=NewInstance(flag_onlyValue, flag_canNull);
		list.setComparator(comparator);
		for(T elemnt:this)
		{
			list.add(elemnt);
		}
		
		
		
		return list;
	}


	public AbstractList<T> removeAt(int index) {
		removeRange(index, index+1);
		
		return this;
		
	}
	
	
}
