package Reports;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.text.AttributedCharacterIterator;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;

public class SalesReport implements Printable { 



	private float total;
	private float GST;
	private float PST;
	private float tips;
	private float discount;	
	private float debit;
	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}


	private float Cash;
	private float Tips;
	private float visa;
	private float Mastercard;
	private float AMEX;
	private float GiftCard;
	private float Other;
	private Vector<Vector> AdditionInfo;
	
	private String DateStart;
	private String DateEnd;
	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}

	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}
	
	public String getDateStart() {
		return DateStart;
	}

	public String getDateEnd() {
		return DateEnd;
	}

	public float getCash() {
		return Cash;
	}

	public void setCash(float cash) {
		Cash = cash;
	}

	public float getVisa() {
		return visa;
	}

	public void setVisa(float visa) {
		this.visa = visa;
	}

	public float getMastercard() {
		return Mastercard;
	}

	public void setMastercard(float mastercard) {
		Mastercard = mastercard;
	}

	public float getAMEX() {
		return AMEX;
	}

	public void setAMEX(float aMEX) {
		AMEX = aMEX;
	}

	public float getGiftCard() {
		return GiftCard;
	}

	public void setGiftCard(float giftCard) {
		GiftCard = giftCard;
	}

	public float getOther() {
		return Other;
	}

	public void setOther(float other) {
		Other = other;
	}




	public float getTotal() {
		return total;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount( float discount) {
		this.discount = discount;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public float getGST() {
		return GST;
	}


	public void setGST(float gST) {
		GST = gST;
	}


	public float getPST() {
		return PST;
	}


	public void setPST(float pST) {
		PST = pST;
	}


	public float getTips() {
		return tips;
	}


	public void setTips(float tips) {
		this.tips = tips;
	}


	public Vector<Vector> getAdditionInfo() {
		return AdditionInfo;
	}


	public void setAdditionInfo(Vector<Vector> additionInfo) {
		AdditionInfo = additionInfo;
	}


	public String addSpace(String in) {
		String out = "";

		int space = 28;

		for(int i = 1; i <=(space - in.length());i++) {
			out = out + " ";
		}
		out  = out + in; 



		return out;


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
			int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength;

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
				//int headerRectHeighta=40;



				g2d.setFont(new Font("Monospaced",Font.BOLD,12));

				NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);


				g2d.drawString("        Tomato's             ",12,y);y+=yShift; 
				g2d.drawString("    The Indian Flavor        ",12,y);y+=yShift;
				g2d.drawString("     #101 7238 137st         ",12,y);y+=yShift;
				g2d.drawString("   Surrey B.C. V3W 1V3       ",12,y);y+=yShift;
				g2d.drawString("  Ph No. - 604-502-0206      ",12,y);y+=yShift;
				g2d.drawString("      www.Tomatos.ca          ",12,y);y+=yShift;
				g2d.drawString("",12,y);y+=yShift;
				g2d.drawString(String.valueOf(Calendar.getInstance().getTime()),12,y);y+=yShift;	            

				g2d.drawString("",12,y);y+=yShift;
				g2d.drawString("          Sales Report       ",12,y);y+=headerRectHeight;
				g2d.drawString("=============================",12,y);y+=headerRectHeight;
				
				if(this.DateStart != null && this.DateStart != "") {
					g2d.drawString("",12,y);y+=yShift;
		             g2d.drawString("",12,y);y+=yShift;
		            g2d.drawString(this.addSpace("Date: " + this.DateStart +" -" + this.DateEnd + ""),12,y);y+=yShift;
		            g2d.drawString(this.addSpace("============================="),12,y);y+=headerRectHeight;
				}
				g2d.drawString("",12,y);y+=yShift;	     
				 g2d.drawString(this.addSpace("Net Sales: "+ n.format((this.getTotal()))),12,y);y+=yShift;
				 g2d.drawString(this.addSpace("-Discount: "+ n.format((this.getDiscount()))),12,y);y+=yShift;
				 g2d.drawString(this.addSpace("GST: "+ n.format((this.getGST()))),12,y);y+=yShift;
				 g2d.drawString(this.addSpace("PST: "+ n.format((this.getPST()))),12,y);y+=yShift;      

				 g2d.drawString("",12,y);y+=yShift;



				 g2d.drawString("-----------------------------",10,y);y+=yShift;
				 g2d.drawString("",12,y);y+=yShift;
				 g2d.drawString(this.addSpace("Total Receivable: "+ n.format((this.getTotal() + this.getGST() + this.getPST() - this.getDiscount()))),12,y);y+=yShift;
				 g2d.drawString("============================",12,y);y+=headerRectHeight;
				 g2d.drawString("       Payment Methods      ",12,y);y+=headerRectHeight;
				 g2d.drawString("============================",12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Cash: "+ n.format((this.getCash() + (this.getCash()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Debit: "+ n.format((this.getDebit() + (this.getDebit()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Visa: "+ n.format((this.getVisa() + (this.getVisa()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Master Card: "+ n.format((this.getMastercard() + (this.getMastercard()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("American Express: "+ n.format((this.getAMEX()+ (this.getAMEX()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Other: "+ n.format((this.getOther()+ (this.getOther()*5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString(this.addSpace("Gift Card: "+ n.format((this.getGiftCard()+ (this.getGiftCard() *5/100)))),12,y);y+=headerRectHeight;
				 g2d.drawString("",12,y);y+=yShift;
				 /*g2d.drawString("============================",12,y);y+=headerRectHeight;
				  */ g2d.drawString("",12,y);y+=yShift;
				  // g2d.drawString(this.addSpace(Float.toString(total + total*5/100)),12,y);y+=headerRectHeight;

				  g2d.setFont(new Font("Monospaced",Font.BOLD,12));
				  g2d.drawString("",12,y);y+=yShift;
				  g2d.drawString("-----------------------------",10,y);y+=yShift;
				  g2d.drawString("",12,y);y+=yShift;
				  g2d.drawString("-----------------------------",10,y);y+=yShift;







				  

			}
			catch(Exception r){
				r.printStackTrace();
			}

			result = PAGE_EXISTS;    
		}    
		return result;    
	}
}



