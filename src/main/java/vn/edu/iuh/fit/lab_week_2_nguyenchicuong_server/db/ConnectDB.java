package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models.*;


public class ConnectDB {
    private static ConnectDB instance = null;
    private SessionFactory sessionFactory;
    private Session session;

    public ConnectDB() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductImage.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder()
                .build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.getCurrentSession();
    }

    public static ConnectDB getInstance() {
        if (instance == null)
            instance = new ConnectDB();
        return instance;

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
