package accounts;

import java.util.*;


public class main {

	public static void main(String[] args) {

		MakeAccount acc = new MakeAccount(100);
		acc.view();
		acc.withdraw(50);
		acc.withdraw(60);
		acc.deposit(40);
		acc.withdraw(60);
		MakeAccount acc2 = new MakeAccount(0);
		acc2.deposit(17);
		
		MakeAccountl acc1 = new MakeAccountl(100);
		acc1.show();
		acc1.withdraw(40);
		acc1.deposit(55);
		acc1.show();
		
		MakeAccountlP acc1p = new MakeAccountlP(100,"secret");
		acc1p.view("secret");
		acc1p.withdraw("secret", 40);
		acc1p.deposit("rosebud", 55);
		acc1p.show("secret");
		
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
	}

}
