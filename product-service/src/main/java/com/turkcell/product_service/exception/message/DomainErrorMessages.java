package com.turkcell.product_service.exception.message;

import org.bouncycastle.crypto.agreement.srp.SRP6Client;

public final class DomainErrorMessages {


    private DomainErrorMessages() {
    }

    public static final String PRODUCT_NAME_CANNOT_EMPTY = "Product name cannot be null or empty";
    public static final String PRODUCT_DESCRIPTION_CANNOT_BLANK = "Product description annot be null or empty";
    public static final String PRODUCT_PRICE_NOT_NULL = "Product price cannot be null";
    public static final String PRODUCT_STOCK_NOT_NULL = "product stock not null";
    public static final String PRODUCT_ID_CANNOT_NULL = "product id cannot be null or empty";
    public static final String PRODUCT_ID_INVALID_FORMAT = "Invalid product ID format";
    public static final String STOCK_MUST_BE_POSITIVE = "The amount to be withdrawn must be positive.";
    public static final String STOCK_CANNOT_BE_NEGATIVE = "The desired amount cannot be negative.";
    public static final String INSUFFICIENT_STOCK = "Insufficient stock ";
    public static final String PERCENTAGE_CANNOT_BE_NEGATIVE = "A percentage expression cannot be negative.";
    public static final String CURRENCY_CODE_NULL_OR_EMPTY = "The currency code cannot be null or empty.";
    public static final String CURRENCY_NAME_NULL_OR_EMPTY = "The currency name cannot be null or empty.";
    public static final String CURRENCY_SYMBOL_NULL_OR_EMPTY = "The currency symbol cannot be null or empty.";
    public static final String UNSUPPORTED_CURRENCY = "Unsupported currency";
    public static final String PRODUCT_CURRENCY_NOT_NULL = "Currency price cannot be null";
    public static final String PRICE_MUST_BE_POSITIVE = "Price must be positive.";
    public static final String PRODUCT_CURRENCY_DIFFERENT_CANNOT_COMPARED = "Prices in different currencies cannot be compared.";


}
