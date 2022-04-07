import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class mainButtons extends JPanel implements ActionListener {
	
	private JButton btnTakeOut,btnStayIN,btnPayment,btnReturn,btnChangeId,btnSales,btnTips;
	private JButton btnCustomer;
	private MainButtonListener MBL;
	private JButton btnDiscount;
	
	
	mainButtons(){
		
		setBackground(new Color(245, 222, 179));
		setLayout(new GridLayout(10, 1, 0, 0));
		
		btnStayIN = new JButton("Stay IN");
		btnStayIN.setIconTextGap(0);
		btnStayIN.setHorizontalTextPosition(SwingConstants.LEFT);
		btnStayIN.setHorizontalAlignment(SwingConstants.LEFT);
		btnStayIN.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnStayIN.setBackground(SystemColor.activeCaption);
		btnStayIN.setAlignmentY(0.0f);
		btnStayIN.addActionListener(this);
		add(btnStayIN);
		
		btnTakeOut = new JButton("Take OUT");
		btnTakeOut.setAlignmentY(Component.TOP_ALIGNMENT);
		btnTakeOut.setHorizontalTextPosition(SwingConstants.LEFT);
		btnTakeOut.setIconTextGap(0);
		btnTakeOut.setBackground(SystemColor.activeCaption);
		btnTakeOut.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnTakeOut.setHorizontalAlignment(SwingConstants.LEFT);
		add(btnTakeOut);
		btnTakeOut.addActionListener(this);
		
		btnPayment = new JButton("Payment");
		btnPayment.setIconTextGap(0);
		btnPayment.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPayment.setHorizontalAlignment(SwingConstants.LEFT);
		btnPayment.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnPayment.setBackground(SystemColor.activeCaption);
		btnPayment.setAlignmentY(0.0f);
		add(btnPayment);
		btnPayment.addActionListener(this);
		
		btnDiscount = new JButton("Discount");
		btnDiscount.setIconTextGap(0);
		btnDiscount.setHorizontalTextPosition(SwingConstants.LEFT);
		btnDiscount.setHorizontalAlignment(SwingConstants.LEFT);
		btnDiscount.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnDiscount.setBackground(SystemColor.activeCaption);
		btnDiscount.setAlignmentY(0.0f);
		add(btnDiscount);
		btnDiscount.addActionListener(this);
		
		btnSales = new JButton("Reports");
		btnSales.setIconTextGap(0);
		btnSales.setHorizontalTextPosition(SwingConstants.LEFT);
		btnSales.setHorizontalAlignment(SwingConstants.LEFT);
		btnSales.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnSales.setBackground(SystemColor.activeCaption);
		btnSales.setAlignmentY(0.0f);
		add(btnSales);
		btnSales.addActionListener(this);
		
		btnReturn = new JButton("Return");
		btnReturn.setIconTextGap(0);
		btnReturn.setHorizontalTextPosition(SwingConstants.LEFT);
		btnReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnReturn.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnReturn.setBackground(SystemColor.activeCaption);
		btnReturn.setAlignmentY(0.0f);
		add(btnReturn);
		btnReturn.addActionListener(this);
		
		btnChangeId = new JButton("Change ID");
		btnChangeId.setIconTextGap(0);
		btnChangeId.setHorizontalTextPosition(SwingConstants.LEFT);
		btnChangeId.setHorizontalAlignment(SwingConstants.LEFT);
		btnChangeId.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnChangeId.setBackground(SystemColor.activeCaption);
		btnChangeId.setAlignmentY(0.0f);
		add(btnChangeId);
		btnChangeId.addActionListener(this);
		
		btnTips = new JButton("Tips");
		btnTips.setIconTextGap(0);
		btnTips.setHorizontalTextPosition(SwingConstants.LEFT);
		btnTips.setHorizontalAlignment(SwingConstants.LEFT);
		btnTips.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnTips.setBackground(SystemColor.activeCaption);
		btnTips.setAlignmentY(0.0f);
		add(btnTips);
		btnTips.addActionListener(this);
		
		btnCustomer = new JButton("Customer");
		btnCustomer.setIconTextGap(0);
		btnCustomer.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setFont(new Font("Sitka Subheading", Font.BOLD, 12));
		btnCustomer.setBackground(SystemColor.activeCaption);
		btnCustomer.setAlignmentY(0.0f);
		add(btnCustomer);
		btnCustomer.addActionListener(this);	
		
		
	}
	
	public void setListener(MainButtonListener MBL) {
		this.MBL = MBL;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String btnPressed = "";
		
		if(e.getSource() == btnTakeOut) {
			btnPressed = "TakeOut";
			
			
		}
		else if(e.getSource() == btnStayIN) {
			btnPressed = "StayIN";
			
		}
		else if (e.getSource() == btnPayment) {
			btnPressed =  "Payment";
		}
		else if(e.getSource() == btnDiscount) {
			btnPressed = "Discount"
;		}
		else if(e.getSource() == btnCustomer) {
			btnPressed = "Customer";
		}
		
		else if(e.getSource() == btnSales) {
			btnPressed = "reports";
		}
		
		MainButtonEvent MBE = new MainButtonEvent(this,btnPressed);
		if(MBL != null) {
			MBL.mainButtonEventOccured(MBE);
		}
		
	}

}
