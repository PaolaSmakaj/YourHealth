package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Controller implements ActionListener {
	
	Welcome wel;
	
	public Controller(Welcome wel) throws Exception {
		this.wel = wel;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Lista prestazioni")){
			Performances pe = new Performances();
			pe.setVisible(true);
			}
		else if (ae.getActionCommand().equals("Aggiungi prestazione")){
			AddPerformanceForm apef = new AddPerformanceForm();
			apef.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Rimuovi prestazione")){
			RemovePerformanceForm rpef = new RemovePerformanceForm();
			rpef.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Aggiungi paziente")){
			AddPatientForm apaf = new AddPatientForm();
			apaf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Rimuovi paziente")){
			RemovePatientForm rpaf = new RemovePatientForm();
			rpaf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Aggiungi dottore")){
			AddDocForm adf = new AddDocForm();
			adf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Rimuovi dottore")){
			RemoveDocForm rdf = new RemoveDocForm();
			rdf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Aggiungi macchinario")){
			AddMachForm amf = new AddMachForm();
			amf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Rimuovi macchinario")){
			RemoveMachForm rmf = new RemoveMachForm();
			rmf.setVisible(true);
			}
		else if(ae.getActionCommand().equals("Aggiungi macchinario")){
			
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

