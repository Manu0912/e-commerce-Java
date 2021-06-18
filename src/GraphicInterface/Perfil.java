package GraphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import types_users.Client;
import types_users.Users;

public class Perfil extends JFrame implements ActionListener{

	private JPanel panelInfo, panelBtn;
	private Users user;
	private JButton btnBack, btnChangeA, btnChangeC, btnChangeM, btnChangeL, btnChangeP, btnAddCard;
	private JLabel lName, lLastName, lMail, lAddress, lCity, lCreditCard, lBalance; 
	
	private Color btnColor = new Color(233, 233, 233);
	private Color panelColor = new Color(100, 170, 255);
	private final static int width = 1000;
	private final static int height = 600;
	
	public Perfil(Users user)
	{
		
		this.setLayout(null);
		this.setTitle("Principal");
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// USER
		
		this.user = user;
		
		// PANELS
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(50, 70, 400, 400);
		panelInfo.setBackground(panelColor);
		this.add(panelInfo);	
		
		panelBtn = new JPanel();
		panelBtn.setLayout(null);
		panelBtn.setBounds(520, 70, 400, 400);
		panelBtn.setBackground(panelColor);
		this.add(panelBtn);	
		
		// LABELS
		
		lName = new JLabel("Nombre: " + user.getName());
		lName.setBounds(10, 10, 400, 30);
		lName.setFont(new Font(null, 1, 20));
		panelInfo.add(lName);
		
		lLastName = new JLabel("Apellido: " + user.getLastName());
		lLastName.setBounds(10, 50, 400, 30);
		lLastName.setFont(new Font(null, 1, 20));
		panelInfo.add(lLastName);
		
		lMail = new JLabel("Email: " + user.getEmail());
		lMail.setBounds(10, 90, 400, 30);
		lMail.setFont(new Font(null, 1, 20));
		panelInfo.add(lMail);
		
		if(user instanceof Client)
		{
			Client client = (Client) user;
					
			lCity = new JLabel("Ciudad: " + client.getCity());
			lCity.setBounds(10, 130, 400, 30);
			lCity.setFont(new Font(null, 1, 20));
			panelInfo.add(lCity);
			
			lAddress = new JLabel("Direccion: " + client.getAddress());
			lAddress.setBounds(10, 170, 400, 30);
			lAddress.setFont(new Font(null, 1, 20));
			panelInfo.add(lAddress);
			
			lCreditCard = new JLabel("Tarjeta: " + client.getCard().getNumber());
			lCreditCard.setBounds(10, 210, 400, 30);
			lCreditCard.setFont(new Font(null, 1, 20));
			panelInfo.add(lCreditCard);
			
			lBalance = new JLabel("Saldo: $" + client.getCard().getBalance());
			lBalance.setBounds(10, 250, 400, 30);
			lBalance.setFont(new Font(null, 1, 20));
			panelInfo.add(lBalance);
		}
		
		// BUTTONS
		
		btnChangeP = new JButton("Cambiar contraseña");
		btnChangeP.setBounds(30, 50, 150, 40);
		btnChangeP.addActionListener(this);
		panelBtn.add(btnChangeP);
		
		btnChangeL = new JButton("Cambiar apellido");
		btnChangeL.setBounds(200, 50, 150, 40);
		btnChangeL.addActionListener(this);
		panelBtn.add(btnChangeL);
		
		btnChangeM = new JButton("Cambiar email");
		btnChangeM.setBounds(30, 120, 150, 40);
		btnChangeM.addActionListener(this);
		panelBtn.add(btnChangeM);
		
		btnChangeC = new JButton("Cambiar ciudad");
		btnChangeC.setBounds(200, 120, 150, 40);
		btnChangeC.addActionListener(this);
		panelBtn.add(btnChangeC);
		
		btnChangeA = new JButton("Cambiar direccion");
		btnChangeA.setBounds(30, 190, 150, 40);
		btnChangeA.addActionListener(this);
		panelBtn.add(btnChangeA);
		
		btnAddCard = new JButton("Agregar tarjeta");
		btnAddCard.setBounds(200, 190, 150, 40);
		btnAddCard.addActionListener(this);
		panelBtn.add(btnAddCard);
		
		btnBack = new JButton("Volver");
		btnBack.setBounds(115, 280, 150, 35);
		btnBack.addActionListener(this);
		panelBtn.add(btnBack);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnBack)
		{
			Principal principal = new Principal(user);
			this.setVisible(false);
		}
	}

}






















