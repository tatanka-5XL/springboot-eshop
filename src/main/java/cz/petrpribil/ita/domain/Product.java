package cz.petrpribil.ita.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;
}
