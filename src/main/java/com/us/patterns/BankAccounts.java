package com.us.patterns;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

class BankAccount{
	private String currency;
	private int units;
	public BankAccount(String currency, int units) {
		this.currency = currency;
		this.units = units;
	}
	
	public String getCurrency() {
		return currency;
	}
	public int getUnits() {
		return units;
	}
	public BankAccount getAccountType(){
		return this;
		
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public String getName() {
		if(this instanceof SavingsAccount) return "Savings";
		if(this instanceof CheckingAccount) return "Checking";
		return "Brokerage";
	}
}
public class BankAccounts {

	
	
	 private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

	 public static void main(String args[] ) throws Exception {

	        List<BankAccount> accounts = new ArrayList<BankAccount>();
	        accounts.add(new SavingsAccount("USD",3));//Savings
	        accounts.add(new SavingsAccount("EUR",2));//Savings
	        accounts.add(new CheckingAccount("HUF",100));//Checking
	        accounts.add(new CheckingAccount("COP",10000));//Checking
	        accounts.add(new BrokerageAccount("GBP",2));//Brokerage
	        accounts.add(new BrokerageAccount("INR",600));//Brokerage
	        
	        accounts.stream().forEach(
	                                    account -> System.out.println(
	                                        MessageFormat.format(TEXT,
	                                            new Object[]{
	                                            account.getAccountType().getName(),//make this work
	                                            account.getUnits(),//make this work
	                                            account.getCurrency()//make this work
	                                                           })));
	    }

}
class SavingsAccount extends BankAccount{
	public SavingsAccount(String currency, int units) {
		super(currency, units);
	}
}
class CheckingAccount extends BankAccount{
	public CheckingAccount(String currency, int units) {
		super(currency, units);
	}
}
class BrokerageAccount extends BankAccount{

	public BrokerageAccount(String currency, int units) {
		super(currency, units);
	}
}