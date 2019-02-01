package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class WelcomeDoc extends JFrame implements ActionListener {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JButton performances, profile;
    private static JFrame frame;
    private static JPanel mainpanel, panel1, panel2;
    private GUIFactory factory = new GUIFactory();
	private ControllerDoc contrdoc;


    public WelcomeDoc() {
		try {
			contrdoc = new ControllerDoc(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setTitle("Bentornato, Dottore - YourHealth");
        frame.setLayout(new BorderLayout());

        mainpanel = new JPanel (new GridLayout(2,1));
        frame.add(mainpanel, BorderLayout.CENTER);
        
        panel1 = new JPanel (new GridLayout());
        
        performances = factory.createButton("Lista prestazioni");
        performances.setBackground(Color.white);
        panel1.add(performances);
		performances.addActionListener(contrdoc);
		profile = factory.createButton("Profilo");
		profile.setBackground(Color.lightGray);
        panel1.add(profile);
        profile.addActionListener(contrdoc);
		
		mainpanel.add(panel1);
        
		panel2= new JPanel();
        
        JButton logout = new JButton("Esci");
        logout.setFont(new Font("Calibri", Font.PLAIN,18));
        logout.setBackground(Color.darkGray);
        logout.setForeground(Color.white);
        panel2.add(logout);
        logout.addActionListener(this);
        frame.setVisible(true);
        
        mainpanel.add(panel2);
        }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		LoginForm login = new LoginForm();
	    login.setVisible(true);
	    frame.setVisible(false);
		
	}
       
    
    
}