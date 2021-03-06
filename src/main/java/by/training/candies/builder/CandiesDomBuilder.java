package by.training.candies.builder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.training.candies.entity.*;
import by.training.candies.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CandiesDomBuilder extends AbstractBuilderCandies {
    private static final Logger logger = LogManager.getLogger();
    private DocumentBuilder docBuilder;

    public CandiesDomBuilder() throws CustomException {
        candies = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "failed to build a DocumentBuilder", e);
            throw new CustomException(e);
        }
    }

    public CandiesDomBuilder(Set<AbstractCandy> candies) {
        super(candies);
    }

    @Override
    public void buildSetCandies(String filename) throws CustomException {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList candiesChocolate = root.getElementsByTagName("chocolate_candy");
            NodeList candiesGlazed = root.getElementsByTagName("glazed_candy");
            if (candiesChocolate.getLength() + candiesGlazed.getLength() == 0) {
                throw new CustomException();
            }
            buildInside(candiesChocolate);
            buildInside(candiesGlazed);
        } catch (CustomException e) {
            logger.log(Level.ERROR, "{} file contains 0 candies", filename, e);
            throw e;
        } catch (IOException | SAXException e) {
            logger.log(Level.ERROR, "{} file problems", filename, e);
            throw new CustomException(e);
        }
    }

    private void buildInside(NodeList candiesList) {
        for (int i = 0; i < candiesList.getLength(); i++) {
            Element candiesElement = (Element) candiesList.item(i);
            AbstractCandy candy = buildCandies(candiesElement);
            candies.add(candy);
        }
    }

    private AbstractCandy buildCandies(Element candiesElement) {
        AbstractCandy candy = null;
        if (candiesElement.getTagName().equals("chocolate_candy")) {
            candy = new ChocolateCandy();
            ((ChocolateCandy) candy).setTypeChocolate(TypeChocolate.getType(candiesElement.getAttribute("type_chocolate")));
            ((ChocolateCandy) candy).setForm(Form.getForm(candiesElement.getAttribute("form")));
        } else if (candiesElement.getTagName().equals("glazed_candy")) {
            candy = new GlazedCandy();
            ((GlazedCandy) candy).setTypeGlazed(TypeGlazed.getType(candiesElement.getAttribute("type_glazed")));
            ((GlazedCandy) candy).setFilling(Filling.getType(candiesElement.getAttribute("filling")));
        }
        if (candy != null) {
            candy.setId(getElementTextContent(candiesElement, "id"));
            candy.setName(getElementTextContent(candiesElement, "name"));
            candy.setDateManufacture(LocalDate.parse(getElementTextContent(candiesElement, "date_manufacture")));
            candy.setDateExpiration(LocalDate.parse(getElementTextContent(candiesElement, "date_expiration")));
            candy.setProduction(Production.getTypeProduction(getElementTextContent(candiesElement, "production")));
            NodeList ingredientList = candiesElement.getElementsByTagName("ingredient");
            int countTeg = ingredientList.getLength();
            for (int i = 0; i < countTeg; i++) {
                String ingredient = ingredientList.item(i).getTextContent();
                candy.getIngredients().add(Ingredient.getIngredients(ingredient));
            }
            Value value = candy.getValue();
            Element valueElement = (Element) candiesElement.getElementsByTagName("value").item(0);
            value.setProteins(Integer.parseInt(getElementTextContent(valueElement, "proteins")));
            value.setFats(Integer.parseInt(getElementTextContent(valueElement, "fats")));
            value.setCarbohydrates(Integer.parseInt(getElementTextContent(valueElement, "carbohydrates")));
            value.setEnergy(Integer.parseInt(getElementTextContent(valueElement, "energy")));
        }
        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }

}
