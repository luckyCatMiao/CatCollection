package CatCollection.BaseCollection;

import java.util.Comparator;
import java.util.Iterator;

/**
 * 元素集合基类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class AbstractCollection<T> implements MIterable<T> {

	/**
	 * 集合内的值是否可以重复
	 */
	protected boolean onlyValue;
	/**
	 * 比较元素重复的方法
	 */
	protected Comparator<T> comparator;
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 增加一个值
	 * @param value
	 */
	abstract public AbstractCollection<T> add(T value);
	
	
	/**
	 * 检测该值是否存在
	 * @param value
	 */
	public boolean contain(T value)
	{
		
		return false;
	}
	

}
