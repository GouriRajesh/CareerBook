import java.awt.EventQueue; //Application Window

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MockTestWindow {

	private JFrame MockFrame;
	JButton option1Button,option2Button,option3Button,option4Button,nextButton;
	int n=-1;
	int correct=0;
	String que[]= {"1. From a group of 7 men and 6 women, five persons are to be selected to form a committee so that at least 3 men are there on the committee. In how many ways can it be done?",
			"2. In how many ways can the letters of the word 'LEADER' be arranged?","3. A fruit seller had some apples. He sells 40% apples and still has 420 apples. Originally, how many apples did he have?",
			"4. Three candidates contested an election and received 1136, 7636 and 11628 votes respectively. What percentage of the total votes did the winning candidate get?",
			"5. An accurate clock shows 8 o'clock in the morning. Through how may degrees will the hour hand rotate when the clock shows 2 o'clock in the afternoon?",
			"6. The ratio between the length and the breadth of a rectangular park is 3 : 2. If a man cycling along the boundary of the park at the speed of 12 km/hr completes one round in 8 minutes, then the area of the park (in sq. m) is",
			"7. Running at the same constant rate, 6 identical machines can produce a total of 270 bottles per minute. At this rate, how many bottles could 10 such machines produce in 4 minutes?",
			"8. 39 persons can repair a road in 12 days, working 5 hours a day. In how many days will 30 persons, working 6 hours a day, complete the work?",
			"9. A hall is 15 m long and 12 m broad. If the sum of the areas of the floor and the ceiling is equal to the sum of the areas of four walls, the volume of the hall is",
			"10. 66 cubic centimetres of silver is drawn into a wire 1 mm in diameter. The length of the wire in metres will be?"};
	
	String ans[]= {"756","360","700","57","180","153600","1800","13","1200","84"};
	private JLabel statusLabel;
	private JTextArea questiontext;
	private JLabel icon;
	String use;
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MockTestWindow window10 = new MockTestWindow();
					window10.MockFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	public MockTestWindow() {
		initialize();
		}
	public MockTestWindow(String user) {
		use=user;
		initialize();
		}
	void questionmethod(int num)
	{
		if(num<10)
		{	
			questiontext.setText(que[num]);
			option3Button.setText(ans[num]);
		}	

		Random rand = new Random();
		int i,j,k;
		i=rand.nextInt(10);
		while(ans[i]==ans[num]) 
		{
			i=rand.nextInt(10);
		}
			option1Button.setText(ans[i]);
			j=rand.nextInt(10);
		while(ans[j]==ans[num] || ans[j]==ans[i]) 
			{
				j=rand.nextInt(10);
			}
		option2Button.setText(ans[j]);
		k=rand.nextInt(10);
		while(ans[k]==ans[num] || ans[k]==ans[i] || ans[k]==ans[j]) 
		{
			k=rand.nextInt(10);
		}
		option4Button.setText(ans[k]);
		
	}
	
	private void initialize() {
		MockFrame = new JFrame();
		MockFrame.getContentPane().setBackground(new Color(135, 206, 235));
		MockFrame.setBounds(300, 100, 924, 595);
		MockFrame.setTitle("MOCK APTITUDE TEST WINDOW");
		MockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MockFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MOCK APTITUDE TEST");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(166, 22, 471, 85);
		MockFrame.getContentPane().add(lblNewLabel);
		
		option1Button = new JButton("");
		option1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText(" OOPS! YOUR ANSWER IS WRONG ");
				statusLabel.setForeground(new Color(255, 0, 0));
			}
		});
		option1Button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		option1Button.setBounds(109, 354, 117, 39);
		MockFrame.getContentPane().add(option1Button);
		
		option2Button = new JButton("");
		option2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText(" OOPS! YOUR ANSWER IS WRONG ");
				statusLabel.setForeground(new Color(255, 0, 0));
			}
		});
		option2Button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		option2Button.setBounds(285, 354, 117, 39);
		MockFrame.getContentPane().add(option2Button);
		
		option3Button = new JButton("");
		option3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText(" YOUR ANSWER IS CORRECT! ");
				statusLabel.setForeground(new Color(0, 100, 0));
				correct++;
			}
		});
		option3Button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		option3Button.setBounds(479, 354, 117, 39);
		MockFrame.getContentPane().add(option3Button);
		
		option4Button = new JButton("");
		option4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText(" OOPS! YOUR ANSWER IS WRONG ");
				statusLabel.setForeground(new Color(255, 0, 0));
				
			}
		});
		option4Button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		option4Button.setBounds(657, 354, 117, 39);
		MockFrame.getContentPane().add(option4Button);
		
		nextButton = new JButton("NEXT QUESTION");
		nextButton.setBackground(new Color(102, 204, 153));
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(n==9) {
					statusLabel.setText("END OF TEST. Your result is "+correct+" out of 10."); 
					option1Button.setEnabled(false);
					option2Button.setEnabled(false);
					option3Button.setEnabled(false);
					option4Button.setEnabled(false);
					}
				else {
				n++;
				questionmethod(n);
				statusLabel.setText("");
				}
			}
		});
		nextButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nextButton.setBounds(466, 483, 245, 35);
		MockFrame.getContentPane().add(nextButton);
		
		statusLabel = new JLabel("");
		statusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		statusLabel.setBounds(305, 420, 369, 21);
		MockFrame.getContentPane().add(statusLabel);
		
		questiontext = new JTextArea();
		questiontext.setLineWrap(true);
		questiontext.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		questiontext.setWrapStyleWord(true);
		questiontext.setEditable(false);
		questiontext.setBounds(109, 117, 658, 192);
		MockFrame.getContentPane().add(questiontext);
		
		icon = new JLabel("");
		Image im = new ImageIcon(this.getClass().getResource("/signupicon.png")).getImage();
		icon.setIcon(new ImageIcon(im));
		icon.setBounds(630, 22, 101, 72);
		MockFrame.getContentPane().add(icon);
		
		JButton backButton = new JButton("GO TO MAIN PAGE");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mainFrame = new MainWindow(use);
				mainFrame.setVisible(true);
				MockFrame.dispose();
			}
		});
		backButton.setBackground(new Color(255, 204, 102));
		backButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		backButton.setBounds(179, 482, 245, 34);
		MockFrame.getContentPane().add(backButton);
		
		
		MockFrame.setVisible(true);
	}
}
