import java.util.Scanner;
/**
 * Abstract class representing a bank account.
 */
abstract class BankAccount {
    protected double balance;

    /**
     * Constructor to initialize the balance of the bank account.
     * 
     * @param balance Initial balance of the bank account.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Gets the current balance of the bank account.
     * 
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Abstract method to deposit an amount into the bank account.
     * 
     * @param amount The amount to deposit.
     */
    public abstract void deposit(double amount);

    /**
     * Abstract method to withdraw an amount from the bank account.
     * 
     * @param amount The amount to withdraw.
     */
    public abstract void withdraw(double amount);
}

/**
 * Class representing a savings account.
 */
class SavingsAccount extends BankAccount {
    private double interestRate;

    /**
     * Constructor to initialize the balance and interest rate of the savings account.
     * 
     * @param balance Initial balance of the savings account.
     * @param interestRate Interest rate for the savings account.
     */
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Deposits an amount into the savings account and adds interest.
     * 
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
        System.out.println("Deposited " + amount + " with interest to Savings Account. New balance: " + balance);
    }

    /**
     * Withdraws an amount from the savings account if sufficient balance is available.
     * 
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }
}

/**
 * Class representing a current account.
 */
class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    private double overdraftFee;

    /**
     * Constructor to initialize the balance, overdraft limit, and overdraft fee of the current account.
     * 
     * @param balance Initial balance of the current account.
     * @param overdraftLimit Overdraft limit for the current account.
     * @param overdraftFee Overdraft fee for the current account.
     */
    public CurrentAccount(double balance, double overdraftLimit, double overdraftFee) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    /**
     * Deposits an amount into the current account.
     * 
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " to Current Account. New balance: " + balance);
    }

    /**
     * Withdraws an amount from the current account if sufficient balance or overdraft limit is available.
     * 
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Current Account. New balance: " + balance);
        } else if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Current Account using overdraft. New balance: " + balance);
        } else {
            balance -= overdraftFee;
            System.out.println("Overdraft limit exceeded in Current Account. Overdraft fee applied. New balance: " + balance);
        }
    }
}

/**
 * Class to test the functionality of BankAccount, SavingsAccount, and CurrentAccount.
 */
public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavingsAccount savings = new SavingsAccount(1000, 5);
        CurrentAccount current = new CurrentAccount(1000, 500, 50);

        while (true) {
            System.out.println("Choose account type: 1 for Savings, 2 for Current, 3 to Exit");
            int accountType = scanner.nextInt();

            if (accountType == 3) {
                System.out.println("Exiting...");
                break;
            }

            BankAccount account;
            if (accountType == 1) {
                account = savings;
            } else if (accountType == 2) {
                account = current;
            } else {
                System.out.println("Invalid account type. Please try again.");
                continue;
            }

            while (true) {
                System.out.println("Choose operation: 1 for Deposit, 2 for Withdraw, 3 for Balance, 4 to Switch Account");
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                    case 4:
                        System.out.println("Switching account...");
                        break;
                    default:
                        System.out.println("Invalid operation. Please try again.");
                }

                if (operation == 4) {
                    break;
                }
            }
        }

        scanner.close();
    }
}
