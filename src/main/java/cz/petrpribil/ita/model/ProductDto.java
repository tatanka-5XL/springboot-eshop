package cz.petrpribil.ita.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long stock;
    private Long id;

    @Override
    public String toString(){
        return  "Id {" +
                id + "} " +
                name + " - " +
                description + " (" +
                image + "): price [" +
                price + "] stock [" +
                stock + "]";
     }
}