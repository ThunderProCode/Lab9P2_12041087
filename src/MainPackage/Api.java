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
            connection.close();

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
            String sql4 = "UPDATE unitec_students SET student_courses = '"+courses+"' WHERE student_id = "+student.getId();

            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            JOptionPane.showMessageDialog(null,"Se guardaron los cambios");
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Problema al guardar los cambios");
        }
    }
    
     public void editTeacher(Teacher teacher){
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            
            String sql = "UPDATE unitec_teachers SET name = '"+teacher.getName()+"' WHERE teacher_id = "+teacher.getId();
            String sql2 = "UPDATE unitec_teachers SET password = '"+teacher.getPassword()+"' WHERE teacher_id= "+teacher.getId();
            
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            JOptionPane.showMessageDialog(null,"Se guardaron los cambios");
            connection.close();

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
            String coursesList = result.getString("courses");
            ArrayList<Course> courses = getCourses(coursesList);
            
            teacher = new Teacher(id,name,account,password,courses);
            teacher.setId(id);
            connection.close();

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
            String coursesList = result.getString("courses");
            ArrayList<Course> courses = getCourses(coursesList);
            
            teacher = new Teacher(id,name,account,password,courses);
            connection.close();

            
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
            connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return newCoursesList;
    }
    
     public Course getCourseById(int id){
        Course newCourse = null;
         try {
            
            Connection connection = DriverManager.getConnection(databaseURL);
            
            String sql = "SELECT * FROM unitec_courses WHERE course_id="+id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();

            int courseId = result.getInt("course_id");
            String name = result.getString("course_name");
            int teacherId = result.getInt("teacher_id");
            int firstTestId = result.getInt("firstTestId");
            int secondTestId = result.getInt("secondTestId");
            newCourse = new Course(name,courseId,teacherId,secondTestId,firstTestId);
            connection.close();

        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return newCourse;
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
            connection.close();

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
            connection.close();

        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return degrees;
    }
    
    public void addTest(Examen test){
        boolean q1 = test.isQ1(); 
        boolean q2 = test.isQ2();
        boolean q3 = test.isQ3();
        boolean q4 = test.isQ4();
        boolean q5 = test.isQ5();

        String p1 = test.getP1();
        String p2 = test.getP2();
        String p3 = test.getP3();    
        String p4 = test.getP4();    
        String p5 = test.getP5();
        int time = test.getTime();
        
        String sql = "INSERT INTO unitec_tests (p1,p2,p3,p4,p5,q1,q2,q3,q4,q5,course_id,time) VALUES("+  "'" + p1 + "'" + "," + "'" + p2 + "'" + "," + "'" + p3 + "'" + "," + "'" + p4 + "'" + "," + "'" + p5 + "'" + "," + q1 + "," + q2 + "," + q3 + "," + q4 + "," + q5 + "," + test.getCourseId() + "," + time + ")";
        System.out.println(sql);

        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            
            String q = "INSERT INTO unitec_tests ([p1],[p2],[p3],[p4],[p5],[q1],[q2],[q3],[q4],[q5],[time],[course_id]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(q);
            
            st.setString(1,p1);
            st.setString(2,p2);
            st.setString(3,p3);
            st.setString(4,p4);
            st.setString(5,p5);
            st.setBoolean(6,q1);
            st.setBoolean(7, q2);
            st.setBoolean(8, q3);
            st.setBoolean(9, q4);
            st.setBoolean(10, q5);
            st.setInt(11, time);
            st.setInt(12, test.getCourseId());
            System.out.println(st);
            st.executeUpdate();
            connection.close();

        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public Examen getTestById(int id){
        String sql = "SELECT * FROM unitec_tests WHERE Id="+id;
        Examen test = null;
        System.out.println("ID DENTRO ACA: " + id);
        try {
            
            Connection connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            
            boolean q1 = result.getBoolean("q1");
            boolean q2 = result.getBoolean("q2");
            boolean q3 = result.getBoolean("q3");
            boolean q4 = result.getBoolean("q4");
            boolean q5 = result.getBoolean("q5");

            String p1 = result.getString("p1");
            String p2 = result.getString("p2");
            String p3 = result.getString("p3");    
            String p4 = result.getString("p4");    
            String p5 = result.getString("p5");
            
            int time = result.getInt("time");
            int courseId = result.getInt("course_id");
            
            System.out.println(q1+ "" + q2 + "" + q3 + "" + q4 + "" + q5);
            System.out.println(p1+p2+p3+p4+p5);
            
            test = new Examen(q1,q2,q3,q4,q5,p1,p2,p3,p4,p5,time,courseId);
            test.setId(id);
            
            connection.close();

            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return test;
    }
    
    public void createTestResultTable(int studentId, int courseId, int grade,int testId){
        String sql = "CREATE TABLE Student"+studentId+"_Course"+courseId+"_Test"+testId + "( student_id int, course_id int,test_id int, grade int )";
        String sql2 = "INSERT INTO Student"+studentId+"_Course"+courseId+"_Test"+testId +"(student_id,course_id,test_id,grade) VALUES(" + studentId + "," + courseId+","+testId+","+grade+")";
        System.out.println(sql);
        System.out.println(sql2);
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
           
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void updateTestResultTable(){
        
    }
    
    public boolean isTestDone(int studentId, int courseId, int testId){
        String sql = "SELECT * FROM Student"+studentId+"_Course"+courseId+"_Test"+testId;
        System.out.println(sql);
        
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                return true;
            }
            connection.close();

        } catch(SQLException ex){
            return false;
        }
        
        return false;
    }
    
    public int getTestGrade(int studentId, int courseId, int testId){
        String sql = "SELECT * FROM Student"+studentId+"_Course"+courseId+"_Test"+testId;
        int grade = 0;
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            result.next();
            
            grade = result.getInt("grade");
            
            connection.close();

        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return grade;
    }
    
    public void deleteStudent(int studentId){
        String sql = "DELETE FROM unitec_students WHERE student_id="+studentId;
        System.out.println(sql);
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
            
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
