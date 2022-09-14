package net.armanit.ecommerce.product.repository;

import net.armanit.ecommerce.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInterface extends MongoRepository<Product, String> {
    public Product findProductById(String productId);
}
