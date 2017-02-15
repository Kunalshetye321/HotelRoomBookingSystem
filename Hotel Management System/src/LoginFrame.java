import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labelUsername, labelPassword;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonLogin, buttonCancel;
	
	public LoginFrame() 
	{
		this.InitializeComponents();
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.labelUsername = new JLabel("USERNAME");
		this.labelUsername.setBounds(220, 80, 80, 20);
		this.panel.add(this.labelUsername);
		
		this.textUsername = new JTextField();
		this.textUsername.setBounds(300, 80, 120, 20);
		this.panel.add(this.textUsername);
		
		this.labelPassword = new JLabel("PASSWORD");
		this.labelPassword.setBounds(220, 120, 120, 20);
		this.panel.add(this.labelPassword);
		
		this.textPassword = new JPasswordField();
		this.textPassword.setBounds(300, 120, 120, 20);
		this.panel.add(this.textPassword);
		
		this.buttonCancel = new JButton("Close");
		this.buttonCancel.setBounds(220, 180, 120, 30);
		this.panel.add(this.buttonCancel);
		buttonCancel.addActionListener(this);
		
		this.buttonLogin = new JButton("Login");
		this.buttonLogin.setBounds(420, 180, 120, 30);
		this.panel.add(this.buttonLogin);
		buttonLogin.addActionListener(this);
		
		this.add(this.panel);
		this.setSize(600, 400);
		this.setTitle("ADMIN LOGIN");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getActionCommand() == "Close")
		{
			System.exit(0);
		}
		else if(ae.getActionCommand() == "Login")
		{
			String username = textUsername.getText();
			String password = textPassword.getText();
			DataAccess data = new DataAccess();
			if(data.isUserValid(username, password) == true)
			{
				AdminPanel adminpanel = new AdminPanel();
				adminpanel.setVisible(true);
				this.setVisible(false);
		    }
			else 
			{
				JOptionPane.showMessageDialog(null, "Please enter correct login data!");
			}
			
		}
		
	}

}
