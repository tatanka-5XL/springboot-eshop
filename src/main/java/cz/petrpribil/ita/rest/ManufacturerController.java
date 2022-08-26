package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/authors")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping
    public Collection<ManufacturerDto> findAll(){
        return manufacturerService.findAll();
    }
}





/*
    @GetMapping("{id}")
    public ManufacturerDto findManufacturer(@PathVariable("id") Long id){
        return manufacturerService.findManufacturer(id);
    }
 */