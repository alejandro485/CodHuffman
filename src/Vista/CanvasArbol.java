package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Codificacion.Nodo;

public class CanvasArbol extends Canvas {

	private static final long serialVersionUID = 1L;

	private Nodo cabeza;
	private Image imagen;
	private Graphics graficas;
	
	public CanvasArbol(Nodo c) {
		// TODO Auto-generated constructor stub
		cabeza=c;
		this.setSize(700, 700);
		this.setVisible(true);
	}
	
	private void pintarNodo(Nodo c, int pox, int poy, int anx, int any,int dif){
		graficas.setColor(Color.black);
		graficas.drawLine(anx, any+10, pox, poy);
		graficas.setColor(Color.white);
		graficas.fillOval(pox-10,poy-10, 20, 20);
		graficas.setColor(Color.black);
		graficas.drawString(c.contenido, pox-3, poy+2);
		if(c.nodoDerecho!=null){
			pintarNodo(c.nodoDerecho,pox+dif/2, poy+100, pox, poy, dif/2);
		}
		if(c.nodoIzquierdo!=null){
			pintarNodo(c.nodoIzquierdo,pox-dif/2, poy+100, pox, poy, dif/2);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		imagen=createImage(700,700);
		graficas=imagen.getGraphics();
		graficas.setColor(Color.orange);
		graficas.fillRect(0, 0, 700,700);
		pintarNodo(cabeza, 350, 20, 350, 20, 350);
		g.drawImage(imagen, 0, 0, this);
	}
	
}
