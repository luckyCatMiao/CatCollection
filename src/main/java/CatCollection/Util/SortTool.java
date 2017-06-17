package CatCollection.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.BaseCollection.AbstractList;

public class SortTool {

	
	/**
	 * 冒泡排序
	 * @param list
	 * @param comparator
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
	 * @param list
	 * @param comparator
	 * @return
	 */
	public static <T> AbstractList<T> SelectSort(AbstractList<T> list, Comparator<T> comparator) {
		
		
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
	
	
	/**
	 * 插入排序
	 * @param list
	 * @param comparator
	 * @return
	 */
	public static <T> AbstractList<T> InsertSort(AbstractList<T> list, Comparator<T> comparator) {
		
		
	
	   //为每个数排序
		 for(int i=1;i<list.size();i++)
		 {
			 T nowValue=list.get(i);
			 //为该数寻找合适的位置 左边是已经排好的
			for(int a=0;a<i;a++)
			{
				T loopValue=list.get(a);
				//如果小于最左边的数 则直接交换
				if(comparator.compare(nowValue, loopValue)<0)
				{
					T cache=nowValue;
					list.removeRange(i, i);
					//System.arraycopy(list, a, list, a+1, i-a);
					list.add(cache,a);
					list.set(cache, a);
					break;
				}
				
				
			}
		 }
	
	
		 return list;
	}

	
	/**
	 * 归并排序
	 * @param list
	 * @param comparator
	 * @return
	 */
	public static <T> AbstractList<T> MergeSort(AbstractList<T> list, Comparator<T> comparator) {
		
		//这里为了效率起见 先拷贝一份原始list
		//因为内部使用get来获取元素 所以如果是linkedList可能效率会很低
		//先全部转换成XArrayList
		
		AbstractList<T> list2=new XArrayList<>();
		for(T element:list)
		{
			list2.add(element);
		}
		
		list2= _MergeSort(list2,comparator);
		//排序完成 这个时候清空初始数组 再把东西全都复制进去
		//由于_MergeSort返回的还是链表 这里还是不能用get 直接使用遍历
		
		list.clear();
		for(T element:list2)
		{
			list.add(element);
		}
		
		return list;
	}
	
	
	private static <T> AbstractList<T> _MergeSort(AbstractList<T> list, Comparator<T> comparator) {
		//已经有序
		if(list.size()==1)
		{
			return list;
		}
		else
		{
			int center=(0+list.size())/2;
			//分割成左右两部分排序之后在合并
			AbstractList<T> left=list.subList(0, center);
			AbstractList<T> right=list.subList(center, list.size());
			left=MergeSort(left, comparator);
			right=MergeSort(right, comparator);
			return HeBing(left,right,comparator);
			
		}
		
	}

	/**
	 * 合并两个已经有序的list
	 * @param <T>
	 * @param is
	 * @param is2
	 * @return
	 */
	private static <T> AbstractList<T> HeBing(AbstractList<T> is1, AbstractList<T> is2, Comparator<T> comparator) {
		
		
		//因为基本没有查询 只有添加 所以用链表效率高一些
		AbstractList<T> result=new XLinkedList<>();
	
		
		
		//两个指针分别指向两个数组的起始位置
		int index1=0;
		int index2=0;
		
		while(true)
		{
			//如果有一方指针越界
			//则把另外一方剩余的值全加入数组中
			if(index1>is1.size()-1)
			{
				result.addAll(is2.subList(index2, is2.size()));
				break;
			}
			else if(index2>is2.size()-1)
			{
				result.addAll(is1.subList(index1, is1.size()));
				break;
			}
			
			//比较两个指针指向数的大小
			if(comparator.compare(is1.get(index1), is2.get(index2)) >0)
			{
				result.add(is2.get(index2));
				index2++;
			}
			else
			{
				result.add(is1.get(index1));
				index1++;
			}
			
		}
		
		
		
		return result;
	}
}
