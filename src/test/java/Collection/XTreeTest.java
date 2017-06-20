package Collection;

import org.junit.Before;
import org.junit.Test;

import CatCollection.Tree.XTree;
import CatCollection.Tree.XTreeList;

public class XTreeTest {
	private XTree<Integer> tree1;

	@Before
	public void Before()
	{
		this.tree1=new XTree<>();
	
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
