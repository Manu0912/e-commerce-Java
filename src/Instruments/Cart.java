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
	public int sizeInteger() {
		return quantity.size();
	}

	public int sizeProducts() {
		return products.size();
	}

	public int sizeIntegerPos(int pos) {
		int retu = -1;
		if (quantity.size() > pos) {
			retu = quantity.get(pos);
		}
		return retu;
	}

	public int sizeProductsPos(int pos) {
		int retu = -1;
		if (products.size() > pos) {
			products.get(pos);
		}
		return retu;
	}
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
				total += (float) (products.get(i).getPrice() * quantity.get(i));
				System.out.println(products.get(i).getName() + "*" + quantity.get(i));
			}
			System.out.println(total);
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
		this.total = calculateSubTotal() / 2;
		boolean flag = true;
		ArrayList<Float> totales = new ArrayList<Float>();
		System.out.println(total);
		if (quantity.size() == products.size()) {
			for(int j = 0; j < products.size(); j++){
				double totalProducts = products.get(j).getPrice() * quantity.get(j);
				Float totalDiscount = (float) products.get(j).generateDiscountQuantity(totalProducts, quantity.get(j));
				totales.add(totalDiscount);
                if(products.get(j).getStock() < quantity.get(j)){
                    flag = false;
                }
            }

            if(flag == true){
            	for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getStock() >= quantity.get(i)) {
                        products.get(i).substractStock(quantity.get(i));
                        catalogue.remove(products.get(i));
                        catalogue.add(products.get(i));
                        if (products.get(i).getStock() == 0) {
                            catalogue.remove(products.get(i));
                        }
                        
                        CatalogueUtiles.write(catalogue);
                    }
                }
                remove();
            }       
        }
		
		total = 0;
		for(int i = 0; i < totales.size(); i++)
		{
			total += totales.get(i);
		}

		return this.total;
	}
}
