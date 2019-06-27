package Serializacion;
import java.io.*;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {
		Administrador jefe=new Administrador("Juan", 2000, 2005, 12, 10);
		jefe.estableceIncentivo(5000);
		
		Empleado personal[]=new Empleado[3];
		personal[0]=jefe;
		personal[1]=new Empleado("Ana", 2500, 2010, 01, 15);
		personal[2]=new Empleado("Pedro", 3000, 2011, 11, 15);
		
		try {
			/*****Escribo el arreglo serializado en el archivo********************/
			ObjectOutputStream escribiendo_archivo=new ObjectOutputStream(new FileOutputStream("src/Serializacion/serializado.txt")); //abrmos el stream del archivo de salida
			escribiendo_archivo.writeObject(personal);
			escribiendo_archivo.close();
			
			/*****Leo el arreglo serializado del archivo********************/
			ObjectInputStream leyendo_archivo=new ObjectInputStream(new FileInputStream("src/Serializacion/serializado.txt"));
			Empleado[] personal_recuperado=(Empleado[]) leyendo_archivo.readObject();
			leyendo_archivo.close();
			for(Empleado e: personal_recuperado) {
				System.out.println(e); //aqui esta haciendo uso del metodo toString que sobreescribi
			}
			
		}catch(Exception e) {
			System.out.println("Error al crear el archivo de salida");
		}
	}

}

class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;  //generado por eclipse
	/**
	 * 
	 */
	//private static final long serialVersionUID = -3201436104640193290L; //generado por eclipse
	private String nombre;
	private double sueldo;
	private Date altaContrato;

	public Empleado(String nom, double sue, int anio, int mes, int dia) {
		nombre = nom;
		sueldo = sue;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia); 
		altaContrato = calendario.getTime();	
	}
	
	public Empleado(String nom) {  //Sobrecarga de constructor
		nombre = nom;
		sueldo = 10000;
		GregorianCalendar calendario = new GregorianCalendar(); 
		altaContrato = calendario.getTime();	
	}
	
	public String dameNombre() { //getter
		return nombre;
	}
	
	public double dameSueldo() { //getter
		return sueldo;
	}
	
	public Date dameFechaContrato() { //getter
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * (porcentaje/100);
		sueldo += aumento;
	}
	
	public String toString() {
		
		return "Nombre= " + nombre + ", Sueldo= " + sueldo + ", Fecha de Ingreso= " + altaContrato;
	}
}

class Administrador extends Empleado {
	
	
	private static final long serialVersionUID = 1L; //generado por eclipse
	private double incentivo;
	
	public Administrador(String nom, double sue,int anio, int mes, int dia) {
		super(nom, sue, anio, mes, dia); //llamo al constructor del padre
		incentivo=0;
	}
	
	public void estableceIncentivo(double b) {
		incentivo=b;
	}
	
	public double dameSueldo() {		//sobresscribo el metodo del padre por uno nuevo para jefes
		double sueldoBase = super.dameSueldo();
		return sueldoBase + incentivo;
	}
	
	public String toString() {
		return super.toString() + ", Incentivo= " + incentivo;
	}
}
