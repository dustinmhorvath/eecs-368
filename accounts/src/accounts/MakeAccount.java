package accounts;

import java.util.*;


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
