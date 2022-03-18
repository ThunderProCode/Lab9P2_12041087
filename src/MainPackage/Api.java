package MainPackage;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Api {
    
    String databaseURL = "jdbc:ucanaccess://C:/Users/ThunderKnight/Documents/CODE 2022/LabP2/Lab9P2/Unitec_data.accdb";
   
    public Student getStudent(int account){
       Student student = null;
       try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT * FROM unitec_students WHERE acc_number="+account;
             
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            
            int id = result.getInt("student_id");
            String name = result.getString("student_name");
            String degree = result.getString("student_degree");
            String courses = result.getString("student_courses");
            String userPassword = result.getString("password");
            ArrayList coursesList = getCourses(courses);
            
            student = new Student(degree,name,account,userPassword,coursesList);
            student.setId(id);
            
        } catch (SQLException ex) {
            System.out.println("user not found");
        }
       return student;
    }
    
    
    public void editStudent(Student student){
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "UPDATE unitec_students SET student_name = '"+student.getName()+"' WHERE student_id = "+student.getId();
            String sql2 = "UPDATE unitec_students SET student_degree = '"+student.getDegree()+"' WHERE student_id = "+student.getId();
            String sql3 = "UPDATE unitec_students SET password = '"+student.getPassword()+"' WHERE student_id = "+student.getId();
            
            String courses = "";
            for (int i = 0; i < student.getCourses().size(); i++) {
                if(i < student.getCourses().size()-1){
                    courses += student.getCourses().get(i).getId() + ",";
                }else{
                    courses += student.getCourses().get(i).getId();
                }
            }
            
            System.out.println(courses);
            String sql4 = "UPDATE unitec_students SET student_courses = '"+courses+"' WHERE student_id = "+student.getId();

            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            JOptionPane.showMessageDialog(null,"Se guardaron los cambios");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Problema al guardar los cambios");
        }
    }
    
    
    public Teacher getTeacher(int account){
       Teacher teacher = null;
       
       try {
           
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT * FROM unitec_teachers WHERE acc="+account;
             
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            
            int id = result.getInt("teacher_id");
            String name = result.getString("name");
            String password = result.getString("password");
            
            teacher = new Teacher(name,account,password);
            teacher.setId(id);
            
        } catch (SQLException ex) {
           System.out.println("user not found");
        }
       return teacher;
    }
    
     public Teacher getTeacherById(int id){
       Teacher teacher = null;
       
       try {
           
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT * FROM unitec_teachers WHERE teacher_id="+id;
             
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            
            int account = result.getInt("acc");
            String name = result.getString("name");
            String password = result.getString("password");
            
            teacher = new Teacher(name,account,password);
            
            
        } catch (SQLException ex) {
           System.out.println("user not found");
        }
       return teacher;
    }
    
    
    
    
    
    public ArrayList getCourses(String coursesList){
        String[] courses = coursesList.split(",");
        ArrayList<Course> newCoursesList = new ArrayList();
        try {
            
            Connection connection = DriverManager.getConnection(databaseURL);
            
            for (String course : courses) {
                
                String sql = "SELECT * FROM unitec_courses WHERE course_id="+course;
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                result.next();
                
                int courseId = result.getInt("course_id");
                String name = result.getString("course_name");
                String degree = result.getString("degree");
                int teacherId = result.getInt("teacher_id");
                int firstTestId = result.getInt("firstTestId");
                int secondTestId = result.getInt("secondTestId");
                
                Course newCourse = new Course(name,courseId,teacherId,secondTestId,firstTestId);
                newCoursesList.add(newCourse);
                
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return newCoursesList;
    }
    
       public ArrayList getAllCourses(){
        ArrayList<Course> newCoursesList = new ArrayList();
        try {
            
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT * FROM unitec_courses";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                 int courseId = result.getInt("course_id");
                String name = result.getString("course_name");
                int teacherId = result.getInt("teacher_id");
                int firstTestId = result.getInt("firstTestId");
                int secondTestId = result.getInt("secondTestId");

                Course newCourse = new Course(name,courseId,teacherId,secondTestId,firstTestId);
                newCoursesList.add(newCourse);
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return newCoursesList;
    }
    
    public ArrayList getAllDegrees(){ 
        ArrayList<Degree> degrees = new ArrayList();
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT * FROM unitec_degrees";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                int degreeId = result.getInt("Id");
                String name = result.getString("name");
                
                Degree degree = new Degree(name,degreeId);
                degrees.add(degree);
            }
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return degrees;
    }
    
}
