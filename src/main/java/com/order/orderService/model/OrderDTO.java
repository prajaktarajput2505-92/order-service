package com.order.orderService.model;

import java.util.List;

public record OrderDTO(int id, List<Integer> products) {
}
