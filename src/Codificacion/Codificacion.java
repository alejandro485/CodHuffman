package Codificacion;
import org.apache.commons.lang3.StringUtils;


public class Codificacion {
	String entrada;
	String entradaOriginal;
	int[][] matrizCodificacion;
	public Arbol arbol;
	
	public void recepcion(String ent){
		entradaOriginal=ent;
		entrada=ent;
		//variables para la frecuencia de los caracteres
		String str=null;
		int contador=0;
		int rec=0;
		
		//variables para la busqueda de los numero para la conformacion del arbol
		int numB=1;
		int numE1=-1;
		int numE2=-1;
		int ubicacionActual;
		
		//validacion de continuacion de busqueda
		boolean validacionContinuacion;
		int numEV;
		
		matrizCodificacion=new int[4][52];//inicializacion de la matriz
		for(int i=0; i<4; i++){
			for(int j=0; j<52; j++){
				matrizCodificacion[i][j]=-1;
			}
		}
		//recoleccion de frecuencia
		while(contador<26){
			str=Character.toString((char)(97+contador));
			System.out.println("Caracter actual: "+str);
			rec=StringUtils.countMatches(entrada,str );
			matrizCodificacion[0][contador]=rec;
			entrada.replaceAll(str, "");
			contador++;
		}

		do{
			//recoleccion de la pareja de numeros menores
			ubicacionActual=0;
			while(matrizCodificacion[0][ubicacionActual]>-1){
				if(matrizCodificacion[0][ubicacionActual]==numB && matrizCodificacion[1][ubicacionActual]==-1){
					if(numE1==-1){
						numE1=ubicacionActual;
					}
					else{
						numE2=ubicacionActual;
						break;
					}
				}
				ubicacionActual++;
			}
			if(matrizCodificacion[0][ubicacionActual]==-1){
				numB++;
			}
			else{
				for(int i=0;i<52;i++){//creacion de la cajetilla para el arbol
					if(matrizCodificacion[0][i]==-1){
						matrizCodificacion[0][i]=(matrizCodificacion[0][numE1]+ matrizCodificacion[0][numE2]);
						matrizCodificacion[2][i]=numE1;
						matrizCodificacion[3][i]=numE2;
						matrizCodificacion[1][numE1]=i;
						matrizCodificacion[1][numE2]=i;
						ubicacionActual=i;
						numE2=-1;
						numE1=-1;
						System.out.println("Asignacion de campo con hijos en :"+i);
						break;
					}
				}
			}
			//validacion de consecucion de proceso
			validacionContinuacion=true;
			numEV=0;
			for(int i=ubicacionActual;i>-1;i--){
				if(matrizCodificacion[1][i]==-1 && matrizCodificacion[0][i]>0){
					numEV++;
				}
			}
			if(numEV==1){
				validacionContinuacion=false;
			}
		}while(validacionContinuacion);
		System.out.println("finalizacion de busqueda");
		// pintar matriz
		for(int i=0;i<4;i++){
			for(int j=0;j<52;j++){
				if(matrizCodificacion[i][j]==-1){
					System.out.print("  |");
				}
				else if(matrizCodificacion[i][j]>9){
					System.out.print(matrizCodificacion[i][j]+"|");
				}else{
					System.out.print(matrizCodificacion[i][j]+" |");
				}
			}
			System.out.println();
		}
	}
	
	public void generarArbol(){
		int j;
		for(j=51;j>=0;j--){
			if(matrizCodificacion[0][j]>0){
				break;
			}
		}
		arbol=new Arbol();
		arbol.cabeza=generarNodo(j);
	}
	
	private Nodo generarNodo(int cabeza){
		if(cabeza<0){
			return null;
		}
		else{
			Nodo nodo;
			if(cabeza<26){
				nodo=new Nodo(Character.toString((char)(97+cabeza)));
			}
			else{
				nodo=new Nodo(matrizCodificacion[0][cabeza]+"");
				nodo.nodoDerecho=generarNodo(matrizCodificacion[3][cabeza]);
				nodo.nodoIzquierdo=generarNodo(matrizCodificacion[2][cabeza]);
			}
			return nodo;
		}
	}
	
	public void pintarArbol(int espacios, String cod, Nodo n){
		String esp="";
		for(int i=0; i<espacios;i++){
			esp+=" ";
		}
		System.out.print(esp+"|-"+n.contenido);
		if(n.nodoDerecho==null && n.nodoIzquierdo==null){
			System.out.print(" - cod: "+cod);
		}
		else{
			if(n.nodoIzquierdo!=null){
				System.out.println();
				pintarArbol(espacios+2, cod+"0", n.nodoIzquierdo);
			}
			if(n.nodoDerecho!=null){
				System.out.println();
				pintarArbol(espacios+2, cod+"1", n.nodoDerecho);
			}
		}
	}
	
}
