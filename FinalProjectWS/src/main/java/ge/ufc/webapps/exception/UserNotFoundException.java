package ge.ufc.webapps.exception;

import javax.xml.ws.WebFault;

@WebFault
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    
    
    public UserNotFoundException() {
        super("the user does not exist");
    }
    
    public UserNotFoundException(String message) {
        super(message);
    }
}

