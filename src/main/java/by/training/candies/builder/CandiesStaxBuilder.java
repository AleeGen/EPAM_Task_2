package by.training.candies.builder;


import by.training.candies.entity.AbstractCandy;
import by.training.candies.entity.CandiesXmlTag;
import by.training.candies.entity.ChocolateCandy;
import by.training.candies.entity.GlazedCandy;
import by.training.candies.exception.CustomException;
import by.training.candies.parameters.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class CandiesStaxBuilder extends AbstractBuilderCandies {
    private static Logger logger = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public CandiesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        candies = new HashSet<AbstractCandy>();
    }

    public CandiesStaxBuilder(Set<AbstractCandy> candies) {
        super(candies);
    }

    @Override
    public void buildSetCandies(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandiesXmlTag.CHOCOLATE_CANDY.getValue()) || name.equals(CandiesXmlTag.GLAZED_CANDY.getValue())) {
                        AbstractCandy candy = buildCandies(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.log(Level.ERROR, "{} file problems", filename, e);
            e.printStackTrace();
        } catch (IOException e) {
            logger.log(Level.ERROR, "Problems with threads", e);
            e.printStackTrace();
        }
    }

    private AbstractCandy buildCandies(XMLStreamReader reader) throws XMLStreamException {
        AbstractCandy candy = null;
        if (reader.getLocalName().equals(CandiesXmlTag.GLAZED_CANDY.getValue())) {
            candy = new GlazedCandy();
            String filling = reader.getAttributeValue(null, CandiesXmlTag.FILLING.getValue());
            ((GlazedCandy) candy).setFilling(Filling.getType(filling));
            String type_glazed = reader.getAttributeValue(null, CandiesXmlTag.TYPE_GLAZED.getValue());
            if (type_glazed == null) {
                type_glazed = "";
            }
            ((GlazedCandy) candy).setTypeGlazed(TypeGlazed.getType(type_glazed));
        } else if (reader.getLocalName().equals(CandiesXmlTag.CHOCOLATE_CANDY.getValue())) {
            candy = new ChocolateCandy();
            String type_chocolate = reader.getAttributeValue(null, CandiesXmlTag.TYPE_CHOCOLATE.getValue());
            ((ChocolateCandy) candy).setTypeChocolate(TypeChocolate.getType(type_chocolate));
            String form = reader.getAttributeValue(null, CandiesXmlTag.FORM.getValue());
            if (form == null) {
                form = "";
            }
            ((ChocolateCandy) candy).setForm(Form.getForm(form));
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                        case ID -> candy.setId(getXMLText(reader));
                        case NAME -> candy.setName(getXMLText(reader));
                        case DATE_MANUFACTURE -> candy.setDateManufacture(LocalDate.parse(getXMLText(reader)));
                        case DATE_EXPIRATION -> candy.setDateExpiration(LocalDate.parse(getXMLText(reader)));
                        case PRODUCTION -> candy.setProduction(Production.getTypeProduction(getXMLText(reader)));
                        case INGREDIENT -> candy.getIngredients().add(Ingredients.getIngredients(getXMLText(reader)));
                        case VALUE -> candy.setValue(getXMLValue(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.CHOCOLATE_CANDY || CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.GLAZED_CANDY) {
                        return candy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <chocolate/glazed_candy>");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandiesXmlTag.valueOf(name.toUpperCase())) {
                        case PROTEINS -> value.setProteins(Integer.parseInt(getXMLText(reader)));
                        case FATS -> value.setFats(Integer.parseInt(getXMLText(reader)));
                        case CARBOHYDRATES -> value.setCarbohydrates(Integer.parseInt(getXMLText(reader)));
                        case ENERGY -> value.setEnergy(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandiesXmlTag.valueOf(name.toUpperCase()) == CandiesXmlTag.VALUE) {
                        return value;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
