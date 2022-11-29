package com.fullcycle.controllers;

import com.fullcycle.inputs.CategoryInput;
import com.fullcycle.models.Category;
import com.fullcycle.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CategoryController {
  private final CategoryRepository categoryRepository;

  @QueryMapping
  public Iterable<Category> getCategories() {
    return categoryRepository.findAll();
  }

  @MutationMapping
  public Category createCategory(@Argument CategoryInput input) {
    var category = Category.builder().name(input.name()).description(input.description()).build();
    return categoryRepository.save(category);
  }
}
