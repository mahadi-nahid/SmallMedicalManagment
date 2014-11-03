package com.mahadihasan.mc.gui;

import com.mahadihasan.mc.patient.Patient;
import com.mahadihasan.mc.patient.PrescriptionData;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class PrintEmail extends JFrame {

    private String name;
    private String age;
    private String sex;
    private String problems;
    private String[] medicines = new String[5];
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JLabel titleLabel;
    private JTextArea prescriptionArea;
    
    
    private JButton emailButton;
    private JButton printButton;
    private JButton backButton;

    
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    
    PrescriptionData data;
    Patient patient;
    
    public PrintEmail(PrescriptionData pd, Patient p) {
        super("PrintEmail");


        //------------------

        data = pd;
        patient = p;
        
        //-----------------
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        setLayout(layout);

        //----------------------

        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setBackground(Color.CYAN);
        centerPanel.setBackground(Color.ORANGE);
        bottomPanel.setBackground(Color.BLUE);
        
        titleLabel = new JLabel("Prescription : ");
        
        
        prescriptionArea = new JTextArea(20,50);
        prescriptionArea.setBackground(Color.CYAN);
        backButton = new JButton("Back");
        emailButton = new JButton("Email");
        printButton = new JButton("Print");
        
        backButton.setToolTipText("Click Here to Back");
        emailButton.setToolTipText("Mail This Prescription ");
        printButton.setToolTipText("Print This Prescription");
        



        //-------------------
        
        topPanel.add(titleLabel);
        centerPanel.add(new JScrollPane(prescriptionArea));
        bottomPanel.add(backButton);
        bottomPanel.add(printButton);
        bottomPanel.add(emailButton);
        
        //---------------
        name = data.getName();
        age = data.getAge();
        sex = data.getSex();
        problems = data.getProblems();
        medicines = data.getMedicines();


       // JOptionPane.showMessageDialog(null, name + " \n"
         //       + age + "\n"
         //       + sex + "\n"
          //      + problems + "\n"
           //     + medicines + "\n");
        
        String s = "";
        for (int i = 0; i < 5; i++) {

            System.out.println(medicines[i]);
            s = s.concat(medicines[i]+ "\n");
        }


        String mainString = "Date : "+ new Date().toString() + "\n"
                + "Name : " + name + "\n"
                + "Age : " + age+ "\n"
                + "Sex : " + sex+ "\n"
                + "----------------------------------\n"
                + "Problems : \n" + problems+"\n"
                + "-----------------------------------\n"
                + ""
                + "Medicines :\n" +s+ "\n"
                + "---------------------------------------";

        //--------------------------------



        prescriptionArea.setText(mainString);
        prescriptionArea.setEditable(false);


        //---------Actions=------------
        
        backButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // Patient patient = new Patient("2010331044",name, age, sex, "", "", "", "", "", "");
                Prescription prescription = new Prescription(patient);
                dispose();
            }
        });
        
        printButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
                //print this data..
                //
                
                //***** Save it to Database.....
                JOptionPane.showMessageDialog(null, "Not Yet Completed\n");
                dispose();
                
            }
        });
        
        emailButton.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Email This data 
                JOptionPane.showMessageDialog(null, "Not Yet Completed\n");
                dispose();
            }
        });
        //---------------------
        
        addComponent(topPanel, 0, 0,1,1);
        addComponent(centerPanel, 1, 0, 1, 15);
        addComponent(bottomPanel, 16, 0, 1, 1);
        
       // add(bottomPanel);
        //----------------------------------

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);


        setExtendedState(MAXIMIZED_BOTH);
        
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
