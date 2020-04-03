package pl.karolcichosz.sri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.karolcichosz.sri.model.Category;

@Transactional(propagation = Propagation.NEVER)
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
