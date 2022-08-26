package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
