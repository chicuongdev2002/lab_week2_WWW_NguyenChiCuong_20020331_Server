package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.sevices;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Employee;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Product;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories.EmployeeRepository;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductServices {
    private final ProductRepository proRe;

    public ProductServices() {
        proRe=new ProductRepository(Product.class);
    }
    //Lấy tất cả
    public List<Product> getAll(){
        return proRe.getAll();
    }
    //Lấy bởi id
    public Optional<Product> findById(long id){
        return proRe.findById(id);
    }
    //Thêm
    public boolean insert(Product product){
        return proRe.insert(product);
    }
    //Cập nhật
    public Optional<Boolean> update(Product product){
        Optional<Product> o=findById(product.getProduct_id());
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(proRe.update(product));
    }
    //Xóa
    public Optional<Boolean> delete(long id){
        Optional<Product> o=findById(id);
        if(o.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(proRe.delete(id));
    }
}
