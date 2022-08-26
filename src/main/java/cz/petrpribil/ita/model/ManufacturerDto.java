package cz.petrpribil.ita.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto {
    private Long id;
    private String name;
    @JsonProperty("bio")
    private String about;
    @JsonProperty("birthDate")
    private String VatNr;
}
