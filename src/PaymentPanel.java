import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PaymentPanel extends Panel implements ActionListener { 
	
	
	private JButton btnCash,btnVisa,btnMastercard,btnAmericanEx,btnGiftCard,btnOther,btnDebit;
	private listPanel lp;
	
	public PaymentPanel(listPanel lp) {
		
		this.lp = lp;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		btnCash = new JButton("CASH");
		btnCash.setBackground(new Color(0, 255, 153));
		btnCash.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCash.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnCash);
		btnCash.addActionListener(this);
		
		btnVisa = new JButton("VISA");
		btnVisa.setBackground(new Color(0, 255, 153));
		btnVisa.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnVisa.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnVisa);
		btnVisa.addActionListener(this);
		
		btnDebit = new JButton("Debit");
		btnDebit.setBackground(new Color(0, 255, 153));
		btnDebit.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDebit.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnDebit);
		btnDebit.addActionListener(this);
		
		btnMastercard = new JButton("MSTRCARD");
		btnMastercard.setBackground(new Color(0, 255, 153));
		btnMastercard.setHorizontalAlignment(SwingConstants.LEFT);
		btnMastercard.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnMastercard.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnMastercard);
		btnMastercard.addActionListener(this);
		
		btnAmericanEx = new JButton("American EX");
		btnAmericanEx.setBackground(new Color(0, 255, 153));
		btnAmericanEx.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAmericanEx.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnAmericanEx);
		btnAmericanEx.addActionListener(this);
		
		btnGiftCard = new JButton("Gift Card");
		btnGiftCard.setBackground(new Color(0, 255, 153));
		btnGiftCard.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnGiftCard.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnGiftCard);
		btnGiftCard.addActionListener(this);
		
		btnOther = new JButton("Other");
		btnOther.setBackground(new Color(0, 255, 153));
		btnOther.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnOther.setPreferredSize(new Dimension(200, 50));
		panel_1.add(btnOther);
		btnOther.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String type = "";
				
		if(e.getSource() == btnCash){
			type = "Cash";
		}
		else if(e.getSource() == btnVisa) {
			type = "Visa";
		}
		else if(e.getSource() == btnMastercard) {
			type = "MasterCard";
		}
		else if(e.getSource() == btnAmericanEx) {
			type = "American Express";
		}
		else if(e.getSource() == btnOther) {
			type = "Other";
		}
		else if(e.getSource() == btnDebit) {
			type = "Debit";
		}
		else if(e.getSource() == btnGiftCard) {
			type = "Gift Card";
		}
				
		Payment payment = new Payment(type,lp);
		payment.setVisible(true);
		payment.setSize(890, 525);
		payment.setLocationRelativeTo(this);
		
		
		
	}
	
	
	

}
