package CatCollection;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Iterator;
import java.util.Stack;

import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Exception.UnsupportedFunctionException;

public class XStack<T> extends FixCollection<T>{

	
	//内部使用数组存储数据
	private XArrayList<T> data;
	
	
	public XStack() {
		data=new XArrayList<>();
	}
	public XStack(boolean flag_onlyValue, boolean flag_canNull) {
		data=new XArrayList<>(flag_onlyValue,flag_canNull);
	}
	@Override
	public Iterator<T> iterator() {
		
		return data.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}

	

	
	
	public XStack<T> push(T value)
	{
		data.add(value);
		
		return this ;
	}
	
	public T pop()
	{
		
		
		return data.getRangeAndRemove(data.size()-1, data.size()-1).toOneValue();
		
	}
	
	public T  peak() {
	
		return data.get(data.size()-1);
	}
	
	

}
