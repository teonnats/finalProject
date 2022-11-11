package ge.ufc.webapps.model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transactions", propOrder = { "userId", "firstName", "lastName" })
public class Transactions {
	@XmlElement(name = "SystemTransactionId")
	private String systemTransactionId;
	
	@XmlElement(name = "AgentId")
	private String agentId;

	@XmlElement(name = "AgentTransactionId")
	private int agentTransactionId;

	@XmlElement(name = "UserId")
	private String userId;

	@XmlElement(name = "Amount")
	private String amount;

	@XmlElement(name = "Date")
	private Date transactionDate;
	
	public Transactions() {
		
	}

	public Transactions(String systemTransactionId, String agentId, int agentTransactionId, String userId, String amount,
			Date transactionDate) {
		this.systemTransactionId = systemTransactionId;
		this.agentId = agentId;
		this.agentTransactionId = agentTransactionId;
		this.userId = userId;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transactions [systemTransactionId=" + systemTransactionId + ", agentId=" + agentId
				+ ", agentTransactionId=" + agentTransactionId + ", userId=" + userId + ", amount=" + amount
				+ ", transactionDate=" + transactionDate + "]";
	}

	public String getSystemTransactionId() {
		return systemTransactionId;
	}

	public void setSystemTransactionId(String systemTransactionId) {
		this.systemTransactionId = systemTransactionId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public int getAgentTransactionId() {
		return agentTransactionId;
	}

	public void setAgentTransactionId(int agentTransactionId) {
		this.agentTransactionId = agentTransactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}	

}

