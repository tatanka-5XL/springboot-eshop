package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Order extends AbstractEntity {
//    private enum statuses {
//        NEW,
//        COMPLETED,
//        CANCELLED
//        }
        private String status;
}
