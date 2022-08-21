package cz.petrpribil.ita.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {
    private Long id;
    private String name;
    private String about;
    private String VatNr;
}
