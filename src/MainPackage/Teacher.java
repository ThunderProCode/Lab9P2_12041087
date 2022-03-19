package MainPackage;

import java.util.ArrayList;

public class Teacher extends User {
    
    private int id;
    private ArrayList<Course> courses = new ArrayList();
    
    public Teacher(int id,String name, int account, String password, ArrayList<Course> courses) {
        super(name, account,password);
        this.id = id;
        this.courses = courses;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    
}
