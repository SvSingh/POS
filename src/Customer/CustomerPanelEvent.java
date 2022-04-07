package Customer;

import java.util.EventObject;

public class CustomerPanelEvent extends EventObject {
	
	public CustomerPanelEvent(Object source, int id) {
		super(source);
		this.id = id;
	}

	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
