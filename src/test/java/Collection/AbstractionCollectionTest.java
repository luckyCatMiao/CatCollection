package Collection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.Exception.NullValueException;
import CatCollection.Exception.CollectionException.OnlyValueException;

public abstract class AbstractionCollectionTest extends FixCollectionTest {
	
	AbstractCollection<Integer> collection1;
	private AbstractCollection<Integer> collection2;
	
	
	public AbstractionCollectionTest()throws Exception  {
		//生成为父类的同名类型
		//获取运行时子类
		Class<?> childClass=this.getClass().getAnnotation(TestType.class).Type();
		
		
		
		
		
		Constructor<?> constructor1=childClass.getConstructor();
		Constructor<?> constructor2=childClass.getConstructor(boolean.class,boolean.class);
		
		collection1=(AbstractCollection<Integer>) constructor1.newInstance();
		collection2=(AbstractCollection<Integer>) constructor2.newInstance(true,false);
		InitValue(collection1);
		InitValue(collection2);
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
	
}
