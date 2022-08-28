package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.ProductGroup;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class ProductGroupRepositoryIT implements WithAssertions {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateAndRetrieveProductGroup(){
        ProductGroup testProductGroup = new ProductGroup()
                .setName("Vareni")
                .setDescription("Jidlo, piti , nadobi");

        testEntityManager.persistAndFlush(testProductGroup);
        testEntityManager.detach(testProductGroup);

        Optional<ProductGroup> result = productGroupRepository.findById(testProductGroup.getId());

        assertThat(result).isNotEmpty();

        ProductGroup resultProductGroup = result.get();

        assertThat(resultProductGroup.getName()).isEqualTo(testProductGroup.getName());
        assertThat(resultProductGroup.getDescription()).isEqualTo(testProductGroup.getDescription());
        assertThat(resultProductGroup.getId()).isEqualTo(testProductGroup.getId());
    }

}
