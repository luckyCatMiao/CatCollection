package Collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XQuene;
import CatCollection.XStack;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.XChart;

@TestType(Type = XQuene.class)
public class XQueneTest extends FixCollectionTest{
	
	public XQueneTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	private XQuene<Integer> quene=new XQuene<>();
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
	}

	@Test
	public void testSize() {
		assertEquals(1, quene.push(5).shallowClone().size());
	}

	@Test
	public void testIterator() {
		
	}

	@Test
	public void testPush() {
		assertEquals(2, quene.push(5).push(4).size());
	}

	@Test
	public void testPop() {
		assertEquals(5, quene.push(5).push(4).pop(),0);
	}

	@Test
	public void testPeak() {
		assertEquals(5, quene.push(5).push(4).pop(),0);
	}

	@Override
	protected void InitValue(FixCollection<Integer> collection) {
	XQuene<Integer> list1=(XQuene<Integer>) collection;
	
	
		list1.push(1);
		list1.push(2);
		list1.push(3);
		list1.push(4);
		list1.push(5);
		
		
		
		
		
	}

	
	@Override
	public void addValue(FixCollection<Integer> collection, int value) {
	
		
	}
	
	public void testShallowClone() {
		InitValue(quene);
		assertEquals("[5,4,3,2,1]", quene.shallowClone().toString());
		assertEquals("[5,5,4,3,2,1]", quene.shallowClone().push(5).toString());
	}
	
	
}
