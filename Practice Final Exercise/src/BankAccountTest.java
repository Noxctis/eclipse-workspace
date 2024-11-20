import java.util.Scanner;

abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
        System.out.println("Deposited " + amount + " with interest to Savings Account. New balance: " + balance);
    }

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

class CurrentAccount extends BankAccount {
    private double overdraftLimit;
    private double overdraftFee;

    public CurrentAccount(double balance, double overdraftLimit, double overdraftFee) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " to Current Account. New balance: " + balance);
    }

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
