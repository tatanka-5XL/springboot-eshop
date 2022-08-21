package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.mapper.ProductGroupMapper;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.model.ProductGroupDto;
import cz.petrpribil.ita.repository.ProductGroupRepository;
import cz.petrpribil.ita.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductGroupServiceImpl implements ProductGroupService {

    private final ProductGroupRepository productGroupRepository;
    private final ProductGroupMapper productGroupMapper;

    @Override
    @Transactional(readOnly = true)
    public ProductGroupDto findProductGroup(Long id) {
        log.info("Fetching product group " + id + "...");
        ProductGroupDto productGroup = productGroupRepository.findById(id)
                .map(productGroupMapper::toDto)
                .orElseThrow();   // refactor???
        log.debug("Displayed product group " + productGroup);
        return productGroup;
    }

    @Override
    public Collection<ProductGroupDto> findAll() {
        return productGroupRepository.findAll().stream()
                .map(productGroupMapper::toDto)
                .collect(Collectors.toList());
    }
}
