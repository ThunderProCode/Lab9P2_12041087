package MainPackage;

public class Teacher extends User {
    
        private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    public Teacher(String name, int account, String password) {
        super(name, account,password);
    }
    
}
