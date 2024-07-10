import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener
{
   UsernameandPasswords userpasswords;
   JFrame frame = new JFrame("Login page");
   JLabel Title = new JLabel("Login");
   JLabel username = new JLabel("username");
   JLabel password = new JLabel("password");
   JTextField text = new JTextField("username");
   JPasswordField text1 = new JPasswordField();
   JButton button = new JButton("Login");
   JPanel panel = new JPanel();

   public Login(UsernameandPasswords userpasswords)
   {
      this. userpasswords= userpasswords;
      frame.setVisible(true);
      frame.setSize(500, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
       
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(Color.BLACK);
      
      Title.setForeground(Color.WHITE);
      Title.setFont(new Font("Arial", Font.BOLD, 24));
      Title.setBounds(200, 50, 100, 30);
      panel.add(Title);

      username.setForeground(Color.WHITE);
      username.setFont(new Font("Arial",Font.PLAIN, 14));
      username.setBounds(125, 120, 80, 30);
      panel.add(username);

      text.setBackground(Color.WHITE);
      text.setForeground(Color.BLACK);
      text.setBounds(200, 120, 150, 30);
      panel.add(text);

      password.setForeground(Color.WHITE);
      password.setBounds(125, 180, 80, 30);
      password.setFont(new Font("Arial",Font.PLAIN, 14));
      panel.add(password);
   
      text1.setBackground(Color.WHITE);
      text1.setForeground(Color.BLACK);
      text1.setBounds(200, 180, 150, 30);
      panel.add(text1);

      button.setBackground(Color.BLUE);
      button.setForeground(Color.WHITE);
      button.setFocusable(false);
      button.setBounds(200, 250, 100, 30);
      panel.add(button);

      button.addActionListener(this);
      frame.add(panel);

   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == button)
      {
      String userId=text.getText();
      String password=String.valueOf(text1.getPassword());
      
         if(userpasswords.validateUser(userId, password))
         {
          JOptionPane.showMessageDialog(frame, "Login Successful");
          frame.dispose();
          new Welcomepage(userId);
         } 
         else 
         {
            JOptionPane.showMessageDialog(frame,"Login Failed" );
         }
      } 
     

   }
    
}
