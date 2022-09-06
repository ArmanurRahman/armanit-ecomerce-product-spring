package net.armanit.ecommerce.product.controller;

import lombok.extern.slf4j.Slf4j;
import net.armanit.ecommerce.product.model.Product;
import net.armanit.ecommerce.product.repository.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductInterface productInterface;

    @PostMapping("/product/add")
    public Product addProduct(@Valid @RequestBody Product product) {
        log.info("Product add");
        return  productInterface.save(product);
    }

}
