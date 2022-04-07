import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Database.Database;

import java.awt.FlowLayout;

public class DisplayPanel extends JPanel implements ActionListener {
	
	private Database db;
	private Vector<String> Categories;
	private Vector<Vector> MenuItems;
	public JButton categories,item;
	private JPanel MenuPanel,CatPanel;
	private listPanel lp;
	private Order order;
	
	DisplayPanel(listPanel lp,Database db,Order order){		
		
		this.lp =  lp;
		
		
		this.order = order;
			
		setBackground(Color.WHITE);
		setBounds(95, 22, 800, 600);
		
		Categories = new Vector<String>();
		
		this.db = db;
		Categories = db.getCategories();
		
		//setForeground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
				
		
		ScrollPane sp = new ScrollPane();
		CatPanel = new JPanel();
		CatPanel.setBackground(Color.WHITE);
		CatPanel.setPreferredSize(new Dimension(50, 300));
		sp.setPreferredSize(new Dimension(50, 300));
		sp.add(CatPanel);
		//CatPanel.setBounds(0, 0, 906, 129);
		add(sp,BorderLayout.NORTH);
		CatPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		ScrollPane sp2 = new ScrollPane();
		MenuPanel = new JPanel();
		MenuPanel.setPreferredSize(new Dimension(300,800));
		MenuPanel.setBackground(Color.WHITE);
		//MenuPanel.setBounds(0, 128, 906, 544);
		sp2.add(MenuPanel);
		add(sp2,BorderLayout.CENTER);
		MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		
		
	
		Enumeration<String> enu = Categories.elements(); 
		  
       
			
		while (enu.hasMoreElements()) { 
           // System.out.println(enu.nextElement()); 
			
            categories = new JButton(enu.nextElement());
            categories.setPreferredSize(new Dimension(140,50));
            categories.setBackground(Color.LIGHT_GRAY);
            categories.setOpaque(true);
            categories.addActionListener(this);
            CatPanel.add(categories);	
		
		
        	}
		}

	
	public void actionPerformed(ActionEvent e) {
		
		String bPressed = ((AbstractButton) e.getSource()).getText();
		
		if(Categories.contains(bPressed)) {
			
			layMenuPanel(((AbstractButton) e.getSource()).getText());			
		}
		
		else {
				
			DefaultTableModel model = (DefaultTableModel) lp.table.getModel();
			
			float price = db.getPrice(bPressed);
			
			boolean gst = db.getgst(bPressed);
			
			boolean plt = db.getplt(bPressed);
			
			boolean pst = db.getpst(bPressed);
			
			NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
			
			
			
			boolean present = false;	
			
			if((lp.table.getSelectedRow() == -1) && (lp.Guest == 1)) {
				for(int x = model.getRowCount();x >= 1 ; --x) {
					
					if(model.getColumnCount() != 0) {
						if(model.getValueAt(x - 1,0).equals(bPressed)) {					
							int qty = (int) model.getValueAt(x - 1, 1) + 1;						
												
							model.setValueAt(qty, x - 1, 1);
							model.setValueAt(n.format(price * qty), x - 1, 2);
							present = true;
											
						}
					}
							
				}
				
				if(present == false) {
					model.addRow(new Object[] {
						bPressed,
						1,
						n.format(price)						
					});
				}
			}
			else if((lp.table.getSelectedRow() == -1) && (lp.Guest != 1)) {
				model.addRow(new Object[] {
						bPressed,
						1,
						n.format(price)						
					});
			}
			else if(lp.table.getSelectedRow() >= 0) {
				
				model.insertRow(lp.table.getSelectedRow() + 1,new Object[] {
						bPressed,
						1,
						n.format(price)
						
					});
							
				
			}
				if(plt) {
					lp.PLT = lp.PLT + (price/10);					
				}
				
				if(pst) {
					
					lp.PST = (float) (lp.PST + (price*(0.07)));
				}
			
							
				lp.total = lp.total + price;			
				
				lp.DisplayTotal();
				
			
			
			
			
			
			
		}	
		
		
	}
	
	public void layMenuPanel(String Menu) {
		
		MenuItems = db.getMenuItems(Menu);			
		
		MenuPanel.removeAll();
		
		MenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
				
		
		for (int i = 0; i < MenuItems.size(); i++)
		{			
			Vector<String> v = (Vector)MenuItems.elementAt(i);
			item = new JButton(v.elementAt(1));
			item.addActionListener(this);
			item.setPreferredSize(new Dimension(140,60));
			item.setBackground(new Color(135,206,250));
            item.setOpaque(true);				
			MenuPanel.add(item);
				    
		}
		
		
		
		MenuPanel.revalidate();
		MenuPanel.repaint();
		
		
		
	}
	}
