package com.turkcell.product_service.domain.valueobjects;

import com.turkcell.product_service.core.exception.DomainException;
import com.turkcell.product_service.core.exception.message.DomainErrorMessages;

import java.util.Objects;

public final class Currency {
    private final String code;
    private final String name;
    private final String symbol;
    public static final Currency TRY = new Currency("TRY", "Türk Lirası", "₺");
    public static final Currency USD = new Currency("USD", "Amerikan Doları", "$");
    public static final Currency EUR = new Currency("EUR", "Euro", "€");
    public static final Currency GBP = new Currency("GBP", "İngiliz Sterlini", "£");
    public Currency(String code, String name, String symbol) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException(DomainErrorMessages.CURRENCY_CODE_NULL_OR_EMPTY);
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(DomainErrorMessages.CURRENCY_NAME_NULL_OR_EMPTY);
        }
        if (symbol == null || symbol.trim().isEmpty()) {
            throw new IllegalArgumentException(DomainErrorMessages.CURRENCY_SYMBOL_NULL_OR_EMPTY);
        }

        this.code = code.toUpperCase().trim();
        this.name = name.trim();
        this.symbol = symbol.trim();
    }
    public static Currency fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new DomainException(DomainErrorMessages.CURRENCY_CODE_NULL_OR_EMPTY);
        }
        String upperCode = code.toUpperCase().trim();
        return switch (upperCode) {
            case "TRY" -> TRY;
            case "USD" -> USD;
            case "EUR" -> EUR;
            case "GBP" -> GBP;
            default -> throw new DomainException(DomainErrorMessages.UNSUPPORTED_CURRENCY);
        };
    }
    public static boolean isSupported(String code) {
        if (code == null || code.trim().isEmpty()) {
            return false;
        }

        String upperCode = code.toUpperCase().trim();
        return upperCode.equals("TRY") || upperCode.equals("USD") ||
                upperCode.equals("EUR") || upperCode.equals("GBP");
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code) && Objects.equals(name, currency.name) && Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, symbol);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
