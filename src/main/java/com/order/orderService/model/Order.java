package com.order.orderService.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "orders") // ✅ avoid reserved word 'order'
public class Order {

    @Id
    private int id;

    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_name")
    private List<String> products;
}