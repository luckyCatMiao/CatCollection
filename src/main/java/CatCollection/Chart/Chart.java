package CatCollection.Chart;

import java.util.LinkedList;

import CatCollection.XLinkedList;
import CatCollection.Chart.Exception.NotContainChartNodeException;
import CatCollection.Exception.NullValueException;

/**
 * 有向无权图
 * @author Administrator
 *
 */
public class Chart<T> {

	private class ChartNode
	{
		public T value;
		
		public XLinkedList<ChartNode> linkedNodes=new XLinkedList<>(true, false);

		@Override
		public String toString() {
		
			StringBuffer string=new StringBuffer();
			linkedNodes.forEach(a->string.append(a.value+" "));
			
			return value+":"+string.toString();
		}
		
		
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
	public Chart<T> linkNode(T value1,T value2,Boolean twoDirection)
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

	public Chart<T> addNode(T value)
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

	
}
