/*
 * Dustin Horvath
 * Accounts program
 * 3/25/15
 * EECS 368 HW #3
 * MakeAccountlP.java: Inherits from MakeAccountl. Adds password feature (basic).
 */

package accounts;

public class MakeAccountlP extends MakeAccountl{

	String passwd;
	
	public MakeAccountlP(double dep, String pass) {
		super(dep);
		passwd = pass;
	}
	
	public void deposit(String pass, double dep){
		if(pass.equals(passwd)){
			current_bal += dep;
			System.out.println("Balance:" + current_bal);
			list = list.substring(0, list.length()-1);
			list = list + "(+ " + dep + " = " + current_bal + " ) )";
		}
		else{
			pw_error();
		}
	}
	
	public void withdraw(String pass, double take){
		if(pass.equals(passwd)){
			if(take <= current_bal){
				current_bal -= take;
				System.out.println("Balance:" + current_bal);
				list = list.substring(0, list.length()-1);
				list = list + "(- " + take + " = " + current_bal + " ) )";
			}
			else{
				System.out.println("Insufficient Funds");
			}
		}
		else{
			pw_error();
		}
	}
	
	public void view(String pass){
		if(pass.equals(passwd)){
			System.out.println("Balance:" + current_bal);
		}
		else{
			pw_error();
		}
	}
	
	public void show(String pass){
		if(pass.equals(passwd)){
			System.out.println("Ledger:" + list);
		}
		else{
			pw_error();
		}
	}
	
	public void pw_error(){
		System.out.println("Incorrect Password");
	}
}
