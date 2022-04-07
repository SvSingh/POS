package Customer;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.Database;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerReport extends JPanel {
	private JTable table;

	private int id;
	
	Database db;
	
	CustomerReportListener CRL;

	private DefaultTableModel model;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		
		Vector<Vector> orders =	db.getCustomerOrder(id);
		if(model.getRowCount() != 0) {
			model.setRowCount(0);
		}
		
		
		for(int x = 0;x < orders.size();x++) {
			model.addRow(new Object[] {
				orders.elementAt(x).elementAt(0),
				orders.elementAt(x).elementAt(1),
				orders.elementAt(x).elementAt(2),
			});
		}
	}
	
	public void setListener(CustomerReportListener CRL) {
		this.CRL = CRL;
	}

	public CustomerReport(Database db) {
		
		this.db = db;
		setPreferredSize(new Dimension(450, 749));
		setLayout(new BorderLayout(0, 0));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(CRL != null) {
					CustomerReportEvent CRE = new CustomerReportEvent(this,(int) model.getValueAt(table.getSelectedRow(), 0));
					CRL.customerReportEventOccured(CRE);
				}
				
				
			}
		});
		table.setPreferredSize(new Dimension(500, 800));
		
		model = new DefaultTableModel(new Object[][] {}, new String[] { "Order No", "Date", "Total $" });

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

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 800));
		add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		add(panel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 50));
		add(panel_1, BorderLayout.SOUTH);

	}
}
