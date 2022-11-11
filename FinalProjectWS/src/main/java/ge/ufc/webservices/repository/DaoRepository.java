package ge.ufc.webservices.repository;

import java.util.List;

import ge.ufc.webapps.exception.DatabaseException;
import ge.ufc.webapps.exception.TransactionsAlreadyExistsException;
import ge.ufc.webapps.exception.TransactionsNotFoundException;
import ge.ufc.webapps.exception.UserAlreadyExistsException;
import ge.ufc.webapps.exception.UserNotFoundException;
import ge.ufc.webapps.model.Transactions;
import ge.ufc.webapps.model.User;
import ge.ufc.webapps.model.Users;



public interface DaoRepository {
	
	List<Users> listUsers() throws DatabaseException, UserNotFoundException;

    User getUser(int id) throws UserNotFoundException, DatabaseException;
    
    Transactions addTransactions(int id) throws DatabaseException, TransactionsAlreadyExistsException, UserAlreadyExistsException;

	void addTransactions(Transactions transactions) throws DatabaseException, TransactionsAlreadyExistsException, UserAlreadyExistsException;
	
    void updateStatus(Transactions transactions) throws DatabaseException, TransactionsAlreadyExistsException, TransactionsNotFoundException;


}


