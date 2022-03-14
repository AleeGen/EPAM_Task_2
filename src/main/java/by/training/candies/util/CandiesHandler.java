package by.training.candies.util;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.entity.CandiesXmlTag;
import by.training.candies.entity.ChocolateCandy;
import by.training.candies.entity.GlazedCandy;
import by.training.candies.parameters.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandiesHandler extends DefaultHandler {

    private Set<AbstractCandy> candies;
    private AbstractCandy current;
    private CandiesXmlTag currentXmlTag;
    private EnumSet<CandiesXmlTag> withText;
    private static final String ELEMENT_CHOCOLATE_CANDIES = "chocolate_candy";
    private static final String ELEMENT_GLAZED_CANDIES = "glazed_candy";

    public CandiesHandler() {
        candies = new HashSet<AbstractCandy>();
        withText = EnumSet.range(CandiesXmlTag.ID, CandiesXmlTag.ENERGY);
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (qName) {
            case ELEMENT_CHOCOLATE_CANDIES:
                current = new ChocolateCandy();
                ((ChocolateCandy) current).setTypeChocolate(TypeChocolate.getType(attrs.getValue(0)));
                if (attrs.getLength() == 2) {
                    ((ChocolateCandy) current).setForm(Form.getForm(attrs.getValue(1)));
                }
                break;
            case ELEMENT_GLAZED_CANDIES:
                current = new GlazedCandy();
                ((GlazedCandy) current).setTypeGlazed(TypeGlazed.getType(attrs.getValue(0)));
                if (attrs.getLength() == 2) {
                    ((GlazedCandy) current).setFilling(Filling.getType(attrs.getValue(1)));
                }
                break;
            default:
                CandiesXmlTag temp = CandiesXmlTag.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentXmlTag = temp;
                }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_CHOCOLATE_CANDIES.equals(qName) || ELEMENT_CHOCOLATE_CANDIES.equals(qName)) {
            candies.add(current);
        }
    }

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
