package bsu.comp152;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String name, int taxID){
           this.name = name;
           customerID = taxID;
           accounts = new ArrayList<BankAccount>();
        }

        public int getCustomerID(){
        return customerID;
        }
        public String getName(){
        return name;
        }

        public boolean openAccount(double initialDeposit){
            var newAccount = new BankAccount(initialDeposit, 0.04F);
            var success = accounts.add(newAccount);
            return success;
        }

        public BankAccount closeAccount(int accountID){
        BankAccount accountToClose = null;
            for (var account : accounts){
                if(account.getAccountID() ==accountID){
                    accountToClose = account;
                }
            }
            accounts.remove(accountToClose);
            return accountToClose;
        }

}
