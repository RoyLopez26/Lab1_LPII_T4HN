package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Empleado;

public class EmpleadoController {

	// Create
	public String crearEmpleado(String apellidos, String nombres, int edad, String sexo, int salario) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		try {
			Empleado empleado = new Empleado(apellidos, nombres, edad, sexo, salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			session.close();
			
			return "Empleado ["+apellidos + nombres+"] registrado exitosamente.";
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "Error al registrar al empleado ["+apellidos + nombres+"].";
		}
	}
	
	// Read
	public String leerEmpleado(int idempleado) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);
			session.getTransaction().commit();
			session.close();
			
			return empleado.toString();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "El empleado ["+ idempleado +"] no existe."; 
		}
	}
	
	//Update
	public String actualizarEmpleado(int idempleado, String apellidos, String nombres, int edad, String sexo, int salario) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idempleado);				
			empleado.setApellidos(apellidos);
			empleado.setNombres(nombres);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);		
			
			session.update(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "El empleado ["+apellidos + nombres+"] se actualizado correctamente.";
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "Error al actualizar al empleado ["+apellidos + nombres+"].";
		}
	}
	
	//Delete
	public String eliminarEmpleado(int idempleado) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado= session.get(Empleado.class,idempleado);
			session.delete(empleado);
			session.getTransaction().commit();			
			sessionFactory.close();
			return "El empleado ["+idempleado+"] se eliminado correctamente.";
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "Error al eliminar al empleado ["+idempleado+"].";
		}
	}
}
