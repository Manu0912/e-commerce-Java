package main;

import List.Catalogue;
import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;
public class Main {

	public static void main(String[] args) {		
		Catalogue<Products> catalogue = new Catalogue<Products>();
		Products e = new HomeAppliances(1, "Cafetera", 20000, 80, 50, 20, 20);
		Products v = new Vehicle(2, "Ford", 800000, 10, "Auto", true, 0);
		Products i = new Estate(3, "Casa", 150000, 1, 4, true, "Mar del Plata");
		Products c = new Clothing(4, "Remera", 1200, 40, 'M', "Verde", "Addidas");
		
		catalogue.add(e);
		catalogue.add(v);
		catalogue.add(i);
		catalogue.add(c);
		
		catalogue.write();
		
		Catalogue<Products> c2 =  new Catalogue<Products>();
		c2 = catalogue.read();
		
		System.out.println(c2.getElement(0));
	}
}
