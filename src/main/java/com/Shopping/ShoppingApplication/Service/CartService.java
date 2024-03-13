package com.Shopping.ShoppingApplication.Service;

import com.Shopping.ShoppingApplication.Model.Cart;
import com.Shopping.ShoppingApplication.Model.DTO.ItemDTO;
import com.Shopping.ShoppingApplication.Model.Entity.Item;
import com.Shopping.ShoppingApplication.Model.ItemCart;
import com.Shopping.ShoppingApplication.Repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    ItemRepository itemRepository;

    @Autowired
    public CartService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Cart addItem(Cart oldCart, Long id) {
        Item itemD = itemRepository.getItemById(id);
        if(itemD == null) return null;

        ModelMapper modelMapper = new ModelMapper();
        ItemDTO item = modelMapper.map(itemD, ItemDTO.class);

        if(oldCart.get(item) == null) {
            ItemCart itemCart = new ItemCart(item);
            oldCart.put(item, itemCart);

            return oldCart;
        } else {
            ItemCart itemCart = oldCart.get(item);
            itemCart.setQuantity(itemCart.getQuantity() + 1);
            itemCart.setTotal(itemCart.getPrice() * itemCart.getQuantity());
            oldCart.put(item, itemCart);

            return oldCart;
        }
    }

    public Cart delItem(Cart oldCart, Long id) {
        Item itemD = itemRepository.getItemById(id);
        if(itemD == null) return null;

        ModelMapper modelMapper = new ModelMapper();
        ItemDTO item = modelMapper.map(itemD, ItemDTO.class);

        oldCart.remove(item);
        return oldCart;
    }

    public Cart updateItem(Cart oldCart, Long id, int num) {
        Item itemD = itemRepository.getItemById(id);
        if(itemD == null) return null;

        ModelMapper modelMapper = new ModelMapper();
        ItemDTO item = modelMapper.map(itemD, ItemDTO.class);

        oldCart.put(item, oldCart.get(item).update(num));
        if(oldCart.get(item).getQuantity() == 0) oldCart.remove(item);
        return oldCart;
    }

}
