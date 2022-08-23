package com.produtos_servicos.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos_servicos.items.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
