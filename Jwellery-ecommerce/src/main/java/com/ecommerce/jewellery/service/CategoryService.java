package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.CategoryRepository;
import com.ecommerce.jewellery.model.Category;
import java.util.List;

import com.ecommerce.jewellery.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        Category category = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
        for (Product p: category.getProducts()){
            p.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("/productImage/").path(p.getImage()).toUriString());
        }
        return category;
    }

//    public List<Category> getAll(){
//        return categoryRepository.findAll();
//    }

    public List<Category> getAll(){
        List<Category> category = categoryRepository.findAll();
        for(Category c:category){
            for (Product p: c.getProducts()){
                p.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("/productImage/").path(p.getImage()).toUriString());
            }
        }

        return category;
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
