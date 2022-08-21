package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String about;
    private String vatNr;
    @ManyToOne
    @JoinColumn (
            name = "id_manufacturer"
    )
    private Manufacturer manufacturer;

}
