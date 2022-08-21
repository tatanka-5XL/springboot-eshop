package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/manufacturers")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;
    @GetMapping
    public Collection<ManufacturerDto> findAll(){
        return manufacturerService.findAll();
    }
}
