package CatCollection.Util;

import java.util.Comparator;

import CatCollection.BaseCollection.AbstractList;

public class SortTool {

	
	/**
	 * 冒泡排序
	 * @param list
	 * @return
	 */
	static public <T> AbstractList<T> BubbleSort(AbstractList<T> list,Comparator<T> comparator)
	{
		//每轮将一个数移动到最右边
			int size=list.size();
		   for(int i=0;i<size;i++)
		   {
			   //当前需要循环的范围 右边i个是已经排好的数据
			   for(int q=0;q<size-i-1;q++)
			   {
				   T valueLeft=list.get(q);
				   T valueRight=list.get(q+1);
				   if(comparator.compare(valueLeft, valueRight)>0)
				   {
					  list.set(valueLeft, q+1);
					   list.set(valueRight, q);
				   }
				  
				   
			   }
			   
		   }
		   
		   return list;
	}

	/**
	 * 选择排序
	 * @param <T>
	 * @param list1
	 * @param object
	 * @return
	 */
	public static <T> Object SelectSort(AbstractList<T> list, Comparator<T> comparator) {
		
		
		int size=list.size();
	   for(int i=0;i<size;i++)
	   {
		   //当前需要循环的范围 右边i个是已经排好的数据
		   T maxValue=null;
		   int maxValueIndex = 0;
		   for(int q=0;q<size-i;q++)
		   {
			   T nowValue=list.get(q);
			   //选择一个最大的数
			   if(maxValue==null||comparator.compare(nowValue, maxValue)>0)
			   {
				   maxValue=nowValue;
				   maxValueIndex=q;
			   }
		   }
		   
		   //将最大的数与未排序的最右边交换
		   T cache=list.get(size-i-1);
		   list.set(maxValue, size-i-1);
		   list.set(cache, maxValueIndex);
		   
	   }   
		
		return list;
	}
	
	
	
	
	//插入排序
}
