import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class CheckIn extends JFrame implements ActionListener, ItemListener
{
	private JPanel panel;
	private JLabel labelCustomarID,labelFirstName,labelLastName,labelMobileNumber,labelNumberOfAdults,labelNumberOfChildrens,labelRoomNumber,labelRoomType,labelBedType,labelRoomPrice,labelCheckInDate,labelDayOfStay,labelAmount,labelPayed,labelDue;
	private JLabel labelDisplayFirstName,labelDisplayLastName,labelDisplayMobileNumber,labelDisplayNumberOfAdults,labelDisplayNumberOfChildrens,labelDisplayRoomType,labelDisplayBedType,labelDisplayRoomPrice,labelDisplayAmount;
	private JTextField textfieldCheckInDate,textfieldDayOfStay,textfieldPayed,textfieldDue,textfieldAmount;
	private JComboBox comboboxCustomarID,comboboxRoomNumber;
	private JButton buttonClose, buttonUpdate, buttonSave;
	private DataAccess da;
	private String[] info;
	private String[] roominfo;
	
	public CheckIn() 
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
		
		this.labelFirstName = new JLabel("First Name : ");
		this.labelFirstName.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelFirstName);
		
		this.labelDisplayFirstName = new JLabel();
		this.labelDisplayFirstName.setBounds(250, 50, 100, 20);
		this.panel.add(this.labelDisplayFirstName);
		
		this.labelLastName = new JLabel("Last Name : ");
		this.labelLastName.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelLastName);
		
		this.labelDisplayLastName = new JLabel();
		this.labelDisplayLastName.setBounds(250, 80, 100, 20);
		this.panel.add(this.labelDisplayLastName);
		
		this.labelMobileNumber = new JLabel("Mobile Number : ");
		this.labelMobileNumber.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelMobileNumber);
		
		this.labelDisplayMobileNumber = new JLabel();
		this.labelDisplayMobileNumber.setBounds(250, 110, 100, 20);
		this.panel.add(this.labelDisplayMobileNumber);
		
		this.labelNumberOfAdults = new JLabel("Number Of Adults : ");
		this.labelNumberOfAdults.setBounds(100, 140, 150, 20);
		this.panel.add(this.labelNumberOfAdults);
		
		this.labelDisplayNumberOfAdults = new JLabel();
		this.labelDisplayNumberOfAdults.setBounds(250, 140, 100, 20);
		this.panel.add(this.labelDisplayNumberOfAdults);
		
		this.labelNumberOfChildrens = new JLabel("Number Of Childrens : ");
		this.labelNumberOfChildrens.setBounds(100, 170, 150, 20);
		this.panel.add(this.labelNumberOfChildrens);
		
		this.labelDisplayNumberOfChildrens = new JLabel();
		this.labelDisplayNumberOfChildrens.setBounds(250, 170, 100, 20);
		this.panel.add(this.labelDisplayNumberOfChildrens);
		
		this.labelRoomNumber = new JLabel("Room Number : ");
		this.labelRoomNumber.setBounds(100, 200, 100, 20);
		this.panel.add(this.labelRoomNumber);
		
		this.comboboxRoomNumber = new JComboBox(da.getRoomNumber());
		this.comboboxRoomNumber.setBounds(250, 200, 100, 20);
		this.comboboxRoomNumber.addItemListener(this);
		this.panel.add(this.comboboxRoomNumber);
		
		this.labelRoomType = new JLabel("Room Type : ");
		this.labelRoomType.setBounds(100, 230, 100, 20);
		this.panel.add(this.labelRoomType);
		
		this.labelDisplayRoomType = new JLabel();
		this.labelDisplayRoomType.setBounds(250, 230, 100, 20);
		this.panel.add(this.labelDisplayRoomType);
		
		this.labelBedType = new JLabel("Bed Type : ");
		this.labelBedType.setBounds(100, 260, 100, 20);
		this.panel.add(this.labelBedType);
		
		this.labelDisplayBedType = new JLabel();
		this.labelDisplayBedType.setBounds(250, 260, 100, 20);
		this.panel.add(this.labelDisplayBedType);
		
		this.labelRoomPrice = new JLabel("Room Price : ");
		this.labelRoomPrice.setBounds(100, 290, 100, 20);
		this.panel.add(this.labelRoomPrice);
		
		this.labelDisplayRoomPrice = new JLabel();
		this.labelDisplayRoomPrice.setBounds(250, 290, 100, 20);
		this.panel.add(this.labelDisplayRoomPrice);
		
		this.labelCheckInDate = new JLabel("Check-In Date : ");
		this.labelCheckInDate.setBounds(100, 320, 100, 20);
		this.panel.add(this.labelCheckInDate);
		
		this.textfieldCheckInDate = new JTextField();
		this.textfieldCheckInDate.setBounds(250, 320, 100, 20);
		this.panel.add(this.textfieldCheckInDate);
		
		this.labelDayOfStay = new JLabel("Check-Out Date : ");
		this.labelDayOfStay.setBounds(100, 350, 100, 20);
		this.panel.add(this.labelDayOfStay);
		
		this.textfieldDayOfStay = new JTextField();
		this.textfieldDayOfStay.setBounds(250, 350, 100, 20);
		this.panel.add(this.textfieldDayOfStay);
		
		this.labelAmount = new JLabel("Amount : ");
		this.labelAmount.setBounds(100, 380, 100, 20);
		this.panel.add(this.labelAmount);
		
		this.textfieldAmount = new JTextField();
		this.textfieldAmount.setBounds(250, 380, 100, 20);
		this.panel.add(this.textfieldAmount);
		
		this.labelPayed = new JLabel("Payed : ");
		this.labelPayed.setBounds(100, 410, 100, 20);
		this.panel.add(this.labelPayed);
		
		this.textfieldPayed = new JTextField();
		this.textfieldPayed.setBounds(250, 410, 100, 20);
		this.panel.add(this.textfieldPayed);
		
		this.labelDue = new JLabel("Due : ");
		this.labelDue.setBounds(100, 440, 100, 20);
		this.panel.add(this.labelDue);
		
		this.textfieldDue = new JTextField();
		this.textfieldDue.setBounds(250, 440, 100, 20);
		this.panel.add(this.textfieldDue);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 500, 80, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonUpdate = new JButton("Update");
		this.buttonUpdate.setBounds(250, 500, 80, 20);
		this.panel.add(buttonUpdate);
		buttonUpdate.addActionListener(this);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(400, 500, 80, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 600);
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
			CheckInUpdate  update = new CheckInUpdate();
			update.setVisible(true);
			this.setVisible(false);
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
			
			if(da.InsertCheckIn(checkInData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Insert Successfully!");
				CheckIn checkin1 = new CheckIn();
				checkin1.setVisible(true);
				this.setVisible(false);
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Insertion Failed!");
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getItemSelectable() == this.comboboxCustomarID)
		{
			Object item = ie.getItem();
			int i = Integer.parseInt(item.toString());
			this.info = da.getCustomarinfo(i);
			labelDisplayFirstName.setText(info[0]);
			labelDisplayLastName.setText(info[1]);
			labelDisplayMobileNumber.setText(info[5]);
			labelDisplayNumberOfAdults.setText(info[9]);
			labelDisplayNumberOfChildrens.setText(info[10]);
		}
		else if(ie.getItemSelectable() == this.comboboxRoomNumber)
		{
			Object itrm = ie.getItem();
			int i = Integer.parseInt(itrm.toString());
			this.roominfo = da.getRoominfo(i);
			labelDisplayRoomType.setText(roominfo[0]);
			labelDisplayBedType.setText(roominfo[1]);
			labelDisplayRoomPrice.setText(roominfo[2]);
			
		}
	}
}
