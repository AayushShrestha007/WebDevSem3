package com.ayush.onlyshoes.repository;


import com.ayush.onlyshoes.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryRepoTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveCategory(){
        Category category= Category.builder()
                .name("Nike2")
                .build();
        Category category1= categoryRepository.save(category);
        Assertions.assertThat(category1.getId()).isGreaterThan(0);

    }
    
    @Test
    @Order(2)
    public void deleteCategory(){
        Category category= categoryRepository.findById(1).get();
        categoryRepository.deleteById(1);
        Optional<Category> emptyCategory= categoryRepository.findById(1);
        Assertions.assertThat(emptyCategory).isEqualTo(Optional.empty());
    }


}
