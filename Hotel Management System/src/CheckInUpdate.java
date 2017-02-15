
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class CheckInUpdate extends JFrame implements ActionListener, ItemListener
{
	private JPanel panel;
	private JLabel labelCustomarID,labelRoomNumber,labelCheckInDate,labelDayOfStay,labelAmount,labelPayed,labelDue;
	private JTextField textfieldCheckInDate,textfieldDayOfStay,textfieldPayed,textfieldDue,textfieldAmount;
	private JComboBox comboboxCustomarID,comboboxRoomNumber;
	private JButton buttonClose, buttonSave;
	private DataAccess da;
	private String[] info;
	
	public CheckInUpdate() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);

		DataAccess da =  new DataAccess();
		this.da = da;
		
		this.labelCustomarID = new JLabel("Customar ID : ");
		this.labelCustomarID.setBounds(100, 20, 100, 20);
		this.panel.add(this.labelCustomarID);
		
		this.comboboxCustomarID = new JComboBox(da.getCustomarID());
		this.comboboxCustomarID.setBounds(250, 20, 100, 20);
		this.comboboxCustomarID.addItemListener(this);
		this.panel.add(this.comboboxCustomarID);
		
		this.labelRoomNumber = new JLabel("Room Number : ");
		this.labelRoomNumber.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelRoomNumber);
		
		this.comboboxRoomNumber = new JComboBox(da.getRoomNumber());
		this.comboboxRoomNumber.setBounds(250, 50, 100, 20);
		this.comboboxRoomNumber.addItemListener(this);
		this.panel.add(this.comboboxRoomNumber);
		
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
		
		this.buttonSave = new JButton("Save");
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
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Close")
		{
			this.setVisible(false);
		}
		else if(ae.getActionCommand() == "Update")
		{

		}
		else if(ae.getActionCommand() == "Save")
		{
			int CustomarID = Integer.parseInt((String) this.comboboxCustomarID.getSelectedItem());
			int RoomNumber = Integer.parseInt((String) this.comboboxRoomNumber.getSelectedItem());	
			String checkin = this.textfieldCheckInDate.getText(); 
			String checkout = this.textfieldDayOfStay.getText();
			int amount = Integer.parseInt((String) this.textfieldAmount.getText());
			int payed = Integer.parseInt((String) this.textfieldPayed.getText());
			int due = Integer.parseInt((String) this.textfieldDue.getText());
			
			CheckInData checkInData = new CheckInData();
			checkInData.setCustomarId(CustomarID);
			checkInData.setRoomNumber(RoomNumber);
			checkInData.setCheckInDate(checkin);
			checkInData.setCheckOutData(checkout);
			checkInData.setAmount(amount);
			checkInData.setPayed(payed);
			checkInData.setDue(due);
			
			if(da.UpdateCheckIn(checkInData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Update Successfully!");
				CheckIn checkin1 = new CheckIn();
				checkin1.setVisible(true);
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Update Failed!");
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getStateChange() == ItemEvent.SELECTED)
		{
			Object item = ie.getItem();
			int i = Integer.parseInt(item.toString());
			this.info = da.getCustomarinfo(i);
			for(int i1=0;i1<info.length;i1++)
			{
				System.out.println(info[i1]);
			}
		}
	}
}
