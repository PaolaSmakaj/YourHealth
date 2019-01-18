package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPatient implements ActionListener {
	
	WelcomePatient welpatient;
	
	public ControllerPatient(WelcomePatient welpatient) throws Exception {
		this.welpatient = welpatient;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Lista prestazioni")){
			}
		else if (ae.getActionCommand().equals("Aggiungi prestazione")){
			AddPerformanceForm apef = new AddPerformanceForm();
			apef.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Rimuovi prestazione")){
			RemovePerformanceForm rpef = new RemovePerformanceForm();
			rpef.setVisible(true);
			}
		else if (ae.getActionCommand().equals("Profilo")){
	  }
		
	}
}
