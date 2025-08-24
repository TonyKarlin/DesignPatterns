import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLBuilder {

    public Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.newDocument();
    }

    public Node addElement(String name, String contents, Node parent, Document document) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent node cannot be null");
        }

        Node node = document.createElement(name);
        node.appendChild(document.createTextNode(contents));
        return parent.appendChild(node);
    }

    public void writeToXML(String path, Document document) throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(path);
        transformer.transform(source, result);
    }
}
