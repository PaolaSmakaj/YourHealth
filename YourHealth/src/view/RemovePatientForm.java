package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Admin;

public class RemovePatientForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1267953887222906002L;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int) screenSize.getWidth();
    private int height = (int) screenSize.getHeight();
    private GUI fac = new GUIFactory();
    private String codicefiscale;
    private final float font = 20.0f;
    
    
    public RemovePatientForm() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(width / 3, height / 3);
        frame.setLocationByPlatform(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Rimuovi Paziente");
        frame.setResizable(false);
        
        
      //Panels
        JPanel canvas = fac.createBoxPanel();
        frame.add(canvas, BorderLayout.WEST);
        JPanel canvas2 = fac.createBoxPanel();
        frame.add(canvas2, BorderLayout.CENTER);
        JPanel canvas3 = fac.createFlowPanel();
        frame.add(canvas3,  BorderLayout.EAST);
        
        JLabel labelCF = fac.createLabelRight("Codice Fiscale: ", font);
        canvas.add(labelCF);
        JTextField textCF = fac.createTextField();
        canvas2.add(textCF);
        
        JButton confirm = new JButton("Rimuovi");
        confirm.setFont(new Font("Calibri", Font.PLAIN,18));
        confirm.setBackground(Color.darkGray);
        confirm.setForeground(Color.white);
        confirm.addActionListener(a -> {
        	
        	codicefiscale = textCF.getText();
        	try {
				Admin.removePaziente(codicefiscale);
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	JOptionPane.showMessageDialog(frame, "Elemento rimosso correttamente");
            frame.dispose();
        });
        canvas3.add(confirm);
        frame.setVisible(true);
        frame.pack();
    }
}