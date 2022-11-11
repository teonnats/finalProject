package ge.ufc.webapps.exception;

import javax.xml.ws.WebFault;

@WebFault
public class UserAlreadyExistsException extends Exception {
    private static final long serialVersionUID = 1L;
    
    
    public UserAlreadyExistsException() {
        super("This user already exists");
    }
    
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
