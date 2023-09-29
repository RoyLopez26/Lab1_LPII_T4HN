package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@Column(name="idempleado")
	private int idempleado;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="nombres")
	private String nombres;
	@Column(name="edad")
	private int edad;
	@Column(name="sexo")
	private String sexo;
	@Column(name="salario")
	private int salario;
	
	public Empleado() {
		
	}
	
	public Empleado(String apellidos, String nombres, int edad, String sexo, int salario) {
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.edad = edad;
		this.sexo = sexo;
		this.salario = salario;
	}

	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return "Empleado [idempleado=" + idempleado + ", Apellidos=" + apellidos + ", Nombres=" + nombres + ", Edad="
				+ edad + ", Sexo=" + sexo + ", Salario=" + salario + "]";
	}
	
}
