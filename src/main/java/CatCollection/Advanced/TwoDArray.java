package CatCollection.Advanced;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.Advanced.TwoDArray.ArrayPoint;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Exception.CollectionException.ListException.IndexOutOfRangeException;

/**
 * 不可拓展的二维数组
 * @author Administrator
 * @param <T>
 *
 */
public class TwoDArray<T> extends FixCollection<T>{

	

	public class ArrayPoint {

		public int x;
		public int y;
		public T value;
		
		public ArrayPoint(int x, int y, T value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "ArrayPoint [x=" + x + ", y=" + y + ", " + (value != null ? "value=" + value : "") + "]";
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}
		
		
	}

	private int xRange;
	private int yRange;
	private Object[][] data;
	
		
	public TwoDArray(int xRange,int yRange) {
		
		this(xRange, yRange, false, true);
	}

	public TwoDArray(int xRange,int yRange,boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
	
		
		this.xRange=xRange;
		this.yRange=yRange;
		
		data=new Object[yRange][xRange];
	}

	
	
	public void addAt(int x,int y,T value)
	{
		CheckRange(x,xRange);
		CheckRange(y,yRange);
		
		flag_notNullTest(value);
		flag_onlyValueTest(value);
		
		
		data[y][x]=value;
		
	}
	
	public T getAt(int x,int y)
	{
		try {
			CheckRange(x,xRange);
			CheckRange(y,yRange);
			
		} catch (Exception e) {
			//超出范围直接返回null
			return null;
		}
		
		
		
		
		return (T) data[y][x];
	}
	
	
	public void removeAt(int x,int y)
	{
		CheckRange(x,xRange);
		CheckRange(y,yRange);
		
		
		
		data[y][x]=null;
	}
	

	private void CheckRange(int value, int Range) {
		if(!(value>=0&&value<Range))
		{
			throw new IndexOutOfRangeException(value, Range);
		}
		
	}

	
	public void printPlane()
	{
		for(int y=0;y<yRange;y++)
		{
			for(int x=0;x<xRange;x++)
			{
				String value=data[y][x]+"";
				
				System.out.print(value.charAt(0)+"  ");
			}
			System.out.print("\n");
		}
	}
	
	@Override
	public Iterator<T> iterator() {
	
		
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return yRange*xRange;
	}
	
	
	
	public XLinkedList<ArrayPoint> arrayPoints() {
		
		XLinkedList<ArrayPoint> linkedList=new XLinkedList<>();
		
		for(int y=0;y<yRange;y++)
		{
			for(int x=0;x<xRange;x++)
			{
				T value=getAt(x, y);
				if(value!=null)
				{
					ArrayPoint arrayPoint=new ArrayPoint(x,y,value);
					linkedList.add(arrayPoint);
				}
				
				
			}
			
		}
		
		return linkedList;
		
	}
	

	@Override
	public FixCollection<T> shallowClone() {
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 用值填充所有空位
	 */
	public TwoDArray<T> fill(T value) {
	
		for(int y=0;y<yRange;y++)
		{
			for(int x=0;x<xRange;x++)
			{
				addAt(x, y, value);
				
				
			}
			
		}
	
		return this;
	}
	
	
	

}
