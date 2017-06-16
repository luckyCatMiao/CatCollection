package CatCollection;

import java.io.Serializable;

import CatCollection.BaseCollection.AbstractList;
import CatCollection.BaseCollection.FixCollection;

/**
 * 链表(单向链表)
 * @author Administrator
 *
 * @param <T>
 */
public class XLinkedList<T> extends AbstractList<T>{

	
	
	
	/**
	 * 链表节点类
	 * @author Administrator
	 *
	 */
	private class LinkPoint<T> implements Serializable
	{
		/**
		 * 值
		 */
		public T value;
		/**
		 * 下一个节点
		 */
		public LinkPoint next;
		/**
		 * 上一个节点
		 */
		public LinkPoint last;
		@Override
		public String toString() {
			return "LinkPoint [" + (value != null ? "value=" + value : "") + "]";
		}
		
		
		
		
	}

	
	
	/**
	 * 起始点
	 */
	private LinkPoint<T> startPoint;
	
	private int size=0;
	
	public XLinkedList() {
		super();
		
	}

	public XLinkedList(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected void _realRemove(T value) {
		
		 //查找到该点
		LinkPoint<T> point=getPointByValue(value);
		if(point!=null)
		{	
			if(point.equals(startPoint))
			{
				startPoint=startPoint.next;
			}
			else
			{
				LinkPoint<T> lastPoint=point.last;
				LinkPoint<T> nextPoint=point.next;
				LinkPoint(lastPoint, nextPoint);
			}
			
			
			size--;
		}
		
	}

	/**
	 * 连接两个点
	 * @param lastPoint
	 * @param nextPoint
	 */
	private void LinkPoint(LinkPoint<T> lastPoint, LinkPoint<T> nextPoint) {
		//该点的上一个点引用到该点的下一个点
		if(lastPoint!=null)
		{
			lastPoint.next=nextPoint;
		}
		if(nextPoint!=null)
		{
			nextPoint.last=lastPoint;
		}
	}
	
	
	

	private XLinkedList<T>.LinkPoint<T> getPointByValue(T value) {
		LinkPoint<T> nowPoint=startPoint;
		while(nowPoint!=null)
		{
			if(nowPoint.value.equals(value))
			{
				return nowPoint;
			}
			nowPoint=nowPoint.next;
				
		}
		return null;
	}

	@Override
	protected void _realAdd(T value) {
		if(startPoint==null)
		{
			startPoint=new LinkPoint<>();
			startPoint.value=value;
		}
		else
		{
			//插入最后一个点的后面
			LinkPoint<T> point=new LinkPoint<>();
			point.value=value;
			
			LinkPoint<T> endPoint=getPoint(size()-1);
			LinkPoint(endPoint, point);
			
			
		}
		
		size++;
		
	}

	/**
	 * 根据索引查找点
	 * @param index
	 * @return
	 */
	private XLinkedList<T>.LinkPoint<T> getPoint(int index) 
	{
		
		checkRange(index);
		int i=0;
		
		LinkPoint<T> nowPoint=startPoint;
		while(nowPoint!=null)
		{
			if(i==index)
			{
				return nowPoint;
			}
			nowPoint=nowPoint.next;
			i++;
		}
		
		return null;
	}
	
	

	@Override
	public int size() {
		
		return size;
	}

	@Override
	protected T _realGet(int index) {
		
		
		return getPoint(index).value;
	}

	@Override
	protected void _realSet(T value, int index) {
		
		getPoint(index).value=value;
	}
	
	

}
