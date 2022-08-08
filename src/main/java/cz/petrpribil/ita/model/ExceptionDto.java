package cz.petrpribil.ita.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExceptionDto {
    private final String message;
    private final String code;

}
