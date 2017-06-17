package CatCollection;

import java.util.Iterator;

import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Exception.UnsupportedFunctionException;

/**
 * 队列
 * @author Administrator
 *
 * @param <T>
 */
public class XQuene<T> extends FixCollection<T> {

	//内部使用数组数据
	protected XArrayList<T> data;
		
	
	public XQuene() {
		data=new XArrayList<>();
	}
	public XQuene(boolean flag_onlyValue, boolean flag_canNull) {
		data=new XArrayList<>(flag_onlyValue,flag_canNull);
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return data.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	

	public XQuene<T> push(T value)
	{
		if(data.size()==0)
		{
			data.add(value);
		}
		else
		{
			data.add(value,0);
		}
	
		
		return this ;
		
	}
	
	//返回最右边的值
	public T pop()
	{
		
		return data.getRangeAndRemove(data.size()-1, data.size()-1).toOneValue();
		
	}
	
	public T  peak() {
	
		return data.get(data.size()-1);
	}
	
	
	@Override
	public XQuene<T> shallowClone() {
		XQuene<T> quene=new XQuene<>();
		for(T element:this)
		{
			quene.push(element);
		}
		
		
		return quene;
	}
	
	
}
