import java.io.*;

public class Acceso_Archivo {

	public static void main(String[] args) {
		LeerFichero accede_archivo=new LeerFichero();
		accede_archivo.Lee();
	}

}

class LeerFichero{
	public void Lee(){
		
		try {
			FileReader entrada=new FileReader("src/prueba.txt");
			BufferedReader mibuffer=new BufferedReader(entrada);
			String linea="";
			
			/*int c=entrada.read();
			char letra=(char)c;
			if (c!=-1) { System.out.print(letra);}			
			while (c!=-1) {
			
				c=entrada.read();		
				letra=(char)c;
				System.out.print(letra);
				
			}*/
			
			while(linea!=null) {
				linea=mibuffer.readLine();
				if (linea!=null) 
					System.out.println(linea);
			}
			
			entrada.close();  //cerramos el archivo
		} catch (IOException e) { //Cambio el tipo de excepcion por la de IO exception para que vala para los 2 metodos
			System.out.println("No se encuentra el archivo");
			e.printStackTrace();
		}
		
	}
}