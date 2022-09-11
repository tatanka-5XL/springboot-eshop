package cz.petrpribil.ita.job;

import cz.petrpribil.ita.service.CartService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Component
@Slf4j
public class CartRemovingJob {

    private static CartService cartService;

    @Scheduled(cron = "${app.job.cart-removal.cron}")
    public static void main (String[] args) {
        log.debug("Removing unused carts...");
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime timeStamp = localDateTimeNow.minus(10, ChronoUnit.MINUTES);
        cartService.deleteCartsByModifiedAtBefore(timeStamp);
        log.debug("Unused carts removed");
    }
}

