package pl.karolcichosz.sri.controllers;


import org.springframework.stereotype.Controller;
import pl.karolcichosz.sri.CategoryHelper;
import pl.karolcichosz.sri.dao.ProductRepository;

@Controller
public class ShopController {
    final ProductRepository productRepository;
    final CategoryHelper categoryHelper;

    public ShopController(ProductRepository productRepository, CategoryHelper categoryHelper) {
        this.productRepository = productRepository;
        this.categoryHelper = categoryHelper;
    }


}
