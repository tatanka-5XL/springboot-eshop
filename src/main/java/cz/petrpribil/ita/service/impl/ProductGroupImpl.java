package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.mapper.ProductGroupMapper;
import cz.petrpribil.ita.model.ProductGroupDto;
import cz.petrpribil.ita.repository.ProductGroupRepository;
import cz.petrpribil.ita.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductGroupImpl implements ProductGroupService {

    private final ProductGroupRepository productGroupRepository;
    private final ProductGroupMapper productGroupMapper;

    @Override
    public Collection<ProductGroupDto> findAll() {
        return productGroupRepository.findAll().stream()
                .map(productGroupMapper::toDto)
                .collect(Collectors.toList());
    }
}
