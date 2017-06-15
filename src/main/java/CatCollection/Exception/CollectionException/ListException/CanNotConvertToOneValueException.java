package CatCollection.Exception.CollectionException.ListException;

import CatCollection.Exception.CollectionException.CollectionException;

public class CanNotConvertToOneValueException extends CollectionException {

	public CanNotConvertToOneValueException(String string) {
		super("当前list的size 为:"+string+",只有size为1时才可以转换成list");
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
