import CatCollection.XLinkedList;
import CatCollection.Chart.Chart;

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
		
		
		Chart<Integer> chart=new Chart<>();
		chart.addNode(1).addNode(2).addNode(3);
		chart.linkNode(1, 2, false);
		chart.linkNode(1, 3, false);
		chart.linkNode(2, 3, true);
		
		
		System.out.println(chart);
		
		
		
	}
}
