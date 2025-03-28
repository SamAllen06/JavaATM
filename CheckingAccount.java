import java.util.*;
import java.io.*;

public class CheckingAccount implements Serializable{
	double balance = 0d;
	
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
				System.out.println(getBalanceString());
			}//end else if
			else if (userChoice.equals("2")){
				System.out.println("Deposit money");
				makeDeposit();
			}//end else if
			else if (userChoice.equals("3")){
				System.out.println("Withdraw money");
				makeWithdrawal();
			}//end else if
			else{
				System.out.println("I didn't understand that. Try again");
			}//end else
		}//end while loop
	}//end start definition

	public double getBalance(){
		return this.balance;
	}//end getBalance def

	public String getBalanceString(){
		//String strBalance = String.valueOf(this.balance);
		String formattedStrBalance = String.format("$%.02f", this.balance);
		return formattedStrBalance;
	}//end getBalanceString def

	public void setBalance(double balance){
		this.balance = balance;
	}//end setBalance def

	public void checkBalance(){
		System.out.println(getBalanceString());
	}//end checkBalance def

	public double getDouble(){
		boolean keepGoing = true;
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		double userDouble = 0d;
		while (keepGoing){
			try{
				userDouble = Double.parseDouble(userInput);
				keepGoing = false;
			}//end try
			catch(NumberFormatException e){
				System.out.println("Invalid input. Try again.");
			}//end catch
		}//end while loop
		return userDouble;
	}//end getDouble def

	public void makeDeposit(){
		System.out.print("How much would you like to deposit? ");
		double depositDouble = getDouble();
		this.balance = depositDouble + this.balance;
	}//end makeDeposit def

	public void makeWithdrawal(){
		System.out.print("How much would you like to withdraw? ");
		double withdrawalDouble = getDouble();
		if (withdrawalDouble > this.balance){
			System.out.println("You can't withdraw more money than what's in your account. ");
		}//end if
		else{
			this.balance = this.balance - withdrawalDouble;
		}//end else
	}//end makeWithdrawal def

}//end CheckingAccount def
