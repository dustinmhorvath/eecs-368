package accounts;

public class MakeAccountlPATS extends MakeAccountlPAT{
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
