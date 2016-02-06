package Inicial;

import java.util.Scanner;

import Codificacion.Codificacion;

public class Inicial {
	private static Scanner scanner;

	public static void main(String arg[]){
		Codificacion c=new Codificacion();
		scanner = new Scanner(System.in);
		System.out.println("Entrada de datos: ");
		c.recepcion(scanner.nextLine());
		c.generarArbol();
		System.out.println("Arbol de dependencias");
		c.pintarArbol(2, "", c.arbol.cabeza);
	}
}