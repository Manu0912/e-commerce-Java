package Files;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import List.Catalogue;
import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;

public class CatalogueUtiles {

	private final static String file_products = "products.dat";
	/**
     * @param catalogue of type Catalogue
     * @apiNote open the file, and copy a catalog object from it.
     */
	public static void write(Catalogue catalogue) {
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file_products);
			oos = new ObjectOutputStream(fos);

			for (int i = 0; i < catalogue.count(); i++) {
				oos.writeObject(catalogue.getElement(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
     * @param product of type Products
     * @apiNote open the file, and copy a Products object from it.
     */
	public static void write(Products product) {
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		Catalogue catalogue = CatalogueUtiles.read();
		catalogue.add(product);

		try {
			fos = new FileOutputStream(file_products);
			oos = new ObjectOutputStream(fos);

			for (int i = 0; i < catalogue.count(); i++) {
				oos.writeObject(catalogue.getElement(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
     * @param product of type Products
     * @apiNote open the file, and read a catalog object from it.
     * @return returns a catalog object
     */
	public static Catalogue read() {
		ObjectInputStream ois = null;
		Catalogue catalogue = new Catalogue();
		try {
			ois = new ObjectInputStream(new FileInputStream(file_products));
			Products product = null;

			while ((product = (Products) ois.readObject()) != null) {
				catalogue.add(product);
			}
		} catch (EOFException e) {
			System.out.println("Fin del archivo");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return catalogue;
	}

	
}
