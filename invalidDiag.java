import java.awt.*;  //JFrame
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class invalidDiag extends JFrame {

	private JPanel Dialog;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invalidDiag frame = new invalidDiag();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	public invalidDiag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 180, 485, 305);
		setTitle("ERROR");
		Dialog = new JPanel();
		Dialog.setBackground(new Color(135, 206, 235));
		setContentPane(Dialog);
				Dialog.setLayout(null);
			
			
				JLabel Label1 = new JLabel("INVALID USERNAME OR PASSWORD");
				Label1.setForeground(new Color(255, 0, 0));
				Label1.setFont(new Font("Tahoma", Font.BOLD, 20));
				Label1.setBounds(53, 32, 384, 40);
				getContentPane().add(Label1);
			
			
				JButton Button = new JButton("OK");
				Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						}
				}); 
				Button.setFont(new Font("Tahoma", Font.PLAIN, 14));
				Button.setBounds(188, 203, 85, 21);
				getContentPane().add(Button);
			
				JLabel Label2 = new JLabel("PLEASE TRY AGAIN OR");
				Label2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				Label2.setBounds(135, 82, 205, 47);
				getContentPane().add(Label2);
			
				JLabel Label3 = new JLabel("SIGN UP IF YOU DON'T HAVE AN ACCOUNT");
				Label3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				Label3.setBounds(50, 139, 445, 21);
				getContentPane().add(Label3);
			}
		
	}


