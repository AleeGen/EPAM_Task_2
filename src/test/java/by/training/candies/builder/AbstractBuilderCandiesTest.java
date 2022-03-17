package by.training.candies.builder;

import by.training.candies.entity.*;
import by.training.candies.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

public class AbstractBuilderCandiesTest {
    private static final Logger logger = LogManager.getLogger();
    public static final String pathXml = ClassLoader.getSystemResource("candies_test.xml").getPath();
    Set<AbstractCandy> expected = new HashSet<>();

    {
        expected.add(new GlazedCandy(
                "g1",
                "candy1",
                Production.IDEAL,
                new HashSet<>(Arrays.asList(Ingredient.FRUCTOSE, Ingredient.BUTTER)),
                new Value(3, 2, 13, 18),
                LocalDate.parse("2022-01-01"),
                LocalDate.parse("2022-02-07"),
                TypeGlazed.CARAMEL,
                Filling.FONDANT));

        expected.add(new ChocolateCandy(
                "c1",
                "candy2",
                Production.SPARTAK,
                new HashSet<>(Arrays.asList(Ingredient.FRUCTOSE, Ingredient.MILK, Ingredient.FLOUR)),
                new Value(1, 2, 8, 15),
                LocalDate.parse("2022-03-02"),
                LocalDate.parse("2022-06-13"),
                TypeChocolate.BITTER,
                Form.FREE));

        expected.add(new ChocolateCandy(
                "c2",
                "candy3",
                Production.VESTA,
                new HashSet<>(Arrays.asList(Ingredient.SALT, Ingredient.SUGAR, Ingredient.WATER)),
                new Value(2, 5, 14, 25),
                LocalDate.parse("2022-04-22"),
                LocalDate.parse("2022-12-12"),
                TypeChocolate.WHITE,
                Form.RELIEF));

        expected.add(new GlazedCandy(
                "g2",
                "candy4",
                Production.KOMMUNARKA,
                new HashSet<>(Arrays.asList(Ingredient.STARCH)),
                new Value(5, 1, 6, 9),
                LocalDate.parse("2022-10-09"),
                LocalDate.parse("2022-12-17"),
                TypeGlazed.MISSING,
                Filling.WITH_PRALINE));
    }

    @Test
    public void testDomBuildSetCandies() {
        try {
            AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder("dom");
            builder.buildSetCandies(pathXml);
            assertEquals(builder.getCandies(), expected, "Fail");
        } catch (CustomException e) {
            logger.log(Level.ERROR, e);
            e.printStackTrace();
        }
    }

    @Test
    public void testSaxBuildSetCandies() {
        try {
            AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder("sax");
            builder.buildSetCandies(pathXml);
            assertEquals(builder.getCandies(), expected, "Fail");
        } catch (CustomException e) {
            logger.log(Level.ERROR, e);
            e.printStackTrace();
        }
    }

    @Test
    public void testStaxBuildSetCandies() {
        try {
            AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder("stax");
            builder.buildSetCandies(pathXml);
            assertEquals(builder.getCandies(), expected, "Fail");
        } catch (CustomException e) {
            logger.log(Level.ERROR, e);
            e.printStackTrace();
        }
    }

}