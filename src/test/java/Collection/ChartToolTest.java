package Collection;

import org.junit.Before;
import org.junit.Test;

import CatCollection.Chart.ChartTool;
import CatCollection.Chart.XChart;
import junit.framework.Assert;

public class ChartToolTest {

	
	private XChart<Integer> chart;

	@Before
	public void setUP()
	{

		XChart<Integer> chart=new XChart<>();
		this.chart=chart;
		chart.addNode(1).addNode(2).addNode(3).addNode(4).addNode(5);
		chart.linkNode(1, 2, false);
		chart.linkNode(1, 3, false);
		chart.linkNode(2, 3, true);
		chart.linkNode(1, 4, false);
		chart.linkNode(4, 5, false);
		chart.linkNode(5, 2, false);
		
	}
	
	@Test
	public void testDFS()
	{
	
		Assert.assertEquals("[1,4,5]", ChartTool.DFSSearch(chart, 1, 5).toString());
	}
	
	
	@Test
	public void testBFS()
	{
		Assert.assertEquals("[1,4,5]", ChartTool.BFSSearch(chart, 1, 5).toString());
	}
}
