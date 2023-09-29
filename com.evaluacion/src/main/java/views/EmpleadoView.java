package views;

import controllers.EmpleadoController;

public class EmpleadoView {
	
	public static void main(String[] args) {		
		
		//Create
		//String empleado = new EmpleadoController().crearEmpleado("Lopez", "Roy", 18, "Masculino", 2200);		
			
		//Read
		//String empleado = new EmpleadoController().leerEmpleado(6);
		
		//Update
		//String empleado = new EmpleadoController().actualizarEmpleado(6, "Paredes", "Juanito", 30, "Masculino", 2000);

		//Delete
		String empleado = new EmpleadoController().eliminarEmpleado(6);
		
		System.out.print(empleado);
	}
}
