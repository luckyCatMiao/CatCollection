package CatCollection;


import java.util.Arrays;
import java.util.Comparator;

import CatCollection.BaseCollection.AbstractList;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Util.ArrayTool;

/**
 * 一个基于array为内部结构的list实现类
 * 
 * 该框架的另一个设计特点就是不写入一般用不到的方法!
 * 比如用初始大小初始化生成一个list
 * 
 * 另一个特点就是不考虑效率优化 考虑简洁的继承和扩展
 *比如sort 就直接卸载abstaactList里 先全部get出来成为数组 然后排序 再全部set回去 而不是在子类的
 *内部结构(比如这里的内部array)上直接操作
 *可能会慢一点 但是如果要实现一个新的treeList 就可以不用重写sort
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class XArrayList<T> extends AbstractList<T> {

	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 9181552448229759208L;

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
	transient private static int default_size=10;


	
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
	public FixCollection<T> set(T value, int index) {
		checkRange(index);
		data[index]=value;
		return this;
	}


	@Override
	public AbstractList<T> removeRange(int startIndex, int endIndex) {
		checkRange(startIndex);
		checkRange(endIndex);
		
		int length = size()-endIndex;
		System.arraycopy(data, endIndex+1, data, startIndex, length);
		
		index-=endIndex-startIndex+1;
		
		return this;
	}


	@Override
	public AbstractList<T> getRange(int startIndex, int endIndex) {
		
		checkRange(startIndex);
		checkRange(endIndex);
		
		AbstractList<T> abstractCollection=new XArrayList<>();
		for(int i=startIndex;i<=endIndex;i++)
		{
			abstractCollection.add((T) data[i]);
		}
		
		
		return abstractCollection;
	}


	public AbstractList<T> getRangeAndRemove(int startIndex, int endIndex) {
		
		
		AbstractList<T> list=getRange(startIndex, endIndex);
		removeRange(startIndex, endIndex);
		
		return list;
		
	}

	

	@Override
	protected T _realToOneValue() {
	
		return (T) data[0];
	}





	

	
	
	

}
