package ge.ufc.webservices.ws;

import java.util.List;

import javax.jws.WebService;

import ge.ufc.webapps.exception.DatabaseException;
import ge.ufc.webapps.exception.TransactionsAlreadyExistsException;
import ge.ufc.webapps.exception.UserAlreadyExistsException;
import ge.ufc.webapps.exception.UserNotFoundException;
import ge.ufc.webapps.model.Transactions;
import ge.ufc.webapps.model.User;
import ge.ufc.webapps.model.Users;
import ge.ufc.webservices.repository.DaoRepository;
import ge.ufc.webservices.repository.DaoRepositoryImpl;



@WebService(endpointInterface = "ge.ufc.webservices.ws.ServiceWS")
public class Service implements ServiceWS {

    private DaoRepository userRepositoryImpl = new DaoRepositoryImpl();

	@Override
	public User check(int id) throws UserNotFoundException, DatabaseException {
		return userRepositoryImpl.getUser(id);
	}

	@Override
	public Transactions pay(int id) throws UserNotFoundException, DatabaseException, TransactionsAlreadyExistsException, UserAlreadyExistsException {
		return userRepositoryImpl.addTransactions(id);
	}

	@Override
	public List<Users> getAllUsers() throws DatabaseException, UserNotFoundException {
		return userRepositoryImpl.listUsers();
	}
}


