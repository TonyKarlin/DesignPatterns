import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Facade facade = new ApiFacade(); // Didn't want to make a new client / concrete class for the name api
        CurrencyConversionClient conversionClient = new CurrencyConversionClient();

        try {
            Map<String, String> namesInfo = facade.getAttributeValueFromJson("https://api.agify.io/?name=michael", "name");
            System.out.println(namesInfo);

            Map<String, Double> object = conversionClient.getCurrencyByAbbreviation("eur");
            System.out.println(object);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
