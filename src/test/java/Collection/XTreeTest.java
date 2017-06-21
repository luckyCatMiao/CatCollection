package Collection;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import CatCollection.Tree.XTree;
import CatCollection.Tree.XBinaryTree;
public class XTreeTest {
	private XTree<Integer> tree1;

	@Before
	public void Before()
	{
		this.tree1=new XTree<>();
		tree1.addNode(3,null);
		
		tree1.addNode(2, 3);
		tree1.addNode(1, 3);
		
		tree1.addNode(4, 2);
		tree1.addNode(6, 2);
		
		tree1.addNode(10, 1);
		tree1.addNode(7, 1);
	
		
	}
	
	@Test
	public void TestAdd()
	{
		
	}
	
	@Test
	public void testGetChildSize()
	{
		
	}
	
	@Test
	public void TestImageString()
	{
		System.out.println(tree1.toImageString());
		
		
	}
}
