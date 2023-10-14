public class Current extends Account {
    public Current(int id, int balance) {
        super(id, balance);
    }

    @Override
    public double getBenefit() {
        return 0;
    }
}