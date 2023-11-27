import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class WelcomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Welcome");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image backgroundImage = ImageIO.read(new File("images/background.jpg"));
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        
        backgroundPanel.setLayout(new BorderLayout());

        // Resized logo with a transparent background
        ImageIcon logoIcon = new ImageIcon("images/logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledLogo);
        JLabel logoLabel = new JLabel(scaledIcon);
        backgroundPanel.add(logoLabel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Welcome to Your Last Will and Testament App!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 20, 0));
        backgroundPanel.add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton signInButton = new JButton("Sign In");
        JButton signUpButton = new JButton("Sign Up");
        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);

        frame.add(backgroundPanel);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the sign-in page
                SignInPage signInPage = new SignInPage();
                signInPage.setVisible(true);
                frame.dispose(); // Close the welcome page
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the sign-up page
                SignUpPage signUpPage = new SignUpPage();
                signUpPage.setVisible(true);
                frame.dispose(); // Close the welcome page
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
