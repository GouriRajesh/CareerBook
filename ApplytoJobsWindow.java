import java.awt.Color; //Application Window
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ApplytoJobsWindow  {

	private JFrame ApplyjobsFrame;
	private JTextField name;
	private JTextField email;
	private JTextField companyname;
	private JTextField jobid;
	private JComboBox companyemail;
	String use;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplytoJobsWindow window = new ApplytoJobsWindow();
					window.ApplyjobsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	public ApplytoJobsWindow() {
		initialize();
	}
	public ApplytoJobsWindow(String user) {
		use=user;
		initialize();
	}

	private void initialize() {
		ApplyjobsFrame = new JFrame();
		ApplyjobsFrame.setBounds(300, 100, 957, 570);
		ApplyjobsFrame.setTitle("APPLY TO JOBS WINDOW");
		ApplyjobsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ApplyjobsFrame.getContentPane().setBackground(new Color(135, 206, 235));
		ApplyjobsFrame.getContentPane().setLayout(null);
		
		JLabel headLabel = new JLabel("APPLY TO JOBS");
		headLabel.setForeground(new Color(255, 255, 255));
		headLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		headLabel.setBounds(249, 10, 327, 96);
		ApplyjobsFrame.getContentPane().add(headLabel);
		
		JLabel enternameLabel = new JLabel("FULL NAME");
		enternameLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		enternameLabel.setBounds(58, 147, 211, 42);
		ApplyjobsFrame.getContentPane().add(enternameLabel);
		
		JLabel companynameLabel = new JLabel("COMPANY NAME");
		companynameLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		companynameLabel.setBounds(42, 242, 164, 28);
		ApplyjobsFrame.getContentPane().add(companynameLabel);
		
		JLabel companyjobidLabel = new JLabel("COMPANY JOB ID");
		companyjobidLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		companyjobidLabel.setBounds(495, 235, 177, 42);
		ApplyjobsFrame.getContentPane().add(companyjobidLabel);
		
		JLabel enteremailLabel = new JLabel("EMAIL ID");
		enteremailLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		enteremailLabel.setBounds(546, 154, 177, 28);
		ApplyjobsFrame.getContentPane().add(enteremailLabel);
		
		JLabel companyemailLabel = new JLabel("COMPANY EMAIL ID");
		companyemailLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		companyemailLabel.setBounds(235, 331, 203, 42);
		ApplyjobsFrame.getContentPane().add(companyemailLabel);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setBounds(222, 147, 216, 38);
		ApplyjobsFrame.getContentPane().add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email.setColumns(10);
		email.setBounds(682, 147, 216, 38);
		ApplyjobsFrame.getContentPane().add(email);
		
		companyname = new JTextField();
		companyname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyname.setColumns(10);
		companyname.setBounds(222, 239, 216, 38);
		ApplyjobsFrame.getContentPane().add(companyname);
		
		jobid = new JTextField();
		jobid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobid.setColumns(10);
		jobid.setBounds(682, 235, 216, 38);
		ApplyjobsFrame.getContentPane().add(jobid);
		
		companyemail = new JComboBox();
		companyemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyemail.setBackground(new Color(255, 255, 255));
		companyemail.setBounds(465, 331, 216, 38);
		ApplyjobsFrame.getContentPane().add(companyemail);
		
		try {
			Scanner sc = new Scanner(new File("BusinessEmails.txt"));
			while(sc.hasNext()==true)
			{
				companyemail.addItem(sc.nextLine());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ApplyjobsFrame.getContentPane().add(companyemail);
		
		
		try {
			File newone = new File(use+".txt");
			String full = Files.readAllLines(Paths.get(use+".txt")).get(1);
			name.setText(full);
			name.setEditable(false);
			String ema = Files.readAllLines(Paths.get(use+".txt")).get(2);
			email.setText(ema);
			email.setEditable(false);
			
			}catch(Exception e) {
			e.printStackTrace();
			}
		
		JButton applynowButton = new JButton("APPLY NOW!");
		applynowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(verifyName(name.getText())==false || verifyName(companyname.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid name or company name.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(emailValid(email.getText())==false || emailValid(companyemail.getSelectedItem().toString())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid email address or company email address.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				File che= new File((companyname.getText()+jobid.getText()).toUpperCase()+".txt");
				if(che.exists()==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid Company name or Job ID.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(flag==0) {

				File obj = new File("temp.txt");
				try {
				
					if(obj.exists()==true) {
						obj.setWritable(true);
						FileWriter myWriter = new FileWriter(obj,true); //appends the data
						myWriter.write(name.getText().toUpperCase()+"COMPARE.txt\r\n");
						myWriter.write(email.getText()+"\r\n");
						myWriter.write(companyname.getText().toUpperCase()+jobid.getText().toUpperCase()+".txt\r\n");
						myWriter.write(companyemail.getSelectedItem().toString()+"\r\n");
						myWriter.write("\r\n");
						myWriter.close();
						obj.setReadOnly();
						}
					
					else if(obj.createNewFile()==true){
						obj.setWritable(true);
					FileWriter myWriter = new FileWriter(obj,true);
					myWriter.write(name.getText().toUpperCase()+"COMPARE.txt\r\n");
					myWriter.write(email.getText()+"\r\n");
					myWriter.write(companyname.getText().toUpperCase()+jobid.getText().toUpperCase()+".txt\r\n");
					myWriter.write(companyemail.getSelectedItem().toString()+"\r\n");
					myWriter.write("\r\n");
					myWriter.close();
					obj.setReadOnly();
					}
					
					} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Could not create file.","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("You have successfully applied to the job.");
				MainWindow mainFrame = new MainWindow(use);
				mainFrame.setVisible(true);
				ApplyjobsFrame.dispose();
		
			} 
		}
		});
		applynowButton.setBackground(new Color(154, 205, 50));
		applynowButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		applynowButton.setBounds(359, 416, 193, 59);
		ApplyjobsFrame.getContentPane().add(applynowButton);
		
		JLabel icon = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/jobseeker.png")).getImage();
		icon.setIcon(new ImageIcon(im));
		icon.setBounds(586, 24, 100, 82);
		ApplyjobsFrame.getContentPane().add(icon);
		
		
		ApplyjobsFrame.setVisible(true);
	}
	boolean verifyName(String s)
	{
		if(s.matches("[a-zA-Z ]+"))
			return true;
		else
			return false;
	}
	boolean emailValid(String s) 
    { 
        String emailexpr = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
        Pattern pat = Pattern.compile(emailexpr); 
        if (s == null) 
        return false; 
        return pat.matcher(s).matches(); 
    } 

}
