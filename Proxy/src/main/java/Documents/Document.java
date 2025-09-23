package Documents;

public interface Document {
    String getId();
    String getCreationDate();
    String getContent(String user);
}
