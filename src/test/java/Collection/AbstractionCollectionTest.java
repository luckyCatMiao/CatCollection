package Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Constructor;

import org.junit.Before;
import org.junit.Test;

import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.NullValueException;
import CatCollection.Exception.CollectionException.OnlyValueException;
import CatCollection.Util.ArrayTool;

public class AbstractionCollectionTest {
	
	AbstractCollection<Integer> collection1;
	AbstractCollection<Integer> collection2;
	
	
	public AbstractionCollectionTest()throws Exception  {
		//生成为父类的同名类型
		//获取运行时子类
		Class<?> childClass=this.getClass().getDeclaredField("collection1").getType();
		Constructor<?> constructor1=childClass.getConstructor();
		Constructor<?> constructor2=childClass.getConstructor(boolean.class,boolean.class);
		
		collection1=(AbstractCollection<Integer>) constructor1.newInstance();
		collection2=(AbstractCollection<Integer>) constructor2.newInstance(true,false);
		 
		collection1.add(5);
		collection1.add(4);
		collection1.add(3);
		collection1.add(2);
		collection1.add(1);
	}
	

	
	@Test
	public void testAdd() {
		
		collection1.add(0);
		assertEquals(collection1.toString(), "[5,4,3,2,1,0]");
	}

	@Test(expected = NullValueException.class)
	public void testAddNull() {
		
		collection2.add(null);
	
	}

	@Test(expected = OnlyValueException.class)
	public void testAddSame() {
		
		collection2.add(5);
		collection2.add(5);
	
	}

	@Test
	public void testRemove() {
	
		collection1.remove(3);
		assertEquals("[5,4,2,1]", collection1.toString());
		collection1.remove(2);
		assertEquals("[5,4,1]", collection1.toString());
		collection1.remove(1);
		assertEquals("[5,4]", collection1.toString());
		assertEquals(2, collection1.size());
	}

	@Test(expected = NullValueException.class)
	public void testRemoveError() {
		
		collection2.remove(null);
		
	}

	@Test
	public void testClear() {
	
		
		assertEquals(0,collection1.clear().size() );
		
	}

	@Test
	public void testShallowClone() {
	
		
		assertNotEquals(collection1, collection1.shallowClone());
		
	}

	@Test
	public void testDeepClone() {
		
		AbstractList<Integer> abstractList=(AbstractList<Integer>) collection1.deepClone().remove(5);
	
		assertEquals(5, collection1.size());
		assertEquals(4, abstractList.size());	
		assertNotEquals(collection1, abstractList);
	}

	@Test
	public void testToArray() {
		assertEquals("[5,4,3,2,1]",ArrayTool.toString(collection1.toArray(Integer.class),collection1.size()-1));
	
	
		Integer[] integers=collection1.toArray(Integer.class);
	
	
	}

}
