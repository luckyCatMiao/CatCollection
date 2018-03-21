package TestBean;

import java.io.Serializable;

public class CloneBean implements Serializable{


	public CloneBean2 bean2;
	public int value;
	public CloneBean2 getBean2() {
		return bean2;
	}
	public void setBean2(CloneBean2 bean2) {
		this.bean2 = bean2;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public CloneBean(CloneBean2 bean2, int value) {
		super();
		this.bean2 = bean2;
		this.value = value;
	}
	
	
	
}
