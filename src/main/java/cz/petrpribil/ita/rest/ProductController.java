package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import cz.petrpribil.ita.service.ProductServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("http://localhost:8088")
public class ProductController {
    private ProductServiceInterface productService;

    public ProductController(ProductServiceInterface productService) {
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

}
