import javax.swing.*;  //JFrame
import javax.swing.border.EmptyBorder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ResumeWindow extends JFrame {

	private JPanel resumePanel;
	private JTextField insname10,percent10,insname12,percent12,insnameug,cgpaug,insnamepg,cgpapg,rfullname,rage,rbirthday,rnationality,rphno,remail;
	private JTextField skill5,skill1,skill2,skill3,skill4,lang1,lang2,lang3,lang4,lang5,course1,course2,course3,course4,course5,rcompname,rcompduration,rcomppost;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton others;
	private JCheckBox yescb;
	private JCheckBox nocb;
	

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumeWindow ResumeFrame = new ResumeWindow();
					ResumeFrame.setVisible(true);
				
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */
	public ResumeWindow() 
	{
		//no code
	}
		public ResumeWindow(String username2) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 100, 1042, 652);
		setTitle("RESUME WINDOW");
		resumePanel = new JPanel();
		resumePanel.setBackground(new Color(135, 206, 235));
		resumePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(resumePanel);
		resumePanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 110, 996, 454);
		resumePanel.add(tabbedPane);
		
		JPanel personalinfo = new JPanel();
		personalinfo.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("PERSONAL INFO", null, personalinfo, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		personalinfo.setLayout(null);
		
		JLabel rfullnameLabel = new JLabel("Full name");
		rfullnameLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rfullnameLabel.setBounds(59, 35, 95, 29);
		personalinfo.add(rfullnameLabel);
		
		JLabel rageLabel = new JLabel("Age");
		rageLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rageLabel.setBounds(59, 121, 77, 29);
		personalinfo.add(rageLabel);
		
		JLabel rbirthdayLabel = new JLabel("Birthday");
		rbirthdayLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rbirthdayLabel.setBounds(59, 217, 83, 29);
		personalinfo.add(rbirthdayLabel);
		
		JLabel rgenderLabel = new JLabel("Gender");
		rgenderLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rgenderLabel.setBounds(551, 35, 77, 29);
		personalinfo.add(rgenderLabel);
		
		JLabel rnationLabel = new JLabel("Nationality");
		rnationLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rnationLabel.setBounds(59, 308, 95, 29);
		personalinfo.add(rnationLabel);
		
		JLabel rphnoLabel = new JLabel("Phone Number");
		rphnoLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		rphnoLabel.setBounds(532, 145, 136, 29);
		personalinfo.add(rphnoLabel);
		
		JLabel remailLabel = new JLabel("Email ID");
		remailLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		remailLabel.setBounds(551, 217, 77, 29);
		personalinfo.add(remailLabel);
		
		JLabel raddrLabel = new JLabel("Address");
		raddrLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		raddrLabel.setBounds(551, 308, 83, 29);
		personalinfo.add(raddrLabel);
		
		rfullname = new JTextField();
		rfullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rfullname.setBounds(184, 38, 171, 40);
		personalinfo.add(rfullname);
		rfullname.setColumns(10);
		
		rage = new JTextField();
		rage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rage.setColumns(10);
		rage.setBounds(184, 124, 171, 40);
		personalinfo.add(rage);
		
		rbirthday = new JTextField();
		rbirthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rbirthday.setColumns(10);
		rbirthday.setBounds(184, 217, 171, 40);
		personalinfo.add(rbirthday);
		
		rnationality = new JTextField();
		rnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rnationality.setColumns(10);
		rnationality.setBounds(184, 311, 171, 40);
		personalinfo.add(rnationality);
		
		rphno = new JTextField();
		rphno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rphno.setColumns(10);
		rphno.setBounds(723, 141, 171, 40);
		personalinfo.add(rphno);
		
		remail = new JTextField();
		remail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		remail.setColumns(10);
		remail.setBounds(723, 213, 171, 40);
		personalinfo.add(remail);
		
		JTextArea raddress = new JTextArea();
		raddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		raddress.setBackground(new Color(176, 224, 230));
		raddress.setBounds(723, 289, 171, 104);
		personalinfo.add(raddress);
		
		female = new JRadioButton("FEMALE");
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(female.isSelected()==true) {
					male.setSelected(false);
					others.setSelected(false);
				}
			}
		});
		female.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		female.setBounds(816, 20, 95, 44);
		personalinfo.add(female);
		
		others = new JRadioButton("OTHERS");
		others.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(others.isSelected()==true) {
					male.setSelected(false);
					female.setSelected(false);
				}
			}
		});
		others.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		others.setBounds(752, 76, 109, 44);
		personalinfo.add(others);
		
		male = new JRadioButton("MALE");
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(male.isSelected()==true) {
					female.setSelected(false);
					others.setSelected(false);
				}
			}
		});
		male.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		male.setBounds(707, 20, 95, 44);
		personalinfo.add(male);
		
		JPanel qualification = new JPanel();
		qualification.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("QUALIFICATION", null, qualification, null);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 0));
		qualification.setLayout(null);
		
		JLabel std10Label = new JLabel("10TH STANDARD");
		std10Label.setBounds(156, 33, 142, 28);
		std10Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		qualification.add(std10Label);
		
		JLabel std12Label = new JLabel("12TH STANDARD");
		std12Label.setBounds(693, 33, 142, 28);
		std12Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		qualification.add(std12Label);
		
		JLabel ugLabel = new JLabel("UNDER GRADUATE");
		ugLabel.setBounds(150, 227, 164, 28);
		ugLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		qualification.add(ugLabel);
		
		JLabel insnameLabel1 = new JLabel("Name of Institute");
		insnameLabel1.setBounds(46, 80, 143, 28);
		insnameLabel1.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(insnameLabel1);
		
		insname10 = new JTextField();
		insname10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insname10.setBounds(199, 83, 228, 28);
		qualification.add(insname10);
		insname10.setColumns(10);
		
		JLabel percentLabel1 = new JLabel("Percentage scored");
		percentLabel1.setBounds(46, 141, 142, 38);
		percentLabel1.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(percentLabel1);
		
		percent10 = new JTextField();
		percent10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		percent10.setBounds(199, 141, 228, 28);
		percent10.setColumns(10);
		qualification.add(percent10);
		
		JLabel insnameLabel2 = new JLabel("Name of Institute");
		insnameLabel2.setBounds(560, 80, 136, 28);
		insnameLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(insnameLabel2);
		
		JLabel percentLabel2 = new JLabel("Percentage scored");
		percentLabel2.setBounds(560, 146, 136, 28);
		percentLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(percentLabel2);
		
		insname12 = new JTextField();
		insname12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insname12.setBounds(715, 87, 228, 28);
		insname12.setColumns(10);
		qualification.add(insname12);
		
		percent12 = new JTextField();
		percent12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		percent12.setBounds(715, 149, 228, 28);
		percent12.setColumns(10);
		qualification.add(percent12);
		
		JLabel insnameLabel3 = new JLabel("Name of Institute");
		insnameLabel3.setBounds(46, 275, 127, 28);
		insnameLabel3.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(insnameLabel3);
		
		JLabel cgpaLabel1 = new JLabel("Average CGPA");
		cgpaLabel1.setBounds(46, 329, 118, 28);
		cgpaLabel1.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(cgpaLabel1);
		
		insnameug = new JTextField();
		insnameug.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insnameug.setBounds(199, 278, 228, 28);
		insnameug.setColumns(10);
		qualification.add(insnameug);
		
		cgpaug = new JTextField();
		cgpaug.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cgpaug.setBounds(199, 332, 228, 28);
		cgpaug.setColumns(10);
		qualification.add(cgpaug);
		
		JLabel pgLabel = new JLabel("POST GRADUATE");
		pgLabel.setBounds(693, 227, 149, 28);
		pgLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		qualification.add(pgLabel);
		
		JLabel insnameLabel4 = new JLabel("Name of Institute");
		insnameLabel4.setBounds(560, 278, 136, 28);
		insnameLabel4.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(insnameLabel4);
		
		JLabel cgpaLabel2 = new JLabel("Average CGPA");
		cgpaLabel2.setBounds(560, 332, 118, 28);
		cgpaLabel2.setFont(new Font("Georgia", Font.PLAIN, 16));
		qualification.add(cgpaLabel2);
		
		insnamepg = new JTextField();
		insnamepg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		insnamepg.setBounds(715, 278, 228, 28);
		insnamepg.setColumns(10);
		qualification.add(insnamepg);
		
		cgpapg = new JTextField();
		cgpapg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cgpapg.setBounds(715, 329, 228, 28);
		cgpapg.setColumns(10);
		qualification.add(cgpapg);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 0));
		
		JPanel skills = new JPanel();
		skills.setBackground(new Color(255, 255, 255));
		tabbedPane.setForegroundAt(1, new Color(0, 0, 0));
		tabbedPane.addTab("SKILLS", null, skills, null);
		skills.setLayout(null);
		
		JLabel skillsLabel = new JLabel("TOP 5 SKILLS");
		skillsLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		skillsLabel.setBounds(94, 24, 124, 31);
		skills.add(skillsLabel);
		
		JLabel Label1 = new JLabel("1.");
		Label1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label1.setBounds(22, 103, 45, 13);
		skills.add(Label1);
		
		JLabel Label2 = new JLabel("2.");
		Label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label2.setBounds(22, 166, 45, 13);
		skills.add(Label2);
		
		JLabel Label3 = new JLabel("3.");
		Label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label3.setBounds(22, 233, 45, 13);
		skills.add(Label3);
		
		JLabel Label4 = new JLabel("4.");
		Label4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label4.setBounds(22, 291, 45, 13);
		skills.add(Label4);
		
		JLabel Label5 = new JLabel("5.");
		Label5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label5.setBounds(22, 354, 45, 13);
		skills.add(Label5);
		
		skill5 = new JTextField();
		skill5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill5.setBounds(77, 348, 167, 31);
		skills.add(skill5);
		skill5.setColumns(10);
		
		JLabel languageLabel = new JLabel("LANGUAGES KNOWN");
		languageLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		languageLabel.setBounds(322, 30, 180, 19);
		skills.add(languageLabel);
		
		JLabel experienceLabel = new JLabel("PREVIOUS EXPERIENCE");
		experienceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		experienceLabel.setBounds(774, 24, 195, 31);
		skills.add(experienceLabel);
		
		JLabel courseLabel = new JLabel("COURSES");
		courseLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseLabel.setBounds(589, 28, 92, 23);
		skills.add(courseLabel);
		
		skill1 = new JTextField();
		skill1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill1.setColumns(10);
		skill1.setBounds(77, 97, 167, 31);
		skills.add(skill1);
		
		skill2 = new JTextField();
		skill2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill2.setColumns(10);
		skill2.setBounds(77, 160, 167, 31);
		skills.add(skill2);
		
		skill3 = new JTextField();
		skill3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill3.setColumns(10);
		skill3.setBounds(77, 227, 167, 31);
		skills.add(skill3);
		
		skill4 = new JTextField();
		skill4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill4.setColumns(10);
		skill4.setBounds(77, 285, 167, 31);
		skills.add(skill4);
		
		lang1 = new JTextField();
		lang1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lang1.setColumns(10);
		lang1.setBounds(322, 97, 167, 31);
		skills.add(lang1);
		
		lang2 = new JTextField();
		lang2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lang2.setColumns(10);
		lang2.setBounds(322, 160, 167, 31);
		skills.add(lang2);
		
		lang3 = new JTextField();
		lang3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lang3.setColumns(10);
		lang3.setBounds(322, 227, 167, 31);
		skills.add(lang3);
		
		lang4 = new JTextField();
		lang4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lang4.setColumns(10);
		lang4.setBounds(322, 285, 167, 31);
		skills.add(lang4);
		
		lang5 = new JTextField();
		lang5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lang5.setColumns(10);
		lang5.setBounds(322, 348, 167, 31);
		skills.add(lang5);
		
		course1 = new JTextField();
		course1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course1.setColumns(10);
		course1.setBounds(551, 97, 167, 31);
		skills.add(course1);
		
		course2 = new JTextField();
		course2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course2.setColumns(10);
		course2.setBounds(551, 160, 167, 31);
		skills.add(course2);
		
		course3 = new JTextField();
		course3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course3.setColumns(10);
		course3.setBounds(551, 227, 167, 31);
		skills.add(course3);
		
		course4 = new JTextField();
		course4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course4.setColumns(10);
		course4.setBounds(551, 285, 167, 31);
		skills.add(course4);
		
		course5 = new JTextField();
		course5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		course5.setColumns(10);
		course5.setBounds(551, 348, 167, 31);
		skills.add(course5);
		
		yescb = new JCheckBox("YES");
		yescb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(yescb.isSelected()==true)
					nocb.setSelected(false);
			}
		});
		yescb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		yescb.setBounds(788, 97, 64, 21);
		skills.add(yescb);
		
		nocb = new JCheckBox("NO");
		nocb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nocb.isSelected()==true)
					yescb.setSelected(false);
			}
		});
		nocb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nocb.setBounds(886, 97, 69, 23);
		skills.add(nocb);
		
		JLabel yesLabel = new JLabel("If YES, ");
		yesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yesLabel.setBounds(836, 136, 64, 31);
		skills.add(yesLabel);
		
		JLabel rcompLabel = new JLabel("Company name");
		rcompLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rcompLabel.setBounds(808, 166, 131, 23);
		skills.add(rcompLabel);
		
		rcompname = new JTextField();
		rcompname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rcompname.setColumns(10);
		rcompname.setBounds(788, 199, 167, 31);
		skills.add(rcompname);
		
		JLabel rcompdurLabel = new JLabel("Duration");
		rcompdurLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rcompdurLabel.setBounds(832, 240, 107, 18);
		skills.add(rcompdurLabel);
		
		rcompduration = new JTextField();
		rcompduration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rcompduration.setColumns(10);
		rcompduration.setBounds(783, 268, 167, 31);
		skills.add(rcompduration);
		
		JLabel rcomppostLabel = new JLabel("Post");
		rcomppostLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rcomppostLabel.setBounds(849, 309, 45, 13);
		skills.add(rcomppostLabel);
		
		rcomppost = new JTextField();
		rcomppost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rcomppost.setColumns(10);
		rcomppost.setBounds(783, 336, 167, 31);
		skills.add(rcomppost);
		
		try {
			File newone = new File(username2+".txt");
			String full = Files.readAllLines(Paths.get(username2+".txt")).get(1);
			rfullname.setText(full);
			rfullname.setEditable(false);
			String em = Files.readAllLines(Paths.get(username2+".txt")).get(2);
			remail.setText(em);
			remail.setEditable(false);
			String ph = Files.readAllLines(Paths.get(username2+".txt")).get(5);
			rphno.setText(ph);
			rphno.setEditable(false);
			String bday = Files.readAllLines(Paths.get(username2+".txt")).get(6);
			rbirthday.setText(bday);
			rbirthday.setEditable(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton createButton = new JButton("CREATE");
		createButton.setBackground(new Color(244, 164, 96));
		createButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		createButton.setBounds(814, 382, 111, 35);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int flag=0;
				if(!verifyName(rfullname.getText()))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid name.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(emailValid(remail.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid email address.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(!(isValid(rphno.getText())))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid phone number.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(validDate(rbirthday.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid birth date in dd/mm/yyy format.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(!verifyName(rnationality.getText()))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid nationality.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(validNum(rage.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid age.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(validNum(percent10.getText())==false || validNum(percent12.getText())==false || validNum(cgpaug.getText())==false ||validNum(cgpapg.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter valid percentage or cgpa.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(flag==0) {
				 String namef=rfullname.getText().toUpperCase()+"RESUME.txt";
				File newfile = new File(rfullname.getText().toUpperCase()+"RESUME.txt");
				try {
					if(newfile.exists()==true) {
						newfile.setWritable(true);
						FileWriter myWriter = new FileWriter(newfile);
						myWriter.write("*****************************"+rfullname.getText().toUpperCase()+" RESUME*******************************\r\n");
						myWriter.write("______________________________PERSONAL INFORMATION____________________________________\r\n");
						myWriter.write("  FULL NAME: "+rfullname.getText().toUpperCase()+"\r\n");
						myWriter.write("  AGE: "+rage.getText().toUpperCase()+"\r\n");
						myWriter.write("  BIRTHDAY: "+rbirthday.getText().toUpperCase()+"\r\n");
						myWriter.write("  NATIONALITY: "+rnationality.getText().toUpperCase()+"\r\n");
						if(male.isSelected()==true)
						myWriter.write("  GENDER: MALE\r\n");
						else if(female.isSelected()==true)
						myWriter.write("  GENDER: FEMALE\r\n");
						else if(others.isSelected()==true)
						myWriter.write("  GENDER: OTHERS\r\n");
						myWriter.write("  PHONE NUMBER: "+rphno.getText().toUpperCase()+"\r\n");
						myWriter.write("  EMAIL ID: "+remail.getText()+"\r\n");
						myWriter.write("  ADDRESS: "+raddress.getText().toUpperCase()+"\r\n");
						myWriter.write("_______________________________QUALIFICATIONS_____________________________________\r\n");
						myWriter.write("  10TH STANDARD\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insname10.getText().toUpperCase()+"\r\n");
						myWriter.write("  PERCENTAGE SCORED: "+percent10.getText().toUpperCase()+"\r\n");
						myWriter.write("  12TH STANDARD\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insname12.getText().toUpperCase()+"\r\n");
						myWriter.write("  PERCENTAGE SCORED: "+percent12.getText().toUpperCase()+"\r\n");
						myWriter.write("  UNDER GRADUATE\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insnameug.getText().toUpperCase()+"\r\n");
						myWriter.write("  AVERAGE CGPA: "+cgpaug.getText().toUpperCase()+"\r\n");
						myWriter.write("  POST GRADUATE\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insnamepg.getText().toUpperCase()+"\r\n");
						myWriter.write("  AVERAGE CGPA: "+cgpapg.getText().toUpperCase()+"\r\n");
						myWriter.write("___________________________________SKILLS____________________________________\r\n");
						myWriter.write("  TOP FIVE SKILLS\r\n");
						myWriter.write("  1."+skill1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+skill2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+skill3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+skill4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+skill5.getText().toUpperCase()+"\r\n");
						myWriter.write("  TOP FIVE LANGUAGES KNOWN\r\n");
						myWriter.write("  1."+lang1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+lang2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+lang3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+lang4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+lang5.getText().toUpperCase()+"\r\n");
						myWriter.write("  TOP FIVE COURSES\r\n");
						myWriter.write("  1."+course1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+course2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+course3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+course4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+course5.getText().toUpperCase()+"\r\n");
						if(nocb.isSelected()==true)
							myWriter.write("  PREVIOUS EXPERIENCE: NO\r\n");
						else if(yescb.isSelected()==true) {
							myWriter.write("  PREVIOUS EXPERIENCE: YES\r\n");
							myWriter.write("  EXPERIENCE\r\n");
							myWriter.write("  COMPANY NAME: "+rcompname.getText().toUpperCase()+"\r\n");
							myWriter.write("  COMPANY EXPERIENCE DURATION: "+rcompduration.getText().toUpperCase()+"\r\n");
							myWriter.write("  COMPANY EXPERIENCE POST: "+rcomppost.getText().toUpperCase()+"\r\n");
						}
						myWriter.close(); 
						newfile.setReadOnly();
						ViewResumeWindow viewreswindow = new ViewResumeWindow(namef,username2);
					} 
					else if(newfile.createNewFile()==true) {
						newfile.setWritable(true);
						FileWriter myWriter = new FileWriter(newfile);
						myWriter.write("*****************************"+rfullname.getText().toUpperCase()+" RESUME*******************************\r\n");
						myWriter.write("______________________________PERSONAL INFORMATION____________________________________\r\n");
						myWriter.write("  FULL NAME: "+rfullname.getText().toUpperCase()+"\r\n");
						myWriter.write("  AGE: "+rage.getText().toUpperCase()+"\r\n");
						myWriter.write("  BIRTHDAY: "+rbirthday.getText().toUpperCase()+"\r\n");
						myWriter.write("  NATIONALITY: "+rnationality.getText().toUpperCase()+"\r\n");
						if(male.isSelected()==true)
						myWriter.write("  GENDER: MALE\r\n");
						else if(female.isSelected()==true)
						myWriter.write("  GENDER: FEMALE\r\n");
						else if(others.isSelected()==true)
						myWriter.write("  GENDER: OTHERS\r\n");
						myWriter.write("  PHONE NUMBER: "+rphno.getText().toUpperCase()+"\r\n");
						myWriter.write("  EMAIL ID: "+remail.getText()+"\r\n");
						myWriter.write("  ADDRESS: "+raddress.getText().toUpperCase()+"\r\n");
						myWriter.write("_______________________________QUALIFICATIONS_____________________________________\r\n");
						myWriter.write("  10TH STANDARD\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insname10.getText().toUpperCase()+"\r\n");
						myWriter.write("  PERCENTAGE SCORED: "+percent10.getText().toUpperCase()+"\r\n");
						myWriter.write("  12TH STANDARD\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insname12.getText().toUpperCase()+"\r\n");
						myWriter.write("  PERCENTAGE SCORED: "+percent12.getText().toUpperCase()+"\r\n");
						myWriter.write("  UNDER GRADUATE\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insnameug.getText().toUpperCase()+"\r\n");
						myWriter.write("  AVERAGE CGPA: "+cgpaug.getText().toUpperCase()+"\r\n");
						myWriter.write("  POST GRADUATE\r\n");
						myWriter.write("  NAME OF INSTITUTE: "+insnamepg.getText().toUpperCase()+"\r\n");
						myWriter.write("  AVERAGE CGPA: "+cgpapg.getText().toUpperCase()+"\r\n");
						myWriter.write("___________________________________SKILLS____________________________________\r\n");
						myWriter.write("  TOP FIVE SKILLS\r\n");
						myWriter.write("  1."+skill1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+skill2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+skill3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+skill4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+skill5.getText().toUpperCase()+"\r\n");
						myWriter.write("  TOP FIVE SKILLS\r\n");
						myWriter.write("  1."+skill1.getText().toUpperCase()+"\r\n");
						myWriter.write("  TOP FIVE LANGUAGES KNOWN\r\n");
						myWriter.write("  1."+lang1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+lang2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+lang3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+lang4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+lang5.getText().toUpperCase()+"\r\n");
						myWriter.write("  TOP FIVE COURSES\r\n");
						myWriter.write("  1."+course1.getText().toUpperCase()+"\r\n");
						myWriter.write("  2."+course2.getText().toUpperCase()+"\r\n");
						myWriter.write("  3."+course3.getText().toUpperCase()+"\r\n");
						myWriter.write("  4."+course4.getText().toUpperCase()+"\r\n");
						myWriter.write("  5."+course5.getText().toUpperCase()+"\r\n");
						if(nocb.isSelected()==true)
							myWriter.write("  PREVIOUS EXPERIENCE: NO\r\n");
						else if(yescb.isSelected()==true) {
							myWriter.write("  PREVIOUS EXPERIENCE: YES\r\n");
							myWriter.write("  EXPERIENCE\r\n");
							myWriter.write("  COMPANY NAME: "+rcompname.getText().toUpperCase()+"\r\n");
							myWriter.write("  COMPANY EXPERIENCE DURATION: "+rcompduration.getText().toUpperCase()+"\r\n");
							myWriter.write("  COMPANY EXPERIENCE POST: "+rcomppost.getText().toUpperCase()+"\r\n");
						}
						myWriter.close(); 
						newfile.setReadOnly();
						ViewResumeWindow viewreswindow = new ViewResumeWindow(namef,username2);
						
						File comparefile = new File(rfullname.getText().toUpperCase()+"COMPARE.txt");
						if(comparefile.exists()==true) {
							comparefile.setWritable(true);
							FileWriter mywrite = new FileWriter(comparefile);
							mywrite.write(percent10.getText()+"\r\n");
							mywrite.write(percent12.getText()+"\r\n");
							mywrite.write(cgpaug.getText()+"\r\n");
							mywrite.write(cgpapg.getText()+"\r\n");
							mywrite.write(skill1.getText()+"\r\n");
							mywrite.write(skill2.getText()+"\r\n");
							mywrite.write(skill3.getText()+"\r\n");
							mywrite.write(skill4.getText()+"\r\n");
							mywrite.write(skill5.getText()+"\r\n");
							mywrite.write(lang1.getText()+"\r\n");
							mywrite.write(lang2.getText()+"\r\n");
							mywrite.write(lang3.getText()+"\r\n");
							mywrite.write(lang4.getText()+"\r\n");
							mywrite.write(lang5.getText()+"\r\n");
							if(nocb.isSelected()==true)
								mywrite.write("NO\r\n");
							else if(yescb.isSelected()==true)
								mywrite.write("YES\r\n");
							mywrite.close();
							comparefile.setReadOnly();
						}
					
					else if(comparefile.createNewFile()==true) {
						comparefile.setWritable(true);
						FileWriter mywrite = new FileWriter(comparefile);
						mywrite.write(percent10.getText()+"\r\n");
						mywrite.write(percent12.getText()+"\r\n");
						mywrite.write(cgpaug.getText()+"\r\n");
						mywrite.write(cgpapg.getText()+"\r\n");
						mywrite.write(skill1.getText()+"\r\n");
						mywrite.write(skill2.getText()+"\r\n");
						mywrite.write(skill3.getText()+"\r\n");
						mywrite.write(skill4.getText()+"\r\n");
						mywrite.write(skill5.getText()+"\r\n");
						mywrite.write(lang1.getText()+"\r\n");
						mywrite.write(lang2.getText()+"\r\n");
						mywrite.write(lang3.getText()+"\r\n");
						mywrite.write(lang4.getText()+"\r\n");
						mywrite.write(lang5.getText()+"\r\n");
						if(nocb.isSelected()==true)
							mywrite.write("NO\r\n");
						else if(yescb.isSelected()==true)
							mywrite.write("YES\r\n");
						mywrite.close();
						comparefile.setReadOnly();						
					}
					}
				}catch (IOException e1) {
						JOptionPane.showMessageDialog(null,"UNABLE TO CREATE RESUME.","ERROR",JOptionPane.ERROR_MESSAGE);
					}

				dispose();
				}// if no errors
		}});
		skills.add(createButton);
		
		JLabel resheadLabel = new JLabel("CREATE YOUR RESUME");
		resheadLabel.setBounds(256, 20, 487, 75);
		resheadLabel.setForeground(new Color(255, 255, 255));
		resheadLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		resumePanel.add(resheadLabel);
		
		JLabel resiconLabel = new JLabel("");
		resiconLabel.setBounds(743, 20, 79, 69);
		Image img = new ImageIcon(this.getClass().getResource("/signupicon.png")).getImage();
		resiconLabel.setIcon(new ImageIcon(img));
		resumePanel.add(resiconLabel);
		
		}
		boolean isValid(String s) // checks if phone number is valid
	    { 
			Pattern num = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
			Matcher m = num.matcher(s); 
	        return (m.find() && m.group().equals(s)); 
	    } 
		
		boolean verifyName(String s) // checks if name is valid
		{
			if(s.matches("[a-zA-Z ]+"))
				return true;
			else
				return false;
		}
		boolean validDate(String s) // checks if date is valid
		{
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/uuuu");
			try {
				format.parse(s);
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		boolean emailValid(String s) //checks if email is valid
	    { 
	        String emailexpr = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
	        Pattern pat = Pattern.compile(emailexpr); 
	        if (s == null) 
	        return false; 
	        return pat.matcher(s).matches(); 
	    } 
		boolean validNum(String s) // checks if phone number is valid
		{
			String exp = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
			Pattern p =Pattern.compile(exp);
			Matcher m=p.matcher(s);
			return m.find() && m.group().equals(s);
			
		}
}
