package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Manufacturer;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
class ManufacturerRepositoryIT implements WithAssertions {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testCreateAndRetrieveManufacturer(){

        Manufacturer testManufacturer = new Manufacturer()
            .setName("Plastik s.r.o.")
            .setAbout("Vyroba z plastu pro potravinarsky prumysl");

        testEntityManager.persistAndFlush(testManufacturer);
        testEntityManager.detach(testManufacturer);

        Optional<Manufacturer> result = manufacturerRepository.findById(testManufacturer.getId());

        assertThat(result).isNotEmpty();

        Manufacturer resultManufacturer = result.get();

        assertThat(resultManufacturer.getName()).isEqualTo(testManufacturer.getName());
        assertThat(resultManufacturer.getAbout()).isEqualTo(testManufacturer.getAbout());
        assertThat(resultManufacturer.getId()).isEqualTo(testManufacturer.getId());
    }

}
