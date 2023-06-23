import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.image.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import jdk.incubator.vector.VectorOperators.Test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel panel,panel2;
	private JLabel label1,label2;
	private JButton btn1,btn2,btn3;
	private Admin obj1,obj2,obj3,obj4;
	private Flights f1,f2,f3,f4,f5,f6,f7;
	private static ArrayList<Admin> listAdmin = new ArrayList<Admin>();
	public static ArrayList<Passenger> listPassenger = new ArrayList<Passenger>();
	public static ArrayList<Flights> listFlights = new ArrayList<Flights>();
	public static ArrayList<BookingObject> listBookings = new ArrayList<BookingObject>();
	private JLabel imagelabel;
	
	public static void main (String [] args)
	{	
		new MainMenu();	
	}
	
	public MainMenu() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(54, 11, 349, 78);
		
		label1 = new JLabel("Welcome To New Pak AirLine");
		panel2.add(label1);
		label1.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		label2 = new JLabel("Flight System");
		panel2.add(label2);
		label2.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		panel.add(panel2);
		
		obj1 = new Admin("Umair F.","1234","Male");
		listAdmin.add(obj1);
		obj2 = new Admin("Fahad Khalid","Fahad123#","Male");
		listAdmin.add(obj2);
		obj3 = new Admin("Sana Imran","Sana123#","Female");
		listAdmin.add(obj3);
		obj4 = new Admin("Asad Tariq","Asad123#","Male");
		listAdmin.add(obj4);
		
		f1 = new Flights("Dom 300","Lahore North","Karachi North","12.00 H","13.00 H",50,10);
		listFlights.add(f1);
		f2 = new Flights("Dom 301","Islamabad North","Karachi North","9.00 H","11.00 H",50,10);
		listFlights.add(f2);
		f3 = new Flights("Dom 302","Karachi South","Quetta North","14.00 H","15.50 H",50,10);
		listFlights.add(f3);
		f4 = new Flights("Int 303","Peshawar North","America","00.00 H","11.00 H",50,10);
		listFlights.add(f4);
		f5 = new Flights("Int 304","Quetta South","Qatar","2.00 H","4.00 H",50,10);
		listFlights.add(f5);
		f6 = new Flights("Int 305","Islamabad South","Frankfurt","6.00 H","21.00 H",50,10);
		listFlights.add(f6);
		f7 = new Flights("Int 306","Lahore South","Karachi North","18.00 H","19.00 H",50,10);
		listFlights.add(f7);
		
		btn1 = new JButton("About");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new About();
			}
		});
		btn1.setForeground(Color.red);
		btn1.setFont(new Font("Serif", Font.PLAIN, 18));
		btn1.setBounds(38, 130, 113, 36);
		panel.add(btn1);
		
		btn2 = new JButton("Admin");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminLogin(listAdmin);
			}
		});
		btn2.setForeground(Color.RED);
		btn2.setFont(new Font("Serif", Font.PLAIN, 18));
		btn2.setBounds(177, 130, 113, 36);
		panel.add(btn2);
		
		btn3 = new JButton("Passenger");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new LogInScreen();
			}
		});
		btn3.setForeground(Color.RED);
		btn3.setFont(new Font("Serif", Font.PLAIN, 18));
		btn3.setBounds(316, 130, 113, 36);
		panel.add(btn3);
		
		JButton btn3_1 = new JButton("Exit");
		btn3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn3_1.setForeground(Color.RED);
		btn3_1.setFont(new Font("Serif", Font.PLAIN, 18));
		btn3_1.setBounds(316, 353, 113, 36);
		panel.add(btn3_1);
		
//		imagelabel = new JLabel("");
//		imagelabel.setBounds(23, 189, 436, 213);
//		ImageIcon img = new ImageIcon(this.getClass().getResource("/picture1.jpg"));
//		imagelabel.setIcon(img);
//		panel.add(imagelabel);
		
		setTitle("Home Page");
		setBounds(100,100,500,450);
		setVisible(true);
		
	}
}
