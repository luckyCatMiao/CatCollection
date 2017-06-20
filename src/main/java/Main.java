import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CatCollection.XArrayList;
import CatCollection.XLinkedList;
import CatCollection.XStack;
import CatCollection.Chart.ChartTool;
import CatCollection.Chart.XChart;
import CatCollection.Tree.XTree;
import Collection.ChartToolTest;

public class Main {

	public static void main(String[] args) {
//		XLinkedList<Integer> list1=new XLinkedList<>();
//		
//		list1.add(5);
//		list1.add(4);
//		list1.add(3);
//		list1.add(2);
//		list1.add(1);
//		
//		for(Integer element:list1)
//		{
//			System.out.println(element);
//		}
		
		
		
		//System.out.println(chart);
	//	System.out.println(chart.Search(1, 5));
		
		
		//XLinkedList<Integer> linkedList=new XLinkedList<>();
		//System.out.println(ChartTool.GetUnVisitedLinkPoint(1, (XLinkedList<Integer>)linkedList.add(2).add(3), chart));
		
//		ChartToolTest test=new ChartToolTest();
//		test.setUP();
//		
//		test.testBFS();
		
		
//		XStack<Integer> newPath=new XStack<>();
//		newPath.push(1);
//		XStack<Integer> newPath2=newPath.shallowClone();
//		newPath2.push(2);
//		System.out.println(newPath2);
//		System.out.println(newPath);
//		
//		
//		XArrayList<Integer> newPath3=new XArrayList<>();
//		newPath3.add(1);
//		newPath3.add(2);
//		XArrayList<Integer> newPath4=(XArrayList<Integer>) newPath3.shallowClone();
//		newPath4.add(2);
//		System.out.println(newPath3);
//		System.out.println(newPath4);
	
		
		
//		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4));
//		List<Integer> list2=list.subList(0, 2);
//		list2.add(5);
//		System.out.println(list);
		
		

		XTree<Integer> tree1=new XTree<>();
		tree1.addNode(3,null);
		
		tree1.addNode(2, 3);
		tree1.addNode(1, 3);
		
		tree1.addNode(4, 2);
		tree1.addNode(6, 2);
		
		tree1.addNode(3, 1);
		tree1.addNode(7, 1);
		
	}
}
