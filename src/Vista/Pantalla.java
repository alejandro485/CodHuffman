package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Codificacion.Nodo;

public class Pantalla extends JFrame {

	private static final long serialVersionUID = 1L;
	private CanvasArbol canvas;
	private JPanel contentPane;

	public Pantalla(Nodo c) {
		this.setSize(780,780);
		this.setVisible(true);
		this.setFocusable(true);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		canvas=new CanvasArbol(c);
		canvas.setLocation(20, 20);
		contentPane.add(canvas);
	}
	
}
