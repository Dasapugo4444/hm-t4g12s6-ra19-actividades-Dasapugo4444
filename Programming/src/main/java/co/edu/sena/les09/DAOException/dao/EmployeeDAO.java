package co.edu.sena.les09.DAOException.dao;

import co.edu.sena.les09.DAOException.model.Employee;

public interface EmployeeDAO {

    public void add(Employee emp) throws DAOException;

    public void update(Employee emp) throws DAOException;

    public void delete(int id)throws DAOException;

    public Employee findById(int id) throws DAOException;

    public Employee[] getAllEmployees() throws DAOException;
    
}