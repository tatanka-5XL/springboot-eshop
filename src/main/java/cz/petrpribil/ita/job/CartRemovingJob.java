package cz.petrpribil.ita.job;

import cz.petrpribil.ita.domain.Cart;
import cz.petrpribil.ita.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Slf4j
public class CartRemovingJob {


    @Scheduled(cron = "${app.job.cart-removal}")
    public class CartRemovingJob {

        public void writeSomething() {
                log.info("Jobisek");

    }
}
