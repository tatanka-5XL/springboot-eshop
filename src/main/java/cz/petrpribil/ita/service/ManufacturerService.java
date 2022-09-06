package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ManufacturerDto;

import java.util.Collection;

public interface ManufacturerService {

    /**
     * To show all manufacturers stored in the database
     * @return collection of manufacturers as {@link Collection<ManufacturerDto>}
     */
    Collection<ManufacturerDto> findAll();
}



//    ManufacturerDto findManufacturer(Long id);