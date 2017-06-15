package Collection;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.geometry.partitioning.Side;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.NullValueException;
import CatCollection.Exception.CollectionException.OnlyValueException;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;
import CatCollection.Util.ArrayTool;

/**
 * 貌似junit为每个测试方法都重新创建一个类 即每次创建一个类只测试一个方法
 * 所以要想在所有方法被测试前设置一些东西只能在静态方法里而不是构造器里
 * @author Administrator
 *
 */
public class XArrayListTest {
	private AbstractList<Integer> list;
	private AbstractList<Integer> list2;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	
	@Before
	public void setUp() throws Exception {
		this.list=new XArrayList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		this.list2=new XArrayList<>(true, false);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	
	@Test
	public void testAdd() {
		
		list.add(0);
		assertEquals(list.toString(), "[5,4,3,2,1,0]");
	}
	
	
	@Test(expected  =  NullValueException.class )
	public void testAddNull() {
		
		list2.add(null);
	
	}
	@Test(expected  =  OnlyValueException.class )
	public void testAddSame() {
		
		list2.add(5);
		list2.add(5);
	
	}
	
	@Test
	public void testIndexof() {
		
	
		assertEquals(0, list.indexOf(5));
	}
	
	
	@Test
	public void testLastindexof() {
		
		
		assertEquals(4, list.lastIndexOf(5));
	}
	
	@Test
	public void testGet() {

		assertEquals(5, list.get(0),0);
	}
	
	
	 @Test(expected  =  IndexOutOfRangeException.class )
	 
	 public  void testGetError()  {
	 
	 list.get(list.size()+1);
	 list.get(-1);
	 
	 } 
	 
	
	@Test
	public void testRemove() {
	
		list.remove(3);
		assertEquals("[5,4,2,1]", list.toString());
		list.remove(2);
		assertEquals("[5,4,1]", list.toString());
		list.remove(1);
		assertEquals("[5,4]", list.toString());
		assertEquals(2, list.size());
	}
	
	@Test(expected  =  NullValueException.class )
	public void testRemoveError() {
		
		list2.remove(null);
		
	}
	
	

	@Test
	public void testSort() {
		
		list.setComparator((a,b)->a-b);
		assertEquals("[1,2,3,4,5]",list.toString() );
		
		list.add(1);
		list.add(-20);
		assertEquals("[-20,1,1,2,3,4,5]",list.toString() );
		
	}
	
	
	@Test
	public void testSublist() {
		
		
		
		assertEquals("[1,2,3]",list.reverse().subList(0, 3).toString() );
		
	}
	
	
	@Test
	public void testClear() {
	
		
		assertEquals(0,list.clear().size() );
		
	}
	
	@Test
	public void testReverse() {
	
		list.removeAll(1,2,3);
		
		assertEquals("[4,5]",list.reverse().toString());
		
	}
	
	
	@Test
	public void testShallowClone() {
	
		
		assertNotEquals(list, list.shallowClone());
		
	}
	
	@Test
	public void testDeepClone() {
		
		AbstractList<Integer> abstractList=(AbstractList<Integer>) list.deepClone().remove(5);

		assertEquals(5, list.size());
		assertEquals(4, abstractList.size());	
		assertNotEquals(list, abstractList);
	}
	
	@Test
	public void testSet() {
		assertNotEquals("[5,4,3,2,1]", list.set(6, 0).toString());
	}
	
	@Test
	public void testToArray() {
		assertEquals("[5,4,3,2,1]",ArrayTool.toString(list.toArray(),list.size()-1));
	
	
	
	
	}
	
}
