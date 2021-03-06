package bsu.comp152;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;
    private Customer currentlySelectedCustomer;

    public Bank(){
        allCustomers = new ArrayList<Customer>();
        allAccounts = new ArrayList<BankAccount>();
    }

    private void printMenu(){
        System.out.println("What do you want to do next:");
        System.out.println("(select the number of the option)");
        System.out.println("[1] Add Customer");
        System.out.println("[2] Select Customer");
        System.out.println("[3] Add account for current Customer");
        System.out.println("[4] to Quit");
    }

    private void addCustomer(Scanner passedInputReader){
        passedInputReader.nextLine();//there is a trailing '\n' left over on input
        System.out.print("Enter new customer's nme:");
        var name = passedInputReader.nextLine();
        System.out.print("Enter the customer's Tax ID:");
        var ssn = passedInputReader.nextInt();
        currentlySelectedCustomer = new Customer(name, ssn);
        allCustomers.add(currentlySelectedCustomer);
        System.out.println("Created new currently selected customer with name "+
                currentlySelectedCustomer.getName() + " and taxId of "+
                currentlySelectedCustomer.getCustomerID());
    }

    private Optional<Customer> selectCustomer(int id){
        for(var customer: allCustomers){
            if(customer.getCustomerID() == id){
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    public void doBanking(){
        var inputReader = new Scanner(System.in);
        while(true){
            printMenu();
            var input = inputReader.nextInt();
            switch (input){
                case 0:
                case 1:
                    addCustomer(inputReader);
                    break;
                case 2:
                    System.out.print("Enter the id of the customer you want to select:");
                    var customerId = inputReader.nextInt();
                    var willthiswork = selectCustomer(customerId);
                    if(willthiswork.isPresent())
                        System.out.println("Selected customer "+ willthiswork.get().getName());
                    else
                        System.out.println("No such Customer");
                    break;
                case 3:
                    System.out.println("We haven't implemented that yet");
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("That is not an option");
            }
        }
    }
}
