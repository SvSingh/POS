import java.util.EventObject;

public class TableEvent extends EventObject {
	
	private String tableSelected;

	public TableEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public TableEvent(Object source,String tableSelected) {
		super(source);
		
		this.tableSelected = tableSelected;
		// TODO Auto-generated constructor stub
	}
	
	
	

	public String getTableSelected() {
		return tableSelected;
	}

	public void setTableSelected(String tableSelected) {
		this.tableSelected = tableSelected;
	}
	
	

}
