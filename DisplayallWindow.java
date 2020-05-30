import java.awt.EventQueue; //Application window

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayallWindow {

	private JFrame DisplayallFrame;
	String company;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayallWindow displaywindow = new DisplayallWindow();
					displaywindow.DisplayallFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	public DisplayallWindow() {
		initialize();
	}
	public DisplayallWindow(String comp) {
		company=comp;
		initialize();
	}

	private void initialize() {
		DisplayallFrame = new JFrame("DISPLAY ALL JOBS WINDOW");
		DisplayallFrame.getContentPane().setBackground(new Color(135, 206, 235));
		DisplayallFrame.getContentPane().setLayout(null);
		DisplayallFrame.setBounds(300, 100, 953, 674);
		DisplayallFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel displayallLabel = new JLabel("JOB VACANCIES");
		displayallLabel.setForeground(new Color(255, 255, 255));
		displayallLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		displayallLabel.setBounds(254, 10, 415, 102);
		DisplayallFrame.getContentPane().add(displayallLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(73, 122, 795, 413);
		DisplayallFrame.getContentPane().add(scroll);
		
		JLabel jobimage = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/jobseeker.png")).getImage();
		jobimage.setIcon(new ImageIcon(im));
		jobimage.setBounds(601, 21, 116, 91);
		DisplayallFrame.getContentPane().add(jobimage);
		
		JButton prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainWindow businessmainFrame = new BusinessMainWindow(company);
				DisplayallFrame.dispose();
				
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		prevButton.setBounds(341, 563, 282, 38);
		DisplayallFrame.getContentPane().add(prevButton);
		
		
		try {
		FileReader reader = new FileReader("commonjobportalfile.txt");
		BufferedReader br= new BufferedReader(reader);
		textArea.read(br,null);
		br.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "UNABLE TO DISPLAY JOB VACANCIES","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		DisplayallFrame.setVisible(true);
	}
}
