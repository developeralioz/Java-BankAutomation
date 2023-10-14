public class ShortTerm extends Account {
    private static final double ANNUAL_INTEREST_RATE = 0.17;
    private static final int MINIMUM_BALANCE = 1000;

    public ShortTerm(int id, int balance) {
        super(id, balance);
    }

    @Override
    public double getBenefit() {
        return ANNUAL_INTEREST_RATE / 365 * getBalance();
    }

    public static double getAnnualInterestRate() {
        return ANNUAL_INTEREST_RATE;
    }

    public static int getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
}