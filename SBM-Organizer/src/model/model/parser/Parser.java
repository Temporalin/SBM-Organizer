package model.model.parser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 5:32 PM
 */
public abstract class Parser<T> {
    private final XMLInputFactory factory;

    public Parser() {
        factory = XMLInputFactory.newFactory();
    }

    public T parse(final String xml) {
        return parse(new StringReader(xml));
    }

    public T parse(final Reader reader) {
        XMLStreamReader xmlReader = null;

        try {
            xmlReader = factory.createXMLStreamReader(reader);
            return parse(xmlReader);
        } catch(XMLStreamException e) {
            throw new RuntimeException(e);
        } finally {
            cleanupReader(xmlReader);
        }
    }

    protected boolean isNotNil(final Map<String, String> attrs) {
        return !Boolean.valueOf(attrs.get("nil"));
    }

    private void cleanupReader(XMLStreamReader xmlReader) {
        try {
            if(xmlReader != null) {
                xmlReader.close();
            }
        } catch(XMLStreamException e) {
            //eat it
        }
    }

    protected abstract T parse(final XMLStreamReader reader);
}
