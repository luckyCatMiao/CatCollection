package CatCollection.Exception.CollectionException;

public class OnlyValueException extends CollectionException {

	public <T> OnlyValueException(T value) {
		super("不能重复值的集合出现重复值:"+value);
	}

}
