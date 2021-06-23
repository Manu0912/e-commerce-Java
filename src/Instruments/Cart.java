package Instruments;

import java.io.Serializable;
import java.util.ArrayList;

import Files.CatalogueUtiles;
import List.Catalogue;
import Products.Products;

public class Cart implements Serializable {
	private ArrayList<Integer> quantity;
	private float total;
	private ArrayList<Products> products;

	public Cart() {
		quantity = new ArrayList<Integer>();
		total = 0;
		products = new ArrayList<Products>();
	}

	// GETTERS

	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	public float getTotal() {
		return calculateSubTotal();
	}

	public ArrayList<Products> getProducts() {
		return products;
	}

	// SETTERS

	public void setTotal(float total) {
		this.total = total;
	}

	// METHODS

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getName();
			int quant = quantity.get(i);
			float price = (float) (products.get(i).getPrice() * quantity.get(i));
			builder.append(name + "(" + quant + ") = $" + price + "\n");
		}

		return builder.toString();
	}

	/**
	 * 
	 * @param product
	 * @return -1 if no exist /or the index of the product
	 */
	public int existProduct(Products p) {
		int pos = -1;

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == p.getId()) {
				pos = i;
			}
		}

		return pos;
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 * @apiNote If the product exist, just sum the quantity. If it doesn't exist,
	 *          add the product and the quantity
	 */
	public void add(Products product) {
		int posProduct = existProduct(product);
		if (posProduct == -1) {
			this.products.add(product);
			this.quantity.add(1);
		} else {
			this.quantity.set(posProduct, this.quantity.get(posProduct) + 1);
		}
	}

	/**
	 * 
	 * @param product
	 * @apiNote If quantity is greater than 1, quantity -= 1. Else, it is removed.
	 */
	public void remove(Products product) {
		int posProduct = existProduct(product);

		if (posProduct != -1) {
			if (this.quantity.get(posProduct) > 1) {
				this.quantity.set(posProduct, this.quantity.get(posProduct) - 1);
			} else {
				this.quantity.remove(posProduct);
				this.products.remove(posProduct);
			}
		}
	}

	public void remove() {
		while (!quantity.isEmpty() && !products.isEmpty()) {
			int i = 0;
			this.quantity.remove(i);
			this.products.remove(i);
			i++;
		}
	}

	/**
	 * 
	 * @return The sum of price of all products or -1 if there is an error
	 */
	public float calculateSubTotal() {

		if (quantity.size() == products.size()) {
			for (int i = 0; i < products.size(); i++) {
				total += products.get(i).getPrice() * quantity.get(i);
			}
		} else {
			total = -1;
		}

		return total;
	}

	/**
	 * @apiNote subtract the quantity from stock and remove the product
	 * @return The final price
	 */
	public float buy() {
		Catalogue catalogue = CatalogueUtiles.read();
		this.total = calculateSubTotal(); // falta agregar descuentos, si es que los hay.

		if (quantity.size() == products.size()) {
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getStock() > quantity.get(i)) {
					catalogue.remove(products.get(i));
					products.get(i).substractStock(quantity.get(i));
					catalogue.add(products.get(i));
					CatalogueUtiles.write(catalogue);
					remove();
				}
			}
		}

		return this.total;
	}
}
