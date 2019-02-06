package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Enums;

public class AddPerformanceForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private String patName, patSurname, codFis, sex, docName, docSurname, spec, typeMach, typeAmb;
    private int age;
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

        JLabel labelPatName = fac.createLabelRight("Nome paziente: ", font);
        canvas.add(labelPatName);
        JTextField textPatName = fac.createTextField();
        canvas2.add(textPatName);

        JLabel labelPatSurname = fac.createLabelRight("Cognome paziente: ", font);
        canvas.add(labelPatSurname);
        JTextField textPatSurname = fac.createTextField();
        canvas2.add(textPatSurname);

        JLabel labelCodFis = fac.createLabelRight("Codice fiscale: ", font);
        canvas.add(labelCodFis);
        JTextField textCodFis = fac.createTextField();
        canvas2.add(textCodFis);

        JLabel labelAge = fac.createLabelRight("Età: ", font);
        canvas.add(labelAge);
        JTextField textAge = fac.createTextField();
        canvas2.add(textAge);

        JLabel labelSex = fac.createLabelRight("Sesso: ", font);
        canvas.add(labelSex);
        JComboBox<String> textSex = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textSex);
        
        JLabel labelDocName = fac.createLabelRight("Nome dottore: ", font);
        canvas.add(labelDocName);
        JTextField textDocName = fac.createTextField();
        canvas2.add(textDocName);

        JLabel labelDocSurname = fac.createLabelRight("Cognome dottore: ", font);
        canvas.add(labelDocSurname);
        JTextField textDocSurname = fac.createTextField();
        canvas2.add(textDocSurname);
        
        JLabel labelSpec = fac.createLabelRight("Ruolo: ", font);
        canvas.add(labelSpec);
        JComboBox<String> textSpec = fac.createCombo(Enums.Ruolo.getValoriRuolo());
        canvas2.add(textSpec);
        
        JLabel labelTypeMach = fac.createLabelRight("Tipo macchinario: ", font);
        canvas.add(labelTypeMach);
        JComboBox<String> textTypeMach = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textTypeMach);
        
        JLabel labelTypeAmb = fac.createLabelRight("Tipo ambulatorio: ", font);
        canvas.add(labelTypeAmb);
        JComboBox<String> textTypeAmb = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textTypeAmb);

        JButton confirm = new JButton("Salva");
        confirm.setFont(new Font("Calibri", Font.PLAIN,18));
        confirm.setBackground(Color.darkGray);
        confirm.setForeground(Color.white);
        confirm.addActionListener(a -> {
            try {
                patName = textPatName.getText();
                patSurname = textPatSurname.getText();
                codFis = textCodFis.getText();
                sex = textSex.getSelectedItem().toString();
                age = Integer.parseInt(textAge.getText());
                docName = textDocName.getText();
                docSurname = textDocSurname.getText();
                spec = textSpec.getSelectedItem().toString();
                typeMach = textTypeMach.getSelectedItem().toString();
                typeAmb = textTypeMach.getSelectedItem().toString();
    
                JOptionPane.showMessageDialog(frame, "Prestazione aggiunta correttamente");
                frame.dispose();
               
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Età non valida");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            } catch (IllegalStateException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}
