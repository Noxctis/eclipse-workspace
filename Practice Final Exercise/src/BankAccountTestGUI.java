import javax.swing.*;

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
        JOptionPane.showMessageDialog(null, "Deposited " + amount + " with interest to Savings Account.\nNew balance: " + balance);
    }

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
        JOptionPane.showMessageDialog(null, "Deposited " + amount + " to Current Account.\nNew balance: " + balance);
    }

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
            JOptionPane.showMessageDialog(null, "Overdraft limit exceeded in Current Account.\nOverdraft fee applied.\nNew balance: " + balance);
        }
    }
}

public class BankAccountTestGUI {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(1000, 5);
        CurrentAccount current = new CurrentAccount(1000, 500, 50);

        while (true) {
            String[] accountOptions = {"Savings Account", "Current Account", "Exit"};
            int accountChoice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an account type:",
                    "Bank Account",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    accountOptions,
                    accountOptions[0]
            );

            if (accountChoice == 2 || accountChoice == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            }

            BankAccount account = (accountChoice == 0) ? savings : current;

            while (true) {
                String[] operationOptions = {"Deposit", "Withdraw", "Check Balance", "Switch Account"};
                int operationChoice = JOptionPane.showOptionDialog(
                        null,
                        "Choose an operation:",
                        "Bank Account - " + ((accountChoice == 0) ? "Savings" : "Current"),
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        operationOptions,
                        operationOptions[0]
                );

                if (operationChoice == 3 || operationChoice == JOptionPane.CLOSED_OPTION) {
                    break;
                }

                switch (operationChoice) {
                    case 0 -> {
                        String depositInput = JOptionPane.showInputDialog("Enter amount to deposit:");
                        if (depositInput != null) {
                            try {
                                double depositAmount = Double.parseDouble(depositInput);
                                account.deposit(depositAmount);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                            }
                        }
                    }
                    case 1 -> {
                        String withdrawInput = JOptionPane.showInputDialog("Enter amount to withdraw:");
                        if (withdrawInput != null) {
                            try {
                                double withdrawAmount = Double.parseDouble(withdrawInput);
                                account.withdraw(withdrawAmount);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                            }
                        }
                    }
                    case 2 -> JOptionPane.showMessageDialog(null, "Current balance: " + account.getBalance());
                    default -> JOptionPane.showMessageDialog(null, "Invalid operation. Please try again.");
                }
            }
        }
    }
}
