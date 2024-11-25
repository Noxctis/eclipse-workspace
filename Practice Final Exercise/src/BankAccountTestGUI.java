import javax.swing.*;

/**
 * Abstract class representing a bank account.
 */
abstract class BankAccount {
    protected double balance;

    /**
     * Constructor to initialize the balance.
     * 
     * @param balance Initial balance of the account.
     */
    public BankAccount(double balance) {
        this.balance = balance;
    }

    /**
     * Method to get the current balance.
     * 
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Abstract method for depositing money.
     * 
     * @param amount The amount to deposit.
     */
    public abstract void deposit(double amount);

    /**
     * Abstract method for withdrawing money.
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
     * Constructor to initialize the balance and interest rate.
     * 
     * @param balance Initial balance of the account.
     * @param interestRate Interest rate for the savings account.
     */
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    /**
     * Method to deposit money with interest.
     * 
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        balance += amount + (amount * interestRate / 100);
        JOptionPane.showMessageDialog(null, "Deposited " + amount + " with interest to Savings Account.\nNew balance: " + balance);
    }

    /**
     * Method to withdraw money.
     * 
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrew " + amount + " from Savings Account.\nNew balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient balance in Savings Account.");
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
     * Constructor to initialize the balance, overdraft limit, and overdraft fee.
     * 
     * @param balance Initial balance of the account.
     * @param overdraftLimit Overdraft limit for the current account.
     * @param overdraftFee Overdraft fee for exceeding the overdraft limit.
     */
    public CurrentAccount(double balance, double overdraftLimit, double overdraftFee) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    /**
     * Method to deposit money.
     * 
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) {
        balance += amount;
        JOptionPane.showMessageDialog(null, "Deposited " + amount + " to Current Account.\nNew balance: " + balance);
    }

    /**
     * Method to withdraw money.
     * 
     * @param amount The amount to withdraw.
     */
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrew " + amount + " from Current Account.\nNew balance: " + balance);
        } else if (balance + overdraftLimit >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrew " + amount + " from Current Account using overdraft.\nNew balance: " + balance);
        } else {
            balance -= overdraftFee;
            JOptionPane.showMessageDialog(null, "Overdraft limit exceeded in Current Account. Overdraft fee applied.\nNew balance: " + balance);
        }
    }
}

/**
 * Class to test the bank accounts using a GUI.
 */
public class BankAccountTestGUI {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1000, 5);
        CurrentAccount current = new CurrentAccount(1000, 500, 50);

        while (true) {
            String[] options = {"Savings", "Current", "Exit"};
            int accountType = JOptionPane.showOptionDialog(null, "Choose account type:", "Bank Account",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (accountType == 2) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            }

            BankAccount account;
            if (accountType == 0) {
                account = savings;
            } else if (accountType == 1) {
                account = current;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid account type. Please try again.");
                continue;
            }

            while (true) {
                String[] operations = {"Deposit", "Withdraw", "Balance", "Switch Account"};
                int operation = JOptionPane.showOptionDialog(null, "Choose operation:", "Bank Account",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operations, operations[0]);

                switch (operation) {
                    case 0:
                        String depositAmountStr = JOptionPane.showInputDialog("Enter amount to deposit:");
                        double depositAmount = Double.parseDouble(depositAmountStr);
                        account.deposit(depositAmount);
                        break;
                    case 1:
                        String withdrawAmountStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
                        double withdrawAmount = Double.parseDouble(withdrawAmountStr);
                        account.withdraw(withdrawAmount);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Current balance: " + account.getBalance());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Switching account...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid operation. Please try again.");
                }

                if (operation == 3) {
                    break;
                }
            }
        }
    }
}
