import java.util.*;

class Bank{
	Admin admin = new Admin();
	ArrayList<Customer> customers = new ArrayList();
	//CustomerArrayList customers = new CustomerArrayList();
	//CustomerArrayList();

	public static void main(String[] args){
		Bank bank = new Bank();
		bank.start();
	}//end main def

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

		loadSampleCustomers();
		fullCustomerReport();
		
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
			}//end else if
			else{
				System.out.println("Invalid input. ");
			}//end else
		}//end while loop
	}//end start def

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

/*
class CustomerArrayList{
	ArrayList<Customer> customers = new ArrayList();
}//end CustomerArrayList def
*/
