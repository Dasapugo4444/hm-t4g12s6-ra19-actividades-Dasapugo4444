package co.edu.sena.les09.DAOException.dao;

import co.edu.sena.les09.DAOException.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {

    // not thread-safe
    private static Employee[] employeeArray = new Employee[10];

    // package level access
    EmployeeDAOMemoryImpl() {
    }

    // Add an Employee record
    public void add(Employee emp) throws DAOException {
        if (employeeArray[emp.getId()]!=null){
            throw new DAOException(("Error añadiendo empleado, el empleado ya existe "+emp.getId()));
        }
        try {
            employeeArray[emp.getId()]=emp;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DAOException("Error añadiendo al empleado, el id debe tener menos de "+employeeArray.length+" caracteres");
        }
    }

    // Update an employee record
    public void update(Employee emp) throws DAOException {
        if (employeeArray[emp.getId()]==null){
            throw new DAOException("Error al actualizar el empleado, no existe el empleado "+emp.getId());
        }
        try {
            employeeArray[emp.getId()]=emp;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DAOException("Error actualizando al empleado, debe tener menos de "+employeeArray.length+" caracteres");
        }
    }

    // Delete an employee record that has this ID
    public void delete(int id) throws DAOException {
        if (employeeArray[id] == null){
            throw new DAOException("El empleado"+id+"no existe");
        }
        try {
            employeeArray[id]=null;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new DAOException("Error al borrar al empleado, debe tener menos de"+employeeArray.length+"caracteres");
        }
    }

    // Find an Employee record using this ID
    public Employee findById(int id) throws DAOException {
       try {
           return employeeArray[id];
       }catch (ArrayIndexOutOfBoundsException e){
           throw new DAOException("No se encontró al empleado");
       }
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    public Employee[] getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        // Iterate through the memory array and find Employee objects
        for (Employee e : employeeArray) {
            if (e != null) {
                emps.add(e);
            }
        }
        return emps.toArray(new Employee[0]);
    }


    public void close(){
        System.out.println("No hay conexión de base de datos para cerrar aún");
    }
}
