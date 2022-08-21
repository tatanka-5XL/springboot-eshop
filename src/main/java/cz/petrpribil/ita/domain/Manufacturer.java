package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Manufacturer extends AbstractEntity {
    private String name;
    private String about;
    private String vatNr;
}
