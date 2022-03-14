package by.training.candies.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void warning(SAXParseException e) throws SAXParseException{
        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
        throw e;
    }

    @Override
    public void error(SAXParseException e) throws SAXParseException{
        logger.error(getLineColumnNumber(e) + " - " + e.getMessage());
        throw e;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXParseException{
        logger.fatal(getLineColumnNumber(e) + " - " + e.getMessage());
        throw e;
    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}
