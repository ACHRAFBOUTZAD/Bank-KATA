package Bank_Kata;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        /* account.withdraw(3000); // This should fail if balance is insufficient */

        account.printStatement();
    }
}