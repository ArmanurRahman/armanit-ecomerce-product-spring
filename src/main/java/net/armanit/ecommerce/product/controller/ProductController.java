package net.armanit.ecommerce.product.controller;

import lombok.extern.slf4j.Slf4j;
import net.armanit.ecommerce.product.model.Product;
import net.armanit.ecommerce.product.repository.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@Slf4j
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductInterface productInterface;

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) {
        log.info("Product add");
        return  productInterface.save(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProduct() {
        log.info("get all product");
        return productInterface.findAll();
    }

    @GetMapping("/getProductById/{productId}")
    public Product getProductById(@PathVariable String productId) {
        log.info("getProductById");
        return productInterface.findProductById(productId);
    }

    @GetMapping("/getProductByNameAndCategory")
    public List<Product> getProductByNameAndCategory(@RequestParam(required = true) String name,
                                                     @RequestParam(required = true) String category) {
        return productInterface.findProductsByNameLikeAndCategoryLike(name, category);
    }

    @GetMapping("/getProductByPriceRange")
    public List<Product> getProductByPriceRange(@RequestParam String category,
                                                @RequestParam int minPrice,
                                                @RequestParam int maxPrice) {
        return productInterface.findProductsByCategoryLikeAndPriceBetween(category, minPrice, maxPrice);
    }


    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable String productId, @Valid @RequestBody Product product) {
        return productInterface.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productInterface.deleteProductById(productId);
    }

}
