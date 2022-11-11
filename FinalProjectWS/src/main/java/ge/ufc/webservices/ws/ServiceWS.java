package ge.ufc.webservices.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import ge.ufc.webapps.exception.DatabaseException;
import ge.ufc.webapps.exception.TransactionsAlreadyExistsException;
import ge.ufc.webapps.exception.UserAlreadyExistsException;
import ge.ufc.webapps.exception.UserNotFoundException;
import ge.ufc.webapps.model.Transactions;
import ge.ufc.webapps.model.User;
import ge.ufc.webapps.model.Users;






@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceWS {
	
    @WebMethod(operationName = "check")
    @WebResult(name = "checkResult")
    User check(@WebParam(name = "UserId") int id) throws UserNotFoundException, DatabaseException;

    
    @WebMethod(operationName = "pay")
    @WebResult(name = "payResult")
    Transactions pay(@WebParam(name = "SystemTransactionId") int id) throws UserNotFoundException, DatabaseException, TransactionsAlreadyExistsException, UserAlreadyExistsException;

    @WebMethod(operationName = "GetAllUsers")
    @WebResult(name = "GetAllUsersResult")
    List<Users> getAllUsers() throws DatabaseException, UserNotFoundException;
}
