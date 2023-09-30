package atmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckBalance {
    private static double balance;
    
    // Constructor, getters, setters, and other methods
    
    public static void checkBalance() {
        String csvFile = "transactions.csv";
        String line;
        double totalDeposits = 0.0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Split the line by commas to extract the transaction details
                String[] transaction = line.split(",");
                
                // Assuming the transaction format is: [date],[amount],[type]
                // Check if the transaction is a deposit
                if (transaction.length == 3 && transaction[2].equalsIgnoreCase("deposit")) {
                    double depositAmount = Double.parseDouble(transaction[1]);
                    totalDeposits += depositAmount;
                }
            }
            
            double balance = getTotalBalance() + totalDeposits;
            System.out.println("Total balance: " + balance);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static double getTotalBalance() {
        // Retrieve the initial balance from wherever it is stored (e.g., database)
        return balance;
    }
    
    // Other methods for updating balance, etc.
}

