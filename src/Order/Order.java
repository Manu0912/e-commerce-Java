package Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;
import Instruments.Cart;
import Products.Products;

public class Order implements Serializable{
    private TreeMap<Integer, Products> order;
    private UUID id;
    private String buyDate;
    private String state;
    private double total;
    // Email de la persona que hizo la orden
    private String email;

    public Order() {
        // hashmap donde Products es el producto e int es cuanto pidio del producto en
        // la orden
        // ej: 3 papas lays, 2 hamburguesas
        order = (TreeMap<Integer, Products>) new TreeMap<Integer, Products>();
        id = UUID.randomUUID();
        buyDate = new Date().toString();
        state = "Orden recien recibida";
        total = 0;
        email = "";
    }

    // METODS

    /**
     * @param namProduct of type String
     * @apiNote checks if an object in the treeMap matches the id and the
     *          nameProduct
     * @return object of type Products,if it does not find null
     */
    public Products getProduct(String namProduct) {
        Products object = null;
        boolean check = true;
        String name = "";
        Iterator<Entry<Integer, Products>> it = order.entrySet().iterator();
        Products obj;

        while (it.hasNext() && check) {
            Entry<Integer, Products> entry = it.next();
            obj = (Products) entry.getValue();
            name = obj.getName();

            if (namProduct == name) {
                object = entry.getValue();
                check = false;
            }
        }
        return object;
    }

    /**
     * 
     * @apiNote converts the Order object to a string
     * @return String,if it does not find any order returns null
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        Iterator<Entry<Integer, Products>> it = order.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Integer, Products> entry = it.next();
            string.append(entry.getKey());
            string.append(entry.getValue());
        }
        return string.toString();
    }

    /**
     * @param cart of type Cart
     * @apiNote add the products of the cart to the treemap
     */
    public void addProducts(Cart cart) {
        ArrayList<Integer> quantity = cart.getQuantity();
        ArrayList<Products> products = cart.getProducts();

        if (quantity.size() == products.size()) {
            for (int i = 0; i < quantity.size(); i++) {
                order.put(quantity.get(i), products.get(i));
                total = total + products.get(i).getPrice();
            }
        }
    }

    /**
     * @param namProduct of type String
     * @apiNote remove a specific product
     * @return if variable check is true,the product was removed,otherwise a false
     *         finds it
     */
    public boolean removeProduct(String namProduct) {
        boolean check = false;
        String name = "", className = "";
        Iterator<Entry<Integer, Products>> it = order.entrySet().iterator();
        Products obj;

        while (it.hasNext() && !check) {
            Entry<Integer, Products> entry = it.next();

            obj = (Products) entry.getValue();
            name = obj.getName();

            if (namProduct == name) {
                it.remove();
                check = true;
            }
        }
        return check;
    }

    // GETTERS
    public String getBuyDate() {
        return buyDate;
    }

    public UUID getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    // SETTERS
    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
