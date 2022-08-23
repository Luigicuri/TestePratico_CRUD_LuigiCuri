package com.produtos_servicos.OrderedItems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos_servicos.OrderedItems.model.OrderedItem;

public interface OrderedItemRepository extends JpaRepository<OrderedItem, Long>{

}
