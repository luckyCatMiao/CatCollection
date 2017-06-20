package CatCollection.Tree;

import java.util.Iterator;

import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.XChart;

/**
 * 树 这里实现为图的特例(内部使用图存储数据)
 * @author Administrator
 *
 */
public class XTree<T> extends AbstractCollection<T>{
	
	

	
	private T root;
	private XChart<T> chart;

	public XTree() {

		chart=new XChart<>();
	};
	
	public XTree(boolean flag_onlyValue,boolean flag_canNull) {

		super(flag_onlyValue,flag_canNull);
		chart=new XChart<>(flag_onlyValue,flag_canNull);

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void _realRemove(T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _realAdd(T flagTest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FixCollection<T> shallowClone() {
		// TODO Auto-generated method stub
		return null;
	};
	
	public XTree<T> addNode(T root) {
		if(root==null)
		{
			this.root=root;
		}
		else
		{
			
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
		// TODO Auto-generated method stub
		return null;
	}
	

}
