package pl.karolcichosz.sri.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karolcichosz.sri.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
