package Collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CatCollection.XQuene;
import CatCollection.XStack;

public class XQueneTest {
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
		assertEquals(1, quene.push(5).size());
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

}
