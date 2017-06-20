package Collection;

import Annotation.TestType;
import CatCollection.XStack;
import CatCollection.BaseCollection.AbstractList;
import CatCollection.BaseCollection.FixCollection;
import CatCollection.Chart.XChart;

@TestType(Type = XChart.class)
public class XChartTest extends FixCollectionTest{

	public XChartTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void InitValue(FixCollection<Integer> collection) {
		XChart<Integer> chart=(XChart<Integer>) collection;
		chart.addNode(5);
		chart.addNode(4);
		chart.addNode(3);
		chart.addNode(2);
		chart.addNode(1);
		
		
		
	}
	
	@Override
	public void addValue(FixCollection<Integer> collection, int value) {
		XChart<Integer> list=(XChart<Integer>) collection;
		list.addNode(value);
		
	}

	@Override
	public void testShallowClone() {
	
	}
}
