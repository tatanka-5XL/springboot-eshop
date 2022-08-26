package cz.petrpribil.ita.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cart extends AbstractEntity {
    @ManyToMany
    @JoinTable(
            name="r_cart_product",
            joinColumns = @JoinColumn(name="id_cart"),
            inverseJoinColumns = @JoinColumn(name="id_product")
    )
    private List<Product> products;
}
