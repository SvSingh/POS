import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import Database.Database;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

public class StayInLayout extends JPanel implements ActionListener {
	
	
	private SILListener sillistener;
	
	private JButton A2,A1,A3,
					B1,B2,B3;
	
	private Vector<JButton> buttons;
	
	private Vector<String> active;
	private Vector<Vector> tableInfo;
	
	Database db;
	private JButton A4;
	private JButton B4;
	private JButton A5;
	private JButton B5;
	
	public StayInLayout(Database db) {
		
		this.db = db;
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		
		buttons = new Vector<JButton>();
		setLayout(new GridLayout(0, 2, 0, 0));
		
		A1 = new JButton("A1");
		A1.setMargin(new Insets(25, 25, 25, 25));
		A1.setBackground(new Color(255, 127, 80));
		A1.addActionListener(this);
		add(A1);
		buttons.add(A1);
		A1.setForeground(Color.WHITE);
		
		
		A3 = new JButton("A3");
		A3.setMargin(new Insets(25, 25, 25, 25));
		A3.setForeground(Color.WHITE);
		A3.setFont(new Font("Tahoma", Font.BOLD, 15));
		A3.setBackground(new Color(255, 127, 80));
		A3.addActionListener(this);
		
		A2 = new JButton("A2");
		A2.setMargin(new Insets(25, 25, 25, 25));
		A2.setBackground(new Color(255, 127, 80));
		A2.addActionListener(this);
		
		B1 = new JButton("B1");
		B1.setMargin(new Insets(25, 25, 25, 25));
		B1.setBackground(new Color(255, 127, 80));
		B1.addActionListener(this);
		add(B1);
		buttons.add(B1);
		B1.setForeground(Color.WHITE);
		add(A2);
		buttons.add(A2);
		A2.setForeground(Color.WHITE);
		
		B2 = new JButton("B2");
		B2.setMargin(new Insets(25, 25, 25, 25));
		B2.setBackground(new Color(255, 127, 80));
		B2.addActionListener(this);
		add(B2);
		buttons.add(B2);
		B2.setForeground(Color.WHITE);
		add(A3);
		buttons.add(A3);
		
		B3 = new JButton("B3");
		B3.setMargin(new Insets(25, 25, 25, 25));
		B3.setBackground(new Color(255, 127, 80));
		B3.addActionListener(this);
		add(B3);
		buttons.add(B3);
		B3.setForeground(Color.WHITE);
		
		A4 = new JButton("A4");
		A4.setMargin(new Insets(25, 25, 25, 25));
		A4.setForeground(Color.WHITE);
		A4.setFont(new Font("Tahoma", Font.BOLD, 15));
		A4.setBackground(new Color(255, 127, 80));
		add(A4);
		
		B4 = new JButton("B4");
		B4.setMargin(new Insets(25, 25, 25, 25));
		B4.setForeground(Color.WHITE);
		B4.setBackground(new Color(255, 127, 80));
		add(B4);
		
		A5 = new JButton("A5");
		A5.setMargin(new Insets(25, 25, 25, 25));
		A5.setForeground(Color.WHITE);
		A5.setFont(new Font("Tahoma", Font.BOLD, 15));
		A5.setBackground(new Color(255, 127, 80));
		add(A5);
		
		B5 = new JButton("B5");
		B5.setMargin(new Insets(25, 25, 25, 25));
		B5.setForeground(Color.WHITE);
		B5.setBackground(new Color(255, 127, 80));
		add(B5);
		
		
		active = db.getActiveTable();
		
		
		
		
		/*
		for(int x = 0;x < active.size();x++) {
			
			tableInfo = db.getTableInfo(active.elementAt(x));
			for(int y = 0;y < buttons.size(); y++) {
				
				if(buttons.elementAt(y).getText().equals(tableInfo.elementAt(10).elementAt(1))) {
								
					//buttons.elementAt(y).setText("<html><div align = 'center'>" + tableInfo.elementAt(10).elementAt(1) + "<br>$" + tableInfo.elementAt(9).elementAt(1) + "</div></html>");
					
				}
				
			}
			
			
			
			
			
		}
		*/
		
		
		
		
		
	}
	
	
	public void setListener(SILListener sillistener) {
		
		this.sillistener = sillistener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		String TableSelected = ((AbstractButton) e.getSource()).getText();		
				
		TableEvent ev = new TableEvent(this,TableSelected);
		
		if(sillistener != null) {
			
			sillistener.SILEventOccured(ev);
		}
		
	}

}
