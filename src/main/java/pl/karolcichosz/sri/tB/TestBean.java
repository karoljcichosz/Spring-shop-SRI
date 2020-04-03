package pl.karolcichosz.sri.tB;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.karolcichosz.sri.CategoryHelper;
import pl.karolcichosz.sri.controllers.ShopController;
import pl.karolcichosz.sri.controllers.StatefulCartController;
import pl.karolcichosz.sri.dao.CategoryRepository;
import pl.karolcichosz.sri.dao.ProductRepository;
import pl.karolcichosz.sri.model.Category;
import pl.karolcichosz.sri.model.Product;

import java.io.Serializable;
import java.util.List;

@Controller("testBean")
@Scope(value = "session")
public class TestBean implements Serializable {

	final ShopController shopController;
	final CategoryHelper categoryHelper;
	final ProductRepository productRepository;
	final CategoryRepository categoryRepository;
	final StatefulCartController cartController;

	public TestBean(ShopController shopController, CategoryHelper categoryHelper, ProductRepository productRepository, CategoryRepository categoryRepository, StatefulCartController cartController) {
		this.shopController = shopController;
		this.categoryHelper = categoryHelper;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.cartController = cartController;
	}

	@SneakyThrows
	@GetMapping("/sri2")
	public String test() {
		Category newCategory = new Category();
		newCategory.setParentCategory(categoryHelper.getCategoryList().get(0));
		newCategory.setName("Tablety");
		categoryRepository.save(newCategory);
		Product newProduct= new Product();
		newProduct.setCategory(newCategory);
		newProduct.setName("Tablet 2000");
		newProduct.setStock(10);
		newProduct.setVersion(0);
		productRepository.save(newProduct);
		Category currentCategory= categoryHelper.getCategoryList().get(3);
		List<Product> categoryProducts=shopController.getProductList(currentCategory);
		cartController.add(categoryProducts.iterator().next().getId(), 3);
		currentCategory=categoryHelper.getCategoryList().get(2);
		categoryProducts=shopController.getProductList(currentCategory);
		cartController.add(categoryProducts.iterator().next().getId(), 6);
		return "OK";
	}

}
