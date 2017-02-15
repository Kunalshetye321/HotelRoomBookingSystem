import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class DeleteCheckIn extends JFrame implements ActionListener, ItemListener
{
	private JPanel panel;
	private JLabel labelCustomarID,labelRoomNumber,labelCheckInDate,labelDayOfStay,labelAmount,labelPayed,labelDue;
	private JTextField textfieldCheckInDate,textfieldRoomNumber,textfieldDayOfStay,textfieldPayed,textfieldDue,textfieldAmount;
	private JComboBox comboboxCustomarID;
	private JButton buttonClose, buttonSave;
	private DataAccess data;
	private String[] info;
	
	public DeleteCheckIn() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		DataAccess data =  new DataAccess();
		this.data = data;
		
		this.labelCustomarID = new JLabel("Customar ID : ");
		this.labelCustomarID.setBounds(100, 20, 100, 20);
		this.panel.add(this.labelCustomarID);
		
		this.comboboxCustomarID = new JComboBox(data.getCustomarID());
		this.comboboxCustomarID.setBounds(250, 20, 100, 20);
		this.comboboxCustomarID.addItemListener(this);
		this.panel.add(this.comboboxCustomarID);
		
		this.labelRoomNumber = new JLabel("Room Number : ");
		this.labelRoomNumber.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelRoomNumber);
		
		this.textfieldRoomNumber = new JTextField();
		this.textfieldRoomNumber.setBounds(250, 50, 100, 20);
		this.panel.add(this.textfieldRoomNumber);
		
		this.labelCheckInDate = new JLabel("Check-In Date : ");
		this.labelCheckInDate.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelCheckInDate);
		
		this.textfieldCheckInDate = new JTextField();
		this.textfieldCheckInDate.setBounds(250, 80, 100, 20);
		this.panel.add(this.textfieldCheckInDate);
		
		this.labelDayOfStay = new JLabel("Check-Out Date : ");
		this.labelDayOfStay.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelDayOfStay);
		
		this.textfieldDayOfStay = new JTextField();
		this.textfieldDayOfStay.setBounds(250, 110, 100, 20);
		this.panel.add(this.textfieldDayOfStay);
		
		this.labelAmount = new JLabel("Amount : ");
		this.labelAmount.setBounds(100, 140, 100, 20);
		this.panel.add(this.labelAmount);
		
		this.textfieldAmount = new JTextField();
		this.textfieldAmount.setBounds(250, 140, 100, 20);
		this.panel.add(this.textfieldAmount);
		
		this.labelPayed = new JLabel("Payed : ");
		this.labelPayed.setBounds(100, 170, 100, 20);
		this.panel.add(this.labelPayed);
		
		this.textfieldPayed = new JTextField();
		this.textfieldPayed.setBounds(250, 170, 100, 20);
		this.panel.add(this.textfieldPayed);
		
		this.labelDue = new JLabel("Due : ");
		this.labelDue.setBounds(100, 200, 100, 20);
		this.panel.add(this.labelDue);
		
		this.textfieldDue = new JTextField();
		this.textfieldDue.setBounds(250, 200, 100, 20);
		this.panel.add(this.textfieldDue);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 250, 80, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonSave = new JButton("Delete");
		this.buttonSave.setBounds(400, 250, 80, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 400);
		this.setTitle("Customar Check-In");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getStateChange() == ItemEvent.SELECTED)
		{
			Object item = ie.getItem();
			int i = Integer.parseInt(item.toString());
			this.info = data.getCheckIninfo(i);
			textfieldCheckInDate.setText(info[1]);
			textfieldRoomNumber.setText(info[0]);
			textfieldDayOfStay.setText(info[2]);
			textfieldPayed.setText(info[4]);
			textfieldDue.setText(info[5]);
			textfieldAmount.setText(info[3]);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		int i = Integer.parseInt((String)this.comboboxCustomarID.getSelectedItem());
		
		if(ae.getActionCommand() == "Close")
		{
			this.setVisible(false);
		}
		else if(ae.getActionCommand() == "Delete")
		{
			if(data.DELETECheckInInfo(i) == true)
			{
			
				JOptionPane.showMessageDialog(null, "DELETE Successfully!");
				DeleteCheckIn delete = new DeleteCheckIn();
				delete.setVisible(true);
				this.setVisible(false);
				
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "DELETE Failed!");
			}
		}
		
	}

}
