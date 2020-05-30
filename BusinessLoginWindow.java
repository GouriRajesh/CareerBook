import java.awt.Color;  //Application Window
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BusinessLoginWindow {

	private JFrame businesslogFrame;
	private JTextField companyname;
	private JPasswordField companypassword;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessLoginWindow window5 = new BusinessLoginWindow();
					window5.businesslogFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */


	BusinessLoginWindow() {
		initialize();
	}

	private void initialize() {
		businesslogFrame = new JFrame("BUSINESS LOGIN WINDOW");
		businesslogFrame.setBounds(380, 100, 751, 553);
		businesslogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		businesslogFrame.getContentPane().setBackground(new Color(135, 206, 235));
		businesslogFrame.getContentPane().setLayout(null);
		
		JLabel busheadLabel = new JLabel("BUSINESS LOGIN PAGE");
		busheadLabel.setForeground(new Color(255, 255, 255));
		busheadLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		busheadLabel.setBounds(133, 27, 459, 49);
		businesslogFrame.getContentPane().add(busheadLabel);
		
		JLabel companynameLabel = new JLabel("COMPANY NAME");
		companynameLabel.setForeground(new Color(255, 255, 255));
		companynameLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
		companynameLabel.setBounds(119, 115, 234, 58);
		businesslogFrame.getContentPane().add(companynameLabel);
		
		companyname = new JTextField();
		companyname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyname.setBounds(390, 127, 217, 42);
		businesslogFrame.getContentPane().add(companyname);
		
		JLabel companypasswordLabel = new JLabel("PASSWORD");
		companypasswordLabel.setForeground(new Color(255, 255, 255));
		companypasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 25));
		companypasswordLabel.setBounds(146, 194, 167, 58);
		businesslogFrame.getContentPane().add(companypasswordLabel);
		
		companypassword = new JPasswordField();
		companypassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companypassword.setBounds(390, 206, 217, 42);
		businesslogFrame.getContentPane().add(companypassword);
		
		JButton companyloginButton = new JButton("LOGIN");
		companyloginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				File businessfile = new File(companyname.getText()+".txt"); 
				
				try {
					Scanner myReader = new Scanner(businessfile);
					String passworddata = myReader.nextLine();
					myReader.close();
					
					if (businessfile.exists()==true && (companypassword.getText().compareTo(passworddata))==0) {
						System.out.println("You have logged in as a business page.");
						BusinessMainWindow businessmainFrame = new BusinessMainWindow(companyname.getText().toUpperCase());
						businesslogFrame.dispose();
						
				    }
					
					else if (businessfile.exists()==true || (companypassword.getText().compareTo(passworddata))!=0){
						System.out.println("Business Account/File present but wrong password");
						invalidDiag frame = new invalidDiag();
						frame.setVisible(true);
					}
					
					} catch (FileNotFoundException e1) {
					
					System.out.println("Business Account/File absent");
					invalidDiag frame = new invalidDiag();
					frame.setVisible(true);
				} 
			
			
			}});
		companyloginButton.setFont(new Font("Georgia", Font.PLAIN, 25));
		companyloginButton.setBounds(272, 289, 167, 49);
		companyloginButton.setBackground(new Color(255, 153, 102));
		businesslogFrame.getContentPane().add(companyloginButton);
		
		JLabel companysignupLabel = new JLabel("ARE YOU NEW HERE? CREATE NEW BUSINESS ACCOUNT");
		companysignupLabel.setForeground(Color.WHITE);
		companysignupLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		companysignupLabel.setBounds(71, 348, 577, 58);
		businesslogFrame.getContentPane().add(companysignupLabel);
		
		JButton companysignupButton = new JButton("CREATE NOW!");
		companysignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Creating new business account");
				BusinessSignupWindow businesssignupFrame = new BusinessSignupWindow();
				businesssignupFrame.setVisible(true); 
				businesslogFrame.dispose();
			}
		});
		companysignupButton.setBackground(new Color(255, 255, 255));
		companysignupButton.setForeground(Color.BLACK);
		companysignupButton.setFont(new Font("Georgia", Font.PLAIN, 22));
		companysignupButton.setBounds(241, 416, 229, 49);
		businesslogFrame.getContentPane().add(companysignupButton);
		
		businesslogFrame.setVisible(true);
		
	}
}
		
		
		
