package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.entity.ProductDTO;
import com.example.ManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product->products.add(product));

        return products;
    }

    public Product getProductById(Long prod_ID) {
        return productRepository.findById(prod_ID).get();
    }

//    public boolean updateProduct(Long prod_ID) {
//        Product product = getProductById(prod_ID);
//        product.setProd_name(product.getProd_name());
//        product.setProd_price(product.getProd_price());
//        product.setAvailability(product.getAvailability());
//        product.setCategory_ID(product.getCategory_ID());
//
//        return saveOrUpdateProduct(product);
//    }

    public boolean updateProduct(Long prod_ID, ProductDTO productDTO) {
        Product product = getProductById(prod_ID);
        product.setProd_name(productDTO.getProd_name());
        product.setProd_price(productDTO.getProd_price());
        product.setAvailability(productDTO.getAvailability());
        product.setCategory_ID(productDTO.getCategory_ID());

        return saveOrUpdateProduct(product);
    }

    public boolean saveOrUpdateProduct(Product product) {
        Product updatedProduct = productRepository.save(product);

        if(getProductById(updatedProduct.getProd_ID()) != null)
            return true;

        return false;
    }

    public boolean deleteProduct(Long prod_ID) {
        productRepository.deleteById(prod_ID);

        return true;
    }
}