package cz.petrpribil.ita.rest;

import cz.petrpribil.ita.model.ProductGroupDto;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// SpringContext vs Tomcat - viz Slide
// toto je kompletni integracni test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductGroupControllerIT implements WithAssertions {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void findAll(){
        ResponseEntity<ProductGroupDto[]> response = testRestTemplate.getForEntity("/api/v1/genres", ProductGroupDto[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        ProductGroupDto[] body = response.getBody();

        assertThat(body).hasSize(3);
    }
}