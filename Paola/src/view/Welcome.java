package view;
import java.awt.*;
import javax.swing.*;

class Welcome extends JFrame {
    
    private JButton addPerformance, removePerformance, addPatient, addDoctor, removePatient, removeDoctor, addMach, removeMach, addAmb, removeAmb;
    private static JButton performances, patients, doctors, mach, amb;
    private static JFrame frame;
    private static JPanel panel, center;
    private JScrollPane scroll;
    private WelcomeFactory factory = new WelcomeFactory();
	private Controller contr;


    public Welcome() {
		try {
			contr = new Controller(this);
		} catch(Exception e) {
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
        
        performances = factory.createButton("Lista prestazioni");
        panel.add(performances);
		performances.addActionListener(contr);
        addPerformance = factory.createButton("Aggiungi prestazione");
        panel.add(addPerformance);
		addPerformance.addActionListener(contr); 			
        removePerformance = factory.createButton("Rimuovi prestazione");
        panel.add(removePerformance);
		removePerformance.addActionListener(contr);	
        
        JSeparator sep0 = factory.createSep();
        panel.add(sep0);
        
        patients = factory.createButton("Lista pazienti");
        panel.add(patients);
		patients.addActionListener(contr);
        addPatient = factory.createButton("Aggiungi paziente");
        panel.add(addPatient);
		addPatient.addActionListener(contr);
        removePatient = factory.createButton("Rimuovi paziente");
        panel.add(removePatient);
		removePatient.addActionListener(contr);	

        JSeparator sep1 = factory.createSep();
        panel.add(sep1);
        
        doctors = factory.createButton("Lista dottori");
        panel.add(doctors);
		doctors.addActionListener(contr);
        addDoctor = factory.createButton("Aggiungi dottore");
        panel.add(addDoctor);
		addDoctor.addActionListener(contr);	
        removeDoctor = factory.createButton("Rimuovi dottore");
        panel.add(removeDoctor);
		removeDoctor.addActionListener(contr);	
        
        JSeparator sep2 = factory.createSep();
        panel.add(sep2);
        
        mach = factory.createButton("Lista macchinari");
        panel.add(mach);
		mach.addActionListener(contr);
		addMach = factory.createButton("Aggiungi macchinario");
        panel.add(addMach);
		addMach.addActionListener(contr);
        removeMach = factory.createButton("Rimuovi macchinario");
        panel.add(removeMach);
		removeMach.addActionListener(contr);
        frame.setVisible(true);
       
        JSeparator sep3 = factory.createSep();
        panel.add(sep3);
        
        amb = factory.createButton("Lista ambulatori");
        panel.add(amb);
		amb.addActionListener(contr);
		addAmb = factory.createButton("Aggiungi ambulatorio");
        panel.add(addAmb);
		addAmb.addActionListener(contr);
        removeAmb = factory.createButton("Rimuovi ambulatorio");
        panel.add(removeAmb);
		removeAmb.addActionListener(contr);
        frame.setVisible(true);
        }
}