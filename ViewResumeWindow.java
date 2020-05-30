import java.awt.*;         //Application window
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class ViewResumeWindow {

	JFrame viewresumeFrame;
	JTextArea resumeArea;
	String rec;
	String youu;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewResumeWindow viewreswindow = new ViewResumeWindow();
					viewreswindow.viewresumeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	public ViewResumeWindow() {
		initialize();
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f= chooser.getSelectedFile();
		String filename=f.getAbsolutePath();
		try {
			
			FileReader reader = new FileReader(filename);
			BufferedReader br= new BufferedReader(reader);
			resumeArea.read(br,null);
			br.close();
			resumeArea.requestFocus();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "UNABLE TO DISPLAY RESUME","ERROR",JOptionPane.ERROR_MESSAGE);
			}
	}
	public ViewResumeWindow(String receive) {
		rec=receive;
		initialize();
		try {
			
			FileReader reader = new FileReader(rec);
			BufferedReader br= new BufferedReader(reader);
			resumeArea.read(br,null);
			br.close();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "UNABLE TO DISPLAY RESUME","ERROR",JOptionPane.ERROR_MESSAGE);
			}
	}
	public ViewResumeWindow(String receive, String you) {
		rec=receive;
		youu=you;
		initialize();
		try {
			
			FileReader reader = new FileReader(rec);
			BufferedReader br= new BufferedReader(reader);
			resumeArea.read(br,null);
			br.close();
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "UNABLE TO DISPLAY RESUME","ERROR",JOptionPane.ERROR_MESSAGE);
			}
	}

	private void initialize() {
		viewresumeFrame = new JFrame("VIEW MY RESUME WINDOW");
		viewresumeFrame.getContentPane().setBackground(new Color(135, 206, 235));
		viewresumeFrame.getContentPane().setLayout(null);
		viewresumeFrame.setBounds(300, 100, 953, 674);
		viewresumeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel Label1 = new JLabel("YOUR RESUME");
		Label1.setForeground(new Color(255, 255, 255));
		Label1.setFont(new Font("Tahoma", Font.BOLD, 40));
		Label1.setBounds(320, 10, 415, 102);
		viewresumeFrame.getContentPane().add(Label1);
		
		resumeArea = new JTextArea();
		resumeArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		resumeArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(resumeArea);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(73, 122, 795, 413);
		viewresumeFrame.getContentPane().add(scroll);
	
		
		JButton prevButton = new JButton("GO TO PREVIOUS PAGE");
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow mainFrame = new MainWindow(youu);
				mainFrame.setVisible(true);
				viewresumeFrame.dispose();
			}
		});
		prevButton.setBackground(new Color(255, 204, 102));
		prevButton.setFont(new Font("Georgia", Font.PLAIN, 18));
		prevButton.setBounds(341, 563, 282, 38);
		viewresumeFrame.getContentPane().add(prevButton);
		
		viewresumeFrame.setVisible(true);
	}
}
