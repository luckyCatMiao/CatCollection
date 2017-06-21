package CatCollection.Tree;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import CatCollection.XLinkedList;
import CatCollection.XStack;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.XChart;
import CatCollection.Exception.NullValueException;

/**
 * 多叉树 
 * @author Administrator
 *
 */
public class XTree<T> extends FixCollection<T>{
	
	
	private class TreeNode implements Serializable
	{
		
		public T value;
		public XLinkedList<TreeNode> childs=new XLinkedList<>();
		
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj.getClass()==TreeNode.class)
			{
				
				TreeNode node=(XTree<T>.TreeNode) obj;
				
				return value.equals(node.value);
			}
			
			return super.equals(obj);
		}
	}
	
	

	private TreeNode rootNode;
	

	
	
	
	public XTree() {
		
	
	};
	
	public XTree(boolean flag_onlyValue,boolean flag_canNull) {
		super(flag_onlyValue,flag_canNull);
		
		
	};
	
	
	
	@Override
	public Iterator<T> iterator() {
		
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public XTree<T> shallowClone() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public XTree<T> addNode(T value,T parent) {
		
		flag_onlyValueTest(value);
		flag_notNullTest(value);
		
		
		if(this.rootNode==null)
		{
			TreeNode node=CreateNode(value);
			this.rootNode=node;
		
		}
		else
		{
			
			TreeNode parentNode=getNodeByValue(parent);
			TreeNode node=CreateNode(value);
			parentNode.childs.add(node);
		}
		
		return this;
		
	}
	
	private XTree<T>.TreeNode getNodeByValue(T value) {
	
		//这样做明显会降低效率  不过算了 这个树就当一种抽象数据结构了
		//二叉搜索树重新写不继承这个算了 没办法
		for(TreeNode element:allTreeNodes())
		{
			if(element.value.equals(value))
			{
				return  element;
			}
		}
		
		
		throw new NullValueException();
		
	}



	private XLinkedList<TreeNode> allTreeNodes() {
		
		
		
		
		return _getNodesChilds(rootNode);
	}

	private XLinkedList<TreeNode> _getNodesChilds(TreeNode root) {
		
		XLinkedList<TreeNode> nodes=new XLinkedList<>();
		nodes.add(root);
		for(TreeNode node:root.childs)
		{
			nodes.addAll(_getNodesChilds(node));
		}
		
		
		return nodes;
	}

	private XTree<T>.TreeNode CreateNode(T value) {
		TreeNode node=new TreeNode();
		node.value=value;
		
		return node;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/**
	 * 返回更加容易看出结构的格式化字符串
	 * @return
	 */
	public String toImageString() {
		

		return getNodeString(rootNode);
	}

	/**
	 * 递归方法 获取当前节点构成的子树的字符串描述
	 * @param rootNode
	 * @return
	 */
	private String getNodeString(XTree<T>.TreeNode rootNode) {
	
		if(rootNode==null)
		{
			return "";
		}
		
	
		
		StringBuffer stringBuffer=new StringBuffer();
		//使用类似深度优先搜索的方法遍历树
		
		XStack<TreeNode> stack=new XStack<>();
		stack.push(rootNode);
		while(true)
		{
			XStack<TreeNode> stack2=new XStack<>();
			//输出当前层
			while(!stack.isEmpty())
			{
				TreeNode node=stack.pop();
				//貌似用图的特例来实现有点低效..因为我把图封装的太好了..
				//到时候把图的内部用哈希表来存储节点可能会好一些
				stringBuffer.append(node.value+" ");
				for(TreeNode child:node.childs)
				{
					stack2.push(child);
				}
			}
			stringBuffer.append("\n");
			//进行交换
			if(!stack2.isEmpty())
			{
				stack=stack2;
			}
			else
			{
				break;
			}
			
		}
		
		
		return stringBuffer.toString();
	}
	

}
