package net.armanit.ecommerce.product.repository;

import net.armanit.ecommerce.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductInterface extends MongoRepository<Product, String> {
    public Product findProductById(String productId);
    public List<Product> findProductsByNameLikeAndCategoryLike(String name, String category);

    public List<Product> findProductsByCategoryLikeAndPriceBetween(String category, int minPrice, int maxPrice);

    public void deleteProductById(String productId);
}
