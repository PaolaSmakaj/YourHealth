package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class LoginForm extends JFrame{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 3401252203616577808L;
	/**
	 * 
	 */
	
	private static JButton admin, doc, patient;
	static JFrame frame;
    private static JPanel mainpanel, panel1;
    private GUIFactory factory = new GUIFactory();
	private ControllerLogin contr;


    public LoginForm() {
		try {
			contr = new ControllerLogin(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setTitle("YourHealth");
        frame.setLayout(new BorderLayout());

        mainpanel = new JPanel (new GridLayout(2,1));
        frame.add(mainpanel, BorderLayout.CENTER);
        
        panel1 = new JPanel (new GridLayout());
        
        admin = factory.createButton("Amministratore");
        admin.setBackground(Color.white);
        panel1.add(admin);
		admin.addActionListener(contr);
		doc = factory.createButton("Dottore");
		doc.setBackground(Color.lightGray);
        panel1.add(doc);
        doc.addActionListener(contr);
        patient = factory.createButton("Paziente");
		patient.setBackground(Color.lightGray);
        panel1.add(patient);
        patient.addActionListener(contr);
		
		mainpanel.add(panel1);
		frame.setVisible(true);
		/*panel2= new JPanel();
        
        JButton logout = new JButton("Esci");
        logout.setFont(new Font("Calibri", Font.PLAIN,18));
        logout.setBackground(Color.darkGray);
        logout.setForeground(Color.white);
        panel2.add(logout);
        logout.addActionListener(this);
        frame.setVisible(true);
        
        mainpanel.add(panel2);*/
        }
}