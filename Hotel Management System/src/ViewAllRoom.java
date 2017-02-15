import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Vector;

public class ViewAllRoom extends JFrame implements ActionListener
{
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField textfieldSearch;
	private JButton buttonok,buttonSearch;
	
	public ViewAllRoom()
	{
		this.initializeComponents();
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		Vector<String> columns = new Vector<String>();
		columns.add("Room Type");
		columns.add("Bed Type");
		columns.add("Room Number");
		columns.add("Room Price");
		
		DataAccess data = new DataAccess();
		this.tableModel = new DefaultTableModel(data.getAllRoomInfo(), columns);
		this.table = new JTable(this.tableModel)
		
		
		{
			public boolean isCellEditable(int row, int column)
			{
				if(column == 0)
					return true;
				else
					return false;
			}
		};
//		table.getColumnModel().getColumn(0).setPreferredWidth(30);

		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds( 10, 20, 1350, 200);
		this.panel.add(this.scrollPane);
		
		this.buttonok =new JButton("OK");
		this.buttonok.setBounds(550, 280, 100, 30);
		this.buttonok.addActionListener(this);
		this.panel.add(this.buttonok);
		
		this.add(this.panel);
		this.setTitle("DISPLAY ROOM LIST");
		this.setSize(1500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}

}
