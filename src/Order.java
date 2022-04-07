import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Time;
import Database.Database;
import orderPrinting.Page;
import orderPrinting.RecieptPrint;
import orderPrinting.orderPrint;

//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.swing.table.DefaultTableModel;

import Database.Database;
public class Order {
	
	//"INSERT INTO `orders_orders` (`order_ID`, `Date`, `Time`, `Active`, `paymentType`, `Tip`, `GST`, `PLT`, `SubTotal`, `Table`, `TakeOutNumber`, `Guest`, `Cutomer_name_id`) VALUES (NULL, '2020-04-13', '12:02:05.000000', '1', NULL, NULL, NULL, NULL, '11.99', NULL, NULL, '1', NULL);"
		
	private int orderID,Guest;
	private String date,time;
	
	private Boolean active;
	private String PaymentType;
	private Double TIP;
	private Double GST;
	private Double PLT;
	private Double PST;
	private Double Subtotal;
	private float discountRate;
	private String discount;
	public float getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}


	private String Table;
	private int takeOutNumber;
	private int CustomerID;
	private Vector<Vector> SavedItems;
	private Vector<Vector> NewItems;
	private listPanel lp;
	private Vector<Object> orderVec;
	private Vector<Vector> printItem;
	
	public void setPrintItem(Vector<Vector> item) {
		this.printItem = item;
	}
	
	Database db = new Database();
	
	
	public void recieptprint() {
		//String printerNameDesired = "Kitchen1";
		
		String printerNameDesired = "Microsoft Print to PDF";

		PrintService[] service = PrinterJob.lookupPrintServices(); // list of printers
		DocPrintJob docPrintJob = null;

		int count = service.length;

		for (int i = 0; i < count; i++) {
		    if (service[i].getName().equalsIgnoreCase(printerNameDesired)) {
		        docPrintJob = service[i].createPrintJob();
		        i = count;
		    }
		}
		try {
		PrinterJob pjob = PrinterJob.getPrinterJob();
		Page page = new Page();
		pjob.setPrintService(docPrintJob.getPrintService());
		//pjob.setJobName("job");
		RecieptPrint rp = new RecieptPrint();
		rp.setOrderItems(printItem);
		rp.setOrderInt(orderID);
		rp.setTip(this.getTIP());
		rp.setMethod(this.getPaymentType());
		rp.setTotal(this.getSubtotal());
		rp.setGst(this.getGST());
		rp.setPLT(this.getPLT());
		rp.setPST(this.getPST());
		
		
		pjob.setPrintable(rp, page.getPageFormat(pjob));
		pjob.print();
		}catch (PrinterException ex) {
            ex.printStackTrace();
   }	
		
	}
	
	
	public void orderPrint(){
		String printerNameDesired = "Kitchen1";

		PrintService[] service = PrinterJob.lookupPrintServices(); // list of printers
		DocPrintJob docPrintJob = null;

		int count = service.length;

		for (int i = 0; i < count; i++) {
		    if (service[i].getName().equalsIgnoreCase(printerNameDesired)) {
		        docPrintJob = service[i].createPrintJob();
		        i = count;
		    }
		}
		try {
		PrinterJob pjob = PrinterJob.getPrinterJob();
		Page page = new Page();
		pjob.setPrintService(docPrintJob.getPrintService());
		//pjob.setJobName("job");
		orderPrint op = new orderPrint();
		op.setOrderItems(printItem);
		op.setOrderInt(orderID);
		
		if(this.getTable() == null || this.getTable().equals("null")) {
			op.setTableNo(Integer.toString(this.getTakeOutNumber()));
			op.setOrderType("Takeout");
		}
		
		else {
			op.setTableNo(getTable());
			op.setOrderType("stayIn");
		}
		pjob.setPrintable(op, page.getPageFormat(pjob));
		if(printItem != null) {
			pjob.print();
		}
				
		}catch (PrinterException ex) {
            ex.printStackTrace();
   }	
		
	}
	
	public Vector<Vector> getListItems(){
		Vector<Vector> Items = new Vector<Vector>();
		
		int g = 1;
		
		DefaultTableModel model = (DefaultTableModel) lp.table.getModel();
		
		Vector<Object> s = new Vector<Object>();
		
		for(int x = 0;x < model.getRowCount();x++) {
			
			
			if(model.getValueAt(x, 0).equals(">>>>>>>> " + g + " >>>>>>>>") == false) {
				if(model.getValueAt(x, 0).toString().contains("<")) {
					if(model.getValueAt(x, 0).toString().contains("Discount")) {
						this.setDiscount(((String) model.getValueAt(x, 0)).replace("<html><font color=red>","").replace("</font></html>", ""));
					}
					else {
						DeactivateItem(((String) model.getValueAt(x, 0)).replace("<html><font color=red>","").replace("</font></html>", ""));
					}
					
				}
				else if(model.getValueAt(x, 0).toString().contains("<") == false) {
					if(model.getValueAt(x, 0).toString().contains("(")) {
						
						Vector<Object> ss = (Vector<Object>) s.elementAt(s.size() - 1);
						ss.add(model.getValueAt(x, 0).toString());
					}
					else {
						Vector<Object> ss = new Vector<Object>();
						ss.add(model.getValueAt(x, 0));
						ss.add(model.getValueAt(x, 1));
						//ss.add(Float.parseFloat(model.getValueAt(x, 2).toString().replace("$", ""))/(float)model.getValueAt(x, 1));
						
						
						ss.add(Float.parseFloat(model.getValueAt(x, 2).toString().replace("$", "")));
						
						if((x+1) < model.getRowCount()) {
							if(model.getValueAt(x+1, 0).toString().contains("(")) {
								ss.add(model.getValueAt(x+1, 0));
								x++;
								}
							else {
								ss.add("");
							}
						}
						else {
							ss.add("");
						}
						
						
						
						s.add(ss);		
						
					}
					
				}
				
			}
			
			else if(model.getValueAt(x, 0).equals(">>>>>>>> " + g + " >>>>>>>>")) {
				if(!s.isEmpty()) {
					Items.add(s);
				}			
				s = new Vector<Object>();
				g++;				
			}
			
			
		}
		if(!s.isEmpty()) {
			Items.add(s);
		}
		if(g != 1) {
			Guest = (g - 1);
		}
		else {
			Guest = (1);
		}
		
		
		
		
		
		return Items;
	}
	
	
	public void save() {	
		
		
		if(orderVec == null) {
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			date =  dateFormat.format(new Date());
			time = timeFormat.format(new Date());
			
			active = true;		
			
			NewItems = this.getListItems();			
			
		
			if(!NewItems.isEmpty()) {
				
				if(getSubtotal() == 0) {
					setActive(false);
				}
				
				//`order_ID`, `Date`, `Time`, `Active`, `paymentType`, `Tip`, `GST`, `PLT`, `SubTotal`, `Table`, `TakeOutNumber`, `Guest`, `Cutomer_name_id`) 
				String OrderInsert = "INSERT INTO `orders_orders` (`order_ID`, `Date`, `Time`, `Active`, `paymentType`, `Tip`, `GST`, `PLT`, `SubTotal`, `Table`, `TakeOutNumber`, `Guest`, `Cutomer_name_id`,`DiscountPrice`,`Discount`,`PST`) VALUES (" + getOrderID() +", '"+ getDate() + "', '" + getTime() +  "', '"+ (getActive() ? 1 : 0)  + "', '" + getPaymentType() + "', "+getTIP()+", " + getGST() + ",  " +getPLT() +  " , '"+getSubtotal() +"', '"+getTable() +"', " + getTakeOutNumber() + ", '"+ getGuest() + "', "+ getCustomerId() + ", "+ getDiscountRate() + ", '"+ getDiscount()+ "', "+ getPST() + ");";
				orderID = db.insert(OrderInsert);
				
				
				
				
				
				for(int x = 0;x < NewItems.size();x++) {
					for(int y = 0;y < NewItems.elementAt(x).size();y++) {
						Vector<Object> items = (Vector<Object>) (NewItems.elementAt(x).elementAt(y));
						int itemId = db.getItemID((String) items.elementAt(0));						
						
						
						int present = db.getPrintedItems(itemId,orderID,x+1);						
						if(present == 0) {
							db.insertItems((int)items.elementAt(1), x + 1, itemId, orderID,(String) items.elementAt(3));
						}
						else if(present == (int) items.elementAt(1)) {
							
						}
						else {
							db.updateItems((int) items.elementAt(1), x+1,itemId , orderID,(String) items.elementAt(3));;
							
						}
											
					}
				}
				
				this.printItem = NewItems;
				
				
			}
			
			
			
			
		}
		
		else if(orderVec != null) {
			
			NewItems = this.getListItems();			
			int g = 1;		
				
				
			
			if(getSubtotal() == 0) {
				setActive(false);
			}
			//UPDATE `orders_orders` SET `GST` = '" + getGST() + "', `SubTotal` = '" + getSubTotal() + "', `Guest` = '" + getGuest() + "' WHERE `orders_orders`.`order_ID` =  + getOrderID;
			String OrderUpdate = "UPDATE `orders_orders` SET `GST` = " + getGST() + ", `PLT` = " + getPLT() + ", `PST` = " + getPST() + ", `SubTotal` = '" + getSubtotal() + "', `paymentType` = '" + getPaymentType()  + "', `Tip` = '" + getTIP()  + "', `Active` = '" + (getActive() ? 1 : 0) + "', `DiscountPrice` = '" + getDiscountRate()+ "', `Discount` = '" + getDiscount() + "', `Guest` = '" + getGuest() + "' WHERE `orders_orders`.`order_ID` = " + getOrderID();
			int l = db.insert(OrderUpdate);
			
			
			if(!NewItems.isEmpty()) {
				
				Vector<Vector> orderItems = new Vector<Vector>();
			
				for(int x = 0;x < NewItems.size();x++) {
					Vector<Vector> In = new Vector<Vector>();
					for(int y = 0;y < NewItems.elementAt(x).size();y++) {
						Vector<Object> itemsIn = new Vector<Object>();
						Vector<Object> items = (Vector<Object>) (NewItems.elementAt(x).elementAt(y));
						int itemId = db.getItemID((String) items.elementAt(0));						
						
						
						int present = db.getPrintedItems(itemId,getOrderID(),x+1);						
						if(present == 0) {
							itemsIn.add(items.elementAt(0));
							itemsIn.add(items.elementAt(1));
							itemsIn.add(items.elementAt(2));
							itemsIn.add(items.elementAt(3));
							db.insertItems((int)items.elementAt(1), x + 1, itemId, getOrderID(),(String)items.elementAt(3));
					}
				else if(present == (int) items.elementAt(1)) {
						
				}
				else {
					itemsIn.add(items.elementAt(0));
					itemsIn.add((int)items.elementAt(1) - present);
					itemsIn.add(items.elementAt(2));
					itemsIn.add(items.elementAt(3));
						db.updateItems((int) items.elementAt(1), x+1,itemId , getOrderID(),(String) items.elementAt(3));;
						
				}
				In.add(itemsIn);						
				}
					orderItems.add(In);
			}
				
				
				this.printItem = orderItems;	
			}
			
		}
		
		
		
		
		
		
		
	}
	
	
	public Double getPST() {
		return PST;
	}


	public void setPST(Double pST) {
		
		PST = pST;
		
	}


	public Vector<Object> getOrderVec(){
		return orderVec;
	}


	public void setOrderVec(Vector<Object> orderVec) {
		this.orderVec = orderVec;
	}


	public void setOrder(Vector<Object> orderVec) {
		
		this.orderVec = orderVec;
		
		
		orderID = ((int) orderVec.elementAt(0));
		date = ( String.valueOf(orderVec.elementAt(1)));
		active = ((Boolean) orderVec.elementAt(3));
		PaymentType = ((String) orderVec.elementAt(4));
		TIP = ((Double) orderVec.elementAt(5));
		GST = ((Double) orderVec.elementAt(6));
		PLT = ((Double) orderVec.elementAt(7));
		Subtotal = ((Double) orderVec.elementAt(8));
		Table = ((String) orderVec.elementAt(9));
		CustomerID = (int)(orderVec.elementAt(12));
		Guest = (int) orderVec.elementAt(11);
		discountRate = (float)((double) orderVec.elementAt(13));
		discount = (String) orderVec.elementAt(14);
		PST = ((Double) orderVec.elementAt(15));
		SavedItems = new Vector<Vector>();
		
		
		
		if(( orderVec.elementAt(10)) != null) {			
			takeOutNumber = ((int) orderVec.elementAt(10));			
		}		
		
		for(int x = 1; x <= getGuest();x++ ) {
			Vector<Vector> items =  db.getOrderItems(getOrderID(),x);
			SavedItems.add(items);
			}
		
		
	}
	
	public void DeactivateItem(String item) {
		int itemId = db.getItemID(item);
		db.decativateItem(itemId,getOrderID());
	}
	
	public boolean checkItem(String valueAt) {
		
		boolean res = false;
		if(orderVec != null) {
			
			for(int x = 0;x < SavedItems.size();x++) {
				for(int y = 0;y < SavedItems.elementAt(x).size();y++) {
					Vector<Object> items = (Vector<Object>) (SavedItems.elementAt(x).elementAt(y));
					if(valueAt.equals(items.elementAt(0))) {
						res =  true;
					}
				}
			}
		}	
			
		
		
		return res;
	}
	 	
	
	public void setListPanel(listPanel lp) {
		
		this.lp = lp;
	}


	public int getGuest() {
		return Guest;
	}


	public void setGuest(int guest) {
		Guest = guest;
	}

	public Vector<Vector> getItems() {
		return SavedItems;
	}


	public void AddItems(Vector<Vector> items) {
		NewItems = items;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public Boolean getActive() {
		if (active == null){
			return true;
		}
		else {
			return active;
		}
		
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public String getPaymentType() {
		return PaymentType;
	}


	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}


	public Double getTIP() {
		
			return TIP;
			
		
	}


	public void setTIP(Double tIP) {
		TIP = tIP;
	}


	public Double getGST() {
		return GST;
	}


	public void setGST(Double gST) {
		GST = gST;
	}


	public Double getPLT() {		
			return PLT;		
		
	}


	public void setPLT(Double PLT) {
		this.PLT = PLT;
		
	}


	public Double getSubtotal() {
		return Subtotal;
	}


	public void setSubtotal(Double subtotal) {
		Subtotal = subtotal;
	}


	public String getTable() {
		return Table;
	}


	public void setTable(String table) {
		Table = table;
	}


	public int getTakeOutNumber() {
		return takeOutNumber;
	}


	public void setTakeOutNumber(int tableselected) {
		this.takeOutNumber = tableselected;
	}


	public int getCustomerId() {
		return CustomerID;
	}


	public void setCustomerId(int customerId) {
		CustomerID = customerId;
	}


	
	
	

}
