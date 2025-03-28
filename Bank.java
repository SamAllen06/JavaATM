import java.util.*;
import java.io.*;

class Bank implements Serializable{
	Admin admin = new Admin();
	CustomerArrayList customers = new CustomerArrayList();
	
	public Bank(){
	//loadSampleCustomers();
	//saveCustomers();
	loadCustomers();
	start();
	saveCustomers();
	}//end constructor

	public static void main(String[] args){
		Bank bank = new Bank();
	}//end main def

	public void saveCustomers(){
		try{
			FileOutputStream fileOut = new FileOutputStream("CustomerArray.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(customers);
			objectOut.close();
			fileOut.close();
		}//end try
		catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}//end catch
	}//end saveCustomers def

	public void loadCustomers(){
		try{
			FileInputStream fileIn = new FileInputStream("CustomerArray.dat");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			//customers = (ArrayList<Customer>)objectIn.readObject();
			customers = (CustomerArrayList)objectIn.readObject();
			objectIn.close();
			fileIn.close();
		}//end try
		catch(Exception e){
			System.out.println("Error:" + e.getMessage());
		}//end catch
	}//end loadCustomers def

	public String menu(){
		System.out.println("Bank menu: ");
		System.out.println("0) Exit");
		System.out.println("1) Log-in as customer");
		System.out.println("2) Log-in as admin");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		return response;
	}//end menu def

	public void start(){
		boolean keepGoing = true;
		admin.Admin();
		
		while (keepGoing){
			String response = menu();
			if (response.equals("0")){
				keepGoing = false;
				System.out.println("Goodbye...");
			}//end if
			else if (response.equals("1")){
				System.out.println("Logging in as customer...");
				loginAsCustomer();
			}//end else if
			else if (response.equals("2")){
				System.out.println("Logging in as admin...");
				boolean isLogin = admin.login();
				if (isLogin){
					startAdmin();
				}//end if
			}//end else if
			else{
				System.out.println("Invalid input. ");
			}//end else
		}//end while loop
	}//end start def

	public void startAdmin(){
		boolean keepGoing = true;
		
		while (keepGoing){
			String response = admin.menu();
			if (response.equals("0")){
				keepGoing = false;
				System.out.println("Exiting admin. ");
			}//end if
			else if (response.equals("1")){
				fullCustomerReport();
			}//end else if
			else if (response.equals("2")){
				addUser();
			}//end else if
			else if (response.equals("3")){
				applyInterest();
			}//end else if
			else if (response.equals("4")){
				setInterest();
			}//end else if
			else{
				System.out.println("Invalid input. ");
				keepGoing = false;
			}//end else
		}//end while loop
	}//end startAdmin

	public void setInterest(){
		for (Customer customer: customers){
			System.out.print("What would you like the interest rate for " + customer.getUserName() + " to be? ");
			double response = customer.checking.getDouble();
			customer.savings.setInterestRate(response);
		}//end for loop
	}//end setInterest

	public void loadSampleCustomers(){
		Customer albert = new Customer();
		Customer bertie = new Customer();
		Customer carrie = new Customer();
		albert.setUserName("Albert");
		albert.setPIN("1111");
		albert.savings.setBalance(1000);
		albert.checking.setBalance(125);
		bertie.setUserName("Bertie");
		bertie.setPIN("2222");
		carrie.setUserName("Carrie");
		carrie.setPIN("3333");
		customers.add(albert);
		customers.add(bertie);
		customers.add(carrie);
	}//end loadSampleCustomers def

	public void loginAsCustomer(){
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String tempUsername = input.nextLine();
		System.out.print("PIN: ");
		String tempPIN = input.nextLine();

		Customer currentCustomer = new Customer();
		currentCustomer = null;

		boolean isLogin = false;

		for (Customer customer: customers){
			isLogin = customer.login(tempUsername, tempPIN);
			if (isLogin){
				currentCustomer = customer;
			}//end if statement
		}//end for loop
		if (currentCustomer != null){
			currentCustomer.start();
		}//end if 
		else{
			System.out.println("I couldn't find an existing user with that Username or PIN, sorry. ");
		}//end else
	}//end loginAsCustomer def
	
	public void fullCustomerReport(){
		for (Customer customer: customers){
			System.out.println(customer.getReport());
		}//end for loop
	}//end fullCustomerReport def

	public void addUser(){
		Scanner input = new Scanner(System.in);
		System.out.print("What would you like your username to be? ");
		String newUsername = input.nextLine();
		System.out.print("What would you like your PIN to be? ");
		String newPIN = input.nextLine();
		
		Customer newCustomer = new Customer();
		customers.add(newCustomer);
		newCustomer.setUserName(newUsername);
		newCustomer.setPIN(newPIN);
	}//end addUser def

	public void applyInterest(){
		for (Customer customer: customers){
			customer.savings.calcInterest();
		}//end for loop
	}//end applyInterest def
}//end bank def


class CustomerArrayList extends ArrayList<Customer> implements Serializable{
	private static long serialVersionUID = 1L;
}//end CustomerArrayList def

