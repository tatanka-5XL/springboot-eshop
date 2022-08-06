package cz.petrpribil.ita.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(length=256)
    private String name;
    @NotNull
    @Column(length=512)
    private String description;
    @NotNull
    private String image;
    @NotNull
    @Size
    private Long price;
    @Size
    private Long stock;
}
