package MainPackage;

import javax.swing.JPanel;

public class Main {
    
    public static MainScreen MainScreen = new MainScreen();
    public static Api Api = new Api();
    public static Auth Auth = new Auth();
    public static LoginScreen LoginScreen = new LoginScreen();
    
    public static JPanel studentPanel = MainScreen.getStudentPanel();
    public static JPanel teacherPanel = MainScreen.getTeacherPanel();
    
    public static void main(String[] args) {
        
        LoginScreen.setVisible(true);
        MainScreen.fillComboBoxes();
    }
    
}
