import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.opencsv.CSVWriter;    // CSVWriter library

class ATMGUI extends JFrame {
    private JTextField accountNumberField;
    private JPasswordField pinField;
    private JButton loginButton;
    private JButton createAccountButton;

    public ATMGUI() {
        // Set up the GUI components
        setTitle("ATM Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel accountNumberLabel = new JLabel("Account Number:");
        JLabel pinLabel = new JLabel("PIN:");
        accountNumberField = new JTextField();
        pinField = new JPasswordField();
        loginButton = new JButton("Login");
        createAccountButton = new JButton("Create Account");

        // Add the components to the JFrame
        add(accountNumberLabel);
        add(accountNumberField);
        add(pinLabel);
        add(pinField);
        add(loginButton);
        add(createAccountButton);

        // Add an ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountNumberField.getText();
                String pin = new String(pinField.getPassword());
                // Call a method to handle login logic
                login(accountNumber, pin);
            }
        });

        // Add an ActionListener to the create account button
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call a method to handle account creation logic
                createAccount();
            }
        });

        setVisible(true);
    }

    private void login(String accountNumber, String pin) {
        private void login(String accountNumber, String pin) {
            // Logic to handle login functionality
        
            // Assuming you have a list of Account objects that stores the existing accounts
            List<Account> accounts = getAccountList(); // Replace this with your own method to retrieve the account list
        
            // Check if the account exists
            Account account = findAccountByNumber(accountNumber, accounts);
        
            if (account == null) {
                JOptionPane.showMessageDialog(this, "Invalid account number!", "Error", JOptionPane.ERROR_MESSAGE);
                // Display an error message if the account number is not found
            } else {
                // Validate the pin
                if (account.validatePin(pin)) {
                    JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Display a success message
        
                    // Proceed to the main menu
                    showMainMenu(account);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid pin!", "Error", JOptionPane.ERROR_MESSAGE);
                    // Display an error message if the pin is incorrect
                }
            }
        }
        
        private Account findAccountByNumber(String accountNumber, List<Account> accounts) {
            // Iterate through the accounts and find the one with a matching account number
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    return account;
                }
            }
            return null; // Return null if the account number is not found
        }
        
        private void showMainMenu(Account account) {
            JFrame mainMenuFrame = new JFrame("Main Menu");
            mainMenuFrame.setSize(400, 300);
            mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainMenuFrame.setLayout(new FlowLayout());
        
            JLabel welcomeLabel = new JLabel("Welcome, " + account.getFullName());
            mainMenuFrame.add(welcomeLabel);
        
            JButton withdrawButton = new JButton("Withdraw Money");
            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement logic to withdraw money here
                }
            });
            mainMenuFrame.add(withdrawButton);
        
            JButton transferButton = new JButton("Transfer Money");
            transferButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement logic to transfer money here
                }
            });
            mainMenuFrame.add(transferButton);
        
            // Add more buttons/options for other functionality (e.g., checking balance, changing password, etc.)
        
            mainMenuFrame.setVisible(true);
        }
        
                
        private void createAccount() {
            // Logic to handle account creation functionality
            // Prompt the user for necessary information and generate an account
            
            // Get user input for necessary information
            String username = getUserInput("Enter your username: ");
            String password = getUserInput("Enter your password: ");
        
            // Generate a new account
            Account newAccount = generateAccount(username, password);
        
            // Save the new account to the database
            saveAccount(newAccount);
        }
        
        // Helper method to get user input with a specified prompt
        private String getUserInput(String prompt) {
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
        
        // Helper method to generate an Account object with the given username and password
        private Account generateAccount(String username, String password) {
            // Generate a unique account ID
            int accountId = generateUniqueId();
            
            // Create a new Account object
            Account newAccount = new Account(accountId, username, password);
        
            return newAccount;
        }
        
        // Helper method to save an Account object to the database
        private void saveAccount(Account account) {
            try {
                // Create a FileWriter object to write to the CSV file
                FileWriter fileWriter = new FileWriter("accounts.csv", true);
                
                // Create a CSVWriter object with the FileWriter
                CSVWriter csvWriter = new CSVWriter(fileWriter);
                
                // Create an array of String to represent the account data
                String[] data = {account.getId(), account.getName(), account.getEmail()};
                
                // Write the data to the CSV file
                csvWriter.writeNext(data);
                
                // Close the CSVWriter and FileWriter
                csvWriter.close();
                fileWriter.close();
                
                System.out.println("Account saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }        
        private int generateUniqueId() {
            // Generate a random integer between 1 and 1000000
            int uniqueId = (int)(Math.random() * 1000000) + 1;
            return uniqueId;
        }        

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ATMGUI();
            }
        });
    }
}
