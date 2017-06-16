package CatCollection;

import java.util.Comparator;

/**
 * 优先级队列
 * @author Administrator
 *
 * @param <T>
 */
public class XPriorityQuene<T> extends XQuene<T> {

	
	
	
	public XPriorityQuene(Comparator<T> comparator) {
		
		data=new XArrayList<>();
		data.setComparator(comparator);
	}

	
	public XPriorityQuene(Comparator<T> comparator,boolean flag_onlyValue, boolean flag_canNull) {
		super(flag_onlyValue, flag_canNull);
		data=new XArrayList<>();
		data.setComparator(comparator);
	}

	@Override
	public XQuene<T> push(T value) {
		data.add(value);
		
		return this;
	}
	
	
	
	
	
	
}
