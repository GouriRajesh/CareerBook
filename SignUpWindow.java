import javax.swing.*;   //JFrame
import javax.swing.JOptionPane;
import java.awt.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SignUpWindow extends JFrame {

	 JPanel signupPanel;
	 JTextField nameText, emailText, phoneText, birthText, nuserText;
	 JPasswordField npasswordText, rpasswordText;
	 private JRadioButton maleButton;
	 private JRadioButton femaleButton;
	 private JRadioButton othersButton;
	 
/*	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpWindow signupFrame = new SignUpWindow();
					signupFrame.setVisible(true);
					
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	} */

		SignUpWindow() 
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 888, 607);
		setTitle("SIGNUP WINDOW");
		signupPanel = new JPanel();
		signupPanel.setBackground(new Color(135, 206, 235));
		getContentPane().add(signupPanel);
		signupPanel.setLayout(null);
		
		JLabel signupLabel = new JLabel("SIGN UP TO CAREERBOOK");
		signupLabel.setBackground(new Color(135, 206, 235));
		signupLabel.setForeground(new Color(255, 255, 255));
		signupLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		signupLabel.setBounds(147, 25, 533, 65);
		signupPanel.add(signupLabel);
		
		JLabel nameLabel = new JLabel("FULL NAME");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		nameLabel.setBounds(45, 100, 144, 37);
		signupPanel.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameText.setBounds(214, 104, 188, 35);
		signupPanel.add(nameText);
		nameText.setColumns(10);
		
		JLabel emailLabel = new JLabel("EMAIL");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		emailLabel.setBounds(45, 171, 142, 24);
		signupPanel.add(emailLabel);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailText.setBounds(214, 169, 188, 35);
		signupPanel.add(emailText);
		emailText.setColumns(10);
		
		JLabel phoneLabel = new JLabel("PHONE  NUMBER");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		phoneLabel.setBounds(423, 88, 188, 61);
		signupPanel.add(phoneLabel);
		
		phoneText = new JTextField();
		phoneText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneText.setBounds(624, 103, 188, 35);
		signupPanel.add(phoneText);
		phoneText.setColumns(10);
		
		JLabel birthLabel = new JLabel("DATE OF BIRTH");
		birthLabel.setForeground(Color.WHITE);
		birthLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		birthLabel.setBounds(423, 301, 178, 33);
		signupPanel.add(birthLabel);
		
		JLabel genderLabel = new JLabel("GENDER");
		genderLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		genderLabel.setForeground(Color.WHITE);
		genderLabel.setBounds(447, 198, 116, 31);
		signupPanel.add(genderLabel);
		
		maleButton = new JRadioButton("MALE");
		maleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(maleButton.isSelected()==true) {
					
					femaleButton.setSelected(false);
					othersButton.setSelected(false);
					
				}
			}
		});
		maleButton.setBackground(Color.WHITE);
		maleButton.setFont(new Font("Georgia", Font.PLAIN, 12));
		maleButton.setBounds(624, 170, 78, 32);
		signupPanel.add(maleButton);
		
		femaleButton = new JRadioButton("FEMALE");
		femaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(femaleButton.isSelected()==true) {
					
					maleButton.setSelected(false);
					othersButton.setSelected(false);
					
				}
			}
		});
		femaleButton.setBackground(Color.WHITE);
		femaleButton.setFont(new Font("Georgia", Font.PLAIN, 12));
		femaleButton.setBounds(727, 170, 85, 32);
		signupPanel.add(femaleButton);
		
		othersButton = new JRadioButton("OTHERS");
		othersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(othersButton.isSelected()==true) {
					
					femaleButton.setSelected(false);
					maleButton.setSelected(false);
					
				}
			}
		});
		othersButton.setBackground(Color.WHITE);
		othersButton.setFont(new Font("Georgia", Font.PLAIN, 12));
		othersButton.setBounds(678, 239, 78, 32);
		signupPanel.add(othersButton);
		
		JLabel imageLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/signupicon.png")).getImage();
		imageLabel.setIcon(new ImageIcon(img));
		imageLabel.setBounds(658, 10, 70, 78);
		signupPanel.add(imageLabel);
		
		JCheckBox agreeCheckbox = new JCheckBox("I AGREE TO THE TERMS AND CONDITIONS APPLIED");
		agreeCheckbox.setBackground(new Color(255, 255, 255));
		agreeCheckbox.setFont(new Font("Georgia", Font.PLAIN, 17));
		agreeCheckbox.setBounds(45, 448, 470, 43);
		signupPanel.add(agreeCheckbox);
		
		JLabel countryLabel = new JLabel("COUNTRY");
		countryLabel.setForeground(Color.WHITE);
		countryLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		countryLabel.setBounds(447, 367, 144, 37);
		signupPanel.add(countryLabel);
		
		birthText = new JTextField();
		birthText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthText.setBounds(624, 303, 188, 35);
		signupPanel.add(birthText);
		birthText.setColumns(10);
		
		JLabel nuserLabel = new JLabel("NEW USERNAME");
		nuserLabel.setForeground(Color.WHITE);
		nuserLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		nuserLabel.setBounds(10, 237, 166, 31);
		signupPanel.add(nuserLabel);
		
		nuserText = new JTextField();
		nuserText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nuserText.setBounds(214, 238, 188, 35);
		signupPanel.add(nuserText);
		nuserText.setColumns(10);
		
		JLabel npasswordLbel = new JLabel("NEW PASSWORD");
		npasswordLbel.setForeground(Color.WHITE);
		npasswordLbel.setFont(new Font("Georgia", Font.PLAIN, 20));
		npasswordLbel.setBounds(10, 302, 178, 31);
		signupPanel.add(npasswordLbel);
		
		npasswordText = new JPasswordField();
		npasswordText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		npasswordText.setBounds(214, 303, 188, 35);
		signupPanel.add(npasswordText);
		
		JLabel rpasswordLabel = new JLabel("RETYPE PASSWORD");
		rpasswordLabel.setForeground(Color.WHITE);
		rpasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		rpasswordLabel.setBounds(10, 370, 199, 31);
		signupPanel.add(rpasswordLabel);
		
		rpasswordText = new JPasswordField();
		rpasswordText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rpasswordText.setBounds(214, 371, 188, 35);
		signupPanel.add(rpasswordText);
		
		JComboBox countrycomboBox = new JComboBox();
		countrycomboBox.setBackground(new Color(255, 255, 255));
		countrycomboBox.addItem("INDIA");
		countrycomboBox.addItem("USA");
		countrycomboBox.addItem("GERMANY");
		countrycomboBox.addItem("CHINA");
		countrycomboBox.addItem("AUSTRALIA");
		countrycomboBox.addItem("UK");
		countrycomboBox.addItem("RUSSIA");
		countrycomboBox.addItem("JAPAN");
		countrycomboBox.addItem("FRANCE");
		countrycomboBox.addItem("UAE");
		countrycomboBox.setBounds(624, 369, 188, 38);
		signupPanel.add(countrycomboBox);
		
		JButton continueButton = new JButton("SIGN UP NOW!");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	int flag=0;
				if(!verifyName(nameText.getText()))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid name.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(emailValid(emailText.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid email address.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(npasswordText.getText().compareTo(rpasswordText.getText())!=0)
				{
					JOptionPane.showMessageDialog(null,"New password and Retyped password do not match.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(!(isValid(phoneText.getText())))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid phone number.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(validDate(birthText.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid birth date in dd/mm/yyy format.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(agreeCheckbox.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null,"Please agree to the terms and conditions and select the checkbox.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(flag==0) {
				File newuserfile = new File(nuserText.getText()+".txt");
				if (newuserfile.exists()==true) {
					try {
						Scanner	myReader = new Scanner(newuserfile);
						String password = myReader.nextLine();
						myReader.close();
						
						if(npasswordText.getText().compareTo(password)==0) {
							System.out.println("File/Account already exists.");
							System.out.println("File name: " + newuserfile.getName()); 
							System.out.println("You have now logged in.");
							MainWindow mainFrame = new MainWindow(nuserText.getText());
							mainFrame.setVisible(true);
							dispose();
							}
						else if(npasswordText.getText().compareTo(password)!=0) {
							System.out.println("Username already exists. Please choose a different username.");
							JOptionPane.showMessageDialog(null,"Username already exists. Please choose a different username.","ERROR",JOptionPane.ERROR_MESSAGE);
							}
					
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}					

				else {
						try 
						{	
							if (nuserText.getText().isBlank()) {
								System.out.println("Please enter a valid username.");
								}
						else if (newuserfile.createNewFile()) {
								System.out.println("You have signed up and logged in!");
								System.out.println("File created: " + newuserfile.getName());
								FileWriter myWriter = new FileWriter(nuserText.getText()+".txt");
								myWriter.write(npasswordText.getText()+"\r\n");
								myWriter.write(/*"FULL NAME: "+*/nameText.getText().toUpperCase()+"\r\n");
								myWriter.write(/*"EMAIL ID: "+*/emailText.getText().toLowerCase()+"\r\n");
								myWriter.write(/*"USERNAME: "+*/nuserText.getText()+"\r\n");
								myWriter.write(/*"PASSWORD: "+*/npasswordText.getText()+"\r\n");
								myWriter.write(/*"PHONE NUMBER: "+*/phoneText.getText()+"\r\n");
								myWriter.write(/*"DATE OF BIRTH: "+*/birthText.getText()+"\r\n");
								myWriter.write(/*"COUNTRY: "+*/(countrycomboBox.getSelectedItem().toString().toUpperCase())+"\r\n");
								myWriter.close(); 
								newuserfile.setReadOnly();
								MainWindow mainFrame = new MainWindow(nuserText.getText());
								mainFrame.setVisible(true);
								dispose();
								} 
					} catch (IOException e1) {
					e1.printStackTrace();
					}
				}
				}//if
				
			}});
		
		continueButton.setBackground(new Color(144, 238, 144));
		continueButton.setFont(new Font("Georgia", Font.PLAIN, 17));
		continueButton.setBounds(624, 437, 188, 65);
		signupPanel.add(continueButton);
		
	}
		boolean isValid(String s)  //checks if phone number is valid
	    { 
			Pattern num = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
			Matcher m = num.matcher(s); 
	        return (m.find() && m.group().equals(s)); 
	    } 
		
		boolean verifyName(String s) //checks if the name is valid
		{
			if(s.matches("[a-zA-Z ]+"))
				return true;
			else
				return false;
		}
		boolean validDate(String s) //checks if the date is valid
		{
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/uuuu");
			try {
				format.parse(s);
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		boolean emailValid(String s) //checks if the email is valid
	    { 
	        String emailexpr = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
	        Pattern pat = Pattern.compile(emailexpr); 
	        if (s == null) 
	        return false; 
	        return pat.matcher(s).matches(); 
	    } 
}
