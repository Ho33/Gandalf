package gandalf;

public class Contraseña {

	public static void main(String[] args) {
//		//numero de caracteres 136900;
//		
//		RANGO 33 136900 total de caracteres UNICODE


		
		 String contraseña = "\".($=";
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
									}
								}
								if (numeroDigitos==2) {
									if (contraseña.compareTo(String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
									}
								}
								if (numeroDigitos==3) {
									if (contraseña.compareTo(String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
									}
								}
								if (numeroDigitos==4) {
									System.out.println(String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));
									if (contraseña.compareTo(String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
									}
								}
								if (numeroDigitos==5) {
									System.out.println(String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));
									if (contraseña.compareTo(String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
									}
								}
								if (numeroDigitos==6) {
									System.out.println(String.valueOf(generarLetra(b))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)));
									if (contraseña.compareTo(String.valueOf(generarLetra(c))+String.valueOf(generarLetra(a))+String.valueOf(generarLetra(i))+String.valueOf(generarLetra(j))+String.valueOf(generarLetra(k)))==0) {
										System.out.println("encontrado"+intento.toString());
										encontrado=true;
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
		 if(numeroDigitos==6)numeroDigitos++;
	}

	private static char generarLetra(int k) {
		char letra = (char) k ;
		return letra;
	}

}
