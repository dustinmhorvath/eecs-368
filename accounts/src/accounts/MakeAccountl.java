package accounts;


public class MakeAccountl extends MakeAccount{
	String list;
	
	public MakeAccountl(double dep){
		super(dep);
		list = "'( (start = " + dep + " ) )";
	}

	public void deposit(int dep){
		current_bal += dep;
		System.out.println("Balance:" + current_bal);
		list = list.substring(0, list.length()-1);
		list = list + "(+ " + dep + " = " + current_bal + " ) )";
	}
	
	public void withdraw(int take){
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
