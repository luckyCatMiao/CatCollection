package CatCollection.Exception.CollectionException.ListException;

import CatCollection.Exception.CollectionException.CollectionException;

public class IndexOutOfRangeException extends CollectionException {

	public IndexOutOfRangeException(int index, int size) {
		super("数组索引越界,请求索引:"+index+",实际范围:0~"+size);
	}

}
