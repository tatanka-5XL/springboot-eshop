package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
