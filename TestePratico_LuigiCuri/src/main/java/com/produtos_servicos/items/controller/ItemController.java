package com.produtos_servicos.items.controller;
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

import com.produtos_servicos.exceptions.ResourceNotFoundException;
import com.produtos_servicos.items.model.Item;
import com.produtos_servicos.items.repository.ItemRepository;



@RestController
@RequestMapping("/api")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;
	
	//getAll
	@GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
	//getbyId
	@GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId)
        throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
          .orElseThrow(() -> new ResourceNotFoundException("Item not found by Id - Item não encontrado pelo Id :: " + itemId));
        return ResponseEntity.ok().body(item);
    }
	//post
	@PostMapping("/items")
	public Item createItem(@Validated @RequestBody Item item) {
		return itemRepository.save(item);
		
	}
	//update
	@PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
         @Validated @RequestBody Item itemDetails) throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found by Id - Item não encontrado pelo Id :: " + itemId));

        item.setDescription(itemDetails.getDescription());
        item.setValue(itemDetails.getValue());
        item.setType(itemDetails.getType());
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }

	//delete
	 @DeleteMapping("/items/{id}")
	    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long itemId)
	         throws ResourceNotFoundException {
	        Item item = itemRepository.findById(itemId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Item not found by Id - Item não encontrado pelo Id :: " + itemId));
	        itemRepository.delete(item);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
