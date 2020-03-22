package pl.karolcichosz.sri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karolcichosz.sri.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
