import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SelectCandidates{

	private JFrame selectFrame;
	private JTextField selectingcompanyname;
	private JPasswordField selectingcompanypassword;
	String company;
	
	int selected=0;
	int candidates=0;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectCandidates candidateswindow = new SelectCandidates();
					candidateswindow.selectFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}    */

	SelectCandidates() 
	{
		initialize();
	}
	SelectCandidates(String comp) 
	{
		company=comp;
		initialize();
	} 
	
	int check(String one,String two,String three,String four,String start) throws Exception
	{
			int lines1=0;
			int lines2=0;
			int compare=0;
			if(three.startsWith(start)==true)
			{
				File file1 = new File(one);
				File file2 = new File(three);
			
				Scanner sc1 = new Scanner(file1);
				Scanner sc2 = new Scanner(file2);
					
				while(sc1.hasNext()) {
						lines1++; //lines in candidate file
						sc1.nextLine();
						}
					String f1[]= new String[lines1]; //initialize with no. of lines in candidate file
					
				while(sc2.hasNext()) {
						lines2++; //lines in company file
						sc2.nextLine();
						}

				String f2[]= new String[lines2]; //initialize with no. of lines in company file
					sc1.close();
					sc2.close();
					Scanner scan1 = new Scanner(file1);
					Scanner scan2 = new Scanner(file2);
					
					for(int i1=0; i1<lines1; i1++) {
						f1[i1]=scan1.nextLine();       // copy all content of candidate file into array
					}
					for(int i2=0; i2<lines2; i2++ ) {
						f2[i2]=scan2.nextLine();		// copy all content of company file into array
					}

					for(int j=0;j<=3;j++) 
					{
						if(Float.parseFloat(f1[j])>=Float.parseFloat(f2[j]))
						{
							compare++;
						}
					}

					for(int k=4;k<=8;k++) {
						for(int l=4;l<=8;l++) {
							
							if(f1[k].equalsIgnoreCase(f2[l])) {
								compare++;
							}
							
						}
					}

					for(int g=9; g<=13; g++) {
						for(int o=9; o<=11; o++) {
							
							if(f1[g].equalsIgnoreCase(f2[o]))	{
								compare++;
							}
						}
					}

					if(f1[14].compareTo(f2[12])==0 || f1[14].compareTo("yes")==0) {
						compare++;
						
					}

					if(compare>=10) {
						System.out.println("YOU ARE SELECTED");
						
						Mail obj = new Mail();
						obj.send(two,"Congratulations!\r\nYou have been SELECTED for Round Two of the interview. For further information please get in touch with the company personnel using the Official Mail ID provided below. ALL THE BEST!\r\n"+ four);
						
						scan1.close();
						scan2.close();
						return 1;
					}
					else {
						System.out.println("YOU ARE NOT SELECTED");
						
						Mail obj = new Mail();
						obj.send(two,"We are sorry to inform you that you have NOT been selected for Round Two of the interview. Better Luck Next Time!");
						
						scan1.close();
						scan2.close();
						return 0;
					}
					
			
			} // if same company
				else
				{
					File newfile = new File("newfile.txt");
					if(newfile.exists()==true) {
						FileWriter myWriter = new FileWriter(newfile,true);
						myWriter.write(one+"\r\n");
						myWriter.write(two+"\r\n");
						myWriter.write(three+"\r\n");
						myWriter.write(four+"\r\n");
						myWriter.write("\r\n");
						myWriter.close();
					}
					
					else if(newfile.createNewFile()==true) {
						FileWriter myWriter = new FileWriter(newfile,true);
						myWriter.write(one+"\r\n");
						myWriter.write(two+"\r\n");
						myWriter.write(three+"\r\n");
						myWriter.write(four+"\r\n");
						myWriter.write("\r\n");
						myWriter.close();
					}
					return 0;
				}
	}
	
	int can(String three, String start) {
		
		if(three.startsWith(start)==true)
		{
			return 1;
		}
		else return 0;
	}

	private void initialize() {
		selectFrame = new JFrame("SELECT CANDIDATES WINDOW");
		selectFrame.getContentPane().setBackground(new Color(135, 206, 235));
		selectFrame.setBounds(350, 100, 750, 430);
		selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectFrame.getContentPane().setLayout(null);
		
		JLabel candidateheadLabel = new JLabel("SELECT CANDIDATES");
		candidateheadLabel.setForeground(new Color(255, 255, 255));
		candidateheadLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		candidateheadLabel.setBounds(93, 44, 466, 49);
		selectFrame.getContentPane().add(candidateheadLabel);
		
		JLabel companyLabel = new JLabel("ENTER COMPANY NAME");
		companyLabel.setForeground(new Color(255, 255, 255));
		companyLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		companyLabel.setBounds(58, 137, 308, 33);
		selectFrame.getContentPane().add(companyLabel);
		
		JLabel passwordLabel = new JLabel("ENTER PASSWORD");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
		passwordLabel.setBounds(58, 211, 273, 33);
		selectFrame.getContentPane().add(passwordLabel);
		
		selectingcompanyname = new JTextField();
		selectingcompanyname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		selectingcompanyname.setBounds(416, 137, 250, 37);
		selectFrame.getContentPane().add(selectingcompanyname);
		selectingcompanyname.setColumns(10);
		
		selectingcompanypassword = new JPasswordField();
		selectingcompanypassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		selectingcompanypassword.setBounds(416, 207, 250, 37);
		selectFrame.getContentPane().add(selectingcompanypassword);

		try { File take = new File(company+".txt");
		String name = Files.readAllLines(Paths.get(company+".txt")).get(1);
		selectingcompanyname.setText(name);
		selectingcompanyname.setEditable(false);
		}catch(Exception e) {
			e.printStackTrace();
		} 
		
		JButton selectButton = new JButton("SELECT");
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File one = new File(selectingcompanyname.getText()+".txt");
					Scanner sc = new Scanner(one);
					
					if(sc.nextLine().compareTo(selectingcompanypassword.getText())==0)  // company password is valid
						{  	sc.close(); 
					
						File two = new File("temp.txt"); //contains all the job applicants
						Scanner scan = new Scanner(two);
						while(scan.hasNextLine()==true)
						{
							String cname = scan.nextLine();
							String cemail = scan.nextLine();
							String coname = scan.nextLine();
							String coemail = scan.nextLine();
							scan.nextLine();
							
							int value = check(cname,cemail,coname,coemail,selectingcompanyname.getText().toUpperCase());
						
							if(value==1) 
							{
								selected++;
							}
							int val= can(coname,selectingcompanyname.getText()/*.toUpperCase()*/);
							if(val==1)
							{
								candidates++;
							}
						} 
							scan.close();
							File mickey = new File("newfile.txt"); // contains applicants other than the current company, rewritten to temp.txt
							Scanner sc1 =new Scanner(mickey);
							File minnie = new File("temp.txt");
							minnie.setWritable(true);
							FileWriter myWriter = new FileWriter(minnie);
							
							while(sc1.hasNextLine()==true) {
								String t= sc1.nextLine();
								myWriter.write(t+"\r\n");
							}
							minnie.setReadOnly();
							sc1.close();
							myWriter.close();
							FileWriter mywriter = new FileWriter(new File("newfile.txt")); // contents are empty
							mywriter.close();
							
							System.out.println("Total number of candidates applied="+candidates);
							System.out.println("Total number of selected candidates="+selected);
							JOptionPane.showMessageDialog(null,"Total number of candidates applied="+candidates+"\r\nTotal number of selected candidates="+selected,"RESULT",JOptionPane.INFORMATION_MESSAGE);
							// does not work when newfile.txt file is deleted. Program has to be run once in order to work properly.
						
						}
					else 
						{
							JOptionPane.showMessageDialog(null,"Wrong password.","ERROR",JOptionPane.ERROR_MESSAGE);
						}	
					} catch(Exception e1) 
					{
						JOptionPane.showMessageDialog(null, "UNABLE TO SELECT CANDIDATES/OPEN FILE.","ERROR",JOptionPane.ERROR_MESSAGE);
					} 
				}
			});
		selectButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectButton.setBackground(new Color(244, 164, 96));
		selectButton.setBounds(440, 291, 125, 33);
		selectFrame.getContentPane().add(selectButton);
		
		JLabel icon = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/employee.png")).getImage();
		icon.setIcon(new ImageIcon(im));
		icon.setBounds(511, 10, 95, 117);
		selectFrame.getContentPane().add(icon);
		
		JButton prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainWindow businessmainFrame = new BusinessMainWindow(company);
				selectFrame.dispose();
				
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prevButton.setBounds(100, 291, 282, 33);
		selectFrame.getContentPane().add(prevButton);
		
		selectFrame.setVisible(true);
	}
	


	
}
