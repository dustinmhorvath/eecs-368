/*
 * Dustin Horvath
 * Accounts program
 * 3/25/15
 * EECS 368 HW #3
 * main.java
 */

package accounts;

class MakeAccount {	
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

class MakeAccountl extends MakeAccount{
	String list;
	
	public MakeAccountl(double dep){
		super(dep);
		list = "'( (start = " + dep + " ) )";
	}

	@Override
	public void deposit(double dep){
		current_bal += dep;
		System.out.println("Balance:" + current_bal);
		list = list.substring(0, list.length()-1);
		list = list + "(+ " + dep + " = " + current_bal + " ) )";
	}
	
	@Override
	public void withdraw(double take){
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

	public void show(){
		System.out.println("Ledger:" + list);
	}
}

class MakeAccountlP extends MakeAccountl{

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

class MakeAccountlPA extends MakeAccountlP{
	int max_attempts = 8;
	int count;
	
	public MakeAccountlPA(double dep, String pass){
		super(dep, pass);
		count = 0;
	}

	public void deposit(String pass, double dep){
		if(count < max_attempts){
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
		else{
			System.out.println("Cops Called");
		}
	}
	
	public void withdraw(String pass, double take){
		if(count < max_attempts){
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
		else{
			System.out.println("Cops Called");
		}
	}
	
	public void view(String pass){
		if(count < max_attempts){
			if(pass.equals(passwd)){
				System.out.println("Balance:" + current_bal);
			}
			else{
				pw_error();
			}
		}
		else{
			System.out.println("Cops Called");
		}
	}
	
	public void show(String pass){
		if(count < max_attempts){
			if(pass.equals(passwd)){
				System.out.println("Ledger:" + list);
			}
			else{
				pw_error();
			}
		}
		else{
			System.out.println("Cops Called");
		}
	}

	@Override
	public void pw_error(){
		System.out.println("Incorrect Password");
		count++;
	}
}

class MakeAccountlPAT extends MakeAccountlPA{

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

class MakeAccountlPATS extends MakeAccountlPAT{
	double rate;
	
	public MakeAccountlPATS(double dep, String pass, double intr) {
		super(dep, pass);
		rate = intr;
	}

	public void interest(String pass){
		if(passwd.equals(pass)){
			current_bal = current_bal * (1 + rate);
			view(pass);
		}
		else{
			pw_error();
		}
	}
	
}

public class main {
	public static void main(String[] args) {

		System.out.println();
		System.out.println("-----------------PART 1-------------------");
		MakeAccount acc = new MakeAccount(100);
		acc.view();
		acc.withdraw(50);
		acc.withdraw(60);
		acc.deposit(40);
		acc.withdraw(60);
		MakeAccount acc2 = new MakeAccount(0);
		acc2.deposit(17);
		
		System.out.println();
		System.out.println("-----------------PART 2-------------------");
		MakeAccountl acc1 = new MakeAccountl(100);
		acc1.view();
		acc1.withdraw(40);
		acc1.deposit(55);
		acc1.show();
		
		System.out.println();
		System.out.println("-----------------PART 3-------------------");
		MakeAccountlP acc1p = new MakeAccountlP(100,"secret");
		acc1p.view("secret");
		acc1p.withdraw("secret", 40);
		acc1p.deposit("rosebud", 55);
		acc1p.show("secret");
		
		System.out.println();
		System.out.println("-----------------PART 4-------------------");
		MakeAccountlPA acc1pa = new MakeAccountlPA(100, "secret");
		acc1pa.withdraw("secret", 60);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("rosebud", 55);
		acc1pa.withdraw("secret", 60);

		System.out.println();
		System.out.println("-----------------PART 5-------------------");
		MakeAccountlPAT fromAcc = new MakeAccountlPAT(300, "secret");
		MakeAccountlPAT toAcc = new MakeAccountlPAT(200, "rosebud");
		fromAcc.transfer("secret", toAcc, "secret");
		fromAcc.show("secret");
		fromAcc.transfer("secret", toAcc, "rosebud");
		fromAcc.show("secret");
		toAcc.show("rosebud");
	
		System.out.println();
		System.out.println("-----------------PART 6-------------------");
		MakeAccountlPATS sav = new MakeAccountlPATS(100, "rosebud", 0.05);
		sav.interest("bananas");
		sav.interest("rosebud");
		sav.deposit("rosebud", 0);
	}
}