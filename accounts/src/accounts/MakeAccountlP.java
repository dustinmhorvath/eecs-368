package accounts;

public class MakeAccountlP extends MakeAccountl{

	String passwd;
	
	public MakeAccountlP(double dep, String pass) {
		super(dep);
		passwd = pass;
	}
	
	public void deposit(String pass, int dep){
		if(pass.equals(passwd)){
			current_bal += dep;
			System.out.println("Balance:" + current_bal);
			list = list.substring(0, list.length()-1);
			list = list + "(+ " + dep + " = " + current_bal + " ) )";
		}
		else{
			System.out.println("Incorrect Password");
		}
	}
	
	public void withdraw(String pass, int take){
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
			System.out.println("Incorrect Password");
		}
	}
	
	public void view(String pass){
		if(pass.equals(passwd)){
			System.out.println("Balance:" + current_bal);
		}
		else{
			System.out.println("Incorrect Password");
		}
	}
	
	public void show(String pass){
		if(pass.equals(passwd)){
			System.out.println("Ledger:" + list);
		}
		else{
			System.out.println("Incorrect Password");
		}
	}
}
