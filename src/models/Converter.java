package models;

public class Converter {
    private String origin;
    private String destiny;
    private String result;
    private String value;

    public Converter(ConverterExchangeRateApi apiConverter, String value) {
        this.origin = apiConverter.base_code();
        this.destiny = apiConverter.target_code();
        this.result = apiConverter.conversion_result();
        this.value =  value;
    }

    @Override
    public String toString() {

        double value = 0;
        try {
            value = Double.valueOf(getValue());
        } catch (Exception ignored) {}

        double result = 0;
        try {
            result = Double.valueOf(getResult());
        } catch (Exception ignored) {}

        String message = """
                Valor %.2f [%s] corresponde ao valor final %.2f [%s]"""
                .formatted(value, getOrigin(), result, getDestiny());

        if (getOrigin() != null && getDestiny() != null) {
            return message;
        } else {
            return "";
        }
    }

    private String getOrigin() { return this.origin; }
    private String getDestiny() { return this.destiny; }
    private String getResult() { return this.result; }
    private String getValue() { return this.value; }

}
