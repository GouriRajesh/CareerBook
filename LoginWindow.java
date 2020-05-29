import java.awt.*;  //Application Window
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.*;
class LoginWindow {

	private JFrame loginFrame;
	private JTextField usernameText;
	private JPasswordField passwordText;

	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					LoginWindow window1 = new LoginWindow();
					window1.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	LoginWindow() {
		initialize();
	}	
	private void initialize() {
		loginFrame = new JFrame("LOGIN WINDOW");
		loginFrame.getContentPane().setBackground(new Color(135, 206, 235));
		loginFrame.setBounds(300, 100, 888, 607);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JLabel headingLabel = new JLabel("WELCOME TO CAREERBOOK!");
		headingLabel.setForeground(new Color(255, 255, 255));
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		headingLabel.setBounds(121, 25, 605, 49);
		loginFrame.getContentPane().add(headingLabel);
		
		JLabel bookLabel = new JLabel("");
		Image book = new ImageIcon(this.getClass().getResource("/bookicon.png")).getImage();
		bookLabel.setIcon(new ImageIcon(book));
		bookLabel.setBounds(716, 25, 63, 58);
		loginFrame.getContentPane().add(bookLabel);
		
		JLabel tagLabel = new JLabel("Your one stop location to building your career");
		tagLabel.setForeground(new Color(255, 255, 255));
		tagLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		tagLabel.setBounds(131, 84, 677, 42);
		loginFrame.getContentPane().add(tagLabel);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
		usernameLabel.setBounds(208, 150, 167, 58);
		loginFrame.getContentPane().add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameText.setBounds(452, 164, 217, 42);
		loginFrame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
		passwordLabel.setBounds(208, 218, 167, 58);
		loginFrame.getContentPane().add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordText.setBounds(452, 232, 217, 42);
		loginFrame.getContentPane().add(passwordText);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			
				File userfile = new File(usernameText.getText()+".txt"); 
				
				try {
					Scanner myReader = new Scanner(userfile);
					String datapass = myReader.nextLine();
					myReader.close();
					
					if (userfile.exists()==true && (passwordText.getText().compareTo(datapass))==0) {
						System.out.println("You have logged in!");
						MainWindow mainFrame = new MainWindow(usernameText.getText());
						mainFrame.setVisible(true);
						loginFrame.dispose();
				    }
					
					else if (userfile.exists()==true || (passwordText.getText().compareTo(datapass))!=0){
						System.out.println("User/File present but wrong password");
						invalidDiag frame = new invalidDiag();
						frame.setVisible(true);
					}
					
					} catch (FileNotFoundException e1) {
					
					System.out.println("User/File absent");
					invalidDiag frame = new invalidDiag();
					frame.setVisible(true);
				} 
			
			
			}});
		loginButton.setBackground(new Color(255, 153, 102));
		loginButton.setFont(new Font("Georgia", Font.PLAIN, 24));
		loginButton.setBounds(166, 319, 167, 49);
		loginFrame.getContentPane().add(loginButton);
		
		JLabel newsignupLabel = new JLabel("Are you new here? Join us now!");
		newsignupLabel.setForeground(Color.WHITE);
		newsignupLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		newsignupLabel.setBounds(254, 374, 344, 58);
		loginFrame.getContentPane().add(newsignupLabel);
		
		JButton newsignupButton = new JButton("SIGN UP");
		newsignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Creating new account");
				SignUpWindow signupFrame = new SignUpWindow();
    			signupFrame.setVisible(true); 
    			loginFrame.dispose();
			}
		});
		newsignupButton.setBackground(Color.WHITE);
		newsignupButton.setForeground(Color.BLACK);
		newsignupButton.setFont(new Font("Georgia", Font.PLAIN, 22));
		newsignupButton.setBounds(301, 442, 229, 49);
		loginFrame.getContentPane().add(newsignupButton);
		
		JButton bussiloginButton = new JButton("SWITCH TO BUSINESS ACCOUNT");
		bussiloginButton.setBounds(370, 320, 356, 49);
		bussiloginButton.setBackground(new Color(255, 153, 102));
		bussiloginButton.setFont(new Font("Georgia", Font.PLAIN, 20));
		bussiloginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				BusinessLoginWindow window5 = new BusinessLoginWindow();
				loginFrame.dispose();
			}
		});
		loginFrame.getContentPane().add(bussiloginButton);
		
		loginFrame.setVisible(true);
	}

}

