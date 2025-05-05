package com.hoangdm.product.models.dtos.mapper;

import com.hoangdm.product.models.dtos.CategoryResponse;
import com.hoangdm.product.models.dtos.ProductPurchaseResponse;
import com.hoangdm.product.models.dtos.ProductRequest;
import com.hoangdm.product.models.dtos.ProductResponse;
import com.hoangdm.product.models.entities.Category;
import com.hoangdm.product.models.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(
                        Category.builder()
                                .id(request.categoryId()).build()
                )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                new CategoryResponse(
                        product.getCategory().getId(),
                        product.getCategory().getName(),
                        product.getCategory().getDescription())
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product,double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
