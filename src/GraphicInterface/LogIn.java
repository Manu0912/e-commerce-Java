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

import Exceptions.LoginException;
import Files.UserUtiles;
import libreria.TextPrompt;
import types_users.Users;

public class LogIn extends JFrame implements ActionListener{

	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton buttonLogin, buttonSignup;
	private TextPrompt phUser, phPassword;
	private Users user;
	
	private final static int width = 600;
	private final static int height = 600;
	
	public LogIn() 
	{
		this.setLayout(null);
		this.setTitle("Inicio");
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TXT
		txtUser = new JTextField();
		txtUser.setBounds(180, 160, 185, 30);
		phUser = new TextPrompt("Ingrese su usario", txtUser);
		this.add(txtUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 210, 185, 30);
		phPassword = new TextPrompt("Ingrese su contraseņa", txtPassword);
		this.add(txtPassword);
		
		// BUTTONS
		
		buttonLogin = new JButton("Log in");
		buttonLogin.setBounds(180, 260, 80, 30);
		buttonLogin.setVisible(true);
		buttonLogin.addActionListener(this);
		this.add(buttonLogin);
		
		buttonSignup = new JButton("Sign up");
		buttonSignup.setBounds(285, 260, 80, 30);
		buttonSignup.setVisible(true);
		buttonSignup.addActionListener(this);
		this.add(buttonSignup);
	}
	
	
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == buttonSignup)
		{
			SignUp signup = new SignUp();
			this.setVisible(false);
		}
		else if(e.getSource() == buttonLogin)
		{
			try {
				if(validateUser())
				{
					Principal principal = new Principal(user);
					this.setVisible(false);
				}
			} catch (LoginException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}

		}
	}
	
	public boolean validateUser() throws LoginException
	{
		boolean valid = false;
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getValue().getName().equals(txtUser.getText()) && entry.getValue().getPassword().equals(txtPassword.getText()))
			{
				user = entry.getValue();
				valid = true;
			}
		}
		
		if(valid == false)
		{
			throw new LoginException("Usuario o contraseņa incorrecta!");
		}
		
		return valid;
	}

}
















