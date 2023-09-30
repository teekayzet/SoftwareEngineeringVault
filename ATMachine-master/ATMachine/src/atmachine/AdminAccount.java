package atmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AdminAccount {
    private static final String ACCOUNTS_FILE = "accounts.csv";
    private static final String TRANSACTION_FILE = "transactions.csv";
    private static final String TEMP_FILE = "temp.csv";

    public static void runAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select an option:");
        System.out.println("1. View all account details");
        System.out.println("2. View transaction history");
        System.out.println("3. Edit account holder's details");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                viewAllAccountDetails();
                break;
            case 2:
                viewTransactionHistory();
                break;
            case 3:
                editAccountHolderDetails();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }

        scanner.close();
    }

    private static void viewAllAccountDetails() {
        // Code to view all account details...
        System.out.println("Account Details:");
        System.out.println("| Account Number | Full Name        | National ID   | Date of Birth | Occupation      | Address         |");

        try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                String accountNumber = accountData[0];
                String fullName = accountData[2];
                String nationalId = accountData[3];
                String dateOfBirth = accountData[4];
                String occupation = accountData[5];
                String address = accountData[6];

                System.out.printf("| %14s | %16s | %13s | %14s | %16s | %16s |%n", accountNumber, fullName, nationalId,
                        dateOfBirth, occupation, address);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
  
    // ...

    private static void viewTransactionHistory() {
        // Code to view transaction history...
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(TRANSACTION_FILE));
    
                try (// Prompt the user to enter the name or ID number to search
                Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter the user's name or ID number to search: ");
                    String searchQuery = scanner.nextLine();
   
                    System.out.println("Transaction History:");
   
                    String line;
                    boolean hasTransactions = false;
   
                    while ((line = reader.readLine()) != null) {
                        String[] transactionData = line.split(",");
                        String accountNumber = transactionData[0];
                        String transactionDetails = transactionData[1];
   
                        // Check if the account number or user's name from transaction details matches the search query
                        if (accountNumber.equals(searchQuery) || transactionDetails.contains(searchQuery)) {
                            System.out.printf("| %-14s | %s%n", accountNumber, transactionDetails);
                            hasTransactions = true;
                        }
                    }
                    
                    if (!hasTransactions) {
                        System.out.println("No transaction history found for the user.");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }       
        // ...
    }
    
    }
    private static void editAccountHolderDetails() {
        try (// Code to edit account holder's details...
                // Prompt the admin for the account number of the account holder to edit
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the account number of the account holder: ");
            String accountNumberToEdit = scanner.nextLine();

            // Create a temporary list to hold modified account details
            List<String> modifiedAccountDetails = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNTS_FILE))) {
                String line;
                boolean isAccountFound = false;

                // Read the account details and check if the account number matches
                while ((line = reader.readLine()) != null) {
                    String[] accountData = line.split(",");
                    String accountNumber = accountData[0];

                    if (accountNumber.equals(accountNumberToEdit)) {
                        // Display current details and prompt for new details
                        System.out.println("Current Account Details:");
                        System.out.println("Full Name: " + accountData[1]);
                        System.out.println("National ID: " + accountData[2]);
                        System.out.println("Date of Birth: " + accountData[3]);
                        System.out.println("Occupation: " + accountData[4]);
                        System.out.println("Address: " + accountData[5]);

                        System.out.println("Enter new details:");

                        // Prompt for new details
                        System.out.print("New Full Name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("New National ID: ");
                        String newNationalId = scanner.nextLine();
                        System.out.print("New Date of Birth: ");
                        String newDateOfBirth = scanner.nextLine();
                        System.out.print("New Occupation: ");
                        String newOccupation = scanner.nextLine();
                        System.out.print("New Address: ");
                        String newAddress = scanner.nextLine();

                        // Modify the account details with the new details
                        String modifiedAccountData = String.join(",", accountNumber,
                                newFullName, newNationalId, newDateOfBirth, newOccupation, newAddress);

                        modifiedAccountDetails.add(modifiedAccountData);
                        isAccountFound = true;
                    } else {
                        // Add unchanged account details to the temporary list
                        modifiedAccountDetails.add(line);
                    }
                }

                if (!isAccountFound) {
                    System.out.println("Account not found. Please try again.");
                } else {
                    // Write modified account details to the temporary file
                    writeModifiedDetailsToTempFile(modifiedAccountDetails);

                    // Replace the original file with the temporary file
                    replaceOriginalFileWithTempFile();
                    System.out.println("Account holder's details updated successfully.");
                }
            } catch (IOException e) {
                System.out.println("Error reading/writing file: " + e.getMessage());
            }
        }
    }    
    private static void writeModifiedDetailsToTempFile(List<String> modifiedAccountDetails) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEMP_FILE))) {
            for (String accountData : modifiedAccountDetails) {
                writer.write(accountData);
                writer.write("\n");
            }
        }
    }

    private static void replaceOriginalFileWithTempFile() {
        File originalFile = new File(ACCOUNTS_FILE);
        File tempFile = new File(TEMP_FILE);

        if (tempFile.renameTo(originalFile)) {
            tempFile.delete();
        }
    }

    // ...
}
