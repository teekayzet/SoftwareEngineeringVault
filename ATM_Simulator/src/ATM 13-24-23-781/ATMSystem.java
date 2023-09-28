public class ATMSystem {
    public static void main(String[] args) {
        // Creating an instance of the ATM GUI
        ATMGUI atmGUI = new ATMGUI();

        // Setting up the GUI components and functionality
        atmGUI.setTitle("ATM System");
        atmGUI.setSize(800, 600);
        atmGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding components to the GUI
        atmGUI.addComponents(); // A separate method in the ATMGUI class to add components to the JFrame

        // Adding functionality to the components
        atmGUI.getWithdrawButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amountToWithdraw = Double.parseDouble(atmGUI.getWithdrawTextField().getText());
                // Check if the amount to withdraw is valid (e.g., not greater than the balance)
                if (amountToWithdraw > 0 && amountToWithdraw <= atmGUI.getBalance()) {
                    // Perform the withdrawal
                    atmGUI.setBalance(atmGUI.getBalance() - amountToWithdraw);
                    // Update the balance label
                    atmGUI.getBalanceLabel().setText("Balance: $" + atmGUI.getBalance());
                    // Display a success message to the user
                    JOptionPane.showMessageDialog(atmGUI, "Withdrawal successful.");
                } else {
                    // Display an error message to the user
                    JOptionPane.showMessageDialog(atmGUI, "Invalid withdrawal amount.");
                }
            }
         });
         atmGUI.getDepositButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amountToDeposit = Double.parseDouble(atmGUI.getDepositTextField().getText());
                // Check if the amount to deposit is valid (e.g., not negative)
                if (amountToDeposit > 0) {
                    // Perform the deposit
                    atmGUI.setBalance(atmGUI.getBalance() + amountToDeposit);
                    // Update the balance label
                    atmGUI.getBalanceLabel().setText("Balance: $" + atmGUI.getBalance());
                    // Display a success message to the user
                    JOptionPane.showMessageDialog(atmGUI, "Deposit successful.");
                } else {
                    // Display an error message to the user
                    JOptionPane.showMessageDialog(atmGUI, "Invalid deposit amount.");
                }
            }
         });
        // Displaying the GUI
        atmGUI.setVisible(true);
    }
}
