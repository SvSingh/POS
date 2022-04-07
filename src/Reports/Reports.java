package Reports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.Vector;

import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Customer.CustomerReportEvent;
import Customer.CustomerReportListener;
import Database.Database;



public class Reports extends JPanel implements ActionListener {
	
	Database db;
	
	private JTable table;
	private DefaultTableModel model;
	public ReportCanvas textField;
	private JScrollPane scrollPane ;
	
	private JButton PrintButton;
	
	private String type = "";
	
	private CustomerReportListener CRL;
	
	public JTextPane text;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String makeEqualString(String first,String second) {
		String result = first;
		
		for(int x = 0; x <(50 - first.length() - second.length());x++){
			result = result + ".";
		}
		result = result + second;
		
		
		
		return result;
		
	}

	
	public void addSaleReportText() {
		
		if(table != null) {
			
			this.remove(table);
			this.remove(scrollPane);
			
		}
		else if(textField != null) {
			this.remove(textField);
			this.remove(PrintButton);
		}
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		add(panel, BorderLayout.NORTH);
		
		
		textField = new ReportCanvas();
		textField.setBackground(Color.WHITE);
		textField.setPreferredSize(new Dimension(500, 800));
		add(textField, BorderLayout.CENTER);
		//textField.setColumns(10);
		
		PrintButton = new JButton("Print");
		//PrintButton.setBounds(153, 277, 89, 23);
		PrintButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SalesReport sp = new SalesReport();

				sp.setTotal(textField.getTotal());
				sp.setGST(textField.getGST());
				sp.setDiscount(textField.getDiscount());
				sp.setPST(textField.getPST());
				sp.setCash(textField.getCash());
				sp.setAMEX(textField.getAMEX());
				sp.setMastercard(textField.getMastercard());
				sp.setOther(textField.getOther());
				sp.setVisa(textField.getVisa());
				sp.setGiftCard(textField.getGiftCard());
				sp.setDebit(textField.getDebit());
				sp.setDateEnd(textField.getDateEnd());
				sp.setDateStart(textField.getDateStart());
				
				String printerNameDesired = "Microsoft Print to PDF";

				PrintService[] service = PrinterJob.lookupPrintServices(); // list of printers
				DocPrintJob docPrintJob = null;

				int count = service.length;

				for (int i = 0; i < count; i++) {
					if (service[i].getName().equalsIgnoreCase(printerNameDesired)) {
						docPrintJob = service[i].createPrintJob();
						i = count;
					}
				}
				try {
					PrinterJob pjob = PrinterJob.getPrinterJob();
					Page page = new Page();
					pjob.setPrintService(docPrintJob.getPrintService());
					//pjob.setJobName("job");



					pjob.setPrintable(sp, page.getPageFormat(pjob));
					pjob.print();
				}catch (PrinterException ex) {
					ex.printStackTrace();
				}	
				
				
			}
			
			
			
			
		});
		add(PrintButton,BorderLayout.SOUTH);
		

		
		this.revalidate();
		this.repaint();
		
	}
	
	
	
	public void adddTable() {
		
		if(PrintButton != null) {
			this.remove(PrintButton);
			this.remove(textField);
			
		}
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 800));
		
		this.add(scrollPane, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
		
		Vector<Vector> orders =	db.getTodaysOrder();
		if(model.getRowCount() != 0) {
			model.setRowCount(0);
		}
		
		
		for(int x = 0;x < orders.size();x++) {
			if(orders.elementAt(x).elementAt(9) != null) {
				String table = (String) orders.elementAt(x).elementAt(9);
			}
			else {
				String table = (String) orders.elementAt(x).elementAt(10);
			}
			
			model.addRow(new Object[] {
				orders.elementAt(x).elementAt(0),
				orders.elementAt(x).elementAt(1),
				"$" + ((double)orders.elementAt(x).elementAt(6) + (double)orders.elementAt(x).elementAt(7) +(double)orders.elementAt(x).elementAt(8)),
			});
		}
		
		
	
	}
	
	public void setListener(CustomerReportListener CRL) {
		this.CRL = CRL;
	}
	public Reports(Database db) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		this.db = db;
		setPreferredSize(new Dimension(450, 749));
		setLayout(new BorderLayout(0, 0));
		
		text = new JTextPane();
		
		text.setPreferredSize(new Dimension(500, 800));
		text.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		text.setForeground(Color.BLACK);
		
		StyledDocument doc = text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		
		table = new JTable();
		table.setPreferredSize(new Dimension(500, 800));
		
		model = new DefaultTableModel(new Object[][] {}, new String[] { "Order No", "Table or Take out no.", "Total $" });

		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(81);
		
		table.setRowHeight(25);
		table.setPreferredScrollableViewportSize(new Dimension(450, 390));
		table.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.YELLOW);
		table.setSelectionForeground(Color.BLACK);
		table.setGridColor(Color.WHITE);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(CRL != null) {
					CustomerReportEvent CRE = new CustomerReportEvent(this,(int) model.getValueAt(table.getSelectedRow(), 0));
					CRL.customerReportEventOccured(CRE);
				}
				
				
			}
		});

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(500, 800));
		

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		add(panel, BorderLayout.NORTH);

	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
