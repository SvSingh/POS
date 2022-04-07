package Reports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Database.Database;
import orderPrinting.Page;
import orderPrinting.RecieptPrint;

public class reportPanel extends JPanel implements ActionListener {

	private JButton btnOrders,btnSales,btnSalesCustom;

	private Reports reports;
	public void setReports( Reports reports) {
		this.reports = reports;
	}
	public reportPanel() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		btnOrders = new JButton("Today's Order");
		btnOrders.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnOrders.setForeground(new Color(255, 255, 255));
		btnOrders.setPreferredSize(new Dimension(200, 50));
		btnOrders.setBackground(new Color(102, 153, 153));
		add(btnOrders);

		btnOrders.addActionListener(this);

		btnSales = new JButton("Sales");
		btnSales.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnSales.setForeground(new Color(255, 255, 255));
		btnSales.setPreferredSize(new Dimension(200, 50));
		btnSales.setBackground(new Color(102, 153, 153));
		add(btnSales);
		btnSales.addActionListener(this);
		
		btnSalesCustom = new JButton("Custom Sales");
		btnSalesCustom.setPreferredSize(new Dimension(200, 50));
		btnSalesCustom.setForeground(Color.WHITE);
		btnSalesCustom.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnSalesCustom.setBackground(new Color(102, 153, 153));
		btnSalesCustom.addActionListener(this);
		add(btnSalesCustom);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(reports != null) {

			if(e.getSource() == btnOrders) {
				reports.adddTable();
			}
			else if (e.getSource() == btnSalesCustom) {
				
				DateSelector DateSelect = new DateSelector();
				
				DateSelect.setVisible(true);
				
				DateSelect.setSize(600, 450);	
				
				DateSelect.setDEL(new DateEventListener() {

					@Override
					public void DateEventOccured(DateEvent DE) {
						
						
						
						Database db = new Database();
						
						String StartDate = DE.getStartDate();
						String EndDate = DE.getEndDate();

						Float Discount = db.getSales("DiscountPrice",StartDate,EndDate);
						Float subtotal = db.getSales("SubTotal",StartDate,EndDate);
						subtotal = subtotal + Discount;
						Float GST = db.getSales("GST",StartDate,EndDate);
						Float PLT = db.getSales("PLT",StartDate,EndDate);

						float Visa = db.getSaleType("visa",StartDate,EndDate);
						float MasterCard = db.getSaleType("MasterCard",StartDate,EndDate);
						float cash = db.getSaleType("Cash",StartDate,EndDate);
						float AMEX = db.getSaleType("American Express",StartDate,EndDate);
						float Gift = db.getSaleType("Gift Card",StartDate,EndDate);
						float other = db.getSaleType("Other",StartDate,EndDate);
						float debit = db.getSaleType("debit",StartDate,EndDate);
						
					
						reports.textField.setTotal(subtotal);
						reports.textField.setGST(GST);
						reports.textField.setDiscount(Discount);
						reports.textField.setPST(PLT);
						reports.textField.setCash(cash);
						reports.textField.setAMEX(AMEX);
						reports.textField.setMastercard(MasterCard);
						reports.textField.setOther(other);
						reports.textField.setVisa(Visa);
						reports.textField.setGiftCard(Gift);
						reports.textField.setDebit(debit);
						reports.textField.setDateStart(StartDate);
						reports.textField.setDateEnd(EndDate);
						
						reports.addSaleReportText();
						
					}
					
					
					
					
				});
				
			
			}
			else if(e.getSource() == btnSales) {
				
				reports.addSaleReportText();
				
				Database db = new Database();

				Float Discount = db.getSales("DiscountPrice");
				Float subtotal = db.getSales("SubTotal");
				subtotal = subtotal + Discount;
				Float GST = db.getSales("GST");
				Float PLT = db.getSales("PLT");
				

				float Visa = db.getSaleType("visa");
				float MasterCard = db.getSaleType("MasterCard");
				float cash = db.getSaleType("Cash");
				float AMEX = db.getSaleType("American Express");
				float Gift = db.getSaleType("Gift Card");
				float other = db.getSaleType("Other");
				float debit = db.getSaleType("debit");
			
				reports.textField.setTotal(subtotal);
				reports.textField.setGST(GST);
				reports.textField.setDiscount(Discount);
				reports.textField.setPST(PLT);
				reports.textField.setCash(cash);
				reports.textField.setAMEX(AMEX);
				reports.textField.setMastercard(MasterCard);
				reports.textField.setOther(other);
				reports.textField.setVisa(Visa);
				reports.textField.setGiftCard(Gift);
				reports.textField.setDebit(debit);
				
			}
	
			
			

		}

	}

}
