package atmachine;
import java.math.BigDecimal;
import java.util.Scanner;

public class Withdraw{
    private static String accountNumber;
    private static BigDecimal withdrawalCharge;

    // Constructor and other methods

    public static void cashOut() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the amount to be withdrawn: ");
            BigDecimal amountToWithdraw = scanner.nextBigDecimal();

            subtractWithdrawalChargeFromBalance(accountNumber, amountToWithdraw.add(withdrawalCharge));
        }
        System.out.println("Withdrawal successful!");
    }

    // Other methods
    
    private static void subtractWithdrawalChargeFromBalance(String accountNumber, BigDecimal withdrawalAmount) {
        // Retrieve the account balance from wherever it is stored (e.g., database)
        BigDecimal currentBalance = getAccountBalance(accountNumber);
        
        // Subtract the withdrawal amount and withdrawal charge from the current balance
        BigDecimal updatedBalance = currentBalance.subtract(withdrawalAmount);
        
        // Update the account balance in the database or wherever it is stored
        updateAccountBalance(accountNumber, updatedBalance);
    }

    private static BigDecimal getAccountBalance(String accountNumber) {

        return withdrawalCharge;
        // Retrieve the account balance from wherever it is stored (e.g., database)
        // Return the balance as a BigDecimal object
    }

    private static void updateAccountBalance(String accountNumber, BigDecimal updatedBalance) {
        // Update the account balance in the database or wherever it is stored
    }
}
