package by.training.candies.validator;

import by.training.candies.exception.CustomExceptionHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validation {


    public boolean valid(String pathXsd, String pathXml) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(pathXsd);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(pathXml);
            validator.setErrorHandler(new CustomExceptionHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(pathXml + " is not correct or valid");
        }
        return false;
    }

}
