package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.PreviewResponse;
import cz.petrpribil.ita.model.ProductRequestDto;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.model.ProductSimpleDto;
import cz.petrpribil.ita.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/products")
// @CrossOrigin("http://localhost:8088")  uz nemusim, mam to nastavene globalne v SecurityConfig
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

    @PostMapping(value = "{id}/preview", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPreview(@PathVariable Long id, @RequestPart("file")MultipartFile file) {
        productService.addPreview(id, file);
    }

    @GetMapping(value = "{id}/preview", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPreview(@PathVariable("id") Long id, HttpServletResponse response) {
        PreviewResponse previewResponse = productService.getPreview(id);
        response.addHeader("Contet-Disposition", "attachement; filename=" + previewResponse.getFilename());
        return previewResponse.getBytes();
    }


}
