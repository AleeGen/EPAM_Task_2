package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class CandiesDomBuilderTest {
    public static final String pathXml = "C:\\Users\\user\\IdeaProjects\\SecondTaskEPAM\\src\\main\\resources\\candies.xml";

    @DataProvider(name = "true_candy")
    public Object[][] createData() {
        Object[][] data = new Object[16][];
        return data;
    }

    @Test(dataProvider = "true_candy")
    public void testBuildSetCandies(Set<AbstractCandy> expected) {
        AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder("dom");
        builder.buildSetCandies(pathXml);
        assertEquals(builder.getCandies(), expected,"not equals");
    }
}