import java.awt.*;
import javax.swing.*;

public class Welcomepage {
    private JFrame frame;
    private JLabel welcomeLabel;

    public Welcomepage(String userID) {

        frame = new JFrame("Welcome page");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setLocationRelativeTo(null);

        welcomeLabel = new JLabel("Hello," + userID);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        welcomeLabel.setBounds(90, 200, 300, 30); 
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(welcomeLabel);
        frame.setVisible(true);

    }
}