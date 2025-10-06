import java.util.Map;

public interface Facade {
    Map<String, String> getAttributeValueFromJson(String urlString,
                                  String attributeName)
            throws Exception;
}
