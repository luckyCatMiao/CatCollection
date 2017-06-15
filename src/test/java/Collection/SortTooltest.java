package Collection;
import static org.junit.Assert.*;
import org.junit.Test;

import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Util.SortTool;

public class SortTooltest {

	private AbstractList<Integer> list1;
	
	
	public SortTooltest() {
		list1=new XArrayList<>();
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		
	}
	
	
	
	
	@Test
	public void testBubbleSort()
	{
		
		assertEquals("[1,2,3,4,5]", SortTool.BubbleSort(list1, (a,b)->a-b).toString());
		
	}
	
	@Test
	public void testSelectSort()
	{
		assertEquals("[1,2,3,4,5]", SortTool.SelectSort(list1, (a,b)->a-b).toString());
	}
	
}
