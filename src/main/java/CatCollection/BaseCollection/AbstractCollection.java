package CatCollection.BaseCollection;

import java.util.Comparator;
import java.util.Iterator;

import CatCollection.Annotation.CollectionFlag;
import CatCollection.Exception.NullValueException;
import CatCollection.Exception.CollectionException.OnlyCanCallOnceException;
import CatCollection.Exception.CollectionException.OnlyValueException;

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
	@CollectionFlag
	protected boolean flag_onlyValue=false;
	/**
	 * 是否接受null值
	 */
	@CollectionFlag
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
	 * 比较元素的方法
	 */
	protected Comparator<T> comparator;
	
	
	abstract public int size();
	
	
	@Override
	public Iterator<T> iterator() {
		
		return null;
	}
	
	/**
	 * 增加一个值
	 * 先进行flag选项的测试 测试完成后再进入真正的添加 添加过程由子类完成 但是实际调用到的add方法还是
	 * 该类的
	 * @param value
	 */
	public AbstractCollection<T> add(T value)
	{
		flag_onlyValueTest(value);
		flag_notNullTest(value);
		
		
		_realAdd(value);
		
		return this;
	}
	
	
	/**
	 * 移除一个值
	 * @param value
	 */
	public AbstractCollection<T> remove(T value)
	{
		flag_notNullTest(value);
		_realRemove(value);
		
		return this;
	}
	
	 public boolean isEmpty() {
	        return size() == 0;
	    }
	
	abstract protected void _realRemove(T value);

	abstract protected void _realAdd(T flagTest);

	
	

	private void flag_notNullTest(T value) {
		 //直接报错 该框架的特点就是及早报错
		//毕竟自己设置了唯一 又添加重复的值 这是自己的问题 不应该由框架静默处理
		
		if(!flag_canNull&&value==null)
		{
			throw new NullValueException();
		}
	}

	private void flag_onlyValueTest(T value) {
		//元素唯一而且不包含该值
		if(flag_onlyValue&&contain(value))
		{
			throw new OnlyValueException(value);
		}
	}

	/**
	 * 检测该值是否存在
	 * @param value
	 */
	public boolean contain(T value)
	{
		//如果设置了不能为null 也不能用null查询
		flag_notNullTest(value);
		
		
	     for(T elements:this)
	     {
	    	 if(elements.equals(value))
	    	 {
	    		 return true;
	    	 }
	     }
		 
	        
		return false;
	}
	

}
