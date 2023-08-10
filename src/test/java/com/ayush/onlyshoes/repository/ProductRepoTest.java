package com.ayush.onlyshoes.repository;


import com.ayush.onlyshoes.model.Category;
import com.ayush.onlyshoes.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepoTest {
    @Autowired
    private ProductRepository productRepository;

    //Test to save the prodcuct
    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveProduct(){
//        Category category= Category.builder()
//                .id(20)
//                .name("Nike2")
//                .build();

        Product product = Product.builder()
                .id(Long.valueOf(1))
                .name("Air Jordan")
//                .category(category)
                .price(23.0)
                .weight(20.0)
                .description("Nice")
                .imageName("null")
                .build();
        Product newP= productRepository.save(product);
        Assertions.assertThat(newP.getId()).isGreaterThan(0);

    }

    //Test to Fetch all product list
    @Test
    @Order(2)
    public void fetchProductList(){
        List<Product> products = productRepository.findAll();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }

    //Test to update a product
    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateProduct(){
        Product product= productRepository.findById(Long.valueOf(1)).get();
        product.setName("Not Air Jordan");
        Product updatedProduct= productRepository.save(product);
        Assertions.assertThat(updatedProduct.getName()).isEqualTo("Not Air Jordan");

    }


    //delete product test
    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteProduct(){
        Product product= productRepository.findById(Long.valueOf(1)).get();
        productRepository.delete(product);
//
        Optional<Product> emptyProduct = productRepository.findById(Long.valueOf(1));
        Assertions.assertThat(emptyProduct).isEqualTo(Optional.empty());
    }

}
