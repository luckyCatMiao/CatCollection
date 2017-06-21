package Collection;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import CatCollection.Map.XHashMap;

public class XHashMapTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private XHashMap<String,Integer> map;

	@Before
	public void setUp() throws Exception {
		
		this.map=new XHashMap<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		map.put("1", 1);
		
		assertEquals(1, map.get("1"),0);
	}

	@Test
	public void testPut() {
		map.put("1", 1);
		
		assertEquals("[ 1:1 ]", map.toString());
		
		
	}

	@Test
	public void testRemove() {
		map.put("1", 1);
		map.remove("1");
		assertEquals(null, map.get("1"));
		
	}

	@Test
	public void testRehash() {
		map.put("1", 1);
		//测试重新扩充哈希化之后的map
		for(int i=2;i<10000;i++)
		{
			map.put(i+"", i);
		}
		
		
		assertEquals(1, map.get("1"),0);
	}
}
