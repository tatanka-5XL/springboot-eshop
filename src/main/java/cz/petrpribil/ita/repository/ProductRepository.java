package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
