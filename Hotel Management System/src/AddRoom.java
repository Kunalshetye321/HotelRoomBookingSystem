import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labelRoomType,labelBedType,labelRoomNumber,labelRoomPrice,labelRoomID,labelDisplayRoomID;
	private JTextField textfieldRoomNumber,textfieldRoomPrice;
	private JComboBox comboboxRoomType,comboboxBedType;
	private JButton buttonClose, buttonSave,buttonUpdate;
	private int RoomID;
	
	public AddRoom()
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.labelRoomID = new JLabel("ADD NEW ROOM");
		this.labelRoomID.setBounds(250, 20, 200, 20);
		this.panel.add(this.labelRoomID);
		
		
		this.labelRoomType = new JLabel("Room Type : ");
		this.labelRoomType.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelRoomType);
		
		String[] roomtype = {"AC","NoN-AC"};
		
		this.comboboxRoomType = new JComboBox(roomtype);
		this.comboboxRoomType.setBounds(200, 50, 100, 20);
		this.panel.add(this.comboboxRoomType);
		
		this.labelBedType = new JLabel("Bed Type : ");
		this.labelBedType.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelBedType);
		
		String[] bedtype = {"Singal","Double"};
		
		this.comboboxBedType = new JComboBox(bedtype);
		this.comboboxBedType.setBounds(200, 80, 100, 20);
		this.panel.add(this.comboboxBedType);
		
		this.labelRoomNumber = new JLabel("Room Number : ");
		this.labelRoomNumber.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelRoomNumber);
		
		this.textfieldRoomNumber = new JTextField();
		this.textfieldRoomNumber.setBounds(200, 110, 100, 20);
		this.panel.add(this.textfieldRoomNumber);
		
		this.labelRoomPrice = new JLabel("Room Price : ");
		this.labelRoomPrice.setBounds(100, 140, 100, 20);
		this.panel.add(this.labelRoomPrice);
		
		this.textfieldRoomPrice = new JTextField();
		this.textfieldRoomPrice.setBounds(200, 140, 100, 20);
		this.panel.add(this.textfieldRoomPrice);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 200, 100, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonUpdate = new JButton("Update");
		this.buttonUpdate.setBounds(250, 200, 100, 20);
		this.panel.add(buttonUpdate);
		buttonUpdate.addActionListener(this);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(350, 200, 100, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		
		this.add(this.panel);
		this.setSize(600, 600);
		this.setTitle("ADD ROOM");
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
			String RoomType = (String) this.comboboxRoomType.getSelectedItem(); 
			String BedType = (String) this.comboboxBedType.getSelectedItem();
			int RoomNumber = Integer.parseInt((String)this.textfieldRoomNumber.getText());
			int RoomPrice = Integer.parseInt((String)this.textfieldRoomPrice.getText());
			
			RoomData roomData = new RoomData();
			roomData.setRoomType(RoomType);
			roomData.setBedType(BedType);
			roomData.setRoomNumber(RoomNumber);
			roomData.setRoomPrice(RoomPrice);
			
			DataAccess data = new DataAccess();	

			if(data.InsertRoom(roomData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Insert Successfully!");
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Insertion Failed!");
			}
		}
		
	}
	
}
