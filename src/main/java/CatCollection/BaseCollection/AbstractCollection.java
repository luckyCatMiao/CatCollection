package CatCollection.BaseCollection;

import java.util.Comparator;
import java.util.Iterator;

import CatCollection.Exception.OnlyCanCallOnceException;

/**
 * 元素集合基类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class AbstractCollection<T> implements MIterable<T> {

	
	/**
	 * 为了保持内部状态的前后一致性 这些集合配置参数只能在创建时输入 之后就是只读状态
	 * 如果不是只读 例如刚开始接受null之后不接受null 可能会造成混乱
	 * 
	 * 
	 */
	/**
	 * 集合内的值是否可以重复
	 */
	protected boolean flag_onlyValue=true;
	/**
	 * 是否接受null值
	 */
	protected boolean flag_canNull=true;
	

	
//--------------------------------------------------------------------------------------
	
	public AbstractCollection()
	{
		
	}
	
	public AbstractCollection(boolean flag_onlyValue,boolean flag_canNull) {

			this.flag_canNull=flag_canNull;
			this.flag_onlyValue=flag_onlyValue;

	};
	
	
	
	/**
	 * 比较元素重复的方法
	 */
	protected Comparator<T> comparator;
	
	
	abstract public int size();
	
	
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
