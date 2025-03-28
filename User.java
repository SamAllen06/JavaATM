import java.util.*;

abstract class User implements HasMenu{
	String userName = "";
	String PIN = "";
	
	boolean login(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("What's your username? ");
		String userName = input.nextLine();

		System.out.print("What's your 4-digit pin? ");
		String PIN = input.nextLine();

		System.out.println(this.userName + ", " + this.PIN);

		if (userName.equals(this.userName)){
			if (PIN.equals(this.PIN)){
				System.out.println("Login successful");
				return true;
			}//end if
			else{
				System.out.println("PIN wrong");
				return false;
			}//end else
		}//end if
		else{
			System.out.println("Username wrong");
			return false;
		}//end else
	}//end login constructor
	
	boolean login(String userName, String PIN){
		if (userName.equals(this.userName)){
			if (PIN.equals(this.PIN)){
				return true;
			}//end if
			else{
				return false;
			}//end else
		}//end if
		else{
			return false;
		}//end else
	}//end login def
	
	public void setUserName(String userName){
		this.userName = userName;
	}//end setUserName def
	
	public String getUserName(){
		return this.userName;
	}//end getUserName def
	
	public void setPIN(String PIN){
		this.PIN = PIN;

		//use String.matches("^\\d{4}$") for exception handler
	}//end setPin def
	
	public String getPIN(){
		return this.PIN;
	}//end getPin def

	abstract String getReport();
}//end User def
