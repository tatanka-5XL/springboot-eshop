package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.configuration.SecurityConfiguration;
import cz.petrpribil.ita.configuration.SecurityConfigurationProperties;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.exception.ProductNotFoundException;
import cz.petrpribil.ita.model.ProductDto;
import cz.petrpribil.ita.service.ProductService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static cz.petrpribil.ita.mother.ProductMother.getTestProductDto;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest extends AbstractControllerTest implements WithAssertions {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService mockProductService;

    @Test
    void findProduct() throws Exception {
        ProductDto testProductDto = getTestProductDto();

        when(mockProductService.findProduct(1L))
                .thenReturn(testProductDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(getJsonContent("/responses/findProduct.json")));
    }

    @Test
    void testProductNotFound() throws Exception {

        when(mockProductService.findProduct(2L))
                .thenThrow(new ProductNotFoundException(2L));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/2"))
                .andExpect(status().isNotFound())
                .andExpect(content().json(getJsonContent("/responses/findProduct_notFound.json")));

        verify(mockProductService).findProduct(2L);
    }

    // toto uz je test zabezpecene funkcionality!!!
    @Test
    void deleteProduct() throws Exception {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION,"Basic dXNlcjpwYXNzd29yZA==");

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/products/3")
                .headers(httpHeaders))
                .andExpect(status().isNoContent());

        verify(mockProductService).deleteProduct(3L);
    }

    private String getJsonContent(String resource) throws IOException, URISyntaxException {
        return Files.readString(Paths.get(getClass().getResource(resource).toURI()));
    }
}