package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.mapper.ManufacturerMapper;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.repository.ManufacturerRepository;
import cz.petrpribil.ita.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;
    @Override
    public Collection<ManufacturerDto> findAll() {
        return manufacturerRepository.findAll().stream()
                .map(manufacturerMapper::toDto)
                .collect(Collectors.toList());
    }
}
