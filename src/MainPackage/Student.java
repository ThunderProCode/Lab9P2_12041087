package MainPackage;

import java.util.ArrayList;

public class Student extends User {
    
    private String degree;
    private ArrayList<Course> courses = new ArrayList();
    private int id;
    
    public Student(String degree, String name, int account,String password, ArrayList courses) {
        super(name, account, password);
        this.degree = degree;
        this.courses = courses;
    }
    
    public String getDegree() {
        return degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    
    public void addCourse(Course course){
        this.courses.add(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Student{" + "degree=" + degree + ", courses=" + courses + '}';
    }
    
    
    
}
