package com.produtos_servicos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos_servicos.pedidos.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
