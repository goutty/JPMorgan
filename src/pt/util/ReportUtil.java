package pt.util;

import java.util.Formatter;
import java.util.List;

import pt.messages.Messages;
import pt.vo.Product;
import pt.vo.TransactionHistory;

public class ReportUtil {

	public static String printSalesIntervalReport(List<Product> products) {
		StringBuilder stringBuilder = new StringBuilder();
		Formatter fmt = new Formatter(stringBuilder);
		try {
			for (Product product : products) {
				stringBuilder.append("======================================== Individual Sales =========================================\n");
				for (TransactionHistory transactionHistory : product.getTransactionHistories()) {
					fmt.format(Messages.MESSAGES_TYPE_1,
								product.getName(),
								Long.valueOf(transactionHistory.getCalculatedAmount())+product.getCurrency()+"\n");
				}
				stringBuilder.append("========================================================================================\n");
				stringBuilder.append("=========================== Sale and the number of Occurrences =================================\n");

				for (String saleType : product.getSalesMapperType().keySet()) {
					int saleAmountForType = product.getSalesMapperType().get(saleType);
					fmt.format(Messages.MESSAGES_TYPE_2,
									saleAmountForType,
									saleType+"\n");
				}
				stringBuilder.append("====================================================================================\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			fmt.close();
		}
		return stringBuilder.toString();
	}

	public static String printDetailedSalesAdjustmentReport(List<Product> products) {
		StringBuilder stringBuilder = new StringBuilder();
		Formatter fmt = new Formatter(stringBuilder);
		try {
			stringBuilder.append("============================ Sale and an Adjustment Breakdown ================================\n");
			for (Product product : products) {
				for (TransactionHistory transactionHistory : product.getTransactionHistories()) {
					fmt.format(Messages.MESSAGES_TYPE_3,
									product.getName().toUpperCase() 
									+ "\t-->\t" + transactionHistory.toDisplay()+"\n");
				}
			}
			stringBuilder.append("===================================================================================\n");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			fmt.close();
		}
		return stringBuilder.toString();
	}
}
