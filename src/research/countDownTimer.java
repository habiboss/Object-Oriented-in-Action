/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package research;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author UNKNOWN
 */
public class countDownTimer extends mainMenu implements ActionListener {
    
        public JButton starts, stops, reset;
        public Timer countdown;
        public JLabel timerLabel;
        public JPanel panel;
        int count = 0;
        long watchStart;
    public countDownTimer() {
 
    
    }
 public JPanel createTimer() {   
        panel = new JPanel();
        
        
        setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.black),
             BorderFactory.createEmptyBorder(10,10,10, 10)
        ));
        JLabel countdownTimer = new JLabel("Count Down Timer:");
        panel.add(countdownTimer);
        starts = new JButton("Start");
        starts.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            countdown.start();
            }
        });
        panel.add(starts);
        
        stops = new JButton("Stop");
        stops.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            countdown.stop();
            
            }
        });
        panel.add(stops);
        
        reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                countdown.stop();
                count = 0;
                timerLabel.setText("00:00");
            }
        });
        panel.add(reset);
        
        timerLabel = new JLabel("00:00");
        panel.add(timerLabel);
        
        countdown = new Timer(1000, new TimerListener());
       
        
     return panel;
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        count++;
        timerLabel.setText("00:"+count);
        }
        
    }

        
}
