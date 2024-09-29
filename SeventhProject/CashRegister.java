public class CashRegister {
    private int cashOnHand;

    /**
     * Default constructor. Sets the cash register to 500 cents.
     */
    public CashRegister() {
        this.cashOnHand = 500;
    }

    /**
     * Constructor with parameter. Sets the cash register to a custom amount.
     * @param cashIn Initial cash in the register
     */
    public CashRegister(int cashIn) {
        this.cashOnHand = cashIn;
    }

    /**
     * Shows the current balance in the cash register.
     * @return The current balance
     */
    public int getCurrentBalance() {
        return cashOnHand;
    }

    /**
     * Accepts the amount deposited by the customer.
     * @param amountIn The amount deposited by the customer
     */
    public void acceptAmount(int amountIn) {
        cashOnHand += amountIn;
    }
}
