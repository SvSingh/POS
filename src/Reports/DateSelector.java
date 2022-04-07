package Reports;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.FlowLayout;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

public class DateSelector extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnNewButton,btnNewButton_1;
	JDateChooser dateChooser,dateChooser_1;
	JLabel MessageLabel;
	DateEventListener DEL;
	


	public DateSelector() {
		
		
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Select the date You want to generate the Report for.");
		lblNewLabel.setPreferredSize(new Dimension(400, 14));
		lblNewLabel.setBounds(66, 11, 344, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setBounds(10, 62, 100, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(264, 62, 100, 21);
		contentPane.add(lblEndDate);
		
		btnNewButton = new JButton("Generate Report");
		btnNewButton.setBounds(65, 134, 128, 23);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(217, 134, 116, 23);
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 94, 233, 20);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(264, 94, 211, 20);
		contentPane.add(dateChooser_1);
		
		MessageLabel = new JLabel("");
		MessageLabel.setBounds(10, 164, 481, 14);
		contentPane.add(MessageLabel);
	}


	public DateEventListener getDEL() {
		return DEL;
	}


	public void setDEL(DateEventListener dEL) {
		DEL = dEL;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton_1) {
			this.dispose();
		}
		
		else if(e.getSource() == btnNewButton) {
			
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
			if(dateChooser.getDate() != null && dateChooser_1.getDate() != null ) {
				String startDate = dt1.format(dateChooser.getDate());
				String EndDate = dt1.format(dateChooser_1.getDate());
				
				DateEvent DE = new DateEvent(this,startDate,EndDate);
				
				if(DEL != null) {
					
						DEL.DateEventOccured(DE);
					
				}
				
				this.dispose();
			}
			else {
				MessageLabel.setText("PLease eneter all dates.");
				
				this.revalidate();
				this.repaint();
			}
			

			
		}
		
		
	}
}
