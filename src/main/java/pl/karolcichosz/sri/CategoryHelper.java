package pl.karolcichosz.sri;


import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.karolcichosz.sri.dao.CategoryRepository;
import pl.karolcichosz.sri.model.Category;

import java.util.List;

@Component
public class CategoryHelper {

    private final CategoryRepository categoryRepository;

    @Getter
    List<Category> categoryList;

    public CategoryHelper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryList=this.categoryRepository.findAll();
    }

    @Scheduled(fixedDelay = 5000)
    public void refreshList()
    {
        categoryList=categoryRepository.findAll();
    }
}
