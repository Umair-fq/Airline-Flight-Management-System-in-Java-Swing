import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.ChronoUnit;
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

public class YourBookings extends JFrame
{
	private JPanel panel,panel2;
	private JLabel labeltag,label;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane sp;
	private JButton btnRemove;
	private JButton btnBill;
	private static float penalty=0;
	private JLabel labeltagPenalty;
	
	public YourBookings() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 810, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color (216,191,216));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(58, 11, 678, 41);
		panel.add(panel2);
		
		label = new JLabel("Your Reserved Flights");
		panel2.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		labeltag = new JLabel("Select To remove a Flight");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltag.setBounds(293, 63, 301, 22);
		panel.add(labeltag);
		
		String [] headings = {"Flight Id","Date","Departure Airport","Landing Airport","Departure Time",
				"Landing Time","Economy Seats","Business Seats"};
		
		dtm = new DefaultTableModel(headings,0);
		
		for (int i=0; i<MainMenu.listBookings.size(); i++)
		{
			Object [] arr = {MainMenu.listBookings.get(i).getFlightId(),"28-12-21",MainMenu.listBookings.get(i).getDepartureAirport(),
					MainMenu.listBookings.get(i).getLandingAirport(),MainMenu.listBookings.get(i).getDepartureTime(),
					MainMenu.listBookings.get(i).getLandingTime(),MainMenu.listBookings.get(i).getSeatsEconomy(),
					MainMenu.listBookings.get(i).getSeatsBusiness()};
			
			dtm.addRow(arr);
		}
		
		table = new JTable(dtm);
		sp = new JScrollPane(table);
		sp.setBounds(10, 96, 766, 255);
		panel.add(sp);
		
		btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRowCount()>1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select only One Row!!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (table.getSelectedRow()!=-1)
				{
					int index = table.getSelectedRow();
					BookingObject temp = MainMenu.listBookings.get(index);
					
					float total=0;
					float time1 = stringConverter(temp.getLandingTime());
					float time2 = stringConverter(temp.getDepartureTime());
					float timedifference = Math.abs(time1-time2);
	
					if (temp.getFlightId().contains("INT") || temp.getFlightId().contains("Int"))
					{
						if (temp.getSeatsBusiness()==0)
						{
							float multiple = timedifference*(20000)*(temp.getSeatsEconomy());
							float Tax = (10*multiple)/100;
						    total = multiple+Tax;
						}
						else if (temp.getSeatsEconomy()==0)
						{
							float multiple = timedifference*(20000)*(temp.getSeatsBusiness());
							float Tax = (10*multiple)/100;
							total = multiple+Tax;
						}
					}
					else
					{
						if (temp.getSeatsBusiness()==0)
						{
							float multiple = timedifference*(10000)*(temp.getSeatsEconomy());
							float Tax = (5*multiple)/100;
						     total = multiple+Tax;
						}
						else if (temp.getSeatsEconomy()==0)
						{
							float multiple = timedifference*(10000)*(temp.getSeatsBusiness());
							float Tax = (5*multiple)/100;
							total = multiple+Tax;
						}
					
					}
					
						float amount = (25*total)/100;
						penalty = penalty + amount;
	
					dtm.removeRow(index);
					MainMenu.listBookings.remove(temp);
					dispose();
					new YourBookings();

					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Cancelled but you will be charged penalty! "+penalty,"Flight Removed",JOptionPane.INFORMATION_MESSAGE);
				
				}
				else if (table.getSelectedRow()==-1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select any Row!!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
	
			}
		});
		btnRemove.setForeground(Color.RED);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemove.setBounds(163, 375, 103, 34);
		panel.add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(441, 375, 103, 34);
		panel.add(btnBack);
		
		btnBill = new JButton("Bill");
		btnBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRow()==-1)
				{
					float product=0;
					
					for (int i=0; i<MainMenu.listBookings.size();i++)
					{
						float time1 = stringConverter(MainMenu.listBookings.get(i).getLandingTime());
						float time2 = stringConverter(MainMenu.listBookings.get(i).getDepartureTime());
						float timedifference = Math.abs(time1-time2);
						
						if (MainMenu.listBookings.get(i).getFlightId().contains("INT") || MainMenu.listBookings.get(i).getFlightId().contains("Int"))
						{
							if (MainMenu.listBookings.get(i).getSeatsBusiness()==0)
							{
								float multiple = timedifference*(20000)*(MainMenu.listBookings.get(i).getSeatsEconomy());
								float Tax = (10*multiple)/100;
								float total = multiple+Tax;
								product = product + total;
							}
							else if (MainMenu.listBookings.get(i).getSeatsEconomy()==0)
							{
								float multiple = timedifference*(20000)*(MainMenu.listBookings.get(i).getSeatsBusiness());
								float Tax = (10*multiple)/100;
								float total = multiple+Tax;
								product = product + total;
							}
						}
						else
						{
							if (MainMenu.listBookings.get(i).getSeatsBusiness()==0)
							{
								float multiple = timedifference*(10000)*(MainMenu.listBookings.get(i).getSeatsEconomy());
								float Tax = (5*multiple)/100;
								float total = multiple+Tax;
								product = product + total;
							}
							else if (MainMenu.listBookings.get(i).getSeatsEconomy()==0)
							{
								float multiple = timedifference*(10000)*(MainMenu.listBookings.get(i).getSeatsBusiness());
								float Tax = (5*multiple)/100;
								float total = multiple+Tax;
								product = product + total;
							}
						}
					}
							
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Your total of all flights with Tax is : "+product,"Bill",JOptionPane.INFORMATION_MESSAGE);	
				}
				
				else if (table.getSelectedRowCount()>1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select One Flight to view its Bill details ","Error",JOptionPane.INFORMATION_MESSAGE);	
				}
				
				else
				{
					int index = table.getSelectedRow();
					BookingObject temp = MainMenu.listBookings.get(index);
					
					float total=0;
					
					float time1 = stringConverter(temp.getLandingTime());
					float time2 = stringConverter(temp.getDepartureTime());
					float timedifference = Math.abs(time1-time2);
	
					if (temp.getFlightId().contains("INT") || temp.getFlightId().contains("Int"))
					{
						if (temp.getSeatsBusiness()==0)
						{
							float multiple = timedifference*(20000)*(temp.getSeatsEconomy());
							float Tax = (10*multiple)/100;
						    total = multiple+Tax;
						}
						else if (temp.getSeatsEconomy()==0)
						{
							float multiple = timedifference*(20000)*(temp.getSeatsBusiness());
							float Tax = (10*multiple)/100;
							total = multiple+Tax;
						}
					}
					else
					{
						if (temp.getSeatsBusiness()==0)
						{
							float multiple = timedifference*(10000)*(temp.getSeatsEconomy());
							float Tax = (5*multiple)/100;
						     total = multiple+Tax;
						}
						else if (temp.getSeatsEconomy()==0)
						{
							float multiple = timedifference*(10000)*(temp.getSeatsBusiness());
							float Tax = (5*multiple)/100;
							total = multiple+Tax;
						}
					
					}
			
				JOptionPane msg = new JOptionPane();
				msg.showMessageDialog(panel,"Your Bill of this Flights with Tax is : "+total,"Bill",JOptionPane.INFORMATION_MESSAGE);
				
				}
			
			}
		});
		btnBill.setForeground(Color.RED);
		btnBill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBill.setBounds(304, 375, 103, 34);
		panel.add(btnBill);
		
		labeltagPenalty = new JLabel("Current Penalty : "+penalty+" Rs.");
		labeltagPenalty.setForeground(Color.RED);
		labeltagPenalty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltagPenalty.setBounds(10, 63, 256, 22);
		panel.add(labeltagPenalty);
		
		setTitle("Update Schedule");
		setVisible(true);
	}
	
	float stringConverter(String str)
	{
		char [] array = new char[5];
		
		for (int i=0; i<=4; i++)
		{
			array[i] = str.charAt(i);
		}
		
		float number = Float.parseFloat(String.valueOf(array));
		return number;
	}
}













	