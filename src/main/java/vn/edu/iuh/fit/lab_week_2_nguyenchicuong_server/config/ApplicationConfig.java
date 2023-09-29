package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.db.ConnectDB;


@ApplicationPath("/api")

public class ApplicationConfig extends Application {
    public ApplicationConfig(){
        ConnectDB.getInstance().getSessionFactory();
    }
}
