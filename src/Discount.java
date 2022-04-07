import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Discount extends Panel implements ActionListener {
	
	
	JButton fivePercent,btn10Discount,btn15Discount,btn20Discount,btnStaffMeal,btnManagerMeal;
	
	listPanel lp;
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	
	DefaultTableModel model ;
	
	float discount;
	public Discount(listPanel lp) {
		this.discount = lp.discount;
		this.lp = lp;
		
		model = (DefaultTableModel) lp.table.getModel();
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(700, 500));
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		fivePercent = new JButton("5% Discount");
		fivePercent.setForeground(new Color(255, 255, 255));
		fivePercent.setBackground(new Color(255, 153, 0));
		fivePercent.setHorizontalAlignment(SwingConstants.LEFT);
		fivePercent.setFont(new Font("Tahoma", Font.BOLD, 22));
		fivePercent.setPreferredSize(new Dimension(200, 60));
		add(fivePercent);		
		fivePercent.addActionListener(this);
		
		btn10Discount = new JButton("10% Discount");
		btn10Discount.setForeground(new Color(255, 255, 255));
		btn10Discount.setBackground(new Color(255, 153, 0));
		btn10Discount.setHorizontalAlignment(SwingConstants.LEFT);
		btn10Discount.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn10Discount.setPreferredSize(new Dimension(200, 60));
		add(btn10Discount);
		btn10Discount.addActionListener(this);
		
		btn15Discount = new JButton("15% Discount");
		btn15Discount.setForeground(new Color(255, 255, 255));
		btn15Discount.setBackground(new Color(255, 153, 0));
		btn15Discount.setHorizontalAlignment(SwingConstants.LEFT);
		btn15Discount.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn15Discount.setPreferredSize(new Dimension(200, 60));
		add(btn15Discount);
		btn15Discount.addActionListener(this);
		
		btn20Discount= new JButton("20% Discount");
		btn20Discount.setForeground(new Color(255, 255, 255));
		btn20Discount.setBackground(new Color(255, 153, 0));
		btn20Discount.setHorizontalAlignment(SwingConstants.LEFT);
		btn20Discount.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn20Discount.setPreferredSize(new Dimension(200, 60));
		add(btn20Discount);
		btn20Discount.addActionListener(this);
		
		
		btnStaffMeal = new JButton("Staff Meal");
		btnStaffMeal.setForeground(new Color(255, 255, 255));
		btnStaffMeal.setBackground(new Color(255, 153, 0));
		btnStaffMeal.setHorizontalAlignment(SwingConstants.LEFT);
		btnStaffMeal.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnStaffMeal.setPreferredSize(new Dimension(200, 60));
		add(btnStaffMeal);
		btnStaffMeal.addActionListener(this);
		
		
		btnManagerMeal = new JButton("Manager Meal");
		btnManagerMeal.setForeground(new Color(255, 255, 255));
		btnManagerMeal.setBackground(new Color(255, 153, 0));
		btnManagerMeal.setHorizontalAlignment(SwingConstants.LEFT);
		btnManagerMeal.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnManagerMeal.setPreferredSize(new Dimension(200, 60));
		add(btnManagerMeal);
		btnManagerMeal.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fivePercent && lp.discount == 0) {
			lp.discount = (5 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: 5 Percent" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount)	 + "</font></html>"				
			});
		}
		else if(e.getSource() == btn10Discount && lp.discount == 0) {
			lp.discount = (10 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: 10 Percent" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount)	 + "</font></html>"				
			});
		}
		else if(e.getSource() == btn15Discount && lp.discount == 0) {
			lp.discount = (15 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: 15 Percent" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount) + "</font></html>"					
			});
		}
		else if(e.getSource() == btn20Discount && lp.discount == 0) {
			lp.discount = (20 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: 20 Percent" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount)	 + "</font></html>"				
			});
		}
		else if(e.getSource() == btnStaffMeal && lp.discount == 0) {
			lp.discount = (50 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: Staff Meal" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount) + "</font></html>"					
			});
		}
		else if(e.getSource() == btnManagerMeal && lp.discount == 0) {
			lp.discount = (100 * lp.total)/100;
			lp.total = lp.total - lp.discount;
			lp.DisplayTotal();
			model.addRow(new Object[] {
					"<html><font color=red>" +"Discount: Manager Meal" + "</font></html>",
					"<html><font color=red>" +"" + "</font></html>",
					"<html><font color=red>" +"-"+n.format(lp.discount) + "</font></html>"					
			});
		}
		
	}
	
	

}
