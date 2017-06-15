package CatCollection.BaseCollection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import CatCollection.Annotation.CollectionFlag;
import CatCollection.Exception.NullValueException;
import CatCollection.Exception.CollectionException.OnlyValueException;

/**
 * 元素集合基类
 * @author Administrator
 *
 * @param <T>
 */
public abstract class AbstractCollection<T> implements MIterable<T>,Cloneable,Serializable {

	
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
	 * 集合内元素数量
	 * @return
	 */
	abstract public int size();
	
	
	
	
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
	 * 移除一个值 (只移除第一个找到的值)
	 * @param value
	 */
	public AbstractCollection<T> remove(T value)
	{
		flag_notNullTest(value);
		_realRemove(value);
		
		
		return this;
	}
	
	/**
	 * 集合是否为空
	 * @return
	 */
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
	
	
	/**
	 * 添加所有
	 * @param values
	 * @return
	 */
	public AbstractCollection<T> addAll(T... values)
	{
		
		for(T value:values)
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
	public AbstractCollection<T> removeAll(T... values)
	{
		
		for(T value:values)
		{
			remove(value);
		}
		
		return this;
	}

	
	/**
	 * 清空集合
	 * @return
	 */
	public AbstractCollection<T> clear() {
		
		
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
	 * 浅克隆
	 * @return
	 */
	public AbstractCollection<T> shallowClone()
	{
		
		try {
			return  (AbstractCollection<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 深克隆 使用序列化	
	 * @return
	 */
	public AbstractCollection<T> deepClone()
	{
		
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream;
		ObjectInputStream objectInputStream;
		AbstractCollection<T> t = null;
		try {
			objectOutputStream = new ObjectOutputStream(stream);
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			 objectInputStream=new ObjectInputStream(new ByteArrayInputStream(stream.toByteArray()));
			t=(AbstractCollection<T>) objectInputStream.readObject();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return t;
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


	public T[] toArray(Class<?> class1)
	{

		//这里好神奇啊  居然可以强转的过来
		//比如class1 为Object T为Integer 这样的强转居然也可以
		//Array.newInstance是一个native方法 不知道怎么实现的
		T[] arrays=(T[]) Array.newInstance(class1, size());
		int index=0;
		//数组的顺序依赖于子类实现的遍历器的遍历顺序
		for(T element:this)
		{
			arrays[index++]=element;
		}
		
		return arrays;
	}
	
}
