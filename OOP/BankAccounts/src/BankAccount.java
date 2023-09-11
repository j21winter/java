import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int accounts;
	private static double totalMoney;

			
//	Blank Constructor 
	public BankAccount() {
		
	}
	
//	Checking account only Constructor 
	public BankAccount(double checkingBalance) {
		this.checkingBalance = checkingBalance;
		accounts ++;
		this.accountNumber = createAccountNumber();
	}
//	Checking and Savings Constructor
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		accounts ++;
		this.accountNumber = createAccountNumber();
	}

//	GETTERS
//	Checking Balance
	public double getCheckingBalance() {
		return checkingBalance;
	}

//	Savings Balance
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
//	Balances
	public void getBalances() {
		double checkingBalance = getCheckingBalance();
		double savingsBalance = getSavingsBalance();
		System.out.printf("\nChecking Account: %s\nSavings Account: %s\n\n", checkingBalance, savingsBalance);
	}
	
//	Account Number
	public void getAccountNumber() {
		System.out.println(this.accountNumber);
	}

//	Static Accounts
	public static int getAccounts() {
		return accounts;
	}

//	Total Money
	public static double getTotalMoney() {
		return totalMoney;
	}
	
//	Deposit money into Savings
	public double depositSaving(double amount) {
		savingsBalance += amount;
		totalMoney += amount;
		return getSavingsBalance();
	}
	
//	Deposit money into checking
	public double depositChecking(double amount) {
		checkingBalance += amount;
		totalMoney += amount;
		return getCheckingBalance();
	}
	
//	Withdraw money from Savings
	public void withdrawSaving(double amount) {
		if(amount > savingsBalance) {
			return;
		}
		else {
			savingsBalance -= amount;
			totalMoney -= amount;
		}

	}
	
//	Withdraw money from checking
	public void withdrawChecking(double amount) {
		if(amount > checkingBalance) {
			return;
		}
		else {
			checkingBalance -= amount;
			totalMoney -= amount;
		}
	}
	
	private String createAccountNumber() {
		Random random = new Random();
		long randomNum = random.nextLong();
		if(randomNum < 0) {
			randomNum = randomNum * -1;
		}
		String accountNum = Long.toString(randomNum).substring(0,10);
		return accountNum;
	}


	
	
	
}
