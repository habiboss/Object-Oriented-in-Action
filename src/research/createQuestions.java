/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package research;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author UNKNOWN
 */
public class createQuestions extends dbConnection implements ItemListener, ActionListener {
    ///  create object
    private JTextField textfields[] = new JTextField[0];
    private JMenuBar topMenu;
    private JMenuItem Clear, Main_Menu, exit, Cancel, Save; 
    private JMenu menu;   
    private JTextField QtextField, Question1, Question2, Question3, Question4, Question5 ;
    private String RadioValues, CheckValues, ComboValues;
    private String [] inputType = {"TextField", "Radio", "CheckBox", "ComboBox"}; 
    private JComboBox type1, type2, type3, type4, type5;
    JPanel grid = new JPanel(new GridLayout(0, 2));
    JPanel box = new JPanel();
    public JFrame frame;
    
//initializing objects ////////////////////////////////////////

     JLabel GValue1 = new JLabel();   

     JLabel GValue2 = new JLabel(); 

     JLabel GValue3 = new JLabel();  

     JLabel GValue4 = new JLabel();  

     JLabel GValue5 = new JLabel();  
     
     
    //////////////////////////////////////////////////////////////
    public createQuestions() {
        
        topMenu = new JMenuBar();
        menu = new JMenu("File");
        topMenu.add(menu);
        Main_Menu = new JMenuItem("Main Menu");
        Main_Menu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
          
            mainMenu mn = new mainMenu();
          mn.createAndShowGUI();
          frame.setVisible(false);
            
            }
        });
        Save = new JMenuItem("Save");
        Save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           java.util.Date date = new java.util.Date();
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
           String formattedDate = sdf.format(date);
            conn1(QtextField.getText(), QtextField.getText(), Question1.getText(), type1.getSelectedItem().toString(), GValue1.getText(), formattedDate);
            conn2(QtextField.getText(), Question2.getText(), type2.getSelectedItem().toString(), GValue2.getText(), formattedDate);
            conn3(QtextField.getText(), Question3.getText(), type3.getSelectedItem().toString(), GValue3.getText(), formattedDate);
            conn4(QtextField.getText(), Question4.getText(), type4.getSelectedItem().toString(), GValue4.getText(), formattedDate);
            conn5(QtextField.getText(), Question5.getText(), type5.getSelectedItem().toString(), GValue5.getText(), formattedDate);
            clearAll();
            }
        });
        Cancel = new JMenuItem("Cancel");
        Cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             int reply = JOptionPane.showConfirmDialog(null, "Are you sure you to exit, All Progress will be lost", "Exit", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          mainMenu mn = new mainMenu();
          mn.createAndShowGUI();
          frame.setVisible(false);
        }
        else {
           
          //s System.exit(0);
        }
            }
        });
        Clear = new JMenuItem("Clear Text");
        Clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            clearText();
            }
        });
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // add object to form
        menu.add(Main_Menu);
        menu.addSeparator();
        menu.add(Save);
        menu.addSeparator();
        menu.add(Cancel);
        menu.addSeparator();
        menu.add(Clear);
        menu.addSeparator();
        menu.add(exit);
        ////////////////////////////////////
        QtextField = new JTextField();
        Question1 = new JTextField();
        Question2 = new JTextField();
        Question3 = new JTextField();
        Question4 = new JTextField();
        Question5 = new JTextField();
        
        type1 = new JComboBox(inputType);
        type2 = new JComboBox(inputType);
        type3 = new JComboBox(inputType);
        type4 = new JComboBox(inputType);
        type5 = new JComboBox(inputType);
    }
        public void closeFrame() {
         //JFrame frame = new JFrame();
         //frame.setVisible(false);
         //frame.dispose();
         System.exit(0);
     }
        //create a container to add object
    private void addContainerPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        grid.setAlignmentX(10);
        grid.setAlignmentY(30);
        box.add(grid);
        addLabel("Questionaire Title", pane);
        
        pane.add(QtextField);
        addLabel("Type in Question1", pane);
        
        pane.add(Question1);
        addLabel("Please Choose an input Type", pane);
        
        pane.add(type1);
        type1.addItemListener(this);
        type1.setName("text");

        pane.add(GValue1);
        addLabel("Type in Question2", pane);
        
        pane.add(Question2);
        addLabel("Please Choose an input Type", pane);
        
        pane.add(type2);
        type2.addItemListener(this);
        type2.setName("2");

        pane.add(GValue2);
        addLabel("Type in Question3", pane);
        
        pane.add(Question3);
        addLabel("Please Choose an input Type", pane);
        
        pane.add(type3);
        type3.addItemListener(this);
        type3.setName("3");

        pane.add(GValue3);
        addLabel("Type in Question4", pane);
        
        pane.add(Question4);
        addLabel("Please Choose an input Type", pane);
        
        pane.add(type4);
        type4.addItemListener(this);
        type4.setName("4");

        pane.add(GValue4);
        addLabel("Type in Question5", pane);
        
        pane.add(Question5);
        addLabel("Please Choose an input Type", pane);
        
        pane.add(type5);
        type5.addItemListener(this);
        type5.setName("5");

        pane.add(GValue5);     
    }
    // clears all string from object after save
    private void clearAll() {
        JOptionPane.showMessageDialog(null, QtextField.getText() + " Questionnaire Created");
        QtextField.setText("");
        Question1.setText("");
        Question2.setText("");
        Question3.setText("");
        Question4.setText("");
        Question5.setText("");
        GValue1.setText("");
        GValue2.setText("");
        GValue3.setText("");
        GValue4.setText("");
        GValue5.setText("");
        
    }
    public void clearText() {
             QtextField.setText("");
        Question1.setText("");
        Question2.setText("");
        Question3.setText("");
        Question4.setText("");
        Question5.setText("");
        GValue1.setText("");
        GValue2.setText("");
        GValue3.setText("");
        GValue4.setText("");
        GValue5.setText("");   
    }
    
    private void addComboBox(Container container) {
        String [] inputType = {"TextField", "Radio", "CheckBox", "ComboBox"}; 
        JComboBox select = new JComboBox(inputType);
        select.setSelectedIndex(0);
        select.getSelectedItem().toString();
        container.add(select);
    } 
    /////////////////create radio button in 1st panel////////////////////////////////////////////
    private void customizeRadioButton1() {  
//        do {
//            RadioNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Radio Button you want",""));
//            Gnumbers1.setText("" + RadioNum);
//        } while (RadioNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            RadioValues = JOptionPane.showInputDialog("Please type in the Name of your Radio Button Separated by Commas","");
            GValue1.setText("" + RadioValues );
        }       
    }
        private void customizeRadioButton2() {  
//        do {
//            RadioNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Radio Button you want",""));
//            Gnumbers2.setText("" + RadioNum);
//        } while (RadioNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            RadioValues = JOptionPane.showInputDialog("Please type in the Name of your Radio Button Separated by Commas","");
            GValue2.setText("" + RadioValues );
        }       
    }
         private void customizeRadioButton3() {  
//        do {
//            RadioNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Radio Button you want",""));
//            Gnumbers3.setText("" + RadioNum);
//        } while (RadioNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            RadioValues = JOptionPane.showInputDialog("Please type in the Name of your Radio Button Separated by Commas","");
            GValue3.setText("" + RadioValues );
        }       
    }
           private void customizeRadioButton4() {  
//        do {
//            RadioNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Radio Button you want",""));
//            Gnumbers4.setText("" + RadioNum);
//        } while (RadioNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            RadioValues = JOptionPane.showInputDialog("Please type in the Name of your Radio Button Separated by Commas","");
            GValue4.setText("" + RadioValues );
        }       
    }
           private void customizeRadioButton5() {  
//        do {
//            RadioNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Radio Button you want",""));
//            Gnumbers5.setText("" + RadioNum);
//        } while (RadioNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            RadioValues = JOptionPane.showInputDialog("Please type in the Name of your Radio Button Separated by Commas","");
            GValue5.setText("" + RadioValues );
        }       
    }
    
    /////////////////create checkbox button in 1st panel////////////////////////////////////////////              
    private void customizeCheckBoxButton1() {
//       do {
//            CheckNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of ComboBox Button you want",""));
//            Gnumbers1.setText("" + CheckNum);
//        } while (CheckNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            CheckValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue1.setText("" + CheckValues );
        }  
    }
        private void customizeCheckBoxButton2() {
//       do {
//            CheckNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Checkbox Button you want",""));
//            Gnumbers2.setText("" + CheckNum);
//        } while (CheckNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            CheckValues = JOptionPane.showInputDialog("Please type in the Name of your Checkbox Button Separated by Commas","");
            GValue2.setText("" + CheckValues );
        }  
    }
            private void customizeCheckBoxButton3() {
//       do {
//            CheckNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Checkbox Button you want",""));
//            Gnumbers3.setText("" + CheckNum);
//        } while (CheckNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            CheckValues = JOptionPane.showInputDialog("Please type in the Name of your Checkbox Button Separated by Commas","");
            GValue3.setText("" + CheckValues );
        }  
    }
                private void customizeCheckBoxButton4() {
//       do {
//            CheckNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Checkbox Button you want",""));
//            Gnumbers4.setText("" + CheckNum);
//        } while (CheckNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            CheckValues = JOptionPane.showInputDialog("Please type in the Name of your Checkbox Button Separated by Commas","");
            GValue4.setText("" + CheckValues );
        }  
    }
                    private void customizeCheckBoxButton5() {
//       do {
//            CheckNum = Integer.parseInt(JOptionPane.showInputDialog("Please type in the number of Checkbox Button you want",""));
//            Gnumbers5.setText("" + CheckNum);
//        } while (CheckNum < 1);
        for (int y = 0 ; y < 1 ; y++ ) {
            CheckValues = JOptionPane.showInputDialog("Please type in the Name of your Checkbox Button Separated by Commas","");
            GValue5.setText("" + CheckValues );
        }  
    } 
    /////////////////create comboBox button in 1st panel////////////////////////////////////////////     
    private void customizeComboBox1() {
        for (int y = 0 ; y < 1 ; y++ ) {
            ComboValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue1.setText("" + ComboValues );
        }  
    }
    private void customizeComboBox2() {
        for (int y = 0 ; y < 1 ; y++ ) {
            ComboValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue2.setText("" + ComboValues );
        }  
    }
    private void customizeComboBox3() {
        for (int y = 0 ; y < 1 ; y++ ) {
            ComboValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue3.setText("" + ComboValues );
        }  
    }
    private void customizeComboBox4() {
        for (int y = 0 ; y < 1 ; y++ ) {
            ComboValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue4.setText("" + ComboValues );
        }  
    }
    private void customizeComboBox5() {
        for (int y = 0 ; y < 1 ; y++ ) {
            ComboValues = JOptionPane.showInputDialog("Please type in the Name of your ComboBox Button Separated by Commas","");
            GValue5.setText("" + ComboValues );
        }  
    }

    
    private void addLabel(String text, Container container) {
        JLabel label = new JLabel(text); 
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }
    
    public void addTextfield(String text, Container container) {
        JTextField textField = new JTextField();
        textField.setName(text);
        textField.setAlignmentY(Component.CENTER_ALIGNMENT);
        container.add(textField);
        textField.getText();  
        //for (int i = 0; i < textfields.length; i++) {
           //Increase size of array by 1
        textfields = Arrays.copyOf(textfields, textfields.length + 1);
        //Store something in the last element
        textfields[textfields.length-1] = textField;//Store something in the last element 
        //textField = textfields[textfields.length];
        //}      
    }
    public void getTextfieldName(String name) {
        addTextfield(name, null); 
    }
    // create and show GUI
     public void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Create Questionnaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addContainerPane(frame.getContentPane());
        //Display the window.
        frame.setSize(300, 600);
        frame.setVisible(true);      
        //includes the Menu
        frame.setJMenuBar(topMenu);
    }
  
  // handle change state of comboBox
    public void itemStateChanged(ItemEvent e) {
//////////////////////////////////RADIO/////////////////////////////
             if (type1.getSelectedItem().equals("Radio")) {
                  if  (!type1.getName().equals("radio")) {
                          System.out.println("state changed");
                            type1.setName("radio");
                            customizeRadioButton1();
                     }
             }
             if (type2.getSelectedItem().equals("Radio")) {
                    if  (!type2.getName().equals("radio")) {
                          System.out.println("state changed");
                            type2.setName("radio");
                            customizeRadioButton2();
                     }
                 }
             if (type3.getSelectedItem().equals("Radio")) {
                       if  (!type3.getName().equals("radio")) {
                          System.out.println("state changed");
                            type3.setName("radio");
                            customizeRadioButton3();
                     }
                 } 
             if (type4.getSelectedItem().equals("Radio")) {
                     if  (!type4.getName().equals("radio")) {
                          System.out.println("state changed");
                            type4.setName("radio");
                            customizeRadioButton4();
                     }
                 }
             if (type5.getSelectedItem().equals("Radio")) {
                    if  (!type5.getName().equals("radio")) {
                          System.out.println("state changed");
                            type5.setName("radio");
                            customizeRadioButton5();
                     }
                 }  
/////////////////////////////CHECKBOX////////////////////////////////////////////////////////
            if (type1.getSelectedItem().equals("CheckBox")) {
                  if  (!type1.getName().equals("check")) {
                          System.out.println("state changed");
                            type1.setName("check");
                            customizeCheckBoxButton1();
                     }
                 }
            if (type2.getSelectedItem().equals("CheckBox")) {
                  if  (!type2.getName().equals("check")) {
                          System.out.println("state changed");
                            type2.setName("check");
                            customizeCheckBoxButton2();
                     }
                 }
            if (type3.getSelectedItem().equals("CheckBox")) {
                  if  (!type3.getName().equals("check")) {
                          System.out.println("state changed");
                            type3.setName("check");
                            customizeCheckBoxButton3();
                     }
                 }
            if (type4.getSelectedItem().equals("CheckBox")) {
                  if  (!type4.getName().equals("check")) {
                          System.out.println("state changed");
                            type4.setName("check");
                            customizeCheckBoxButton4();
                     }
                 }
            if (type5.getSelectedItem().equals("CheckBox")) {
                  if  (!type5.getName().equals("check")) {
                          System.out.println("state changed");
                            type5.setName("check");
                            customizeCheckBoxButton5();
                     }
                 }
////////////////////////////////COMBOBOX//////////////////////////////////
            if (type1.getSelectedItem().equals("ComboBox")) {
                   if  (!type1.getName().equals("combo")) {
                          System.out.println("state changed");
                            type1.setName("combo");
                            customizeComboBox1();
                     }
                }
            if (type2.getSelectedItem().equals("ComboBox")) {
                   if  (!type2.getName().equals("combo")) {
                          System.out.println("state changed");
                            type2.setName("combo");
                            customizeComboBox2();
                     }
                }
            if (type3.getSelectedItem().equals("ComboBox")) {
                   if  (!type3.getName().equals("combo")) {
                          System.out.println("state changed");
                            type3.setName("combo");
                            customizeComboBox3();
                     }
                }
            if (type4.getSelectedItem().equals("ComboBox")) {
                   if  (!type4.getName().equals("combo")) {
                          System.out.println("state changed");
                            type4.setName("combo");
                            customizeComboBox4();
                     }
                }
            if (type5.getSelectedItem().equals("ComboBox")) {
                   if  (!type5.getName().equals("combo")) {
                          System.out.println("state changed");
                            type5.setName("combo");
                            customizeComboBox5();
                     }
                }

 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
    
        
    



  
    
}



