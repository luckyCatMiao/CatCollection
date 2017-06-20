package CatCollection.Tree;

import java.util.Iterator;

import CatCollection.XStack;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.XChart;

/**
 * 树 这里实现为图的特例(内部使用图存储数据)
 * @author Administrator
 *
 */
public class XTree<T> extends FixCollection<T>{
	
	

	
	private T root;
	private XChart<T> chart;

	
	/**
	 * 树强制不能输入空值和重复值 一旦可以输入 就要进行多余的判断 完全失去了树的性能优势
	 *因此强制不能插入空值和重复值
	 */
	public XTree() {

		
		chart=new XChart<>(true,false);
	};
	
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return chart.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return chart.size();
	}

	@Override
	public XTree<T> shallowClone() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public XTree<T> addNode(T value,T root) {
		if(this.root==null)
		{
			this.root=value;
			chart.addNode(value);
		}
		else
		{
			chart.addNode(value);
			chart.linkNode(root, value, false);
		}
		
		return this;
		
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
		

		return getNodeString(root);
	}

	/**
	 * 递归方法 获取当前节点构成的子树的字符串描述
	 * @param node
	 * @return
	 */
	private String getNodeString(T node) {
	
		if(node==null)
		{
			return "";
		}
		
	
		
		StringBuffer stringBuffer=new StringBuffer();
		//使用类似深度优先搜索的方法遍历树
		
		XStack<T> stack=new XStack<>();
		stack.push(node);
		while(true)
		{
			XStack<T> stack2=new XStack<>();
			//输出当前层
			while(!stack.isEmpty())
			{
				T value=stack.pop();
				//貌似用图的特例来实现有点低效..因为我把图封装的太好了..
				//到时候把图的内部用哈希表来存储节点可能会好一些
				stringBuffer.append(value+" ");
				for(T child:chart.getLinkedPoint(value))
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
