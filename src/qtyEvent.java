import java.util.EventObject;

public class qtyEvent extends EventObject {
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	private int qty;
	public qtyEvent(Object source,int qty) {
		super(source);
		
		this.qty = qty;
		// TODO Auto-generated constructor stub
	}
	
	
	
}