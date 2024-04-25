package models;

public record ConverterExchangeRateApi(
        String base_code,
        String target_code,
        String conversion_result
) {
}
