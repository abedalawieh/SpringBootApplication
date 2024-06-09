package com.salesmanagement.salesmanagement.product.service;

import com.salesmanagement.salesmanagement.product.model.ProductModel;
import com.salesmanagement.salesmanagement.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<ProductModel> findAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ProductModel> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }

    @Transactional
    public ProductModel updateProduct(Long id, ProductModel product) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setCategory(product.getCategory());
                    return productRepository.save(existingProduct);
                }).orElseGet(() -> {
                    product.setId(id);
                    return productRepository.save(product);
                });
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
