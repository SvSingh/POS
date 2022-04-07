import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Database.Database;
public class listPanel extends JPanel implements ActionListener  {
	
	private JButton btnNewButton,btnQty,btnComment,btnSeperator,btnPrint;
	public JTextArea textArea;
	public JScrollPane listScroller; 
	private JPanel BottomPanel,topPanel;
	public JTable table;
	private DefaultTableModel model;
	public int Guest;
	private JButton btnSend;
	public JTextArea txtrGst;
	public JTextArea txtrTotal;
	public Database db;
	private JLabel CustomerName,CustomerPhoneNo;
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	
	public Order getOrder() {
		return order;
	}
	public float discount;
	public float total;
	public float PST;
	public float PLT;
	public float GST;
	public String TableSelected;
	private Order order;	
	public mainFrame main;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	public void setmainFrame(mainFrame main) {
		
		this.main =  main;
	}	
	
	listPanel(Database db, String Tableselected,Order order ){
		setBackground(Color.WHITE);	
		
		this.db = db;
		
		this.TableSelected = Tableselected;
		
		total = 0;
		GST = 0;
		PLT = 0;	
		PST = 0;
		this.order = order;
		
		
		
		setLayout(new BorderLayout());
		
		
		Guest = 1;
		
		
		topPanel = new JPanel();
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				getCustomerDetail GCD = new getCustomerDetail(CustomerName.getText().replace("Customer Name: ", ""), CustomerPhoneNo.getText().replace("Customer Phone No: ", "")); 
				GCD.setVisible(true);
				GCD.setLocationRelativeTo(null);
				GCD.setSize(600, 350);
				GCD.setListener(new CustomerListener() {

					@Override
					public void customerEventOccured(CustomerEvent CE) {
						
						CustomerName.setText("Customer Name: " + CE.getCustomerName());
						CustomerPhoneNo.setText("Customer Phone No: " + CE.getCustomerNumber());
						
						
					}
					
				});
				
			}
		});
		topPanel.setBackground(SystemColor.controlHighlight);
		topPanel.setPreferredSize(new Dimension(10, 100));
		
		add(topPanel,BorderLayout.NORTH);
		topPanel.setLayout(null);
		
		JLabel TableNo = new JLabel("Table No:");
		TableNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		TableNo.setBounds(22, 11, 159, 14);
		topPanel.add(TableNo);
		
		JLabel TakeOutNo = new JLabel("Take Out No:");
		TakeOutNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		TakeOutNo.setBounds(22, 46, 159, 14);
		topPanel.add(TakeOutNo);
		
		CustomerName = new JLabel("Customer Name: ");
		CustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		CustomerName.setBounds(191, 6, 249, 24);
		topPanel.add(CustomerName);
		
		CustomerPhoneNo = new JLabel("Customer Phone No: ");
		CustomerPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		CustomerPhoneNo.setBounds(191, 41, 249, 24);
		topPanel.add(CustomerPhoneNo);
		
		BottomPanel = new JPanel();
		BottomPanel.setSize(new Dimension(70, 20));
		BottomPanel.setMinimumSize(new Dimension(20, 70));
		BottomPanel.setPreferredSize(new Dimension(20, 120));
		BottomPanel.setForeground(Color.DARK_GRAY);
		
		
		btnSeperator = new JButton("Seperator");		
		btnSeperator.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSeperator.addActionListener(this);	
	
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(this);
		BottomPanel.setLayout(new GridLayout(2, 4, 0, 0));
		
		txtrGst = new JTextArea();
		txtrGst.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		txtrGst.setText("GST:\r\nPLT:\r\nPST:");
		txtrGst.setBorder(new LineBorder(new Color(0, 0, 0)));
		BottomPanel.add(txtrGst);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		btnNewButton.setSize(40, 40);
		BottomPanel.add(btnNewButton);
		BottomPanel.add(btnSeperator);
		
		add(BottomPanel, BorderLayout.SOUTH);
		
		btnSend = new JButton("Send");
		BottomPanel.add(btnSend);
		btnSend.addActionListener(this);
		
		txtrTotal = new JTextArea();
		txtrTotal.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		txtrTotal.setText(" Total:$" + total);
		txtrTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		BottomPanel.add(txtrTotal);
		
		btnComment = new JButton("Comment");		
		btnComment.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComment.addActionListener(this);
		BottomPanel.add(btnComment);
		
		
		btnQty = new JButton("Qty");
		btnQty.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnQty.addActionListener(this);
		BottomPanel.add(btnQty);
		
		btnPrint = new JButton("Print Reciept");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.addActionListener(this);
		BottomPanel.add(btnPrint);
		
		
		table = new JTable();
		table.setRowHeight(25);
		table.setPreferredScrollableViewportSize(new Dimension(450, 390));
		table.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.YELLOW);
		table.setSelectionForeground(Color.BLACK);
		table.setGridColor(Color.WHITE);
		
		model = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Item", "Qty", "Total $"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Integer.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(163);
		
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setBackground(Color.WHITE);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(452, 390));
		scrollPane.setBackground(Color.WHITE);
		add(scrollPane, BorderLayout.CENTER);
		
		Vector<Object> TableInfo;
		
		String type = "";
		
		if(TableSelected.contains("A") || TableSelected.contains("B") || TableSelected.contains("C") ) {
			
			TableNo.setText(TableNo.getText() + " " + TableSelected);
			TableInfo = db.getStayTableInfo(TableSelected);
			type = "StayIn";
			
		}
		
		else if(!TableSelected.equals("0")) {
			
			TakeOutNo.setText(TakeOutNo.getText() + " " + TableSelected);
			TableInfo = db.getTakeOutTableInfo(Integer.parseInt(TableSelected));
			type = "Takeout";
		}
		else {
			TableInfo = db.getTableInfo(order.getOrderID());		
			
		}
	
		
		
		
		
		order.setListPanel(this);
		
		if(TableInfo.isEmpty() != true) {		
					
			
			order.setOrder(TableInfo);
			
			Vector<Vector> items = order.getItems();
			
			
			total = order.getSubtotal().floatValue();
			
			GST = (float) order.getGST().floatValue();
			
			PLT = order.getPLT().floatValue();
			
			PST = order.getPST().floatValue();
			
			if(order.getTakeOutNumber() != 0 && TableSelected.equals("0")) {
				TakeOutNo.setText(TakeOutNo.getText() + " " + order.getTakeOutNumber());
			}
			
			else if(order.getTable() != null && TableSelected.equals("0")) {
				
				TableNo.setText(TableNo.getText() + " " + order.getTable());
			}
			
			
			
			if(order.getCustomerId() != 0 ) {
				
				Vector<Object> CustInfo = db.getCustomerInfo(order.getCustomerId());
					/*
				CustomerName.setText("Customer Name: " + CustInfo.elementAt(0));
				CustomerPhoneNo.setText("Customer Phone No: " + CustInfo.elementAt(1));
				*/
				
				
			}
			
			
			
			
			for(int y = 0;y < items.size();y++) {
				
				for(int x = 0;x < items.elementAt(y).size();x++) {
					
								
					Vector<Object> out = (Vector<Object>) items.elementAt(y).elementAt(x);
					String three;
					if((Float) out.elementAt(2) < 0) {
						three = '$' + String.valueOf((int) out.elementAt(1) * -(Float) out.elementAt(2));
					}
					else {
						three = '$' + String.valueOf((int) out.elementAt(1) * (Float) out.elementAt(2));
					}
					model.addRow(new Object[] {
							(String) out.elementAt(0),
							(int) out.elementAt(1),
							three
							
						});
					if((Float) out.elementAt(2) < 0) {
						model.addRow(new Object[] {
								"<html><font color=red>" + (String) out.elementAt(0) + "</font></html>",
								"<html><font color=red>" + (int) out.elementAt(1) + "</font></html>",
								"<html><font color=red>" + ("-") + three + "</font></html>"
								
							});
					}
					if(out.size() == 4) {
						model.addRow(new Object[] {
								 (String) out.elementAt(3) 
						});
					}
					
				}						
				if((y + 1) < items.size()) {
					AddSeperator();
				}
			}
			
			if(order.getDiscountRate() != 0) {
				discount = order.getDiscountRate();
				model.addRow(new Object[] {
						"<html><font color=red>" + order.getDiscount() + "</font></html>",
						"<html><font color=red>" +"" + "</font></html>",
						"<html><font color=red>" +"-"+n.format(discount) + "</font></html>"					
				});
			}
			DisplayTotal();
		}
		
		else if(TableInfo.isEmpty() && type.equals("StayIn")) {
			
				order.setTable(Tableselected);
			
		}
		
		else if( TableInfo.isEmpty() && type.equals("Takeout") ) {
			order.setTakeOutNumber(Integer.parseInt(Tableselected));
		}
		
		
		
	}
	
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNewButton && order.getActive()) {
			
			
			if(table.getSelectedRow() != -1) {
				
				if((boolean)model.getValueAt(table.getSelectedRow(), 0).equals(">>>>>>>> " + String.valueOf(Guest-1) + " >>>>>>>>")) {
					Guest--;
					model.removeRow(table.getSelectedRow());
				}
				
				else if ((boolean)model.getValueAt(table.getSelectedRow(), 0).equals(">>>>>>>> " + "1" + " >>>>>>>>")) {
					
					
					
					for(int x = model.getRowCount();x >= 2 ; --x) {
						
						if(model.getColumnCount() != 0) {
							if(model.getValueAt(x - 1,0).equals(">>>>>>>> " + String.valueOf(Guest-1) + " >>>>>>>>")) {
								
								model.removeRow(x - 1);
								Guest--;
							}
						}		
					
				}
					model.removeRow(table.getSelectedRow());
				  
			}
				
			if(model.getValueAt(table.getSelectedRow(), 2) != null) {				
				//System.out.println(model.getValueAt(table.getSelectedRow(), 0));
				
				//total = total -	Float.parseFloat(model.getValueAt(table.getSelectedRow(), 2).toString().replace("$", ""));
				
				total = total -	Float.parseFloat(model.getValueAt(table.getSelectedRow(), 2).toString().replace("$", "").replace("<html><font color=red>","").replace("</font></html>", ""));
				if(db.getpst((String) model.getValueAt(table.getSelectedRow(),0))){
					 PST = (float) (PST - (Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", "")))*0.07);
					 						  
				 }	
				
				if(db.getplt((String) model.getValueAt(table.getSelectedRow(),0))){
					 PLT = (float) (PLT - (Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", "")))/10);
					 						  
				 }
				if(order.checkItem((String)model.getValueAt(table.getSelectedRow(), 0))) {
						
						
						model.insertRow(table.getSelectedRow() + 1, new Object[] {
								"<html><font color=red>" + model.getValueAt(table.getSelectedRow(), 0) + "</font></html>",
								"<html><font color=red>" +model.getValueAt(table.getSelectedRow(), 1) + "</font></html>",
								"<html><font color=red>" +"-" + (String)(model.getValueAt(table.getSelectedRow(), 2)) + "</font></html>"								
							});
						
					
						
					}
					
					else if(model.getValueAt(table.getSelectedRow(), 0).toString().replace("$", "").replace("<html><font color=red>","").replace("</font></html>", "").contains("Discount")) {
						discount = 0;
						model.removeRow(table.getSelectedRow());
					}
					
					else {
						model.removeRow(table.getSelectedRow());
					}
					
					
				
				this.DisplayTotal();
			}
			
		}
			/*
			else if (model.getRowCount() != 0) {
				total = total -	Float.parseFloat(model.getValueAt(model.getRowCount() - 1, 2).toString().replace("$", "").replace("<html><font color=red>","").replace("</font></html>", ""));
				if(db.getpst((String) model.getValueAt(table.getSelectedRow(),0))){
					 PLT = (float) (PLT - (Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", "")))/10);
					 						  
				 }
				model.removeRow(model.getRowCount() - 1);
				this.DisplayTotal();
			}*/
			
			
		}
		
		else if(e.getSource() == btnQty && order.getActive() ) {
			
			
			if(table.getSelectedRow() != -1) {
				
				inputQty inQty = new inputQty((int)(model.getValueAt(table.getSelectedRow(), 1)));
				inQty.setVisible(true);
				
				inQty.setSize(500, 250);				
				
				inQty.setLocationRelativeTo(this.main);
				
				inQty.setQtylistener(new QtyEventListener() {
					
					public void qtyEventOccured(qtyEvent qE) {
						
					 int qty = qE.getQty();
					 
					 float price = Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", ""))/(int)model.getValueAt(table.getSelectedRow(), 1);
					 
					 total = total - Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", ""));
					 total = total + (price*qty);
					 if(db.getpst((String) model.getValueAt(table.getSelectedRow(),0))){
						 PST = (float) (PST - (Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", "")))*0.07);
						 PST = (float) (PST + ((price*qty)*0.07));
								  
					 }
					 
					 if(db.getplt((String) model.getValueAt(table.getSelectedRow(),0))){
						 PLT = (float) (PLT - (Float.parseFloat(model.getValueAt(table.getSelectedRow(),2).toString().replace("$", "")))/10);
						 PLT = PLT + (price*qty)/10;
								  
					 }
					 model.setValueAt(qty, table.getSelectedRow(), 1);	
					 model.setValueAt(price*qty, table.getSelectedRow(), 2);
					 DisplayTotal();
					 table.getSelectionModel().clearSelection();
					 
					 
					}
					
					
				});
				
				
			}
			
			
			
			
		}
		else if(e.getSource() == btnPrint) {
			
			order.setPrintItem(order.getListItems());
			order.recieptprint();
			
		}
		
		else if(e.getSource() == btnComment && order.getActive()) {
			
			
				
				Comment comment = new Comment();
				comment.setVisible(true);
				comment.setLocationRelativeTo(this.main);
				
				comment.setListener(new CommentListener() {		
					
					
					@Override
					public void CommentOccured(CommentEvent CE) {
						// TODO Auto-generated method stub
						
						String insert;
						if(CE.getComment().contains("(")) {
							insert = CE.getComment();
						}
						else {
							insert = "( " + CE.getComment() + " )";
						}
						
						if(table.getSelectedRow() != -1) {
						model.insertRow(table.getSelectedRow() + 1, new Object[] {
								insert
						});
						}
						else {
							model.insertRow(table.getRowCount() 
									, new Object[] {
									insert
							});
						}
						
					}
					
				});
				
			
			table.getSelectionModel().clearSelection();
			
		}
		
		else if(e.getSource() == btnSend) {		
			
			
			
			if( order.getActive()) {
				this.save();
				order.orderPrint();
			}
			
			
			main.setLayout();
			
			
			
		}
		
		else if(e.getSource() == btnSeperator && order.getActive()) {
			
			AddSeperator();
		}
		
		
		
	}
	
	public void save() {
		String name = CustomerName.getText().replace("Customer Name: ", "");
		String Phone = CustomerPhoneNo.getText().replace("Customer Phone No: ", "");
		
		name.trim();
		Phone.trim();
		
		int custID = db.PutCustomer(name,Phone);
		order.setCustomerId(custID);
			
		
		order.setSubtotal(Double.parseDouble(df.format( total)));
		
		order.setPLT(Double.parseDouble(df.format(PLT)));
		order.setGST(Double.parseDouble(df.format(GST)));
		order.setPST(Double.parseDouble(df.format(PST)));
		order.setDiscountRate(Float.parseFloat(df.format(discount)));
		
		order.save();
		
	}
	
	public void DisplayTotal() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
		
		GST = (Float) (total *5/100);
		
		
		txtrGst.setText("GST:" + n.format(GST) + "\r\nPLT: " + n.format(PLT)+ "\r\nPST: " + n.format(PST));
		
		txtrTotal.setText("  Total:" + n.format(total + GST + PLT + PST));
		table.getSelectionModel().clearSelection();
	}
	
	private void AddSeperator() {
		
		if(table.getSelectedRow() == -1 && table.getRowCount() !=0) {
			if(Guest == 1) {
			model.insertRow(0, new Object[] {
					">>>>>>>> " + Guest + " >>>>>>>>"
				});
			
			Guest++;
				
			}
			
			
			model.addRow(new Object[] {
					">>>>>>>> " + Guest + " >>>>>>>>"
				});
			
			Guest++;
			}
			
			
			
		
		else if(table.getSelectedRow() != -1) {
			
			if(Guest == 1) {
					model.insertRow(0, new Object[] {
					">>>>>>>> " + Guest + " >>>>>>>>"
					});
					Guest++;
			}	
			
			
			model.insertRow(table.getSelectedRow() + 1, new Object[] {
					">>>>>>>> " + Guest + " >>>>>>>>"
				});
			
			Guest++;
			
			
			table.getSelectionModel().clearSelection();
		}
		
		
		
		
	}
}
