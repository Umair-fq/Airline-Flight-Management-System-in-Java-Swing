import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogInScreen extends JFrame {

	private JPanel panel,panel2;
	private JLabel label,label2,label3,labeltag;
	private JTextField field1;
	private JPasswordField field2;
	private JButton button;
	private JLabel labeltag2;
	private JButton btnsignup;
	private JPanel panel3;
	private JOptionPane o;
	private JButton btnMainmenu;
	
	public LogInScreen()
	{
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
		field1.setBounds(142, 103, 171, 30);
		panel.add(field1);
		field1.setColumns(10);
		
		field2 = new JPasswordField();
		field2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		field2.setBounds(142, 154, 171, 30);
		panel.add(field2);
		
		labeltag = new JLabel("");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labeltag.setBounds(119, 72, 194, 20);
		panel.add(labeltag);
		
		button = new JButton("Continue");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (field1.getText().equals("") || field2.getText().equals(""))
				{
					labeltag.setText("*Fill all fields");
				}
				else
				{
					boolean check = false;
					int counter=0;
					int index=-1;
					
					for (Passenger obj : MainMenu.listPassenger)
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
			 		    new PassengerAccount(MainMenu.listPassenger.get(index));
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
		button.setBounds(119, 224, 109, 30);
		panel.add(button);
		
		panel3 = new JPanel();
		panel3.setBounds(96, 278, 276, 40);
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setBackground(new Color(216,196,216));
		panel.add(panel3);
		
		labeltag2 = new JLabel("If you are a new User -->");
		panel3.add(labeltag2);
		labeltag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnsignup = new JButton("Sign UP");
		btnsignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SignUpScreen object = new SignUpScreen();
			}
		});
		panel3.add(btnsignup);
		btnsignup.setForeground(Color.RED);
		btnsignup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnsignup.setBorder(BorderFactory.createEmptyBorder());
		btnsignup.setBackground(new Color(216,196,216));
		
		btnMainmenu = new JButton("MainMenu");
		btnMainmenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		btnMainmenu.setForeground(Color.RED);
		btnMainmenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMainmenu.setBounds(238, 224, 109, 30);
		panel.add(btnMainmenu);
		
		setVisible(true);
	}
}
