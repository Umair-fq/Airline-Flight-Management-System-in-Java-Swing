import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateFlightSchedule extends JFrame {

	private JPanel panel,panel2;
	private JLabel lblManageFlightSchedule;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane sp;
	private JButton btnRemove,btnUpdate,btnAdd;
	private JLabel lblNewLabel_1;

	public UpdateFlightSchedule() 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 985, 620);
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(216, 191, 216));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBackground(new Color(255, 182, 193));
		panel2.setBounds(175, 107, 583, 41);
		panel.add(panel2);
		
		lblManageFlightSchedule = new JLabel("Manage Flight Schedule");
		panel2.add(lblManageFlightSchedule);
		lblManageFlightSchedule.setFont(new Font("Tahoma", Font.BOLD, 18));
		
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
		sp.setBounds(171, 154, 587, 255);
		panel.add(sp);
		
		btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRowCount()>1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select only One Row!!","",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (table.getSelectedRow()!=-1)
				{
					int index=table.getSelectedRow();
					dtm.removeRow(index);
					MainMenu.listFlights.remove(index);
				
				}
				else if (table.getSelectedRow()==-1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select any Row!!","",JOptionPane.INFORMATION_MESSAGE);
				}
	
			}
		});
		btnRemove.setForeground(Color.RED);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemove.setBounds(171, 442, 118, 34);
		panel.add(btnRemove);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (table.getSelectedRowCount()>1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select only One Row!!","",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (table.getSelectedRow()!=-1)
				{
					int index=table.getSelectedRow();
					dispose();
					new UpdateFlightRoute(index);
					
				}
				else if (table.getSelectedRow()==-1)
				{
					JOptionPane msg = new JOptionPane();
					msg.showMessageDialog(panel,"Please Select any Row!!","",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(325, 442, 118, 34);
		panel.add(btnUpdate);
		
		btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new AddFlight();
			}
		});
		btnAdd.setForeground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(477, 442, 118, 34);
		panel.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(640, 442, 118, 34);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Mari Flight Management System");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(204, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(219, 11, 633, 49);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("May 25, 2022");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 107, 171, 28);
		panel.add(lblNewLabel_1);
		
		setTitle("Update Schedule");
		setVisible(true);
	}
}
