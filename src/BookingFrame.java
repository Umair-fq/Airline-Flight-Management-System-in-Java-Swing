import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class BookingFrame extends JFrame
{
	private JPanel panel,panel2;
	private JLabel labeltag,label;
	private DefaultTableModel dtm;
	private JTable table;
	private Passenger object;
	private JScrollPane sp;
	private JButton btnBook;

	public BookingFrame(Passenger object)
	{
		this.object=object;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(58, 11, 583, 41);
		panel.add(panel2);
		
		label = new JLabel("Schedule of NPAFS Flights");
		panel2.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		labeltag = new JLabel("NPAFS Flight Schedule on 28 Dec 2021");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltag.setBounds(256, 63, 301, 22);
		panel.add(labeltag);
		
		String [] headings = {"Flight Id","Departure Airport","Landing Airport","Departure Time",
				"Landing Time","Economy Seats","Business Seats"};
		
		dtm = new DefaultTableModel(headings,0);
		
		for (int i=0; i<MainMenu.listFlights.size(); i++)
		{
			Object [] arr = {MainMenu.listFlights.get(i).getFlightId(),MainMenu.listFlights.get(i).getDepartureAirport(),
					MainMenu.listFlights.get(i).getLandingAirport(),MainMenu.listFlights.get(i).getDepartureTime(),
					MainMenu.listFlights.get(i).getLandingTime(),MainMenu.listFlights.get(i).getSeatsEconomy(),
					MainMenu.listFlights.get(i).getSeatsBusiness()};
			
			dtm.addRow(arr);
		}
		
		table = new JTable(dtm);
		sp = new JScrollPane(table);
		sp.setBounds(10, 96, 686, 255);
		panel.add(sp);
		
		btnBook = new JButton("Book");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRowCount()>1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select only One flight!!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (table.getSelectedRow()!=-1)
				{
					int index=table.getSelectedRow();
					Flights tempObject = MainMenu.listFlights.get(index);
					
					String [] Options = {"Economy","Business"};
					
					int choice = JOptionPane.showOptionDialog(panel,"Select The Seat Type!!","Select Class",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE,null,Options,Options[0]);
					
					if (choice==0)
					{	
						if (tempObject.getSeatsEconomy()>0)
						{
							String str = JOptionPane.showInputDialog(panel,"Enter Number of seats you want to book");
							if (validSeats(str)==true)
							{
								int seatsBooked = Integer.parseInt(str);
							  if (seatsBooked!=0)
							  {
								if (tempObject.getSeatsEconomy()>=seatsBooked)
								{
									if (tempObject.getFlightId().contains("Int")||tempObject.getFlightId().contains("INT"))
									{
										String s = JOptionPane.showInputDialog("Do you hava Passport??Yes/No?");
										if(s.equals("yes")||s.equals("Yes")||s.equals("y")||s.equals("Y")|| s.equals("YES"))
										{
												tempObject.setSeatsEconomy(tempObject.getSeatsEconomy()-seatsBooked);
							
												BookingObject obj = new BookingObject(tempObject.getFlightId(),tempObject.getDepartureAirport(),
														tempObject.getDepartureTime(),tempObject.getLandingAirport(),
														tempObject.getLandingTime(),seatsBooked,0);
												
													MainMenu.listBookings.add(obj);
									
													JOptionPane msg = new JOptionPane();
													msg.showMessageDialog(panel,"Successfully Booked","Successful",JOptionPane.INFORMATION_MESSAGE);
													dispose();
													new BookingFrame(object);
										}
										else
										{
											JOptionPane msg = new JOptionPane();
											msg.showMessageDialog(panel,"Can not Book because you dont have passport!!","Failed",JOptionPane.INFORMATION_MESSAGE);
										}
									}
									else
									{
										
										tempObject.setSeatsEconomy(tempObject.getSeatsEconomy()-seatsBooked);
										
										BookingObject obj = new BookingObject(tempObject.getFlightId(),tempObject.getDepartureAirport(),
												tempObject.getDepartureTime(),tempObject.getLandingAirport(),
												tempObject.getLandingTime(),seatsBooked,0);
										MainMenu.listBookings.add(obj);
									
											JOptionPane msg = new JOptionPane();
											msg.showMessageDialog(panel,"Successfully Booked","Successful",JOptionPane.INFORMATION_MESSAGE);
											dispose();
											new BookingFrame(object);
										
									}
								}
								else
								{
									JOptionPane msg = new JOptionPane();
									msg.showMessageDialog(panel,"Not Enough Available Seats!","Failed",JOptionPane.INFORMATION_MESSAGE);
								}
							  }
							 else
							 {
										JOptionPane msg = new JOptionPane();
											msg.showMessageDialog(panel,"Enter Atleast One Seat!","Failed",JOptionPane.INFORMATION_MESSAGE);
							  }
							}
							else
							{
								JOptionPane msg = new JOptionPane();
								msg.showMessageDialog(panel,"Invalid Input for seats","Error",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane msg = new JOptionPane();
							msg.showMessageDialog(panel,"No Available Seats in Selected Class! Booking Failed","Not Booked",JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
						
					else if (choice==1)
					{	
						if (tempObject.getSeatsBusiness()>0)
						{
							String str = JOptionPane.showInputDialog(panel,"Enter Number of seats you want to book");
							
							if (validSeats(str)==true)
							{
								int seatsBooked = Integer.parseInt(str);
							if (seatsBooked!=0)
							{
								if (tempObject.getSeatsBusiness()>=seatsBooked)
								{
									if (tempObject.getFlightId().contains("Int")||tempObject.getFlightId().contains("INT"))
									{
											String s = JOptionPane.showInputDialog("Do you hava Passport??Yes/No?");
									
											if(s.equals("yes")||s.equals("Yes")||s.equals("y")||s.equals("Y")|| s.equals("YES"))
											{
												tempObject.setSeatsBusiness(tempObject.getSeatsBusiness()-seatsBooked);
							
												BookingObject obj = new BookingObject(tempObject.getFlightId(),tempObject.getDepartureAirport(),
														tempObject.getDepartureTime(),tempObject.getLandingAirport(),
														tempObject.getLandingTime(),0,
														seatsBooked);
												
														MainMenu.listBookings.add(obj);
												
														JOptionPane msg = new JOptionPane();
														msg.showMessageDialog(panel,"Successfully Booked","Successful",JOptionPane.INFORMATION_MESSAGE);
														dispose();
														new BookingFrame(object);
											}
											else
											{
												JOptionPane msg = new JOptionPane();
												msg.showMessageDialog(panel,"Can not Book because you dont have passport!!","Failed",JOptionPane.INFORMATION_MESSAGE);
											}
									}
									else
									{
										
										tempObject.setSeatsBusiness(tempObject.getSeatsBusiness()-seatsBooked);
										
										BookingObject obj = new BookingObject(tempObject.getFlightId(),tempObject.getDepartureAirport(),
												tempObject.getDepartureTime(),tempObject.getLandingAirport(),
												tempObject.getLandingTime(),0,
												seatsBooked);
										MainMenu.listBookings.add(obj);
							
												JOptionPane msg = new JOptionPane();
												msg.showMessageDialog(panel,"Successfully Booked","Successful",JOptionPane.INFORMATION_MESSAGE);
												dispose();
												new BookingFrame(object);
										
									}
								
								}
								else
								{
									JOptionPane msg = new JOptionPane();
									msg.showMessageDialog(panel,"Not Enough Available Seats!","Failed",JOptionPane.INFORMATION_MESSAGE);
								}
							  }
							  else
							  {
								  JOptionPane msg = new JOptionPane();
									msg.showMessageDialog(panel,"Select atleast one seat!!","Failed",JOptionPane.INFORMATION_MESSAGE);
							  }
							}
							else
							{
								JOptionPane msg = new JOptionPane();
								msg.showMessageDialog(panel,"Invalid Input for seats","Error",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else
						{
							JOptionPane msg = new JOptionPane();
							msg.showMessageDialog(panel,"No Available Seats in Selected Class! Booking Failed","Not Booked",JOptionPane.INFORMATION_MESSAGE);
						}
						
						
					}
	
					
				}
				else if (table.getSelectedRow()==-1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select any Flight first!!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnBook.setForeground(Color.RED);
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBook.setBounds(223, 375, 103, 34);
		panel.add(btnBook);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(378, 375, 103, 34);
		panel.add(btnBack);
		
		JLabel labeltag_1 = new JLabel(object.getUsername()+"'s  BOOKING Panel");
		labeltag_1.setForeground(Color.RED);
		labeltag_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labeltag_1.setBounds(10, 63, 213, 22);
		panel.add(labeltag_1);
		
		setTitle("Update Schedule");
		setVisible(true);
	}
	
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
}





















