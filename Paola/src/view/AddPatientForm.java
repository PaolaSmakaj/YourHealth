package view;
import java.awt.*;
import javax.swing.*;

import util.Enums;

public class AddPatientForm extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new WelcomeFactory();
    private String name, surname, codFis, sex;
    private int age;
    private final Float font = 20.0f;
   
    public AddPatientForm() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(width / 3, height / 3);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Insert patient info");
        frame.setResizable(false);

        JPanel canvas = fac.createBoxPanel();
        frame.add(canvas, BorderLayout.WEST);
        JPanel canvas2 = fac.createBoxPanel();
        frame.add(canvas2, BorderLayout.CENTER);
        JPanel canvas3 = fac.createFlowPanel();
        frame.add(canvas3,  BorderLayout.EAST);

        JLabel labelName = fac.createLabelRight("Nome: ", font);
        canvas.add(labelName);
        JTextField textName = fac.createTextField();
        canvas2.add(textName);

        JLabel labelSurname = fac.createLabelRight("Cognome: ", font);
        canvas.add(labelSurname);
        JTextField textSurname = fac.createTextField();
        canvas2.add(textSurname);

        JLabel labelCodFis = fac.createLabelRight("Codice Fiscale: ", font);
        canvas.add(labelCodFis);
        JTextField textCodFis = fac.createTextField();
        canvas2.add(textCodFis);

        JLabel labelAge = fac.createLabelRight("Et�: ", font);
        canvas.add(labelAge);
        JTextField textAge = fac.createTextField();
        canvas2.add(textAge);

        JLabel labelSex = fac.createLabelRight("Sesso: ", font);
        canvas.add(labelSex);
        JComboBox<String> textSex = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textSex);

        JButton confirm = fac.createButton("Salva");
        confirm.addActionListener(a -> {
            try {
                name = textName.getText();
                surname = textSurname.getText();
                codFis = textCodFis.getText();
                sex = textSex.getSelectedItem().toString();
                age = Integer.parseInt(textAge.getText());
    
                //MainGUI.createPatient(name, surname, codFis, sex, disease, age, priority);
                JOptionPane.showMessageDialog(frame, "Elemento aggiunto correttamente");
                frame.dispose();
                //MainGUI.refreshWaiting();
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Et� non valida");
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
