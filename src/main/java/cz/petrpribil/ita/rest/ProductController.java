package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("api/v1/product")
    public ProductDto findProduct() {
        return productService.findProduct();
    }
}
