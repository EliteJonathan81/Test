/**
 * Class that can store the data required for a primitive bank account.
 * This class can only be accessed from within the package.
 * @author jg971
 * @version 1
 * @release 04/11/16
 */
class BankAccount{
	
	private long balance;
	private long ID;
	private long overDraft;
	
	
	
	/**
	 * Constructor supplying the account ID and maximum overdraft
	 * @param startingID - the starting ID of the account.
	 * It is your responsibility to ensure the ID is unique.
	 * @param startingoverDraft - the allowed overdraft the user starts with in pence.
	 * Must not be below 0.
	 */
	BankAccount(long startingID, long startingoverDraft){
		
		ID = startingID;
		
		if (startingoverDraft >= 0) {
			overDraft = startingoverDraft;
		}
		else {
			System.out.println("Error: the allowed overdraft cannot be below 0. The"
					+ " allowed overdraft has been set to 0.");
			overDraft = 0;
		}
		
		
	}
	
	/**
	 * The following 3 methods are accessors for the balance in pence, the ID and 
	 * the allowed overdraft in pence for the account.
	 */
	long getBalance() {
		return balance;
	}
	
	long getID() {
		return ID;
	}

	long getoverDraft() {
		return overDraft;
	}
	
	
	
	
	/**
	 * @param increment - the value in pence to increment the balance. If positive this
	 * means that money is going into the account. If negative this means that money
	 * is being withdrawn from the account. You cannot take out more money than that's
	 * in the account (including overdraft).
	 */
	void incrementBalance(long increment){	
		
		if (increment < 0) {
			
			long decrement = increment * -1; 
			
			if (decrement <= balance + overDraft){
				balance -= decrement;	
			}
			else {
				System.out.println("Error: not enough money in account!");
			}		
			
		}
		else {
			balance += increment;
		}
		
	}
	
	/**
	 * @param newID - the newID of the account.
	 * It is your responsibility to ensure the ID is unique.
	 */
	void changeID(long newID){
		ID = newID;
	}
	
	
	
	/**
	 * @param newoverDraft - the new value of the allowed overdraft for the account
	 * in pence. Must not be below 0. Also this cannot result in an account going out
	 * of their allowed overdraft.
	 */
	void setoverDraft(long newoverDraft){
		
		if (newoverDraft >= 0) {
			
			if (newoverDraft >= (balance * -1)) {
				overDraft = newoverDraft;
			}
			else {
				System.out.println("Error: this would cause account to go over"
						+ " allowed overdraft.");
			}
			
		}
		else {
			System.out.println("Error: the allowed overdraft cannot be below 0.");
			overDraft = 0;	
		}
		
	}
	
	
}



/**
 * This program tests the class BankAccount by creating 2 different accounts. 
 * This testing includes how the class handles illegal input data.
 */
public class Lab4ex3 {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount(1, 0);
		
		BankAccount account2 = new BankAccount(2, 20000);
		//Both accounts start with a balance of £0, except account2 starts with an overdraft of £200.00.
	
		long pounds;
		int pence;
		String penceString;
		
		
		//Displays account 2 balance.
		pounds = account2.getBalance() / 100;
		pence = (int)account2.getBalance() % 100;
		penceString = (pence < 10) ? ("0" + pence) : ("" + pence);
		System.out.println("Account ID: " + account2.getID() + ", Balance: £" +
				pounds + "." + penceString);
		
		
		//Adds £100.00 into account 1 and displays balance.
		account1.incrementBalance(10000);
		pounds = account1.getBalance() / 100;
		pence = (int)account1.getBalance() % 100;
		penceString = (pence < 10) ? ("0" + pence) : ("" + pence);
		System.out.println("Account ID: " + account1.getID() + ", Balance: £" +
		pounds + "." + penceString);
		
		
		/* Sets account 1 an overdraft of £100.00. Then takes £200.00 out of the
		 account so just within overdraft. */ 
		account1.setoverDraft(10000);
		account1.incrementBalance(-20000);
		pounds = account1.getBalance() / 100;
		pence = (int)account1.getBalance() % 100;
		penceString = (pence < 10) ? ("0" + pence) : ("" + pence);
		System.out.println("Account ID: " + account1.getID() + ", Balance: £" +
				pounds + "." + penceString);
		
		
		//Tries to set the overdraft of account 1 to invalid values.
		account1.setoverDraft(-1);
		account1.setoverDraft(100);
		
		
		//Displays the over draft of account 2.
		pounds = account2.getoverDraft() / 100;
		pence = (int)account2.getoverDraft() % 100;
		penceString = (pence < 10) ? ("0" + pence) : ("" + pence);
		System.out.println("Account ID: " + account2.getID() + ", Allowed Overdraft: £" +
				pounds + "." + penceString);
		
		
		//Takes too much money out of account 2.
		account2.incrementBalance(-20001);
		
				

	}

}
