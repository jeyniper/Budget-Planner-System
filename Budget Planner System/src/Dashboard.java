import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    Dashboard () {

        JLabel imageLabel = new JLabel();
        ImageIcon bgImage = new ImageIcon("dashboardbg.png");
        imageLabel.setIcon(bgImage);
        this.add(imageLabel);

         // home button
         JButton homeButton = new JButton();
         ImageIcon homeB = new ImageIcon("homeb.png");
         homeButton.setIcon(homeB);
         homeButton.setBounds(1100, 600, 150, 50);
 
         EventHandler handler = new EventHandler();
         homeButton.addActionListener(handler);
         imageLabel.add(homeButton);

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

            // goes to mainpage frame
            new MainPage();
            dispose(); // close the frame
        }
    }
}

