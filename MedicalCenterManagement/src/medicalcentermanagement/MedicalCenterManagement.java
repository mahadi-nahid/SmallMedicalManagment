
package medicalcentermanagement;

import com.mahadihasan.mc.gui.LogIn;
import javax.swing.UIManager;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class MedicalCenterManagement {

    public static void main(String[] args) {   
        
        
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        try { 
              UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
          
         }catch(Exception exception) {
             
         }
        
        LogIn logIn = new LogIn();
    }
}
