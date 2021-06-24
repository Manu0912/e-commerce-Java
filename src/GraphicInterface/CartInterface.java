package GraphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Files.CatalogueUtiles;
import Files.UserUtiles;
import List.Catalogue;
import Products.Products;
import types_users.Client;
import types_users.Users;

public class CartInterface extends JFrame implements ActionListener{

	private JPanel panelInfo, panelBuy;
	private JButton btnBuy, btnCancel, btnBack, btnRemove;
	private JLabel labelTxt, labelTotal;
	private JTextArea txtArea;
	private Client client;
	 
	
	private Color panelColor = new Color(100, 170, 255);
	private final static int width = 1000;
	private final static int height = 600;
	
	public CartInterface(Users user)
	{
		
		this.setLayout(null);
		this.setTitle("Carrito");
		this.setSize(width, height);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// USER
		
		this.client = (Client) user;
		
		// PANELS
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(50, 70, 400, 400);
		panelInfo.setBackground(panelColor);
		this.add(panelInfo);	
		
		panelBuy = new JPanel();
		panelBuy.setLayout(null);
		panelBuy.setBounds(520, 70, 400, 400);
		panelBuy.setBackground(panelColor);
		this.add(panelBuy);	
		
		// LABEL
		
		labelTxt = new JLabel("Productos ("+ getQuantity() + "): ");
		labelTxt.setBounds(10, 10, 400, 30);
		labelTxt.setFont(new Font(null, 1, 20));
		panelInfo.add(labelTxt);
		
		labelTotal= new JLabel("Total del pedido: $" + getTotal());
		labelTotal.setBounds(10, 10, 400, 30);
		labelTotal.setFont(new Font(null, 1, 20));
		panelBuy.add(labelTotal);
		
		// TEXT AREA
		
		txtArea = new JTextArea(toStringP());
		txtArea.setBounds(10, 50, 380, 300);
		txtArea.setFont(new Font(null, 1, 16));
		txtArea.setBorder(null);
		txtArea.setFocusable(false);
		panelInfo.add(txtArea);
		
		// BUTTONS
		
		btnBuy = new JButton("Comprar");
		btnBuy.setBounds(30, 200, 150, 40);
		btnBuy.addActionListener(this);
		panelBuy.add(btnBuy);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(200, 200, 150, 40);
		btnCancel.addActionListener(this);
		panelBuy.add(btnCancel);
		
		btnBack = new JButton("Volver");
		btnBack.setBounds(30, 270, 150, 40);
		btnBack.addActionListener(this);
		panelBuy.add(btnBack);
		
		btnRemove = new JButton("Remover");
		btnRemove.setBounds(200, 270, 150, 40);
		btnRemove.addActionListener(this);
		panelBuy.add(btnRemove);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnBack)
		{
			Principal p = new Principal(client);
			this.setVisible(false);
		}
		else if(e.getSource() == btnRemove)
		{
			String productName = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto a remover: ");
			remove(productName);
			this.setVisible(false);
			new CartInterface(client);
		}
		else if(e.getSource() == btnCancel)
		{
			cancel();
			this.setVisible(false);
			new CartInterface(client);
		}
		else
		{
			String message = buy();
			JOptionPane.showMessageDialog(this, message);
			this.setVisible(false);
			new CartInterface(client);
		}
	}
	
	public int getQuantity()
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		int quantity = 0;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				quantity = client.getCart().getQuantity().size();
			}
		}
		
		return quantity;
	}
	
	public float getTotal()
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		float total = 0;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				total = client.getCart().getTotal();
			}
		}
		
		return total;
	}
	
	public String toStringP()
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		String s = "";
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				s = client.getCart().toString();
			}
		}
		
		return s;
	}
	
	public void remove(String productName)
	{
		Catalogue catalogue = CatalogueUtiles.read();
		Products p = catalogue.getElementByName(productName);
		
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				client.getCart().remove(p);
				UserUtiles.write(client);
			}
		}
	}
	
	public void cancel()
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				client.getCart().remove();
				UserUtiles.write(client);
			}
		}
	}
	
	public String buy()
	{		
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		Client client;
		String buy = "";
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			if(entry.getKey() == this.client.getId())
			{
				client = (Client) entry.getValue();
				buy = client.buy();
				UserUtiles.write(client);
			}
		}
		
		return buy;
	}
}

















