package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;
import cz.petrpribil.ita.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("http://localhost:8088")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("{id}")
    public ProductDto findProduct(@PathVariable("id") Long id) {
        return productService.findProduct(id);
    }

    @GetMapping
    public Collection<ProductSimpleDto> findAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductRequestDto productRequestDto){
             return productService.createProduct(productRequestDto);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductRequestDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
