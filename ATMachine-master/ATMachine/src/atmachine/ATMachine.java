package atmachine;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ATMachine {
    public static final String ACCOUNTS_FILE = "accounts.csv";
    private static final Object ADMIN_USERNAME = "ADMINISTRATOR";
    private static final Object ADMIN_PASSWORD = "97831005290012";
    public static void main(String[] args) {
        System.out.println("WELCOME TO Takudzwa's BANK!");
        showOptions();
    }
    public static void showOptions(){
        System.out.println("Please select an option:");
        System.out.println("1.Login");
        System.out.println("2.Signup");
        System.out.println("3.Login As Admin");

        try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch(option){
                case 1:
                login();
                break;
                case 2:
                signup();
                break;
                case 3:
                loginAsAdmin();
                break;
                default:
                System.out.println("Invalid option. Please try again");
                showOptions();
                break;
            }
            scanner.close();
        }
        }
        public static void login() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(ACCOUNTS_FILE));

            System.out.print("Enter your account number: ");
            try (Scanner scanner = new Scanner(System.in)) {
                int accountNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter your pin: ");
                int pin =Integer.parseInt(scanner.nextLine());

                String line;
                boolean isValidUser = false;

                //iterate through the CSV file and check if the entered account nummber and pin match
                while((line = reader.readLine()) != null){
                    String[] accountData = line.split(",");
                    int storedAccountNumber = Integer.parseInt(accountData[0]);
                    int storedPin = Integer.parseInt(accountData[1]);

                    if (accountNumber == storedAccountNumber && pin == storedPin) {
                        isValidUser = true;
                        break;
                    }
                }
                if (isValidUser) {
                    System.out.println("Login successful!");
                    Home.home();
                }else{
                    System.out.println("Invalid account number or PIN. Please try again.");
                    showOptions();
                }
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
public static void signup() {
        try {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter your full name: ");
                String fullName = scanner.nextLine();

                System.out.print("Enter your national ID number: ");
                String nationalId = scanner.nextLine();

                System.out.print("Enter your date of birth: ");
                String dateOfBirth = scanner.nextLine();

                System.out.print("Enter your occupation: ");
                String occupation = scanner.nextLine();

                System.out.print("Enter your address: ");
                String address = scanner.nextLine();

                // Generate a random 16-digit bank account number
                String accountNumber = generateAccountNumber();

                // Generate a random 4-digit PIN
                String pin = generatePIN();

                // Append the new account details to the CSV file
                BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNTS_FILE, true));
                writer.write(accountNumber + "," + pin + "," + fullName + "," + nationalId + "," + dateOfBirth + ","
                        + occupation + "," + address);
                writer.write("\n");
                writer.close();

                System.out.println("Account created successfully!");
                System.out.println("Your account number: " + accountNumber);
                System.out.println("Your PIN: " + pin);
            }

            System.out.println("Please do not share your account details with anyone.");

            showOptions();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Login as admin successful!");
            AdminAccount.runAdminMenu();
        }else {
            System.out.println("Invalid username or password. Please try again.");
            showOptions();
        }
        scanner.close();
    }

    private static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        // Generate 16 random digits
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    private static String generatePIN() {
        Random random = new Random();

        // Generate a random 4-digit PIN
        int pin = random.nextInt(10000);

        // Format the PIN with leading zeros if necessary
        return String.format("%04d", pin);
    }
}

//
//