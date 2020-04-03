package pl.karolcichosz.sri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.karolcichosz.sri.model.Category;
import pl.karolcichosz.sri.model.Product;

import java.util.List;

@Transactional(propagation = Propagation.NEVER)
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
