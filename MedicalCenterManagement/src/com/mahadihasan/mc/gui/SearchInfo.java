package com.mahadihasan.mc.gui;

import com.mahadihasan.mc.db.AllInformation;
import com.mahadihasan.mc.patient.Patient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class SearchInfo extends JFrame {

    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton prescribeButton;
    private JButton backbButton;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    //-------------------------
    private JLabel[] ptnt_info;

    //------------------------
    public SearchInfo() {

        super("Search");

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);


        //------------------------------
        topPanel = new JPanel();
        centerPanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setBackground(Color.CYAN);
        centerPanel.setBackground(Color.GREEN);
        bottomPanel.setBackground(Color.BLUE);

        centerPanel.setLayout(new GridLayout(1, 2, 2, 3));

        leftPanel = new JPanel();
        rightPanel = new JPanel();

        //---------------------------------
        leftPanel.setLayout(new GridLayout(10, 1, 2, 2));


        ptnt_info = new JLabel[10];


        for (int i = 0; i < 10; i++) {
            ptnt_info[i] = new JLabel();
            leftPanel.add(ptnt_info[i]);
        }


        //---------------------------------

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);


        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 100;
        constraints.weighty = 1;
        addComponent(topPanel, 0, 0, 1, 1);
        constraints.weightx = 100;
        constraints.weighty = 10;
        addComponent(centerPanel, 1, 0, 1, 3);
        constraints.weightx = 100;
        constraints.weighty = 1;
        addComponent(bottomPanel, 4, 0, 1, 1);


        //--------------------

        centerPanel.setVisible(false);
        bottomPanel.setVisible(false);


        //--------------Components------

        searchLabel = new JLabel("Search : ");
        searchField = new JTextField(12);
        searchButton = new JButton("Search");

        searchField.setBackground(Color.ORANGE);

        searchField.setToolTipText("Enter A Valid ID");
        searchButton.setToolTipText("Search By ID");
        prescribeButton = new JButton("Prescribe");

        backbButton = new JButton("Back");


        prescribeButton.setToolTipText("To Prescribe Click Here");
        backbButton.setToolTipText("To Back Click Here");

        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);


        bottomPanel.add(backbButton, BorderLayout.WEST);
        bottomPanel.add(prescribeButton, BorderLayout.EAST);

        //--------------Actions----------

        searchField.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
        searchButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {


                        String key = searchField.getText();
                        // two Methods Personal Information...//previous details


                        showPersonalInfo(key);
                        showPreviousRecord(key);

                        centerPanel.setVisible(true);
                        bottomPanel.setVisible(true);
                    }
                });

        prescribeButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {

                        String key = searchField.getText();
                        Patient patient;
                        AllInformation allInformation = new AllInformation();

                        patient = allInformation.getPersonalInformation(key);

                        Prescription prescription = new Prescription(patient);
                        //dispose();
                    }
                });

        backbButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        dispose();
                        //LogIn logIn = new LogIn();
                    }
                });
        //--------------------
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 500);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screanSize = toolkit.getScreenSize();

        int screanHeight = screanSize.height;
        int screanWidth = screanSize.width;
        setLocation(screanWidth / 4, screanHeight / 4);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }

    private void showPersonalInfo(String key) {
        
        Patient patient;
        AllInformation allInformation = new AllInformation();

        patient = allInformation.getPersonalInformation(key);
        //Patient object <== allData

        if (patient.getID() == null) {
            JOptionPane.showMessageDialog(null, "Not In Database");
            prescribeButton.setEnabled(false);
        } else {
            String[] data = new String[12];
            String[] title = {"ID : ", "Name : ", "Age : ", "Sex : ",
                "Blood Group: ", "Date Of Birth : ", "Height : ",
                "Weight : ", "Mobile No : ", "Email : "};

            Font font = new Font("Tahoma", Font.BOLD, 15);

            data[0] = patient.getID();

            data[1] = patient.getName();
            data[2] = patient.getAge();
            data[3] = patient.getSex();
            data[4] = patient.getBloodGroup();
            data[5] = patient.getDateOfBirth();
            data[6] = patient.getHeight();
            data[7] = patient.getWeight();
            data[8] = patient.getMobileNo();
            data[9] = patient.getEmail();

            for (int i = 0; i < 10; i++) {

                ptnt_info[i].setText("" + title[i] + data[i]);
                ptnt_info[i].setFont(font);
            }
            
            prescribeButton.setEnabled(true);
        }
    }

    private void showPreviousRecord(String key) {
        //Show previous record in right panel
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
