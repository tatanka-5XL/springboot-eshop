package cz.petrpribil.ita.mother;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.model.CartDto;

public class CartMother {
    private CartMother(){

    }

    public static Cart getTestCart(){
        return (Cart) new Cart()
                .setId(400L);
    }

    public static CartDto getTestCartDto(){
        return new CartDto()
                .setCartId(400L);
    }
}
