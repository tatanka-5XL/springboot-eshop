package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.Manufacturer;
import cz.petrpribil.ita.mapper.ManufacturerMapper;
import cz.petrpribil.ita.model.ManufacturerDto;
import cz.petrpribil.ita.repository.ManufacturerRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static cz.petrpribil.ita.mother.ManufacturerMother.getTestManufacturer;
import static cz.petrpribil.ita.mother.ManufacturerMother.getTestManufacturerDto;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManufacturerServiceImplTest implements WithAssertions {
        @InjectMocks
        private ManufacturerServiceImpl manufacturerServiceImpl;
        @Mock
        private ManufacturerRepository mockManufacturerRepository;
        @Mock
        private ManufacturerMapper mockManufacturerMapper;


        @Test
        void testFindManufacturer() {
            Manufacturer testManufacturer = getTestManufacturer();
            ManufacturerDto expectedResult = getTestManufacturerDto();

            when(mockManufacturerRepository.findById(200L))
                    .thenReturn(Optional.of(testManufacturer));
            when(mockManufacturerMapper.toDto(testManufacturer))
                    .thenReturn((expectedResult));

            ManufacturerDto result = manufacturerServiceImpl.findManufacturer(100L);

            assertThat(result).isEqualTo(expectedResult);

            verify(mockManufacturerRepository).findById(100L);
            verify(mockManufacturerMapper).toDto(testManufacturer);

        }

        @Test
        void testFindAll(){
            Manufacturer testManufacturer1 = getTestManufacturer();
            Manufacturer testManufacturer2 = getTestManufacturer();
            ManufacturerDto testManufacturerDto1 = getTestManufacturerDto();
            ManufacturerDto testManufacturerDto2 = getTestManufacturerDto();

            when(mockManufacturerRepository.findAll()).thenReturn(List.of(testManufacturer1, testManufacturer2));

            when(mockManufacturerMapper.toDto(testManufacturer1)).thenReturn(testManufacturerDto1);
            when(mockManufacturerMapper.toDto(testManufacturer2)).thenReturn(testManufacturerDto2);

            Collection<ManufacturerDto> resultToApi = manufacturerServiceImpl.findAll();

            assertThat(resultToApi).hasSize(2);
            assertThat(resultToApi).contains(testManufacturerDto1, testManufacturerDto2);

            verify(mockManufacturerRepository).findAll();
            verify(mockManufacturerMapper).toDto(testManufacturer1);
            verify(mockManufacturerMapper).toDto(testManufacturer2);

        }

}
