package cz.petrpribil.ita.domain;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class ProductGroup extends AbstractEntity {
    private String name;
    private String description;
}
