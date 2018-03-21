package CatCollection.BaseCollection;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;

import CatCollection.Annotation.CollectionFlag;

/**
 * 元素集合基类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class AbstractCollection<T> extends FixCollection<T>{


	
	
	
	public AbstractCollection(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue,flag_canNull);
	}


	public AbstractCollection() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 增加一个值
	 * 先进行flag选项的测试 测试完成后再进入真正的添加 添加过程由子类完成 但是实际调用到的add方法还是
	 * 该类的
	 * @param value
	 */
	public FixCollection<T> add(T value)
	{
		flag_onlyValueTest(value);
		flag_notNullTest(value);
		
		
		_realAdd(value);
	
		
		return this;
	}
	
	
	/**
	 * 移除一个值 (只移除第一个找到的值)
	 * @param value
	 */
	public FixCollection<T> remove(T value)
	{
		flag_notNullTest(value);
		_realRemove(value);
		
		
		return this;
	}
	
	abstract protected void _realRemove(T value);

	abstract protected void _realAdd(T flagTest);

	
	

	/**
	 * 清空集合
	 * @return
	 */
	public FixCollection<T> clear() {
		while(size()>0)
		{
			for(T element:this)
			{
				remove(element);
				
			}
		}
	
		
		return this;
	}
	 
	/**
	 * 添加所有
	 * @param values
	 * @return
	 */
	public FixCollection<T> addAll(T... values)
	{
		
		for(T value:values)
		{
			add(value);
		}
		
		return this;
	}
	
	
	/**
	 * 移除所有
	 * @return
	 */
	public FixCollection<T> removeAll(FixCollection<T> collection)
	{
		
		for(T value:collection)
		{
			remove(value);
		}
		
		return this;
	}

	/**
	 * 添加所有
	 * @return
	 */
	public FixCollection<T> addAll(FixCollection<T> collection)
	{
		
		for(T value:collection)
		{
			add(value);
		}
		
		return this;
	}
	
	
	/**
	 * 移除所有
	 * @param values
	 * @return
	 */
	public FixCollection<T> removeAll(T... values)
	{
		
		for(T value:values)
		{
			remove(value);
		}
		
		return this;
	}

	
	
//	public T[] toArray()
//	{
//
//		//这里好神奇啊  居然可以强转的过来
//		//比如class1 为Object T为Integer 这样的强转居然也可以
//		//Array.newInstance是一个native方法 不知道怎么实现的
//		T[] arrays=(T[]) Array.newInstance(Object.class, size());
//		int index=0;
//		//数组的顺序依赖于子类实现的遍历器的遍历顺序
//		for(T element:this)
//		{
//			arrays[index++]=element;
//		}
//		//发现好像不行。。 虽然可以编译 但是实际调用后上又报错了 还是Object类型??不知道什么鬼
//		return arrays;
//	}


	public FixCollection<T> addAll(Collection<T> collect) {
		
		for(T element:collect)
		{
			
			add(element);
		}
			
		return this;
	}


	
}
