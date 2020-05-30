import java.awt.*;  //JFrame
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;

class MainWindow extends JFrame {

	private JPanel mainPanel;
	String usernamee;
	String another;
	String anotherone;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow mainFrame = new MainWindow();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */
	public MainWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 888, 750);
		setTitle("MAIN WINDOW");
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(135, 206, 235));
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("WELCOME TO CAREERBOOK");
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		welcomeLabel.setBounds(141, 10, 603, 85);
		mainPanel.add(welcomeLabel);
		
		JLabel whatLabel = new JLabel("What would you like to do today?");
		whatLabel.setForeground(new Color(255, 255, 255));
		whatLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		whatLabel.setBounds(151, 105, 534, 65);
		mainPanel.add(whatLabel);
		
		JButton resumenewButton = new JButton("1. CREATE MY RESUME");
		resumenewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		resumenewButton.setBackground(new Color(240, 230, 140));
		resumenewButton.setBounds(253, 195, 336, 55);
		resumenewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Creating resume");
				ResumeWindow ResumeFrame;
				try {
					ResumeFrame = new ResumeWindow(usernamee);
					ResumeFrame.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mainPanel.add(resumenewButton);
		
		JButton jobsButton = new JButton("3. APPLY TO JOBS");
		jobsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobsMainWindow jobswindow = new JobsMainWindow(usernamee);
				
				dispose();
			}
		});
		jobsButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jobsButton.setBackground(new Color(240, 230, 140));
		jobsButton.setBounds(253, 368, 336, 55);
		mainPanel.add(jobsButton);
		
		JButton aptitudeButton = new JButton("4. MOCK APTITUDE TEST");
		aptitudeButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		aptitudeButton.setBackground(new Color(240, 230, 140));
		aptitudeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MockTestWindow window10 = new MockTestWindow(usernamee);
				dispose();
				}
		});
		aptitudeButton.setBounds(253, 452, 336, 49);
		mainPanel.add(aptitudeButton);
		
		JButton touchButton = new JButton("5. GET IN TOUCH");
		touchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetInTouchWindow window = new GetInTouchWindow(usernamee);
				dispose();
			}
		});
		touchButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		touchButton.setBackground(new Color(240, 230, 140));
		touchButton.setBounds(253, 531, 336, 55);
		mainPanel.add(touchButton);
		
		JLabel ideaLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/idea.png")).getImage();
		ideaLabel.setIcon(new ImageIcon(img3));
		ideaLabel.setBounds(629, 90, 94, 91);
		mainPanel.add(ideaLabel);
		
		JButton viewresumeButton = new JButton("2. VIEW MY RESUME");
		try {
			File newone = new File(usernamee+".txt");
			another = Files.readAllLines(Paths.get(usernamee+".txt")).get(1);
			anotherone=another+"RESUME.txt";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		viewresumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewResumeWindow viewreswindow = new ViewResumeWindow(anotherone,usernamee);
				dispose();
			}
		});
		viewresumeButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		viewresumeButton.setBackground(new Color(240, 230, 140));
		viewresumeButton.setBounds(253, 276, 336, 55);
		mainPanel.add(viewresumeButton);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window1 = new LoginWindow();
				dispose();
			}
		});
		logoutButton.setBackground(new Color(220, 20, 60));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logoutButton.setBounds(360, 638, 130, 36);
		mainPanel.add(logoutButton);
	
	}
	
	public MainWindow(String username1) 
	{	
		usernamee=username1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 888, 750);
		setTitle("MAIN WINDOW");
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(135, 206, 235));
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("WELCOME TO CAREERBOOK");
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		welcomeLabel.setBounds(141, 10, 603, 85);
		mainPanel.add(welcomeLabel);
		
		JLabel whatLabel = new JLabel("What would you like to do today?");
		whatLabel.setForeground(new Color(255, 255, 255));
		whatLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		whatLabel.setBounds(151, 105, 534, 65);
		mainPanel.add(whatLabel);
		
		JButton resumenewButton = new JButton("1. CREATE MY RESUME");
		resumenewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		resumenewButton.setBackground(new Color(240, 230, 140));
		resumenewButton.setBounds(253, 195, 336, 55);
		resumenewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Creating resume");
				ResumeWindow ResumeFrame;
				try {
					ResumeFrame = new ResumeWindow(usernamee);
					ResumeFrame.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mainPanel.add(resumenewButton);
		
		JButton jobsButton = new JButton("3. APPLY TO JOBS");
		jobsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobsMainWindow jobswindow = new JobsMainWindow(usernamee);
				
				dispose();
			}
		});
		jobsButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jobsButton.setBackground(new Color(240, 230, 140));
		jobsButton.setBounds(253, 368, 336, 55);
		mainPanel.add(jobsButton);
		
		JButton aptitudeButton = new JButton("4. MOCK APTITUDE TEST");
		aptitudeButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		aptitudeButton.setBackground(new Color(240, 230, 140));
		aptitudeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MockTestWindow window10 = new MockTestWindow(usernamee);
				dispose();
				}
		});
		aptitudeButton.setBounds(253, 452, 336, 49);
		mainPanel.add(aptitudeButton);
		
		JButton touchButton = new JButton("5. GET IN TOUCH");
		touchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetInTouchWindow window = new GetInTouchWindow(usernamee);
				dispose();
			}
		});
		touchButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		touchButton.setBackground(new Color(240, 230, 140));
		touchButton.setBounds(253, 531, 336, 55);
		mainPanel.add(touchButton);
		
		JLabel ideaLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/idea.png")).getImage();
		ideaLabel.setIcon(new ImageIcon(img3));
		ideaLabel.setBounds(629, 90, 94, 91);
		mainPanel.add(ideaLabel);
		
		JButton viewresumeButton = new JButton("2. VIEW MY RESUME");
		try {
			File newone = new File(usernamee+".txt");
			another = Files.readAllLines(Paths.get(usernamee+".txt")).get(1);
			anotherone=another+"RESUME.txt";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		viewresumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewResumeWindow viewreswindow = new ViewResumeWindow(anotherone,usernamee);
				dispose();
			}
		});
		viewresumeButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		viewresumeButton.setBackground(new Color(240, 230, 140));
		viewresumeButton.setBounds(253, 276, 336, 55);
		mainPanel.add(viewresumeButton);
		
		JButton logoutButton = new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window1 = new LoginWindow();
				dispose();
			}
		});
		logoutButton.setBackground(new Color(220, 20, 60));
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logoutButton.setBounds(360, 638, 130, 36);
		mainPanel.add(logoutButton);
	}
}
