
public class BankTest {

	public static void main(String[] args) {
		
		System.out.println("\n\n----------Accounts Test---------\n\n");

		
		BankAccount account1 = new BankAccount(0,0);
		account1.getAccountNumber();
		BankAccount account2 = new BankAccount(0,0);
		account2.getAccountNumber();
		BankAccount account3 = new BankAccount(0,0);
		account3.getAccountNumber();
		
		System.out.println("\n\n----------Deposit Test---------\n\n");
		
		account1.depositChecking(100);
		System.out.println(account1.getCheckingBalance());
		account1.depositSaving(100);
		System.out.println(account1.getSavingsBalance());
		account1.getBalances();
		
		
		account2.depositChecking(200);
		System.out.println(account2.getCheckingBalance());
		account2.depositSaving(200);
		System.out.println(account2.getSavingsBalance());
		account2.getBalances();
		

		account3.depositChecking(300);
		System.out.println(account3.getCheckingBalance());
		account3.depositSaving(300);
		System.out.println(account3.getSavingsBalance());
		account3.getBalances();
		
		System.out.printf("Total Money: %s\n\n", BankAccount.getTotalMoney());
		
		System.out.println("\n\n----------Withdrawal Test---------\n\n");
		
		account1.withdrawChecking(10);
		System.out.println(account1.getCheckingBalance());
		account1.withdrawSaving(10);
		System.out.println(account1.getSavingsBalance());
		account1.getBalances();
		
		
		account2.withdrawChecking(20);
		System.out.println(account2.getCheckingBalance());
		account2.withdrawSaving(20);
		System.out.println(account2.getSavingsBalance());
		account2.getBalances();
		
		
		account3.withdrawChecking(30);
		System.out.println(account3.getCheckingBalance());
		account3.withdrawSaving(30);
		System.out.println(account3.getSavingsBalance());
		account3.getBalances();
		
		System.out.printf("Total Money: %s\n\n", BankAccount.getTotalMoney());
		
	}

}
