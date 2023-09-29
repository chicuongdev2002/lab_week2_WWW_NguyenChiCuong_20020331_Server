package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories;


import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;

public class EmployeeRepository extends CRUDRepository<Employee> {

    public EmployeeRepository(Class<Employee> entityClass) {
        super(entityClass);
    }
}
