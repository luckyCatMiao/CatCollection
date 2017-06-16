import CatCollection.XLinkedList;

public class Main {

	public static void main(String[] args) {
		XLinkedList<Integer> list1=new XLinkedList<>();
		
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		list1.remove(5);
		System.out.println(list1);
		
	}
}
