package CatCollection.BaseCollection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import CatCollection.Annotation.CollectionFlag;
import CatCollection.Util.ArrayTool;

/**
 * 一个无法加入和删除元素的集合 只供继承使用
 * @author Administrator
 *
 * @param <T>
 */
abstract public class FixCollection<T> implements MIterable<T>,Cloneable,Serializable {


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
	
	public FixCollection() {
		// TODO Auto-generated constructor stub
	}
	
	public FixCollection(boolean flag_onlyValue,boolean flag_canNull) {

		this.flag_canNull=flag_canNull;
		this.flag_onlyValue=flag_onlyValue;

	};
	
	/**
	 * 集合内元素数量
	 * @return
	 */
	public abstract int size();

	/**
	 * 集合是否为空
	 * @return
	 */
	public boolean isEmpty() {
	    return size() == 0;
	}

	
	/**
	 * 转化成流(这里流框架就不自己写了 用java8的)
	 * @return
	 */
	public Stream<T> stream() {
	    return StreamSupport.stream(ssss(), false);
	}

	Spliterator<T> ssss() {
		 
		 ArrayList<T> list=new ArrayList<>();
		 this.forEach(a->list.add(a));
		 
	     return Spliterators.spliterator(list, 0);
	  }
	
	

	/**
	 * object.clone虽然让collection!=collection2 但是因为collection内部都用
	 * 引用变量(如数组)来保存元素 所以两者其实还是指向同一堆元素 
	 * 需要子类覆盖
	 * @param class1
	 * @return
	 */
	abstract public FixCollection<T> shallowClone();
		



	/**
	 * 深克隆 使用序列化	
	 * @return
	 */
	public <E extends FixCollection<T>> E deepClone(Class<E> class1) {
		
		ByteArrayOutputStream stream=new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream;
		ObjectInputStream objectInputStream;
		E t = null;
		try {
			objectOutputStream = new ObjectOutputStream(stream);
			objectOutputStream.writeObject(this);
			objectOutputStream.close();
			 objectInputStream=new ObjectInputStream(new ByteArrayInputStream(stream.toByteArray()));
			t=(E ) objectInputStream.readObject();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return t;
	}
	
	/**
	 * 深克隆 使用序列化	
	 * @return
	 */
	public FixCollection<T> deepClone() {
		
		
		return deepClone(getClass());
	}

	public T[] toArray(Class<?> class1) {
	
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ArrayTool.toString(toArray(Object.class), size());
	}
}
