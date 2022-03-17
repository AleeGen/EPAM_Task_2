package by.training.candies.validator.impl;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidationTest {
    public static final String pathXml = ClassLoader.getSystemResource("candies_test.xml").getPath();
    public static final String pathXsd = ClassLoader.getSystemResource("schema_test.xsd").getPath();

    @Test
    public void testValid() {
        boolean result = new Validation().valid(pathXsd, pathXml);
        assertTrue(result);
    }
}