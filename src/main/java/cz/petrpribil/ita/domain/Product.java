package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length=512)
    private String description;
    private String image;
    private Long price;
    private Long stock;
}