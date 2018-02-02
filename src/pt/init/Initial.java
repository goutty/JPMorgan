package pt.init;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import pt.cache.MemoryCache;
import pt.messages.Messages;
import pt.util.ReportUtil;
import pt.util.StringUtil;
import pt.vo.Product;
import pt.vo.TransactionHistory;

public class Initial {
	
	public void init(String userInput) {
		try {
			if (isProductExisting(userInput)) {
				productUpdate(getProductExisting(userInput), userInput);
			}
			else {
				productCreate(userInput);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String printSalesIntervalReport() {
		return ReportUtil.printSalesIntervalReport(getProductsInMemory());
	}
	
	public String printDetailedSalesAdjustmentReport() {
		return ReportUtil.printDetailedSalesAdjustmentReport(getProductsInMemory());
	}
	
	protected void productCreate(String userInput) {
		try {
			Product product = 
					new Product(getProductsInMemory().size() == 0 ? 1 :getProductsInMemory().size(), 
							StringUtil.getProductName(userInput), 
							StringUtil.getAmountFromProductWithoutCurrency(userInput), 
							Messages.DEFAULT_CURRENCY, 
							new Date());

			TransactionHistory transactionHistory = 
					new TransactionHistory(product.getTransactionHistoriesSize(), 
							product.getId(), userInput, new Long("0"), product.getOriginalAmount(), new Date());

			transactionHistory.setCalculatedAmount(product.getOriginalAmount());
			Collections.sort(product.getTransactionHistories(), TransactionHistory.transactionDateComparatorDESC);
			product.setSalesMapperType(StringUtil.getUpdatedSalesMapperTypeForProduct(product, userInput));
			product.addTransactionHistories(transactionHistory);
			getProductsInMemory().add(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void productUpdate(Product product, String userInput) {
		try {
			Collections.sort(product.getTransactionHistories(), TransactionHistory.transactionDateComparatorASC);
			TransactionHistory transactionHistory = 
					new TransactionHistory(product.getTransactionHistoriesSize()+1, 
							product.getId(), userInput, 
							product.getTransactionHistories().get(0).getCalculatedAmount(), 
							StringUtil.getAmountFromProductWithoutCurrency(userInput), new Date());
			
			Collections.sort(product.getTransactionHistories(), TransactionHistory.transactionDateComparatorDESC);
			long calculatedAmount = StringUtil.getCalculatedAmount(userInput, transactionHistory);
			transactionHistory.setCalculatedAmount(calculatedAmount);
			product.setSalesMapperType(StringUtil.getUpdatedSalesMapperTypeForProduct(product, userInput));
			product.addTransactionHistories(transactionHistory);
			for (Product productInMemory : getProductsInMemory()) {
				if (productInMemory.getName().equals(product.getName())) {
					productInMemory.setTransactionHistories(product.getTransactionHistories());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isProductExisting(String userInput) {
		try {

			String productInputted = StringUtil.getProductName(userInput);
			for (Product product : getProductsInMemory()) {
				if (product.getName().equalsIgnoreCase(productInputted)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private Product getProductExisting(String userInput) {
		try {
			String productInputted = StringUtil.getProductName(userInput);
			for (Product product : getProductsInMemory()) {
				if (product.getName().equalsIgnoreCase(productInputted)) {
					return product;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new NullPointerException("No Product was found");
	}
	
	protected synchronized List<Product> getProductsInMemory() {
		return MemoryCache.getInstance().products;
	}
}
