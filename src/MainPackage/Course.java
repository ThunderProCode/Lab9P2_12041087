/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author ThunderKnight
 */
public class Course {
    
    private String name; 
    private int id;
    private int teacher_id;
    private int secondTestId;
    private int firstTestId;

    public Course(String name, int teacher_id) {
        this.name = name;
        this.teacher_id = teacher_id;
        this.secondTestId = -1;
        this.firstTestId = -1;
        
    }

    
    
    public Course(String name, int id, int teacher_id, int secondTestId, int firstTestId) {
        this.name = name;
        this.id = id;
        this.teacher_id = teacher_id;
        this.secondTestId = secondTestId;
        this.firstTestId = firstTestId;
    }
    
    
    public int getFirstTestId() {
        return firstTestId;
    }

    public void setFirstTestId(int firstTestId) {
        this.firstTestId = firstTestId;
    }

   
    public int getSecondTestId() {
        return secondTestId;
    }

    
    public void setSecondTestId(int secondTestId) {
        this.secondTestId = secondTestId;
    }
    
    public int getTeacher_id() {
        return teacher_id;
    }
    
    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", id=" + id + ", teacher_id=" + teacher_id + ", secondTestId=" + secondTestId + ", firstTestId=" + firstTestId + '}';
    }

    
   

}
