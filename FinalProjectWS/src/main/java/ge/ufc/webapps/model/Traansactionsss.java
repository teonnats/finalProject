package ge.ufc.webapps.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;


@XmlRootElement(name = "transactionsss")
@XmlAccessorType(XmlAccessType.FIELD)
public class Traansactionsss {
    @XmlElement(name = "transactions")
    @JsonProperty("transactionsss")
    private List<Transactions> transactionsss;

    public List<Transactions> getTransactionsss() {
        return transactionsss;
    }
    
    public void seTransactionsss(List<Transactions> transactionsss) {
        this.transactionsss = transactionsss;
    }

    @Override
    public String toString() {
        return transactionsss.toString();
    }
}