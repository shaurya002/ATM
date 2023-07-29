import java.util.*;

public class ATM {

	public static void main(String[] args) {
		ATMop atm = new ATMop();
	}
}

class Data{
	float balance;
}

class ATMop{
	Scanner s = new Scanner(System.in);
	HashMap<Integer,Data> hMap = new HashMap<>();
	
	ATMop(){
		System.out.println("************************************************");
		System.out.println("Wellcome to ATM");
		another_account();
	}
	
	public void another_account() {
		System.out.println("************************************************");
		System.out.println("Enter your pin code");
		int pinCode = s.nextInt();
		
		if(hMap.containsKey(pinCode)) {
			Data obj = hMap.get(pinCode);
			menu(obj);
		}else {
			System.out.println("************************************************");
			System.out.println("Please create your account first");
			System.out.println("Set your pin code");
			int pin = s.nextInt();
			Data obj = new Data();
			
			hMap.put(pin, obj);
			menu(obj);
		}
	}
	
	public void menu(Data obj) {
		System.out.println("Please Enter the valid number");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit Balance");
		System.out.println("3. Withdraw Balance");
		System.out.println("4. Check Another Account");
		System.out.println("5. Exit");
		
		int x = s.nextInt();
		switch(x) {
		case 1:
			check_bal(obj);
			break;
		case 2:
			deposit_bal(obj);
			break;
		case 3:
			withdraw_bal(obj);
			break;
		case 4:
			another_account();
			break;
		case 5:
			System.out.println("Thank You!");
			System.out.println("Visit us Again");
			break;
		default:
			System.out.println("Please enter a valid number: ");
			menu(obj);
			break;
		}
	}

	public void withdraw_bal(Data obj) {
		System.out.println("************************************************");
		System.out.print("Enter your Amount: ");
		float a = s.nextFloat();
		if(obj.balance>=a) {
			obj.balance-=a;
			System.out.println("Amount withdraw sucessfully!!");
		}else {
			System.out.println("Insufficient Balance");
		}
		System.out.println("************************************************");
		menu(obj);
	}

	public void deposit_bal(Data obj) {
		System.out.println("************************************************");
		System.out.print("Enter your Amount: ");
		float a = s.nextFloat();
		obj.balance+=a;
		System.out.println("Amount deposited sucessfully!!");
		System.out.println("************************************************");
		menu(obj);
	}

	public void check_bal(Data obj) {
		System.out.println("************************************************");
		System.out.println("==> Your Balance: "+ obj.balance+" <==");
		System.out.println("************************************************");
		menu(obj);
	}
}
