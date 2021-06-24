package Exceptions;

public class CreditCardException extends Exception {
	/**
     * @param message   of type String
     * @apiNote add a message for the credit card exception
     */
    public CreditCardException(String message) {
        super(message);
    }
}
