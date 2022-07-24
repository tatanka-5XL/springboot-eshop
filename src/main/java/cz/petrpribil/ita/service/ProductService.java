package cz.petrpribil.ita.service;

import cz.petrpribil.ita.model.ProductDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    public ProductService () {
        System.out.println("In constructor");
        this.productDtoMap = productDtoMap;
    }
    public static Map<Long, ProductDto> productDtoMap;

    @PostConstruct
    public void init(){
        ProductDto productDto1 = new ProductDto(
                "Sekera",
                "Super rychle seka, lehka a ucinna",
                "https://www.mall.cz/i/45314226/550/550",
                1500L,
                5L,
                1L
        );
        ProductDto productDto2 = new ProductDto(
                "Nuz",
                "Ostry, pevny, v lese nezklame",
                "https://cdn.myshoptet.com/usr/www.kniland.cz/user/shop/big/7071_nuz-morakniv-bushcraft-black.jpg?5dbed848",
                900L,
                10L,
                2L
        );
        ProductDto productDto3 = new ProductDto(
                "Firesteel",
                "Odted uz nebudete potrebovat zapalky ani zapalovac!",
                "https://img.cestovatelskyobchod.cz/images/JOKER/podpalovace/joker-pd04-firesteel-olive-wood.jpg",
                400L,
                20L,
                3L
        );

        productDtoMap = Stream.of(productDto1, productDto2, productDto3)
                .collect(Collectors.toMap(
                        ProductDto::getId,
                        Function.identity()
                ));

    }

    public static ProductDto findProduct(Long id) {
        return productDtoMap.get(id);
    }

    public static Collection<ProductDto> findAllProducts() {return productDtoMap.values();
    }
}
