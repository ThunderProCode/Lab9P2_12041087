/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

public class Examen {
    
    private int Id;
    
    private boolean q1;
    private boolean q2;
    private boolean q3;
    private boolean q4;
    private boolean q5;
    
    private String p1;
    private String p2;
    private String p3;    
    private String p4;    
    private String p5;
    private int time;
    
    private int courseId;

    public Examen(boolean q1, boolean q2, boolean q3, boolean q4, boolean q5, String p1, String p2, String p3, String p4, String p5, int time,int courseId) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.time = time;
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    /**
     * Get the value of time
     *
     * @return the value of time
     */
    public int getTime() {
        return time;
    }

    /**
     * Set the value of time
     *
     * @param time new value of time
     */
    public void setTime(int time) {
        this.time = time;
    }

    
    /**
     * Get the value of p5
     *
     * @return the value of p5
     */
    public String getP5() {
        return p5;
    }

    /**
     * Set the value of p5
     *
     * @param p5 new value of p5
     */
    public void setP5(String p5) {
        this.p5 = p5;
    }

    
    /**
     * Get the value of p4
     *
     * @return the value of p4
     */
    public String getP4() {
        return p4;
    }

    /**
     * Set the value of p4
     *
     * @param p4 new value of p4
     */
    public void setP4(String p4) {
        this.p4 = p4;
    }


    /**
     * Get the value of p3
     *
     * @return the value of p3
     */
    public String getP3() {
        return p3;
    }

    /**
     * Set the value of p3
     *
     * @param p3 new value of p3
     */
    public void setP3(String p3) {
        this.p3 = p3;
    }


    /**
     * Get the value of p2
     *
     * @return the value of p2
     */
    public String getP2() {
        return p2;
    }

    /**
     * Set the value of p2
     *
     * @param p2 new value of p2
     */
    public void setP2(String p2) {
        this.p2 = p2;
    }


    /**
     * Get the value of p1
     *
     * @return the value of p1
     */
    public String getP1() {
        return p1;
    }

    /**
     * Set the value of p1
     *
     * @param p1 new value of p1
     */
    public void setP1(String p1) {
        this.p1 = p1;
    }

    

    /**
     * Get the value of q5
     *
     * @return the value of q5
     */
    public boolean isQ5() {
        return q5;
    }

    /**
     * Set the value of q5
     *
     * @param q5 new value of q5
     */
    public void setQ5(boolean q5) {
        this.q5 = q5;
    }

    
    /**
     * Get the value of q4
     *
     * @return the value of q4
     */
    public boolean isQ4() {
        return q4;
    }

    /**
     * Set the value of q4
     *
     * @param q4 new value of q4
     */
    public void setQ4(boolean q4) {
        this.q4 = q4;
    }

    
    /**
     * Get the value of q3
     *
     * @return the value of q3
     */
    public boolean isQ3() {
        return q3;
    }

    /**
     * Set the value of q3
     *
     * @param q3 new value of q3
     */
    public void setQ3(boolean q3) {
        this.q3 = q3;
    }

    
    /**
     * Get the value of q2
     *
     * @return the value of q2
     */
    public boolean isQ2() {
        return q2;
    }

    /**
     * Set the value of q2
     *
     * @param q2 new value of q2
     */
    public void setQ2(boolean q2) {
        this.q2 = q2;
    }

    
    /**
     * Get the value of q1
     *
     * @return the value of q1
     */
    public boolean isQ1() {
        return q1;
    }

    /**
     * Set the value of q1
     *
     * @param q1 new value of q1
     */
    public void setQ1(boolean q1) {
        this.q1 = q1;
    }

}
