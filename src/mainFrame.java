import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Customer.Customer;
import Customer.CustomerPanelEvent;
import Customer.CustomerPanelListener;
import Customer.CustomerReport;
import Customer.CustomerReportEvent;
import Customer.CustomerReportListener;
import Database.Database;
import Reports.Reports;
import Reports.reportPanel;

public class mainFrame extends JFrame {
	
	private mainButtons mainbutton;
	private header HeaderPanel;
	private FooterPanel footerpanel;
	private listPanel listpanel;
	private DisplayPanel displayPanel;
	private StayInLayout SIL;
	private String tableSelected;
	private PaymentPanel payment;
	private Database db;
	private TakeOutLayout TOL;
	private Discount discount;
	private Customer customer;
	private CustomerReport CR;
	private reportPanel RP;
	private Reports report;
	
	mainFrame main = this;
	
	
	
	
	public void setLayout() {	
		
		
		
		removePanels();
				
		getContentPane().add(SIL,BorderLayout.CENTER);
		
		
		
		
		
		getContentPane().revalidate();
		getContentPane().repaint();
		
		
	}
	
	private void removePanels() {
		
		if(listpanel != null) {
			getContentPane().remove(listpanel);
		}
		if(displayPanel !=null) {
			getContentPane().remove(displayPanel);
		}
		if(payment != null) {
			getContentPane().remove(payment);
		}
		if(discount != null) {
			getContentPane().remove(discount);
		}
		if(TOL != null) {
			getContentPane().remove(TOL);
		}
		if(SIL != null) {
			getContentPane().remove(SIL);
		}
		if(customer != null) {
			getContentPane().remove(customer);
		}
		if(CR != null) {
			getContentPane().remove(CR);
		}
		if(RP != null) {
			getContentPane().remove(RP);
		}
		if(report != null) {
			getContentPane().remove(report);
		}
		
		
	}
	
	

	mainFrame() {
		
		db = new Database();
		
		//System.out.println(Categories);
		
		mainbutton = new mainButtons();
		
		HeaderPanel = new header();
		
		footerpanel = new FooterPanel();	
		
		RP = new reportPanel();
		
		
		
		
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1200,800));
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(mainbutton, BorderLayout.WEST);
		
		getContentPane().add(HeaderPanel,BorderLayout.NORTH);
		
		getContentPane().add(footerpanel,BorderLayout.SOUTH);
		
			
		SIL = new StayInLayout(db);	
		TOL = new TakeOutLayout(db);
		
		
		//getContentPane().add(SIL,BorderLayout.CENTER);
			
		getContentPane().add(SIL,BorderLayout.CENTER);
		
		
		
		mainbutton.setListener(new MainButtonListener() {

			
			public void mainButtonEventOccured(MainButtonEvent MBE) {
				if(MBE.getBtnPressed().equals("reports")) {
					
					removePanels();
					
					report = new Reports(db);
					
					getContentPane().add(RP,BorderLayout.CENTER);
					getContentPane().add(report,BorderLayout.EAST);
					RP.setReports(report);
					
					report.setListener(new CustomerReportListener() {

						@Override
						public void customerReportEventOccured(CustomerReportEvent CRE) {
							getContentPane().remove(report);					
							
							
							Order order = new Order();
							
							order.setOrderID(CRE.getOrderId());
							
							listpanel = new listPanel(db,"0",order);
							listpanel.setmainFrame(main);
							
							getContentPane().add(listpanel,BorderLayout.EAST);
							
							getContentPane().revalidate();
							getContentPane().repaint();
							
						}
						
					});
					
					getContentPane().revalidate();
					getContentPane().repaint();
					
					
				}
				if(MBE.getBtnPressed().equals("Customer")) {
					
					customer = new Customer(db);
					CR = new CustomerReport(db);
					
					CR.setListener(new CustomerReportListener() {

						@Override
						public void customerReportEventOccured(CustomerReportEvent CRE) {
							getContentPane().remove(CR);
							
							
							
							Order order = new Order();
							
							order.setOrderID(CRE.getOrderId());
							
							listpanel = new listPanel(db,"0",order);
							listpanel.setmainFrame(main);
							
							getContentPane().add(listpanel,BorderLayout.EAST);
							
							getContentPane().revalidate();
							getContentPane().repaint();
							
						}
						
					});
					removePanels();
					
					
					getContentPane().add(customer,BorderLayout.CENTER);
					getContentPane().add(CR,BorderLayout.EAST);
					
						
					customer.setListener(new CustomerPanelListener() {
						@Override
						public void CustomerEventOccured(CustomerPanelEvent CPE) {
							if(listpanel != null) {
								getContentPane().remove(listpanel);
							}
							CR.setId(CPE.getId());
							
							getContentPane().add(CR,BorderLayout.EAST);
							getContentPane().revalidate();
							getContentPane().repaint();
						}
						
					});
					
					getContentPane().revalidate();
					getContentPane().repaint();
					
				}
				if(MBE.getBtnPressed().equals("TakeOut")) {
					removePanels();
					getContentPane().remove(SIL);
					getContentPane().add(TOL,BorderLayout.CENTER);
						
					
					getContentPane().revalidate();
					getContentPane().repaint();
					
				}
				else if(MBE.getBtnPressed().equals("StayIN")) {
					
					removePanels();
					
					getContentPane().remove(TOL);
					getContentPane().add(SIL,BorderLayout.CENTER);
					
					
					getContentPane().revalidate();
					getContentPane().repaint();
				}
				
				else if (MBE.getBtnPressed().equals("Payment")) {
					if(listpanel != null && listpanel.isDisplayable()) {
						
						payment = new PaymentPanel(listpanel);
						removePanels();
						getContentPane().add(listpanel,BorderLayout.EAST);
						getContentPane().add(payment,BorderLayout.CENTER);
						
						getContentPane().revalidate();
						getContentPane().repaint();
					}
					
				}
				
				else if (MBE.getBtnPressed().equals("Discount")) {
					if(listpanel != null && listpanel.isDisplayable()) {
						
						discount = new Discount(listpanel);
						removePanels();
						getContentPane().add(listpanel,BorderLayout.EAST);
						getContentPane().add(discount,BorderLayout.CENTER);
						
						getContentPane().revalidate();
						getContentPane().repaint();
					}
					
				}
				
			}
			
		});
		
			
		TOL.setListener(new SILListener() {

			@Override
			public void SILEventOccured(TableEvent te) {
				tableSelected = te.getTableSelected();	
				
				Order order = new Order();
				
				listpanel = new listPanel(db,tableSelected,order);
				
				listpanel.setmainFrame(main);
				
				displayPanel = new DisplayPanel(listpanel,db,order);			
				
				getContentPane().add(listpanel,BorderLayout.EAST);
				getContentPane().remove(TOL);
				getContentPane().add(displayPanel,BorderLayout.CENTER);	
				
				getContentPane().revalidate();
				getContentPane().repaint();
				
			}
			
			
		});

		SIL.setListener(new SILListener() {
			
			public void SILEventOccured(TableEvent te) {
				
				tableSelected = te.getTableSelected();	
				
				Order order = new Order();
				
				listpanel = new listPanel(db,tableSelected,order);
				
				listpanel.setmainFrame(main);
				
				displayPanel = new DisplayPanel(listpanel,db,order);			
				
				getContentPane().add(listpanel,BorderLayout.EAST);
				getContentPane().remove(SIL);
				getContentPane().add(displayPanel,BorderLayout.CENTER);	
				
				getContentPane().revalidate();
				getContentPane().repaint();
				
				
			}
			
			
		});
		
		
		//pack();
	}
}
