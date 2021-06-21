package GraphicInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Files.UserUtiles;
import libreria.TextPrompt;
import types_users.Client;
import types_users.Users;

public class SignUp extends JFrame implements ActionListener{

	private JTextField txtUserName, txtName_lastName, txtMail, txtCity, txtAddress;
	private JPasswordField txtPassword;
	private JButton btnSignin ,btnBack;
	private TextPrompt phUserName, phName_lastName, phPassword, phMail, phCity, phAddress;
	
	private final static int width = 600;
	private final static int height = 600;
	
	public SignUp()
	{
		this.setLayout(null);
		this.setTitle("Sign up");
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TXT
		
		txtUserName = new JTextField();
		txtUserName.setBounds(80, 105, 185, 30);
		phUserName = new TextPrompt("Ingrese su nombre de usuario", txtUserName);
		this.add(txtUserName);
		
		txtName_lastName = new JTextField();
		txtName_lastName.setBounds(300, 105, 185, 30);
		phName_lastName = new TextPrompt("Ingrese su nombre y apellido", txtName_lastName);
		this.add(txtName_lastName);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(80, 155, 185, 30);
		phPassword = new TextPrompt("Ingrese una contraseña", txtPassword);
		this.add(txtPassword);
		
		txtMail = new JTextField();
		txtMail.setBounds(300, 155, 185, 30);
		phMail = new TextPrompt("Ingrese su mail", txtMail);
		this.add(txtMail);
		
		txtCity = new JTextField();
		txtCity.setBounds(80, 205, 185, 30);
		phCity = new TextPrompt("Ingrese su ciudad", txtCity);
		this.add(txtCity);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(300, 205, 185, 30);
		phAddress = new TextPrompt("Ingrese su direccion", txtAddress);
		this.add(txtAddress);
		
		// BTN
		
		btnBack = new JButton("Volver");
		btnBack.setBounds(120, 255, 120, 30);
		btnBack.addActionListener(this);
		this.add(btnBack);
		
		
		btnSignin = new JButton("Sign in");
		btnSignin.setBounds(300, 255, 120, 30);
		btnSignin.addActionListener(this);
		this.add(btnSignin);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnBack)
		{
			LogIn inicio = new LogIn();
			this.setVisible(false);
		}
		else if(e.getSource() == btnSignin)
		{
			if(validNewUser())
			{
				// creamos un cliente con los datos
				Users client = new Client(txtUserName.getText(), txtName_lastName.getText(), txtPassword.getText(), txtMail.getText(), txtCity.getText(), txtAddress.getText());
				
				// guardamos el cliente en el archivo
				UserUtiles.write(client);
				
				// entramos al ecommerce
				Principal principal = new Principal(client);
				this.setVisible(false);
			}
				
		}
	}
	
	
	public boolean validNewUser()
	{
		boolean valid = false;

		String name = txtUserName.getText();
		String lastName = txtName_lastName.getText();
		String password = txtPassword.getText();
		String mail = txtMail.getText();
		String city = txtCity.getText();
		String address = txtAddress.getText();
		
		if(!name.isBlank() && !lastName.isBlank() && !password.isBlank() && !mail.isBlank() && !city.isBlank() && !address.isBlank())
		{	
			if(validName(name))
			{
				if(validMail(mail))
				{
					valid = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El mail ya esta registrado o mal redactado, porfavor inicie sesion o ingrese otro!");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "El nombre de usuario ya esta registrado, porfavor inicie sesion o ingrese otro!");
			}
		}
		
		return valid;
	}
	
	public boolean validMail(String mail)
	{
		boolean valid = false;
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		if(!hashMap.isEmpty())
		{
			if(!mail.isBlank() && mail.contains("@") && mail.contains(".com")) 
			{
				while(it.hasNext())
				{
					Entry<Integer, Users> entry = it.next();
					if(!entry.getValue().getEmail().equals(mail))
					{
						valid = true;
					}
					else
					{
						valid = false;
					}
				}
			}
		}
		else
		{
			valid = true;
		}
			
		return valid;		
	}
	
	public boolean validName(String name)
	{
		boolean valid = false;
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		if(!hashMap.isEmpty())
		{
			if(!name.isBlank())
			{
				while(it.hasNext())
				{
					Entry<Integer, Users> entry = it.next();
					if(!entry.getValue().getName().equals(name))
					{
						valid = true;
					}
					else
					{
						valid = false;
					}
				}
			}
		}
		else
		{
			valid = true;
		}

			
		return valid;
	}
	
}















