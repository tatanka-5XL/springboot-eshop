package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductGroupDto;

import java.util.Collection;

public interface ProductGroupService {

    /**
     * To show all product groups stored in the database
     * @return collection of product groups as {@link Collection<ProductGroupDto>}
     */
    Collection<ProductGroupDto> findAll();
}