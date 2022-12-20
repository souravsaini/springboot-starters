package com.sourav.productservice.respository;

import com.sourav.productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
