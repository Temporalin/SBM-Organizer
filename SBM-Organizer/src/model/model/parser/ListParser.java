package model.model.parser;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 9:25 PM
 */
public class ListParser<T> extends Parser<List<T>> {
    private final Parser<T> childParser;
    private final String childKey;

    public ListParser(final Parser<T> childParser, final String childKey) {
        this.childParser = childParser;
        this.childKey = childKey;
    }

    @Override
    protected List<T> parse(final XMLStreamReader xmlReader) {
        final List<T> children = new ArrayList<>();

        try {
            while(xmlReader.hasNext()) {
                final int event = xmlReader.next();
                switch(event) {
                    case XMLStreamReader.START_ELEMENT:
                        if(childKey.equalsIgnoreCase(xmlReader.getLocalName())) {
                            children.add(childParser.parse(xmlReader));
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        return children;
                }
            }
        } catch(XMLStreamException e) {
            throw new RuntimeException(e);
        }
        throw new IllegalArgumentException("Couldn't parse List of " + childKey + " from xml");
    }
}
