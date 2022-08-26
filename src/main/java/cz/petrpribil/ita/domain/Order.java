package cz.petrpribil.ita.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="EshopOrder")
public class Order extends AbstractEntity {
        @ManyToMany
        @JoinTable(
                name="r_order_product",
                joinColumns = @JoinColumn(name="id_order"),
                inverseJoinColumns = @JoinColumn(name="id_product")
        )
        private List<Product> products;
        @Enumerated(EnumType.STRING)
        private OrderStatus orderStatus;

        public enum OrderStatus {
                NEW,
                COMPLETED,
                CANCELLED
        }

}
