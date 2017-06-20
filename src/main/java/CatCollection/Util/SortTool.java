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
					  list.set(q+1, valueLeft);
					   list.set(q, valueRight);
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
		   list.set(size-i-1, maxValue);
		   list.set(maxValueIndex, cache);
		   
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
					list.removeAt(i);
					list.add(cache,a);
					list.set(a, cache);
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

	/**
	 * 希尔排序
	 * @param comparator
	 * @return
	 */
	public static <T> AbstractList<T>  ShellSort(AbstractList<T> list, Comparator<T> comparator) {
		//根据数组size获取初始增量
		int Incremental=1;
		while(3*Incremental+1<list.size())
		{
			Incremental=3*Incremental+1;
		}
		
		
		
		while(Incremental>=1)
		{
			//执行带有增量的插入排序(这里的插入排序一定要从右往左来查找合适的位置)
			
			
			
		
		//当前需要进行几次这样的增量插入排序
		for(int i=0;i<Incremental;i++)
		{
			for(int out=Incremental+i;out<list.size();out+=Incremental)
			{	

				int index=out;
				T cache=list.get(out);
				//为该值寻找合适的位置
				
				//貌似for是先执行最右边的计算,再执行中间的判断..
				for(int in=out-Incremental;in>=0;in-=Incremental)
				{
					//因为这里是增量没法用arraycopy native方法来加速了 只能是一个一个交换
					
					//小的都往右移动
					if(comparator.compare(cache, list.get(in))<0)
					{
						
						list.set(in+Incremental, list.get(in));
						index-=Incremental;
						
					}
					
				}
				//插入到最终的位置
				
					list.set(index,cache );
				
				
				
			}
		}	
			//减少增量
			Incremental=(Incremental-1)/3;
		}
		
		
		
		
		return list;
	
	}

	/**
	 * 快速排序
	 * @param list
	 * @param comparator
	 * @return
	 */
	public static <T> AbstractList<T> QuickSort(AbstractList<T> list, Comparator<T> comparator) {
		
		//这里突然发现我自己的框架里的list.subList实现的和java不一样,我是做了浅复制
		//java是直接指向数据源...浅复制都不算 意思是subList.add之后原list也add了
		
		//所以没法用subList来写了 自己自己标上要处理的范围
		list=_QuickSort(list,comparator,0,list.size());
		
		return list;
	}

	private static <T> AbstractList<T> _QuickSort(AbstractList<T> list, Comparator<T> comparator, int startIndex, int toIndex) {
		if(toIndex-startIndex==1)
		{
			return list;
		}
		//快排
		//对自己进行划分
		int center=HuaFen(list,comparator,startIndex,toIndex);
		//对划分结束的左右子数组再次划分
		_QuickSort(list,comparator,startIndex,center);
		_QuickSort(list,comparator,center,toIndex);
		
		
		return list;
	}

	/**
	 * 划分数组(快排的一部分)
	 * @param <T>
	 * @param is
	 * @return
	 */
	private static <T> int HuaFen(AbstractList<T> is, Comparator<T> comparator, int startIndex, int toIndex) {
		
		
		//选取一个项作为中间值(这里选取最右边的)
		T centerValue=is.get(toIndex-1);
		
		//两个指针指向list开头和结尾(不算入中间值的位置)
		int leftIndex=startIndex;
		int rightIndex=toIndex-1;
		while(true)
		{
			
			//从左往右递增左指针找到一个大于等于中间值的值
			while(leftIndex<rightIndex&&comparator.compare(is.get(leftIndex), centerValue)<=0)
			{
				leftIndex++;
			}
			
			//从右往左递减左指针找到一个小于中间值的值
			while(rightIndex>leftIndex&&comparator.compare(is.get(rightIndex),centerValue)>0)
			{
				rightIndex--;
			}
			
			//进行一次交换(如果leftIndex>rightIndex 则说明在交汇点的左右两边已经划分完毕)
		
			if(leftIndex<rightIndex)
			{
				T cache=is.get(leftIndex);
				is.set(leftIndex, is.get(rightIndex));
				is.set(rightIndex, cache);

//记得很久以前写的时候写了下面的 然后又写了其他一堆乱七八糟的东西 现在想想这里根本不用写
//下一轮循环的时候回自动判断掉	所以其他七七八八的判断也不用写了
//				leftIndex++;
//				rightIndex--;
				
			}
			else
			{
				break;
			}
	
		}	
		return leftIndex;
	}
	
	
}
