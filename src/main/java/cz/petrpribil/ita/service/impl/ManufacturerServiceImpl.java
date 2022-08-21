package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.mapper.ManufacturerMapper;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.repository.ManufacturerRepository;
import cz.petrpribil.ita.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    @Override
    @Transactional(readOnly = true)
    public ManufacturerDto findManufacturer(Long id){
        log.info("Fetching manufacturer " + id + "...");
        ManufacturerDto manufacturer = manufacturerRepository.findById(id)
                .map(manufacturerMapper::toDto)
                .orElseThrow();   // refactor???
        log.debug("Displayed manufacturer " + manufacturer);
        return manufacturer;
    }

    @Override
    public Collection<ManufacturerDto> findAll() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturerMapper::toDto)
                .collect(Collectors.toList());
    }
}
