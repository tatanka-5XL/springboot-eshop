package cz.petrpribil.ita.mother;

import cz.petrpribil.ita.domain.ProductGroup;
import cz.petrpribil.ita.model.ProductGroupDto;

public final class ProductGroupMother {
    private ProductGroupMother(){

    }
    public static ProductGroup getTestProductGroup(){
        return (ProductGroup) new ProductGroup()
                .setName("Strava")
                .setDescription("Jidlo, piti, nadobi")
                .setId(100L);
    }

    public static ProductGroupDto getTestProductGroupDto(){
        return new ProductGroupDto()
                .setName("Strava")
                .setDescription("Jidlo, piti, nadobi")
                .setId(100L);
    }

}
