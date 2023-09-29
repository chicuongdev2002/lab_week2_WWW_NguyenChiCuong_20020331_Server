package vn.edu.iuh.fit.lab_week_2_nguyenchicuong_server.models;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable {
    @Column(name="price",columnDefinition = "DOUBLE")
    private double price;
    @Column(name="quantity",columnDefinition = "DOUBLE")
    private double quantity;
    @Column(name="note",columnDefinition = "varchar(255)")
    private String note;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
