package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
}
