package Customer;

import java.util.EventObject;

public class CustomerReportEvent extends EventObject {
	
	public CustomerReportEvent(Object source, int orderId) {
		super(source);
		this.orderId = orderId;
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	private int orderId;

}
