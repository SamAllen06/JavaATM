import java.util.*;

class Admin extends User{
	public void Admin(){
		this.setUserName("admin");
		this.setPIN("0000");
	}//end constructor
	
	public void start(){};

	public String menu(){
		System.out.print("Admin Menu: \n0) Exit \n1) Full customer report \n2) Add user \n3) Apply interest to savings accounts\n4) Set Interest Rate \nAction: ");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		return response;
	}// end menu def

	public String getReport(){
		String adminReport = getUserName() + ", " + getPIN();
		return adminReport;
	}//end getReport def

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

	
}//end class def
