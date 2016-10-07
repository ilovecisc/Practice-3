package Account;
import java.util.Date;

import Exception.InsufficientFundsException;
public class Account {
	private int id=0;
	private double balance=0;
	private double annualInterestRate=0;
	private Date dateCreated;
	
	public Account(int id, double balance, double annualInterestRate){
		this.id=id;
		this.balance=balance;
		this.annualInterestRate=annualInterestRate;
		this.dateCreated=dateCreated;	
	}
	public int getID() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		return annualInterestRate/12;
	}
	public void deposit(double amount)
	   {
	      balance += amount;
	}
	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount <= balance)
	      {
	         balance -= amount;
	      }
	      else
	      {
	         double needs = amount - balance;
	         throw new InsufficientFundsException(needs);
	      }
	}
}
