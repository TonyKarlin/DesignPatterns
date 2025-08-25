import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLBuilder {
    private Document document;
    private Element root;

    public void setRoot(Element root) {
        this.root = root;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public Element getRoot() {
        return root;
    }

    public void createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        setDocument(builder.newDocument());
        setRoot(document.createElement("root"));

        document.appendChild(root);
    }

    public Node addElement(String name, String contents, Node parent) {
        Node node;
        if (parent == null) {
            node = document.createElement(name);
            node.appendChild(document.createTextNode(contents));
            return root.appendChild(node);
        }

        if (document != null) {
            node = document.createElement(name);
            node.appendChild(document.createTextNode(contents));
            return parent.appendChild(node);
        } else return null;
    }

    public void writeToXML(String path) throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(path);
        transformer.transform(source, result);
    }
}
