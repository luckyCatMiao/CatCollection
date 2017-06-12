package CatCollection;

import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;

/**
 * 一个基于array为内部结构的list实现类
 * @author Administrator
 *
 * @param <T>
 */
public class XArrayList<T> extends AbstractList<T> {

	
	/**
	 * 内部存储使用的array
	 */
	private T[] data;

	
	
	@Override
	public AbstractCollection<T> add(T value) {
		
		//元素唯一而且不包含该值
		if(onlyValue&&!contain(value))
		{
			
		}
		//元素不唯一
		else if(!onlyValue)
		{
			
		}
		
		
		return this;
	}
	
	
	
	

}
