public class App {
    public static void main(String[] args) throws Exception {
    
        String filename = "C:\\Users\\smdas\\OneDrive\\Desktop\\user_data.ser";
        UsernameandPasswords userpasswords=new UsernameandPasswords(filename);
        new createaccount(userpasswords);
        
    }
}
