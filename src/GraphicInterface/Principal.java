package GraphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Files.CatalogueUtiles;
import Files.UserUtiles;
import List.Catalogue;
import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;
import types_users.Admin;
import types_users.Client;
import types_users.Users;


public class Principal extends JFrame implements ActionListener{

	private JButton btnTodos, btnE, btnI, btnV, btnR, btnC, btnP, btnCarrito;
	private JPanel panelBtn, panelProdcutos;
	private JScrollPane scrolPane;
	private ArrayList<JPanel> arrayPanel;
	private Products product;
	private Users user;
	
	private Color btnColor = new Color(233, 233, 233);
	private Color panelColor = new Color(100, 170, 255);
	private final static int width = 1000;
	private final static int height = 600;
	 
	public Principal(Users user)
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
		
		panelBtn = new JPanel();
		panelBtn.setLayout(null);
		panelBtn.setBounds(0, 5, width, 60);
		panelBtn.setBackground(panelColor);
		this.add(panelBtn);
		
		panelProdcutos = new JPanel();
		panelProdcutos.setLayout(null);
		panelProdcutos.setBounds(0, 75, width, height);
		panelProdcutos.setBackground(panelColor);
		panelProdcutos.setPreferredSize(new Dimension(width, 800));
		this.add(panelProdcutos);
		
		scrolPane = new JScrollPane(panelProdcutos);
		scrolPane.setBounds(0,75, width - 20, 600);
		scrolPane.setVisible(true);
		this.add(scrolPane);
				
		// BTN
		
		btnTodos = new JButton("Todos");
		btnTodos.setBounds(10, 13, 80, 30);
		btnTodos.setBackground(btnColor);
		btnTodos.addActionListener(this);
		panelBtn.add(btnTodos);
		
		btnE = new JButton("Electrodomesticos");
		btnE.setBounds(100, 13, 140, 30);
		btnE.setBackground(btnColor);
		btnE.addActionListener(this);
		panelBtn.add(btnE);
		
		btnI = new JButton("Inmuebles");
		btnI.setBounds(250, 13, 95, 30);
		btnI.setBackground(btnColor);
		btnI.addActionListener(this);
		panelBtn.add(btnI);
		
		btnV = new JButton("Vehiculos");
		btnV.setBounds(355, 13, 90, 30);
		btnV.setBackground(btnColor);
		btnV.addActionListener(this);
		panelBtn.add(btnV);
		
		btnR = new JButton("Ropa");
		btnR.setBounds(465, 13, 80, 30);
		btnR.setBackground(btnColor);
		btnR.addActionListener(this);
		panelBtn.add(btnR);
		
		btnC = new JButton("Carrito");
		btnC.setBounds(695, 13, 80, 30);
		btnC.setBackground(btnColor);
		btnC.addActionListener(this);
		panelBtn.add(btnC);
		
		btnP = new JButton("Mi Perfil");
		btnP.setBounds(800, 13, 100, 30);
		btnP.setBackground(btnColor);
		btnP.addActionListener(this);
		panelBtn.add(btnP);
		
		
		arrayPanel = mostrarProductos();
		setBounds(arrayPanel);
		
	}
	
	
		
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnTodos)
		{
			ocultar(arrayPanel);
			
			arrayPanel = mostrarProductos();
			setBounds(arrayPanel);
		}
		else if(e.getSource() == btnE)
		{	
			ocultar(arrayPanel);
						
			arrayPanel = mostrarE();
			setBounds(arrayPanel);
		}
		else if(e.getSource() == btnI)
		{	
			ocultar(arrayPanel);
			
			arrayPanel = mostrarI();
			setBounds(arrayPanel);
		}
		else if(e.getSource() == btnV)
		{	
			ocultar(arrayPanel);

			arrayPanel = mostrarV();
			setBounds(arrayPanel);
		}
		else if(e.getSource() == btnR)
		{	
			ocultar(arrayPanel);
			
			arrayPanel = mostrarR();
			setBounds(arrayPanel);
		}
		else if(e.getSource() == btnP)
		{
			Perfil perfil = new Perfil(user);
			this.setVisible(false);
		}
		else if(e.getSource() == btnC)
		{
			if(user instanceof Client)
			{
				CartInterface cart = new CartInterface(user);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No tienes acceso al carrito porque eres Admin!");
			}
		}
		else 
		{
			addToCart(e);
		}
	}
	
	
	
	// METODOS
	
	public ArrayList<JPanel> mostrarProductos()
	{
		ArrayList<JPanel> arrayPanel = new ArrayList<JPanel>();
		Catalogue catalogue = CatalogueUtiles.read();
		
		for(int i = 0; i < catalogue.count(); i++)
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.white);
			panelProdcutos.add(panel);
			
			this.product = catalogue.getElement(i);
			
			JTextArea txt = new JTextArea(product.toString());
			txt.setBounds(0,0,200,150);
			txt.setBorder(null);
			txt.setFocusable(false);
			panel.add(txt);
			
			JButton btnCarrito = new JButton("Agregar al carrito");
			btnCarrito.setBounds(20, 150, 150, 30);
			btnCarrito.addActionListener(this);
			panel.add(btnCarrito);
			
			arrayPanel.add(panel);
			
		}
		
		return arrayPanel;
	}
	
	public ArrayList<JPanel> mostrarE()
	{
		ArrayList<JPanel> arrayPanel = new ArrayList<JPanel>();
		Catalogue catalogue = CatalogueUtiles.read();
		for(int i = 0; i < catalogue.count(); i++)
		{
			if(catalogue.getElement(i) instanceof HomeAppliances)
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.white);
				panelProdcutos.add(panel);
				
				this.product = catalogue.getElement(i);
				
				JTextArea txt = new JTextArea(catalogue.getElement(i).toString());
				txt.setBounds(0,0,200,150);
				txt.setBorder(null);
				txt.setFocusable(false);
				panel.add(txt);
				
				JButton btnCarrito = new JButton("Agregar al carrito");
				btnCarrito.setBounds(20, 150, 150, 30);
				btnCarrito.addActionListener(this);
				panel.add(btnCarrito);
				
				arrayPanel.add(panel);
			}
			
		}
		
		return arrayPanel;
	}
	
	public ArrayList<JPanel> mostrarI()
	{
		ArrayList<JPanel> arrayPanel = new ArrayList<JPanel>();
		
		Catalogue catalogue = CatalogueUtiles.read();
		for(int i = 0; i < catalogue.count(); i++)
		{
			if(catalogue.getElement(i) instanceof Estate)
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.white);
				panelProdcutos.add(panel);
				
				this.product = catalogue.getElement(i);
				
				JTextArea txt = new JTextArea(catalogue.getElement(i).toString());
				txt.setBounds(0,0,200,150);
				txt.setBorder(null);
				txt.setFocusable(false);
				panel.add(txt);
				
				JButton btnCarrito = new JButton("Agregar al carrito");
				btnCarrito.setBounds(20, 150, 150, 30);
				btnCarrito.addActionListener(this);
				panel.add(btnCarrito);
				
				arrayPanel.add(panel);
			}
		}
		
		return arrayPanel;
	}
	
	public ArrayList<JPanel> mostrarV()
	{
		ArrayList<JPanel> arrayPanel = new ArrayList<JPanel>();
		
		Catalogue catalogue = CatalogueUtiles.read();
		for(int i = 0; i < catalogue.count(); i++)
		{
			if(catalogue.getElement(i) instanceof Vehicle)
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.white);
				panelProdcutos.add(panel);
				
				this.product = catalogue.getElement(i);
				
				JTextArea txt = new JTextArea(catalogue.getElement(i).toString());
				txt.setBounds(0,0,200,150);
				txt.setBorder(null);
				txt.setFocusable(false);
				panel.add(txt);
				
				JButton btnCarrito = new JButton("Agregar al carrito");
				btnCarrito.setBounds(20, 150, 150, 30);
				btnCarrito.addActionListener(this);
				panel.add(btnCarrito);
				
				arrayPanel.add(panel);
			}
		}
		
		return arrayPanel;
	}
	
	public ArrayList<JPanel> mostrarR()
	{
		ArrayList<JPanel> arrayPanel = new ArrayList<JPanel>();
		
		Catalogue catalogue = CatalogueUtiles.read();
		for(int i = 0; i < catalogue.count(); i++)
		{
			if(catalogue.getElement(i) instanceof Clothing)
			{
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBackground(Color.white);
				panelProdcutos.add(panel);
				
				this.product = catalogue.getElement(i);
				
				JTextArea txt = new JTextArea(catalogue.getElement(i).toString());
				txt.setBounds(0,0,200,150);
				txt.setBorder(null);
				txt.setFocusable(false);
				panel.add(txt);
				
				JButton btnCarrito = new JButton("Agregar al carrito");
				btnCarrito.setBounds(20, 150, 150, 30);
				btnCarrito.addActionListener(this);
				panel.add(btnCarrito);
				
				arrayPanel.add(panel);
			}
		}
		
		return arrayPanel;
	}
	
	public void setBounds(ArrayList<JPanel> arrayPanel)
	{
		try 
		{
			arrayPanel.get(0).setBounds(40,50,200,200);
			arrayPanel.get(1).setBounds(270,50,200,200);
			arrayPanel.get(2).setBounds(500,50,200,200);
			arrayPanel.get(3).setBounds(730,50,200,200);
			arrayPanel.get(4).setBounds(40,260,200,200);
			arrayPanel.get(5).setBounds(270,260,200,200);
			arrayPanel.get(6).setBounds(500,260,200,200);
			arrayPanel.get(7).setBounds(730,260,200,200);
			arrayPanel.get(8).setBounds(40,470,200,200);
			arrayPanel.get(9).setBounds(270,470,200,200);
			arrayPanel.get(10).setBounds(500,470,200,200);
			arrayPanel.get(11).setBounds(730,470,200,200);
		} 
		catch (Exception e) 
		{
		
		}
	}
	
	public void ocultar(ArrayList<JPanel> arrayPanel)
	{
		for(int i = 0; i < arrayPanel.size(); i++)
		{
			arrayPanel.get(i).setVisible(false);
		}
	}
	
	public void addToCart(ActionEvent e)
	{
		try 
		{
			if(user instanceof Client)
			{
				Catalogue catalogue = CatalogueUtiles.read();
				HashMap<Integer, Users> hashMap = UserUtiles.read();
				Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
				Client client;
				
				for(int i = 0; i < catalogue.count(); i++)
				{
					if(e.getSource() == arrayPanel.get(i).getComponent(1))
					{
						JTextArea jta = (JTextArea) arrayPanel.get(i).getComponent(0);
						
						while(it.hasNext())
						{
							Entry<Integer, Users> entry = it.next();
							if(entry.getKey() == user.getId())
							{
								client = (Client) entry.getValue();
								Products p = catalogue.getElementByName(getNameProdutc(jta.getText()));
								client.addToCart(p);
								UserUtiles.write(client);
							}
						}
					}
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "No puede usar esta funcion!");
			}
		
		}
		catch (IndexOutOfBoundsException iobe) 
		{

		}	
		catch (Exception ex) {

		}
	}

	public String getNameProdutc(String txtArea)
	{
		String name = "";
		int i = 0;
		while(txtArea.charAt(i) != ' ')
		{
			name += txtArea.charAt(i);
			i++;
		}
		
		return name;
	}
}



























