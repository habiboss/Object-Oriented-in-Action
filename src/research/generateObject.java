/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package research;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;

/**
 *
 * @author UNKNOWN
 */
public class generateObject extends dbConnection implements ActionListener, ItemListener{
    JButton button;
    public JTextField textFieldinput;
    public JCheckBox [] checkBox;
    public JCheckBox check1, check2, check3, check4;
    public JRadioButton [] radio;
    public JComboBox comboBox;
    JPanel TextFieldPanel, ID;
    public JLabel Label_Values;
    JScrollPane scrollPane;
    public JLabel Label_Question;
    public String values;
    public String input_Type = "";
    ButtonGroup grp;
    //String[] value;
    public generateObject() {
        grp = new ButtonGroup();
        comboBox = new JComboBox();
        //checkBox = new JCheckBox[0];
        //radio = new JRadioButton[0];
        
        textFieldinput = new JTextField(); 
    }
    // creates panel for textField object to be used in answerquestion comboBox state
    public JPanel TextFieldObject  (String text, Container pane) {
        
       pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
       
        input_Type = "TextField";
        TextFieldPanel = new JPanel();
        //scrollPane = new JScrollPane(TextFieldPanel);
        //add(scrollPane, BorderLayout.CENTER);
        //addContainerPane(scrollPane, BorderLayout.CENTER);
        TextFieldPanel.setLayout(new GridLayout(0, 1));
        
        Label_Question = new JLabel();
        TextFieldPanel.add(Label_Question);
        Label_Question.setText(text);
        
        
        textFieldinput.setName("Text");
        TextFieldPanel.add(textFieldinput);
       
        pane.add(TextFieldPanel);
   
        return  TextFieldPanel;
    }
    // creates panel for combobox object to be used in answerquestion comboBox state
    public JPanel ComboBoxObject (String text, String test, Container pane) {
        TextFieldPanel = new JPanel();
        TextFieldPanel.setLayout(new GridLayout(0, 1));
        input_Type = "ComboBox";
        
        Label_Question = new JLabel();
        TextFieldPanel.add(Label_Question);
        Label_Question.setText(test);
        
        String[] strings = text.split(",");
        

        for (int i = 0; i < strings.length; i ++) {
          comboBox = new JComboBox(strings);  
          comboBox.addItemListener(this);
          
      }
        
        TextFieldPanel.add(comboBox);
        pane.add(TextFieldPanel);

        return TextFieldPanel;         
    }
    // creates panel for checkboxobjec object to be used in answerquestion comboBox state
    public JPanel checkBoxObject (String text, String values, Container pane) {
       TextFieldPanel = new JPanel();
       TextFieldPanel.setLayout(new GridLayout(0, 1)); 
       input_Type = "CheckBox";
       
       Label_Question = new JLabel();
       TextFieldPanel.add(Label_Question);
       Label_Question.setText(text);
       
       String[] strings = values.split(",");
       checkBox = new JCheckBox[strings.length];
        //radio = new JRadioButton[0];
      // JCheckBox sss;
       for (int i = 0; i < strings.length; i ++) {
       checkBox[i] = new JCheckBox(strings[i]);
       checkBox[i].addActionListener(this);

       TextFieldPanel.add(checkBox[i]);
          
      }      
       pane.add(TextFieldPanel); 
       
       return TextFieldPanel;
    }
    // creates panel for radioobject object to be used in answerquestion comboBox state
    public JPanel RadioObject (String text, String values, Container pane) {
       TextFieldPanel = new JPanel();
       TextFieldPanel.setLayout(new GridLayout(0, 1)); 
       input_Type = "Radio";
       
       Label_Question = new JLabel();
       TextFieldPanel.add(Label_Question);
       Label_Question.setText(text);
       
       String[] strings = values.split(",");

        radio = new JRadioButton[strings.length];
       for (int i = 0; i < strings.length; i ++) {   
       radio[i] = new JRadioButton(strings[i]);
       grp.add(radio[i]);  
       radio[i].addActionListener(this);
       TextFieldPanel.add(radio[i]);
      }  
       
       pane.add(TextFieldPanel); 
       
       return TextFieldPanel;
    }
    
        public void addContainerPane(Container pane, BorderLayout ae) {
        pane.setLayout(new ScrollPaneLayout());
        
        }
        // retrieve values from create object to be passed as dbconnection
    public String retrieve_values() {
        values = new String();
        String [] value = new String[10000];
        //List myList = new ArrayList();
        int i = 0;
        if (input_Type == "TextField") {
            values = textFieldinput.getText();
        } else if (input_Type == "ComboBox") {
            values = comboBox.getSelectedItem().toString();
        } else if (input_Type == "CheckBox") {
            values = "";
            for (int y = 0; y < checkBox.length; y++) {
            if (checkBox[y].isSelected()) {
            values = values + checkBox[y].getText() + "-";
             i++; 
            }
        } 
        } else if (input_Type == "Radio") {
            values = "";
            for (int y = 0; y < radio.length; y++) {
            if (radio[y].isSelected()) {
            values = values + radio[y].getText();
            i++;
            }
           
        }
        }
         System.out.println("->"+values);
        return values;
    }
    
    public void clearAlls() {
             //  if (input_Type == "TextField") {
            textFieldinput.setText("");
       // } else if (input_Type == "ComboBox") {
            //comboBox.setSelectedIndex(0);
       // } else if (input_Type == "CheckBox") {
            values = "";
            for (int y = 0; y < checkBox.length; y++) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
            if (checkBox[y].isSelected()) {
            checkBox[y].setSelected(false);
            }
        } 
        //} else if (input_Type == "Radio") {
            values = "";
            for (int y = 0; y < radio.length; y++) {
           if (radio[y].isSelected()) {
            radio[y].setSelected(false);
           }
           
        }
       // } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    
        public void createAndShowGUI() {
        //Create and set up the window.
        //Set up the content pane. 
        //Display the window.
        mainMenu layouts = new mainMenu();
        layouts.pack();
        layouts.setSize(200, 100);
        layouts.setVisible(true);
        //includes the Menu
        layouts.addWindowStateListener(new WindowStateListener() {

            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("windowStateChanged.");
            }
        });

    }
    
}

