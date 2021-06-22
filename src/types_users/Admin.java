package types_users;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Files.CatalogueUtiles;
import Files.UserUtiles;
import List.Catalogue;
import List.Orders;
import List.UserList;
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
    public void changeOrderState(Order order, String state, Orders orders, UserList ul) {
        String email = order.getEmail();
        Client client = (Client) ul.getUserByEmail(email);
        orders.modifyOrderState(order.getId().toString(), state);

        client.setOrders(orders);
        UserUtiles.write(ul.getHashMap());
    }

    /**
     * @param originalProduct of type Products
     * @param newProduct      of type Product
     * @param catalogue       of type Catalogue
     * @apiNote modify product
     */
    // modificar producto

    public void modifyProduct(Products originalProduct, Products newProduct, Catalogue catalogue) {
        FileOutputStream fos;
        ObjectOutputStream ous;

        if (originalProduct.getId() == newProduct.getId()) {
            catalogue.remove(originalProduct);
            catalogue.add(newProduct);
        }

        CatalogueUtiles.write(catalogue);

    }

    /**
     * @param catalogue of type Catalogue
     * @param product   of type Products
     * @apiNote delete product
     */
    // borrar producto

    public void deleteProduct(Catalogue catalogue, Products product) {
        catalogue.remove(product);
        CatalogueUtiles.write(catalogue);
    }

    /**
     * @param catalogue of type Catalogue
     * @param product   of type Products
     * @apiNote delete product
     */
    // agregar producto

    public void addProduct(Catalogue catalogue, Products product) {
        catalogue.add(product);
        CatalogueUtiles.write(catalogue);
    }

}
