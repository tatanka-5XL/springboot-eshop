package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductGroupDto;

import java.util.Collection;

public interface ProductGroupService {

    ProductGroupDto findProductGroup(Long id);
    Collection<ProductGroupDto> findAll();
}
