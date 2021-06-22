package List;

import java.util.ArrayList;

import Products.Products;

public class Catalogue {
	private ArrayList<Products> catalogue;

	public Catalogue() {
		catalogue = new ArrayList<Products>();
	}

	/**
	 * 
	 * @param product of type Products
	 * @return the index if the product exist or -1 if not
	 */
	public int existProduct(Products product) {
		int pos = -1;

		for (int i = 0; i < catalogue.size(); i++) {
			if (catalogue.get(i).getName().equals(product.getName())) {
				pos = i;
			}
		}

		return pos;
	}

	/**
	 * @apiNote add the product to the catalogue
	 * @param product
	 */
	public void add(Products product) {
		int pos = existProduct(product);

		if (pos == -1) {
			catalogue.add(product);
		} else {
			catalogue.add(pos, product);
		}
	}

	/**
	 * @apiNote remove the product from the catalogue
	 * @param product
	 */
	public void remove(Products product) {
		int pos = existProduct(product);

		if (pos != -1) {
			catalogue.remove(pos);

		}
	}

	/**
	 * 
	 * @param index of the product
	 * @return the product in the index i
	 */
	public Products getElement(int i) {
		return catalogue.get(i);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < catalogue.size(); i++) {
			builder.append(catalogue.get(i).toString() + "\n");
		}

		return builder.toString();
	}

	/**
	 * 
	 * @return the size of the catalogue
	 */
	public int count() {
		return catalogue.size();
	}

	/**
	 * 
	 * @param name of the product
	 * @return the product found
	 */
	public Products getElementByName(String name) {
		Products p = null;

		for (int i = 0; i < catalogue.size(); i++) {
			if (catalogue.get(i).getName().equals(name)) {
				p = catalogue.get(i);
			}
		}

		return p;
	}

}
