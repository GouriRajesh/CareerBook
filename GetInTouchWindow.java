import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class GetInTouchWindow {

	private JFrame getframe;
	private JTextField emailText;
	private JTextField subjectText;
	private JComboBox emailBox;
	String user;
	String email;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetInTouchWindow window = new GetInTouchWindow();
					window.getframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */
	
	public GetInTouchWindow() {
		initialize();
	}
	
	public GetInTouchWindow(String user) {
		this.user=user;
		initialize();
	} 

	private void initialize() {
		getframe = new JFrame("GET IN TOUCH WINDOW");
		getframe.setBounds(300, 80, 972, 682);
		getframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getframe.getContentPane().setBackground(new Color(135, 206, 235));
		getframe.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("GET IN TOUCH");
		heading.setForeground(new Color(255, 255, 255));
		heading.setFont(new Font("Tahoma", Font.BOLD, 40));
		heading.setBounds(281, 24, 302, 78);
		getframe.getContentPane().add(heading);
		
		JLabel fromLabel = new JLabel("FROM EMAIL ID");
		fromLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fromLabel.setBounds(117, 146, 133, 26);
		getframe.getContentPane().add(fromLabel);
		
		JLabel toLabel = new JLabel("TO EMAIL ID");
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		toLabel.setBounds(117, 215, 133, 26);
		getframe.getContentPane().add(toLabel);
		
		try {
		File object = new File(user+".txt");
		email = Files.readAllLines(Paths.get(user+".txt")).get(2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		emailText = new JTextField(email); // user email here
		emailText.setEditable(false);
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailText.setBounds(312, 143, 480, 39);
		getframe.getContentPane().add(emailText);
		emailText.setColumns(10);
		
		JTextArea messageText = new JTextArea();
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		messageText.setLineWrap(true);
		messageText.setBounds(162, 353, 630, 189);
		getframe.getContentPane().add(messageText);
		
		JLabel subjectLabel = new JLabel("SUBJECT");
		subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		subjectLabel.setBounds(117, 286, 112, 25);
		getframe.getContentPane().add(subjectLabel);
		
		subjectText = new JTextField();
		subjectText.setColumns(10);
		subjectText.setBounds(312, 282, 480, 39);
		subjectText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getframe.getContentPane().add(subjectText);
		
		JButton sendButton = new JButton("SEND");
		sendButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {	
				
			Mail newmail = new Mail();
			newmail.send(emailBox.getSelectedItem().toString(),messageText.getText()+"\r\nPlease contact the below email ID to address this query.Thankyou from CAREERBOOK.\r\n"+emailText.getText(),subjectText.getText());
			}
		});
		sendButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sendButton.setBackground(new Color(102, 204,153));
		sendButton.setBounds(540, 563, 133, 39);
		getframe.getContentPane().add(sendButton);
		
		JLabel icon = new JLabel("");
		Image ima= new ImageIcon(this.getClass().getResource("/email.png")).getImage();
		icon.setIcon(new ImageIcon(ima));
		icon.setBounds(599, 24, 85, 72);
		getframe.getContentPane().add(icon);
		
		emailBox = new JComboBox();
		emailBox.setBackground(new Color(255, 255, 255));
		emailBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailBox.setBounds(312, 213, 480, 39);
		try {
			Scanner sc = new Scanner(new File("BusinessEmails.txt"));
			while(sc.hasNext()==true)
			{
				emailBox.addItem(sc.nextLine());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		getframe.getContentPane().add(emailBox);
		
		JButton prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mainFrame = new MainWindow(user);
				mainFrame.setVisible(true);
				getframe.dispose();
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		prevButton.setBounds(220, 563, 282, 38);
		getframe.getContentPane().add(prevButton);
		
		getframe.setVisible(true);
	}
}
