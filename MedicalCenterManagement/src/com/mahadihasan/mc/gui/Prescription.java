package com.mahadihasan.mc.gui;

import com.mahadihasan.mc.patient.Patient;
import com.mahadihasan.mc.patient.PrescriptionData;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Prescription extends JFrame {

    private JPanel topPanel;
    private JPanel centerPanel1;
    private JPanel centerPanel2;
    private JPanel medicinePanel;
    private JPanel testPanel;
    private JPanel bottomPanel;
    
    private JLabel[] infoLabels;
   
    private JLabel problemLabel;
    private JTextArea discriptionArea;
    private JLabel[] medicineLabels;
    private JTextField[] medicineFields;
    private JComboBox[] bOrAfterMeal;
    private JCheckBox[] morning;
    private JCheckBox[] afternoon;
    private JCheckBox[] night;
    private JButton clearButton;
    private JButton backButton;
    private JButton okButton;
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private String[] bOrAfter = {"Before Meal", "After Meal"};
    
    private Patient patient;

    public Prescription(Patient p) {

        super("Prescription");

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        //----------------------
        patient = p;

        // setLayout(layout);

        setLayout(new GridLayout(4, 1, 2, 2));

        topPanel = new JPanel();
        topPanel.setBackground(Color.CYAN);
        centerPanel1 = new JPanel();
        centerPanel1.setBackground(Color.GRAY);
        medicinePanel = new JPanel();
        medicinePanel.setBackground(Color.ORANGE);
        testPanel = new JPanel();
        testPanel.setBackground(Color.RED);
        centerPanel2 = new JPanel();
        centerPanel2.setBackground(Color.GREEN);
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLUE);

        
         //--------------Panel Layout-------------
        topPanel.setLayout(new GridLayout(4, 1, 1, 1));
        centerPanel1.setLayout(new GridLayout(1, 2, 2, 2));
        centerPanel2.setLayout(new GridLayout(1, 2, 2, 2));
        medicinePanel.setLayout(new GridLayout(5, 6, 2, 2));
        bottomPanel.setLayout(new FlowLayout());
        
        topPanel.setAutoscrolls(true);
        
        //-----------------topPanel----------------------
        
        Font font = new Font("Tahoma", Font.BOLD, 15);
        
        infoLabels = new JLabel[4];
        String[] value = new String [4];
        
        value[0] = new Date().toString();
        value[1] = patient.getName();
        value[2] = patient.getAge();
        value[3] = patient.getSex();
        
        String[] title = {"Date : ", "Name : ", "Age : ", "Sex : "};
        for (int i = 0; i < 4; i++) {
            infoLabels[i] = new JLabel(""+title[i]+value[i]);
            infoLabels[i].setFont(font);
            topPanel.add(infoLabels[i]);
            
        }
        
        //-----------------------------------------



        problemLabel = new JLabel("Problem : ");
        problemLabel.setFont(new Font("Tahoma", Font.BOLD+Font.ITALIC, 18));
        discriptionArea = new JTextArea(1, 4);
        discriptionArea.setBackground(Color.ORANGE);


        //----------


        medicineLabels = new JLabel[5];
        medicineFields = new JTextField[5];

        morning = new JCheckBox[5];
        afternoon = new JCheckBox[5];
        night = new JCheckBox[5];


        bOrAfterMeal = new JComboBox[5];
        for (int i = 0; i < 5; i++) {

            medicineLabels[i] = new JLabel("" + (i + 1) + ". Medicine " + (i + 1) + ": ");
            medicineFields[i] = new JTextField(10);

            bOrAfterMeal[i] = new JComboBox(bOrAfter);

            //------------

            morning[i] = new JCheckBox("morning");
            afternoon[i] = new JCheckBox("afternoon");
            night[i] = new JCheckBox("night");
            //-----------

        }




        //------------
        backButton = new JButton("Back");
        clearButton = new JButton("Clear");
        okButton = new JButton("Ok");

        
        clearButton.setToolTipText("Clear All");
        okButton.setToolTipText("OK");
        backButton.setToolTipText("Back");
        
       
        //--------------Components Add--------------------------

        centerPanel1.add(problemLabel);
        centerPanel1.add(new JScrollPane(discriptionArea));

        centerPanel2.add(medicinePanel);
        centerPanel2.add(testPanel);

        for (int i = 0; i < 5; i++) {
            medicinePanel.add(medicineLabels[i]);
            medicinePanel.add(medicineFields[i]);
            medicinePanel.add(bOrAfterMeal[i]);
            medicinePanel.add(morning[i]);
            medicinePanel.add(afternoon[i]);
            medicinePanel.add(night[i]);

        }




        bottomPanel.add(clearButton);
        bottomPanel.add(backButton);
        bottomPanel.add(okButton);
        //---------------------------------------

        //------------Actions-------------
        clearButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clear();
                    }
                });

        backButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        //SearchInfo searchInfo = new SearchInfo();
                    }
                });

        okButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {


                        //jdghkjfhdglfkgjlkfdjhkl

                        ///

                        String name = patient.getName();
                        String age = patient.getAge();
                        String sex = patient.getSex();
                        
                        String problems = discriptionArea.getText();
                        String[] medicines = {"", "", "", "", ""};
                        String temp;// = "";
                        String checkBoxtemp;// = "";

                        int k = 0;
                        
                        for (int i = 0; i < 5; i++) {

                            if (!medicineFields[i].getText().isEmpty()) {

                                checkBoxtemp = String.format(" %s %s %s",
                                        morning[i].isSelected() ? "-Morning- " : "",
                                        afternoon[i].isSelected() ? " -Afternoon- " : "",
                                        night[i].isSelected() ? "-Night-" : "");

                                temp = String.format("" + (k+1) + ".  " + medicineFields[i].getText()
                                        + ":==> " + bOrAfter[bOrAfterMeal[i].getSelectedIndex()]
                                        + ", (" + checkBoxtemp + ")\n");

                                medicines[k] = temp;
                                k++;

                            }

                        }

                        PrescriptionData data = new PrescriptionData(name, age, sex, problems, medicines);

                        PrintEmail printEmail = new PrintEmail(data, patient);

                        dispose();

                    }
                });


        //-------------------------
        add(topPanel);
        add(centerPanel1);
        add(centerPanel2);
        add(bottomPanel);

        //--------------------------

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);
        
        setExtendedState(MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);


    }

    private void clear() {

        discriptionArea.setText("");
        for (int i = 0; i < 5; i++) {
            medicineFields[i].setText("");
            morning[i].setSelected(false);
            afternoon[i].setSelected(false);
            night[i].setSelected(false);

            bOrAfterMeal[i].setSelectedIndex(0);
        }

    }
}
