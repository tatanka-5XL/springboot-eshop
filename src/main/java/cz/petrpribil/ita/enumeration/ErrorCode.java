package cz.petrpribil.ita.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    GENERIC_ERROR("0000"),
    PRODUCT_NOT_FOUND("0001"),
    ARGUMENTS_NOT_VALID("0002"),
    MANUFACTURER_NOT_FOUND("0003"),
    ORDER_NOT_FOUND("0004");

    private final String code;
}
