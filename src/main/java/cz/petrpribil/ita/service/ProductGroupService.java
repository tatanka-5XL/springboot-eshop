package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductGroupDto;

import java.util.Collection;

public interface ProductGroupService {
    Collection<ProductGroupDto> findAll();
}
