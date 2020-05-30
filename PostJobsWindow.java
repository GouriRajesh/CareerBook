import javax.swing.*;  //JFrame
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class PostJobsWindow extends JFrame {

	private JPanel postjobsPanel;
	private JTextField jobcompanyname,jobpost,joblocation,jobemail,language1,language3,skill2,skill3,skill4,skill5,skill1,percent10,percent12,ugcgpa,pgcgpa,language2;
	private JRadioButton yes;
	private JRadioButton no;
	private JTextField jobid;
	private JTextField applyby;
	String company;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostJobsWindow postjobsFrame = new PostJobsWindow();
					postjobsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	public PostJobsWindow() {
		initialize();
	}
	public PostJobsWindow(String comp) {
		company=comp;
		initialize();
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 20, 1394, 805);
		setTitle("POST JOBS WINDOW");
		postjobsPanel = new JPanel();
		postjobsPanel.setBackground(new Color(135, 206, 235));
		postjobsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(postjobsPanel);
		postjobsPanel.setLayout(null);
		
		JLabel jobheadingLabel = new JLabel("POST NEW JOB VACANCIES");
		jobheadingLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		jobheadingLabel.setForeground(new Color(255, 255, 255));
		jobheadingLabel.setBounds(423, 10, 538, 75);
		postjobsPanel.add(jobheadingLabel);
		
		JLabel companynameLabel = new JLabel("COMPANY NAME");
		companynameLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		companynameLabel.setBounds(22, 112, 171, 35);
		postjobsPanel.add(companynameLabel);
		
		jobcompanyname = new JTextField();
		jobcompanyname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobcompanyname.setBounds(203, 115, 152, 35);
		postjobsPanel.add(jobcompanyname);
		jobcompanyname.setColumns(10);
		
		JLabel jobpostLabel = new JLabel("JOB POST");
		jobpostLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		jobpostLabel.setBounds(708, 114, 141, 31);
		postjobsPanel.add(jobpostLabel);
		
		JLabel jobdescriptionLabel = new JLabel("JOB DESCRIPTION");
		jobdescriptionLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		jobdescriptionLabel.setBounds(22, 209, 171, 35);
		postjobsPanel.add(jobdescriptionLabel);
		
		JTextArea jobdescription = new JTextArea();
		jobdescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobdescription.setLineWrap(true);
		jobdescription.setWrapStyleWord(true);
		jobdescription.setBounds(203, 194, 152, 69);
		postjobsPanel.add(jobdescription);
		
		JLabel skillrequirementLabel = new JLabel("SKILL REQUIREMENTS");
		skillrequirementLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		skillrequirementLabel.setBounds(80, 315, 206, 35);
		postjobsPanel.add(skillrequirementLabel);
		
		JLabel languagerequirementLabel = new JLabel("LANGUAGE REQUIREMENTS");
		languagerequirementLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		languagerequirementLabel.setBounds(971, 315, 273, 35);
		postjobsPanel.add(languagerequirementLabel);
		
		JLabel joblocationLabel = new JLabel("JOB LOCATION");
		joblocationLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		joblocationLabel.setBounds(1028, 114, 145, 30);
		postjobsPanel.add(joblocationLabel);
		
		JLabel emailLabel = new JLabel("CONTACT EMAIL");
		emailLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		emailLabel.setBounds(1031, 206, 157, 41);
		postjobsPanel.add(emailLabel);
		
		JLabel educationrequirementLabel = new JLabel("EDUCATION REQUIREMENTS");
		educationrequirementLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		educationrequirementLabel.setBounds(507, 317, 263, 31);
		postjobsPanel.add(educationrequirementLabel);
		
		jobpost = new JTextField();
		jobpost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobpost.setColumns(10);
		jobpost.setBounds(835, 115, 152, 35);
		postjobsPanel.add(jobpost);
		
		joblocation = new JTextField();
		joblocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		joblocation.setColumns(10);
		joblocation.setBounds(1198, 115, 152, 35);
		postjobsPanel.add(joblocation);
		
		jobemail = new JTextField();
		jobemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobemail.setColumns(10);
		jobemail.setBounds(1198, 210, 152, 35);
		postjobsPanel.add(jobemail);
		
		language1 = new JTextField();
		language1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		language1.setColumns(10);
		language1.setBounds(1075, 395, 152, 35);
		postjobsPanel.add(language1);
		
		language3 = new JTextField();
		language3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		language3.setColumns(10);
		language3.setBounds(1075, 581, 152, 35);
		postjobsPanel.add(language3);
		
		skill2 = new JTextField();
		skill2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill2.setColumns(10);
		skill2.setBounds(101, 446, 152, 35);
		postjobsPanel.add(skill2);
		
		skill3 = new JTextField();
		skill3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill3.setColumns(10);
		skill3.setBounds(101, 525, 152, 35);
		postjobsPanel.add(skill3);
		
		skill4 = new JTextField();
		skill4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill4.setColumns(10);
		skill4.setBounds(101, 604, 152, 35);
		postjobsPanel.add(skill4);
		
		skill5 = new JTextField();
		skill5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill5.setColumns(10);
		skill5.setBounds(101, 674, 152, 35);
		postjobsPanel.add(skill5);
		
		skill1 = new JTextField();
		skill1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		skill1.setColumns(10);
		skill1.setBounds(101, 375, 152, 35);
		postjobsPanel.add(skill1);
		
		percent10 = new JTextField();
		percent10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		percent10.setColumns(10);
		percent10.setBounds(412, 395, 152, 35);
		postjobsPanel.add(percent10);
		
		percent12 = new JTextField();
		percent12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		percent12.setColumns(10);
		percent12.setBounds(708, 395, 152, 35);
		postjobsPanel.add(percent12);
		
		ugcgpa = new JTextField();
		ugcgpa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ugcgpa.setColumns(10);
		ugcgpa.setBounds(412, 506, 152, 35);
		postjobsPanel.add(ugcgpa);
		
		pgcgpa = new JTextField();
		pgcgpa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pgcgpa.setColumns(10);
		pgcgpa.setBounds(708, 506, 152, 35);
		postjobsPanel.add(pgcgpa);
		
		language2 = new JTextField();
		language2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		language2.setColumns(10);
		language2.setBounds(1075, 492, 152, 35);
		postjobsPanel.add(language2);
		
		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel.setBounds(46, 382, 45, 28);
		postjobsPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("2.");
		lblNewLabel_9.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_9.setBounds(46, 453, 45, 28);
		postjobsPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("5.");
		lblNewLabel_10.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_10.setBounds(46, 677, 45, 32);
		postjobsPanel.add(lblNewLabel_10);
		
		JLabel jobtypeLabel = new JLabel("JOB TYPE");
		jobtypeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		jobtypeLabel.setBounds(402, 211, 100, 30);
		postjobsPanel.add(jobtypeLabel);
		
		JLabel lblNewLabel_12 = new JLabel("4.");
		lblNewLabel_12.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_12.setBounds(46, 607, 45, 20);
		postjobsPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("3.");
		lblNewLabel_13.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_13.setBounds(46, 528, 45, 32);
		postjobsPanel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("1.");
		lblNewLabel_14.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_14.setBounds(985, 398, 45, 24);
		postjobsPanel.add(lblNewLabel_14);
		
		JComboBox jobtypecomboBox = new JComboBox();
		jobtypecomboBox.setBackground(new Color(255, 255, 255));
		jobtypecomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jobtypecomboBox.setBounds(527, 212, 149, 35);
		jobtypecomboBox.addItem("FULL-TIME");
		jobtypecomboBox.addItem("PART-TIME");
		jobtypecomboBox.addItem("INTERNSHIP");
		jobtypecomboBox.addItem("WORK FROM HOME");
		postjobsPanel.add(jobtypecomboBox);
		
		try { File take = new File(company+".txt");
		String name = Files.readAllLines(Paths.get(company+".txt")).get(1);
		jobcompanyname.setText(name);
		jobcompanyname.setEditable(false);
		String email = Files.readAllLines(Paths.get(company+".txt")).get(4);
		jobemail.setText(email);
		jobemail.setEditable(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton postitButton = new JButton("POST IT");
		postitButton.setBackground(new Color(255, 204, 102));
		postitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int flag=0;
				if(!verifyName(jobcompanyname.getText()))
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid company name.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(emailValid(jobemail.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid email address.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(validDate(applyby.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter a valid date in dd/mm/yyy format.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				if(validNum(percent10.getText())==false || validNum(percent12.getText())==false || validNum(ugcgpa.getText())==false ||validNum(pgcgpa.getText())==false)
				{
					JOptionPane.showMessageDialog(null,"Please enter valid percentage or cgpa.","ERROR",JOptionPane.ERROR_MESSAGE);
					flag=1;
				}
				
				if(flag==0) {
				
				System.out.println("JOB HAS BEEN POSTED");
				String f=(jobcompanyname.getText()+jobid.getText()).toUpperCase()+".txt";
				File particularfile = new File(f);
				
				try {
				if(particularfile.createNewFile()==true) {
					FileWriter mywrite = new FileWriter(particularfile);
					mywrite.write(percent10.getText()+"\r\n");
					mywrite.write(percent12.getText()+"\r\n");
					mywrite.write(ugcgpa.getText()+"\r\n");
					mywrite.write(pgcgpa.getText()+"\r\n");
					mywrite.write(skill1.getText()+"\r\n");
					mywrite.write(skill2.getText()+"\r\n");
					mywrite.write(skill3.getText()+"\r\n");
					mywrite.write(skill4.getText()+"\r\n");
					mywrite.write(skill5.getText()+"\r\n");
					mywrite.write(language1.getText()+"\r\n");
					mywrite.write(language2.getText()+"\r\n");
					mywrite.write(language3.getText()+"\r\n");
					
					if(yes.isSelected()==true)
					mywrite.write("YES\r\n");
					else if(no.isSelected()==true)
					mywrite.write("NO\r\n");
					mywrite.close(); 
					particularfile.setReadOnly();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"FILE CREATION ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
				File commonfile = new File("commonjobportalfile.txt");
				if(commonfile.exists()==true) {
					
					try {
						commonfile.setWritable(true);
						FileWriter myWriter = new FileWriter("commonjobportalfile.txt",true); //for appending data
						myWriter.write("***********************************"+(jobcompanyname.getText().toUpperCase())+"**************************************\r\n");
						myWriter.write("  JOB POST: "+jobpost.getText().toUpperCase()+"\r\n");
						myWriter.write("  JOB ID: "+jobid.getText().toUpperCase()+"\r\n");
						myWriter.write("  JOB LOCATION: "+joblocation.getText().toUpperCase()+"\r\n");
						myWriter.write("  JOB DESCRIPTION: "+jobdescription.getText().toUpperCase()+"\r\n");
						myWriter.write("  JOB TYPE: "+(jobtypecomboBox.getSelectedItem().toString().toUpperCase())+"\r\n");
						myWriter.write("  CONTACT EMAIL ID: "+jobemail.getText().toUpperCase()+"\r\n");
						myWriter.write("  SKILL REQUIREMENTS:\r\n");
						myWriter.write("  SKILL 1: "+skill1.getText()+"\r\n");
						myWriter.write("  SKILL 2: "+skill2.getText()+"\r\n");
						myWriter.write("  SKILL 3: "+skill3.getText()+"\r\n");
						myWriter.write("  SKILL 4: "+skill4.getText()+"\r\n");
						myWriter.write("  SKILL 5: "+skill5.getText()+"\r\n");
						myWriter.write("  EDUCATION REQUIREMENTS:\r\n");
						myWriter.write("  10TH STANDARD PERCENTAGE MINIMUM: "+percent10.getText()+"\r\n");
						myWriter.write("  12TH STANDARD PERCENTAGE MINIMUM: "+percent12.getText()+"\r\n");
						myWriter.write("  UNDERGRADUATE MINIMUM CGPA: "+ugcgpa.getText()+"\r\n");
						myWriter.write("  POSTGRADUATE MINIMUM CGPA: "+pgcgpa.getText()+"\r\n");
						myWriter.write("  LANGUAGE REQUIREMENTS:\r\n");
						myWriter.write("  FIRST PRIORITY: "+language1.getText()+"\r\n");
						myWriter.write("  SECOND PRIORITY: "+language2.getText()+"\r\n");
						myWriter.write("  THIRD PRIORITY: "+language3.getText()+"\r\n");
						
						if(yes.isSelected()==true)
						myWriter.write("  PREVIOUS EXPERIENCE REQUIRED?: YES\r\n");
						else if(no.isSelected()==true)
						myWriter.write("  PREVIOUS EXPERIENCE REQUIRED?: NO\r\n");
						myWriter.write("  APPLY BEFORE: "+applyby.getText()+"\r\n");
						myWriter.close(); 
						commonfile.setReadOnly();
						}
						catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}// if
					else
					try {
							if(commonfile.createNewFile()==true) {
							commonfile.setWritable(true);
							FileWriter myWriter = new FileWriter("commonjobportalfile.txt"); //for writing 1st time
							myWriter.write("***********************************"+(jobcompanyname.getText().toUpperCase())+"**************************************\r\n");
							myWriter.write("  JOB POST: "+jobpost.getText().toUpperCase()+"\r\n");
							myWriter.write("  JOB ID: "+jobid.getText().toUpperCase()+"\r\n");
							myWriter.write("  JOB LOCATION: "+joblocation.getText().toUpperCase()+"\r\n");
							myWriter.write("  JOB DESCRIPTION: "+jobdescription.getText().toUpperCase()+"\r\n");
							myWriter.write("  JOB TYPE: "+(jobtypecomboBox.getSelectedItem().toString().toUpperCase())+"\r\n");
							myWriter.write("  CONTACT EMAIL ID: "+jobemail.getText().toUpperCase()+"\r\n");
							myWriter.write("  SKILL REQUIREMENTS:\r\n");
							myWriter.write("  SKILL 1: "+skill1.getText()+"\r\n");
							myWriter.write("  SKILL 2: "+skill2.getText()+"\r\n");
							myWriter.write("  SKILL 3: "+skill3.getText()+"\r\n");
							myWriter.write("  SKILL 4: "+skill4.getText()+"\r\n");
							myWriter.write("  SKILL 5: "+skill5.getText()+"\r\n");
							myWriter.write("  EDUCATION REQUIREMENTS:\r\n");
							myWriter.write("  10TH STANDARD PERCENTAGE MINIMUM: "+percent10.getText()+"\r\n");
							myWriter.write("  12TH STANDARD PERCENTAGE MINIMUM: "+percent12.getText()+"\r\n");
							myWriter.write("  UNDERGRADUATE MINIMUM CGPA: "+ugcgpa.getText()+"\r\n");
							myWriter.write("  POSTGRADUATE MINIMUM CGPA: "+pgcgpa.getText()+"\r\n");
							myWriter.write("  LANGUAGE REQUIREMENTS:\r\n");
							myWriter.write("  FIRST PRIORITY: "+language1.getText()+"\r\n");
							myWriter.write("  SECOND PRIORITY: "+language2.getText()+"\r\n");
							myWriter.write("  THIRD PRIORITY: "+language3.getText()+"\r\n");
							
							if(yes.isSelected()==true)
							myWriter.write("  PREVIOUS EXPERIENCE REQUIRED?: YES\r\n");
							else if(no.isSelected()==true)
							myWriter.write("  PREVIOUS EXPERIENCE REQUIRED?: NO\r\n");
							myWriter.write("  APPLY BEFORE: "+applyby.getText()+"\r\n");
							myWriter.close(); 
							commonfile.setReadOnly();
						}
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				BusinessMainWindow window = new BusinessMainWindow(company);
				dispose();
			}//if flag
		}});
		postitButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		postitButton.setBounds(920, 660, 152, 56);
		postjobsPanel.add(postitButton);
		
		JLabel lblNewLabel_15 = new JLabel("2.");
		lblNewLabel_15.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_15.setBounds(985, 493, 45, 28);
		postjobsPanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("3.");
		lblNewLabel_16.setFont(new Font("Georgia", Font.PLAIN, 22));
		lblNewLabel_16.setBounds(985, 582, 45, 28);
		postjobsPanel.add(lblNewLabel_16);
		
		JLabel experienceLabel = new JLabel("Previous Experience Required?");
		experienceLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		experienceLabel.setBounds(501, 583, 301, 56);
		postjobsPanel.add(experienceLabel);
		
		yes = new JRadioButton("YES");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(yes.isSelected()==true) {
					no.setSelected(false);
				}
			}
		});
		yes.setBackground(new Color(255, 255, 255));
		yes.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		yes.setBounds(444, 670, 141, 41);
		postjobsPanel.add(yes);
		
		no = new JRadioButton("NO");
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(no.isSelected()==true)
					yes.setSelected(false);
			}
		});
		no.setBackground(new Color(255, 255, 255));
		no.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		no.setBounds(661, 670, 141, 41);
		postjobsPanel.add(no);
		
		JLabel Label10 = new JLabel("10%");
		Label10.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Label10.setBounds(348, 395, 41, 35);
		postjobsPanel.add(Label10);
		
		JLabel Label12 = new JLabel("12%");
		Label12.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Label12.setBounds(653, 397, 45, 30);
		postjobsPanel.add(Label12);
		
		JLabel LabelUG = new JLabel("UG CGPA");
		LabelUG.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		LabelUG.setBounds(308, 509, 81, 28);
		postjobsPanel.add(LabelUG);
		
		JLabel LabelPG = new JLabel("PG CGPA");
		LabelPG.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		LabelPG.setBounds(620, 511, 84, 24);
		postjobsPanel.add(LabelPG);
		
		JLabel jobidLabel = new JLabel("JOB ID");
		jobidLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		jobidLabel.setBounds(402, 115, 69, 35);
		postjobsPanel.add(jobidLabel);
		
		jobid = new JTextField();
		jobid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jobid.setBounds(524, 113, 152, 35);
		postjobsPanel.add(jobid);
		jobid.setColumns(10);
		
		applyby = new JTextField();
		applyby.setFont(new Font("Tahoma", Font.PLAIN, 16));
		applyby.setBounds(839, 212, 148, 35);
		postjobsPanel.add(applyby);
		applyby.setColumns(10);
		
		JLabel applybyLabel = new JLabel("APPLY BY");
		applybyLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		applybyLabel.setBounds(708, 206, 120, 40);
		postjobsPanel.add(applybyLabel);

		JLabel jobicon = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/jobseeker.png")).getImage();
		jobicon.setIcon(new ImageIcon(im));
		jobicon.setBounds(972, 10, 100, 85);
		postjobsPanel.add(jobicon);
		
		setVisible(true);
	}
	boolean verifyName(String s)
	{
		if(s.matches("[a-zA-Z ]+"))
			return true;
		else
			return false;
	}
	boolean validDate(String s)
	{
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/mm/uuuu");
		try {
			format.parse(s);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	boolean emailValid(String s) 
    { 
        String emailexpr = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
        Pattern pat = Pattern.compile(emailexpr); 
        if (s == null) 
        return false; 
        return pat.matcher(s).matches(); 
    } 
	boolean validNum(String s)
	{
		String exp = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
		Pattern p =Pattern.compile(exp);
		Matcher m=p.matcher(s);
		return m.find() && m.group().equals(s);
		
	}
}
