package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Customer;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories.CustomerRepository;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServices {
    private final CustomerRepository cusRe;

    public CustomerServices() {
        cusRe=new CustomerRepository(Customer.class);
    }
    //Lấy tất cả
    public List<Customer> getAll(){
        return cusRe.getAll();
    }
    //Lấy bởi id
    public Optional<Customer> findById(long id){
        return cusRe.findById(id);
    }
    //Thêm
    public boolean insert(Customer customer){
        return cusRe.insert(customer);
    }
    //Cập nhật
    public Optional<Boolean> update(Customer customer){
        Optional<Customer> o=findById(customer.getCustId());
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(cusRe.update(customer));
    }
    //Xóa
    public Optional<Boolean> delete(long id){
        Optional<Customer> o=findById(id);
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(cusRe.delete(id));
    }
}
