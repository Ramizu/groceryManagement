package com.example.ManagementSystem.service;

import com.example.ManagementSystem.entity.Product;
import com.example.ManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public boolean updateProductName(Long prod_ID) {
        Product product = getProductById(prod_ID);
        product.setProd_name("Name"); // Retrieve from user input

        return saveOrUpdateProduct(product);
    }

    boolean updateProductPrice(Long prod_ID) {
        Product product = getProductById(prod_ID);
        product.setProd_price(10.00); // Retrieve from user input

        return saveOrUpdateProduct(product);
    }

    boolean updateProductAvailability(Long prod_ID) {
        Product product = getProductById(prod_ID);
        product.setAvailability(true); // Retrieve from user input

        return saveOrUpdateProduct(product);
    }

    public boolean saveOrUpdateProduct(Product product) {
        Product updatedProduct = productRepository.save(product);

        if(getProductById(updatedProduct.getProd_ID()) != null)
            return true;

        return false;
    }

    boolean deleteUpdate(Long prod_ID) {
        productRepository.deleteById(prod_ID);

        if(getProductById(prod_ID) == null)
            return true;

        return false;
    }
}
