import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Vector;

public class ViewAllCustomarInfo extends JFrame implements ActionListener, KeyListener
{
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextField textfieldSearch;
	private JButton buttonok,buttonSearch;
	
	public ViewAllCustomarInfo()
	{
		this.initializeComponents();
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		//this.panel.setBackground(Color.orange);
		
		Vector<String> columns = new Vector<String>();
		columns.add("First name");
		columns.add("Last Name");
		columns.add("Gender");
		columns.add("Marrage Status");
		columns.add("Address");
		columns.add("Mobile Number");
		columns.add("Email");
		columns.add("National ID");
		columns.add("Passport Number");
		columns.add("No. OF Adults");
		columns.add("No. OF Child");
		columns.add("Room Number");
		columns.add("Check In Date");
		columns.add("Check Out Date");

		
		DataAccess data = new DataAccess();
		this.tableModel = new DefaultTableModel(data.getAllMemberInfo(), columns);
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
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(10).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(60);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds( 10, 20, 1350, 200);
		this.panel.add(this.scrollPane);
		
		this.buttonok =new JButton("OK");
		this.buttonok.setBounds(550, 280, 100, 30);
		this.buttonok.addActionListener(this);
		this.panel.add(this.buttonok);
		
		this.buttonSearch =new JButton("Search By First Name");
		this.buttonSearch.setBounds(20, 280, 200, 30);
		this.buttonSearch.addActionListener(this);
		this.panel.add(this.buttonSearch);
		
		this.textfieldSearch= new JTextField();
		this.textfieldSearch.setBounds(300, 280, 100, 20);
		this.textfieldSearch.addKeyListener(this);
		this.panel.add(this.textfieldSearch);
		
		this.add(this.panel);
		this.setTitle("DISPLAY MEMBERLIST");
		this.setSize(1500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent kr) 
	{
		try {
			    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nahiyanhotel","root","");
				String sql="SELECT * FROM customarinfo WHERE first_name =?";
				PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
				stmt.setString(1, textfieldSearch.getText());
				ResultSet rs=stmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				stmt.close();
				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


}
