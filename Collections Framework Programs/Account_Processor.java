package com.demo;

import java.util.*;
abstract class Account implements Comparable<Account>{
    String acc_no;
    double balance;	
    public Account(String no,double bal){
        acc_no = no; 
        balance = bal;
    }	
//Override "compareTo" method here
    @Override
    public int compareTo(Account obj1)
    {
    	Account ac1 = (Account) obj1;
    	if(balance==ac1.balance)
    	{
    		return 0;
    	}
    	else if(balance>ac1.balance)
    	{
    		return -1;
    	}
    	else
    	{
    		return 1;
    	}
    }

// Override "equals" method here
    public boolean equals(Object obj)
    {
    	Account obj1 = (Account)obj;
    	if(Integer.parseInt(this.acc_no)==obj1.hashCode())
    	{
    		//System.out.println("Equal Class");
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

// Override "hashCode" method here
    public int hashCode()
    {
    	return Integer.parseInt(acc_no);
    }
}
class SavingsAccount extends Account{
    public SavingsAccount(String acc_no, double bal) {
        // Complete the definition
    	super(acc_no,bal);
    }
    // Override the toString() method
    @Override
    public String toString()
    {
    	return "Savings Account:"+this.acc_no+" , "+"Balance:"+this.balance;
    }
}


class CurrentAccount extends Account{
    double overdraft_limit;
    public CurrentAccount(String acc_no, double bal, double odl) {
        // Complete the constructor definition}}
    	super(acc_no,bal);
    	this.overdraft_limit = odl;
    }
    // Override the toString() method}}
    @Override
    public String toString()
    {
    	return "Current Account:"+this.acc_no+" , "+"Balance:"+this.balance;
    }
}

public class Account_Processor {
     // Define the `accountProcessor' method here
	public static void accountProcessor(ArrayList<Account> acc)
	{
		LinkedHashSet<Account> acc_lhs = new LinkedHashSet<Account>();
		for(Account a:acc)
		{
			acc_lhs.add(a);
		}
		ArrayList<Account> acrr = new ArrayList<Account>(acc_lhs);
		Collections.sort(acrr);
		for(Account a:acrr)
		{
			System.out.println(a);
		}
	}

 public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        ArrayList<Account> acc = new ArrayList<Account>();
        
        //reading the number of savings accounts
        int s_acc_count = s.nextInt();
        for(int i=1;i<=s_acc_count;i++) {
            //reading acc no
            String no = s.next();
            //reading balance
            double bal = s.nextDouble();
            acc.add(new SavingsAccount(no,bal));
        }
        
        //reading the number of current accounts
        int c_acc_count = s.nextInt();
        for(int i=1;i<=c_acc_count;i++) {
            //reading acc no
            String no = s.next();
            //reading balance
            double bal = s.nextDouble();
            //reading overdraft limit
            double lim = s.nextDouble();
            acc.add(new CurrentAccount(no,bal,lim));
        }
        
        accountProcessor(acc);
        }
}