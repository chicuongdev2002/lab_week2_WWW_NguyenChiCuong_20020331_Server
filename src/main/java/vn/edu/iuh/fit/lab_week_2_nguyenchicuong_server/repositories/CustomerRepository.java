package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;

import java.util.List;


public class CustomerRepository extends  CRUDRepository<Customer> {

    public CustomerRepository(Class<Customer> entityClass) {
        super(entityClass);
    }

    public static class EmployeeServices {

        private final EmployeeRepository emRe;

        public EmployeeServices() {
             emRe=new EmployeeRepository(Employee.class);
        }


    }
}
