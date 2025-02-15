package com.artbylakshmi.repo;

import com.artbylakshmi.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    // You can add custom queries here if needed, for example:
    // Optional<OrderDetails> findByName(String name);
    // List<OrderDetails> findByStatus(OrderDetails.OrderStatus status);


    List<OrderDetails> findAll();
}

