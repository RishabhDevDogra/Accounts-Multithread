package exercise1;

public class Account extends Thread {
	

	private double balanceAmount;


	public Account(double initialDepositAmount) {

		balanceAmount = initialDepositAmount;
	}

	public synchronized double getBalance() {

		return balanceAmount;
	}
	public synchronized void deposit(double amountdeposited) {

		try {
			Thread.sleep(1000);
			balanceAmount += amountdeposited;

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		System.out.printf("%s deposited %.2f in the account.\n", Thread.currentThread().getName(), amountdeposited);

		System.out.println(toString() + "\n");
	}

	
	public synchronized void withdraw(double amountwithdrawn) {

		try {
			Thread.sleep(1000);
			if (balanceAmount >= amountwithdrawn) {
				balanceAmount -= amountwithdrawn;
			}

		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		System.out.printf("%s withdrawn %.2f from the account.\n", Thread.currentThread().getName(), amountwithdrawn);

		System.out.println(toString() + "\n");

	}

	@Override
	public String toString() {
		return "Account Balance is:" + balanceAmount;
	}
}
