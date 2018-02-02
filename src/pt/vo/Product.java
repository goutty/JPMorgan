package pt.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
	
	private int id;
	private String name;
	private long originalAmount;
	private String currency;
	private List<TransactionHistory> transactionHistories = new ArrayList<TransactionHistory>();
	private Date dateCreated;
	private Map<String, Integer> salesMapperType = new HashMap<String, Integer>();
	

	public Product(int id, String name, long originalAmount, String currency, List<TransactionHistory> transactionHistories,
			Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.originalAmount = originalAmount;
		this.currency = currency;
		this.transactionHistories = transactionHistories;
		this.dateCreated = dateCreated;
	}
	
	public Product(int id, String name, long originalAmount, String currency, Date dateCreated) {
		super();
		this.id = id;
		this.name = name;
		this.originalAmount = originalAmount;
		this.currency = currency;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getOriginalAmount() {
		return originalAmount;
	}
	
	public void setOriginalAmount(long originalAmount) {
		this.originalAmount = originalAmount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public List<TransactionHistory> getTransactionHistories() {
		return transactionHistories;
	}
	
	public int getTransactionHistoriesSize() {
		return getTransactionHistories().size() == 0 ? 1 : getTransactionHistories().size();
	}
	
	public void setTransactionHistories(List<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}
	
	public void addTransactionHistories(TransactionHistory transactionHistory) {
		this.getTransactionHistories().add(transactionHistory);
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Map<String, Integer> getSalesMapperType() {
		return salesMapperType;
	}

	public void setSalesMapperType(Map<String, Integer> salesMapperType) {
		this.salesMapperType = salesMapperType;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", originalAmount=" + originalAmount 
				+ ", currency=" + currency
				+ ", transactionHistories=" + transactionHistories 
				+ ", dateCreated=" + dateCreated 
				+ "salesMapperType=" + salesMapperType
				+ "]";
	}
	
}