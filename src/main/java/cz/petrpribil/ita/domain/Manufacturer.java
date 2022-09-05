package cz.petrpribil.ita.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Manufacturer extends AbstractEntity {
    private String name;
    private String about;
    private String vatNr;
}
