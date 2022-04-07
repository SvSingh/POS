import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;

public class getCustomerDetail extends JFrame implements ActionListener {
	
	private String customerName;
	private String customerNumber;
	private JTextField textName;
	private JTextField textnumber;
	private JButton btnSubmit,btnCancel;
	
	private CustomerListener Cl;
	
	
	
	public void setListener(CustomerListener Cl) {
		this.Cl = Cl;
	}
	
	
	public getCustomerDetail(String customerName,String customerNumber) {
		setLocationByPlatform(true);
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Name :");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 64, 244, 41);
		panel.add(lblNewLabel);
		
		JLabel lblCustomerNumber = new JLabel("Customer Number:");
		lblCustomerNumber.setHorizontalTextPosition(SwingConstants.LEFT);
		lblCustomerNumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCustomerNumber.setBounds(10, 129, 244, 41);
		panel.add(lblCustomerNumber);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.BOLD, 22));
		textName.setBounds(10, 70, 244, 34);
		panel_1.add(textName);
		textName.setText(customerName);
		textName.setColumns(10);
		
		textnumber = new JTextField();
		textnumber.setFont(new Font("Tahoma", Font.BOLD, 22));
		textnumber.setColumns(10);
		textnumber.setBounds(10, 132, 244, 34);
		textnumber.setText(customerNumber);
		panel_1.add(textnumber);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setHorizontalAlignment(SwingConstants.LEFT);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSubmit.setBounds(10, 241, 120, 42);
		panel_1.add(btnSubmit);
		
		btnSubmit.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBounds(140, 241, 120, 42);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSubmit) {
			if(Cl != null) {
				
				CustomerEvent CE = new CustomerEvent(this,textName.getText(),textnumber.getText());
				Cl.customerEventOccured(CE);
			}
			
			this.dispose();
			
		}
		else if (e.getSource() == btnCancel) {
			this.dispose();
		}
		// TODO Auto-generated method stub
		
	}
}
