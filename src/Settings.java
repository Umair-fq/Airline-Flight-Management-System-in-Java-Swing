import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class Settings extends JFrame {

	private JPanel panel,panel2;
	private JButton btnUpdate,btnBack;
	private User obj;
	private JRadioButton radioUsername,radioPassword;
	private JLabel labeltag,label;
	private JTextField fieldUsername;
	private JPasswordField fieldPass;

	public Settings(User obj)
	{
		this.obj=obj;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(54, 11, 325, 40);
		panel.add(panel2);
		
		label = new JLabel("Change Username or Password");
		panel2.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		labeltag = new JLabel("Select what you want to change!");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labeltag.setBounds(83, 62, 283, 15);
		panel.add(labeltag);
		
		fieldUsername = new JTextField();
		fieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldUsername.setBounds(150, 103, 119, 20);
		fieldUsername.setVisible(false);
		panel.add(fieldUsername);
		
		fieldPass = new JPasswordField();
		fieldPass.setBounds(150, 140, 119, 20);
		fieldPass.setVisible(false);
		panel.add(fieldPass);
		
		btnUpdate = new JButton("Update");
		
		btnBack = new JButton("Back");
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(213, 198, 109, 23);
		panel.add(btnBack);
		
		radioUsername = new JRadioButton("Username");
		radioUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (radioUsername.isSelected()==true)
				{
					fieldUsername.setVisible(true);
				}
				else
				{
					fieldUsername.setVisible(false);
				}
			}
		});
		radioUsername.setForeground(Color.BLUE);
		radioUsername.setBackground(new Color (216,191,216));
		radioUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioUsername.setBounds(36, 101, 102, 23);
		panel.add(radioUsername);
		
		radioPassword = new JRadioButton("Password");
		radioPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (radioPassword.isSelected()==true)
				{
					fieldPass.setVisible(true);
				}
				else
				{
					fieldPass.setVisible(false);
				}
			}
		});
		radioPassword.setForeground(Color.BLUE);
		radioPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioPassword.setBackground(new Color(216, 191, 216));
		radioPassword.setBounds(36, 137, 102, 23);
		panel.add(radioPassword);
		
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 	
				if (radioUsername.isSelected()==true && radioPassword.isSelected()==true)
				{
					if (!fieldUsername.getText().equals("") && !fieldPass.getText().equals(""))
					{
						if (fieldUsername.getText().length()>=6)
						{
							if (validPassword(fieldPass.getText())==true && fieldPass.getText().length()>=8)
							{
                                obj.setUsername(fieldUsername.getText());
                                obj.setPassword(fieldPass.getText());
                                JOptionPane msg = new JOptionPane();
                                msg.showMessageDialog(panel,"Settings Changed.Log out and Login In Again to refresh Screen","",JOptionPane.INFORMATION_MESSAGE);
                                dispose();
							}
							else
							{
								labeltag.setText("*Invalid Password Format!! Try Another");
							}
						}
						else
						{
							labeltag.setText("*Username must have atleast 6 characters!");
						}
						
					}
					else
					{
						labeltag.setText("*Please fill All Slots");
					}
				}
				else if (radioUsername.isSelected()==true)
				{
					if (!fieldUsername.getText().equals(""))
					{
						if (fieldUsername.getText().length()>=6)
						{
							obj.setUsername(fieldUsername.getText());
							JOptionPane msg = new JOptionPane();
							msg.showMessageDialog(panel,"Settings Changed.Log out and Log In again to refresh Screen","",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							labeltag.setText("*Username must have atleast 6 characters!");
						}
					}
					else
					{
						labeltag.setText("*Please fill the Slot");
					}
					
				}
				else if (radioPassword.isSelected()==true)
				{
					if (!fieldPass.getText().equals(""))
					{
						if (validPassword(fieldPass.getText())==true && fieldPass.getText().length()>=8)
						{
							obj.setPassword(fieldPass.getText());
							JOptionPane msg = new JOptionPane();
							msg.showMessageDialog(panel,"Settings Changed.Log Out and Log IN again to refresh frame","",JOptionPane.INFORMATION_MESSAGE);
							dispose();
		
						}
						else
						{
							labeltag.setText("Invalid Password Format!!Try Another");
						}
					}
					else
					{
						labeltag.setText("*Please Fill the Slot");
					}
				}
				else
				{
					labeltag.setText("*Please Select any Option");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setBounds(71, 198, 109, 23);
		panel.add(btnUpdate);
		
		setVisible(true);
	}
	
	public boolean validPassword(String str)
	{
		char [] array = str.toCharArray();
		boolean capital=false,small=false,digit=false,special=false;
		
		for (char character : array)
		{
			if (Character.isUpperCase(character)==true)
			{
				capital=true;
				break;
			}
		}
		for (char character : array)
		{
			if (Character.isLowerCase(character)==true)
			{
				small=true;
				break;
			}
		}
		for (char character : array)
		{
			if (Character.isDigit(character)==true)
			{
				digit=true;
				break;
			}
		}
		for (char character : array)
		{
			if (Character.isDigit(character)==false && Character.isLetter(character)==false
					&& Character.isWhitespace(character)==false)
			{
				special=true;
				break;
			}
		}
		
		if (capital==true && small==true && digit==true && special==true)
			return true;
		
		else
			return false;
	}
}
