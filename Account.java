public abstract class Account {
    private int id;
    private int balance;

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public abstract double getBenefit();

    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " TL deposited to account " + id);
    }

    public boolean withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Not enough balance in account " + id + " to withdraw " + amount + " TL");
            return false;
        }
        balance -= amount;
        System.out.println(amount + " TL withdrawn from account " + id);
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}