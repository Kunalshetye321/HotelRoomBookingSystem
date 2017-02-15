import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class AddFoodMenu extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labelFoodID,labelDisplayFoodID,labelFoodName,labelFoodType,labelFoodPrice;
	private JTextField textfieldFoodName,textfieldFoodPrice;
	private JComboBox comboboxFoodType;
	private JButton buttonClose, buttonUpdate, buttonSave;
	private DataAccess data;
	private int FoodId;
	
	public AddFoodMenu() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		DataAccess data = new DataAccess();
		this.data = data;
		
		for(int i=0;i<data.getFoodId().length;i++)
		{
			FoodId = Integer.parseInt((String)data.getFoodId()[i]);
		}
		
		this.labelFoodID = new JLabel("Food ID : ");
		this.labelFoodID.setBounds(100, 20, 100, 20);
		this.panel.add(this.labelFoodID);
		
		this.labelDisplayFoodID = new JLabel((FoodId+1)+"");
		this.labelDisplayFoodID.setBounds(250, 20, 100, 20);
		this.panel.add(this.labelDisplayFoodID);
		
		
		this.labelFoodName = new JLabel("Food Name : ");
		this.labelFoodName.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelFoodName);
		
		this.textfieldFoodName = new JTextField();
		this.textfieldFoodName.setBounds(250, 50, 100, 20);
		this.panel.add(this.textfieldFoodName);
		
		this.labelFoodType = new JLabel("Food Type : ");
		this.labelFoodType.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelFoodType);
		
		String[] Type = {"Bangladeshi","Indian","Thai","Chaines","Western"};
		
		this.comboboxFoodType = new JComboBox(Type);
		this.comboboxFoodType.setBounds(250, 80, 150, 20);
		this.panel.add(this.comboboxFoodType);
		
		this.labelFoodPrice = new JLabel("Food Price : ");
		this.labelFoodPrice.setBounds(100, 110, 150, 20);
		this.panel.add(this.labelFoodPrice);
		
		this.textfieldFoodPrice = new JTextField();
		this.textfieldFoodPrice.setBounds(250, 110, 100, 20);
		this.panel.add(this.textfieldFoodPrice);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 150, 80, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonUpdate = new JButton("Update");
		this.buttonUpdate.setBounds(250, 150, 80, 20);
		this.panel.add(buttonUpdate);
		buttonUpdate.addActionListener(this);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(400, 150, 80, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 300);
		this.setTitle("Add Food Item");
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
			String FoodName = this.textfieldFoodName.getText(); 
			String FoodType = (String) this.comboboxFoodType.getSelectedItem();
			int FoodPrice = Integer.parseInt((String)this.textfieldFoodPrice.getText());
			
			FoodData foodData = new FoodData();
			foodData.setFoodName(FoodName);
			foodData.setFoodType(FoodType);
			foodData.setFoodPrice(FoodPrice);
			
			if(data.InsertFood(foodData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Insert Successfully!");
				AddFoodMenu addFoodMenu = new AddFoodMenu();
				addFoodMenu.setVisible(true);
				this.setVisible(false);
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Insertion Failed!");
			}
		}
	}
}
