package com.order.orderService.model;

import lombok.Data;

@Data
public class Product {

    private long id;

    private String name;

    private String Description;

    private double price;
}
