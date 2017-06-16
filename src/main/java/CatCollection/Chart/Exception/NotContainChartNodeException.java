package CatCollection.Chart.Exception;

public class NotContainChartNodeException extends RuntimeException {

	public NotContainChartNodeException(Object value) {
		
		super("需要进行连接的节点:"+value+"不存在图中");
	}

	
}
