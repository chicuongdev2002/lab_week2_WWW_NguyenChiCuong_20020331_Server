package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.repositories;

import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.Product;

public class ProductRepository extends CRUDRepository<Product> {
    public ProductRepository(Class<Product> entityClass) {
        super(entityClass);
    }
}
