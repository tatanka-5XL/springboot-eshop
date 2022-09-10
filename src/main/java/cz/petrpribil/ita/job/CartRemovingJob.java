package cz.petrpribil.ita.job;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@Slf4j
public class CartRemovingJob {

    private CartRepository cartRepository;

    @Scheduled(cron="${app.job.cart-removal}")
    public void removeUnusedCarts() {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime timeToRemoveBefore = dateTimeNow.minus(10, ChronoUnit.MINUTES);
        List<Cart> oldCarts = cartRepository.findCartsByModifiedAtBefore(timeToRemoveBefore);
        cartRepository.deleteAllInBatch(oldCarts);
    }
}

