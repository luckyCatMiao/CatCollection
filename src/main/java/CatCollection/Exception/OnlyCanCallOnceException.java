package CatCollection.Exception;

public class OnlyCanCallOnceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -385335121602344700L;

	public OnlyCanCallOnceException() {
		super("该方法只能调用一次!");
	}
}
