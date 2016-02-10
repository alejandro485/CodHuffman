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
		c.valorComprimido=0;
		System.out.println("Arbol de dependencias");
		c.pintarArbol(2, "", c.arbol.cabeza);
		System.out.println();
		System.out.println("Valor inicial de bits: "+c.valorInicial);
		System.out.println("Valor comprimido de bits: "+c.valorComprimido);
		System.out.println("Codificado: "+(c.valorComprimido*100/c.valorInicial)+"%");
	}
}