package CatCollection.Chart;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.XStack;
import CatCollection.Annotation.CollectionFlag;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.Exception.NotContainChartNodeException;
import CatCollection.Exception.NullValueException;

/**
 * 有向无权图
 * @author Administrator
 *
 */
public class XChart<T> extends FixCollection<T>{

	
	private class ChartNode implements Serializable
	{
		public T value;
		
		public XLinkedList<ChartNode> linkedNodes=new XLinkedList<>(true, false);

		@Override
		public String toString() {
		
			StringBuffer string=new StringBuffer();
			linkedNodes.forEach(a->string.append(a.value+" "));
			
			return value+":"+string.toString();
		}

		/**
		 * 只返回T值
		 * @return
		 */
		public XLinkedList<T> toValueLinkedList() {
			XLinkedList<T> linkedList=new XLinkedList<>();
			for(ChartNode node:linkedNodes)
			{
				linkedList.add(node.value);
			}
			
			
			
			return linkedList;
		}
		
		
	}
	
	
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
	
	
	public XChart() {
		linkedList=new XLinkedList<>();
	}
	public XChart(boolean flag_onlyValue, boolean flag_canNull) {
		
		super(flag_onlyValue,flag_canNull);
		linkedList=new XLinkedList<>(flag_onlyValue,flag_canNull);
	}
	
	
	
	/**
	 * 使用链表保存所有节点
	 */
	private XLinkedList<ChartNode> linkedList=new XLinkedList<>();
	
	/**
	 * 连接两个节点(节点必须已经添加到图中)
	 * @param value1
	 * @param value2
	 * @param twoDirection
	 * @return
	 */
	public XChart<T> linkNode(T value1,T value2,Boolean twoDirection)
	{
		ChartNode node1=CheckContainNode(value1);
		ChartNode node2=CheckContainNode(value2);
		
		node1.linkedNodes.add(node2);
		if(twoDirection)
		{
			node2.linkedNodes.add(node1);
		}
		
		
		return this;
	}
	
	private ChartNode CheckContainNode(T value) {
		if(value==null)
		{
			throw new NullValueException();
		}
		else
		{
			boolean has=false;
			for(ChartNode element:linkedList)
			{
				if(element.value.equals(value))
				{
					has=true;
					return element;
				}
			}
			
			if(!has)
			{
				throw new NotContainChartNodeException(value);
			}
		}
		return null;
		
	}

	public XChart<T> addNode(T value)
	{
		ChartNode node=new ChartNode();
		node.value=value;
		linkedList.add(node);
		return this;
	}
	
	
	
	@Override
	public String toString() {
		StringBuffer stringBuffer=new StringBuffer();
		for(ChartNode element:linkedList)
		{
			stringBuffer.append(element.toString()+"\n");
		}
		
		
		return stringBuffer.toString();
	}
	
	
	/**
	 * 转换为一张可视化的image
	 */
	public void toImage() {
		throw new UnsupportedOperationException();

	}

	
	public XStack<T> Search(T startPoint,T endPoint)
	{
		
		CheckContainNode(startPoint);
		CheckContainNode(endPoint);
		
		return ChartTool.DFSSearch(this, startPoint, endPoint);
	}

	public XLinkedList<T> getLinkedPoint(T value) {
		CheckContainNode(value);
		
		
		for(ChartNode node:linkedList)
		{
			if(node.value.equals(value))
			{
				return node.toValueLinkedList();
			}
		}
		
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		
		XArrayList<T> list = getValueList();
		
		return list.iterator();
	}

	private XArrayList<T> getValueList() {
		XArrayList<T> list=new XArrayList<>();
		
		for(ChartNode n:linkedList)
		{
			list.add(n.value);
		}
		return list;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedList.size();
	}

	@Override
	public FixCollection<T> shallowClone() {
		
		throw new UnsupportedOperationException();
	}
	
}
