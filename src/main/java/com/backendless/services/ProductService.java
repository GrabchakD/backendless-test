package com.backendless.services;

import com.backendless.IDataStore;
import com.backendless.model.Product;

public interface ProductService {

    IDataStore<Product> getAll();

    Product addProduct(Product product);

    Product updateProductById(Product product);

    Product deleteProductById(Product product);
}
