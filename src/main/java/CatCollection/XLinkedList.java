package CatCollection;

import java.io.Serializable;
import java.util.Iterator;

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
	 *  抽象List基类里面的迭代实现是用的get 对于链表来说效率很低 这边重写一个迭代器
	 * @author Administrator

	 */
	private class LinkedListIterator implements Iterator<T> {

		private XLinkedList<T>.Point point;

		public LinkedListIterator() {
			
			point=startPoint;
			
		}
		
		@Override
		public boolean hasNext() {
	
			
			return point!=null;
		}

		@Override
		public T next() {
			T value=point.value;
			point=point.next;
			
			return value;
			
		}

	}

	/**
	 * 链表节点类
	 * @author Administrator
	 *
	 */
	private class Point implements Serializable
	{
		/**
		 * 值
		 */
		public T value;
		/**
		 * 下一个节点
		 */
		public Point next;
		/**
		 * 上一个节点
		 */
		public Point last;
		@Override
		public String toString() {
			return "LinkPoint [" + (value != null ? "value=" + value : "") + "]";
		}
		
		
		
		
	}

	@Override
	/**
	 * 抽象List基类里面的迭代实现是用的get 对于链表来说效率很低 这边重写一个迭代器
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
		
	}
	
	
	
	/**
	 * 起始点
	 */
	private Point startPoint;
	
	
	private int size=0;
	
	public XLinkedList() {
		super();
		
	}

	/**
	 * 
	 * @param flag_onlyValue
	 * @param flag_canNull
	 */
	public XLinkedList(boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected void _realRemove(T value) {
		
		 //查找到该点
		Point point=getPointByValue(value);
		if(point!=null)
		{	
			if(point.equals(startPoint))
			{
				startPoint=startPoint.next;
			}
			else
			{
				
				Point lastPoint=point.last;
				Point nextPoint=point.next;
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
	private void LinkPoint(Point lastPoint, Point nextPoint) {
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
	
	
	

	private XLinkedList<T>.Point getPointByValue(T value) {
		Point nowPoint=startPoint;
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
			startPoint=new Point();
			startPoint.value=value;
		}
		else
		{
			//插入最后一个点的后面
			Point point=new Point();
			point.value=value;
			
			Point endPoint=getPoint(size()-1);
			LinkPoint(endPoint, point);
			
			
		}
		
		size++;
		
	}

	/**
	 * 根据索引查找点
	 * @param index
	 * @return
	 */
	private XLinkedList<T>.Point getPoint(int index) 
	{
		
		checkRange(index);
		int i=0;
		
		Point nowPoint=startPoint;
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
