//Application Window
import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class BusinessMainWindow {

	private JFrame businessmainFrame;
	String companynamee;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessMainWindow window = new BusinessMainWindow();
					window.businessmainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	public BusinessMainWindow() {
		initialize();
	}
	public BusinessMainWindow(String companyname) {
		companynamee=companyname;
		initialize();
	}

	private void initialize() {
		businessmainFrame = new JFrame();
		businessmainFrame.setBounds(350, 100, 836, 621);
		businessmainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		businessmainFrame.setTitle("BUSINESS MAIN WINDOW");
		businessmainFrame.getContentPane().setBackground(new Color(135, 206, 235));
		businessmainFrame.getContentPane().setLayout(null);
		
		
		JLabel businesswelcomeLabel = new JLabel("WELCOME TO YOUR BUSINESS PAGE");
		businesswelcomeLabel.setForeground(new Color(255, 255, 255));
		businesswelcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		businesswelcomeLabel.setBounds(53, 24, 779, 85);
		businessmainFrame.getContentPane().add(businesswelcomeLabel);
		
		JLabel businesswhatLabel = new JLabel("What do you want to do today?");
		businesswhatLabel.setForeground(new Color(255, 255, 255));
		businesswhatLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		businesswhatLabel.setBounds(139, 119, 452, 65);
		businessmainFrame.getContentPane().add(businesswhatLabel);
		
		JButton postjobsButton = new JButton("1. POST JOB VACANCIES");
		postjobsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostJobsWindow postjobsFrame = new PostJobsWindow(companynamee);
				businessmainFrame.dispose();
			}
		});
		postjobsButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		postjobsButton.setBackground(new Color(240, 230, 140));
		postjobsButton.setBounds(241, 222, 328, 50);
		businessmainFrame.getContentPane().add(postjobsButton);
				
		JButton candidateButton = new JButton("2. SELECT CANDIDATES");
		candidateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SelectCandidates candidateswindow = new SelectCandidates(companynamee);
				businessmainFrame.dispose();
			}
		}); 
		candidateButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		candidateButton.setBackground(new Color(240, 230, 140));
		candidateButton.setBounds(241, 313, 328, 57);
		businessmainFrame.getContentPane().add(candidateButton);
		
		JLabel picLabel = new JLabel("");
		Image imag = new ImageIcon(this.getClass().getResource("/idea.png")).getImage();
		picLabel.setIcon(new ImageIcon(imag));
		picLabel.setBounds(601, 107, 94, 91);
		businessmainFrame.getContentPane().add(picLabel);
		
		JButton viewallButton = new JButton("3. DISPLAY ALL JOB VACANCIES");
		viewallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayallWindow displaywindow = new DisplayallWindow(companynamee);
				businessmainFrame.dispose();
			}
		});
		viewallButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		viewallButton.setBackground(new Color(240, 230, 140));
		viewallButton.setBounds(241, 412, 328, 57);
		businessmainFrame.getContentPane().add(viewallButton);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window1 = new LoginWindow();
				businessmainFrame.dispose();
			}
		});
		logoutButton.setBackground(new Color(220, 20, 60));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logoutButton.setBounds(340, 506, 130, 36);
		businessmainFrame.getContentPane().add(logoutButton);

		businessmainFrame.setVisible(true);

	}

}
