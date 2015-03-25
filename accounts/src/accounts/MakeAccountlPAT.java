/*
 * Dustin Horvath
 * Accounts program
 * 3/25/15
 * EECS 368 HW #3
 * MakeAccountlPAT.java: Inherits from MakeAccountlPA. Adds account balance transfer feature.
 */

package accounts;

public class MakeAccountlPAT extends MakeAccountlPA{

	public MakeAccountlPAT(double dep, String pass) {
		super(dep, pass);
	}
	
	public void transfer(String from_pw, MakeAccountlPAT to_acc, String to_pw){
		if(!this.passwd.equals(from_pw)){
			System.out.println("Incorrect Password");
		}
		else if(!to_acc.passwd.equals(to_pw)){
			System.out.println("Incorrect Password");
		}
		else if(count <= max_attempts){
			double temp = this.current_bal;
			this.withdraw(from_pw, temp);
			to_acc.deposit(to_pw, temp);
		}
	}
}
