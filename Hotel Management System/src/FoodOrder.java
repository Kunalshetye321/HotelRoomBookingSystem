import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class FoodOrder extends JFrame implements ActionListener,ItemListener
{
	private JPanel panel;
	private JLabel labelCustomerID,labelFoodType,labelFoodName,labelFoodPrice,labelFoodQuantity,labelTotalAmount;
	private JTextField textfieldFoodQuantity,textfieldFoodPrice,textfieldTotalAmount,textfieldFoodName;
	private JComboBox comboboxFoodType,comboboxCustomerID;
	private JButton buttonClose, buttonSave;
	private DataAccess data;
	private String[] name;

	
	public FoodOrder() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
	
		DataAccess data = new DataAccess();
		this.data = data;
		
		this.labelCustomerID = new JLabel("Customer ID : ");
		this.labelCustomerID.setBounds(100, 20, 100, 20);
		this.panel.add(this.labelCustomerID);
		
		this.comboboxCustomerID = new JComboBox(data.getCustomarID());
		this.comboboxCustomerID.setBounds(250, 20, 150, 20);
		this.panel.add(this.comboboxCustomerID);
		
		this.labelFoodType = new JLabel("Food Type : ");
		this.labelFoodType.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelFoodType);
		
		this.comboboxFoodType = new JComboBox(data.getFoodType());
		this.comboboxFoodType.setBounds(250, 50, 150, 20);
		this.comboboxFoodType.addItemListener(this);
		this.panel.add(this.comboboxFoodType);
		
		this.labelFoodName = new JLabel("Food Name : ");
		this.labelFoodName.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelFoodName);
		
		this.textfieldFoodName = new JTextField();
		this.textfieldFoodName.setBounds(250, 80, 150, 20);
		this.panel.add(this.textfieldFoodName);
		
		this.labelFoodPrice = new JLabel("Food Price : ");
		this.labelFoodPrice.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelFoodPrice);
		
		this.textfieldFoodPrice = new JTextField();
		this.textfieldFoodPrice.setBounds(250, 110, 150, 20);
		this.panel.add(this.textfieldFoodPrice);
		
		this.labelFoodQuantity = new JLabel("Food Quantity : ");
		this.labelFoodQuantity.setBounds(100, 140, 100, 20);
		this.panel.add(this.labelFoodQuantity);
		
		this.textfieldFoodQuantity = new JTextField();
		this.textfieldFoodQuantity.setBounds(250, 140, 150, 20);
		this.panel.add(this.textfieldFoodQuantity);
		
		this.labelTotalAmount = new JLabel("Total Amount : ");
		this.labelTotalAmount.setBounds(100, 170, 100, 20);
		this.panel.add(this.labelTotalAmount);
		
		this.textfieldTotalAmount = new JTextField();
		this.textfieldTotalAmount.setBounds(250, 170, 150, 20);
		this.panel.add(this.textfieldTotalAmount);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 250, 100, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(350, 250, 100, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 400);
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
		else if(ae.getActionCommand() == "Save")
		{
			int CustomerID = Integer.parseInt((String) this.comboboxCustomerID.getSelectedItem());
			String FoodType = (String) this.comboboxFoodType.getSelectedItem();
			String FoodName = this.textfieldFoodName.getText();
			int FoodPrice = Integer.parseInt((String)this.textfieldFoodPrice.getText());
			int FoodQuantity = Integer.parseInt((String)this.textfieldFoodQuantity.getText());
			int TotalAmount = Integer.parseInt((String)this.textfieldTotalAmount.getText());
			
			FoodOrderData foodOrderData = new FoodOrderData();
			foodOrderData.setCustomarId(CustomerID);
			foodOrderData.setFoodType(FoodType);
			foodOrderData.setFoodName(FoodName);
			foodOrderData.setFoodPrice(FoodPrice);
			foodOrderData.setFoodQuantity(FoodQuantity);
			foodOrderData.setTotalAmount(TotalAmount);
			
			if(data.InsertFoodOrder(foodOrderData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Insert Successfully!");
				FoodOrder foodOrder = new FoodOrder();
				foodOrder.setVisible(true);
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
			String i = item.toString();
			this.name = data.getFoodName(i);
			this.textfieldFoodName.setText(name[0]);
			this.textfieldFoodPrice.setText(name[1]);
			
		}
	}
}
