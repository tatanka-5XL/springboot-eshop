package cz.petrpribil.ita.domain;

import cz.petrpribil.ita.model.ProductDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Order extends AbstractEntity {
        public enum Status {
        NEW,
        COMPLETED,
        CANCELLED
        }
        @Enumerated(EnumType.STRING)
        private Status status;
        @ManyToMany
        private List<Product> products;
}
