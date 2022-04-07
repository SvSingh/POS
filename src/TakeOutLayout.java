import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import Database.Database;

public class TakeOutLayout extends JPanel implements ActionListener {
	
	
	SILListener sil;
	Database db;
	JButton btn ;
	public TakeOutLayout(Database db) {
		
		this.db =db;
		setLayout(new GridLayout(5, 10, 0, 0));
		
		for(int x = 101;x <=150;x++) {
			btn = new JButton(String.valueOf(x));
			add(btn);
			btn.addActionListener(this);
			//btn.setBackground(Color.blue);
		}
		
	}
	
	public void setListener(SILListener sil){
		this.sil = sil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String TakeoutNumber =( (AbstractButton)e.getSource()).getText();
		
		
		TableEvent te = new TableEvent(this,TakeoutNumber);
		if(sil != null) {
			sil.SILEventOccured(te);
		}
		
	}
	
	

}
