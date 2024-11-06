package com.all_day_notes.service.sample_service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.all_day_notes.entity.sample_entity.Item;
import com.all_day_notes.form.sample_item.ItemForm;
import com.all_day_notes.repository.sample_repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }
}