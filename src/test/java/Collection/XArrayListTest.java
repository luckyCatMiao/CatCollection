package Collection;

import static org.junit.Assert.*;

import java.util.Date;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.geometry.partitioning.Side;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import CatCollection.XArrayList;
import CatCollection.BaseCollection.AbstractCollection;
import CatCollection.BaseCollection.AbstractList;

/**
 * 貌似junit为每个测试方法都重新创建一个类 即每次创建一个类只测试一个方法
 * 所以要想在所有方法被测试前设置一些东西只能在静态方法里而不是构造器里
 * @author Administrator
 *
 */
public class XArrayListTest extends AbstractListTest {
	
	public XArrayListTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	XArrayList<Integer> collection1;
	XArrayList<Integer> collection2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
}
