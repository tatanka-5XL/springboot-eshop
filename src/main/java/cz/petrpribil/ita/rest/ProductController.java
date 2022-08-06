package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("http://localhost:8088")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ProductDto findProduct(@PathVariable("id") Long id) {
        return productService.findProduct(id);
    }

    @GetMapping
    public Collection<ProductDto> findAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody CreateProductDto createProductDto){
             return productService.createProduct(createProductDto);
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

}
