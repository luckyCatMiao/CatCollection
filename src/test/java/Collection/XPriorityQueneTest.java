package Collection;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XPriorityQuene;
import CatCollection.XQuene;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Util.ArrayTool;


public class XPriorityQueneTest{

	public XPriorityQueneTest() throws Exception {
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
	}

	@Test
	public void testPush() {
		XPriorityQuene<Integer> quene=new XPriorityQuene<>((a,b)->a-b);
		
		quene.push(5);
		quene.push(10);
		quene.push(3);
		quene.push(0);
		assertEquals("[0,3,5,10]", ArrayTool.toString(quene.toArray(Integer.class)));
		
		
	}



}
