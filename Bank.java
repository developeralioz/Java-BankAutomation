import java.time.LocalDate;
import java.util.*;

public class Bank {
    private final Map<Integer, Account> accounts;
    private LocalDate date;

    public Bank() {
        accounts = new HashMap<>();
        date = LocalDate.of(2023, 5, 5);
    }

    public void createShortTermAccount(int id, int balance) {
        if (balance < ShortTerm.getMinimumBalance()) {
            System.out.println("Short term account must have at least " + ShortTerm.getMinimumBalance() + " TL balance");
            return;
        }
        accounts.put(id, new ShortTerm(id, balance));
        System.out.println("Short term account with ID " + id + " has been created with " + balance + " TL balance");
    }

    public void createLongTermAccount(int id, int balance) {
        if (balance < LongTerm.getMinimumBalance()) {
            System.out.println("Long term account must have at least " + LongTerm.getMinimumBalance() + " TL balance");
            return;
        }
        accounts.put(id, new LongTerm(id, balance));
        System.out.println("Long term account with ID " + id + " has been created with " + balance + " TL balance");
    }

    public void createSpecialAccount(int id, int balance) {
        if (balance < id) {
            System.out.println("Special account must have at least " + id + " TL balance");
            return;
        }
        accounts.put(id, new Special(id, balance));
        System.out.println("Special account with ID " + id + " has been created with " + balance + " TL balance");
    }

    public void createCurrentAccount(int id, int balance) {
        accounts.put(id, new Current(id, balance));
        System.out.println("Current account with ID " + id + " has been created with " + balance + " TL balance");
    }

    public void increaseBalance(int id, int amount) {
        Account account = accounts.get(id);
        if (account == null) {
            System.out.println("No account found with ID " + id);
            return;
        }
        account.deposit(amount);
    }

    public void decreaseBalance(int id, int amount) {
        Account account = accounts.get(id);
        if (account == null) {
            System.out.println("No account found with ID " + id);
            return;
        }
        account.withdraw(amount);
    }

    public void setSystemDate(LocalDate date) {
        this.date = date;
        System.out.println("System date has been set to " + date.toString());
    }

    public void showAccounts() {
        System.out.println("ID\t\tType\t\tBalance\t\tBenefit");
        System.out.println("--\t\t----\t\t-------\t\t------");
        for (Account account : accounts.values()) {
            String type = account instanceof ShortTerm ? "Short Term" :
                    account instanceof LongTerm ? "Long Term" :
                            account instanceof Special ? "Special" : "Current";
            System.out.printf("%d\t\t%s\t\t%d\t\t%.2f TL\n", account.getId(), type, account.getBalance(), account.getBenefit());
        }
    }

    public void showIds() {
        List<Integer> ids = new ArrayList<>(accounts.keySet());
        Collections.sort(ids);
        System.out.println("Account IDs:");
        for (int id : ids) {
            System.out.println(id);
        }
    }

    public void sortition() {
        Map<Integer, Integer> points = new HashMap<>();
        for (Account account : accounts.values()) {
            if (account instanceof Special) {
                points.put(account.getId(), account.getBalance() / 2000);
            }
        }
        if (points.isEmpty()) {
            System.out.println("No special accounts found");
            return;
        }
        int totalPoints = points.values().stream().mapToInt(Integer::intValue).sum();
        Random random = new Random();
        int winningPoint = random.nextInt(totalPoints) + 1;
        int cumulativePoints = 0;
        int winningId = 0;
        for (Map.Entry<Integer, Integer> entry : points.entrySet()) {
            cumulativePoints += entry.getValue();
            if (cumulativePoints >= winningPoint) {
                winningId = entry.getKey();
                break;
            }
        }
        Account account = accounts.get(winningId);
        account.deposit(10000);
        System.out.println("Special account with ID " + winningId + " has won 10000 TL");
    }

    public boolean isBefore(LocalDate otherDate) {
        return date.isBefore(otherDate);
    }

    public LocalDate getDate() {
        return date;
    }
}