package Reports;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JPanel;

public class ReportCanvas extends JPanel {
	
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
	public String getDateStart() {
		return DateStart;
	}

	public String getDateEnd() {
		return DateEnd;
	}


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

		int space = 35;

		for(int i = 1; i <=(space - in.length());i++) {
			out = out + " ";
		}
		out  = out + in; 



		return out;


	}


	 public void paintComponent(Graphics g) {
	      if(g instanceof Graphics2D)
	      {
	    	  
	    	
	        Graphics2D g2d = (Graphics2D)g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        RenderingHints.VALUE_ANTIALIAS_ON);
	        g2d.setColor(Color.WHITE);
	        g2d.fillRect(0, 0, 500, 800);
	        g2d.setColor(Color.BLACK);
	       
	        
	        int y=20;
			int yShift = 10;
			int headerRectHeight=15;
			
			g2d.setFont(new Font("Monospaced",Font.BOLD,12));

			NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);


			g2d.drawString(this.addSpace("        Tomato's             "),12,y);y+=yShift; 
			g2d.drawString(this.addSpace("    The Indian Flavor        "),12,y);y+=yShift;
			g2d.drawString(this.addSpace("     #101 7238 137st         "),12,y);y+=yShift;
			g2d.drawString(this.addSpace("   Surrey B.C. V3W 1V3       "),12,y);y+=yShift;
			g2d.drawString(this.addSpace("  Ph No. - 604-502-0206      "),12,y);y+=yShift;
			g2d.drawString(this.addSpace("      www.Tomatos.ca          "),12,y);y+=yShift;
			g2d.drawString("",12,y);y+=yShift;
			g2d.drawString(this.addSpace(String.valueOf(Calendar.getInstance().getTime())),12,y);y+=yShift;	            

			g2d.drawString("",12,y);y+=yShift;
			g2d.drawString(this.addSpace("          Sales Report       "),12,y);y+=headerRectHeight;
			g2d.drawString(this.addSpace("============================="),12,y);y+=headerRectHeight;
			
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
			
			 g2d.drawString(this.addSpace("-----------------------------"),10,y);y+=yShift;
			 g2d.drawString("",12,y);y+=yShift;
			 g2d.drawString(this.addSpace(this.addSpace("Total Receivable: "+ n.format((this.getTotal() + this.getGST() + this.getPST() - this.getDiscount())))),12,y);y+=yShift;
			 g2d.drawString(this.addSpace("============================"),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace("       Payment Methods      "),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace("============================"),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Cash: "+ n.format((this.getCash() + (this.getCash()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Debit: "+ n.format((this.getDebit() + (this.getDebit()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Visa: "+ n.format((this.getVisa() + (this.getVisa()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Master Card: "+ n.format((this.getMastercard() + (this.getMastercard()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("American Express: "+ n.format((this.getAMEX()+ (this.getAMEX()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Other: "+ n.format((this.getOther()+ (this.getOther()*5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(this.addSpace("Gift Card: "+ n.format((this.getGiftCard()+ (this.getGiftCard() *5/100))))),12,y);y+=headerRectHeight;
			 g2d.drawString(this.addSpace(""),12,y);y+=yShift;
			 
			 
			 g2d.setFont(new Font("Monospaced",Font.BOLD,12));
			  g2d.drawString("",12,y);y+=yShift;
			  g2d.drawString(this.addSpace("-----------------------------"),10,y);y+=yShift;
			  g2d.drawString(this.addSpace(""),12,y);y+=yShift;
			  g2d.drawString(this.addSpace("-----------------------------"),10,y);y+=yShift;
			
	        
	        	       }
	   }
}


