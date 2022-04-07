package Customer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Database.Database;

public class Customer extends JPanel implements ActionListener {
	private JTextField textField;
	JPanel panel_1 ;
	private Database db;
	private Vector<Vector> Cust;
	private CustomerPanelListener CPL;
	
		
	public Customer(Database db) {
		
		this.db = db;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		add(panel,BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Please Enter the Phone Number:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				
				createCutomer();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
				createCutomer();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
				createCutomer();
			}
			
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(10, 0, 0, 0));
		
		
		
		
		
	}

	public void createCutomer() {
		if(!textField.getText().equals("")) {
			
			panel_1.removeAll();
			
			Cust = db.fetchCustomers(textField.getText().trim());
			for(int x = 0;x < Cust.size();x++) {
				JButton customer = new JButton((String)Cust.elementAt(x).elementAt(1));
				
				customer.addActionListener(this);
				
				panel_1.add(customer);
				
				
			}
			
			panel_1.repaint();
			panel_1.revalidate();
		}
	}
	
	public void setListener(CustomerPanelListener CPL) {
		this.CPL = CPL;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(CPL != null) {
			
			int id = 0;
			
			for(int x = 0;x < Cust.size();x++) {
				if(((String)Cust.elementAt(x).elementAt(1)).contains(((JButton)e.getSource()).getText())){
					id = (int) Cust.elementAt(x).elementAt(0);
				}
			}
			CPL.CustomerEventOccured(new CustomerPanelEvent(this,id));
		}
		
	}
}
