package Collection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Annotation.TestType;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Util.ArrayTool;

public abstract class FixCollectionTest {

	
	private FixCollection<Integer> collection1;
	private FixCollection<Integer> collection2;
	
	
	public FixCollectionTest()throws Exception  {
		//生成为父类的同名类型
		//获取运行时子类
		Class<?> childClass=this.getClass().getAnnotation(TestType.class).Type();

		
		Constructor<?> constructor1=childClass.getConstructor();
		Constructor<?> constructor2=childClass.getConstructor(boolean.class,boolean.class);
		
		collection1=(FixCollection<Integer>) constructor1.newInstance();
		collection2=(FixCollection<Integer>) constructor2.newInstance(true,false);

		InitValue(collection1);
		InitValue(collection2);
	}
	
	abstract protected void InitValue(FixCollection<Integer> collection);
	
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
	public void testShallowClone() {
	
		
		assertNotEquals(collection1, collection1.shallowClone());
		
	}

	@Test
	public void testDeepClone() {
		
		FixCollection<Integer> abstractList=(FixCollection<Integer>) collection1.deepClone();
	
	
		assertNotEquals(collection1, abstractList);
	}

	@Test
	public void testToArray() {
		assertEquals("[5,4,3,2,1]",ArrayTool.toString(collection1.toArray(Integer.class),collection1.size()-1));
	
	}
	
	

}
