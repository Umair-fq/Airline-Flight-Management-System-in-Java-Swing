import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddFlight extends JFrame {

	private JPanel panel,panel2;
	private JLabel labeltag;
	private JLabel lblflightId;
	private JLabel lbldepartureAirport;
	private JLabel lbllandingAirport;
	private JLabel lbldepartureTime;
	private JLabel lbllandingTime;
	private JLabel lbleconomySeats;
	private JLabel lblbusinessSeats;
	private JTextField fieldflightId;
	private JTextField fielddepartureAirport;
	private JTextField fieldlandingAirport;
	private JTextField fielddepartureTime;
	private JTextField fieldlandingTime;
	private JTextField fieldeconomySeats;
	private JTextField fieldbusinessSeats;

	
	public AddFlight()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		panel = new JPanel();
		panel.setBackground(new Color (216,191,216));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(82, 11, 408, 43);
		panel.add(panel2);
		
		JLabel lblAddNewFlight = new JLabel("Add New Flight Schedules");
		panel2.add(lblAddNewFlight);
		lblAddNewFlight.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		labeltag = new JLabel("Enter Flight Details");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		labeltag.setBounds(198, 77, 187, 26);
		panel.add(labeltag);
		
		lblflightId = new JLabel("Flight ID :");
		lblflightId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblflightId.setBounds(36, 130, 80, 26);
		panel.add(lblflightId);
		
		lbldepartureAirport = new JLabel("Departure Airport :");
		lbldepartureAirport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldepartureAirport.setBounds(36, 180, 127, 26);
		panel.add(lbldepartureAirport);
		
		lbllandingAirport = new JLabel("Landing Airport  :");
		lbllandingAirport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbllandingAirport.setBounds(36, 230, 127, 26);
		panel.add(lbllandingAirport);
		
		lbldepartureTime = new JLabel("Departure Time :");
		lbldepartureTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldepartureTime.setBounds(36, 280, 127, 26);
		panel.add(lbldepartureTime);
		
		lbllandingTime = new JLabel("Landing Time :");
		lbllandingTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbllandingTime.setBounds(36, 330, 127, 26);
		panel.add(lbllandingTime);
		
		lbleconomySeats = new JLabel("Economy Seats :");
		lbleconomySeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbleconomySeats.setBounds(335, 162, 127, 26);
		panel.add(lbleconomySeats);
		
		lblbusinessSeats = new JLabel("Business Seats :");
		lblbusinessSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbusinessSeats.setBounds(335, 242, 127, 26);
		panel.add(lblbusinessSeats);
		
		fieldflightId = new JTextField();
		fieldflightId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldflightId.setBounds(177, 135, 96, 20);
		panel.add(fieldflightId);
		fieldflightId.setColumns(10);
		
		fielddepartureAirport = new JTextField();
		fielddepartureAirport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fielddepartureAirport.setColumns(10);
		fielddepartureAirport.setBounds(177, 185, 96, 20);
		panel.add(fielddepartureAirport);
		
		fieldlandingAirport = new JTextField();
		fieldlandingAirport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldlandingAirport.setColumns(10);
		fieldlandingAirport.setBounds(177, 235, 96, 20);
		panel.add(fieldlandingAirport);
		
		fielddepartureTime = new JTextField();
		fielddepartureTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fielddepartureTime.setColumns(10);
		fielddepartureTime.setBounds(177, 285, 96, 20);
		panel.add(fielddepartureTime);
		
		fieldlandingTime = new JTextField();
		fieldlandingTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldlandingTime.setColumns(10);
		fieldlandingTime.setBounds(177, 335, 96, 20);
		panel.add(fieldlandingTime);
		
		fieldeconomySeats = new JTextField();
		fieldeconomySeats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldeconomySeats.setColumns(10);
		fieldeconomySeats.setBounds(454, 162, 96, 20);
		panel.add(fieldeconomySeats);
		
		fieldbusinessSeats = new JTextField();
		fieldbusinessSeats.setColumns(10);
		fieldbusinessSeats.setBounds(454, 247, 96, 20);
		panel.add(fieldbusinessSeats);
		
		JButton btnaAdd = new JButton("Add");
		btnaAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Composition of Object Of Flights
				if (!fieldflightId.getText().equals("")&& !fielddepartureAirport.getText().equals("") &&
					!fieldlandingAirport.getText().equals("")&& !fielddepartureTime.getText().equals("")&& 
					!fieldlandingTime.getText().equals("")&& !fieldeconomySeats.getText().equals("")&&
					!fieldbusinessSeats.getText().equals(""))
					{
					 if (fieldflightId.getText().contains("INT") || fieldflightId.getText().contains("Int") || fieldflightId.getText().contains("Dom") || fieldflightId.getText().contains("DOM") )
					  {
							if (validSeats(fieldeconomySeats.getText())==true && validSeats(fieldbusinessSeats.getText())==true)
							{
								int eco = Integer.parseInt(fieldeconomySeats.getText());
								int business = Integer.parseInt(fieldbusinessSeats.getText());
								
								if ((eco>=0 && eco<=50) && (business>=0 && business<=10))
								{
									if(validFlight())
									{
						
										Flights object = new Flights(fieldflightId.getText(),fielddepartureAirport.getText(), fieldlandingAirport.getText(),
												fielddepartureTime.getText(),fieldlandingTime.getText(),eco,business);	
						
										MainMenu.listFlights.add(object);
						
											fieldflightId.setText(null);
											fielddepartureAirport.setText(null);
											fieldlandingAirport.setText(null);
											fielddepartureTime.setText(null);
											fieldlandingTime.setText(null);
											fieldeconomySeats.setText(null);
											fieldbusinessSeats.setText(null);
											labeltag.setText("Enter Flight Details");
											JOptionPane msg = new JOptionPane();
											msg.showMessageDialog(panel,"Successfully Added","Successful",JOptionPane.INFORMATION_MESSAGE);	
									}
									else
									{
										JOptionPane msg = new JOptionPane();
										msg.showMessageDialog(panel,"Five Flights can not Land at a time at same Airport","Failed",JOptionPane.INFORMATION_MESSAGE);	
									}
								}
								else
								{
									JOptionPane msg = new JOptionPane();
									msg.showMessageDialog(panel,"Invalid Numbers for Seats","Failed",JOptionPane.INFORMATION_MESSAGE);
								}
							
							}
							
							else
							{
									JOptionPane msg = new JOptionPane();
									msg.showMessageDialog(panel,"Please Enter Only positive Integers for Seats!","Error",JOptionPane.INFORMATION_MESSAGE);
							}
						  }
					 
						  else
						  {
							  //
							  JOptionPane msg = new JOptionPane();
								msg.showMessageDialog(panel,"Invalid Input for flight Id!","Error",JOptionPane.INFORMATION_MESSAGE);
						  }
						}
				else
				{
					labeltag.setText("*Fill All Slots");
				}
				
			}
		});
		btnaAdd.setForeground(Color.RED);
		btnaAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnaAdd.setBounds(161, 395, 112, 35);
		panel.add(btnaAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBounds(332, 395, 112, 35);
		panel.add(btnBack);
		
		setTitle("Add a Flight");
		setVisible(true);
	}
	
	//function for validation of seats input data type
	public boolean validSeats(String string)
	{
		char [] arr = string.toCharArray();
		boolean valid=true;
		
		for (char character: arr)
		{
			if (Character.isDigit(character)==false)
			{
				valid=false;
				break;
			}
		}
		return valid;
	}
	
	// Function to ensure that more than 5 flights do not land at same time on same airport
	public boolean validFlight()
	{
		int counter=1;
		
		for (Flights object : MainMenu.listFlights)
		{
			
			if (object.getLandingAirport().equals(fieldlandingAirport.getText()) && object.getLandingTime().equals(fieldlandingTime.getText()))
			{
				counter++;
			}
		}
		
		if (counter<=5)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
}










