package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {

	public static void main(String[] args) throws InterruptedException {


		
		int initialBalanceAmount = 3000;
		
		System.out.println("Account Transactions" + "\n");
		System.out.println("Initial balance in the account:" + initialBalanceAmount + "\n");

		Account account = new Account(initialBalanceAmount);
		
		
		
		ArrayList<Transaction> listOfTransactions = new ArrayList<Transaction>();

	
		
		Transaction firstTransaction = new Transaction(account, 1000, true);
		Transaction secondTransaction = new Transaction(account, 40, false);
		Transaction thirdTransaction = new Transaction(account, 1000, true);


	

		listOfTransactions.add(firstTransaction);
		listOfTransactions.add(secondTransaction);
		listOfTransactions.add(thirdTransaction);

		
	
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		
		listOfTransactions.forEach((n) -> executorService.execute(n));

	
		executorService.shutdown();

		try {

			boolean transactionComplete = executorService.awaitTermination(40, TimeUnit.SECONDS);
			if (transactionComplete) {

				System.out.println("Final " + account.toString());

			} else {

				System.out.println("Time up");

			}

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}
}
