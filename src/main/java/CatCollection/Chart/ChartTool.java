package CatCollection.Chart;

import java.util.LinkedList;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.XStack;

public class ChartTool {

	
	/**
	 * 深度优先搜索
	 * @param chart
	 * @param startPoint
	 * @param endPoint
	 * @return
	 */
	static public <T> XStack<T> DFSSearch(XChart<T> chart,T startPoint,T endPoint)
	{
		//数据不验证了 由图自己调用的时候验证
		
		//保存当前的路径
		XStack<T> stack=new XStack<>();
		
		//保存已经访问过的节点
		XLinkedList<T> linkedList=new XLinkedList<>();
		
		//保存当前进行操作的节点
		T nowPoint=startPoint;
		
		//将初始节点压入路径
		stack.push(nowPoint);
		//设置初始节点为已访问
		linkedList.add(startPoint);
		
		
		while(true)
		{
			//System.out.println(stack);
		
		//判断当前节点是不是结束节点
		if(nowPoint.equals(endPoint))
		{
			break;
		}
		
		//找到一个没有被访问过的临接节点
		T linkPoint=GetUnVisitedLinkPoint(nowPoint,linkedList,chart);
		
		//如果该节点的所有连接节点都访问过了
		if(linkPoint==null)
		{
		
			//尝试退回到该节点的上一个节点
			
			//如果当前节点是最后一个节点
			//查找失败 返回null
			if(stack.size()==1)
			{
				
				return null;
			}
			else
			{	//回退节点
				stack.pop();
				nowPoint=stack.peak();
			}
		}
		else
		{
			//转变当前节点为连接的节点
			//设置节点已经访问
			nowPoint=linkPoint;
			
			stack.push(linkPoint);
			linkedList.add(linkPoint);
			
		}
		
		}
		
		
		return stack;
		
	}

	public static <T> T GetUnVisitedLinkPoint(T point, XLinkedList<T> hasVisited,XChart<T> chart) {
		//获取所有连接点
		XLinkedList<T> linkPoints=chart.getLinkedPoint(point);
		
		
		//找到一个没有访问过的点
		for(T value:linkPoints)
		{
			if(!hasVisited.contain(value))
			{	
				return value;
			}
		}
		
		return null;
	}
}
