package Collection;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XArrayList;
import CatCollection.XStack;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;

@TestType(Type = XStack.class)
public class XStackTest extends FixCollectionTest{
	public XStackTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
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
		InitValue(stack);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
			assertEquals(6, stack.push(5).size());
			stack.pop();
			assertEquals(5, stack.size(),0);
	}

	@Test
	public void testIterator() {
		
		XStack<Integer> stack=new XStack<>();
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
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
	}
	@Test
	public void testPeak() {
		assertEquals(5, stack.push(5).peak(),0);
	}

	@Override
	protected void InitValue(FixCollection<Integer> collection) {
		XStack<Integer> list1=(XStack<Integer>) collection;
		
		list1.push(5);
		list1.push(4);
		list1.push(3);
		list1.push(2);
		list1.push(1);
		
	}

	public void testShallowClone() {
		assertEquals("[5,4,3,2,1,5]", stack.shallowClone().push(5).toString());
		assertEquals("[5,4,3,2,1]", stack.toString());
	}

	
}
