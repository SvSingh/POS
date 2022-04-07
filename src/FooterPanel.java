import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import orderPrinting.Page;
import orderPrinting.orderPrint;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;

public class FooterPanel extends JPanel {
	
	JButton btnNewButton,printButton;
	JLabel lbl1;
	
	
	
	FooterPanel(){
		setPreferredSize(new Dimension(1000, 60));
		
		setBackground(Color.GRAY);
		setLayout(new GridLayout(0,7 , 0, 0));
		
		
		btnNewButton = new JButton("Exit");
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(btnNewButton);
		printButton = new JButton("Open Draw/No Sale");
		printButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		printButton.setHorizontalAlignment(SwingConstants.LEFT);
		printButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				String printerNameDesired = "Restaurant";
				//27,112,48,55,121
				byte[] open = {27,112,48,55,121};
//		      byte[] cutter = {29, 86,49};
		        PrintService pservice = 
		        PrintServiceLookup.lookupDefaultPrintService(); 
		        DocPrintJob job = pservice.createPrintJob();
		        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		        Doc doc = new SimpleDoc(open,flavor,null);
		        PrintRequestAttributeSet aset = new 
		        HashPrintRequestAttributeSet();
		        try {
		            job.print(doc, aset);
		        } catch (PrintException ex) {
		            System.out.println(ex.getMessage());
		        }
				
				
			}
			
		});
		
		add(printButton);
		
		  
		  
		 lbl1 = new JLabel();
		// lbl1.preferredSize();
		 lbl1.setFont(new Font("Serif", Font.PLAIN, 36));
		// lbl1.setFont(new Font("Serif", Font.PLAIN, 14));
		 
		 lbl1.setPreferredSize(new Dimension(250,60));
		 lbl1.setSize(new Dimension(250,60));
		 lbl1.setForeground(Color.WHITE);
		 
		 Timer t = new Timer();
		 t.schedule(new TimerTask() {
		     @Override
		     public void run() {
		    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");  
				  String now = String.valueOf(dtf.format(LocalDateTime.now()));			 
				  
				  lbl1.setText(now);
		     }
		 }, 0, 1000);
		 
		 add(lbl1);
		
	}
	
	
}
