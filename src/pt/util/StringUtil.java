package pt.util;

import java.util.HashMap;
import java.util.Map;

import pt.init.enumtype.MathematicalSign;
import pt.messages.Messages;
import pt.vo.Product;
import pt.vo.TransactionHistory;

public class StringUtil {

	public static long getCalculatedAmount(String userInput, TransactionHistory transactionHistory) throws Exception {
		long newCalculatedAmount = 0L;
		try {
			for (MathematicalSign mathSign : MathematicalSign.values()) {
				if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {

					if (mathSign.equals(MathematicalSign.ADD)) {
						newCalculatedAmount = transactionHistory.getFromAmountRecorded()
								+ transactionHistory.getNewAmountEntered();
					}
					if (mathSign.equals(MathematicalSign.MULTIPLY)) {
						newCalculatedAmount = transactionHistory.getFromAmountRecorded()
								* transactionHistory.getNewAmountEntered();
					}
					if (mathSign.equals(MathematicalSign.SUBSTRACT)) {
						newCalculatedAmount = transactionHistory.getFromAmountRecorded()
								- transactionHistory.getNewAmountEntered();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newCalculatedAmount;
	}

	public static long getAmountFromProductWithoutCurrency(String userInput) {
		try {
			if (userInput != null) {
				String amount = "";
				if (!isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					amount = userInput.substring(0, userInput.indexOf(Messages.DEFAULT_CURRENCY));
					return Long.valueOf(amount);
				}
				if (isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					for (MathematicalSign mathSign : MathematicalSign.values()) {
						if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {
							amount = userInput.substring(mathSign.getNameOfSign().length(), userInput.length()).trim();
							amount = amount.substring(0, amount.indexOf(Messages.DEFAULT_CURRENCY));
							return Long.valueOf(amount);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Long.valueOf(0);
	}

	private static String getAmountFromProductWithCurrency(String userInput) {
		
		String amount = "";
		try {
			if (userInput != null) {
				
				if (!isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					amount = userInput.substring(0, userInput.indexOf(Messages.DEFAULT_CURRENCY) + 1);
					return amount;
				}
				if (isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					for (MathematicalSign mathSign : MathematicalSign.values()) {
						if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {
							amount = userInput.substring(mathSign.getNameOfSign().length(), userInput.length()).trim();
							amount = amount.substring(0, userInput.indexOf(Messages.DEFAULT_CURRENCY) + 1);
							return amount;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amount;
	}

	public static String getProductName(String userInput) throws Exception {
		try {
			if (userInput != null) {
				String productName = "";
			
				if (!isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					productName = userInput.replace(getAmountFromProductWithCurrency(userInput), "");
					return productName.trim();

				}
				if (isMathematicalCommand(userInput) && userInput.contains(Messages.DEFAULT_CURRENCY)) {
					for (MathematicalSign mathSign : MathematicalSign.values()) {
						if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {
							productName = userInput.substring(mathSign.getNameOfSign().length(), userInput.length()).trim();
							productName = productName.replace(getAmountFromProductWithCurrency(productName), "");
							return productName.trim();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("The input executed didnt meet the requirements");
	}

	public static boolean isMathematicalCommand(String userInput) {
		try {
			for (MathematicalSign mathSign : MathematicalSign.values()) {
				if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Map<String, Integer> getUpdatedSalesMapperTypeForProduct(Product product, String userInput) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			map.putAll(product.getSalesMapperType());
			String saleType = "";
			if (!isMathematicalCommand(userInput)) {
				saleType = "sales of " + product.getName() + " at " +
						StringUtil.getAmountFromProductWithoutCurrency(userInput) + product.getCurrency() + " each";
			}
			if (isMathematicalCommand(userInput)) {
				for (MathematicalSign mathSign : MathematicalSign.values()) {
					if (userInput.toLowerCase().startsWith(mathSign.getNameOfSign().toLowerCase())) {
						String userInputTemp = userInput.substring(mathSign.getNameOfSign().length(), userInput.length()).trim();
						saleType = "sales of " + product.getName() + " at " +
								StringUtil.getAmountFromProductWithoutCurrency(userInputTemp) + product.getCurrency() + " each";
					}
				}
			}
			if (map.containsKey(saleType)) {
				int salesCount = map.get(saleType);
				map.put(saleType, salesCount+1);
			} else {
				map.put(saleType, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}	
	
}