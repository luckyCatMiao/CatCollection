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
	private Object[] data;

	/**
	 * 内部的索引
	 */
	private int index=-1;
	
	
	/**
	 * 默认的数组大小
	 */
	private static int default_size=10;


	
	public XArrayList() {
		this(default_size);
	}
	
	/**
	 * 以一个初始大小初始化list
	 * @param size
	 */
	public XArrayList(int size) {
		InitInnerArray(size);
	}
	
	/**
	 * 初始化内部数组
	 * @param size
	 */
	private void InitInnerArray(int size) {
		this.data=new Object[size];
		
	}

	/**
	 * 使用参数初始化list
	 * @param flag_onlyValue
	 * @param flag_canNull
	 */
	public XArrayList(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		InitInnerArray(size());
	}
	
	
	@Override
	public AbstractCollection<T> add(T value) {
		
		//元素唯一而且不包含该值
		if(flag_onlyValue&&!contain(value))
		{
			
		}
		//元素不唯一
		else if(!flag_onlyValue)
		{
			
		}
		else
		{
		 //直接报错 该框架的特点就是及早报错
		//毕竟自己设置了唯一 又添加重复的值 这是自己的问题 不应该由框架静默处理
		}
		
		
		return this;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
