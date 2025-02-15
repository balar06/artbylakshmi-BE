package com.artbylakshmi.service;

import com.artbylakshmi.entity.OrderDetails;
import com.artbylakshmi.model.OrderDetailsRequest;
import com.artbylakshmi.model.OrderDetailsResponse;
import com.artbylakshmi.repo.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

   public int postOrder(OrderDetailsRequest orderDetailsRequest){
       OrderDetails orderDetails = new OrderDetails();
       orderDetails.setName(orderDetailsRequest.getName());
       orderDetails.setPrice(BigDecimal.valueOf(orderDetailsRequest.getPrice()));
       orderDetails.setCaption(orderDetailsRequest.getCaption());
       orderDetails.setPhoneNumber(orderDetailsRequest.getPhoneNumber());
       orderDetails.setDeliveryAddress(orderDetailsRequest.getDeliveryAddress());
       orderDetails.setEmail(orderDetailsRequest.getEmail());
       orderDetails.setStatus(orderDetailsRequest.getStatus());
       orderDetails.setOrderDate(LocalDate.now());
       orderDetails.setEstimatedDeliveryDate(LocalDate.now());

       // Save the order to the database
       OrderDetails savedOrder = orderDetailsRepository.save(orderDetails);

       return savedOrder.getOrderId();
    }

    // Method to fetch all orders
    public List<OrderDetailsResponse> getAllOrders() {
        List<OrderDetails> orders = orderDetailsRepository.findAll();

        return orders.stream().map(order -> {
            OrderDetailsResponse response = new OrderDetailsResponse();
            response.setOrderId(order.getOrderId());
            response.setName(order.getName());
            response.setPrice(order.getPrice());
            response.setCaption(order.getCaption());
            response.setPhoneNumber(order.getPhoneNumber());
            response.setDeliveryAddress(order.getDeliveryAddress());
            response.setStatus(order.getStatus()); // Convert Enum to String
            response.setOrderDate(formatDate(order.getOrderDate())); // Format Date
            response.setEstimatedDeliveryDate(formatDate(order.getEstimatedDeliveryDate())); // Format Date
            return response;
        }).collect(Collectors.toList());

    }

    private String formatDate(LocalDate date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return date.format(formatter);  // Format LocalDate as a string
        }
        return null;
    }

}

