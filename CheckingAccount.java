import java.util.*;

public class CheckingAccount{
	double balance;
	
	public static void main(String[] args){
		CheckingAccount ca = new CheckingAccount();
		ca.start();
	}//end menu def

	public CheckingAccount(){
		this.balance = 0d;
	}//end constructor w/o parameters

	public CheckingAccount(double balance){
		this.balance = balance;
	}//end constructor with parameters
		
	public String menu(){
		System.out.println("Would you like to: \n 0: Exit \n 1: View Current Balance \n 2: Deposit money \n 3: Withdraw money ");
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		return userChoice;
	}//end menu def

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String userChoice = menu();
			if (userChoice.equals("0")){
				System.out.println("Goodbye!");
				keepGoing = false;
			}//end if
			else if (userChoice.equals("1")){
				System.out.println("Showing balance");
				//System.out.println(getBalanceString);
			}//end else if
			else if (userChoice.equals("2")){
				System.out.println("Deposit money");
				//makeDeposit();
			}//end else if
			else if (userChoice.equals("3")){
				System.out.println("Withdraw money");
			}//end else if
			else{
				System.out.println("I didn't understand that. Try again");
			}//end else
		}//end while loop
	}//end start definition

	public double getBalance(){
	
	}//end getBalance def

	public String getBalanceString(){
		
	}//end getBalanceString def

	public void setBalance(double balance){

	}//end setBalance def

	public void checkBalance(){

	}//end checkBalance def

	private double getDouble(){

	}//end getDouble def

	public void makeDeposit(){

	}//end makeDeposit def

	public void makeWithdrawal(){

	}//end makeWithdrawal def

}//end CheckingAccount def
