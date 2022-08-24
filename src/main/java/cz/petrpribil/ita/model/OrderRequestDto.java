package cz.petrpribil.ita.model;

import cz.petrpribil.ita.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    public enum Status {
        NEW,
        COMPLETED,
        CANCELLED
    }
    private Status status;
    private List<Product> products;
}
