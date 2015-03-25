/*
 * Dustin Horvath
 * Accounts program
 * 3/25/15
 * EECS 368 HW #3
 * MakeAccount.java: Base class for all accounts. Has get/set for account balance.
 */

package accounts;

public class MakeAccount {	
	protected double current_bal = 0;
	
	public MakeAccount(double dep){
		current_bal = dep;
	}
	
	public void deposit(double dep){
		current_bal += dep;
		System.out.println("Balance:" + current_bal);
	}
	
	public void withdraw(double take){
		if(take <= current_bal){
			current_bal -= take;
			System.out.println("Balance:" + current_bal);
		}
		else{
			System.out.println("Insufficient Funds");
		}
	}
	
	public void view(){
		System.out.println("Balance:" + current_bal);
	}
}
