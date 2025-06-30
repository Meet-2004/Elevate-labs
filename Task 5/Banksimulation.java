import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Show transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        displayBalance();
    }
}

public class Banksimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an account
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Initial Balance:");
        double initialBalance = sc.nextDouble();

        Account myAccount = new Account(name, accNo, initialBalance);

        int choice;
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Account Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    myAccount.displayBalance();
                    break;

                case 4:
                    myAccount.showTransactionHistory();
                    break;

                case 5:
                    myAccount.displayAccountDetails();
                    break;

                case 0:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
