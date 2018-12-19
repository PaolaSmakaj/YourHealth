package view;
import java.awt.*;
import javax.swing.*;

class WelcomePatient extends JFrame {
    
	private JButton addPerformance, removePerformance;
    private static JButton profile;
    private static JFrame frame;
    private static JPanel panel, center;
    private JScrollPane scroll;
    private WelcomeFactory factory = new WelcomeFactory();
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
        
        addPerformance = factory.createButton("Aggiungi prestazione");
        panel.add(addPerformance);
		//addPerformance.addActionListener(contrpatient); 			
        //removePerformance = factory.createButton("Rimuovi prestazione");
        //panel.add(removePerformance);
		//removePerformance.addActionListener(contrpatient);
        JSeparator sep0 = factory.createSep();
        panel.add(sep0);
        
        profile = factory.createButton("Profilo");
        panel.add(profile);
        profile.addActionListener(contrpatient);
        
        frame.setVisible(true);
       
    }
    
}