package com.Shopping.ShoppingApplication.Service;

import com.Shopping.ShoppingApplication.Model.DTO.CategoryDTO;
import com.Shopping.ShoppingApplication.Model.Entity.Category;
import com.Shopping.ShoppingApplication.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDTO> listDTO = new ArrayList<>();

        ModelMapper modelMapper = new ModelMapper();
        for(Category c : list) {
            CategoryDTO categoryDTO = modelMapper.map(c, CategoryDTO.class);
            listDTO.add(categoryDTO);
        }

        return listDTO;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
