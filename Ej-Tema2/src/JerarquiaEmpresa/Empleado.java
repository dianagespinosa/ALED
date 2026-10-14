package JerarquiaEmpresa;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private String nombre;
	private double salario;
	private List<Empleado> subordinados; //Lista de empleados a su cargo

	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
		this.subordinados = new ArrayList<Empleado>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public List<Empleado> getSubordinados(){
		return this.subordinados;
	}
	
	public void addSubordinado(Empleado empleado) {
		this.subordinados.add(empleado);
	}
	
	public static double presupuestoEquipo(Empleado jefe) {
		
		//Caso base: la empresa no tiene ningún empleado 
		if(jefe == null) {
			return 0.0;
		}
		
		//El coste incluye el salario del propio jefe
		double total = jefe.getSalario();
		
		//Caso recursivo: sumar salario de subordinados
		if(jefe.getSubordinados() != null) {
			for(Empleado sub: jefe.getSubordinados()) {
				total += presupuestoEquipo(sub);
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		Empleado e1 = new Empleado("Lucia", 2300);
		Empleado e2 = new Empleado("Patri", 5100);
		Empleado e3 = new Empleado("Ari", 1200);
		Empleado e4 = new Empleado("Carmen", 3000);
		Empleado e5 = new Empleado("Iciar", 800);
		Empleado jefe = new Empleado("Diana", 9800);
		jefe.addSubordinado(e1);
		jefe.addSubordinado(e3);
		e1.addSubordinado(e2);
		e3.addSubordinado(e4);
		e3.addSubordinado(e5);
		
		System.out.println(presupuestoEquipo(e1));
		System.out.println(presupuestoEquipo(e3));
		System.out.println(presupuestoEquipo(jefe));
	}
	}
