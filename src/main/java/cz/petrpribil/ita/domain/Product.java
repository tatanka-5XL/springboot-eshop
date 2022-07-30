package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {
    @Id
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;
}
