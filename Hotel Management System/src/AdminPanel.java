import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labeladmin;
	private JButton buttonAddCustomar,buttonCheckIn,buttonViewCheckOut,buttonOrder,buttonDeleteCheckIn,buttonCheckOut,buttonViewAllCustomar,buttonViewAllRooms,buttonFoodMenu,buttonAddRoom,buttonLogout;
	
	public AdminPanel() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.buttonAddCustomar = new JButton("Add Customar");
		this.buttonAddCustomar.setBounds(50, 50, 300, 50);
		this.panel.add(buttonAddCustomar);
		buttonAddCustomar.addActionListener(this);
		
		this.buttonViewAllCustomar = new JButton("View All Customar");
		this.buttonViewAllCustomar.setBounds(600, 50, 300, 50);
		this.panel.add(buttonViewAllCustomar);
		buttonViewAllCustomar.addActionListener(this);
		
		this.buttonCheckIn = new JButton("Check In");
		this.buttonCheckIn.setBounds(50, 150, 300, 50);
		this.panel.add(buttonCheckIn);
		buttonCheckIn.addActionListener(this);
		
		this.buttonDeleteCheckIn = new JButton("Delete Check In");
		this.buttonDeleteCheckIn.setBounds(600, 150, 300, 50);
		this.panel.add(buttonDeleteCheckIn);
		buttonDeleteCheckIn.addActionListener(this);
		
		this.buttonCheckOut = new JButton("Check Out");
		this.buttonCheckOut.setBounds(50, 250, 300, 50);
		this.panel.add(buttonCheckOut);
		buttonCheckOut.addActionListener(this);
		
		this.buttonViewCheckOut = new JButton("View All Check Out");
		this.buttonViewCheckOut.setBounds(600, 250, 300, 50);
		this.panel.add(buttonViewCheckOut);
		buttonViewCheckOut.addActionListener(this);
		
		
		this.buttonAddRoom = new JButton("Add Room");
		this.buttonAddRoom.setBounds(50, 350, 300, 50);
		this.panel.add(buttonAddRoom);
		buttonAddRoom.addActionListener(this);
		
		this.buttonViewAllRooms = new JButton("View All Rooms");
		this.buttonViewAllRooms.setBounds(600, 350, 300, 50);
		this.panel.add(buttonViewAllRooms);
		buttonViewAllRooms.addActionListener(this);
		
		this.buttonFoodMenu = new JButton("Add Food Menu");
		this.buttonFoodMenu.setBounds(50, 450, 300, 50);
		this.panel.add(buttonFoodMenu);
		buttonFoodMenu.addActionListener(this);

		this.buttonOrder = new JButton("Food Order");
		this.buttonOrder.setBounds(600, 450, 300, 50);
		this.panel.add(buttonOrder);
		buttonOrder.addActionListener(this);
		
		this.buttonLogout = new JButton("Logout");
		this.buttonLogout.setBounds(330, 550, 300, 50);
		this.panel.add(buttonLogout);
		buttonLogout.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(970, 700);
		this.setTitle("Customar Registration");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Add Customar")
		{
			CustomarRegistration customarRegistration = new CustomarRegistration();
			customarRegistration.setVisible(true);
		}
		
		else if(ae.getActionCommand() == "Add Room")
		{
			AddRoom addroom = new AddRoom();
			addroom.setVisible(true);
		}
		else if(ae.getActionCommand() == "Check In")
		{
			CheckIn da = new CheckIn();
			da.setVisible(true);
		}
		else if(ae.getActionCommand() == "Add Food Menu")
		{
			AddFoodMenu addFoodMenu = new AddFoodMenu();
			addFoodMenu.setVisible(true);
		}
		else if(ae.getActionCommand() == "View All Customar")
		{
			ViewAllCustomarInfo viewAllCustomarInfo	= new ViewAllCustomarInfo();
			viewAllCustomarInfo.setVisible(true);
		}
		else if(ae.getActionCommand() == "View All Rooms")
		{
			ViewAllRoom room = new ViewAllRoom();
			room.setVisible(true);
		}
		else if(ae.getActionCommand() == "Food Order")
		{
			FoodOrder order = new FoodOrder();
			order.setVisible(true);
		}
		
		else if(ae.getActionCommand() == "Check Out")
		{
			CheckOut out = new CheckOut();
			out.setVisible(true);;
		}
		
		else if(ae.getActionCommand() == "Delete Check In")
		{
			DeleteCheckIn out = new DeleteCheckIn();
			out.setVisible(true);;
		}
		else if(ae.getActionCommand() == "View All Check Out")
		{
			ViewAllCheckOut out = new ViewAllCheckOut();
			out.setVisible(true);;
		}
		else if(ae.getActionCommand() == "Logout")
		{
			System.exit(0);
		}

		
	}
	
}
