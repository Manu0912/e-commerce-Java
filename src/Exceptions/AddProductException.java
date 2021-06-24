package Exceptions;

public class AddProductException extends Exception {
	/**
     * @param message   of type String
     * @apiNote add a message for the product exception
     */
    public AddProductException(String message) {
        super(message);
    }
}
