package pt.vo;

import java.util.Comparator;
import java.util.Date;

import pt.messages.Messages;

public class TransactionHistory implements Comparable<TransactionHistory>{
	
	private int id;
	private int productId;
	private String executedCommand;
	private long fromAmountRecorded;
	private long newAmountEntered;
	private long calculatedAmount = 0L;
	private Date transactionDate;
	
	public TransactionHistory(int id, int productId, String executedCommand, long fromAmountRecorded, long newAmountEntered,
			Date transactionDate) {
		super();
		this.id = id;
		this.productId = productId;
		this.executedCommand = executedCommand;
		this.fromAmountRecorded = fromAmountRecorded;
		this.newAmountEntered = newAmountEntered;
		this.transactionDate = transactionDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getExecutedCommand() {
		return executedCommand;
	}
	
	public void setExecutedCommand(String executedCommand) {
		this.executedCommand = executedCommand;
	}
	
	public long getFromAmountRecorded() {
		return fromAmountRecorded;
	}
	
	public void setFromAmountRecorded(long fromAmountRecorded) {
		this.fromAmountRecorded = fromAmountRecorded;
	}
	
	public long getNewAmountEntered() {
		return newAmountEntered;
	}
	
	public void setNewAmountEntered(long newAmountEntered) {
		this.newAmountEntered = newAmountEntered;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "TransactionHistory [id=" + id + ", productId=" + productId + ", executedCommand=" + executedCommand
				+ ", fromAmountRecorded=" + fromAmountRecorded + ", newAmountEntered=" + newAmountEntered 
				+ ", transactionDate=" + transactionDate
				+ ", calculatedAmount= " + calculatedAmount
				+ "]";
	}
	
	public String toDisplay() {
		return "Executed sale command [ " + executedCommand 
				+ " ], From amount recorded [ " + fromAmountRecorded + Messages.DEFAULT_CURRENCY
				+ " ], New amount entered  [ " + newAmountEntered + Messages.DEFAULT_CURRENCY
				+ " ], Calculated amount [ " + calculatedAmount + Messages.DEFAULT_CURRENCY
				+ " ]";
	}

	
	@Override
    public int compareTo(TransactionHistory o) {
        return this.id - o.id;
    }
	
	public long getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(long calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public static final Comparator<TransactionHistory> transactionDateComparatorASC = new Comparator<TransactionHistory>(){

        @Override
        public int compare(TransactionHistory o1, TransactionHistory o2) {
            return o2.id - o1.id;
        }
      
    };
    
    public static final Comparator<TransactionHistory> transactionDateComparatorDESC = new Comparator<TransactionHistory>(){

        @Override
        public int compare(TransactionHistory o1, TransactionHistory o2) {
            return o1.id - o2.id;
        }
      
    };
	
}

