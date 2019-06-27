package DirectoriosArchivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Prueba_Rutas {

	public static void main(String[] args) {
		File archivo=new File("src" + File.separator + "DirectoriosArchivos" + File.separator  + "archivo_ejemplo.dat"); //apunto a un archivo
		System.out.println(archivo.getAbsolutePath());

		File ruta=new File("src" + File.separator + "DirectoriosArchivos"); //apunto a un directorio
		System.out.println(ruta.getAbsolutePath());
		
		String[] lista_archivos=ruta.list();	//saco la lista de archivos del directorio
		for(String s:lista_archivos) {
			System.out.println(s);
			
			File f=new File(ruta.getAbsolutePath(),s);
			
			if (f.isDirectory()) {
				String[] archivos_subcarpeta=f.list();
				for(String s2:archivos_subcarpeta) {
					System.out.println(s2);
				}
			}
		}
		
		/*****crear un directorio ******************/
		//File ruta1=new File("src" + File.separator + "DirectoriosArchivos" + File.separator + "nuevoFolder"); 
		//ruta1.mkdir();
		//ruta.delete(); borra archivo o directorio
		
		/*****crear un archivo******************/
		File ruta2=new File("src" + File.separator + "DirectoriosArchivos" + File.separator + "chato.txt");
		try { 
			ruta2.createNewFile();
			//ruta.delete(); borra archivo o directorio
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		Escribiendo accede=new Escribiendo();
		accede.escribir(ruta2.getAbsolutePath());
	}

}

class Escribiendo {
	public Escribiendo() {
		// TODO Auto-generated constructor stub
	}
	
	public void escribir(String archivo){
		String frase="Este es una luinea de texto de prueba";
		try {
			FileWriter escritura=new FileWriter(archivo);
			for(int i=0; i<frase.length();i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		}catch(IOException e) {
			
		}
	}
}
