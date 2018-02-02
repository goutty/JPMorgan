package test;

import org.testng.annotations.Test;

import pt.init.Initial;
import pt.init.enumtype.MathematicalSign;
import pt.messages.Messages;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;

public class TestUpload {

	// Add 20p apples
	// Subtract 20p apples
	// Multiply 20p apples
	// 10p apples

	// Add 2p beans
	// Subtract 4p beans
	// Multiply 2p beans
	// 12p beans
	
	String[] itemsNames = {"beans", "apples", "peas", "bananas","limes"};
	
	@Test
	public void f() {
		Initial execute = new Initial();
		List<String> items = loadItems();
		for (int totalRunningMessageCount = 0; totalRunningMessageCount <= 50; totalRunningMessageCount++) {
			
			if (totalRunningMessageCount == 10) {
				System.out.println(execute.printSalesIntervalReport());
				
			} else if (totalRunningMessageCount == 20) {
				System.out.println(execute.printSalesIntervalReport());
				
			} else if (totalRunningMessageCount == 30) {
				System.out.println(execute.printSalesIntervalReport());
				
			} else if (totalRunningMessageCount == 40) {
				System.out.println(execute.printSalesIntervalReport());
				
			} else if (totalRunningMessageCount == 50) {
				System.out.println(execute.printSalesIntervalReport());
				System.out.println(execute.printDetailedSalesAdjustmentReport());
			} else {
				String userInput= items.get(totalRunningMessageCount);
				execute.init(userInput);
			}
		}
	}

	private List<String> loadItems() {
		List<String> items = new ArrayList<String>();
		items.add("12p beans");
		items.add("13p apples");
		items.add("81p peas");
		items.add("7p bananas");
		items.add("45p limes");
		Random rand = new Random();
		for (int i = 0; i < 16; i++) {
			int randomAmnt = rand.nextInt(50) + 1;
			int randomItem = rand.nextInt(4) + 0;
			items.add(MathematicalSign.ADD.getNameOfSign() + " " + randomAmnt + Messages.DEFAULT_CURRENCY + " " + itemsNames[randomItem]);
		}
		for (int i = 0; i < 16; i++) {
			int randomAmnt = rand.nextInt(50) + 1;
			int randomItem = rand.nextInt(4) + 0;
			items.add(MathematicalSign.MULTIPLY.getNameOfSign() + " " + randomAmnt + Messages.DEFAULT_CURRENCY + " " + itemsNames[randomItem]);
		}
		for (int i = 0; i < 16; i++) {
			int randomAmnt = rand.nextInt(50) + 1;
			int randomItem = rand.nextInt(4) + 0;
			items.add(MathematicalSign.SUBSTRACT.getNameOfSign() + " " + randomAmnt + Messages.DEFAULT_CURRENCY + " " + itemsNames[randomItem]);
		}
		System.out.println(items.size());
		for (String string : items) {
			System.out.println(string);
		}
		return items;
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
