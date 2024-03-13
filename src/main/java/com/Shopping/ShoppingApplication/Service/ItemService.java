package com.Shopping.ShoppingApplication.Service;

import com.Shopping.ShoppingApplication.Model.DTO.ItemDTO;
import com.Shopping.ShoppingApplication.Model.Entity.Category;
import com.Shopping.ShoppingApplication.Model.Entity.Item;
import com.Shopping.ShoppingApplication.Repository.CategoryRepository;
import com.Shopping.ShoppingApplication.Repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    ItemRepository itemRepository;
    CategoryService categoryService;

    @Autowired
    public ItemService(ItemRepository itemRepository, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }

    public List<ItemDTO> getAllItem() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> itemDTOs = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        for(Item i : items) {
            ItemDTO itemDTO = modelMapper.map(i, ItemDTO.class);
            itemDTOs.add(itemDTO);
        }

        return itemDTOs;
    }

    public List<ItemDTO> getItemByCategory(Long id) {
        List<Item> items = itemRepository.getItemByCategory(id);
        List<ItemDTO> itemDTOs = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        for(Item i : items) {
            ItemDTO itemDTO = modelMapper.map(i, ItemDTO.class);
            itemDTOs.add(itemDTO);
        }

        return itemDTOs;
    }

    public List<ItemDTO> searchItemByName(String name) {
        if(name.equals("")) {
            return this.getAllItem();
        }

        List<Item> items = itemRepository.searchItemByName(name);
        List<ItemDTO> itemDTOs = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        for(Item i : items) {
            ItemDTO itemDTO = modelMapper.map(i, ItemDTO.class);
            itemDTOs.add(itemDTO);
        }

        return itemDTOs;
    }

    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.getItemById(id);

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(item, ItemDTO.class);
    }

    public String addItem(String name, String description, int price, String seller, Long categoryId){
        String message = "";
        if(name.isBlank() || description.isBlank() || seller.isBlank() || categoryId == 0) {
            message = "Require all fields!";
            return message;
        }

        if(price <= 0) {
            message = "Invalid price!";
            return message;
        }

        Category category = categoryService.getCategoryById(categoryId);
        Item item = Item.builder().photo("").price(price).name(name).description(description).seller(seller).category(category).build();

        itemRepository.save(item);
        return message;
    }

    public String updateItem(Long id, String name, String description, int price, String seller, Long categoryId) {
        String message = "";

        if(name.isBlank() || description.isBlank() || seller.isBlank() || categoryId == 0) {
            message = "Require all fields!";
            return message;
        }

        if(price <= 0) {
            message = "Invalid price!";
            return message;
        }

        Item item = itemRepository.getItemById(id);
        item.setCategory(categoryService.getCategoryById(categoryId));
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setSeller(seller);

        itemRepository.save(item);

        return message;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
