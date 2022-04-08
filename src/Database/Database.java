package Database;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector; 




public class Database {
	
	
	
	private Connection con;	
	
   public Database() {
	   
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3308/DatabaseName","MYSQL_UserName","MYSQL_Password"); 
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		
		System.out.println(e);
	}	
	
}
   public Vector<Vector> getTodaysOrder(){
	   Vector<Vector> RS = new Vector<Vector>();
	   try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orders` WHERE `Date` = CURDATE()"); 
			
			//ResultSet RS= stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
						
				
					ResultSetMetaData rsmd = rs.getMetaData();		
					
					while(rs.next()) {				
						Vector<Object> ss = new Vector<Object>();
							if(!rs.getBoolean(4)) {
								for(int x = 1;x <= rsmd.getColumnCount();x++) {
									//Vector<Object> op = new Vector<Object>();
									//op.add(rsmd.getColumnName(x));
									//op.add(rs.getObject(x));
									
									ss.add(rs.getObject(x));
										
								}
								RS.add(ss);
								}
							
							
						}
				
				
				
				
				
			
			}catch (SQLException e) {		
				System.out.println(e);
			}
	   
	   return RS;
	   
   }
   
   public Vector<Vector> getCustomerOrder(int id){
	   Vector<Vector> RS = new Vector<Vector>();
	   try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orders` WHERE `Cutomer_name_id` = " + id); 
			//ResultSet RS= stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			while(rs.next()) {
				Vector<Object> ss = new Vector<Object>();
				if(rs.getBoolean(4)) {
					
				}
				ss.add(rs.getInt(1));
				ss.add(rs.getDate(2));
				ss.add(rs.getDouble(9) + rs.getDouble(8) + rs.getDouble(7));
				
				RS.add(ss);
				}
				
				
			
			}catch (SQLException e) {		
				System.out.println(e);
			}
	   
	   return RS;
	   
   }
   
   public Vector<Vector> fetchCustomers(String text) {
	   
	   Vector<Vector> RS = new Vector<Vector>();
	   try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `customer_customer` WHERE `phone_number` LIKE '" + text + "%'"); 
			//ResultSet RS= stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			while(rs.next()) {
				Vector<Object> ss = new Vector<Object>();
				
				ss.add(rs.getInt(1));
				ss.add(rs.getString(2));
				ss.add(rs.getString(3));
				
				RS.add(ss);
				}
				
				
			
			}catch (SQLException e) {		
				System.out.println(e);
			}
	   
	   return RS;
	}
   public Vector<Object> getCustomerInfo(int id){
	   Vector<Object> RS = new Vector<Object>();
	   try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `customer_customer` WHERE `id` = " + id); 
						
			while(rs.next()) {
				RS.add(rs.getString(2));
				RS.add(rs.getString(3));
				}			
			
			}catch (SQLException e) {		
				System.out.println(e);
			}	
	   
	   
	   return RS;
   }
   
   public int PutCustomer(String name, String phone) {
		
		int RS = 0;
		   try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM `customer_customer` WHERE `phone_number` = '" + phone + "'"); 
				//ResultSet RS= stmt.executeQuery("SELECT LAST_INSERT_ID()");
				
				while(rs.next()) {
					
					if(rs.getString(2).equals(name)){
						RS = rs.getInt(1);
					}
					
					else {
						RS = stmt.executeUpdate("UPDATE `customer_customer` SET `Customer_name` = '" +  name +"' WHERE `customer_customer`.`phone_number` = '" +phone +"'" );
					}
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}	
		   if(RS == 0) {
			   
			   try {
					Statement stmt=con.createStatement();  
					RS=stmt.executeUpdate("INSERT INTO `customer_customer` (`id`, `Customer_name`, `phone_number`) VALUES (NULL, '"+ name + "', '" + phone +"');" ); 
					ResultSet rs= stmt.executeQuery("SELECT LAST_INSERT_ID()");
					
					while(rs.next()) {
						RS = rs.getInt(1);
					}
					}catch (SQLException e) {		
						System.out.println(e);
					}	
			   
		   }
		   
		   return RS;
			
	}
   
   public int insert(String orderInsert) {
	   
	   int rs = 0;
	   try {
			Statement stmt=con.createStatement();  
			rs=stmt.executeUpdate(orderInsert ); 
			ResultSet RS= stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			while(RS.next()) {
				rs = RS.getInt(1);
			}
			}catch (SQLException e) {		
				System.out.println(e);
			}	
	   
	   return rs;
		
	}
	public Vector<String> getActiveTable() {
		Vector<String> tables = new Vector<String>();
		
		
		 try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM orders_orders WHERE Active = 1"  ); 
				while(rs.next()) {
					tables.add(rs.getString(11));
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}		
			
			
		
		 
		
		return tables;
		}
	
	
public Vector<Object> getItemDetail(int id){
	
Vector<Object> RS = new Vector<Object>(); 
	
	try {
		
		
		//
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT * FROM `inventory_menu` WHERE `id` = " + id ); 
		
		ResultSetMetaData rsmd = rs.getMetaData();	
		
						
			while(rs.next()) {
				
				
				RS.add(rs.getString(2));
				RS.add(rs.getFloat(3));
				
							
					}
					
					
						
		
		
	} catch (SQLException e) {
		
		
		System.out.println(e);
	}
	
	
	
	
	return RS;
}
	
	
public Vector<Vector> getOrderItems(int i,int Guest){
	
	Vector<Vector> RS = new Vector<Vector>(); 
	
	try {
		
		
		//
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orderitems` WHERE `order_ID_id` = " + i +  " AND `GuestId` = " + Guest ); 
		
		ResultSetMetaData rsmd = rs.getMetaData();			
						
			while(rs.next()) {
				Vector<Object> ss = new Vector<Object>();
				Vector<Object> SS = getItemDetail(rs.getInt(5));
							//System.out.println(SS);
					ss.add(SS.elementAt(0));
					ss.add(rs.getInt(3));
					if(rs.getInt(2) == 0) {
						ss.add(-(float)SS.elementAt(1));
					}
					else {
						ss.add(SS.elementAt(1));
					}
					
					if(!rs.getString(7).equals("")) {
						ss.add(rs.getString(7));
					}
					
					RS.add(ss);
							
					}
					
					
						
		
		
	} catch (SQLException e) {
		
		
		System.out.println(e);
	}
	return RS;
	
	//return null;
	
}

public Vector<Object> getTableInfo(int orderID) {
	
Vector<Object> RS = new Vector<Object>(); 
	
	try {	
		
		//
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orders` WHERE `order_ID` = " + orderID  ); 
		
		ResultSetMetaData rsmd = rs.getMetaData();		
						
			while(rs.next()) {				
				
					
					for(int x = 1;x <= rsmd.getColumnCount();x++) {
						//Vector<Object> op = new Vector<Object>();
						//op.add(rsmd.getColumnName(x));
						//op.add(rs.getObject(x));
						
						RS.add(rs.getObject(x));
							
					}
					
					
				}
				
				
			
	
		
	} catch (SQLException e) {
		
		
		System.out.println(e);
	}
	return RS;  
	 
}
public Vector<Object> getTakeOutTableInfo(int Table) {

	Vector<Object> RS = new Vector<Object>(); 
	
	try {	
		
		
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orders` WHERE `Active` = '1' AND `TakeOutNumber` =" + Table  ); 
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		
		
						
			while(rs.next()) {	
				
				
				if(rs.getInt(11) == (Table) && rs.getBoolean(4)) {
					
					for(int x = 1;x <= rsmd.getColumnCount();x++) {
						//Vector<Object> op = new Vector<Object>();
						//op.add(rsmd.getColumnName(x));
						//op.add(rs.getObject(x));
						
						RS.add(rs.getObject(x));
							
					}
					
					
				}
				
				
				
			}
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 
		//RS.add(rs.getString(2));
		
		
		
		
		
		//con.close();  
		
		
	} catch (SQLException e) {
		
		
		System.out.println(e);
	}
	return RS;  
	 
	
}

	
public Vector<Object> getStayTableInfo(String Table){
		
		
		Vector<Object> RS = new Vector<Object>(); 
		
		try {
			
			
			//
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `orders_orders` WHERE `Active` = '1' AND `Table` = '"+ Table + "'"  ); 
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			
			
							
				while(rs.next()) {
					
					
					
					if(rs.getString(10).equals(Table) && rs.getBoolean(4)) {
						
						for(int x = 1;x <= rsmd.getColumnCount();x++) {
							//Vector<Object> op = new Vector<Object>();
							//op.add(rsmd.getColumnName(x));
							//op.add(rs.getObject(x));
							
							RS.add(rs.getObject(x));
								
						}
						
						
					}
					
					
					
				}
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 
			//RS.add(rs.getString(2));
			
			
			
			
			
			//con.close();  
			
			
		} catch (SQLException e) {
			
			
			System.out.println(e);
		}
		return RS;  
		 
		
	}
   
public boolean getplt(String bPressed) {
	
		boolean gst = false;
try {
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("SELECT PLT FROM inventory_menu WHERE item = '" + bPressed+"'" ); 
	while(rs.next()) {
	gst = rs.getBoolean(1);			
	}
	}catch (SQLException e) {		
		System.out.println(e);
	}		

return gst;
}   
public boolean getpst(String bPressed) {
	
	boolean PST = false;
try {
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("SELECT PST FROM inventory_menu WHERE item = '" + bPressed+"'" ); 
while(rs.next()) {
	PST = rs.getBoolean(1);			
}
}catch (SQLException e) {		
	System.out.println(e);
}		

return PST;
}   
public boolean getgst(String bPressed) {
				
		   		boolean gst = false;
		   try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT GST FROM inventory_menu WHERE item = '" + bPressed+"'" ); 
				while(rs.next()) {
				gst = rs.getBoolean(1);			
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}		
			
			return gst;
		}
	
public void updateItems(int Qty,int GuestId,int ItemId,int orderId, String Comment) {
		
		try {
			Statement stmt=con.createStatement();  
			      
			int rs=stmt.executeUpdate("UPDATE `orders_orderitems` SET `Qty` = '" + Qty + "' WHERE `orders_orderitems`.`Item_id` = '" + ItemId + "' and `GuestId` = '" + GuestId + "' and `order_ID_id` = '" + orderId + "'"  ); 
			int rs1=stmt.executeUpdate("UPDATE `orders_orderitems` SET `Comment` = '" + Comment + "' WHERE `orders_orderitems`.`Item_id` = '" + ItemId + "' and `GuestId` = '" + GuestId + "' and `order_ID_id` = '" + orderId + "'"  ); 
			
		}catch (SQLException e) {		
			System.out.println(e);
		}
		
		
	}
	
	public void insertItems(int Qty,int GuestId,int ItemId,int orderId, String Comment) {
		
		try {
			Statement stmt=con.createStatement();                                                                                                   //  VALUES (NULL, '1', '1', '1', '3', '18', '');
			int rs=stmt.executeUpdate("INSERT INTO `orders_orderitems` (`id`, `Active`, `Qty`, `GuestId`, `Item_id`, `order_ID_id`,`Comment`) VALUES (NULL, '1', '" + Qty + "','" + GuestId + "','" + ItemId + "', '" + orderId + "', '" + Comment  + "');"  ); 
			
		}catch (SQLException e) {		
			System.out.println(e);
		}
		
		
	}
	
	public int getPrintedItems(int itemID,int OrderId,int GuestId) {
		  
		  int res = 0;
		  
		  
		  try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT `Qty` FROM `orders_orderitems` WHERE `Item_id` = '" + itemID + "' AND `order_ID_id` = '" + OrderId +"' and `GuestId` = '" + GuestId + "'"  ); 
				while(rs.next()) {
				res = rs.getInt(1);				
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}	  
		  
		  return res;
		  
	  }
	
	public void decativateItem(int itemId,int orderID) {
		
		try {
			Statement stmt=con.createStatement();  
			      
			int rs=stmt.executeUpdate("UPDATE `orders_orderitems` SET `Active` = '0' WHERE `orders_orderitems`.`Item_id` = '" + itemId + "' AND `orders_orderitems`.`order_ID_id` = '" + orderID + "';"); 
			
		}catch (SQLException e) {		
			System.out.println(e);
		}
		
	}
	
	public int getItemID(String item) {
		  
		  int res = 0;
		  
		  
		  try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT id FROM inventory_menu WHERE item = '" + item+"'" ); 
				while(rs.next()) {
				res = rs.getInt(1);				
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}	  
		  
		  return res;
		  
	  }
	   
	public float getPrice(String item) {
		  
		  float res = 0;
		  
		  
		  try {
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT price FROM inventory_menu WHERE item = '" + item+"'" ); 
				while(rs.next()) {
				res = rs.getFloat(1);				
				}
				}catch (SQLException e) {		
					System.out.println(e);
				}	  
		  
		  return res;
		  
	  }
	   
	public Vector<Vector> getMenuItems(String Category){
		
		
		Vector<Vector> output = new Vector<>();
		
	
		
		int Id = 0;
		
		try {
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("SELECT id FROM inventory_category WHERE name = '" + Category+"'" ); 
		while(rs.next()) {
		Id = rs.getInt(1);
		}
		}catch (SQLException e) {		
			System.out.println(e);
		}
		
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM inventory_menu WHERE category_id =" + Id ); 
			
			while(rs.next()) {
					
					Vector<String> op = new Vector<>();
					op.add(String.valueOf(rs.getInt(1)));
					op.add(rs.getString(2));
					op.add(String.valueOf(rs.getInt(3)));
					
					output.add(op);
				
			}
			
			
			
			}catch (SQLException e) {		
				System.out.println(e);
			}
		
		
		
		return output;
		
		
		
		
	}
		
	public Vector<String> getCategories(){
		
		
		Vector<String> RS = new Vector<String>(); 
		
		try {
			
			
			//System.out.println("Connection SuccessFUll");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from inventory_category"); 
			
			//System.out.println(rs);
			
			while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)); 
				RS.add(rs.getString(2));
				
			
			
			//con.close();  
			
			
		} catch (SQLException e) {
			
			
			System.out.println(e);
		}
		return RS;  
		 
		
	}
	public Float getSales( String what) {
		
		Float res = null;
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT SUM(`" + what + "`) FROM `orders_orders` WHERE Date = CURDATE()" ); 
			while(rs.next()) {
			res = rs.getFloat(1);
			}
			}catch (SQLException e) {		
				System.out.println(e);
			}
		return res;
	}
	
public Float getSales( String what,String StartDate,String EndDate) {
		
		Float res = null;
		try {
			Statement stmt=con.createStatement();  
			//Date = CURDATE()
			ResultSet rs=stmt.executeQuery("SELECT SUM(`" + what + "`) FROM `orders_orders` WHERE Date >= '" + StartDate +"' AND Date <= '" + EndDate +"'" ); 
			while(rs.next()) {
			res = rs.getFloat(1);
			}
			}catch (SQLException e) {		
				System.out.println(e);
			}
		return res;
	}
	
	
	public float getSaleType(String what) {
		Float res = null;
		try {
			Statement stmt=con.createStatement();  
			//Date >= '2021-01-01' AND Date <= '2021-01-31'
			ResultSet rs=stmt.executeQuery("SELECT SUM(`SubTotal`) FROM `orders_orders` WHERE Date = CURDATE() AND `paymentType` = '"+what+"'" ); 
			while(rs.next()) {
			res = rs.getFloat(1);
			}
			}catch (SQLException e) {		
				System.out.println(e);
			}
		return res;
	}
	
	public float getSaleType(String what,String StartDate,String EndDate) {
		Float res = null;
		try {
			Statement stmt=con.createStatement();  
			//Date >= '2021-01-01' AND Date <= '2021-01-31'
			ResultSet rs=stmt.executeQuery("SELECT SUM(`SubTotal`) FROM `orders_orders` WHERE Date >= '" + StartDate + "' AND Date <= '" + EndDate + "' AND `paymentType` = '"+what+"'" ); 
			while(rs.next()) {
			res = rs.getFloat(1);
			}
			}catch (SQLException e) {		
				System.out.println(e);
			}
		return res;
	}

	
	

	

	
	

}
