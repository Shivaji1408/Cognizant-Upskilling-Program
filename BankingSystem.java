import java.util.*;

abstract class BankAccount{
    private int accountNumber;
    private String customerName;
    private double amount;

    public BankAccount(int accountNumber, String customerName, double amount){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    // getter setter for account
    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    // getter setter for CustomerName
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    // getter setter for Amount
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    // deposit and withdraw methods
    public void deposit(double money){
        amount = amount + money;
        System.out.println(amount + " is Deposited Succesful");
    }
    
    public void withdraw(double money){
        if(amount >= money){
            amount = amount - money;
            System.out.println(amount + " is Withdraw Successful");
        }else{
            System.out.println("Do not have enough amount to withdraw.");
        }
    }
    abstract void displayAccountInfo();

}


class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(int accountNumber, String customerName, double amount, double interestRate){
        super(accountNumber,customerName, amount);
        this.interestRate = interestRate;
    }
    @Override
    void displayAccountInfo(){
        System.out.println("/Saving Account");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Customer Name : " + getCustomerName());
        System.out.println("Account Balance :  " + getAmount());
        System.out.println("Interest :  " + interestRate + "%");
    }
}

class CurrentAccount extends BankAccount{
    private double overDraftLimit;
    public CurrentAccount(int accountNumber, String customerName, double amount, double overDraftLimit){
        super(accountNumber,customerName, amount);
        this.overDraftLimit = overDraftLimit;
    }
    @Override
    void displayAccountInfo(){
        System.out.println("/Saving Account");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Customer Name : " + getCustomerName());
        System.out.println("Account Balance :  " + getAmount());
        System.out.println("Over Draft Limit :  " + overDraftLimit);
    }
}

public class BankingSystem {
    public static void main(String args[]){
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount(101,"Rahul",10000, 5));
        accounts.add(new CurrentAccount(102,"Rajesh",65000, 8000));

        accounts.get(0).deposit(2000);
        accounts.get(1).withdraw(1000);

        for(BankAccount account : accounts){
            System.out.println("=====================================");
            account.displayAccountInfo();
        }
    }
}



// Cognizant Class PROJECT 2 case study