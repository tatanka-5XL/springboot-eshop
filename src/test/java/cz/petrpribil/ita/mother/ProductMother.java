package cz.petrpribil.ita.mother;
import cz.petrpribil.ita.domain.Product;
import java.util.Arrays;
import java.util.List;


public class ProductMother {

    private static final Product product1 = new Product()
            .setName("Lahev")
            .setDescription("Popis_lahve")
            .setImage("url_lahve")
            .setPrice(100L)
            .setStock(5L)
            .setId(1L);

    private static final Product product2 = new Product()
            .setName("Batoh")
            .setDescription("Popis_batohu")
            .setImage("url_batohu")
            .setPrice(2000L)
            .setStock(3L)
            .setId(2L);


    public static List<Product> getTestProducts() {
        return Arrays.asList(product1, product2);
    }

    public static Product getTestProduct() {
        return product2;
    }

}
