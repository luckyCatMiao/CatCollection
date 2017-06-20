package Collection;

import org.junit.Before;
import org.junit.Test;

import CatCollection.Tree.XTreeList;

public class XTreeListTest {

	
	private XTreeList<Integer> tree1;

	@Before
	public void Before()
	{
		this.tree1=new XTreeList<>();
		tree1.add(3);
		tree1.add(2);
		tree1.add(1);
		tree1.add(5);
		tree1.add(4);
	}
	
	@Test
	public void TestAdd()
	{
		
		
		
	}
	
	@Test
	public void TestImageString()
	{
		System.out.println(tree1.toImageString());
		
		
	}
	
	
}
