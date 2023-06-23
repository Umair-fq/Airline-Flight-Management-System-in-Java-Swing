import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class AdminBookingChange extends JFrame
{
	private JPanel panel,panel2;
	private JLabel labeltag,lblPassengerBookings;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane sp;
	private JButton btnRemove;
	
	public AdminBookingChange() 
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
		panel2.setBounds(44, 11, 678, 41);
		panel.add(panel2);
		
		lblPassengerBookings = new JLabel("Passenger Bookings");
		panel2.add(lblPassengerBookings);
		lblPassengerBookings.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		labeltag = new JLabel("Select To remove a Flight");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltag.setBounds(293, 63, 301, 22);
		panel.add(labeltag);
		
		String [] headings = {"Flight Id","Date","Departure Airport","Departure Time","Landing Airport",
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
	
					dtm.removeRow(index);
					MainMenu.listBookings.remove(temp);
					dispose();
					new AdminBookingChange();

					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Booking of Client cancelled","Flight Removed",JOptionPane.INFORMATION_MESSAGE);
				
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
		btnRemove.setBounds(231, 375, 125, 41);
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
		btnBack.setBounds(419, 375, 125, 41);
		panel.add(btnBack);
		
		setTitle("Bookings Handling");
		setVisible(true);
	}
}

	