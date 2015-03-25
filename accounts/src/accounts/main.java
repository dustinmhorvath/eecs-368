package accounts;



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
		acc1.show();
		acc1.withdraw(40);
		acc1.deposit(55);
		acc1.show();
		
/*		System.out.println();
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
	*/	
	}

}
