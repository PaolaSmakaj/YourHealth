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
			Performances pe = new Performances();
			pe.setVisible(true);
			break;
		case "Aggiungi prestazione":
			AddPerformanceForm apef = new AddPerformanceForm();
			apef.setVisible(true);
			break;
		case "Rimuovi prestazione":
			RemovePerformanceForm rpef = new RemovePerformanceForm();
			rpef.setVisible(true);
		case "Aggiungi paziente":
			AddPatientForm apaf = new AddPatientForm();
			apaf.setVisible(true);
			break;
		case "Rimuovi paziente":
			RemovePatientForm rpaf = new RemovePatientForm();
			rpaf.setVisible(true);
			break;
		case "Aggiungi dottore":
			AddDocForm adf = new AddDocForm();
			adf.setVisible(true);
			break;
		case "Rimuovi dottore":
			RemoveDocForm rdf = new RemoveDocForm();
			rdf.setVisible(true);
			break;
		case "Aggiungi macchinario":
			AddMachForm amf = new AddMachForm();
			amf.setVisible(true);
			break;
		case "Rimuovi macchinario":
			RemoveMachForm rmf = new RemoveMachForm();
			rmf.setVisible(true);
			break;
		case "Aggiungi ambulatorio":
			AddAmbForm aaf = new AddAmbForm();
			aaf.setVisible(true);
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

