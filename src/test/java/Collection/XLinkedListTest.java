package Collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.BaseCollection.FixCollection;

@TestType(Type = XLinkedList.class)
public class XLinkedListTest extends AbstractListTest {

	public XLinkedListTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	

	@Override
	protected void InitValue(FixCollection<Integer> collection) {
		XLinkedList<Integer> list1=(XLinkedList<Integer>) collection;
		
		list1.add(5);
	
		list1.add(4);
		
		list1.add(3);
		
		list1.add(2);
		
		list1.add(1);
		
	}
	

	

}
