package pt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pt.init.Initial;

public class StartConsole {

	private static BufferedReader stdin = 
			new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		Initial execute = new Initial();
		int totalRunningMessageCount = 0;
		while (totalRunningMessageCount <= 50) {
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
				String userInput= stdin.readLine();
				execute.init(userInput);
			}
			totalRunningMessageCount++;
		}		
	}
}
