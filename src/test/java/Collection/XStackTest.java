package Collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CatCollection.XStack;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;

public class XStackTest {
	private XStack<Integer> stack;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack=new XStack<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
			assertEquals(1, stack.push(5).size());
			stack.pop();
			assertEquals(0, stack.size(),0);
	}

	@Test
	public void testIterator() {
		stack.push(1).push(2);
		for(Integer element:stack)
		{
			assertEquals(true, element==1||element==2);
		}
		
	}

	@Test
	public void testPush() {
		assertEquals(5, stack.push(5).pop(),0);
	}

	@Test
	public void testPop() {
		assertEquals(666, stack.push(5).push(666).pop(),0);
	}

	@Test(expected = IndexOutOfRangeException.class)
	public void testPopError() {
		
		stack.push(2).pop();
		stack.pop();
	}
	@Test
	public void testPeak() {
		assertEquals(5, stack.push(5).peak(),0);
	}

}
