package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.exception.CustomErrorHandler;
import by.training.candies.util.CandiesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class CandiesSaxBuilder {
    private static Logger logger = LogManager.getLogger();
    private Set<AbstractCandy> candies;
    private CandiesHandler handler = new CandiesHandler();
    private XMLReader reader;

    public CandiesSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new CustomErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

    public void buildSetCandies(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        candies = handler.getCandies();
    }
}
