package Inicial;

import java.util.Scanner;

import Codificacion.Codificacion;
import Vista.PantallaJuego;

public class Inicial {
	private static Scanner scanner;

	public static void main(String arg[]){
		Codificacion c=new Codificacion();
		scanner = new Scanner(System.in);
		System.out.println("Entrada de datos: ");
		c.recepcion(scanner.nextLine());
		c.generarArbol();
		c.valorComprimido=0;
		System.out.println("Arbol de dependencias");
		c.pintarArbol(2, "", c.arbol.cabeza);
		System.out.println();
		System.out.println("Valor inicial de bits: "+c.valorInicial);
		System.out.println("Valor comprimido de bits: "+c.valorComprimido);
		double t=100*(c.valorComprimido/c.valorInicial);
		
		System.out.print("Codificado: ");
		System.out.printf("%.3f", t);
		System.out.print("%");
		System.out.println();
		System.out.print("Ahorro: ");
		System.out.printf("%.3f", (100-t));
		System.out.print("%");
		new PantallaJuego(c.arbol.cabeza);
	}
}