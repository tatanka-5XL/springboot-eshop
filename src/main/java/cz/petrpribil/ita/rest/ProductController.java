package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("http://ita-frontend.s3-website.eu-central-1.amazonaws.com")
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

}
