package atmachine;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class AdminAccount {
    public static final String ACCOUNTS_FILE = "accounts.csv";
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
    }
    private static void editAccountHolderDetails() {
        // Code to edit account holder's details...
    }
}
