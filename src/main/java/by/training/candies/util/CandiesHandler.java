package by.training.candies.util;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.entity.CandiesXmlTag;
import by.training.candies.entity.ChocolateCandy;
import by.training.candies.entity.GlazedCandy;
import by.training.candies.parameter.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandiesHandler extends DefaultHandler {
    private static final String ELEMENT_CHOCOLATE_CANDIES = "chocolate_candy";
    private static final String ELEMENT_GLAZED_CANDIES = "glazed_candy";

    private Set<AbstractCandy> candies;
    private AbstractCandy current;
    private CandiesXmlTag currentXmlTag;
    private EnumSet<CandiesXmlTag> withText;

    public CandiesHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range(CandiesXmlTag.ID, CandiesXmlTag.ENERGY);
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (qName) {
            case ELEMENT_CHOCOLATE_CANDIES:
                current = new ChocolateCandy();
                ((ChocolateCandy) current).setTypeChocolate(TypeChocolate.getType(attrs.getValue(attrs.getIndex("type_chocolate"))));
                if (attrs.getLength() == 2) {
                    ((ChocolateCandy) current).setForm(Form.getForm(attrs.getValue(attrs.getIndex("form"))));
                } else {
                    ((ChocolateCandy) current).setForm(Form.getForm(""));
                }
                break;
            case ELEMENT_GLAZED_CANDIES:
                current = new GlazedCandy();
                ((GlazedCandy) current).setFilling(Filling.getType(attrs.getValue(attrs.getIndex("filling"))));
                if (attrs.getLength() == 2) {
                    ((GlazedCandy) current).setTypeGlazed(TypeGlazed.getType(attrs.getValue(attrs.getIndex("type_glazed"))));
                } else {
                    ((GlazedCandy) current).setTypeGlazed(TypeGlazed.getType(""));
                }
                break;
            default:
                CandiesXmlTag temp = CandiesXmlTag.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentXmlTag = temp;
                }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CHOCOLATE_CANDIES.equals(qName) || ELEMENT_GLAZED_CANDIES.equals(qName)) {
            candies.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case ID -> current.setId(data);
                case NAME -> current.setName(data);
                case PRODUCTION -> current.setProduction(Production.getTypeProduction(data));
                case DATE_MANUFACTURE -> current.setDateManufacture(LocalDate.parse(data));
                case DATE_EXPIRATION -> current.setDateExpiration(LocalDate.parse(data));
                case INGREDIENT -> current.getIngredients().add(Ingredients.getIngredients(data));
                case PROTEINS -> current.getValue().setProteins(Integer.parseInt(data));
                case FATS -> current.getValue().setFats(Integer.parseInt(data));
                case CARBOHYDRATES -> current.getValue().setCarbohydrates(Integer.parseInt(data));
                case ENERGY -> current.getValue().setEnergy(Integer.parseInt(data));
                default -> throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
