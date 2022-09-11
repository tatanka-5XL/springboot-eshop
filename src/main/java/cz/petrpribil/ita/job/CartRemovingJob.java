package cz.petrpribil.ita.job;

import cz.petrpribil.ita.service.CartService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class CartRemovingJob {

    private static CartService cartService;

    @Scheduled(cron = "${app.job.cart-removal.cron}")
    public static void main (String[] args) {
        log.debug("Removing unused carts...");
        cartService.deleteCartsByModifiedAtBefore();
        log.debug("Unused carts removed");
    }
}

