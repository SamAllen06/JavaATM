import java.util.*;

class Bank{
	Admin admin = new Admin();
	ArrayList<Customer> customers = new ArrayList();

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
		}//end while loop
	}//end start def

	public void loginAsCustomer(){
		Scanner input = new Scanner(System.in);
		System.out.print("Username: ");
		String tempUsername = input.nextLine();
		System.out.print("PIN: ");
		String tempPIN = input.nextLine();
		currentCustomer = null;

		for (Customer customer: customers){
			boolean isLogin = customer.login(tempUsername, tempPIN);
			
			if (isLogin = true){
				currentCustomer = customer;
			}//end if statement
		}//end for loop
	}//end loginAsCustomer def

}//end bank def
