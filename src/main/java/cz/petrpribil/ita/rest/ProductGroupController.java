package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductGroupDto;
import cz.petrpribil.ita.service.ProductGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/genres")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class ProductGroupController {
    private final ProductGroupService productGroupService;
    @GetMapping
    public Collection<ProductGroupDto> findAll() {
        return productGroupService.findAll();
    }
}





/*

 @GetMapping("{id}")
 public ProductGroupDto findProductGroup(@PathVariable("id") Long id){
 return productGroupService.findProductGroup(id);


 */
