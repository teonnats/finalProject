package ge.ufc.webapps.exception;

public class TransactionsNotFoundException extends Exception {

private static final long serialVersionUID = 1L;
    
    public TransactionsNotFoundException(String message) {
        super(message);
    }
}
