package com.ecommerce.jewellery.mapper;

import com.ecommerce.jewellery.dto.ProductDto;
import com.ecommerce.jewellery.dto.ProductGetDto;
import com.ecommerce.jewellery.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto modelToPostDto(Product product);

    ProductGetDto modelToGetDto(Product product);

    @InheritInverseConfiguration
    Product dtoToModel(ProductDto productPostDto);
}
