package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findCartsByModifiedAtBefore (LocalDateTime timestamp);
}
