package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/authors")
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