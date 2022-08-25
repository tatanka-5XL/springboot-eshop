package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product extends AbstractEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length=512)
    private String description;
    private String image;
    private Long price;
    private Long stock;
    @ManyToOne
    @JoinColumn (
            name = "id_manufacturer"
    )
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn (
            name = "id_product_group"
    )
    private ProductGroup productGroup;

}
