import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SignUpPage {
    public SignUpPage() {
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel);

        JTextField fullNameField = new JTextField(20);
        panel.add(new JLabel("Full Name:"));
        panel.add(fullNameField);

        JTextField emailField = new JTextField(20);
        panel.add(new JLabel("Email Address:"));
        panel.add(emailField);

        JPanel dateOfBirthPanel = new JPanel();
        JTextField yearField = new JTextField(4);
        JTextField monthField = new JTextField(2);
        JTextField dayField = new JTextField(2);
        dateOfBirthPanel.add(yearField);
        dateOfBirthPanel.add(new JLabel("-"));
        dateOfBirthPanel.add(monthField);
        dateOfBirthPanel.add(new JLabel("-"));
        dateOfBirthPanel.add(dayField);
        panel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        panel.add(dateOfBirthPanel);

        JTextField usernameField = new JTextField(20);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);

        JPasswordField passwordField = new JPasswordField(20);
        panel.add(new JLabel("Password (16 characters):"));
        panel.add(passwordField);

        JPasswordField confirmPasswordField = new JPasswordField(20);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPasswordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String email = emailField.getText();
                String year = yearField.getText();
                String month = monthField.getText();
                String day = dayField.getText();
                String dateOfBirth = year + "-" + month + "-" + day;
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword) && password.length() == 16) {
                    String fileName = "userdata.csv";
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                        writer.append(fullName + "," + email + "," + dateOfBirth + "," + username + "," + password);
                        writer.newLine();
                        writer.close();
                        JOptionPane.showMessageDialog(frame,
                                "Signed up successfully!",
                                "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose(); // Close the sign-up page after successful signup
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Passwords do not match or are not 16 characters long.",
                            "Password Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(signUpButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage();
            }
        });
    }
}
