package TestBean;

import java.io.Serializable;

public class CloneBean2 implements Serializable {

	
	public int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CloneBean2(int value) {
		super();
		this.value = value;
	}
	
	
	
}
