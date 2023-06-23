import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisplaySchedule extends JFrame {

	private JPanel panel,panel2;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane sp;

	public DisplaySchedule() 
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
		
		JLabel label = new JLabel("Schedule of NPAFS Flights");
		panel2.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel labeltag = new JLabel("NPAFS Flight Schedule on 28 Dec 2021");
		labeltag.setForeground(Color.RED);
		labeltag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labeltag.setBounds(205, 63, 301, 22);
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
		sp.setBounds(10, 96, 686, 273);
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
		
		setTitle("Flight Schedule");
		setVisible(true);
	}
}
