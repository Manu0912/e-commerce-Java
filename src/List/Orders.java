package List;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Orders<T> {
	private TreeMap<Integer, T> orders;

	public Orders() {
		orders = new TreeMap<Integer, T>();
	}

	public void addOrders(Integer id, T date) {
		orders.put(id, date);
	}

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

	public boolean removeOrders(Integer id, String namProduct) {
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

	public boolean removeAllOrders(Integer id, String namProduct) {
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

	public T getOrders(Integer id, String namProduct) {
		T object = null;
		boolean check = false;
		Iterator<Entry<Integer, T>> it = orders.entrySet().iterator();
		while (it.hasNext() && check) {
			Entry<Integer, T> entry = it.next();
			if (id == entry.getKey() && namProduct == entry.getClass().getName()) {
				it.remove();
			}
		}
		return object;
	}
}
