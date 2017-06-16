package Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.math3.geometry.partitioning.Side;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;
import CatCollection.Util.ArrayTool;

public abstract class AbstractListTest extends AbstractionCollectionTest {

	
	private AbstractList<Integer> list1;
	private FixCollection<Integer> list2;
	
	
	public AbstractListTest() throws Exception {
	//生成为父类的同名类型
	//获取运行时子类
		Class<?> childClass=this.getClass().getAnnotation(TestType.class).Type();
	Constructor<?> constructor1=childClass.getConstructor();
	Constructor<?> constructor2=childClass.getConstructor(boolean.class,boolean.class);
	
	list1=(AbstractList<Integer>) constructor1.newInstance();
	list2=(FixCollection<Integer>) constructor2.newInstance(true,false);
	 
	InitValue(list2);
	InitValue(list1);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndexof() {
		
	
		assertEquals(0, list1.indexOf(5));
		assertEquals(2, list1.indexOf(3));
		assertEquals(-1, list1.indexOf(50));
	}

	@Test
	public void testLastindexof() {
		
		
		assertEquals(4, list1.lastIndexOf(5));
	}

	@Test
	public void testGet() {
	
		assertEquals(5, list1.get(0),0);
		assertEquals(1, list1.get(list1.size()-1),0);
	}

	@Test(expected = IndexOutOfRangeException.class)
	public void testGetError() {
	
	 list1.get(list1.size()+1);
	 list1.get(-1);
	
	 }

	@Test
	public void testSort() {
		
		list1.setComparator((a,b)->a-b);
		assertEquals("[1,2,3,4,5]",list1.toString() );
		
		list1.add(1);
		list1.add(-20);
		assertEquals("[-20,1,1,2,3,4,5]",list1.toString() );
		
	}

	@Test
	public void testSublist() {
		
	
		assertEquals("[1,2,3]",list1.reverse().subList(0, 3).toString() );
		
	}

	@Test
	public void testReverse() {
	
		list1.removeAll(1,2,3);
		
		assertEquals("[4,5]",list1.reverse().toString());
		
	}

	@Test
	public void testSet() {
		
		assertEquals("[6,4,3,2,1]", list1.set(6, 0).toString());
	}
	
	
	@Test
	public void testAddAt() {
		assertEquals("[0,5,4,3,2,1]", list1.add(0, 0).toString());
		assertEquals("[0,5,6,4,3,2,1]", list1.add(6, 2).toString());
	}

	@Test
	public void testRemoveRange() {
		assertEquals("[3,2,1]", list1.removeRange(0, 1).toString());
	}
	
	@Test
	public void testRemove() {
		
		
		assertEquals("[4,3,2,1]", list1.remove(5).toString());
	}
	
	
	@Test
	public void testgetRange() {
		assertEquals("[5,4,3]", list1.getRange(0, 2).toString());
	}
	
	@Test
	public void testToOneValue() {
		assertEquals(5, list1.get(0),0);
	}
	
	@Test
	public void testSize() {
		
		
		assertEquals(6,list1.add(7).size());
	
		assertEquals(5,list1.remove(7).size());
	
	}
	
}
