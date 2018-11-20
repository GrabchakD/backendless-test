package com.backendless.services;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.dao.ProductRepository;
import com.backendless.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public IDataStore<Product> getAll() {
        return Backendless.Persistence.of(Product.class);
    }

    @Override
    public Product addProduct(Product product) {

        Backendless.Persistence.save(product);

        return product;
    }

    @Override
    public Product updateProductById(Product product) {

        Backendless.Persistence.save(product);

        return product;
    }

    @Override
    public Product deleteProductById(Product product) {

        Backendless.Persistence.of(Product.class).remove(product);

        return product;
    }
}
