import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Archivo {

	public static void main(String[] args) {
		Escribe_Archivo escritura=new Escribe_Archivo();
		escritura.escribir();

	}

}

class Escribe_Archivo{
	public void escribir() {
		String frase="Esto es una prueba de escritura";
		
		try {
			FileWriter salida=new FileWriter("src/salida.txt",true); //agrego el true para que agregue en caso de que ya exista
			for(int i=0; i<frase.length(); i++) {
				salida.write(frase.charAt(i));				
			}
			salida.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
			e.printStackTrace();
		}
		
	}
}
