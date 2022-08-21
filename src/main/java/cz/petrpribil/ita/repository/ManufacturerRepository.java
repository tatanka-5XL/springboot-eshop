package cz.petrpribil.ita.repository;

import cz.petrpribil.ita.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}

