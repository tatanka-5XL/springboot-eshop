package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductGroupDto;
import cz.petrpribil.ita.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/productgroups")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class ProductGroupController {
    private final ProductGroupService productGroupService;
    @GetMapping
    public Collection<ProductGroupDto> findAll() {
        return productGroupService.findAll();
    }
}
