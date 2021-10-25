package com.ecommerce.jewellery.service;

import com.ecommerce.jewellery.dao.ProductRepository;
import com.ecommerce.jewellery.dto.ProductDto;
import com.ecommerce.jewellery.dto.ProductGetDto;
import com.ecommerce.jewellery.mapper.ProductMapper;
import com.ecommerce.jewellery.model.Product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

//    public Product save(Product product){
//        return productRepository.save(product);
//    }

    public ProductGetDto save(ProductDto productPostDto, MultipartFile file) throws IOException {

        UUID uuid =UUID.randomUUID();
        File saveFile = new ClassPathResource("static/productImage").getFile();
        Path path = Paths.get(saveFile.getAbsolutePath()+File.separator + uuid + file.getOriginalFilename());
        Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

        Product newProduct = productMapper.dtoToModel(productPostDto);
        newProduct.setImage(uuid+file.getOriginalFilename());

        Product product = productRepository.save(newProduct);

        ProductGetDto productGetDto = productMapper.modelToGetDto(product);

        productGetDto.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("/productImage/").path(productGetDto.getImage()).toUriString());

        return  productGetDto;
//        UserGetDto userGetDto = userMapper.modelToGetDto(user);
//        userGetDto.setImagePath(ServletUriComponentsBuilder.fromCurrentContextPath().path("/userimage/").path(userGetDto.getImagePath()).toUriString());
//        return null;
    }

    public List<Product> saveAll(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product getById(long id){
        Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new) ;
        product.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("/productImage/").path(product.getImage()).toUriString());
        return  product;
    }

//    public List<Product> getAllProducts(){
//        return productRepository.findAll();
//    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        for(Product p:products){
            p.setImage(ServletUriComponentsBuilder.fromCurrentContextPath().path("/productImage/").path(p.getImage()).toUriString());
        }
        return products;
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Product existingProduct = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDetail(updatedProduct.getDetail());
        existingProduct.setProductPrice(updatedProduct.getProductPrice());
        existingProduct.setImage(updatedProduct.getImage());

        return productRepository.save(existingProduct);
    }

    public String updateProduct(Long productId, ProductDto updatedProductPostDto, MultipartFile updatedFile) throws IOException {
        Product existingProduct = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);

        if (existingProduct != null) {
            UUID uuid = UUID.randomUUID();
            File saveFile = new ClassPathResource("static/productImage").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + uuid + updatedFile.getOriginalFilename());
            Files.copy(updatedFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            Product newUpdatedProduct = productMapper.dtoToModel(updatedProductPostDto);
            newUpdatedProduct.setImage(uuid + updatedFile.getOriginalFilename());

            existingProduct.setName(newUpdatedProduct.getName());
            existingProduct.setProductPrice(newUpdatedProduct.getProductPrice());
            existingProduct.setDetail(newUpdatedProduct.getDetail());
            existingProduct.setImage(newUpdatedProduct.getImage());
            existingProduct.setProductQuantity(newUpdatedProduct.getProductQuantity());
            productRepository.save(existingProduct);

            return "Updated ID: " + productId;
        } else {
            return "Not Found";
        }
    }

    public String updateById(long id, int productQuantity){
        productRepository.updateProductById(id, productQuantity);
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
