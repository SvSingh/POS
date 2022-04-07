package orderPrinting;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.AttributedCharacterIterator;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JLabel;

public class orderPrint implements Printable { 
	
	
		
	   
    
		private Vector<Vector> orderItems;
		private String tableNo;
		private String orderType;
		private int OrderId;
			
		
		public void setOrderInt(int orderInt) {
			this.OrderId = orderInt;
		}
	  public String getTableNo() {
			return tableNo;
		}

		public void setTableNo(String tableNo) {
			this.tableNo = tableNo;
		}

		public String getOrderType() {
			return orderType;
		}

		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}

	public Vector<Vector> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(Vector<Vector> newItems) {
			this.orderItems = newItems;
		}

	public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
	  throws PrinterException 
	  {    
		
	      
	                
	        
	      int result = NO_SUCH_PAGE;    
	        if (pageIndex == 0) {                    
	        
	            Graphics2D g2d = (Graphics2D) graphics; 
	            
	            

	            double width = pageFormat.getImageableWidth();                    
	           
	            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

	            ////////// code by alqama//////////////

	            FontMetrics metrics=g2d.getFontMetrics(new Font("Monospaced",Font.BOLD,12));
	        //    int idLength=metrics.stringWidth("000000");
	            //int idLength=metrics.stringWidth("00");
	            int idLength=metrics.stringWidth("000");
	            int amtLength=metrics.stringWidth("000000");
	            int qtyLength=metrics.stringWidth("00000");
	            int priceLength=metrics.stringWidth("000000");
	            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

	        //    int idPosition=0;
	        //    int productPosition=idPosition + idLength + 2;
	        //    int pricePosition=productPosition + prodLength +10;
	        //    int qtyPosition=pricePosition + priceLength + 2;
	        //    int amtPosition=qtyPosition + qtyLength + 2;
	            
	            int productPosition = 0;
	            int discountPosition= prodLength+5;
	            int pricePosition = discountPosition +idLength+10;
	            int qtyPosition=pricePosition + priceLength + 4;
	            int amtPosition=qtyPosition + qtyLength;
	            
	            
	              
	        try{
	            /*Draw Header*/
	            int y=20;
	            int yShift = 10;
	            int headerRectHeight=15;
	            int headerRectHeighta=40;
	            
	            ///////////////// Product names Get ///////////
	             /*   String  pn1a=pn1.getText();
	                String pn2a=pn2.getText();
	                String pn3a=pn3.getText();
	                String pn4a=pn4.getText();
	            ///////////////// Product names Get ///////////
	                
	            
	            ///////////////// Product price Get ///////////
	                int pp1a=Integer.valueOf(pp1.getText());
	                int pp2a=Integer.valueOf(pp2.getText());
	                int pp3a=Integer.valueOf(pp3.getText());
	                int pp4a=Integer.valueOf(pp4.getText());
	                int sum=pp1a+pp2a+pp3a+pp4a;*/
	            ///////////////// Product price Get ///////////
	                
	             g2d.setFont(new Font("Monospaced",Font.BOLD,12));
	             
	             
	             g2d.setColor(Color.BLACK);
	             
	            g2d.drawString(String.valueOf(Calendar.getInstance().getTime()),12,y);y+=yShift;
	            g2d.drawString("",12,y);y+=yShift;
	            g2d.drawString("Order ID: " + String.valueOf(OrderId),12,y);y+=yShift;
	            g2d.drawString("",12,y);y+=yShift;
	            
	            if(this.getOrderType().contentEquals("Takeout")) {
	            	g2d.drawString("Take out No.: " + this.getTableNo(),12,y);y+=yShift;
		            g2d.drawString("",12,y);y+=yShift;	
		            g2d.drawString("",12,y);y+=yShift;
		            g2d.setFont(new Font("Monospaced",Font.BOLD,30));
	            g2d.drawString("  Take out          ",10,y);y+=yShift;	
	            }
	            else{	            	
		            g2d.drawString("",12,y);y+=yShift;
		            g2d.setFont(new Font("Monospaced",Font.BOLD,25));
	            g2d.drawString(" " + "Table No: " + this.getTableNo(),10,y);y+=yShift;	
	            }
	            g2d.setFont(new Font("Monospaced",Font.BOLD,20));
	            g2d.drawString("============================",12,y);y+=headerRectHeight;
	            g2d.drawString("",12,y);y+=yShift;
	            
	            
	            if(orderItems.size()!= 1) {
	            	g2d.drawString("",12,y);y+=yShift;
	            	g2d.drawString("<------------ 1 ------------>",10,y);y+=yShift;		            
	            }
	            for(int x = 0;x < orderItems.size();x++) {
	            	g2d.setFont(new Font("Monospaced",Font.BOLD,15));
					for(int z = 0;z < orderItems.elementAt(x).size();z++) {
						Vector<Object> items = (Vector<Object>) (orderItems.elementAt(x).elementAt(z));
	            		if(items.size() != 0) {
	            			g2d.drawString("",12,y);y+=yShift;
		    	            g2d.drawString(" "+items.elementAt(1) + " " + items.elementAt(0) ,10,y);y+=yShift;
		    	            if(!items.elementAt(3).equals("")) {
		    	            	g2d.drawString(" " +(String) items.elementAt(3), 10, y);y+=yShift;
		    	            }
		            	
	            		}
						}
	            	if((x + 1) != orderItems.size()) {
	            		g2d.setFont(new Font("Monospaced",Font.BOLD,12));
	            		g2d.drawString("",12,y);y+=yShift;
	            		g2d.drawString("<------------ " +(x+1 + 1) + " ------------>",10,y);y+=yShift;
	            	}
	            }
	            g2d.setFont(new Font("Monospaced",Font.BOLD,12));
	            g2d.drawString("",12,y);y+=yShift;
	            g2d.drawString("-----------------------------",10,y);y+=yShift;
	            g2d.drawString("",12,y);y+=yShift;
	            g2d.drawString("-----------------------------",10,y);y+=yShift;
	            
	           
	                   
	           
	             
	           
	            
//	            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//	            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
	          

	    }
	    catch(Exception r){
	    r.printStackTrace();
	    }

	              result = PAGE_EXISTS;    
	          }    
	          return result;    
	      }
	   }



