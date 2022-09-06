package net.armanit.ecommerce.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Data
public class Product {
    @Id
    private String id;

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Category can't be blank")
    private String category;

    private int price;

}
