public class Special extends Account {
    private static final double ANNUAL_INTEREST_RATE = 0.12;
    private final int minimumBalance;

    public Special(int id, int balance) {
        super(id, balance);
        minimumBalance = balance;
    }

    @Override
    public double getBenefit() {
        return ANNUAL_INTEREST_RATE / 365 * getBalance();
    }

    public static double getAnnualInterestRate() {
        return ANNUAL_INTEREST_RATE;
    }

    public int getMinimumBalance() {
        return minimumBalance;
    }
}