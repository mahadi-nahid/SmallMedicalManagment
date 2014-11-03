
package com.mahadihasan.mc.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Database {
    
    
    static final String DATABASE_URL = "jdbc:mysql://localhost/medical_center";
    static final String USER = "root";
    static final String PASS = "";
    public Statement statement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;
    
    
    // conect --close -- insert---delete----etc
    
    public void connectToDatabase() {
        
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            statement = connection.createStatement();
            
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Not Connected");
        }
        
    }
}
