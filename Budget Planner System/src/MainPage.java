import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
	public static void main(String[] args) {
		new MainPage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
			{
				try {
					Savings frame = new Savings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    MainPage () {

        JLabel imageLabel = new JLabel();
        ImageIcon bgImage = new ImageIcon("Homepage.png");
        imageLabel.setIcon(bgImage);
        this.add(imageLabel);

         // networth button
        JButton networthButton = new JButton();
        ImageIcon networthB = new ImageIcon("networthb.png");
        networthButton.setIcon(networthB);
        networthButton.setBounds(500, 250, 400, 65);

        // event handler for networth button
        EventHandler handler = new EventHandler();
        networthButton.addActionListener(handler);
        imageLabel.add(networthButton);
       
     // savings button
        JButton savingsButton = new JButton();
        ImageIcon savingsB = new ImageIcon("savingsb.png");
        savingsButton.setIcon(savingsB);
        savingsButton.setBounds(500, 360, 400, 65);

        // event handler for savings button
        savingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Savings frame = new Savings();
                frame.setVisible(true);
                dispose();
            }
        });
        
        imageLabel.add(savingsButton);

        // Rest of your code...
        
        // event handler for savings button
        EventHandler1 handler1 = new EventHandler1();
        savingsButton.addActionListener(handler1);
        imageLabel.add(savingsButton);

        // cashflow button
        JButton cashflowButton = new JButton();
        ImageIcon cashflowB = new ImageIcon("cashflowb.png");
        cashflowButton.setIcon(cashflowB);
        cashflowButton.setBounds(500, 480, 400, 65);

        // event handler for cashflow button
        EventHandler2 handler2 = new EventHandler2();
        cashflowButton.addActionListener(handler2);
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
                new NetworthStatement();
                dispose(); // close the frame
            }
        }
    
        private class EventHandler1 implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to networth frame
                new Savings();
                dispose(); // close the frame
            }
        }
    
        private class EventHandler2 implements ActionListener {
    
            public void actionPerformed(ActionEvent event) {
    
                // goes to savings frame
                new CashFlow();
                dispose(); // close the frame
            }
        }
}