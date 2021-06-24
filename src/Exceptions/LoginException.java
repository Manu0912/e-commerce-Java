package Exceptions;

public class LoginException extends Exception {

	/**
     * @param message   of type String
     * @apiNote add a message for the login exception
     */
    public LoginException(String message) {
        super(message);
    }
}
