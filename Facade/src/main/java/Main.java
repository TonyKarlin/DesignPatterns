import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Facade facade = new ApiFacade();

        try {
            Map<String, String> namesInfo = facade.getAttributeValueFromJson("https://api.agify.io/?name=tony", "name");
            Map<String, String> currencyInfo = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates");
            System.out.println(namesInfo);
            currencyInfo.forEach((currency, rate) ->
                    System.out.println(currency + ": " + rate));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
