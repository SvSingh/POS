package Reports;

import java.util.EventObject;

public class DateEvent extends EventObject {
	
	
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	
	private String StartDate;
	private String EndDate;
	public DateEvent(Object source,String StartDate, String EndDate) {
		super(source);
		
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		// TODO Auto-generated constructor stub
	}
	
	
	
}