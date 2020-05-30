import java.awt.EventQueue; //Application Window

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobsMainWindow {

	private JFrame JobsmainFrame;
	private JButton prevButton;
	String use;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobsMainWindow jobswindow = new JobsMainWindow();
					jobswindow.JobsmainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	public JobsMainWindow() {
		initialize();
	}
	public JobsMainWindow(String user) {
		use=user;
		initialize();
	}

	private void initialize() {
		JobsmainFrame = new JFrame();
		JobsmainFrame.getContentPane().setBackground(new Color(135, 206, 235));
		JobsmainFrame.setBounds(450, 100, 671, 471);
		JobsmainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JobsmainFrame.setTitle("JOBS MAIN WINDOW");
		JobsmainFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JOB PORTAL");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(149, 38, 568, 65);
		JobsmainFrame.getContentPane().add(lblNewLabel);
		
		prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mainFrame = new MainWindow(use);
				mainFrame.setVisible(true);
				JobsmainFrame.dispose();
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		prevButton.setBounds(185, 337, 282, 38);
		JobsmainFrame.getContentPane().add(prevButton);
		
		JButton applytojobsButton = new JButton("1. APPLY TO JOBS");
		applytojobsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplytoJobsWindow window = new ApplytoJobsWindow(use);
				JobsmainFrame.dispose();
			}
		});
		applytojobsButton.setBackground(new Color(255, 255, 255));
		applytojobsButton.setFont(new Font("Georgia", Font.PLAIN, 22));
		applytojobsButton.setBounds(134, 137, 374, 54);
		JobsmainFrame.getContentPane().add(applytojobsButton);
		
		JButton displayalljobsButton = new JButton("2. DISPLAY ALL JOBS");
		displayalljobsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Displayall2Window displayallwindow = new Displayall2Window(use);
				JobsmainFrame.dispose();
			}
		});
		displayalljobsButton.setBackground(new Color(240, 255, 240));
		displayalljobsButton.setFont(new Font("Georgia", Font.PLAIN, 22));
		displayalljobsButton.setBounds(134, 243, 374, 54);
		JobsmainFrame.getContentPane().add(displayalljobsButton);
		
		JLabel jobicon = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/jobseeker.png")).getImage();
		jobicon.setIcon(new ImageIcon(im));
		jobicon.setBounds(418, 27, 111, 88);
		JobsmainFrame.getContentPane().add(jobicon);

		
		JobsmainFrame.setVisible(true);
	}

}
