package atmachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transfer {
    private static final String TRANSACTIONS_FILE = "transactions.csv";

    private String senderAccountNumber;
    private String recipientAccountNumber;
    private BigDecimal amount;
    private BigDecimal transferCharge;
    private LocalDateTime timestamp;

    public Transfer(String senderAccountNumber, String recipientAccountNumber, BigDecimal amount) {
        this.senderAccountNumber = senderAccountNumber;
        this.recipientAccountNumber = recipientAccountNumber;
        this.amount = amount;
        this.transferCharge = calculateTransferCharge();
        this.timestamp = LocalDateTime.now();
    }

    public void processTransfer() {
        subtractTransferChargeFromBalance();
        recordTransferTransaction();
        System.out.println("Transfer successful!");
    }
    
    private BigDecimal calculateTransferCharge() {
        BigDecimal chargePercentage = new BigDecimal("0.03"); // 3% charge
        return amount.multiply(chargePercentage);
    }

    private void subtractTransferChargeFromBalance() {
        // logic to subtract the transfer charge from the sender's balance
        // Implementation will depend on the overall structure of your program
        // e.g., you might have a BankAccount class with a balance field and methods for updating the balance.
    }

    private void recordTransferTransaction() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            String transaction = String.join(",", senderAccountNumber, recipientAccountNumber,
                    amount.toString(), transferCharge.toString(), timestamp.format(DateTimeFormatter.ISO_DATE_TIME));
            writer.write(transaction);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void transfer() {
    }

    // Getters and setters for senderAccountNumber, recipientAccountNumber, amount, transferCharge, timestamp
    // ...
}
