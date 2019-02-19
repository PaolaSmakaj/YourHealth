package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDoc implements ActionListener {
	
	WelcomeDoc weldoc;
	
	public ControllerDoc(WelcomeDoc weldoc) throws Exception {
		this.weldoc = weldoc;
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
