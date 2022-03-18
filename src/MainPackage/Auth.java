/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import javax.swing.JOptionPane;

/**
 *
 * @author ThunderKnight
 */
public class Auth {
    
   public void login(int account, String password){
       if( Main.Api.getStudent(account) != null ){
           
            Student student = Main.Api.getStudent(account);
           
           if(student.getPassword().equals(password)){
               Main.MainScreen.setLoggedUser(student);
           }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
           }
       }else if( Main.Api.getTeacher(account) != null ){
           Teacher teacher = Main.Api.getTeacher(account);
           
           if(teacher.getPassword().equals(password)){
             Main.MainScreen.setLoggedUser(teacher);
           }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
           }   
       }
       
   }
   
}
