import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener,ItemListener
{
	private JPanel panel;
	private JLabel labelCustomarID,labelCustomarFirstName,labelCustomarRoom,labelCustomarLastName, labelCustomarCheckInDate,labelCustomarCheckOutDate,labelCustomarRoomBill,labelCustomarRoomBillPayed,lebelCustomarRoomBillDue,labelCustomarFoodBill;
	private JTextField textfieldCustomarFirstName,textfieldCustomarRoom,textfieldCustomarLastName, textfieldCustomarCheckInDate,textfieldCustomarCheckOutDate,textfieldCustomarRoomBill,textfieldCustomarRoomBillPayed,textfieldCustomarRoomBillDue,textfieldCustomarFoodBill;
	private JComboBox comboboxCustomarID;
	private JButton buttonClose, buttonSave;
	private DataAccess data;
	private String[] info;
	
	public CheckOut() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		DataAccess data = new DataAccess();
		this.data = data;
		
		this.labelCustomarID = new JLabel("Customar ID : ");
		this.labelCustomarID.setBounds(100, 20, 100, 20);
		this.panel.add(this.labelCustomarID);
		
		this.comboboxCustomarID = new JComboBox(data.getCustomarID());
		this.comboboxCustomarID.setBounds(250, 20, 100, 20);
		this.comboboxCustomarID.addItemListener(this);
		this.panel.add(this.comboboxCustomarID);
		
		this.labelCustomarFirstName = new JLabel("First Name : ");
		this.labelCustomarFirstName.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelCustomarFirstName);
		
		this.textfieldCustomarFirstName = new JTextField();
		this.textfieldCustomarFirstName.setBounds(250, 50, 100, 20);
		this.panel.add(this.textfieldCustomarFirstName);
		
		this.labelCustomarLastName = new JLabel("Last Name : ");
		this.labelCustomarLastName.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelCustomarLastName);
	
		this.textfieldCustomarLastName = new JTextField();
		this.textfieldCustomarLastName.setBounds(250, 80, 100, 20);
		this.panel.add(this.textfieldCustomarLastName);
		
		this.labelCustomarCheckInDate = new JLabel("Check In Date : ");
		this.labelCustomarCheckInDate.setBounds(100, 140, 100, 20);
		this.panel.add(this.labelCustomarCheckInDate);
		
		this.textfieldCustomarCheckInDate = new JTextField();
		this.textfieldCustomarCheckInDate.setBounds(250, 140, 100, 20);
		this.panel.add(this.textfieldCustomarCheckInDate);
		
		this.labelCustomarCheckOutDate = new JLabel("Check Out Date : ");
		this.labelCustomarCheckOutDate.setBounds(100, 170, 100, 20);
		this.panel.add(this.labelCustomarCheckOutDate);
		
		this.textfieldCustomarCheckOutDate = new JTextField();
		this.textfieldCustomarCheckOutDate.setBounds(250, 170, 100, 20);
		this.panel.add(this.textfieldCustomarCheckOutDate);
		
		this.labelCustomarRoomBill = new JLabel("Total Room Bill : ");
		this.labelCustomarRoomBill.setBounds(100, 200, 100, 20);
		this.panel.add(this.labelCustomarRoomBill);
		
		this.textfieldCustomarRoomBill = new JTextField();
		this.textfieldCustomarRoomBill.setBounds(250, 200, 100, 20);
		this.panel.add(this.textfieldCustomarRoomBill);
		
		this.lebelCustomarRoomBillDue = new JLabel("Room Bill Due : ");
		this.lebelCustomarRoomBillDue.setBounds(100, 230, 100, 20);
		this.panel.add(this.lebelCustomarRoomBillDue);
		
		this.textfieldCustomarRoomBillDue = new JTextField();
		this.textfieldCustomarRoomBillDue.setBounds(250, 230, 100, 20);
		this.panel.add(this.textfieldCustomarRoomBillDue);
		
		this.labelCustomarFoodBill = new JLabel("Food Bill Due : ");
		this.labelCustomarFoodBill.setBounds(100, 260, 100, 20);
		this.panel.add(this.labelCustomarFoodBill);
		
		this.textfieldCustomarFoodBill = new JTextField();
		this.textfieldCustomarFoodBill.setBounds(250, 260, 100, 20);
		this.panel.add(this.textfieldCustomarFoodBill);
		
		this.labelCustomarRoomBillPayed = new JLabel("Total Bill Payed : ");
		this.labelCustomarRoomBillPayed.setBounds(100, 290, 100, 20);
		this.panel.add(this.labelCustomarRoomBillPayed);
		
		this.textfieldCustomarRoomBillPayed = new JTextField();
		this.textfieldCustomarRoomBillPayed.setBounds(250, 290, 100, 20);
		this.panel.add(this.textfieldCustomarRoomBillPayed);
		
		this.labelCustomarRoom = new JLabel("Room : ");
		this.labelCustomarRoom.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelCustomarRoom);
		
		this.textfieldCustomarRoom = new JTextField();
		this.textfieldCustomarRoom.setBounds(250, 110, 100, 20);
		this.panel.add(this.textfieldCustomarRoom);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 350, 100, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(350, 350, 100, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
				
		this.add(this.panel);
		this.setSize(600, 600);
		this.setTitle("Customar Registration");
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
		else if(ae.getActionCommand() == "Save")
		{
			int CoustomarID =Integer.parseInt((String) this.comboboxCustomarID.getSelectedItem());
			int RoomNumber = Integer.parseInt((String) this.textfieldCustomarRoom.getText());
			String CheckInDate = this.textfieldCustomarCheckInDate.getText();
			String CheckOutDate = this.textfieldCustomarCheckOutDate.getText();
			int TotalRoomBill = Integer.parseInt((String) this.textfieldCustomarRoomBill.getText());
			int RoomBillDue = Integer.parseInt((String) this.textfieldCustomarRoomBillDue.getText());
			int FoodBillDue = Integer.parseInt((String) this.textfieldCustomarFoodBill.getText());
			int TotalBillPayed = Integer.parseInt((String) this.textfieldCustomarRoomBillPayed.getText());
			
			CheckOutData checkOutData = new CheckOutData();
			checkOutData.setCoustomarID(CoustomarID);
			checkOutData.setRoomNumber(RoomNumber);
			checkOutData.setTotalRoomBill(TotalRoomBill);
			checkOutData.setRoomBillDue(RoomBillDue);
			checkOutData.setFoodBillDue(FoodBillDue);
			checkOutData.setTotalBillPayed(TotalBillPayed);
			checkOutData.setCheckInDate(CheckInDate);
			checkOutData.setCheckOutDate(CheckOutDate);
			
			if(data.InsertCheckOutInfo(checkOutData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Insert Successfully!");
				CheckOut checkout = new CheckOut();
				checkout.setVisible(true);
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
		if(ie.getStateChange() == ItemEvent.SELECTED)
		{
			Object item = ie.getItem();
			int i = Integer.parseInt(item.toString());
			this.info = data.getCustomerCheckOutinfo(i);
			textfieldCustomarFirstName.setText(info[0]);
			textfieldCustomarLastName.setText(info[1]);
			textfieldCustomarRoom.setText(info[2]);
			textfieldCustomarCheckInDate.setText(info[3]);
			textfieldCustomarCheckOutDate.setText(info[4]);
			textfieldCustomarRoomBill.setText(info[5]);
			textfieldCustomarRoomBillDue.setText(info[6]);
			textfieldCustomarFoodBill.setText(info[7]);
			textfieldCustomarRoomBillPayed.setText(info[8]);
			
			
			
		}
		
	}
	

}
