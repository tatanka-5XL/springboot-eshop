package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart extends AbstractEntity {
    @OneToMany
    private List<Product> products;
}
