import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class About extends JFrame
{

	private JPanel panel,panel2;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane sp;
	private JLabel lblNewLabel;
	private JLabel lblCountriesAround;
	private JLabel lblMakeYourJourney;

	public About() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		panel = new JPanel();
		panel.setBackground(new Color (216,191,216));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255,182,193));
		panel2.setBounds(58, 11, 583, 41);
		panel.add(panel2);
		
		JLabel lblAboutNpafs = new JLabel("About NPAFS");
		panel2.add(lblAboutNpafs);
		lblAboutNpafs.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel labeltag = new JLabel("NPAFS Flight Schedule on 28 Dec 2021");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltag.setBounds(204, 176, 301, 22);
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
		sp.setBounds(10, 209, 686, 160);
		panel.add(sp);
		table.setEnabled(false);
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(291, 400, 101, 29);
		panel.add(btnBack);
		
		lblNewLabel = new JLabel("Functional In five Major Cities of Pakistan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 70, 490, 22);
		panel.add(lblNewLabel);
		
		lblCountriesAround = new JLabel("25 Countries Around The Globe");
		lblCountriesAround.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCountriesAround.setBounds(26, 103, 490, 22);
		panel.add(lblCountriesAround);
		
		lblMakeYourJourney = new JLabel("Make Your Journey With Us");
		lblMakeYourJourney.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMakeYourJourney.setBounds(26, 143, 490, 22);
		panel.add(lblMakeYourJourney);
		
		setTitle("Flight Schedule");
		setVisible(true);
	}	

}
