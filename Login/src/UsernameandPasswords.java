import java.io.*;
import java.util.HashMap;

public class UsernameandPasswords {
    private HashMap<String, String> userinfo = new HashMap<>();
    private HashMap<String,String>emailMap = new HashMap<>();
    private String filename;

    public UsernameandPasswords(String filename)
    {
        this.filename = filename;
        deserializeMap();
    }

    public boolean addUser(String username, String password,String email)
    {
        if (userinfo.containsKey(username))
        {
            return false; // Username already exists
        } 
        else if(emailMap.containsKey(email))
        {
            return false;
        }
        else 
        {
            userinfo.put(username, password);
            emailMap.put(email,username);
            serializeMap(); // Serialize after adding user
            return true; // User added successfully
        }
    }

    public boolean validateUser(String username, String password) 
    {
        return userinfo.containsKey(username) && userinfo.get(username).equals(password);
    }
    public boolean emailExists(String email) {
        return emailMap.containsKey(email);
    }


    private void serializeMap()
    {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(userinfo);
            oos.writeObject(emailMap);
            System.out.println("HashMap serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserializeMap()
    {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) 
        {
            userinfo = (HashMap<String, String>) ois.readObject();
            emailMap = (HashMap<String,String>) ois.readObject();
            System.out.println("HashMap deserialized from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
