package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ManufacturerDto;

import java.util.Collection;

public interface ManufacturerService {
    Collection<ManufacturerDto> findAll();
}
