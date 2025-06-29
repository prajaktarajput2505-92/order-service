package com.order.orderService.service;

import com.order.orderService.config.FeignClientConfig;
import com.order.orderService.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service",url = "http://localhost:8080/product",configuration = FeignClientConfig.class)
public interface ProductsServiceProxy {

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id);
}
