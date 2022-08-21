package cz.petrpribil.ita.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Order extends AbstractEntity {
        public enum Status {
        NEW,
        COMPLETED,
        CANCELLED
        }
        @Enumerated(EnumType.STRING)
        private Status status;
}
