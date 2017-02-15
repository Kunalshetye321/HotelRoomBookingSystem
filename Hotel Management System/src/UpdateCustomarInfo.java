
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class UpdateCustomarInfo extends JFrame implements ActionListener, ItemListener
{
	private JPanel panel;
	private JLabel labelCustomarID,labelFirstName, labelLastName,labelEmail,labelMobileNumber,labelGender,lebelMaritorialStatus,labelNationalID,labelAddress,labelPassportNumber,labelNumberOfAdults,labelNumberOfChildrens;
	private JTextField textfieldFirstName,textfieldLastName,textfieldEmail,textfieldMobileNumber,textfieldNationalID,textfieldAddress,textfieldPassportNumber;
	private JRadioButton radioMale,radioFemale;
	private JCheckBox checkboxMarried;
	private JComboBox comboboxChildrens,comboboxAdults,comboboxCustomarID;
	private ButtonGroup group;
	private JButton buttonClose, buttonSave;
	private DataAccess data;
	private String[] info ;

	
	public UpdateCustomarInfo() 
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
		this.comboboxCustomarID.setBounds(200, 20, 100, 20);
		this.comboboxCustomarID.addItemListener(this);
		this.panel.add(this.comboboxCustomarID);
		
		
		this.labelFirstName = new JLabel("First Name : ");
		this.labelFirstName.setBounds(100, 50, 100, 20);
		this.panel.add(this.labelFirstName);
		
		this.textfieldFirstName = new JTextField();
		this.textfieldFirstName.setBounds(200, 50, 100, 20);
		this.panel.add(this.textfieldFirstName);
		
		this.labelLastName = new JLabel("Last Name : ");
		this.labelLastName.setBounds(100, 80, 100, 20);
		this.panel.add(this.labelLastName);
		
		this.textfieldLastName = new JTextField();
		this.textfieldLastName.setBounds(200, 80, 100, 20);
		this.panel.add(this.textfieldLastName);
		
		this.labelGender = new JLabel("Gender : ");
		this.labelGender.setBounds(100, 110, 100, 20);
		this.panel.add(this.labelGender);
		
		this.radioMale = new JRadioButton("Male");
		this.radioMale.setBounds(200, 110, 80, 20);
		this.panel.add(this.radioMale);
		
		this.radioFemale = new JRadioButton("Female");
		this.radioFemale.setBounds(300, 110, 80, 20);
		this.panel.add(this.radioFemale);
		
		this.group = new ButtonGroup();
		this.group.add(radioMale);
		this.group.add(radioFemale);
		
		this.lebelMaritorialStatus = new JLabel("Marrage Status : ");
		this.lebelMaritorialStatus.setBounds(100, 140, 100, 20);
		this.panel.add(this.lebelMaritorialStatus);
		
		this.checkboxMarried = new JCheckBox("Married");
		this.checkboxMarried.setBounds(200, 140, 100, 20);
		this.panel.add(this.checkboxMarried);
		
		this.labelAddress = new JLabel("Address : ");
		this.labelAddress.setBounds(100, 170, 100, 20);
		this.panel.add(this.labelAddress);
		
		this.textfieldAddress = new JTextField();
		this.textfieldAddress.setBounds(200, 170, 300, 50);
		this.panel.add(this.textfieldAddress);
		
		this.labelMobileNumber = new JLabel("Mobile Number : ");
		this.labelMobileNumber.setBounds(100, 230, 100, 20);
		this.panel.add(this.labelMobileNumber);
		
		this.textfieldMobileNumber = new JTextField();
		this.textfieldMobileNumber.setBounds(200, 230, 100, 20);
		this.panel.add(this.textfieldMobileNumber);
		
		this.labelEmail = new JLabel("Email : ");
		this.labelEmail.setBounds(100, 260, 100, 20);
		this.panel.add(this.labelEmail);
		
		this.textfieldEmail = new JTextField();
		this.textfieldEmail.setBounds(200, 260, 100, 20);
		this.panel.add(this.textfieldEmail);
		
		this.labelNationalID = new JLabel("National ID : ");
		this.labelNationalID.setBounds(100, 290, 100, 20);
		this.panel.add(this.labelNationalID);
		
		this.textfieldNationalID = new JTextField();
		this.textfieldNationalID.setBounds(200, 290, 100, 20);
		this.panel.add(this.textfieldNationalID);
		
		this.labelPassportNumber = new JLabel("Passport No : ");
		this.labelPassportNumber.setBounds(100, 320, 100, 20);
		this.panel.add(this.labelPassportNumber);
		
		this.textfieldPassportNumber= new JTextField();
		this.textfieldPassportNumber.setBounds(200, 320, 100, 20);
		this.panel.add(this.textfieldPassportNumber);
		
		this.labelNumberOfAdults = new JLabel("Number Of Adults : ");
		this.labelNumberOfAdults.setBounds(100, 350, 150, 20);
		this.panel.add(this.labelNumberOfAdults);
		
		String[] person = {"0","1","2","3","4","5","6","7","8","9","10"};
		
		this.comboboxAdults = new JComboBox(person);
		this.comboboxAdults.setBounds(250, 350, 50, 20);
		this.panel.add(this.comboboxAdults);
		
		this.labelNumberOfChildrens = new JLabel("Number Of Childrens : ");
		this.labelNumberOfChildrens.setBounds(100, 380, 150, 20);
		this.panel.add(this.labelNumberOfChildrens);
		
		this.comboboxChildrens = new JComboBox(person);
		this.comboboxChildrens.setBounds(250, 380, 50, 20);
		this.panel.add(this.comboboxChildrens);
		
		this.buttonClose = new JButton("Close");
		this.buttonClose.setBounds(100, 450, 80, 20);
		this.panel.add(buttonClose);
		buttonClose.addActionListener(this);

		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(400, 450, 80, 20);
		this.panel.add(buttonSave);
		buttonSave.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 600);
		this.setTitle("Update Customar Info");
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
			int ID = Integer.parseInt((String) this.comboboxCustomarID.getSelectedItem());
			String FirstName = this.textfieldFirstName.getText(); 
			String LastName = this.textfieldLastName.getText();
			String Email = this.textfieldEmail.getText();
			int MobileNumber = Integer.parseInt((String)this.textfieldMobileNumber.getText());
			
			String Gender = null;
			if(radioMale.isSelected()== true)
			{
				Gender = "Male";
			}
			else if(radioFemale.isSelected()== true)
			{
				Gender = "Female";
			}
			
			String MaritorialStatus = "Un-Married";
			if(checkboxMarried.isSelected()== true)
			{
				MaritorialStatus = "Married";
			}
			
			String NationalID = this.textfieldNationalID.getText();
			String Address = this.textfieldAddress.getText();
			String PassportNumber = this.textfieldPassportNumber.getText();
			int NumberOfAdults = Integer.parseInt((String) this.comboboxAdults.getSelectedItem());
			int NumberOfChildrens = Integer.parseInt((String) this.comboboxChildrens.getSelectedItem());
			
				
			
			CustomarData customarData = new CustomarData();
			customarData.setCustomarID(ID);
			customarData.setFirstName(FirstName);
			customarData.setLastName(LastName);
			customarData.setAddress(Address);
			customarData.setEmail(Email);
			customarData.setGender(Gender);
			customarData.setMaritorialStatus(MaritorialStatus);
			customarData.setMobileNumber(MobileNumber);
			customarData.setNationalID(NationalID);
			customarData.setNumberOfAdults(NumberOfAdults);
			customarData.setNumberOfChildrens(NumberOfChildrens);
			customarData.setPassportNumber(PassportNumber);
			
			if(data.UpdateCustomar(customarData) == true)
			{
			
				JOptionPane.showMessageDialog(null, "Update Successfully!");
				CustomarRegistration customar = new CustomarRegistration();
				customar.setVisible(true);
				this.setVisible(false);
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
		if(ie.getItemSelectable() == this.comboboxCustomarID)
		{
			Object item = ie.getItem();
			int i = Integer.parseInt(item.toString());
			this.info = data.getCustomarinfo(i);
			textfieldFirstName.setText(info[0]);
			textfieldLastName.setText(info[1]);
			textfieldAddress.setText(info[4]);
			textfieldMobileNumber.setText(info[5]);
			textfieldEmail.setText(info[6]);
			textfieldNationalID.setText(info[7]);
			textfieldPassportNumber.setText(info[8]);
			

		}
	}

}
