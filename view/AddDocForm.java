package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Enums;

/**
 *  Class to add a doctor to the hospital.
 */
public class AddDocForm extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private String name, surname, codFis, sex, spec;
    private int age;
    private final float font = 20.0f;
    /**
     * 
     */
    public AddDocForm() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(width / 3, height / 3);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Aggiungi dottore");
        frame.setResizable(false);

        //Panels
        JPanel canvas = fac.createBoxPanel();
        frame.add(canvas, BorderLayout.WEST);
        JPanel canvas2 = fac.createBoxPanel();
        frame.add(canvas2, BorderLayout.CENTER);
        JPanel canvas3 = fac.createFlowPanel();
        frame.add(canvas3,  BorderLayout.EAST);

        //Labels and textfields
        JLabel labelName = fac.createLabelRight("Nome: ", font);
        canvas.add(labelName);
        JTextField textName = fac.createTextField();
        canvas2.add(textName);

        JLabel labelSurname = fac.createLabelRight("Cognome: ", font);
        canvas.add(labelSurname);
        JTextField textSurname = fac.createTextField();
        canvas2.add(textSurname);

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

        JLabel labelSpec = fac.createLabelRight("Ruolo: ", font);
        canvas.add(labelSpec);
        JComboBox<String> textSpec = fac.createCombo(Enums.Ruolo.getValoriRuolo());
        canvas2.add(textSpec);

        //confirm button
        JButton confirm = fac.createButton("Salva");
        confirm.addActionListener(a -> {
            try {
                name = textName.getText();
                surname = textSurname.getText();
                codFis = textCodFis.getText();
                sex = textSex.getSelectedItem().toString();
                age = Integer.parseInt(textAge.getText());
                spec = textSpec.getSelectedItem().toString();
                // DA FARE! Welcome.(name, surname, codFis, sex, age, spec);
                JOptionPane.showMessageDialog(frame, "Elemento aggiunto correttamente");
                frame.dispose();
                // DA FARE! MainGUI.refreshDoctors();
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
