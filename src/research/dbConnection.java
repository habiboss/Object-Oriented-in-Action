/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package research;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author UNKNOWN
 */
public class dbConnection{

   //public static void main (String [] args) {
        private Connection conn = null;
        private String query1, query2, query3, query4, query5, query6;
         // create connection and insert for createQuestions class       
        protected void conn1(String title, String text1, String text2, String text3, String text4, String dates) {
        
        
        try {
            createQuestions cr = new createQuestions();
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");
            Statement stmt1 = conn.createStatement();
           Statement stmt6 = conn.createStatement();
            query1 = "insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type, Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "', '" + text4 + "', '" + dates + "')";
          query6 = "insert into questionnaire_Title(title) values ('" + title + "')";
           System.out.println("insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')");
            stmt1.executeUpdate(query1);

           stmt6.executeUpdate(query6);

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

             // create connection and insert for createQuestions class       
        protected void conn2(String text1, String text2, String text3, String text4, String dates) {
        try {
            createQuestions cr = new createQuestions();
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");

           Statement stmt2 = conn.createStatement();
            query2 = "insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type, Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "', '" + text4 + "', '" + dates + "')";
           System.out.println("insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')");
           stmt2.executeUpdate(query2);
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
    
            // create connection and insert for createQuestions class       
        protected void conn3(String text1, String text2, String text3, String text4, String dates) {

        try {
            createQuestions cr = new createQuestions();
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");

           Statement stmt3 = conn.createStatement();
           query3 = "insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type, Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "', '" + text4 + "', '" + dates + "')";
           System.out.println("insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')");

           stmt3.executeUpdate(query3);

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
    // create connection and insert for createQuestions class       
             
        protected void conn4(String text1, String text2, String text3, String text4, String dates) {

        try {
            createQuestions cr = new createQuestions();
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");

           Statement stmt4 = conn.createStatement();

           query4 = "insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')";
          System.out.println("insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')");
           stmt4.executeUpdate(query4);
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
        
          // create connection and insert for createQuestions class              
        protected void conn5(String text1, String text2, String text3, String text4, String dates) {

        try {
            createQuestions cr = new createQuestions();
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\UNKNOWN\\Downloads\\research.sqlite");

           Statement stmt5 = conn.createStatement();

         query5 = "insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')";
           System.out.println("insert into create_questionnaire(Questionnaire_Title, Questions, Input_Type,  Type_Values, Dates) values ('" + text1 + "', '" + text2 + "', '" + text3 + "',  '" + text4 + "', '" + dates + "')");
          stmt5.executeUpdate(query5);
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
}
