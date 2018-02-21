package gandalf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import java.util.StringTokenizer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Gandalf {
	
//	poner contenido en columna en un boxLayout
//	contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
//	modificar tamaño textField.setColumns(10);
//	textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
//	textField.setPreferredSize(new Dimension(1, 20));
//	textField.setMinimumSize(new Dimension(1, 20));
//	btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
//	btnNewButton_5.setPreferredSize(new Dimension(400, 23));
//	btnNewButton_5.setSize(new Dimension(400, 23));
//	btnNewButton_5.setBackground(Color.MAGENTA);
//	btnNewButton_5.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//		}
//	});
//	btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
//	btnNewButton_5.setForeground(Color.RED);
//	contentPane.add(btnNewButton_5);
//	contentPane.add(textField, BorderLayout.CENTER);
//	contentPane.add(panel, BorderLayout.NORTH);
//	panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//	contentPane.add(panel_1, BorderLayout.SOUTH);

	
	/**
	 * calcular area circulo
	 * @param radio
	 * @return float area
	 */
	public float calcularAreaCirculo(float radio) {
		return 2*3.1316f*(radio*radio);
	}
	
	/**
	 * comprueba si dos palabras aparecen en cadena
	 * si estan seguidas devuelve int 1 
	 * si estan las dos pero no consecutivas devuelve int 0
	 * si no estan devuelve int -1
	 * @param palabraUno
	 * @param palabraDos
	 * @param cadena
	 * @return int 1 consecutivas // 0 si las dos pero no consecutivas // -1 si no esta alguna de las dos
	 */
	public int comprobarSiHayDosPalabrasSeparadasYSeguidas(
			String palabraUno,String palabraDos,String cadena){
				String palabrasSeguidas=palabraUno+" "+	palabraDos;
		if (cadena.contains(palabraUno)&&cadena.contains(palabraDos)) {
			if(cadena.contains(palabrasSeguidas))return 1;
			else return 0;
		}
		return -1;
		}
	
	/**
	 * cuenta las veces que se repite un digito en una cifra
	 * @param numero entero en el que se quiere buscar
	 * @param numeroBuscado numero entero que se quiere encontrar
	 * @return int numero de veces que se repite
	 */
	public int contarNumeros(int numero,int numeroBuscado) {
		int numeroDeVeces=0;
		String cadena = String.valueOf(numero);
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i)==String.valueOf(numeroBuscado).charAt(0)) {
				numeroDeVeces++;
			}
		}
		return numeroDeVeces;
	}
	
	/**
	 * reemplaza todas las expresiones que esten en el String [][] traducciones
	 * @param cadena
	 * @return String modificada
	 */
	public String lenguajeSMS(String cadena) {
		String [][] traducciones= {{"por que","xq"},{"por","x"},{"tambien","tb"},
				{"pero","xo"},{"vente","20"},{"te apetece","taptc"},{"muy gracioso","LOL"}};
		for (int i = 0; i < traducciones.length; i++) {
			cadena=cadena.replaceAll(traducciones[i][0], traducciones[i][1]);
		}
		return cadena;
	}
	
	/**
	 * modifica terminaciones
	 * @param terminacion a buscar
	 * @param reemplazo a insertar
	 * @param cadena 
	 * @return String con terminaciones modificadas
	 */
	public String modificarPalabrasTerminadasEn(String terminacion,String reemplazo,String cadena) {
		String cadenaModificada="";
		String palabras []= cadena.split(" ");
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length()>terminacion.length() &&
					palabras[i].substring(palabras[i].length()-terminacion.length()).compareTo(terminacion)==0) {
				palabras[i]=palabras[i].replace(palabras[i].substring(palabras[i].length()-terminacion.length(), palabras[i].length()), reemplazo);
			}
			cadenaModificada+=palabras[i]+" ";
		}
		return cadenaModificada;
	}
	
	/**
	 * muestra solo las palabras cuya longitud coincida con el parametro int tamaño
	 * @param tamaño longitud de las palabras a seleccionar
	 * @param cadena
	 * @return String con las palabras con .length = tamaño + " " un espacio en blanco
	 */
	public String mostrarPalabrasConTamaño(int tamaño,String cadena) {
		String palabras [] = cadena.split(" ");
		String nuevaCadena="";
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length()==tamaño) {
				nuevaCadena+=palabras[i]+" ";
			}
		}
		return nuevaCadena;
	}
	
	/**
	 * hace que todas las vocales sean la introducida por parametro letra
	 * @param cadena que se quiere modificar
	 * @param letra vocal que se quiere introducir en todas las palabras
	 * @return String cadena con las vocales iguales
	 */
	public String vocalesIguales(String cadena,char letra) {
		Character vocales []= {'a','e','i','o','u'};
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < vocales.length; j++) {
				if(cadena.charAt(i)==vocales[j]||
						cadena.charAt(i)==Character.toUpperCase(vocales[j])) {
					cadena=cadena.replace(cadena.charAt(i), letra);
				}
					
			}
		}
		return cadena;
	}
	
	/**
	 * cuenta las vocales de un string incluidas mayusculas
	 * @param cadena
	 * @return int numero de vocales
	 */
	public int contarVocales(String cadena) {
		int numeroVocales=0;
		Character vocales []= {'a','e','i','o','u'};
		for (int i = 0; i < cadena.length(); i++) {
			for (int j = 0; j < vocales.length; j++) {
				if(cadena.charAt(i)==vocales[j]||
					cadena.charAt(i)==Character.toUpperCase(vocales[j]))
					numeroVocales++;
			}
		}
		return numeroVocales;
	}
	
	/**
	 * rellena con asterisco todas las palabras incluidas en el vector de Strings palabrasCensuradas
	 * @param palabrasCensuradas String[] con las palabras que se quieren censurar
	 * @param cadena que se quiere censurar
	 * @return String censurado
	 */
	public String censurarPalabras(String [] palabrasCensuradas,String cadena) {
		String cadenas []= cadena.split(" ");
		for (int i = 0; i < cadenas.length; i++) {
			for (int j = 0; j < palabrasCensuradas.length; j++) {
				if(cadenas[i].compareTo(palabrasCensuradas[j])==0) {
					cadena=cadena.replaceAll(cadenas[i], generarStringAsteriscos(cadenas[i].length()));
				}
			}
		}
		return cadena;
	}
	/**
	 * genera un String con tantos asteriscos como el int longitud
	 * @param longitud numero de asteriscos del string
	 * @return String con tantos * como longitud
	 */
	private String generarStringAsteriscos(int longitud) {
		String cadena = "";
		for (int i = 0; i < longitud; i++) {
			cadena=cadena+="*";
		}
		return cadena;
	}
	
	/**
	 * Cuenta las palabras de un string usando tokenizer 
	 * @param cadena
	 * @return int numero de palabras
	 */
	public int contarPalabras (String cadena) {
		StringTokenizer tokens = new StringTokenizer(cadena, " ");
		//no se accede directamente a el
//		System.out.println(tokens.toString());
		//tokens contiene un grupo de strings separados donde coincida el token
		//porque usar esto y no el split
		//En principio porque nos permite ver nuestro primer iterator
		int numeroPalabras=0;
		while(tokens.hasMoreElements()){
			tokens.nextElement();
			numeroPalabras++;
		}
		return numeroPalabras;
	}
	
	/**
	 * Convierte a mayuscula  letra en un StringBuilder 
	 * @param cadena StringBuilder
	 * @param letra
	 * @return String modificada
	 */
	public String cabiarLetraAMayuscula(StringBuilder cadena, char letra) {
		String letraString=String.valueOf(letra);
	return cadena.toString().replaceAll(letraString, String.valueOf(letra).toUpperCase());
	}
	
	/**
	 * Elimina espacios del principio y final de un String
	 * @param cadena
	 * @return String sin espacios al principio y al final 
	 */
	public String stringSinEspacios(String cadena) {
		return cadena.trim();
	}
	
	/**
	 * corta el string desde la posicion indicada y obtiene un charSequence de 
	 * longitud determinada en longitud 
	 * @param cadena
	 * @param posicion
	 * @param longitud
	 * @return si longitud solicitada mayor que la cadena NULL // si longitud correcta un charSequence
	 */
	public CharSequence cortarStringPosicionLongitudSubSequence(String cadena,int posicion, int longitud) {
		if (cadena.length()<longitud)
		return cadena.subSequence(0, 20);
		else return null;
	}
	
	/**
	 * corta el string desde la posicion indicada y un string de 
	 * longitud determinada en longitud
	 * @param cadena
	 * @param posicion
	 * @param longitud
	 * @return si longitud solicitada mayor que la cadena NULL // si longitud correcta el string extraido
	 */
	public String cortarStringPosicionLongitud(String cadena,int posicion, int longitud) {
		if (cadena.length()<longitud)
		return cadena.substring(0, 20).toString();
		else return null;
	}
	
	
	/**
	 *  divide la cadena tantas veces como encuentre el string introducido
	 * como palabraCorte hasta un maximo de veces introducidas en numeroCortes
	 * 
	 * @param cadenaLarga cadena que se quiere cortar
	 * @param palabraCorte en que parte de la cadena se quiere cortar
	 * @param numeroCortes numero maximo de cortes que queremos obtener
	 * @return String[] de los cortes hechos a cadenaLarga en la ultima posicion del array todo el resto de la cadena
	 */
	public String [] cortaStringsConLimite(String cadenaLarga,String palabraCorte,int numeroCortes){
		return cadenaLarga.split(palabraCorte);
	}
	
	/**
	 * divide la cadena tantas veces como encuentre el string introdducido
	 * como palabraCorte
	 * @param cadenaLarga cadena que se quiere cortar
	 * @param palabraCorte en que parte de la cadena se quiere cortar
	 * @return String[] de los cortes hechos a cadenaLarga
	 */
	public String [] cortaStringsPor(String cadenaLarga,String palabraCorte){
		return cadenaLarga.split(palabraCorte);
	}
	
	/**
	 * sustituye en la cadena original ,todas las coincidencias de
	 *  "reemplazarEsto" por "agregarEsto"
	 * @param original
	 * @param reemplazarEsto
	 * @param agregarEsto
	 * @return cadena modificada
	 */
	public String reemplazarString(String original,String reemplazarEsto, String agregarEsto) {
		return original.replaceAll(reemplazarEsto, agregarEsto);
	}
	
	
	/**
	 * comprueba si una palabra se lee igual 
	 * de izquierda a derecha y de derecha a izquierda
	 * @param cadena
	 * @return true si es palindromo // false si no lo es
	 */
	public boolean buscaPalindromo(CharSequence cadena) {
		StringBuilder cadenaB = new StringBuilder(cadena);
		if (cadena.toString().equalsIgnoreCase(cadenaB.reverse().toString()))return true;
			else return false;
	}
	
	
	/**
	 * cuenta cuantas veces esta letra en cadena
	 * @param letra
	 * @param cadena
	 * @return numero de veces que aparece
	 */
	public int contarLetraEnString(char letra,String cadena){
		int contador=0;
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i)==letra)contador++;
		}
		return contador;
	}
	
	
	/**
	 * cuenta las masyusculas de un string 
	 * @author jckdaniel
	 * @param cadena
	 * @return numero de mayusculas
	 *
	 */
	public int contarMayusculas(String cadena) {
	int contador=0;
		for (int i = 0; i < cadena.length(); i++) {
			if(Character.isUpperCase(cadena.charAt(i)))contador++;
		}
		return contador;
	}
	
	
	
	/**
	 * cuenta las minusculas en un string 
	 * @param cadena
	 * @return numero de minusculas
	 */
	public int contarMinusculas(String cadena) {
		int contador=0;
		for (int i = 0; i < cadena.length(); i++) {
			if(Character.isLowerCase(cadena.charAt(i)))contador++;
		}
		return contador;
	}
	
	/**
	 * obtiene la posicion la ultima coincidencia
	 * de la letra buscada dentro del string principal 
	 * usando el metodo lastIndexOf
	 * @param letra que se quiere buscar
	 * @param cadena en la que se quiere buscar
	 * @return int -1 si no encontrado // si encontrado int posicion
	 */
	public int obtenUltimaPosicion(char letra,String cadena) {
		return cadena.lastIndexOf(letra);
	}
	
	
	/**
	 * obtiene la posicion del primer caracter de la ultima coincidencia
	 * del string buscado dentro del string principal 
	 * usando el metodo lastIndexOf
	 * @param cadenaBuscada 
	 * @param cadena en la que se quiere buscar
	 * @return int -1 si no encontrado // si encontrado int posicion
	 */
	public int obtenUltimaPosicion(String cadenaBuscada,String cadena) {
		return cadena.lastIndexOf(cadenaBuscada);
	}
	
	
	
	/**
	 * comprueba si la cadena esta vacia
	 * usando el metodo isEmpty
	 * @param cadena
	 * @return true o false
	 */
	public boolean compruebaVacia(String cadena) {
		return cadena.isEmpty();
	}
	
	
	
	/**
	 * Obtiene la posicion de la primera coincidencia de la letra buscada
	 * dentro de la cadena en la que se esta buscando
	 * usando el metodo indexOf
	 * @param cadena
	 * @param cadenaBuscada
	 * @return int posicion
	 */
	public int obtenPosicionDe(char letraBuscada,String cadena) {
		return cadena.indexOf(letraBuscada);
	}
	
	
	
	/**
	 * Obtiene la posicion de la primera coincidencia de la cadena buscada
	 * dentro de la cadena en la que se esta buscando
	 * usando el metodo indexOf
	 * @param cadena
	 * @param cadenaBuscada
	 * @return int posicion
	 */
	public int obtenPosicionDe(String cadena,String cadenaBuscada) {
		return cadena.indexOf(cadenaBuscada);
	}
	
	
	
	/**
	 * devuelve 0 si son iguales si no son iguales devuelve un numero resultado 
	 * de la resta de los primeros caracteres no coincidentes
	 * (distingue mayusculas)
	 * usando el metodo compareTo
	 * @param stringUno
	 * @param stringDos
	 * @return int 0 si iguales // otro numero si diferentes
	 */
	public int comparaString(String stringUno,String stringDos) {
		return stringUno.compareTo(stringDos);
	}
	
	
	
	
	/**
	 * devuelve 0 si son iguales si no son iguales devuelve un numero resultado 
	 * de la resta de los primeros caracteres no coincidentes
	 * (Ignora mayusculas)
	 * usando el metodo compareToIgnoreCase
	 * @param stringUno
	 * @param stringDos
	 * @return int 0 si iguales // otro numero si diferentes
	 */
	public int comparaStringIgnorandoMayus(String stringUno, String stringDos){
		return stringUno.compareToIgnoreCase(stringDos);
	}
	
	
	
	
	/**
	 * Une los dos String que se le pasen por parametro
	 * usando el metodo concat
	 * @param stringUno
	 * @param stringDos
	 * @return String resultado de los dos String
	 */
	public String concadenaString(String stringUno,String stringDos) {
		return stringUno.concat(stringDos);
	}
	
	
	
	/**
	 * comprueba si existe el string pasado como primer parametro 
	 * en el segundo string pasado por parametro
	 * usando el metodo contains
	 * @param buscada
	 * @param original
	 * @return true si existe// false si no 
	 */
	public boolean compruebaSiExiste(String buscada , String original) {
		return original.contains(buscada);
	}
	
	
	/**
	 * lee texto introducido por teclado, devuelve en un String
	 * @return String de lo leido por teclado
	 */
	public String leerString() {
		Scanner leerStringIpt= new Scanner(System.in);
		String string= leerStringIpt.nextLine();
		leerStringIpt.close();
		return string;
	}
	
	/**
	 * lee una frase introducida por teclado y la transforma a char array
	 * @return char [] de la frase leida
	 */
	public char[] leerStringDevuelveCharArray() {
		Scanner leer = new Scanner(System.in);
		char frase[]=leer.nextLine().toCharArray();
		leer.close();
		return frase;
	}
	
	/** lee numero
	 * @return numero leido
	 */
	public int leerNumeroIpt() {
		Scanner leerNumeroIpt= new Scanner(System.in);
		int numero = leerNumeroIpt.nextInt();
		leerNumeroIpt.close();
		return numero;
	}
	
	/**
	 * lee char
	 * @return char leido
	 */
	public char leerCharIpt() {
		Scanner leerCharIpt= new Scanner(System.in);
		char respuesta = leerCharIpt.nextLine().charAt(0);
		leerCharIpt.close();
		return respuesta;
	}
	
	/**
	 * crea un numero random 
	 * @param min numero minimo
	 * @param max numero maximo
	 * @return int aleatorio entre min y max
	 */
	public int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
	}
	
	/**
	 * genera un vector de int de numeros aleatorios entre min y max
	 * @param vector recive el vector que quiere rellenar
	 * @param min numero random minimo esperado
	 * @param max numero random maximo esperado
	 */
	public void generaVectorRandom(int[] vector, int min, int max) {
		int intervalo = max - (min - 1);
		for (int indice = 0; indice < vector.length; indice++) {
			vector[indice] = (int) (Math.random() * intervalo) + min;
		}
	}
	
	/**
	 * muestra vector en console java
	 * @param vector
	 */
	public void mostrarVector(int[] vector) {
		System.out.print("{");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.println(vector[vector.length - 1] + "}");
	}
	
	/**
	 * muestra vector en console java
	 * @param vector
	 */
	public void mostrarVector(char vector []) {
		System.out.print("{");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ",");
		}
		System.out.println(vector[vector.length - 1] + "}");
	}
	
	/**
	 * introduce un int en un vector lleno y aumenta la longitud del vector +1
	 * @param vector en el que se quiere introducir el numero
	 * @param elemento int que se quiere introducir
	 * @return int [] con elementos copiados, longitud +1, y el nuevo elemento en la ultima posicion
	 */
	public int [] introducirEnVectorLleno(int vector[],int elemento){
		int reserva[]=new int [vector.length+1];
		for (int i = 0; i < vector.length; i++) {
			reserva[i]=vector[i];
		}
		return reserva;
	}
	
	/**
	 * busca un numero entero en un vector de enteros
	 * @param vector
	 * @param numero
	 * @return true si el numero existe // false si no existe
	 */
	public boolean buscarNumeroEnVector(int[] vector, int numero) {
		boolean encontrado=false;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i]==numero) {
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	/**
	 * calcula la media de un vector de numeros enteros
	 * @param notas
	 * @return media aproximada error +- 0.5
	 */
	public int calcularMediaVector(int[] notas) {
		int suma=0;
		for (int i = 0; i < notas.length; i++) {
			suma+=notas[i];
		}
		return suma/notas.length;
	}
	
	
	/**
	 * rellena la matriz pasado como argumento del metodo con numeros
	 * aleatorios comprendidos entre min y max
	 * @param tablero matriz que se quiere rellenar
	 * @param min numero minimo esperado 
	 * @param max numero maximo esperado
	 */
	public void generarMatrizRandom(int[][] tablero,int min, int max) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=crearRandom(min, max);
			}
		}
	}
	
	/**
	 * muestra la matriz pasada como argumento del metodo
	 * por consola 
	 * @param tablero = matriz que se quiere mostrar
	 */
	public void mostrarMatriz(int[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * ordena la matriz pasada al metodo de menor a mayor
	 * @param matriz
	 */
	public void ordenarMatrizColumnas(int[][] matriz) {
		int vectorAuxiliar[]=new int [matriz[0].length];
		boolean ordenado;
		do {
			ordenado=true;
			for (int i = 0; i < matriz.length-1; i++) {
			if (matriz[i][0]>matriz[i+1][0]) {	
				for (int j = 0; j < vectorAuxiliar.length; j++) {
					vectorAuxiliar[j]=matriz[i][j];
					ordenado=false;
					matriz[i][j]=matriz[i+1][j];
					matriz[i+1][j]=vectorAuxiliar[j];
				}
			}
		}
		} while (!ordenado);
	}
	
	/**
	 * rellena de numeros aleatorios un int [][][] ;
	 * @param matrices
	 * @param min numero random minimo esperado
	 * @param max numero random maximo esperado
	 */
	public void rellenarMatrizTresDimensiones(int[][][] matrices,int min,int max) {
		for (int i = 0; i < matrices.length; i++) {
			for (int j = 0; j < matrices[i].length; j++) {
				for (int k = 0; k < matrices[i][j].length; k++) {
					matrices[i][j][k]=((int)(Math.random()*((max-min)+1)))+min;
				}
			}
		}
	}
	
	/**
	 * muestra array de 3 dimensiones por console
	 * @param matrices
	 */
	public void mostrarMatrizTresDimensiones(int[][][] matrices) {
		for (int i = 0; i < matrices.length; i++) {
			for (int j = 0; j < matrices[i].length; j++) {
				for (int k = 0; k < matrices[i][j].length; k++) {
					System.out.print(matrices[i][j][k]+"  ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	
	/**
	 * calcula la media de un array de 3 dimensiones de 
	 * numeros enteros margen de error +- 0.5
	 * @param notas
	 * @return int media
	 */
	public int calcularMediaMatrizTresDimensiones(int[][][] notas) {
		int suma = 0;
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				for (int j2 = 0; j2 < notas[i][j].length; j2++) {
					suma+=notas[i][j][j2];
				}
			}
		}
		return suma/(notas.length*notas[0].length*notas[0][0].length);
	}
	
	
	/**
	 * comprueba si un numero es primo
	 * @param numero 
	 * @return si es primo true // si no es primo false
	 */
	public boolean comprobarPrimo(int numero) {
		boolean primo=true;
		for (int i = numero-1; i >1; i--) {
			if (numero%i==0)primo=false;
		}
		return primo;
	}
	
	
	/**
	 * calcula el factorial de un numero
	 * @param numero que se quiere calcular
	 * @return factorial del numero calculado
	 */
	public int calcularFactorial(int numero) {
		int factorial=1;
		for (int i = 1; i <=numero; i++) {
			factorial*=i;
		}
		return factorial;
	}
	
	/**
	 * muestra por consola la tabla de multiplicar de un numero
	 * @param numero
	 */
	public void mostrarTablaMultiplicar(int numero) {
		for (int i = 0; i <= 10; i++) {
			System.out.println(numero+" * "+i+" = "+ (numero*i));
		}
	}
	
	
//	****************************************************************
//	CONJUGAR VERBOS
//	****************************************************************
	/**
	 * conjuga un verbo regular en presente pasado o futuro
	 * @param verbo
	 * @param tiempoVerbal //presente//pasado//futuro
	 * @return String verbo conjugado
	 */
	public String conjugarVerbos(String verbo,String tiempoVerbal) {
		
		switch (tiempoVerbal) {
		case "presente":
			verbo=conjugarPresente(verbo,tiempoVerbal);
			break;
		case "pasado":
			verbo=conjugarPasado(verbo,tiempoVerbal);
			break;
		case "futuro":
			verbo=conjugarFuturo(verbo,tiempoVerbal);
			break;
		}
		return verbo;
	}

	private String conjugarFuturo(String verbo, String tiempoVerbal) {
		String reemplazo [] = {"e","as","a","emos","eis","an"};
		String [] pronombre= {"Yo","Tu","El","Nosotros","Vosotros","Ellos"};
		StringBuilder conjugacion= new StringBuilder(0);
		for (int i = 0; i < reemplazo.length; i++) {
			conjugacion.append(pronombre[i]+" " +verbo+reemplazo[i]+"\n");
		}
		return conjugacion.toString().trim();
	}

	private String conjugarPasado(String verbo, String tiempoVerbal) {
		String[] reemplazo = null;
		String [] pronombre= {"Yo","Tu","El","Nosotros","Vosotros","Ellos"};
		String reemplazoAr [] = {"e","aste","o","amos","asteis","aron"};
		String reemplazoErIr [] = {"i","iste","io","imos","isteis","ieron"};
		if(verbo.charAt(verbo.length()-2)=='a') reemplazo = reemplazoAr;
		else if (verbo.charAt(verbo.length()-2)=='e'||verbo.charAt(verbo.length()-2)=='i')reemplazo=reemplazoErIr;
		StringBuilder conjugacion= new StringBuilder(0);
		for (int i = 0; i < reemplazo.length; i++) {
			conjugacion.append(pronombre[i]+" " +verbo.substring(0,verbo.length()-2)+reemplazo[i]+"\n");
		}
		return conjugacion.toString().trim();
	}

	private String conjugarPresente(String verbo, String tiempoVerbal) {
		String[] reemplazo = null;
		String [] pronombre= {"Yo","Tu","El","Nosotros","Vosotros","Ellos"};
		String reemplazoAr[] = {"o","as","a","amos","ais","an"};
		String reemplazoEr[] = {"o","es","e","emos","eis","en"};
		String reemplazoIr[] = {"o","es","e","imos","is","en"};
		switch (Character.toUpperCase(verbo.charAt(verbo.length()-2))) {
		case 'A':
			reemplazo = reemplazoAr;
			break;
		case 'E':
			reemplazo = reemplazoEr;
			break;	
		case 'I':
			reemplazo = reemplazoIr;
			break;
		}
		
		StringBuilder conjugacion= new StringBuilder(0);
		for (int i = 0; i < reemplazo.length; i++) {
			conjugacion.append(pronombre[i]+" " +verbo.substring(0,verbo.length()-2)+reemplazo[i]+"\n");
		}
		return conjugacion.toString().trim();
	}
	
//	**************************************************************
//	 	CHARLA
//	******************************************************************++
	/**
	 * Gandalf se charla
	 */
	public void charlar() {
		String [] conversaciones= {"Frodo No te entrometas en asuntos de magos, pues son astutos y de cólera fácil. ",
				"Se muchas cosas que solo los sabios saben",
				"Quien primero golpea, si golpea bastante fuerte, no tendrá que golpear de nuevo",
				"Un mago nunca llega tarde. Ni pronto, Frodo Bolsón. Llega justo cuando se lo propone.",
				"Guarda tu lengua bifida tras tus colmillos de serpiente venenosa.\n"
				+ " No he vencido al fuego y a la muerte\n"
				+ "para intercambiar falacias con un gusano sarnoso como tú.",
				"No todo el oro reluce, ni toda la gente errante anda perdida;\n"
				+ " a las raíces profundas no llega la escarcha;\n"
				+ " el viejo vigoroso no se marchita. ",
				"Corred insensatos.",
				"Sin duda, más que nunca, supongo.",
				"Aquel que quiebra algo para averiguar qué es,\n"
				+ " ha abandonado el camino de la sabiduría.",
				"Las explicaciones que necesitan los jóvenes son largas y fatigosas. ",
				"Aun las arañas más hábiles pueden dejar un hilo flojo. ",
				"Así ocurre a menudo con los hechos que mueven las ruedas del mundo;\n"
				+ " lo hacen pequeñas manos porque deben hacerlo.",
				"Las buenas historias merecen un buen final.",
				"Es sabiduría reconocer la necesidad,\n"
				+ " cuando todos los otros cursos ya han sido considerados,\n"
				+ " aunque pueda parecer locura a aquellos que se atan a falsas esperanzas.",
				"La esperanza no es la victoria. ",
				"Un traidor puede traicionarse a sí mismo y hacer involuntariamente un bien.",
				"Espera mi llegada con la primera luz del quinto día, al alba mira al este",
				"¡Corre Sombragris! ¡Muéstranos lo que es la premura!"
		};
		
		
		
//		String url = "imagenes/gandalf.gif";
//		ImageIcon imageIcon = new ImageIcon(url);
//		JLabel label = new JLabel(imageIcon);
//		label.setIcon(imageIcon);
		
		Icon icon = new ImageIcon("imagenes/gandalfDos.gif");
		JLabel label = new JLabel(icon);
		JFrame f = new JFrame("Animation");
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack(); f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.getBaselineResizeBehavior();
		

//		"Audios/gandalfCorta.wav"
		try {
			Clip sonido = AudioSystem.getClip();
			File a = new File("Audios/gandalfLarga.wav");
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
			}
			catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
			}
		
		for (int i = 0; i < conversaciones.length; i++) {
			System.out.println("GANDALF DICE:"+conversaciones[crearRandom(0, conversaciones.length-1)]);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String adivinarContraseña (String contraseña) {
//		//numero de caracteres 136900;
//		
//		RANGO 33 136900 total de caracteres UNICODE
//		 String contraseña = "\".($=";
		 boolean encontrado=false;
		 int numeroDigitos = 1;
		 for (int c = 33; c < 127 && !encontrado; c++) {
			for (int b = 33; b < 127 && !encontrado; b++) {
				for (int a = 33; a < 127 && !encontrado; a++) { 
					for (int i = 33; i < 127 && !encontrado; i++) {
						for (int j = 33; j < 127 && !encontrado; j++) {
							for (int k = 33; k < 127 && !encontrado ; k++) {
								String intento = "";
//					System.out.println(String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));

								if (numeroDigitos==1) {
									if (contraseña.compareTo(intento+=generarLetra(k))==0) {
										System.out.println("encontrado"+" "+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(k)); 

									}
								}
								if (numeroDigitos==2) {
									if (contraseña.compareTo(String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)); 

									}
								}
								if (numeroDigitos==3) {
									if (contraseña.compareTo(String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)); 

									}
								}
								if (numeroDigitos==4) {
									if (contraseña.compareTo(String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)); 

									}
								}
								if (numeroDigitos==5) {
									System.out.println(String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));
									if (contraseña.compareTo(String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)); 

									}
								}
								if (numeroDigitos==6) {
									System.out.println(String.valueOf(generarLetra(c))+String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));
									if (contraseña.compareTo(String.valueOf(generarLetra(c))+String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
										return String.valueOf(generarLetra(c))+String.valueOf(generarLetra(c))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)); 
									}
								}
							}
							if (numeroDigitos==1)numeroDigitos++;
						}
						if(numeroDigitos==2)numeroDigitos++;
					}
					if(numeroDigitos==3)numeroDigitos++;
				}
				if(numeroDigitos==4)numeroDigitos++;
			}
			if(numeroDigitos==5)numeroDigitos++;
		 }
		 return "no encontrado";
	 }
	private static char generarLetra(int k) {
		char letra = (char) k ;
		return letra;
	}
}

