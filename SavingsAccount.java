class SavingsAccount extends CheckingAccount{
	double interestRate = 0d;

	public static void main(String[] args){
		SavingsAccount sa = new SavingsAccount();
		sa.start();
	}//end main def

	public void setInterestRate(double interestRate){
		this.interestRate = interestRate;
	}//end setInterestRate def

	public double getInterestRate(){
		return this.interestRate;
	}//end getInterestRate def

	public void calcInterest(){
		this.balance = this.balance + (this.balance * this.interestRate);
	}//end calcInterest def
}//end class def
