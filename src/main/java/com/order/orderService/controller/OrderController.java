package com.order.orderService.controller;

import com.order.orderService.model.Order;
import com.order.orderService.model.OrderDTO;
import com.order.orderService.model.ProductDTO;
import com.order.orderService.repository.OrderRepository;
import com.order.orderService.service.ProductsServiceProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository, ProductsServiceProxy productsServiceProxy) {
        this.orderRepository = orderRepository;
        this.productsServiceProxy = productsServiceProxy;
    }

    private ProductsServiceProxy productsServiceProxy;

    @PostMapping
    @CircuitBreaker(name = "product-service",fallbackMethod = "fallBackMethod")
    public Order createOrder(@RequestBody OrderDTO order) {
        Order newOrder = new Order();
        newOrder.setId(order.id());
        List<String> productList = new ArrayList<>();
        for (Integer id : order.products()) {
            ResponseEntity<ProductDTO> prod = productsServiceProxy.getProductById(id);
            productList.add(prod.getBody().name());
        }
        newOrder.setProducts(productList);
        return orderRepository.save(newOrder);
    }



    public Order fallBackMethod(OrderDTO order, Throwable throwable) {
        Order fallbackOrder = new Order();
        fallbackOrder.setId(order.id());

        // Use default product names since product service failed
        List<String> fallbackProducts = new ArrayList<>();
        for (int i = 0; i < order.products().size(); i++) {
            fallbackProducts.add("UNKNOWN_PRODUCT");
        }

        fallbackOrder.setProducts(fallbackProducts);
        return fallbackOrder;
    }
}
