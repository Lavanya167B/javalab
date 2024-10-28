import java.util.Scanner;

class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        deposit(interest);
        System.out.println("Interest credited: " + interest);
    }
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}

class CurAcct extends Account {
    private static final double MINIMUM_BALANCE = 1000.0;
    private static final double SERVICE_CHARGE = 50.0;

    public CurAcct(String customerName, String accountNumber) {
        super(customerName, accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
    public void displayBalance() {
         checkMinimumBalance();
        System.out.println("Current Balance: " + balance);
    }


    private void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Service charge applied. New Balance: " + balance);
        }
    }
}

public class Bank1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int accountType;

        do {
            System.out.println("Select Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Exit");
           
            accountType = scanner.nextInt();
           
            if (accountType == 1) {
                scanner.nextLine();
                System.out.print("Enter customer name for Savings Account: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter account number for Savings Account: ");
                String accountNumber = scanner.nextLine();
                System.out.print("Enter interest rate for Savings Account in percentage: ");
                double interestRate = scanner.nextDouble();
               
                SavAcct savingsAccount = new SavAcct(customerName, accountNumber, interestRate);
                manageSavingsAccount(scanner, savingsAccount);
               
            } else if (accountType == 2) {
                scanner.nextLine();  
                System.out.print("Enter customer name for Current Account: ");
                String customerName = scanner.nextLine();
                System.out.print("Enter account number for Current Account: ");
                String accountNumber = scanner.nextLine();
               
                CurAcct currentAccount = new CurAcct(customerName, accountNumber);
                manageCurrentAccount(scanner, currentAccount);
               
            } else if (accountType != 3) {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (accountType != 3);

        scanner.close();
    }

    private static void manageSavingsAccount(Scanner scanner, SavAcct savingsAccount) {
        int choice;

        do {
            System.out.println("\nSavings Account Operations:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest");
            System.out.println("4. Display Balance");
            System.out.println("5. Go Back");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount for Savings Account: ");
                    double savDeposit = scanner.nextDouble();
                    savingsAccount.deposit(savDeposit);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount for Savings Account: ");
                    double savWithdraw = scanner.nextDouble();
                    savingsAccount.withdraw(savWithdraw);
                    break;
                case 3:
                    savingsAccount.computeAndDepositInterest();
                    break;
                case 4:
                    savingsAccount.displayBalance();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    private static void manageCurrentAccount(Scanner scanner, CurAcct currentAccount) {
        int choice;

        do {
            System.out.println("\nCurrent Account Operations:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Go Back");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount for Current Account: ");
                    double curDeposit = scanner.nextDouble();
                    currentAccount.deposit(curDeposit);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount for Current Account: ");
                    double curWithdraw = scanner.nextDouble();
                    currentAccount.withdraw(curWithdraw);
                    break;
                case 3:
                    currentAccount.displayBalance();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }
}
