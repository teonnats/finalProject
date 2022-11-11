
package ge.ufc.webapps.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = { "userId", "firstName","lastName"})
public class User {
    @XmlElement(name = "ID")
    private int userId;
    @XmlElement(name = "FirstName")
    private String firstName;
    
    @XmlElement(name = "LastName")
    private String lastName;
    
    @XmlElement(name = "PersonNumber")
    private String personNumber;
    
    @XmlElement(name = "Balance")
    private String balance;

    public User() {

    }
    
    public User(int userId, String firstName, String lastName,String balance) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public User(int userId, String firstName, String lastName, String personNumber, String balance) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.personNumber = personNumber;
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

    

}
