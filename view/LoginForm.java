package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 426996786500293573L;
	private static JLabel l1, l2, l3;
	private static JTextField tf1;
	private static JButton btn1;
	private static JPasswordField p1;
	
	private Image img;

	JFrame frame = new JFrame("Accedi a YourHealth");

	public LoginForm() {
		
		img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Università\\Desktop\\YourHealth\\bg.png");
		
		l1 = new JLabel("Accedi");
		l1.setFont(new Font("Calibri", Font.BOLD,18));

		l2 = new JLabel("E-mail");
		l2.setFont(new Font("Calibri", Font.BOLD,18));

		l3 = new JLabel("Password");
		l3.setFont(new Font("Calibri", Font.BOLD,18));

		tf1 = new JTextField();
		p1 = new JPasswordField();

		btn1 = new JButton("Accedi");
		btn1.setFont(new Font("Calibri", Font.BOLD,18));
		btn1.setBackground(Color.DARK_GRAY);
		btn1.setForeground(Color.WHITE);

		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		p1.setBounds(300, 110, 200, 30);
		btn1.setBounds(150, 160, 100, 30);

		btn1.addActionListener(this);

		frame.add(l1);
		frame.add(l2);
		frame.add(tf1);
		frame.add(l3);
		frame.add(p1);
		frame.add(btn1);
		
		frame.setSize(600, 300);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent ae){


		String uname = tf1.getText();
		@SuppressWarnings("deprecation")
		String pass = p1.getText();
		if(uname.equals("admin@admin.com") && pass.equals("abc@123")){
			new Welcome();
			//wel.setVisible(true);
			frame.setVisible(false);
		}
		else if (uname.equals("doc@doc.com") && pass.equals("abc@123")){
			new WelcomeDoc();
			//weldoc.setVisible(true);
			frame.setVisible(false);
		}
		else if (uname.equals("patient@patient.com") && pass.equals("abc@123")){
			new WelcomePatient();
			//welpatient.setVisible(true);
			frame.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(this,"E-mail o password sbagliata",
					"Errore",JOptionPane.ERROR_MESSAGE); 
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);

	}
	

	/*public static void main(String[] args){
		new LoginForm();
	}*/
}

