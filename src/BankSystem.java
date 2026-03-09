import java.util.Scanner;

class BankAccount {

    String name;
    int accountNumber;
    double balance;

    BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful.");
    }

    void withdraw(double amount) {

        if(amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }

    }

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

}

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        BankAccount account = new BankAccount(name, accNo, 0);

        int choice;

        do {

            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the banking system.");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while(choice != 4);

        sc.close();
    }
}