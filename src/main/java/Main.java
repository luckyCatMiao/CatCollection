import CatCollection.XLinkedList;
import CatCollection.Chart.ChartTool;
import CatCollection.Chart.XChart;

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
		
		
		XChart<Integer> chart=new XChart<>();
		chart.addNode(1).addNode(2).addNode(3).addNode(4).addNode(5);
		chart.linkNode(1, 2, false);
		chart.linkNode(1, 3, false);
		chart.linkNode(2, 3, true);
		chart.linkNode(1, 4, false);
		chart.linkNode(4, 5, false);
		chart.linkNode(5, 2, false);
		
		
		//System.out.println(chart);
		System.out.println(chart.Search(1, 5));
		
		
		//XLinkedList<Integer> linkedList=new XLinkedList<>();
		//System.out.println(ChartTool.GetUnVisitedLinkPoint(1, (XLinkedList<Integer>)linkedList.add(2).add(3), chart));
		
	}
}
