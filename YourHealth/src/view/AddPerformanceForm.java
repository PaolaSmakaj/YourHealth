package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Admin;
import model.Prestazione;
import model.PrestazioneImpl;
import util.Enums;
import util.Enums.Stato;
import util.Enums.TipoPrestazione;

public class AddPerformanceForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2970713926117414003L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private String codFis, Mach, Amb;
    private TipoPrestazione tipo;
    private Stato stato;
    private int tesserinoDottore;
	private LocalDate data;
	private LocalTime ora;
    private final Float font = 20.0f;
   
    public AddPerformanceForm() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(width / 3, height / 3);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Aggiungi prestazione");
        frame.setResizable(false);

        JPanel canvas = fac.createBoxPanel();
        frame.add(canvas, BorderLayout.WEST);
        JPanel canvas2 = fac.createBoxPanel();
        frame.add(canvas2, BorderLayout.CENTER);
        JPanel canvas3 = fac.createFlowPanel();
        frame.add(canvas3,  BorderLayout.EAST);

        JLabel labelCodFis = fac.createLabelRight("Codice fiscale: ", font);
        canvas.add(labelCodFis);
        JTextField textCodFis = fac.createTextField();
        canvas2.add(textCodFis);

        JLabel labelDoc = fac.createLabelRight("Tesserino dottore: ", font);
        canvas.add(labelDoc);
        JTextField textDoc = fac.createTextField();
        canvas2.add(textDoc);
        
        JLabel labelType = fac.createLabelRight("Tipo Prestazione: ", font);
		canvas.add(labelType);
		JComboBox<String> textType = fac.createCombo(Enums.TipoPrestazione.getValoriPrestazioni());
		canvas2.add(textType);
		
		/*
		JLabel labelStatus = fac.createLabelRight("Stato Prestazione: ", font);
		canvas.add(labelStatus);
		JComboBox<String> textStatus = fac.createCombo(Enums.Stato.getValoriStato());
		canvas2.add(textStatus);
		*/
		
		JLabel labelDate = fac.createLabelRight("Data Prestazione: ", font);
		canvas.add(labelDate);
		JTextField textDate = fac.createTextField();
		canvas2.add(textDate);
		
		JLabel labelTime = fac.createLabelRight("Ora Prestazione: ", font);
		canvas.add(labelTime);
		JTextField textTime = fac.createTextField();
		canvas2.add(textTime);
        
        JLabel labelMach = fac.createLabelRight("Macchinario: ", font);
        canvas.add(labelMach);
        JTextField textMach = fac.createTextField();
        canvas2.add(textMach);
        
        JLabel labelAmb = fac.createLabelRight("Ambulatorio: ", font);
        canvas.add(labelAmb);
        JTextField textAmb = fac.createTextField();
        canvas2.add(textAmb);

        JButton confirm = new JButton("Salva");
        confirm.setFont(new Font("Calibri", Font.PLAIN,18));
        confirm.setBackground(Color.darkGray);
        confirm.setForeground(Color.white);
        confirm.addActionListener(a -> {
            try {
            	
                codFis = textCodFis.getText();
                tesserinoDottore = Integer.parseInt(textDoc.getText());
                tipo =  Enums.TipoPrestazione.getFromString(textType.getSelectedItem().toString());
                stato = Enums.Stato.PRENOTATA;
                data = LocalDate.parse(textDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                ora = LocalTime.parse(textTime.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                Mach = textMach.getText();
                Amb = textAmb.getText();
    
                JOptionPane.showMessageDialog(frame, "Prestazione aggiunta correttamente");
                frame.dispose();
                Prestazione P = new PrestazioneImpl(codFis, tesserinoDottore, tipo,
                		data, ora, stato, Mach, Amb);
                Admin.addPrestazione(P);
               
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Età non valida");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            } catch (IllegalStateException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            } catch(Exception e) {
				e.printStackTrace();
			}
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}
