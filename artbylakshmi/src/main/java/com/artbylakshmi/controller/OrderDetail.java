package com.artbylakshmi.controller;

import com.artbylakshmi.model.OrderDetailsRequest;
import com.artbylakshmi.model.OrderDetailsResponse;
import com.artbylakshmi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OrderDetail {

    @Autowired
    private OrderDetailsService orderDetailsService;

    // Endpoint to get all orders
    @GetMapping("/orders")
    public List<OrderDetailsResponse> getAllOrders() {
        return orderDetailsService.getAllOrders(); // Calls the service method to fetch all orders
    }

    @PostMapping("/order")
    public ResponseEntity<Integer> saveOrder(@RequestBody OrderDetailsRequest orderDetailsRequest) {
        int orderId = orderDetailsService.postOrder(orderDetailsRequest);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
