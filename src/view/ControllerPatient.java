package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPatient implements ActionListener {
	
	WelcomePatient welpatient;
	
	public ControllerPatient(WelcomePatient welpatient) throws Exception {
		this.welpatient = welpatient;
	}
	
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "Lista prestazioni":
			break;
		case "Profilo":
			break;
			
		}
	}
}
