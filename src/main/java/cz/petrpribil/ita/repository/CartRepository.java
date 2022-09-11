package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteCartsByModifiedAtBefore(LocalDateTime timestamp);
}
