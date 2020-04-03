package pl.karolcichosz.sri.controllers;


import org.springframework.stereotype.Controller;
import pl.karolcichosz.sri.CategoryHelper;
import pl.karolcichosz.sri.dao.ProductRepository;
import pl.karolcichosz.sri.model.Category;
import pl.karolcichosz.sri.model.Product;

import java.util.List;

@Controller
public class ShopController {
    final ProductRepository productRepository;
    final CategoryHelper categoryHelper;

    public ShopController(ProductRepository productRepository, CategoryHelper categoryHelper) {
        this.productRepository = productRepository;
        this.categoryHelper = categoryHelper;
    }

    public List<Product> getProductList(Category category)
    {
        return productRepository.findByCategory(category);
    }



}
