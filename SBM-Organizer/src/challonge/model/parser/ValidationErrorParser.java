package challonge.model.parser;

import challonge.model.ValidationErrorException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/13/13
 *         Time: 11:50 PM
 */
public class ValidationErrorParser extends Parser<ValidationErrorException> {
    protected ValidationErrorException parse(final XMLStreamReader xmlReader) {
        final List<String> validationErrors = new ArrayList<>();

        try {
            while(xmlReader.hasNext()) {
                final int event = xmlReader.next();
                switch(event) {
                    case XMLStreamReader.START_ELEMENT:
                        if("error".equalsIgnoreCase(xmlReader.getLocalName())) {
                            validationErrors.add(xmlReader.getElementText());
                        }
                        break;
                }
            }
        } catch(XMLStreamException e) {
            throw new RuntimeException(e);
        }

        return new ValidationErrorException(validationErrors);
    }
}
