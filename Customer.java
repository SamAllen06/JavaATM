import java.util.*;

class Customer extends User{
	CheckingAccount checking = new CheckingAccount();
	SavingsAccount savings = new SavingsAccount();

	public static void main(String[] args){
		Customer cu = new Customer();
		cu.start();
	}//end main def

	public Customer(){
		this.userName = "";
		this.PIN = "";
	}//end constructor def

	public Customer(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	}//end Customer def

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String userChoice = menu();
			if (userChoice.equals("0")){
				System.out.println("Logging out. ");
				keepGoing = false;
			}//end if
			else if (userChoice.equals("1")){
				System.out.println("Opening Checking. ");
				checking.start();
			}//end else if
			else if (userChoice.equals("2")){
				System.out.println("Opening Savings. ");
				savings.start();
			}//end else if
			else if (userChoice.equals("3")){
				System.out.println("Changing PIN. ");
				changePIN();
			}//end else if
			else{
				System.out.println("I didn't get that, please try again. ");
			}//end else
		}//end while loop
	}//end start def

	public String menu(){
		System.out.println("0: Log-out \n1: Go to Checking \n2: Go to Savings \n3: Change PIN ");
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		return userChoice;
	}//end menu def

	public void changePIN(){
		System.out.print("What would you like your new PIN to be? ");
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		setPIN(userChoice);
	}//end changePIN def

	public String getReport(){
		String report = getUserName() + ", " + getPIN() + "\nChecking: " + checking.getBalanceString() + "\nSavings: " + savings.getBalanceString();
		return report;
	}//end getReport def
}//end class def
