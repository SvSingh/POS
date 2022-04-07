import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class Payment extends JFrame implements ActionListener {
	
	String type;
	private Order order;
	private listPanel lp;
	private JTextField txtType;
	private JTextField txtSubTotal;
	private JButton btnNewButton,btnCancel,remove;
	private Double total;
	DecimalFormat df = new DecimalFormat("0.00");
	
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private JTextField textField;
	
	public Payment(String type,listPanel lp) {
		getContentPane().setPreferredSize(new Dimension(880, 525));
		this.lp = lp;
		this.order = lp.getOrder();		
		lp.save();
		
		
		Vector<Object> TableInfo;
		
		if(lp.TableSelected.contains("A") || lp.TableSelected.contains("B") || lp.TableSelected.contains("C") ) {
			
			
			TableInfo = lp.db.getStayTableInfo(lp.TableSelected);		
			
		}
		
		else {	
			
			TableInfo = lp.db.getTakeOutTableInfo(Integer.parseInt(lp.TableSelected));
			
		}
		
		order.setOrder(TableInfo);
		
		
		
		total = order.getSubtotal() + order.getGST() + order.getPST();
		
		this.type = type;
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtType = new JTextField();
		txtType.setBackground(Color.WHITE);
		if(type.equals("") == false) {
			txtType.setEditable(false);
		}
		
		txtType.setHorizontalAlignment(SwingConstants.RIGHT);
		txtType.setFont(new Font("Sylfaen", Font.BOLD, 22));
		txtType.setBounds(211, 32, 203, 43);
		panel.add(txtType);
		txtType.setColumns(10);
		txtType.setText(type);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBackground(Color.WHITE);
		txtSubTotal.setEditable(false);
		txtSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubTotal.setFont(new Font("Sylfaen", Font.BOLD, 22));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(211, 104, 203, 43);
		panel.add(txtSubTotal);
		txtSubTotal.setText(n.format(total));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Sylfaen", Font.BOLD, 22));
		textField.setColumns(10);
		textField.setBounds(211, 176, 203, 43);
		panel.add(textField);
		
		if(type == "Cash") {
			
			
			JLabel lblCashRecieved = new JLabel("Cash Recieved:");
			lblCashRecieved.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCashRecieved.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblCashRecieved.setBounds(20, 188, 181, 29);
			panel.add(lblCashRecieved);		
			
			total = Math.round(total * 20.0) / 20.0;
			txtSubTotal.setText(n.format(total));
			
			
		}
		else {
			
			JLabel lblTip = new JLabel("TIP:");
			lblTip.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTip.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblTip.setBounds(20, 188, 181, 29);
			panel.add(lblTip);	
			
		}
		
		JLabel lblNewLabel = new JLabel("Payment Type:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(37, 46, 164, 29);
		panel.add(lblNewLabel);
		
		JLabel lblTotalAmount = new JLabel("Total $ Amount:");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTotalAmount.setBounds(20, 118, 181, 29);
		panel.add(lblTotalAmount);
		
		
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(37, 410, 164, 43);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCancel.setBounds(211, 410, 164, 43);
		panel.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11,BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(4, 3, 0, 0));
		
		
		for(int x = 9;x >=0; x--) {
			if(x == 0) {
				JButton zero =new JButton(".");
				panel_11.add(zero);
				zero.setFont(new Font("Tahoma", Font.BOLD, 26));
				zero.addActionListener(this);
				JButton btn = new JButton(String.valueOf(x));
				panel_11.add(btn);				
				btn.setFont(new Font("Tahoma", Font.BOLD, 26));
				btn.addActionListener(this);
				remove = new JButton("<-");
				panel_11.add(remove);
				remove.setFont(new Font("Tahoma", Font.BOLD, 26));
				remove.addActionListener(this);
				
				
			}
			else {
				JButton btn = new JButton(String.valueOf(x));
				panel_11.add(btn);
				btn.setFont(new Font("Tahoma", Font.BOLD, 26));
				btn.addActionListener(this);
			}
			
		}
		pack();
		
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean done = false;
		
		
		if(e.getSource() == btnNewButton) {
			
			order.setActive(false);
			if(!textField.getText().toString().replace("$","").equals("")) {
				if(type != "Cash") {
					order.setTIP(Double.valueOf(textField.getText().toString().replace("$","")));
					done = true;
				}
				else {
					if(Double.valueOf(textField.getText().toString().replace("$","")) < total) {
						JOptionPane.showMessageDialog(this,"The amount you enetered is less than the Amount needed");
					}
					
					else {
						JOptionPane.showMessageDialog(this,"The Change is: $" + df.format(Double.valueOf(textField.getText().toString().replace("$","")) - total));
						done = true;
					}
					 
				}
				
			}
			else {
				if(type == "Cash") {
					
					JOptionPane.showMessageDialog(this,"please put the right Amount");
				}
				else {
					order.setTIP((double) 0.00);
					done = true;
				}
					
			}
			
			if(done) {
				order.setPaymentType(txtType.getText());
				order.setActive(false);
				order.save();
				order.setPrintItem(order.getListItems());
				order.recieptprint();
				lp.main.setLayout();
				this.dispose();
				
				
				
			}
			
			
			
			
			
			
			
		}
		else if (e.getSource() == btnCancel) {
			this.dispose();
		}
		else if(e.getSource() == remove) {
			if(!textField.getText().equals("")) {
				textField.setText(textField.getText().substring(0,textField.getText().length() - 1));
			}
		}
		else {
			
			
			
				String num =  textField.getText();
				
				if(num.equals("")) {
					num = "$";
				}
					
			JButton b = (JButton)e.getSource();
			textField.setText(String.valueOf(num) + b.getText());
		}
	}
}
