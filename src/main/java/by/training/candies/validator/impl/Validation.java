package by.training.candies.validator.impl;

import by.training.candies.exception.CustomErrorHandler;
import by.training.candies.validator.ChecksValidity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Validation implements ChecksValidity {
    private static Logger logger = LogManager.getLogger();

    public boolean valid(String pathXsd, String pathXml) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(pathXsd);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(pathXml);
            validator.setErrorHandler(new CustomErrorHandler());
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            logger.log(Level.ERROR, pathXml + " is not correct or valid");
        }
        return false;
    }

}













