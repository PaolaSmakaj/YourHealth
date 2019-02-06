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

import util.Enums;

public class AddAmbForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private String type;
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
        
        JLabel labelType = fac.createLabelRight("Tipo ambulatorio: ", font);
        canvas.add(labelType);
        JComboBox<String> textType = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textType);

        JButton confirm = new JButton("Salva");
        confirm.setFont(new Font("Calibri", Font.PLAIN,18));
        confirm.setBackground(Color.darkGray);
        confirm.setForeground(Color.white);
        confirm.addActionListener(a -> {
        	type = textType.getSelectedItem().toString();;
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}

