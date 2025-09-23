package Documents;

import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents = new HashMap<>();

    public void addDocument(Document document) {
        documents.put(document.getId(), document);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }

    public void createProtectedDocument(String id, String creationDate, String content) {
        RealDocument realDocument = new RealDocument(id, creationDate, content);
        DocumentProxy proxy = new DocumentProxy(realDocument);
        addDocument(proxy);
    }
}
