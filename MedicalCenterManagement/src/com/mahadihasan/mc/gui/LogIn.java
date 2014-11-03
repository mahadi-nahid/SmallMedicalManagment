
package com.mahadihasan.mc.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class LogIn extends JFrame {
    
    //private JFrame logInFrame;
    
    private JLabel banerLabel;
    private JLabel imageLabel;
    
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    private JButton logInButton;
    private JButton clearButton;
    
    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    
    public LogIn() {
        
        super("Login");
        
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception exception) {
        }
        
        
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        
        setLayout(layout);
        
        //-----------------Components---------------------------------
        
        Icon nahid = new ImageIcon(getClass().getResource("AB.jpg"));
        
        imageLabel = new JLabel(nahid);
        banerLabel = new JLabel("Medical Center, SUST");
        
        usernameLabel = new JLabel("Username :");
        passwordLabel = new JLabel("Password :");
        
        usernameField = new JTextField("Enter Username", 10);
        passwordField = new JPasswordField("nahid",10);      
        
        logInButton = new JButton("Login");
        clearButton = new JButton("Clear");
        
        
        imageLabel.setToolTipText("Logo SUST");
        usernameField.setToolTipText("Enter Username");
        passwordField.setToolTipText("Enter Password");
        logInButton.setToolTipText("Click Here to Log In");
        clearButton.setToolTipText("Clear Username & Password");
        
        //------------------Add Components------------------------------
        
        
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addComponent(imageLabel, 0, 3, 2, 3);
        //constraints.weightx = 10;
        //constraints.weighty = 1;
        addComponent(banerLabel, 4, 1, 7, 1);
       // constraints.anchor = GridBagConstraints.CENTER;
        
        addComponent(usernameLabel, 6, 2, 1, 1);
        addComponent(usernameField, 6, 4, 1, 1);
        addComponent(passwordLabel, 8, 2, 1, 1);
        addComponent(passwordField, 8, 4, 1, 1);
        
        
        addComponent(logInButton, 12, 4, 1, 1);
        
        //------------------Actions--------------------------------
        
        logInButton.addActionListener(
                
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                
                if(passwordField.getText().toString().equals("nahid")) {
                    //JOptionPane.showMessageDialog(null, "Ok, Successfull");
                    SearchInfo searchInfo = new SearchInfo();
                   // dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Unsuccessfull");
                }
            }
        });
        
        //---------------------------------------------------------
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth/4, screanHeight/4);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
        
        
    }
    private void addComponent(Component component, int row,
            int column, int width, int height) {
        constraints.gridx = column;
        constraints.gridy = row;
        constraints.gridheight = height;
        constraints.gridwidth = width;

        layout.setConstraints(component, constraints);
        add(component);
    }
    
    
    
}
