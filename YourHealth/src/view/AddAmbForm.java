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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Clinica;
import model.Ambulatorio;
import model.AmbulatorioImpl;
import util.Enums;
import util.Enums.TipoAmbulatorio;

public class AddAmbForm extends JFrame {
	private static final long serialVersionUID = -5890537905190128886L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private TipoAmbulatorio type;
    private String id;
    private final Float font = 20.0f;
   
    public AddAmbForm() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(width / 3, height / 3);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Aggiungi ambulatorio");
        frame.setResizable(false);

        JPanel canvas = fac.createBoxPanel();
        frame.add(canvas, BorderLayout.WEST);
        JPanel canvas2 = fac.createBoxPanel();
        frame.add(canvas2, BorderLayout.CENTER);
        JPanel canvas3 = fac.createFlowPanel();
        frame.add(canvas3,  BorderLayout.EAST);
        
        JLabel labelId = fac.createLabelRight("Codice: ", font);
        canvas.add(labelId);
        JTextField textId = fac.createTextField();
        canvas2.add(textId);
        
        JLabel labelType = fac.createLabelRight("Tipo Ambulatorio: ", font);
        canvas.add(labelType);
        JComboBox<String> textType = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textType);

        JButton confirm = new JButton("Salva");
        confirm.setFont(new Font("Calibri", Font.PLAIN,18));
        confirm.setBackground(Color.darkGray);
        confirm.setForeground(Color.white);
        confirm.addActionListener(a -> {
        	type = Enums.TipoAmbulatorio.getFromString(textType.getSelectedItem().toString());
        	id = textId.getText();
        	
        	Ambulatorio A = new AmbulatorioImpl(id, type);
        	try {
				Clinica.addAmbulatorio(A);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}

