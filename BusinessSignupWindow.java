import java.awt.*;  //JFrame
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BusinessSignupWindow extends JFrame {

	private JPanel businesssignupPanel;
	private JTextField companynamesignup,companyid,companyemail,companycontactnumber;
	private JPasswordField companypassword,companyretypepassword;


/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessSignupWindow businesssignupFrame = new BusinessSignupWindow();
					businesssignupFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	public BusinessSignupWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1047, 665);
		setTitle("BUSINESS SIGNUP WINDOW");
		businesssignupPanel = new JPanel();
		businesssignupPanel.setBackground(new Color(135, 206, 235));
		businesssignupPanel.setLayout(null);
		getContentPane().add(businesssignupPanel);
		
		JLabel bussisignupLabel = new JLabel("SIGN UP TO CAREERBOOK");
		bussisignupLabel.setBackground(new Color(135, 206, 235));
		bussisignupLabel.setForeground(new Color(255, 255, 255));
		bussisignupLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		bussisignupLabel.setBounds(203, 10, 533, 65);
		businesssignupPanel.add(bussisignupLabel);
		
		JLabel companynameLabel = new JLabel("COMPANY NAME");
		companynameLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companynameLabel.setBounds(36, 121, 207, 33);
		businesssignupPanel.add(companynameLabel);
		
		JLabel companyidLabel = new JLabel("COMPANY ID");
		companyidLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companyidLabel.setBounds(36, 327, 145, 33);
		businesssignupPanel.add(companyidLabel);
		
		JLabel officialemailLabel = new JLabel("OFFICIAL EMAIL ID");
		officialemailLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		officialemailLabel.setBounds(36, 398, 207, 33);
		businesssignupPanel.add(officialemailLabel);
		
		JLabel companycontactnumberLabel = new JLabel("CONTACT NUMBER");
		companycontactnumberLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companycontactnumberLabel.setBounds(36, 466, 199, 33);
		businesssignupPanel.add(companycontactnumberLabel);
		
		JLabel companyaddressLabel = new JLabel("OFFICIAL POSTAL ADDRESS");
		companyaddressLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companyaddressLabel.setBounds(655, 108, 256, 33);
		businesssignupPanel.add(companyaddressLabel);
		
		JLabel companyocationLabel = new JLabel("COMPANY LOCATION");
		companyocationLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companyocationLabel.setBounds(508, 288, 192, 33);
		businesssignupPanel.add(companyocationLabel);
		
		JLabel companytypeLabel = new JLabel("COMPANY TYPE");
		companytypeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companytypeLabel.setBounds(508, 356, 152, 38);
		businesssignupPanel.add(companytypeLabel);
		
		JLabel companystatusLabel = new JLabel("COMPANY STATUS");
		companystatusLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companystatusLabel.setBounds(508, 435, 192, 33);
		businesssignupPanel.add(companystatusLabel);
		
		companynamesignup = new JTextField();
		companynamesignup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companynamesignup.setBounds(253, 121, 171, 36);
		businesssignupPanel.add(companynamesignup);
		companynamesignup.setColumns(10);
		
		companyid = new JTextField();
		companyid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyid.setColumns(10);
		companyid.setBounds(253, 324, 171, 36);
		businesssignupPanel.add(companyid);
		
		companyemail = new JTextField();
		companyemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyemail.setColumns(10);
		companyemail.setBounds(253, 395, 171, 36);
		businesssignupPanel.add(companyemail);
		
		companycontactnumber = new JTextField();
		companycontactnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companycontactnumber.setColumns(10);
		companycontactnumber.setBounds(253, 463, 171, 36);
		businesssignupPanel.add(companycontactnumber);
		
		JTextArea companyofficialpostaladdress = new JTextArea();
		companyofficialpostaladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyofficialpostaladdress.setBounds(625, 151, 316, 99);
		businesssignupPanel.add(companyofficialpostaladdress);
		
		JComboBox companytypecombobox = new JComboBox();
		companytypecombobox.setBackground(new Color(255, 255, 255));
		companytypecombobox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		companytypecombobox.setBounds(749, 359, 192, 35);
		companytypecombobox.addItem("IT");
		companytypecombobox.addItem("MANUFACTURING");
		companytypecombobox.addItem("REAL ESTATE");
		companytypecombobox.addItem("HEALTH CARE");
		companytypecombobox.addItem("NGO");
		companytypecombobox.addItem("TRAVEL/TOURISM");
		companytypecombobox.addItem("EDUCATION");
		companytypecombobox.addItem("DAIRY");
		companytypecombobox.addItem("BANKING");
		companytypecombobox.addItem("TEXTILE");
		businesssignupPanel.add(companytypecombobox);
		
		JComboBox companylocationcomboBox = new JComboBox();
		companylocationcomboBox.setBackground(new Color(255, 255, 255));
		companylocationcomboBox.addItem("INDIA");
		companylocationcomboBox.addItem("USA");
		companylocationcomboBox.addItem("GERMANY");
		companylocationcomboBox.addItem("CHINA");
		companylocationcomboBox.addItem("AUSTRALIA");
		companylocationcomboBox.addItem("UK");
		companylocationcomboBox.addItem("RUSSIA");
		companylocationcomboBox.addItem("JAPAN");
		companylocationcomboBox.addItem("FRANCE");
		companylocationcomboBox.addItem("UAE");
		companylocationcomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		companylocationcomboBox.setBounds(749, 288, 192, 38);
		businesssignupPanel.add(companylocationcomboBox);
		
		JComboBox companystatuscomboBox = new JComboBox();
		companystatuscomboBox.addItem("MNC");
		companystatuscomboBox.addItem("STARTUP");
		companystatuscomboBox.addItem("GOVERNMENT");
		companystatuscomboBox.addItem("FREELANCING");
		companystatuscomboBox.setBackground(new Color(255, 255, 255));
		companystatuscomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		companystatuscomboBox.setBounds(749, 435, 192, 38);
		businesssignupPanel.add(companystatuscomboBox);
		
		JLabel companynewpasswordLabel = new JLabel("NEW PASSWORD");
		companynewpasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companynewpasswordLabel.setBounds(36, 193, 152, 27);
		businesssignupPanel.add(companynewpasswordLabel);
		
		companypassword = new JPasswordField();
		companypassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companypassword.setBounds(253, 182, 171, 38);
		businesssignupPanel.add(companypassword);
		
		JLabel companyretypepasswordLabel = new JLabel("RETYPE PASSWORD");
		companyretypepasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companyretypepasswordLabel.setBounds(36, 253, 185, 38);
		businesssignupPanel.add(companyretypepasswordLabel);
		
		companyretypepassword = new JPasswordField();
		companyretypepassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		companyretypepassword.setBounds(253, 253, 171, 38);
		businesssignupPanel.add(companyretypepassword);
		
		JCheckBox companytermsCheckbox = new JCheckBox("I AGREE TO THE TERMS AND CONDITIONS APPLIED");
		companytermsCheckbox.setBackground(Color.WHITE);
		companytermsCheckbox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		companytermsCheckbox.setBounds(55, 540, 426, 38);
		businesssignupPanel.add(companytermsCheckbox);
		
		JLabel comiconLabel = new JLabel("");
		Image ima = new ImageIcon(this.getClass().getResource("/signupicon.png")).getImage();
		comiconLabel.setBounds(731, 10, 77, 65);
		comiconLabel.setIcon(new ImageIcon(ima));
		businesssignupPanel.add(comiconLabel);
		
		JButton companysignupButton = new JButton("SIGN UP NOW!");
		companysignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag=0;
				if(!verifyName(companynamesignup.getText()))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid company name.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(emailValid(companyemail.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid company email address.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(companypassword.getText().compareTo(companyretypepassword.getText())!=0)
				{
					JOptionPane.showMessageDialog(null,"New password and Retyped password do not match.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(!(isValid(companycontactnumber.getText())))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid company contact number.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(companytermsCheckbox.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null,"Please agree to the terms and conditions and select the checkbox.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(flag==0) {
				File newbusinessfile = new File(companynamesignup.getText().toUpperCase()+".txt");
				if (newbusinessfile.exists()==true) {
					try {
						Scanner	myReader = new Scanner(newbusinessfile);
						String buspassword = myReader.nextLine();
						myReader.close();
						
						if(companypassword.getText().compareTo(buspassword)==0) {
							System.out.println("Business File/Account already exists.");
							System.out.println("File name: " + newbusinessfile.getName()); 
							System.out.println("You have now logged in.");
							BusinessMainWindow businessmainFrame = new BusinessMainWindow(companynamesignup.getText().toUpperCase());
							dispose();
							}
						else if(companypassword.getText().compareTo(buspassword)!=0) {
							System.out.println("Company name already exists. Please choose a different name.");
							JOptionPane.showMessageDialog(null,"Company name already exists. Please choose a different name.","ERROR",JOptionPane.ERROR_MESSAGE);
							}
					
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					
				}		
				else {
					try 
					{		if (newbusinessfile.createNewFile()) {
							System.out.println("You have signed up and logged in!");
							System.out.println("File created: " + newbusinessfile.getName());
							FileWriter myWriter = new FileWriter(companynamesignup.getText()+".txt");
							myWriter.write(companypassword.getText()+"\r\n");
							myWriter.write(/*"COMPANY NAME: "+*/companynamesignup.getText().toUpperCase()+"\r\n");
							myWriter.write(/*"PASSWORD: "+*/companypassword.getText()+"\r\n");
							myWriter.write(/*"COMPANY ID: "+*/companyid.getText().toUpperCase()+"\r\n");
							myWriter.write(/*"COMPANY EMAIL ID: "+*/companyemail.getText()+"\r\n");
							myWriter.write(/*"COMPANY CONTACT NUMBER: "+*/companycontactnumber.getText().toUpperCase()+"\r\n");
							myWriter.write(/*"OFFICIAL POSTAL ADDRESS: "+*/companyofficialpostaladdress.getText().toUpperCase()+"\r\n");
							myWriter.write(/*"COMPANY LOCATION: "+*/(companylocationcomboBox.getSelectedItem().toString().toUpperCase())+"\r\n");
							myWriter.write(/*"COMPANY TYPE: "+*/(companytypecombobox.getSelectedItem().toString().toUpperCase())+"\r\n");
							myWriter.write(/*"COMPANY STATUS: "+*/(companystatuscomboBox.getSelectedItem().toString().toUpperCase())+"\r\n");
							myWriter.close(); 
							newbusinessfile.setReadOnly();
							
							File bmails = new File("BusinessEmails.txt");
							bmails.setWritable(true);
							FileWriter mywrite = new FileWriter(bmails,true);
							if(bmails.exists()==true) 
								{
								//bmails.setWritable(true);
								mywrite.write(companyemail.getText()+"\r\n");
								mywrite.close();
								bmails.setReadOnly();	
								}
							
							else if(bmails.createNewFile()==true) 
							 {
									//bmails.setWritable(true);
									mywrite.write(companyemail.getText()+"\r\n");
									mywrite.close();
									bmails.setReadOnly();	
							} 
							BusinessMainWindow businessmainFrame = new BusinessMainWindow(companynamesignup.getText().toUpperCase());
							dispose();
							} 
				} catch (IOException e1) {
				e1.printStackTrace();
				}
				}
				}//if
				
				}});
		companysignupButton.setFont(new Font("Georgia", Font.PLAIN, 20));
		companysignupButton.setBounds(610, 516, 231, 62);
		companysignupButton.setBackground(new Color(144, 238, 144));
		businesssignupPanel.add(companysignupButton);
		
	}
	boolean isValid(String s) 
    { 
		Pattern num = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		Matcher m = num.matcher(s); 
        return (m.find() && m.group().equals(s)); 
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
