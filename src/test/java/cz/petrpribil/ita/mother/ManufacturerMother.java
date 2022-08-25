package cz.petrpribil.ita.mother;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.model.ManufacturerDto;

public final class ManufacturerMother {
    private ManufacturerMother(){

    }

    public static Manufacturer getTestManufacturer(){
        return (Manufacturer) new Manufacturer()
                .setName("Plastik")
                .setAbout("Veskere plasticke vyrobky")
                .setVatNr("CZ000000")
                .setId(200L);
    }

    public static ManufacturerDto getTestManufacturerDto(){
        return new ManufacturerDto()
                .setName("Plastik")
                .setAbout("Veskere plasticke vyrobky")
                .setVatNr("CZ000000")
                .setId(200L);
    }

}
