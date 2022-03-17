package by.training.candies.entity;

public enum CandiesXmlTag {
    CANDIES("candies"),
    CHOCOLATE_CANDY("chocolate_candy"),
    GLAZED_CANDY("glazed_candy"),

    TYPE_CHOCOLATE("type_chocolate"),
    FORM("form"),

    FILLING("filling"),
    TYPE_GLAZED("type_glazed"),

    ID("id"),
    NAME("name"),
    DATE_MANUFACTURE("date_manufacture"),
    DATE_EXPIRATION("date_expiration"),
    PRODUCTION("production"),
    INGREDIENT("ingredient"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    ENERGY("energy"),

    VALUE("value");

    private final String value;

    CandiesXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
