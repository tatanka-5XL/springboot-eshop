package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ProductGroup extends AbstractEntity {
    private String name;
    private String description;
}
