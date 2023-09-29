package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository emRe;

    public EmployeeService() {
        emRe=new EmployeeRepository(Employee.class);
    }
   //Lấy tất cả
    public List<Employee> getAll(){
        return emRe.getAll();
    }
    //Lấy bởi id
    public Optional<Employee> findById(long id){
        return emRe.findById(id);
    }
    //Thêm
    public boolean insert(Employee employee){
        return emRe.insert(employee);
    }
    //Cập nhật
    public Optional<Boolean> update(Employee employee){
        Optional<Employee> o=findById(employee.getEmpId());
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(emRe.update(employee));
    }
    //Xóa
    public Optional<Boolean> delete(long id){
        Optional<Employee> o=findById(id);
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(emRe.delete(id));
    }

}
