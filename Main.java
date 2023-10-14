import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1 - Create short term account");
            System.out.println("2 - Create long term account");
            System.out.println("3 - Create special account");
            System.out.println("4 - Create current account");
            System.out.println("5 - Increase account balance");
            System.out.println("6 - Decrease account balance");
            System.out.println("7 - Set system date");
            System.out.println("8 - Show accounts");
            System.out.println("9 - Show account IDs");
            System.out.println("10 - Special account sortition");
            System.out.println("0 - Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.println("Enter account ID:");
                    int shortTermId = scanner.nextInt();
                    System.out.println("Enter initial balance:");
                    int shortTermBalance = scanner.nextInt();
                    bank.createShortTermAccount(shortTermId, shortTermBalance);
                    break;
                case 2:
                    System.out.println("Enter account ID:");
                    int longTermId = scanner.nextInt();
                    System.out.println("Enter initial balance:");
                    int longTermBalance = scanner.nextInt();
                    bank.createLongTermAccount(longTermId, longTermBalance);
                    break;
                case 3:
                    System.out.println("Enter account ID:");
                    int specialId = scanner.nextInt();
                    System.out.println("Enter initial balance:");
                    int specialBalance = scanner.nextInt();
                    bank.createSpecialAccount(specialId, specialBalance);
                    break;
                case 4:
                    System.out.println("Enter account ID:");
                    int currentId = scanner.nextInt();
                    System.out.println("Enter initial balance:");
                    int currentBalance = scanner.nextInt();
                    bank.createCurrentAccount(currentId, currentBalance);
                    break;
                case 5:
                    System.out.println("Enter account ID:");
                    int increaseId = scanner.nextInt();
                    System.out.println("Enter amount to deposit:");
                    int increaseAmount = scanner.nextInt();
                    bank.increaseBalance(increaseId, increaseAmount);
                    break;
                case 6:
                    System.out.println("Enter account ID:");
                    int decreaseId = scanner.nextInt();
                    System.out.println("Enter amount to withdraw:");
                    int decreaseAmount = scanner.nextInt();
                    bank.decreaseBalance(decreaseId, decreaseAmount);
                    break;
                case 7:
                    System.out.println("Enter system date in YYYY-MM-DD format:");
                    LocalDate date = LocalDate.parse(scanner.next());
                    if (bank.isBefore(date)) {
                        bank.setSystemDate(date);
                    } else {
                        System.out.println("New date must be after current date (" + bank.getDate().toString() + ")");
                    }
                    break;
                case 8:
                    bank.showAccounts();
                    break;
                case 9:
                    bank.showIds();
                    break;
                case 10:
                    bank.sortition();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}