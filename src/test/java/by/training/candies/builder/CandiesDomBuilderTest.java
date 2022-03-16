package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CandiesDomBuilderTest {
    public static final String pathXml = "C:\\Users\\user\\IdeaProjects\\SecondTaskEPAM\\src\\main\\resources\\candies.xml";

    @DataProvider(name = "true_candy")
    public Object[][] createData() {
        Object[][] data = new Object[16][];
        return data;
    }

    @Test(dataProvider = "true_candy")
    public void testBuildSetCandies(AbstractCandy candy) {
        AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder("dom");
        builder.buildSetCandies(pathXml);
        for (var i : builder.getCandies()) {
            System.out.println(i);
        }
    }
}