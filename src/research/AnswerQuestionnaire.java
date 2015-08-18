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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.EventListener;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author UNKNOWN
 */
public class AnswerQuestionnaire extends generateObject implements ActionListener, EventListener {

    mainMenu layouts = new mainMenu();
    JComboBox questionnaire_title;
    JMenuBar topMenu;
    JMenuItem Clear, Main_Menu, exit, Cancel, Save;
    JMenu menu;
    JLabel[] question3, question1;
    JLabel question2, ID, IDs;
    int arraySize = 1000;
    JPanel panel = new JPanel();
    String[] questions_label;
    String[] general;
    Container container = layouts.getContentPane();
    //JButton b = new JButton("aaa");
    JTextField[] textfield;
    generateObject[] Text;
    generateObject [] generateO;
    generateObject rmv = new generateObject();
    boolean changed = false;
    JLabel userID;
   // JLabel Status;
    //generateObject a1 = new AnswerQuestionnaire();
    mainMenu a2 = new countDownTimer();
    
    public AnswerQuestionnaire() {
       
      //  Status = new JLabel("Sddddd");
      //  Status.setLayout(new BorderLayout());
        //layouts.add(Status, BorderLayout.PAGE_END);
        String[] inputType = {"Please Choose a Topic"};
        questionnaire_title = new JComboBox(inputType);
        questionnaire_title.setSelectedIndex(0);
        questionnaire_title.setLayout(new BorderLayout());
        layouts.add(questionnaire_title, BorderLayout.PAGE_START);
        
        this.questionnaire_title.addItemListener(new ItemListener() {
        
            public void itemStateChanged(ItemEvent e) {

                Implementations();
                layouts.invalidate();
                layouts.validate();
                layouts.repaint();
                layouts.pack();
                layouts.validate();

            }
        });

        conn();
        
        /////////////////////////////
        questions_label = new String[10000];
        general = new String[10000];
        ////////////////////////////////
        topMenu = new JMenuBar();
        menu = new JMenu("File");
        topMenu.add(menu);
        Main_Menu = new JMenuItem("Main Menu");
        Main_Menu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
          mainMenu mn = new mainMenu();
          mn.createAndShowGUI();
          layouts.setVisible(false);
            }
        });
        Save = new JMenuItem("Save");
        Cancel = new JMenuItem("Cancel");
        Cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you to exit, All Progress will be lost", "Exit", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          mainMenu mn = new mainMenu();
          mn.createAndShowGUI();
          layouts.setVisible(false);
        }
            }
        });
        Clear = new JMenuItem("Clear Text");
        Clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  
                  for (int i = 0; i < Text.length; i++) {
                    Text[i].textFieldinput.setText("");
//                    Text[i].comboBox.setSelectedIndex(0);
                  //  Text[i].checkBox[i].setSelected(false);
                    
            }
            }
        });
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(Main_Menu);
        menu.addSeparator();
        menu.add(Save);
        Save.addActionListener(new ActionListener() {
     
            @Override
            public void actionPerformed(ActionEvent e) {
                conn1();
                //StatusBars("Status: Saved");
                id();
                
            }
        });
        menu.addSeparator();
        menu.add(Cancel);
        menu.addSeparator();
        menu.add(Clear);
        menu.addSeparator();
        menu.add(exit);
        generateO = new generateObject[100];
        ///////////////////////////////////
        question1 = new JLabel[arraySize];
        textfield = new JTextField[arraySize];
        layouts.add(panel);
        panel.setLayout(new GridLayout(0, 1));
        ID = new JLabel();
        layouts.add(ID);
        IDs = new JLabel();
        userID = new JLabel();
        //StatusBars(null);
    }
    //creates unique ID by merging random number with last ID in row
    public JPanel id() {
        //JPanel ids = new JPanel();
        //layouts.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Connection conn = null;
        String query = "";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");
            Statement stmt1 = conn.createStatement();
            query = "Select id from answer_questionnaire";
            ResultSet rs = stmt1.executeQuery(query);
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100);
            while (rs.next()) {
                rs.getRow();
                int id = rs.getInt("id") + 1;
                ID.setText(id + "0" + randomInt + "");    
            }
            userID.setText("User ID: " + ID.getText());
            
            panel.add(userID);
            rs.close();
            stmt1.close();
            System.out.print("User id :" + rs.getInt("id") + " ");
        }   catch (Exception e) {
        }
        
        return panel;
    }

    public void conn() {
        Connection conn = null;
        String query1 = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");
            Statement stmt1 = conn.createStatement();
            query1 = "Select title from questionnaire_Title";
            ResultSet rs = stmt1.executeQuery(query1);
            while (rs.next()) {
                questionnaire_title.addItem(rs.getString("title"));
            }
            rs.close();
            stmt1.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }
// create and show GUI
    public void createAndShowGUI() {
        //Create and set up the window.
        //Set up the content pane. 
        //Display the window.
        layouts.pack();
        layouts.setSize(200, 100);
        layouts.setVisible(true);
        layouts.setJMenuBar(topMenu);
        //includes the Menu
        layouts.addWindowStateListener(new WindowStateListener() {

            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("windowStateChanged.");
            }
        });

    }
// create panel with object from generatedObject Class when combobox state change
    private void Implementations() {
        Connection conn = null;
        String title1, count;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");
            Statement stmt1 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            int counter = 0;
            title1 = "Select * from create_questionnaire where Questionnaire_Title = '" + questionnaire_title.getSelectedItem().toString() + "' ";
            count = "SELECT COUNT(*) FROM create_questionnaire Where Questionnaire_Title = '" + questionnaire_title.getSelectedItem().toString() + "' ";
            ResultSet rs = stmt1.executeQuery(title1);
            //ResultSet rs1 = stmt2.executeQuery(questions);
            ResultSet recordCount = stmt3.executeQuery(count);
            recordCount.next();
            counter = recordCount.getInt(1);
            Text = new generateObject[counter];
            for (int i = 0; i < counter; i++) {
                Text[i] = new generateObject();
            }
            countDownTimer ae = new countDownTimer();
            layouts.getContentPane().removeAll();
            layouts.getContentPane().add(questionnaire_title);
            layouts.getContentPane().add(ae.createTimer());
            layouts.getContentPane().add(id());
            
           // layouts.getContentPane().add(Status , BorderLayout.PAGE_END);
            //layouts.getContentPane().add(StatusBars("Status: Uncomplete"));
            //layouts.getContentPane().add(IDs.setText("ID: "));
          
            int y = 0;
            while (rs.next()) {
                switch (rs.getString("Input_Type")) {
                    case "TextField":
                        layouts.add(Text[y].TextFieldObject(rs.getString("Questions"), container));
                        break;
                    case "ComboBox":
                        layouts.add(Text[y].ComboBoxObject(rs.getString("Type_Values"), rs.getString("Questions"), container));
                        break;
                    case "CheckBox":
                        layouts.add(Text[y].checkBoxObject(rs.getString("Questions"), rs.getString("Type_Values"), container));
                        break;
                    case "Radio":
                        layouts.add(Text[y].RadioObject(rs.getString("Questions"), rs.getString("Type_Values"), container));
                        break;
                }
                y++;

            }
          rs.close();
          stmt1.close();
          stmt3.close();
          conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }

    }

    public void conn1() {
        Connection conn = null;
        try {
            java.util.Date date = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:mm:ss a");
            String formattedDate = sdf.format(date);
            String query;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");
            Statement stmt1 = conn.createStatement();
            String[] Q_label = new String[10000];
            String[] A_values = new String[10000];
            int y = 0;
            for (int i = 0; i < Text.length; i++) {
                Q_label[i] = Text[i].Label_Question.getText();
                A_values[i] = Text[i].retrieve_values(); 
                query = "insert into answer_questionnaire(code, questionnaire_title, questions, answer, dates) values ('" + ID.getText() + "', '" + questionnaire_title.getSelectedItem().toString() + "', '" + Q_label[i] + "', '" + A_values[i] + "', '" + formattedDate + "')";
                System.out.println("insert into answer_questionnaire(questionnaire_title, questions, answer, dates) values ('" + ID.getText() + "', '" + questionnaire_title.getSelectedItem().toString() + "', '" + Q_label[i] + "', '" + A_values[i] + "', '" + formattedDate + "')");
                stmt1.executeUpdate(query);
                
                Text[i].textFieldinput.setText("");
     
                //Text[i].comboBox.setSelectedIndex(0);
                Text[i].grp.clearSelection();
                
                
                //
                
                
//                Text[i].checkBox[i].setSelected(false);
                
            }
           
                JOptionPane.showMessageDialog(null, "Questionnaire Saved");
               // clearAlls();
                conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            try {

                conn.close();
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }
    
    public JPanel StatusBars(String text ) {
    JLabel statusLabel = new JLabel("status: Uncomplete");
    JPanel statusPanel = new JPanel();
    statusLabel.setText(text);
        //JFrame frame = new JFrame();
    //layouts.setLayout(new BorderLayout());
    layouts.setSize(200, 200);
    statusLabel.setLayout(new BorderLayout());
// create the status bar panel and shove it down the bottom of the frame
    
    //statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    layouts.add(statusPanel);
    //statusPanel.setPreferredSize(new Dimension(layouts.getWidth(), 16));
    //statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
    
    //statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
    statusPanel.add(statusLabel, BorderLayout.PAGE_END);
    layouts.setVisible(true);
    
    return statusPanel;
    }
    
    
    


    public void actionPerformed(ActionEvent e) {
    }

}

