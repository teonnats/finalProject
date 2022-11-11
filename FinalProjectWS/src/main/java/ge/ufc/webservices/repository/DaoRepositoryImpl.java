package ge.ufc.webservices.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ge.ufc.webapps.exception.DatabaseException;
import ge.ufc.webapps.exception.TransactionsAlreadyExistsException;
import ge.ufc.webapps.exception.TransactionsNotFoundException;
import ge.ufc.webapps.exception.UserAlreadyExistsException;
import ge.ufc.webapps.exception.UserNotFoundException;
import ge.ufc.webapps.model.Transactions;
import ge.ufc.webapps.model.User;
import ge.ufc.webapps.model.Users;





public class DaoRepositoryImpl implements DaoRepository{
	
	private static final String DUPLICATE_KEY_ERROR = "23505";
	
    private Connection connection;

    public DaoRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public DaoRepositoryImpl() {
    }
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listUsers() throws UserNotFoundException {
		String sql = "SELECT * FROM Users";
	    Users users = new Users();
	    users.setUsers(new ArrayList<>());
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                User user = new User(rs.getInt("userId"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("personNumber"),rs.getString("balance"));
	                users.getUsers().add(user);
	            }
	            return (List<Users>) users;
	        }
	    } catch (SQLException e) {
	    	throw new UserNotFoundException();
	    }
	    
	    
	}
	

	@Override
	public User getUser(int id) throws UserNotFoundException,DatabaseException {
		String sql = "SELECT * FROM Users WHERE userId = ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, sql);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new User(rs.getInt("userId"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("balance"));
	            } else {
	                throw new UserNotFoundException("User is not found in the database");
	            }
	        }
	    } catch (SQLException e) {
	        throw new DatabaseException("Unable to get user from the database", e);
	    }
	}

	@Override
	public void addTransactions(Transactions transactions) throws DatabaseException,TransactionsAlreadyExistsException, UserAlreadyExistsException {
		String sql = "INSERT INTO Transactions (agentTransactionId, userId, amount) VALUES (?, ?)";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, transactions.getSystemTransactionId());
	        ps.setString(2, transactions.getUserId());
	        ps.setString(3, transactions.getAmount());
	        ps.execute();
	    } catch (SQLException e) {
	        if (DUPLICATE_KEY_ERROR.equals(e.getSQLState())) {
	            throw new UserAlreadyExistsException("User already exists in the database");
	        }
	        throw new DatabaseException("Unable to add transaction to the database ", e);
	    }
	}

	@Override
	public Transactions addTransactions(int id) throws DatabaseException, TransactionsAlreadyExistsException, UserAlreadyExistsException {
		return null;
	}

	@Override
	public void updateStatus(Transactions transactions) throws DatabaseException, TransactionsAlreadyExistsException, TransactionsNotFoundException {
		String sql = "UPDATE Transactions SET Transactions= = ? WHERE agentTransactionId = ?";
	    try (PreparedStatement ps = connection.prepareStatement(sql)) {
	        ps.setString(1, transactions.getAgentId());
	        ps.setString(2, transactions.getSystemTransactionId());

	        int SystemTransactionId = ps.executeUpdate();
	        if (SystemTransactionId == 0) {
	            throw new TransactionsNotFoundException("transactions steatus not found in the database");
	        }
	    } catch (SQLException e) {
	        throw new DatabaseException("Unable to update transaction to the database ", e);
	    }		
	}
}









