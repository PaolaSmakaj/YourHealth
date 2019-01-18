package view;
import java.awt.*;
import javax.swing.*;

class WelcomePatient extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JButton performances, profile;
    private static JFrame frame;
    private static JPanel panel, center;
    private JScrollPane scroll;
    private GUIFactory factory = new GUIFactory();
	private ControllerPatient contrpatient;


    public WelcomePatient() {
		try {
			contrpatient = new ControllerPatient(this);
		} catch(Exception e) {
			//PROVA
			e.printStackTrace();
		}
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setTitle("YourHealth");
        frame.setLayout(new BorderLayout());

        panel = factory.createGridPanel();
        frame.add(panel, BorderLayout.WEST);
        center = factory.createBoxPanel();
        scroll = factory.createScrollPane(center);
        frame.add(scroll, BorderLayout.CENTER);
        
        performances = factory.createButton("Lista prestazione");
        panel.add(performances);
        JSeparator sep0 = factory.createSep();
        panel.add(sep0);
        
        profile = factory.createButton("Profilo");
        panel.add(profile);
        profile.addActionListener(contrpatient);
        
        frame.setVisible(true);
       
    }
    
}