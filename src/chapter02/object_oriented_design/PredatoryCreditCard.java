package chapter02.object_oriented_design;

import chapter01.javaprimer.CreditCard;

public class PredatoryCreditCard  extends CreditCard {

    private double apr;  // annual percentage rate

    // Constructor for this class
    public PredatoryCreditCard(String customer, String bank, String account, int limit, double initialBal, double rate ) {
        super(customer, bank,account, limit, initialBal);
        this.apr = rate;
    }

    // A new method for assesssing monthly interest charges
    public void processMonth() {
        if(balance > 0) {                                        // only charge interest on a positive balance
            double monthlyFactor = Math.pow(1 + apr, 1.0/12);   // compute monthly rate
            balance *= monthlyFactor;                           // assess interest
        }
    }
    // Overriding the charge method defined in the superclass CreditCard
    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);    // call inherited method

        if(!isSuccess) {
            balance+= 5;                           // assess a 5$ penalty
        }
        return isSuccess;
    }

    // main
    public static void main(String[] args) {

        // dynamic method dispatch
        CreditCard card = new PredatoryCreditCard("Ana Popescu", "Bank of Malta", "2424 7888 9000 1111", 20000, 50, 0.055);     // Liskov Substitution Principle
        card.charge(400);      // charge card
        CreditCard.printSummary(card);

        if(card instanceof  PredatoryCreditCard predatoryCard) {
            predatoryCard.processMonth();
        }
        CreditCard.printSummary(card);

        card.makePayment(6500);     // make payment
        CreditCard.printSummary(card);
    }
}
