package chapter01.javaprimer;

public class CreditCard {

    // Instances variables
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    // Constructors
    public CreditCard(String customer, String bank, String account, int limit) {
        this(customer,bank, account, limit, 0.0 );   // use balance of zero as default
    }

    public CreditCard(String customer, String bank, String account, int limit, double initialBal) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = initialBal;
    }

    // Accessor methods
    public String getCustomer() {
        return customer;
    }
    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }
    // Updates methods
    public boolean charge( double price ) {    // make a charge
        if( price + balance > limit) {          // if charge would surpass limit
            return false;                       // refuse charge
        }
        // at this point, the charge is successful
        balance += price;                       // update the balance
        return true;                            // announce the good news
    }

    // Processes customer payment that reduces balance
    public void makePayment(double amount) {   // make a payment
        balance -= amount;
    }

    // Utility method to print a card's information
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }

    // main
    public static void main(String[] args) {

        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("Ion Sageata", "Chicago Savings", "5000 6444 7777 9879", 20000);
        wallet[1] = new CreditCard("Ion Perimetru", "Federal Reserve", "1000 1234 7777 1111", 10000);
        wallet[2] = new CreditCard("Ion Butoi", "San-Diego Federal", "9000 8777 7777 9879", 20000, 7700.0);

        for(int val = 1; val <= 10; val++) {
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }

        for(CreditCard card: wallet) {
            CreditCard.printSummary(card);   // calling static method;
            while(card.getBalance() > 2000.0) {
                card.makePayment(2000.0);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }
}
