package accounts;

public class MakeAccountlPA extends MakeAccountlP{
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
