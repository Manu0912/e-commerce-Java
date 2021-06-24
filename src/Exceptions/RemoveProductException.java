package Exceptions;

public class RemoveProductException extends Exception {
	/**
     * @param message   of type String
     * @apiNote add a message for the remove product exception
     */
    public RemoveProductException(String message) {
        super(message);
    }
}
