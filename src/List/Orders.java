package List;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Orders<T> {
	private TreeMap<Integer, T> orders;

	public Orders() {
		orders = new TreeMap<Integer, T>();
	}

	/**
	 * @param id of type Integer,date of type T 
	 * @apiNote add the object T to the orders
	 */
	public void addOrders(Integer id, T date) {
		orders.put(id, date);
	}
	// GETTERS
	
	/**
	 * @param product of type Integer,namProduct of type String 
	 * @apiNote checks if an object in the treeMap matches the id and the nameProduct
	 * @return object of type T,if it does not find null
	 */
	public T getProduct(Integer id, String namProduct) {
		T object = null;
		boolean check = false;
		Iterator<Entry<Integer, T>> it = orders.entrySet().iterator();
		while (it.hasNext() && check) {
			Entry<Integer, T> entry = it.next();
			if (id == entry.getKey() && namProduct == entry.getClass().getName()) {
				object=entry.getValue();
			}
		}
		return object;
	}
	
	// METHODS
	/**
	 * 
	 * @param id of type Integer
	 * @apiNote converts the Orders object to a string
	 * @return String,if it does not find null
	 */
	public String toString(Integer id) {
		StringBuilder string = new StringBuilder();
		Iterator<Entry<Integer, T>> it = orders.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, T> entry = it.next();
			if (id == entry.getKey()) {
				string.append(entry.getValue());
			}
		}
		return string.toString();
	}
	
	/**
	 * @param id of type Integer,namProduct of type String
	 * @apiNote remove a specific product
	 * @return if variable check is true,the product was removed,otherwise a false finds it
	 */
	public boolean removeOrder(Integer id, String namProduct) {
		boolean check = false;
		Iterator<Entry<Integer, T>> it = orders.entrySet().iterator();
		while (it.hasNext() && check) {
			Entry<Integer, T> entry = it.next();
			if (id == entry.getKey() && namProduct == entry.getClass().getName()) {
				it.remove();
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * @param id of type Integer,namProduct of type String
	 * @apiNote remove all the specific product
	 * @return if variable check is true,the products were removed,otherwise a false finds it
	 */
	
	public boolean removeAllOrder(Integer id, String namProduct) {
		boolean check = false;
		Iterator<Entry<Integer, T>> it = orders.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, T> entry = it.next();
			if (id == entry.getKey()) {
				it.remove();
			}
		}
		return check;
	}

}
