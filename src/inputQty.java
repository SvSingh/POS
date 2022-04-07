import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;



public class inputQty extends JFrame implements ActionListener {
	
	
	private int qty;
	private JTextField textField;
	private JButton button,btnNewButton,btnRemove;
	JButton btnCancel,btnOk;
	QtyEventListener QEL;
	
	public boolean active = true;
	
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setQtylistener(QtyEventListener QEL) {
		this.QEL = QEL;
	}
	
	
	public inputQty(int Qty) {
		setUndecorated(true);
		this.qty = Qty;
		setPreferredSize(new Dimension(600, 400));
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		getContentPane().setSize(600, 400);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the Quanitity");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(20, 47, 240, 38);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 37));
		textField.setText(String.valueOf(qty));
		//textField.setText("0");
		textField.setBounds(86, 107, 89, 53);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("-\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnNewButton.setBounds(10, 107, 77, 53);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.BOLD, 26));
		button.setBounds(173, 107, 77, 53);
		panel.add(button);
		button.addActionListener(this);
		
		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnOk.setBounds(10, 230, 114, 38);
		panel.add(btnOk);
		btnOk.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCancel.setBounds(122, 230, 128, 38);
		panel.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton[] numButton = new JButton[] {};
		
		for(int x = 9;x >=0; x--) {
			if(x == 0) {
				panel_1.add(new JLabel(""));
				JButton btn = new JButton(String.valueOf(x));
				panel_1.add(btn);
				btnRemove = new JButton("<");
				panel_1.add(btnRemove);
				btnRemove.setFont(new Font("Tahoma", Font.BOLD, 26));
				btnRemove.addActionListener(this);
				btn.setFont(new Font("Tahoma", Font.BOLD, 26));
				btn.addActionListener(this);
				
			}
			else {
				JButton btn = new JButton(String.valueOf(x));
				panel_1.add(btn);
				btn.setFont(new Font("Tahoma", Font.BOLD, 26));
				btn.addActionListener(this);
			}
			
		}
		pack();
		setVisible(true);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton){
			if(e.getSource() == btnNewButton) {
				
				qty = Integer.parseInt( textField.getText());
				qty--;
				textField.setText(String.valueOf(qty));
				
			}
			else if(e.getSource() == button) {
				qty = Integer.parseInt( textField.getText());
				qty++;
				textField.setText(String.valueOf(qty));
			}
			else if (e.getSource() == btnRemove) {
				if(!textField.getText().equals("")) {
					textField.setText(textField.getText().substring(0,textField.getText().length() - 1));
				}
					
			}
			else if(e.getSource() == btnOk) {
				qty = Integer.parseInt( textField.getText());
				qtyEvent qE = new qtyEvent(this,qty);
				if(QEL != null) {
					
					QEL.qtyEventOccured(qE);
				}
				
				this.dispose();
				
				}
			else if(e.getSource() == btnCancel) {
				this.dispose();
				active = false;
			}
			else {
				if(textField.getText().equals("")) {
					qty = 0;
				}
				else {
					qty = Integer.parseInt((String) textField.getText());
				}
				
				JButton b = (JButton)e.getSource();
				textField.setText(String.valueOf(qty) + b.getText());
			}
		}
		
	}
}



