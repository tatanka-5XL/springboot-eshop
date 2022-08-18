package cz.petrpribil.ita.mother;
import cz.petrpribil.ita.domain.Product;
import cz.petrpribil.ita.model.CreateProductDto;
import cz.petrpribil.ita.model.ProductDto;


public class  ProductMother {
    public static Product getTestProduct() {
        return new Product()
                .setName("Lahev")
                .setDescription("Popis_lahve")
                .setImage("url_lahve")
                .setPrice(100L)
                .setStock(5L)
                .setId(1L);
    }

    public static ProductDto getTestProductDto(){
        return new ProductDto()
                .setName("Lahev")
                .setDescription("Popis_lahve")
                .setImage("url_lahve")
                .setPrice(100L)
                .setStock(5L)
                .setId(3L);
    }

    public static CreateProductDto getTestCreateProductDto(){
        return new CreateProductDto()
                .setName("Lahev")
                .setDescription("Popis_lahve")
                .setImage("url_lahve")
                .setPrice(100L)
                .setStock(5L);
    }

}
