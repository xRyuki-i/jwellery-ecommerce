package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.ProductRepository;
import com.ecommerce.jewellery.model.Product;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product getById(long id){
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Product existingProduct = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDetail(updatedProduct.getDetail());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setImage(updatedProduct.getImage());

        return productRepository.save(existingProduct);
    }

    public String updateById(long id, Double productPrice){
        productRepository.updateProductById(id, productPrice);
        return "Product id:  "+id+" updated";
    }

    public String deleteById(long id){
        productRepository.deleteById(id);

        return "ID: "+id+" deleted";
    }

    public String deleteAll(){
        productRepository.deleteAll();

        return "All Admin deleted";
    }
}
