/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package research;


import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author UNKNOWN
 */
public class mainMenu extends JFrame implements ActionListener {
    createQuestions create_form_display = new createQuestions();
    private JButton createQuestions, answerQuestions;
    public JMenuBar topMenu;
    public JMenuItem exit; 
    public JMenu menu;
    JPanel buttonPanel;
    JButton button, create, answer, view_report;
    
    
    
    
    
    
    
    mainMenu() { 
        topMenu = new JMenuBar(); 
        menu = new JMenu("File");
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           System.exit(0);
            }
        });
        topMenu.add(menu);
        menu.add(exit);
        menu.addSeparator(); 
        
    }
    
    public void addComponentToPane(Container pane) {
        
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        //addAButton("Create", "Create Question", pane);
        //addAButton("Answer", "Answer Question", pane);
        //addAButton("View", "View Report", pane);
        
        create = new JButton("Create");
        pane.add(create);
        create.setSize(100, 600);
        create.addActionListener(new ActionListener() {
        //inline action listern//
            @Override
            public void actionPerformed(ActionEvent e) {
            createQuestions cr = new createQuestions();
            cr.createAndShowGUI();
            setVisible(false);
            }
        });
        
        answer = new JButton("Answer");
        pane.add(answer);
        answer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            AnswerQuestionnaire anw = new AnswerQuestionnaire();
            anw.createAndShowGUI();
            setVisible(false);
            }
        });
    }
    // function //creates button
    public void addAButton(String Name, String Text, Container container) {
        
        button = new JButton(Text);
        button.setName(Name);
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);

    }
    public void displayMenu() {
       // dispatchEvent(new WindowEvent(WindowEvent.WINDOW_CLOSING));
        setVisible(true);
    }
     /// function/// create GUI
        public void createAndShowGUI() {
        //Create and set up the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentToPane(getContentPane());
        
        //Display the window.
        pack();
        setVisible(true);
        setSize(100, 200);
        //includes the Menu
        setJMenuBar(topMenu);
    }
        public void actionPerformed(ActionEvent e) {
        createQuestions create = new createQuestions();
        if (button.getName().equals("Create")) {
            create.createAndShowGUI();
        }         
    }
        
        public static void main (String [] args) {
            //mainMenu start = new mainMenu();
            //start.createAndShowGUI();
            mainMenu a2 = new countDownTimer();
            a2.createAndShowGUI();
        }
}
