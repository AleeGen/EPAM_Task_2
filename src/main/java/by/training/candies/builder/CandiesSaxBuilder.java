package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.exception.CustomErrorHandler;
import by.training.candies.util.CandiesHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CandiesSaxBuilder extends AbstractBuilderCandies {
    private static Logger logger = LogManager.getLogger();
    private CandiesHandler handler;
    private XMLReader reader;

    public CandiesSaxBuilder() {
        handler = new CandiesHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.log(Level.ERROR, "failed to build a DocumentBuilder", e);
            e.printStackTrace();
        }
        reader.setErrorHandler(new CustomErrorHandler());
        reader.setContentHandler(handler);
    }

    public CandiesSaxBuilder(Set<AbstractCandy> candies) {
        super(candies);
    }

    @Override
    public void buildSetCandies(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            logger.log(Level.ERROR, "failed to build a DocumentBuilder", e);
            e.printStackTrace();
        }
        candies = handler.getCandies();
    }
}
