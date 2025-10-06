import java.util.Map;

public class CurrencyConversionClient {
    private final Facade api;
    private final String url;
    private String attribute;


    public CurrencyConversionClient() {
        this.api = new ApiFacade();
        this.url = "https://api.fxratesapi.com/latest";
        this.attribute = "rates";
    }

    public CurrencyConversionClient(String attribute) {
        this.api = new ApiFacade();
        this.url = "https://api.fxratesapi.com/latest";
        this.attribute = attribute;
    }

    public Map<String, Double> getCurrencyByAbbreviation(String abbreviation) {
        try {
            Map<String, String> currencies = api.getAttributeValueFromJson(url, attribute);
            System.out.println(getWholeUrl());
            if (currencies == null) {
                throw new IllegalArgumentException("Currencies could not be fetched with given url: " + getWholeUrl());
            }

            if (currencies.containsKey(abbreviation.toUpperCase())) {
                double result = Double.parseDouble(currencies.get(abbreviation.toUpperCase()));
                printInfo(abbreviation, result);
                return Map.of(abbreviation, result);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Couldn't fetch from API: " + e);
        }
        return null;
    }

    private String addAttributeToApi(String attribute) {
        return this.url + "?" + attribute;
    }

    private String getWholeUrl() {
        return this.url + "?" + attribute;
    }

    private void printInfo(String currency, double course) {
        System.out.println("Course of " + currency.toUpperCase() + " in comparison to USD: " + course);
    }

    private Facade getApi() {
        return api;
    }

    public String getUrl() {
        return url;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
