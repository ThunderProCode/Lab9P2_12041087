package MainPackage;

public class User {
    
    private String name;
    private int account;
     private String password;

    public User(String name, int account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }
    
    public int getAccount() {
        return account;
    }
    
    public void setAccount(int account) {
        this.account = account;
    }
    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
