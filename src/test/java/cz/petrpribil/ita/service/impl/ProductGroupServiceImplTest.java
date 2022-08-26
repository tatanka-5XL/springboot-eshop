package cz.petrpribil.ita.service.impl;

import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.mapper.ProductGroupMapper;
import cz.petrpribil.ita.model.ProductGroupDto;
import cz.petrpribil.ita.repository.ProductGroupRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static cz.petrpribil.ita.mother.ProductGroupMother.getTestProductGroup;
import static cz.petrpribil.ita.mother.ProductGroupMother.getTestProductGroupDto;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductGroupServiceImplTest implements WithAssertions {

    @InjectMocks
    private ProductGroupServiceImpl productGroupServiceImpl;
    @Mock
    private ProductGroupRepository mockProductGroupRepository;
    @Mock
    private ProductGroupMapper mockProductGroupMapper;


    @Test
    void testFindAll(){
        ProductGroup testProductGroup1 = getTestProductGroup();
        ProductGroup testProductGroup2 = getTestProductGroup();
        ProductGroupDto testProductGroupDto1 = getTestProductGroupDto();
        ProductGroupDto testProductGroupDto2 = getTestProductGroupDto();

        when(mockProductGroupRepository.findAll()).thenReturn(List.of(testProductGroup1, testProductGroup2));

        when(mockProductGroupMapper.toDto(testProductGroup1)).thenReturn(testProductGroupDto1);
        when(mockProductGroupMapper.toDto(testProductGroup2)).thenReturn(testProductGroupDto2);

        Collection<ProductGroupDto> resultToApi = productGroupServiceImpl.findAll();

        assertThat(resultToApi).hasSize(2);
        assertThat(resultToApi).contains(testProductGroupDto1, testProductGroupDto2);

        verify(mockProductGroupRepository).findAll();
        verify(mockProductGroupMapper).toDto(testProductGroup1);
        verify(mockProductGroupMapper).toDto(testProductGroup2);

    }
}


/*

    @Test
    void testFindProductGroup() {
        ProductGroup testProductGroup = getTestProductGroup();
        ProductGroupDto expectedResult = getTestProductGroupDto();

        when(mockProductGroupRepository.findById(100L))
                .thenReturn(Optional.of(testProductGroup));
        when(mockProductGroupMapper.toDto(testProductGroup))
                .thenReturn((expectedResult));

        ProductGroupDto result = productGroupServiceImpl.findProductGroup(100L);

        assertThat(result).isEqualTo(expectedResult);

        verify(mockProductGroupRepository).findById(100L);
        verify(mockProductGroupMapper).toDto(testProductGroup);

    }
 */