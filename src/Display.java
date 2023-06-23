import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Display extends JFrame 
{
	private JPanel contentPane; 
	private JTable table;
	private JScrollPane sp;

	public Display() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Data of SignUps");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color (216,191,216));
		
		JLabel label = new JLabel("Accounts");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setForeground(Color.RED);
		label.setBounds(162, 11, 107, 33);
		contentPane.add(label);
		
		String [] heading = new String[] {"Names ","CNIC ","Emails "};
		DefaultTableModel dtm = new DefaultTableModel(heading,0);
		
	    for (int i=0; i<MainMenu.listPassenger.size();i++)
	    {
	    	Object [] o = {MainMenu.listPassenger.get(i).getUsername(),MainMenu.listPassenger.get(i).getCnic(),MainMenu.listPassenger.get(i).getEmail()};
	    	dtm.addRow(o);
	    }
	    
	    table = new JTable(dtm);
		sp = new JScrollPane(table);
		sp.setBounds(10, 55, 419, 158);
	    contentPane.add(sp);
	
		
		JButton btn = new JButton("Back");
		btn.setForeground(Color.RED);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn.setBounds(162, 224, 89, 23);
		contentPane.add(btn);
		getContentPane().add(contentPane);

		setVisible(true);
		
		
	}
}

	