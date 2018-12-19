package view;
import java.awt.*;
import javax.swing.*;

import util.Enums;

public class AddMachForm extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new WelcomeFactory();
    private String type;
    private final Float font = 20.0f;
   
    public AddMachForm() {
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
        
        JLabel labelType = fac.createLabelRight("Tipo Macchinario: ", font);
        canvas.add(labelType);
        JComboBox<String> textType = fac.createCombo(Enums.Sesso.getValoriSesso());
        canvas2.add(textType);

        JButton confirm = fac.createButton("Salva");
        confirm.addActionListener(a -> {
        	type = textType.getSelectedItem().toString();;
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}
