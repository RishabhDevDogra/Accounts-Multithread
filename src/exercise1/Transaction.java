package exercise1;

public class Transaction implements Runnable {
	

	private final Account account;
	private final int amount;
	private boolean deposit = true;


	public Transaction(Account account, int amount, boolean deposit) {
		super();
		this.account = account;
		this.amount = amount;
		this.deposit = deposit;
	}


	public void run() {
		if (deposit) {
			account.deposit(amount);
		} else{
			account.withdraw(amount);
		}
	}
}
