import java.awt.EventQueue; //Application window (Candidate Display)

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

public class Displayall2Window {

	private JFrame Displayall2Frame;
	String use;
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Displayall2Window displayallwindow = new Displayall2Window();
					displayallwindow.Displayall2Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	public Displayall2Window() {
		initialize();
	}
	public Displayall2Window(String user) {
		use=user;
		initialize();
	}

	private void initialize() {
		Displayall2Frame = new JFrame("DISPLAY ALL JOBS WINDOW");
		Displayall2Frame.getContentPane().setBackground(new Color(135, 206, 235));
		Displayall2Frame.setTitle("DISPLAY ALL JOBS WINDOW");
		Displayall2Frame.getContentPane().setLayout(null);
		Displayall2Frame.setBounds(300, 100, 953, 674);
		Displayall2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel displayallLabel = new JLabel("JOB VACANCIES");
		displayallLabel.setForeground(new Color(255, 255, 255));
		displayallLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		displayallLabel.setBounds(254, 10, 415, 102);
		Displayall2Frame.getContentPane().add(displayallLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(73, 122, 795, 413);
		Displayall2Frame.getContentPane().add(scroll);
		
		JLabel jobimage = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/jobseeker.png")).getImage();
		jobimage.setIcon(new ImageIcon(im));
		jobimage.setBounds(601, 21, 116, 91);
		Displayall2Frame.getContentPane().add(jobimage);
		
		JButton prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobsMainWindow jobswindow = new JobsMainWindow(use);
				Displayall2Frame.dispose();
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		prevButton.setBounds(341, 563, 282, 38);
		Displayall2Frame.getContentPane().add(prevButton);
		
		
		try {
		FileReader reader = new FileReader("commonjobportalfile.txt");
		BufferedReader br= new BufferedReader(reader);
		textArea.read(br,null);
		br.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "UNABLE TO DISPLAY JOB VACANCIES","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		Displayall2Frame.setVisible(true);
	}
}
