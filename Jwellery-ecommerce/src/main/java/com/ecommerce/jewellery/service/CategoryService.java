package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.CategoryRepository;
import com.ecommerce.jewellery.model.Category;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> saveAll(List<Category> categories){
        return categoryRepository.saveAll(categories);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category getById(long id){
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category updatedCategory){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingCategory.setCategoryName(updatedCategory.getCategoryName());

        return categoryRepository.save(existingCategory);
    }

    public String deleteById(long id){
        categoryRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        categoryRepository.deleteAll();

        return "All Admin deleted";
    }
}
