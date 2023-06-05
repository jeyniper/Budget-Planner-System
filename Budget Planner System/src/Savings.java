import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Vector;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.io.IOException;
import java.awt.Window.Type;

public class Savings extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Savings frame = new Savings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				//Name of the Frame is set to "AboutMe"
				}
			}
		});
	}
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Date"); 
	private JTextField name;
	private JTextField contact;
	private JTextField course;
	DefaultTableModel model;
	private JTable table;
	protected Vector<?> row;

	Savings() {

		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1300, 750);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setBackground(new Color(0, 0, 102));
		panel.setLayout(null);
		lblNewLabel.setBounds(143, 82, 70, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(143, 138, 70, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Monthly Salary");
		lblNewLabel_2.setBounds(129, 194, 100, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.WHITE);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Projected Expenses");
		lblNewLabel_3.setBounds(91, 250, 181, 14);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.WHITE);
		panel.add(lblNewLabel_3);
		
		JTextField id = new JTextField();
		id.setBounds(34, 107, 307, 20);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(34, 163, 307, 20);
		panel.add(name);
		name.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(34, 219, 307, 20);
		panel.add(contact);
		contact.setColumns(10);
		
		course = new JTextField();
		course.setBounds(34, 275, 307, 20);
		panel.add(course);
		course.setColumns(10);
	
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(34, 306, 126, 29);
		btnNewButton.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent arg0) {
		if(id.getText().equals("")||name.getText().equals("") || course.getText().equals("")
				||contact.getText().equals("") ||course.getText().equals("") )
		{
		JOptionPane.showMessageDialog(null, "Please Fill Complete Information");
		}				
		else
		{
			String[] row = new String[4];		
			row [0] = id.getText();
			row [1] = name.getText();				
			row [2] = contact.getText();
			row [3] = course.getText();
			
			model.addRow(row);
				
				id.setText("");
				name.setText("");			
		      	contact.setText("");
		      	course.setText("");
		      	JOptionPane.showMessageDialog(null, "Saved Succesfully");
		}
					}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setBounds(215, 306, 126, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int i =table.getSelectedRow();
			model.setValueAt(id.getText(), i, 0);
			model.setValueAt(name.getText(), i, 1);
			model.setValueAt(contact.getText(), i, 2);
			model.setValueAt(course.getText(), i, 3);
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBounds(34, 346, 126, 35);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int i = table.getSelectedRow();
			if(i>=0)
			{	
			model.removeRow(i);
			JOptionPane.showMessageDialog(null, "Deleted Succesfully");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Select A Row First");	
			}
			}
			
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.setBounds(215, 346, 126, 35);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  id.setText("");
			  name.setText("");
			  contact.setText("");
			  course.setText("");
			}
		});
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 11, 870, 630);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
    
@Override 
			public void mouseClicked(MouseEvent e) {
                  int i=table.getSelectedRow();
                  id.setText(model.getValueAt(i, 0).toString());
                  name.setText(model.getValueAt(i, 1).toString());
                  contact.setText(model.getValueAt(i, 2).toString());
                  course.setText(model.getValueAt(i, 3).toString());
			}
		});
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel();
		Object[] column = {"Date","Name","Monthly Salary","P.E"};
	    Object [] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("   SAVINGS");
		lblNewLabel_4.setBounds(10, 0, 316, 71);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(Color.WHITE);
		panel.add(lblNewLabel_4);
		
		 JButton btnSave = new JButton("SAVE");
		 btnSave.setBounds(129, 399, 119, 35);
	        btnSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                saveData();
	            }
	        });
	        panel.add(btnSave);
	        
	        JButton btnNewButton_4 = new JButton("BACK");
	        btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
                    new MainPage();
                    dispose();
	            }
	        });

	        btnNewButton_4.setBounds(10, 657, 89, 35);
	        panel.add(btnNewButton_4);
	        // Rest of your code...
	    }

	    private void saveData() {
	        String filename = "data.txt"; // Specify the filename to save the data
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
	            int rowCount = model.getRowCount();
	            int columnCount = model.getColumnCount();

	            // Write column names to the file
	            for (int i = 0; i < columnCount; i++) {
	                writer.write(model.getColumnName(i));
	                if (i < columnCount - 1) {
	                    writer.write("\t");
	                }
	            }
	            writer.newLine();

	            // Write data to the file
	            for (int i = 0; i < rowCount; i++) {
	                for (int j = 0; j < columnCount; j++) {
	                    writer.write(model.getValueAt(i, j).toString());
	                    if (j < columnCount - 1) {
	                        writer.write("\t");
	                    }
	                }
	                writer.newLine();
	            }

	            JOptionPane.showMessageDialog(null, "Data saved successfully!");
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, "Error occurred while saving the data.");
	            e.printStackTrace();
	         
	        }
	    }
	}
