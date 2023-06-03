import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

    MainPage () {

        JLabel imageLabel = new JLabel();
        ImageIcon bgImage = new ImageIcon("Homepage.png");
        imageLabel.setIcon(bgImage);
        this.add(imageLabel);

         // dashboard button
         JButton dashboardButton = new JButton();
         ImageIcon dashboardB = new ImageIcon("dashboardb.png");
         dashboardButton.setIcon(dashboardB);
         dashboardButton.setBounds(500, 250, 350, 60);
 
         EventHandler handler = new EventHandler();
         dashboardButton.addActionListener(handler);
         imageLabel.add(dashboardButton);

         // networth button
        JButton networthButton = new JButton();
        ImageIcon networthB = new ImageIcon("networthb.png");
        networthButton.setIcon(networthB);
        networthButton.setBounds(500, 350, 350, 60);

        // event handler for networth button
        EventHandler1 handler1 = new EventHandler1();
        networthButton.addActionListener(handler1);
        imageLabel.add(networthButton);
       
        // savings button
        JButton savingsButton = new JButton();
        ImageIcon savingsB = new ImageIcon("savingsb.png");
        savingsButton.setIcon(savingsB);
        savingsButton.setBounds(500, 450, 350, 60);

        // event handler for savings button
        EventHandler2 handler2 = new EventHandler2();
        savingsButton.addActionListener(handler2);
        imageLabel.add(savingsButton);

        // cashflow button
        JButton cashflowButton = new JButton();
        ImageIcon cashflowB = new ImageIcon("cashflowb.png");
        cashflowButton.setIcon(cashflowB);
        cashflowButton.setBounds(500, 550, 350, 60);

        // event handler for cashflow button
        EventHandler3 handler3 = new EventHandler3();
        cashflowButton.addActionListener(handler3);
        imageLabel.add(cashflowButton);


         // System layout
         this.setLayout(new FlowLayout());
         this.setTitle("Budget Planner System");
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setSize(1300, 750);
         this.setVisible(true);
         this.setLocationRelativeTo(null);
         this.getContentPane().setBackground(null);
         this.setResizable(true);
        }

        private class EventHandler implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to dashboard frame
                new Dashboard();
                dispose(); // close the frame
            }
        }
    
        private class EventHandler1 implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to networth frame
                new NetworthStatement();
                dispose(); // close the frame
            }
        }
    
        private class EventHandler2 implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to works frame
                new Savings();
                dispose(); // close the frame
            }
        }
    
        private class EventHandler3 implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to resume frame
                new CashFlow();
                dispose(); // close the frame
            }
        }
}