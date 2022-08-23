package com.produtos_servicos.pedidos.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos_servicos.pedidos.repository.OrderRepository;
import com.produtos_servicos.pedidos.model.Order;
import com.produtos_servicos.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	//getAll
	@GetMapping("/orders")
	public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
	//getById
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
	        throws ResourceNotFoundException {
	        Order order = orderRepository.findById(orderId)
	          .orElseThrow(() -> new ResourceNotFoundException("Order not found by Id - Pedido não encontrado pelo Id :: " + orderId));
	        return ResponseEntity.ok().body(order);
	}
	//post
	@PostMapping("/orders")
	public Order createOrder(@Validated @RequestBody Order order) {
		return orderRepository.save(order);
	}
	//update
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
	         @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException {
	        Order order = orderRepository.findById(orderId)
	        .orElseThrow(() -> new ResourceNotFoundException("Order not found by Id - Pedido não encontrado pelo Id :: " + orderId));

	        order.setNumber(orderDetails.getNumber());
	        order.setPercentualDiscount(orderDetails.getPercentualDiscount());
	        order.setTimestamp(orderDetails.getTimestamp());
	        order.setTotalValue(orderDetails.getTotalValue());
	        final Order updatedOrder = orderRepository.save(order);
	        return ResponseEntity.ok(updatedOrder);
	    }
	//delete
	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId)
	         throws ResourceNotFoundException {
	        Order order = orderRepository.findById(orderId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Order not found by Id - Pedido não encontrado pelo Id :: " + orderId));
	        orderRepository.delete(order);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}

