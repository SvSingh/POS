import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class Comment extends JFrame implements ActionListener {
	
	
	private JTextArea textArea;
	private JButton Reg,Mild,Med,Hot,Ok,Cancel;
	
	private CommentListener CL;
	public Comment() {
		setUndecorated(true);
		setMinimumSize(new Dimension(550, 350));
		setPreferredSize(new Dimension(550, 350));
		getContentPane().setPreferredSize(new Dimension(600, 450));
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Comments Below:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(30, 31, 494, 22);
		panel_1.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 25));
		textArea.setTabSize(14);
		textArea.setBounds(10, 102, 514, 42);
		panel_1.add(textArea);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Reg = new JButton("Reg");
		Reg.setFont(new Font("Tahoma", Font.BOLD, 24));
		Reg.setBackground(Color.WHITE);
		Reg.setBounds(23, 40, 115, 48);
		panel.add(Reg);
		Reg.addActionListener(this);
		
		Mild = new JButton("Mild");
		Mild.setFont(new Font("Tahoma", Font.BOLD, 24));
		Mild.setBackground(Color.GREEN);
		Mild.setBounds(148, 40, 116, 48);
		panel.add(Mild);
		Mild.addActionListener(this);
		
		Med = new JButton("Med");
		Med.setFont(new Font("Tahoma", Font.BOLD, 24));
		Med.setBackground(Color.YELLOW);
		Med.setBounds(274, 40, 115, 48);
		panel.add(Med);
		Med.addActionListener(this);
		
		Hot = new JButton("Hot");
		Hot.setFont(new Font("Tahoma", Font.BOLD, 24));
		Hot.setBackground(Color.RED);
		Hot.setBounds(399, 40, 115, 48);
		panel.add(Hot);
	    Hot.addActionListener(this);
		
		Ok = new JButton("OK");
		Ok.setFont(new Font("Tahoma", Font.BOLD, 24));
		Ok.setBounds(148, 106, 116, 38);
		panel.add(Ok);
		Ok.addActionListener(this);
		
		Cancel = new JButton("Cancel");
		Cancel.setFont(new Font("Tahoma", Font.BOLD, 24));
		Cancel.setBounds(274, 106, 115, 38);
		panel.add(Cancel);
		Cancel.addActionListener(this);
	}
	
	public void setListener( CommentListener CL) {
		this.CL = CL;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton) {
			if(e.getSource() == Cancel) {
				this.dispose();
			}
			else if (e.getSource() == Ok) {
				
				CommentEvent CE = new CommentEvent(this,textArea.getText());
				if(CL != null) {
					CL.CommentOccured(CE);
				}
				
				this.dispose();
				
			}
			else {
				JButton pressed = (JButton) e.getSource();
				textArea.setText(textArea.getText() + " ( " + pressed.getText() + " )");
			}
		}
		
	}
}
