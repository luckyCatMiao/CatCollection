package CatCollection;


import java.util.Arrays;
import java.util.Comparator;

import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;
import CatCollection.Util.ArrayTool;

/**
 * 一个基于array为内部结构的list实现类
 * 
 * 该框架的另一个设计特点就是不写入一般用不到的方法!
 * 比如用初始大小初始化生成一个list
 * @author Administrator
 *
 * @param <T>
 */
public class XArrayList<T> extends AbstractList<T> {

	
	


	/**
	 * 内部存储使用的array
	 */
	private Object[] data;

	/**
	 * 内部的索引
	 */
	private int index=-1;
	
	
	/**
	 * 默认的数组大小
	 */
	private static int default_size=10;


	
	public XArrayList() {
		InitInnerArray(default_size);
	}
	
	
	/**
	 * 初始化内部数组
	 * @param size
	 */
	private void InitInnerArray(int size) {
		this.data=new Object[size];
		
	}

	/**
	 * 使用参数初始化list
	 * @param flag_onlyValue
	 * @param flag_canNull
	 */
	public XArrayList(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		InitInnerArray(size());
	}
	
	
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return index+1;
	}

	@Override
	protected void _realAdd(T value) {
		ensureCapability(1);
		
		data[++index]=value;
	}

	
	/**
	 * 自动扩充内部数组 确保大小合适
	 * @param i
	 */
	private void ensureCapability(int i) {
		
		int newSize=i+size();
		//扩充数组直到数组的size可以容纳下新size
		while(data.length<newSize)
		{
			expandArray();
		}
		
		
	}


	/**
	 * 扩充数组 采用的扩充法是oldSize*2+5
	 */
	private void expandArray() {
		data=java.util.Arrays.copyOf(data, data.length*2+5);
		
	}
	
	@Override
	public String toString() {
	
		
		
		return ArrayTool.toString(data,index);
	}


	@Override
	protected void _realRemove(T value) {
		
		int i;
		if((i=indexOf(value))!=-1)
		{
			System.arraycopy(data, i+1, data, i, size()-i);
			index--;
		}
		
	}



	@Override
	public int indexOf(T value) {
		for(int i=0;i<size();i++)
		{
			if(data[i]==value)
			{
				return i;
			}
		}
		
		return -1;
	}


	@Override
	public int lastIndexOf(T value) {
		
		for(int i=size()-1;i>=0;i--)
		{
			if(data[i]==value)
			{
				return size()-i-1;
			}
		}
		
		return -1;
	}


	@Override
	public T get(int index) {
		checkRange(index);
		
		
		return (T) data[index];
	}


	private void checkRange(int index) {
		if(index<0||index>size()-1)
		{
			throw new IndexOutOfRangeException(index,size());
		}
		
	}


	/**
	 * 进行排序
	 * @param comparator
	 */
	protected void sort(Comparator<T> comparator) {
		
		if(comparator!=null)
		{
			Arrays.sort((T[])data, 0, size(), comparator);

		}
	}
	

	
	
	

}
