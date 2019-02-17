package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	
	Welcome wel;
	
	public Controller(Welcome wel) throws Exception {
		this.wel = wel;
	}
	
	public void actionPerformed(ActionEvent ae) {
		switch (ae.getActionCommand()) {
		case "Lista prestazioni":
			new Performances();
			break;
		case "Aggiungi prestazione":
			new AddPerformanceForm();
			break;
		case "Rimuovi prestazione":
			new RemovePerformanceForm();
		case "Aggiungi paziente":
			new AddPatientForm();
			break;
		case "Rimuovi paziente":
			new RemovePatientForm();
			break;
		case "Aggiungi dottore":
			new AddDocForm();
			break;
		case "Rimuovi dottore":
			new RemoveDocForm();
			break;
		case "Aggiungi macchinario":
			new AddMachForm();
			break;
		case "Rimuovi macchinario":
			new RemoveMachForm();
			break;
		case "Aggiungi ambulatorio":
			new AddAmbForm();
			break;
		}
	}
}
	
		//else if(ae.getActionCommand().equals("Rimuovi prestazione")){
		    //int response = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare questo elemento?", "Conferma",
		        //JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    //if (response == JOptionPane.NO_OPTION) {
		      //System.out.println("No button clicked");
		    //} else if (response == JOptionPane.YES_OPTION) {
		      //System.out.println("Yes button clicked");
		    //} else if (response == JOptionPane.CLOSED_OPTION) {
		      //System.out.println("JOptionPane closed");
		    //}
		  //}
		//}
	//}
