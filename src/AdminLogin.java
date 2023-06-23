import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class AdminLogin extends JFrame
{
	private JPanel panel,panel2;
	private JLabel label,label2,label3,labeltag;
	private JTextField field1;
	private JPasswordField field2;
	private JButton button,btnMainMenu;
	private JOptionPane o;
	private ArrayList<Admin> list;

	
	public AdminLogin(ArrayList<Admin> list)
	{
		this.list=list;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		panel.setLayout(null);
		setTitle("Log IN");
		getContentPane().add(panel);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(132, 11, 181, 40);
		panel.add(panel2);
		
		label = new JLabel("Log IN ");
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel2.add(label);
		
		label2 = new JLabel("Username :");
		label2.setFont(new Font("Serif", Font.PLAIN, 17));
		label2.setBounds(30, 90, 136, 53);
		panel.add(label2);
		
		label3 = new JLabel("Password : ");
		label3.setFont(new Font("Serif", Font.PLAIN, 17));
		label3.setBounds(30, 149, 118, 45);
		panel.add(label3);
		
		field1 = new JTextField();
		field1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field1.setBounds(132, 103, 141, 30);
		panel.add(field1);
		field1.setColumns(10);
		
		field2 = new JPasswordField();
		field2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field2.setBounds(132, 158, 141, 30);
		panel.add(field2);
		
		labeltag = new JLabel("");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labeltag.setBounds(100, 72, 213, 20);
		panel.add(labeltag);
		
		button = new JButton("Continue");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (field1.getText().equals("") || field2.getText().equals(""))
				{
					labeltag.setText("*Enter all fields");
				}
				else
				{
					boolean check = false;
					int counter=0;
					int index=-1;
					
					for (Admin obj : list)
					{
						if (field1.getText().equals(obj.getUsername())&& field2.getText().equals(obj.getPassword()))
						{
							check = true;
							index=counter;
							break;	
						}
						counter++;
					}
					if (check==true)
					{
						dispose();
						new AdminAccount(list.get(index));
					}
					else
					{
						labeltag.setText("Invalid Username or Password");
						field1.setText(null);
						field2.setText(null);
					}
				}
				
				
			}
		});
	    button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setForeground(Color.RED);
		button.setBounds(100, 238, 109, 30);
		panel.add(button);
		
		btnMainMenu = new JButton("MainMenu");
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnMainMenu.setForeground(Color.RED);
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMainMenu.setBounds(225, 238, 109, 30);
		panel.add(btnMainMenu);
		
		setVisible(true);
	}
}