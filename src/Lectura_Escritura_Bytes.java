import java.io.*;
public class Lectura_Escritura_Bytes {

	public static void main(String[] args) {
		int contador=0;
		int datos_entrada[]=new int[45177]; //este lo saque al ejecutar primero el contador
		try {
			FileInputStream archivo_lectura=new FileInputStream("src/joseivan.JPG");
			boolean final_arg=false;
			
			while(!final_arg) {
				int byte_entrada=archivo_lectura.read();
				
				if(byte_entrada!=-1)
					datos_entrada[contador]=byte_entrada;
				else				
					final_arg=true;
				
				//System.out.println(byte_entrada);
				contador++;
			}
			//System.out.println(contador);
			archivo_lectura.close();
		
			
		}catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}
		
		crea_Archivo(datos_entrada);

	}
	
	public static void crea_Archivo(int cadena[]){
		try {
			
			FileOutputStream archivo_escritura=new FileOutputStream("src/joseivan_copia.jpg");
			for(int i=0; i<cadena.length; i++) {
				archivo_escritura.write(cadena[i]);
			}
			archivo_escritura.close();
			
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}
}
