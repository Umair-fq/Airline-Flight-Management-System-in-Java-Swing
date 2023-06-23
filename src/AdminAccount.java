import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminAccount extends JFrame {

	private JPanel panel,panel2;
	private User obj;
	private JLabel lblMariFlightManagement,label2;
	private JButton btnSchedule;
	private JButton btnUpdate;
	private JButton btnSettings;
	private JButton btnLogout;
	private JLabel lblimage;
	
	public AdminAccount(User obj)
	{
		this.obj=obj;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 937, 652);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(54, 11, 800, 78);
		panel.add(panel2);
		
		lblMariFlightManagement = new JLabel("Mari Flight Management System");
		panel2.add(lblMariFlightManagement);
		lblMariFlightManagement.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		label2 = new JLabel("Admin:  (<dynamic>)");
		panel2.add(label2);
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnSchedule = new JButton("Flight Schedule");
		btnSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DisplaySchedule();
			}
		});
		btnSchedule.setForeground(Color.BLUE);
		btnSchedule.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSchedule.setBounds(316, 140, 132, 40);
		panel.add(btnSchedule);
		
		btnUpdate = new JButton("Update Schedule");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				new UpdateFlightSchedule();
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(316, 198, 132, 40);
		panel.add(btnUpdate);
		
		btnSettings = new JButton("Account Settings");
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Settings(obj);
			}
		});
		btnSettings.setForeground(Color.BLUE);
		btnSettings.setBounds(313, 407, 135, 40);
		panel.add(btnSettings);
		
		btnLogout = new JButton("Log OUT");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setForeground(Color.RED);
		btnLogout.setBounds(778, 558, 135, 30);
		panel.add(btnLogout);
		
//		lblimage = new JLabel("");
//		lblimage.setBounds(10, 100, 255, 402);
//		ImageIcon img = new ImageIcon(this.getClass().getResource("/pic.jpg"));
//		lblimage.setIcon(img);
//		panel.add(lblimage);
		
		JButton btnAccounts = new JButton("Registered Accounts");
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAccounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Display();
			}
		});
		btnAccounts.setForeground(Color.BLUE);
		btnAccounts.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAccounts.setBounds(316, 341, 132, 40);
		panel.add(btnAccounts);
		
		JButton btnUpdatebook = new JButton("Update Bookings");
		btnUpdatebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				new AdminBookingChange();
			}
		});
		btnUpdatebook.setForeground(Color.BLUE);
		btnUpdatebook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdatebook.setBounds(316, 260, 132, 52);
		panel.add(btnUpdatebook);
		
		setTitle("Welcome Admin");
		setVisible(true);
	}
}
