package ge.ufc.webservices.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ge.ufc.webapps.exception.DatabaseException;

public class DatabaseManager {
    private static final Logger logger = LogManager.getLogger();

    private static final String MOVIE_TOMCAT_DS = "java:comp/env/jdbc/userDS";
    
    public static final String JDBC_URL = "jdbc:derby://localhost:1527/sampleA";

    public static Connection getDatabaseConnection() throws DatabaseException {
        return getConnection();
    }

    private static Connection getConnection() throws DatabaseException {
        try {
            DataSource ds = getDataSource(MOVIE_TOMCAT_DS);
            return ds.getConnection();
        } catch (NamingException e) {
            throw new DatabaseException("Unable to find datasource", e);
        } catch (SQLException e) {
            throw new DatabaseException("Unable to connect to the database", e);
        }
    }

    private static DataSource getDataSource(String jndiName) throws NamingException {
        Context initCtx = new InitialContext();
        return (DataSource) initCtx.lookup(jndiName);
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.warn("Unable to close connection", e);
            }
        }
    }
}

