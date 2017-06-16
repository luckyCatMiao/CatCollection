package CatCollection.BaseCollection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 一个无法加入和删除元素的集合 只供继承使用
 * @author Administrator
 *
 * @param <T>
 */
abstract public class FixCollection<T> implements MIterable<T>{

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
	 * 浅克隆
	 * @return
	 */
	public AbstractCollection<T> shallowClone() {
		
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
	public AbstractCollection<T> deepClone() {
		
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

}
