package ge.ufc.webapps.exception;

public class TransactionsAlreadyExistsException extends Exception {

private static final long serialVersionUID = 1L;
    
    public TransactionsAlreadyExistsException(String message) {
        super(message);
    }
}
