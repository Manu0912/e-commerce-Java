package List;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Order.Order;

public class Orders {
	List<Order> orders;

	public Orders() {
		orders = new ArrayList<Order>();
	}

	/**
	 * @param id of type Integer
	 * @apiNote remove an order
	 * @return if variable check is true,the order was removed, otherwise a false
	 *         finds it
	 */

	public boolean removeOrder(String id) {
		boolean check = false;

		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getId().toString() == id) {
				orders.remove(orders.get(i));
				check = true;
			}
		}

		return check;
	}

	/**
	 * @param order of type Order
	 * @apiNote add an order
	 */

	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * @param uuid of type UUID
	 * @apiNote get an order
	 * @return an order
	 */
	public Order getOrder(UUID uuid) {
		int i = 0;
		boolean check = false;
		Order gettedOrder = null;

		while (i < orders.size() && check == false) {
			if (orders.get(i).getId() == uuid) {
				gettedOrder = orders.get(i);
				check = true;
			}
		}

		return gettedOrder;
	}

	/**
	 * @param order of type Order
	 * @apiNote modify an order state
	 */
	public void modifyOrderState(String id, String state) {
		int i = 0;
		boolean check = false;

		while (i < orders.size() && check == false) {
			if (orders.get(i).getId().toString() == id) {
				orders.get(i).setState(state);
				check = true;
			}
		}
	}
}
