import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
public class createaccount implements ActionListener 
{

    UsernameandPasswords userpasswords;
    
    JFrame frame = new JFrame("Create Account");
    JPanel panel = new JPanel();
    JLabel Title = new JLabel("Create Account");
    JLabel signinJLabel = new JLabel("Already have an account?");
    JButton signButton = new JButton("Sign in");
    JTextField userField = new JTextField("Username");
    JTextField firstname = new JTextField("First Name");
    JTextField lastname = new JTextField("Last Name");
    JPasswordField passwordField = new JPasswordField("password");
    JTextField email = new JTextField("Email");
    JButton button = new JButton("Sign up");

    public createaccount(UsernameandPasswords userpasswords)
    {
        this.userpasswords=userpasswords;
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        // creates the panel to hold the form elements
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        

        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Arial", Font.BOLD, 24));
        Title.setBounds(150, 50, 200, 30);
        panel.add(Title);

        signinJLabel.setForeground(Color.WHITE);
        signinJLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        signinJLabel.setBounds(135, 90, 250, 25);
        panel.add(signinJLabel);

        signButton.setForeground(Color.WHITE);
        signButton.setBackground(Color.BLUE);
        signButton.setBounds(305, 90, 80, 25);
        signButton.setFocusable(false);
        panel.add(signButton);

        userField.setBackground(Color.WHITE);
        userField.setForeground(Color.BLACK);
        userField.setBounds(150,130,200,30);
        panel.add(userField);

        firstname.setBackground(Color.WHITE);
        firstname.setForeground(Color.BLACK);
        firstname.setBounds(150, 170, 95, 30);
        panel.add(firstname);

        lastname.setBackground(Color.WHITE);
        lastname.setForeground(Color.BLACK);
        lastname.setBounds(255, 170, 95, 30);
        panel.add(lastname);

        email.setBackground(Color.WHITE);
        email.setForeground(Color.BLACK);
        email.setBounds(150, 210, 200, 30);
        panel.add(email);

        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.black);
        passwordField.setBounds(150, 250, 200, 30);
        panel.add(passwordField);

        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setBounds(150, 290, 200, 40);
        button.setFocusable(false);
        panel.add(button);

        button.addActionListener(this);
        signButton.addActionListener(this);

        frame.add(panel);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
      
      if (e.getSource() == button) 
      {
        String userId = userField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());
        String firstName = firstname.getText().trim();
        String lastName = lastname.getText().trim();
        String userEmail = email.getText().trim();

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern specialCharPattern = Pattern.compile("\\W");
        Matcher usernameSpecialCharMatcher = specialCharPattern.matcher(userId);
        Matcher passwordSpecialCharMatcher = specialCharPattern.matcher(password);
        Pattern specialPattern = Pattern.compile(emailRegex);
        Matcher emailspecialCharMatcher = specialPattern.matcher(userEmail);

        if (userId.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || userEmail.isEmpty() || password.isEmpty()) 
        {
            JOptionPane.showMessageDialog(frame,"Please fill in all fields" ); 
        }else if (usernameSpecialCharMatcher.find()) {
            JOptionPane.showMessageDialog(frame, "Username should not contain any special symbols");
        }else if (userId.length() > 10) {
            JOptionPane.showMessageDialog(frame, "Username must contain 10 or fewer characters");
        } else if (passwordSpecialCharMatcher.find()) {
            JOptionPane.showMessageDialog(frame, "Password should not contain any special symbols");
        }  
        else if (password.length() > 8) {
            JOptionPane.showMessageDialog(frame, "Password must contain fewer than 8 characters");
        }else if (password.length() < 8) {
            JOptionPane.showMessageDialog(frame, "Password must contain atleast 8 characters");
        } else if (userpasswords.emailExists(userEmail))
        { 
            JOptionPane.showMessageDialog(frame, "Email already Exists");
        }else if(!emailspecialCharMatcher.matches())
        {
            JOptionPane.showMessageDialog(frame, "Invalid email address");
        }

         else 
        {
            boolean added = userpasswords.addUser(userId, password,userEmail);
            if (added)
            {
                JOptionPane.showMessageDialog(frame,"Account created successfully!" ); 
                frame.dispose();
                new Login(userpasswords);
            }
             else
            {
                JOptionPane.showMessageDialog(frame,"username already exists!" );
            }
        }
    } 
    else if (e.getSource() == signButton) 
    {
        frame.dispose();
        new Login(userpasswords);
    }
    }
       
      
    
        
 }