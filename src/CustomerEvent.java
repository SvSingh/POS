import java.util.EventObject;

public class CustomerEvent extends EventObject {
	
	private String CustomerName;
	private String CustomerNumber;
	
	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		CustomerNumber = customerNumber;
	}

	public CustomerEvent(Object source, String customerName, String customerNumber) {
		super(source);
		CustomerName = customerName;
		CustomerNumber = customerNumber;
	}
	
	

}
