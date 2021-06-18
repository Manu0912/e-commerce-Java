package types_users;

import List.Orders;

public class Admin extends Users {

    public Admin() {

    }

    public Admin(String name, String lastName, String password, String email) {
        super(name, lastName, password, email);
    }

    // cambiar estado del pedido
    private void changeOrderState(Orders orderList, int state) {

    }
    // agregar producto
    // modificar producto
    // borrar producto
}
