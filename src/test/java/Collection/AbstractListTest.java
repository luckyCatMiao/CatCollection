package Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;

public class AbstractListTest extends AbstractionCollectionTest {

	
	AbstractList<Integer> collection1;
	AbstractList<Integer> collection2;
	
	
	public AbstractListTest() throws Exception {
	//生成为父类的同名类型
	//获取运行时子类
	Class<?> childClass=this.getClass().getDeclaredField("collection1").getType();
	Constructor<?> constructor1=childClass.getConstructor();
	Constructor<?> constructor2=childClass.getConstructor(boolean.class,boolean.class);
	
	collection1=(AbstractList<Integer>) constructor1.newInstance();
	collection2=(AbstractList<Integer>) constructor2.newInstance(true,false);
	 
	collection1.add(5);
	collection1.add(4);
	collection1.add(3);
	collection1.add(2);
	collection1.add(1);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndexof() {
		
	
		assertEquals(0, collection1.indexOf(5));
	}

	@Test
	public void testLastindexof() {
		
		
		assertEquals(4, collection1.lastIndexOf(5));
	}

	@Test
	public void testGet() {
	
		assertEquals(5, collection1.get(0),0);
	}

	@Test(expected = IndexOutOfRangeException.class)
	public void testGetError() {
	
	 collection1.get(collection1.size()+1);
	 collection1.get(-1);
	
	 }

	@Test
	public void testSort() {
		
		collection1.setComparator((a,b)->a-b);
		assertEquals("[1,2,3,4,5]",collection1.toString() );
		
		collection1.add(1);
		collection1.add(-20);
		assertEquals("[-20,1,1,2,3,4,5]",collection1.toString() );
		
	}

	@Test
	public void testSublist() {
		
		
		
		assertEquals("[1,2,3]",collection1.reverse().subList(0, 3).toString() );
		
	}

	@Test
	public void testReverse() {
	
		collection1.removeAll(1,2,3);
		
		assertEquals("[4,5]",collection1.reverse().toString());
		
	}

	@Test
	public void testSet() {
		assertNotEquals("[5,4,3,2,1]", collection1.set(6, 0).toString());
	}

}
