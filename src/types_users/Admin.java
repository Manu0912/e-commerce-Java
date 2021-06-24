package types_users;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Files.CatalogueUtiles;
import Files.UserUtiles;
import List.Catalogue;
import List.Orders;
import Order.Order;
import Products.Products;

public class Admin extends Users {

    public Admin() {

    }

    public Admin(String name, String lastName, String password, String email) {
        super(name, lastName, password, email);
    }

    /**
     * @param order  of type Order
     * @param state  of type String
     * @param orders of type Orders
     * @param ul     of type UserList
     * @apiNote change product state
     */
    // cambiar estado del pedido
    public void changeOrderState(String email, String state) {
        HashMap<Integer, Users> hashMap = UserUtiles.read();
        Client client = null;

        Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Users> entry = it.next();
            if (entry.getValue().getEmail().equals(email)) {
                client = (Client) entry.getValue();
            }
        }

        Orders orders = client.getOrders();
        Order order = orders.getOrderState();

        orders.modifyOrderState(order.getId().toString(), state);
        client.setOrders(orders);
        System.out.println(client.getOrders().toString());
        UserUtiles.write(client);
    }

    /**
     * @param product of type Products
     * @apiNote delete product
     */
    // borrar producto

    public void deleteProduct(String name) {

        Catalogue catalogue = CatalogueUtiles.read();
        Products product = catalogue.getElementByName(name);
        catalogue.remove(product);
        CatalogueUtiles.write(catalogue);
    }

    /**
     * @param product of type Products
     * @apiNote delete product
     */
    // agregar producto

    public void addProduct(Products product) {
        CatalogueUtiles.write(product);
    }

}
